import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {LoginRequest} from '../model/login-request';
import {TokenStorageService} from './token-storage.service';

const AUTH_API = 'http://localhost:8080/api/public/';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  httpOptions: any;
  isLoggedIn: boolean;
  token: string;

  constructor(private http: HttpClient,
              private tokeStorageService: TokenStorageService) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  login(loginRequest: LoginRequest) {
    return this.http.post(AUTH_API + 'login', loginRequest);
  }

  getHttpOption() {
    this.token = this.tokeStorageService.getToken_2();
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer' + this.token
      })
    };
    return this.httpOptions;
  }
}
