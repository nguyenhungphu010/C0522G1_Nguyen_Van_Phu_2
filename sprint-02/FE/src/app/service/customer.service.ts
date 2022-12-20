import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {SearchResult} from '../model/search-result';
import {Books} from '../model/books';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  API_URL_CUSTOMER: string;

  constructor(private httpClient: HttpClient) {
    this.API_URL_CUSTOMER = environment.api_url;
  }

  paginate(page: number, limit: number, searchName: string, searchAddress: string): Observable<SearchResult<Books>> {
    return this.httpClient.get<SearchResult<Books>>(this.API_URL_CUSTOMER + 'customer/list?page=' + (page - 1) + '&size=' + limit + '&name='
      + searchName + '&address=' + searchAddress);
  }

  getCustomerById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.API_URL_CUSTOMER + 'customer/' + id);
  }

  deleteCustomerById(id: number): Observable<void> {
    return this.httpClient.delete<void>(this.API_URL_CUSTOMER + 'customer/delete/' + id);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_URL_CUSTOMER + 'customer/save', customer);
  }
}
