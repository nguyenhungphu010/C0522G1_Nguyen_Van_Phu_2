import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent} from '@angular/common/http';
import {TokenStorageService} from './token-storage.service';
import {AuthService} from './auth.service';
import {environment} from '../../environments/environment';
import {Order} from '../model/order';
import {Observable} from 'rxjs';
import {Cart} from '../model/cart';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  URL_ORDER: string;
  httpOption: any;

  constructor(private httpClient: HttpClient,
              private tokenStorageService: TokenStorageService,
              private authenticationService: AuthService) {
    this.URL_ORDER = environment.api_url;
    this.httpOption = this.authenticationService.getHttpOption();
  }

  creatOrder(order: Order) {
    return this.httpClient.post(this.URL_ORDER + 'order/save', order, this.httpOption).pipe();
  }

  getAllOrder(): Observable<Order[]> {
    // @ts-ignore
    return this.httpClient.get<Order[]>(this.URL_ORDER + 'order/list', this.httpOption);
  }

  getMaxOrderId(): Observable<number> {
    // @ts-ignore
    return this.httpClient.get<number>(this.URL_ORDER + 'order/max-id', this.httpOption);
  }

}
