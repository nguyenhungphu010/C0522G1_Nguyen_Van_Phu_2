import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {TokenStorageService} from '../../service/token-storage.service';
import {AuthService} from '../../service/auth.service';
import {ShareService} from '../../service/share.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formGroup: FormGroup;
  username: string;
  roles: string[] = [];
  returnUrl: string;

  constructor(private formBuild: FormBuilder,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private authService: AuthService,
              private activeRoute: ActivatedRoute,
              private shareService: ShareService,
  ) {
  }

  ngOnInit(): void {
    this.returnUrl = this.activeRoute.snapshot.queryParams.returnUrl || '';
    this.formGroup = this.formBuild.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      remember_me: ['']
    });
    if (this.tokenStorageService.getToken()) {
      const user = this.tokenStorageService.getUser();
      this.authService.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      this.username = this.tokenStorageService.getUser().username;
    }
  }

  onSubmit() {
    this.authService.login(this.formGroup.value).subscribe(value => {
      if (this.formGroup.value.remember_me) {
        this.tokenStorageService.saveTokenLocal(value.accessToken);
        this.tokenStorageService.saveTokenLocal(value);
      } else {
        this.tokenStorageService.saveTokenSession(value.accessToken);
        this.tokenStorageService.saveUserLocal(value);
      }
      this.authService.isLoggedIn = true;
      this.username = this.tokenStorageService.getUser().username;
      this.roles = this.tokenStorageService.getUser().roles;
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
