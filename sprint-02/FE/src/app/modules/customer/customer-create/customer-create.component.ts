import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../../service/customer.service';
import {Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {Customer} from '../../../model/customer';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../../../dto/user';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  user = new User();
  customer: Customer;
  submitCheck = false;

  constructor(private customerService: CustomerService,
              private route: Router,
              private title: Title) {
    this.title.setTitle('Create new Customer');
  }

  formCreateCustomer: FormGroup = new FormGroup({
    // tslint:disable-next-line:max-line-length
    name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z _ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀ' +
      // tslint:disable-next-line:max-line-length
      'ỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+'), Validators.minLength(4), Validators.maxLength(32)]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern('(0|[(]84[)][+])9\\d{8}')]),
    dayOfBirth: new FormControl('', [Validators.required, this.checkAge]),
    gender: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email, Validators.minLength(12), Validators.maxLength(32)]),
    address: new FormControl('', [Validators.required,
      Validators.minLength(3), Validators.maxLength(32)]),
    username: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(32)]),
    passwordGroup: new FormGroup({
      password: new FormControl('', [Validators.required, Validators.minLength(6), Validators.maxLength(32)]),
      passwordConfirm: new FormControl('', [Validators.required])
    }, this.checkPassword)
  });


  ngOnInit(): void {

  }


  saveCustomer(): void {
    this.submitCheck = true;
    this.customer = this.formCreateCustomer.value;
    this.user.username = this.formCreateCustomer.value.username;
    this.user.password = this.formCreateCustomer.get('passwordGroup.password').value;
    this.customer.user = this.user;
    this.customerService.saveCustomer(this.customer).subscribe(value => {
        Swal.fire({
          icon: 'success',
          title: 'Add new Successfully!',
          text: 'Customer: ' + this.customer.name,
        });
      }, error => {
        console.log(error);
      },
      () => {
      this.route.navigateByUrl('customer/list');

      });
  }

  checkAge(abstractControl: AbstractControl): any {
    const formYear = Number(abstractControl.value.substr(0, 4));
    const curYear = new Date().getFullYear();
    return (curYear - formYear >= 18 && curYear - formYear <= 80) ? null : {invalid18: true};
  }

  checkPassword(abstractControl: AbstractControl): any {
    const checkPass = abstractControl.value;
    return checkPass.password === checkPass.passwordConfirm ? null : {notSame: true};
  }
}
