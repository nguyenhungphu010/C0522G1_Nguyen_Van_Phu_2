import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {Customer} from '../../../model/customer';
import {FormControl, FormGroup} from '@angular/forms';
import {User} from '../../../model/user';
import {CustomerService} from '../../../service/customer.service';
import {Title} from '@angular/platform-browser';
import {ActivatedRoute} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  page = 1;
  pageSize = 5;

  total$: Observable<number>;
  nameSearch = '';
  addressSearch = '';

  action: boolean;

  customerList: Customer[];
  customerId: number;
  deleteName: string;
  customer: Customer;


  constructor(private customerService: CustomerService,
              private title: Title,
              private activeRoute: ActivatedRoute) {
    this.title.setTitle('Customer List');
  }


  ngOnInit(): void {
    // this.customerId = Number(this.activeRoute.snapshot.params.id);
    // this.getCustomerInfo();
    this.paginate();
  }

  getCustomerId(id: number, name: string): void {
    this.customerId = id;
    this.deleteName = name;
    console.log(this.customerId);
    console.log(this.deleteName);
    this.getCustomerInfo();
  }

  getCustomerInfo(): void {
    this.customerService.getCustomerById(this.customerId).subscribe(value => {
      console.log(value);
      if (value != null) {
        this.customer = value;
      }
    });
  }

  paginate() {
    this.customerService.paginate(this.page, this.pageSize, this.nameSearch, this.addressSearch).subscribe(value => {
      console.log(value);
      console.log(this.nameSearch);
      console.log(this.addressSearch);
      if (value != null) {
        this.action = true;
        this.customerList = value.content;
        this.total$ = new BehaviorSubject<number>(value.totalElements);
      } else {
        this.action = false;
      }
    });
  }

  deleteCustomer() {
    return this.customerService.deleteCustomerById(this.customerId).subscribe(value => {
      this.ngOnInit();
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Đã xóa thành công',
        showConfirmButton: false,
        timer: 2700
      });
    }, error => {
    }, () => {
    });
  }

}


