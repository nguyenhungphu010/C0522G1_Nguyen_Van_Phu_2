import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {TokenStorageService} from '../../service/token-storage.service';
import {AuthService} from '../../service/auth.service';
import {ShareService} from '../../service/share.service';
import Swal from 'sweetalert2';
import {LoginResponse} from '../../model/login-response';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formGroup: FormGroup;
  username: string;
  roles: string[];
  returnUrl: string;
  loginResponse: LoginResponse;

  constructor(private formBuild: FormBuilder,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private authService: AuthService,
              private activeRoute: ActivatedRoute,
              private shareService: ShareService,
  ) {
  }

  ngOnInit(): void {
    this.returnUrl = this.activeRoute.snapshot.queryParams.returnUrl || '/home/list';
    this.formGroup = this.formBuild.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      remember_me: ['']
    });
    if (this.tokenStorageService.getToken_2()) {
      // const user = this.tokenStorageService.getUser();
      this.authService.isLoggedIn = true;
      // this.roles = this.tokenStorageService.getRoles();
      this.username = this.tokenStorageService.getUsername();
    }
  }

  onSubmit() {
    console.log(this.returnUrl);
    this.authService.login(this.formGroup.value).subscribe(value => {
        this.loginResponse = value;
        console.log(value);
        if (this.formGroup.value.remember_me) {
          // this.tokenStorageService.saveTokenLocal(value.accessToken);
          this.tokenStorageService.localStorageSave(value);
        } else {
          this.tokenStorageService.sessionStorageSave(value);
        }
        this.authService.isLoggedIn = true;
        this.username = this.tokenStorageService.getUsername();
        this.roles = this.loginResponse.roles;
        console.log(this.roles);
        this.formGroup.reset();
        this.router.navigateByUrl(this.returnUrl);
        // this.shareService.
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: this.username + ' Đăng nhập thành công !',
          showConfirmButton: false,
          timer: 2000
        });
        this.shareService.sendClickEvent();
        window.location.replace('');
      },
      err => {
        this.authService.isLoggedIn = false;
        Swal.fire({
          position: 'center',
          icon: 'warning',
          title: 'Người dùng/ mật khẩu không hợp lệ. Vui lòng thử lại!',
          showConfirmButton: false,
          timer: 2000
        });
      });
  }

  whenExit() {
    this.tokenStorageService.signOut();
    this.username = '';
    this.router.navigateByUrl('');
  }
}
