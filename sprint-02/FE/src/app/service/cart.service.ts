import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {TokenStorageService} from './token-storage.service';
import {AuthService} from './auth.service';
import {Observable} from 'rxjs';
import {Cart} from '../model/cart';
import {RenderParams} from 'creditcardpayments/creditCardPayments';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  URL_CART: string;
  httpOption: any;
  renderParam?: RenderParams;

  constructor(private httpClient: HttpClient,
              private tokenStorageService: TokenStorageService,
              private authenticationService: AuthService) {
    this.URL_CART = environment.api_url;
  }

  getAllCart(): Observable<Cart[]> {
    this.httpOption = this.authenticationService.getHttpOption();
    // @ts-ignore
    return this.httpClient.get<Cart[]>(this.URL_CART + 'cart?username=' + this.tokenStorageService.getUsername(), this.httpOption);
  }

  addToCart(id: number) {
    const cartItem = {
      user: {
        id: this.tokenStorageService.getId()
      },
      book: {
        id: id
      },
      order: {
        id: 1
      }
    };
    return this.httpClient.post(this.URL_CART + 'cart/save', cartItem, this.httpOption);
  }

  updateAll(carts: Cart[]) {
    return this.httpClient.post(this.URL_CART + 'cart/update-all', carts, this.httpOption);
  }

  pay(selectedCarts: Cart[]) {
    return this.httpClient.post(this.URL_CART + 'cart/pay', selectedCarts, this.httpOption);
  }

  deleteCart(id: number) {
    return this.httpClient.post(this.URL_CART + 'cart/delete/' + id, this.httpOption);
  }
}
