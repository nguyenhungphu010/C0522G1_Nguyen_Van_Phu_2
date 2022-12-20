import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Books} from '../model/books';
import {SearchResult} from '../model/search-result';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private API_URL: string;

  constructor(private httpClient: HttpClient) {
    this.API_URL = environment.api_url;
  }

  findAllBook(): Observable<Books[]> {
    return this.httpClient.get<Books[]>(this.API_URL + '/home/list');
  }

  paginate(page: number, limit: number, searchName: string, searchAuthor: string): Observable<SearchResult<Books>> {
    console.log(searchName);
    return this.httpClient.get<SearchResult<Books>>(this.API_URL + 'home/list?page=' + (page - 1) + '&size=' + limit + '&name=' +
      searchName + '&author=' + searchAuthor);
  }

  getById(id: number): Observable<Books> {
    return this.httpClient.get<Books>(this.API_URL + 'home/detail/' + id);
  }

  deleteCustomerById(id: number): Observable<void> {
    return this.httpClient.delete<void>(this.API_URL + 'customer/delete/' + id);
  }
}
