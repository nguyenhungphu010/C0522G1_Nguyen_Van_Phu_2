import {Injectable} from '@angular/core';
import {LoginResponse} from '../model/login-response';

const SESSION_KEY = 'SESSION-TOKEN';
const LOCAL_KEY = 'LOCAL-TOKEN';

const TOKEN = 'TOKEN';
const USER_NAME = 'USER-NAME';
const ROLE = 'ROLE';
const IS_LOGIN = 'IS_LOGIN';
const ID = 'ID';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() {
  }

  localStorageSave(loginResponse: LoginResponse) {
    localStorage.clear();
    sessionStorage.clear();
    localStorage.setItem(TOKEN, loginResponse.accessToken);
    localStorage.setItem(USER_NAME, loginResponse.username);
    localStorage.setItem(ROLE, JSON.stringify(loginResponse.roles));
    localStorage.setItem(IS_LOGIN, loginResponse.isLogin);
    localStorage.setItem(ID, String(loginResponse.id));
  }

  sessionStorageSave(loginResponse: LoginResponse) {
    localStorage.clear();
    sessionStorage.clear();
    sessionStorage.setItem(TOKEN, loginResponse.accessToken);
    sessionStorage.setItem(USER_NAME, loginResponse.username);
    sessionStorage.setItem(ROLE, JSON.stringify(loginResponse.roles));
    sessionStorage.setItem(IS_LOGIN, loginResponse.isLogin);
    sessionStorage.setItem(ID, String(loginResponse.id));
  }

  public getToken_2() {
    if (localStorage.getItem(TOKEN) != null) {
      return localStorage.getItem(TOKEN);
    } else {
      return sessionStorage.getItem(TOKEN);
    }
  }

  getId() {
    if (localStorage.getItem(ID) != null) {
      return localStorage.getItem(ID);
    } else {
      return sessionStorage.getItem(ID);
    }
  }

  public getIsLogin() {
    if (localStorage.getItem(IS_LOGIN) != null) {
      return localStorage.getItem(IS_LOGIN);
    } else {
      return sessionStorage.getItem(IS_LOGIN);
    }
  }

  public getUsername() {
    if (localStorage.getItem(USER_NAME) != null) {
      return localStorage.getItem(USER_NAME);
    } else {
      return sessionStorage.getItem(USER_NAME);
    }
  }

  getRoles() {
    if (localStorage.getItem(ROLE) != null) {
      return localStorage.getItem(ROLE);
    } else {
      return sessionStorage.getItem(ROLE);
    }
  }

  // getUsername() {
  //   // tslint:disable-next-line:triple-equals
  //   if (localStorage.getItem(USER_NAME) != undefined) {
  //     return localStorage.getItem(USER_NAME);
  //   } else {
  //     return sessionStorage.getItem(USER_NAME);
  //   }
  // }

  signOut() {
    window.localStorage.clear();
    window.sessionStorage.clear();
  }

  public saveTokenLocal(token: string) {
    window.localStorage.removeItem(SESSION_KEY);
    window.localStorage.setItem(SESSION_KEY, token);
  }

  public saveTokenSession(token: string) {
    window.sessionStorage.removeItem(SESSION_KEY);
    window.sessionStorage.setItem(SESSION_KEY, token);
  }

  // public getToken(): string {
  //   if (localStorage.getItem(SESSION_KEY) !== null) {
  //     return localStorage.getItem(SESSION_KEY);
  //   } else {
  //     return sessionStorage.getItem(SESSION_KEY);
  //   }
  // }


  public saveUserLocal(user) {
    window.localStorage.removeItem(LOCAL_KEY);
    window.localStorage.setItem(LOCAL_KEY, JSON.stringify(user));
  }

  public saveUserSession(user) {
    window.sessionStorage.removeItem(LOCAL_KEY);
    window.sessionStorage.setItem(LOCAL_KEY, JSON.stringify(user));
  }

  public getUser() {
    if (localStorage.getItem(LOCAL_KEY) !== null) {
      return JSON.parse(localStorage.getItem(LOCAL_KEY));
    } else {
      return JSON.parse(sessionStorage.getItem(LOCAL_KEY));
    }
  }


}
