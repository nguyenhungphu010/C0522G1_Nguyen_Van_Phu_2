import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {TokenStorageService} from '../../service/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthCustomerGuard implements CanActivate {

  constructor(private router: Router,
              private tokenStorageService: TokenStorageService) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const username = this.tokenStorageService.getUsername();
    if (username !== null) {
      const role = this.tokenStorageService.getRoles();
      console.log(role);
      console.log(next.data.roles);
      for (let i = 0; i < next.data.roles; i++) {
        if (role.indexOf(next.data.roles[i]) === -1) {
          return true;
        }
      }
      return false;
    }
  }

}
