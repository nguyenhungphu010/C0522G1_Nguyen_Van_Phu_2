import {Component, OnDestroy, OnInit} from '@angular/core';
import {CartService} from '../../../service/cart.service';
import {Cart} from '../../../model/cart';
import {TokenStorageService} from '../../../service/token-storage.service';
import {render, RenderParams} from 'creditcardpayments/creditCardPayments';
import Swal from 'sweetalert2';
import {FormControl, FormGroup} from '@angular/forms';
import {Order} from '../../../model/order';
import {OrderService} from '../../../service/order.service';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit, OnDestroy {
  cartList: Cart[];
  totalPrice: number = 0;
  selectCart: Cart[] = [];
  order: any;
  // paypal
  renderParam?: RenderParams;
  // order Infor
  orderForm?: FormGroup;
  feeShipping: number = 0;
  customerUserName: string;
  dateOrderProcess: Date;
  paymentMethodTest: string;
  shippingTestId: string;
  crrDate: string;
  crrDate2: string;

  maxId: number;

  orderList: Order[] = [];


  constructor(private cartService: CartService,
              private tokenStorageService: TokenStorageService,
              private orderService: OrderService
  ) {

    this.renderParam = {
      id: '#paypalButton',
      currency: 'VND',
      // value: String((this.totalPrice/ 23000).toFixed(2)),
      value: '0',
      onApprove: details => {
        this.cartService.updateAll(this.cartList).subscribe();
        this.selectCart.map(value => value.status = true);
        this.cartService.pay(this.selectCart).subscribe(value => {
          this.getCartItems();
        });
        alert(' thanh toan thanh cong');
      }
    };
  }

  ngOnInit(): void {
    this.getCartItems();
    render(this.renderParam);

    this.orderForm = new FormGroup({
      paymentMethod: new FormControl('Thanh toán khi nhận hàng'),
      shippingMethod: new FormControl(1),
    });
    this.getFeeShippingMethod();
// khoi tao doi tuong new Date () test
    this.dateOrderProcess = new Date();
    this.crrDate = formatDate(this.dateOrderProcess, 'yyyy-MM-dd', 'en-US');
    // khoi tao current Date gan bao doi tuong Order;
    this.crrDate2 = formatDate(new Date(), 'yyyy-MM-dd', 'en-US');
    this.customerUserName = this.tokenStorageService.getUsername();
    this.shippingTestId = this.orderForm.value.shippingMethod;
    this.paymentMethodTest = this.orderForm.value.paymentMethod;
    // this.getMaxId();
  }

  public getMaxId() {
    this.orderService.getMaxOrderId().subscribe(value => {
      this.maxId = value;
      console.log(this.maxId);
    }, error => {

    }, () => {
      console.log(this.maxId);
    });
    console.log(this.maxId);
  }

  normalPayment() {
    this.orderService.getMaxOrderId().subscribe(value => {
      console.log(value);
      for (let item of this.selectCart) {
        console.log(item);
        item.order.id = value;
        console.log(item.order.id);
      }
    }, error => {

    }, () => {
      console.log(this.maxId);
    });

    console.log(this.maxId);
    this.cartService.updateAll(this.cartList).subscribe();
    this.selectCart.map(value => value.status = true);
    this.cartService.pay(this.selectCart).subscribe(value => {
      this.getCartItems();
      this.selectCart = [];
    });
    this.createOrder();

    window.location.reload();
  }

  getOrderInfo() {
    this.getFeeShippingMethod();
    this.order = {
      payment: this.orderForm.value.paymentMethod,
      dateProcess: this.crrDate2,
      shipping: {
        id: this.orderForm.value.shippingMethod
      }
    };
  }

  getFeeShippingMethod() {
    if (this.orderForm.value.shippingMethod == 1) {
      this.feeShipping = 30000;
    }
    if (this.orderForm.value.shippingMethod == 2) {
      this.feeShipping = 50000;
    }
    if (this.orderForm.value.shippingMethod == 3) {
      this.feeShipping = 80000;
    }
    if (this.orderForm.value.shippingMethod == 4) {
      this.feeShipping = 100000;
    }
  }

  createOrder() {
    this.orderService.creatOrder(this.order).subscribe();
    console.log(this.order);
  }


  getCartItems() {
    this.cartService.getAllCart().subscribe(value => {
      this.cartList = value;
      console.log(value);
    });
  }

  select(cart: Cart) {
    console.log(cart);
    if (this.selectCart.includes(cart)) {
      this.selectCart.splice(this.selectCart.indexOf(cart), 1);
    } else {
      this.selectCart.push(cart);
    }
    this.totalPrice = 0;
    this.selectCart.forEach(value => {
      this.totalPrice += value.quantity * value.book.price;
    });
    console.log(this.totalPrice);
    this.renderParam.value = String((this.totalPrice / 23000).toFixed(2));
    console.log(this.selectCart);
  }

  increase(i: number) {
    this.cartList[i].quantity += 1;
    this.totalPrice = 0;
    this.selectCart.forEach(value => {
      this.totalPrice += value.quantity * value.book.price;
    });
  }

  decrease(i: number) {
    if (this.cartList[i].quantity > 1) {
      this.cartList[i].quantity -= 1;
    }
    this.totalPrice = 0;
    this.selectCart.forEach(value => {
      this.totalPrice += value.quantity * value.book.price;
    });
  }

  ngOnDestroy(): void {
    this.cartService.updateAll(this.cartList).subscribe();
  }

  deleteCart(id: number): void {
    this.cartService.deleteCart(id).subscribe(value => {
      this.getCartItems();
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: ' Xoa san pham thành công !',
        showConfirmButton: false,
        timer: 2000
      });
    });
  }

  // deleteCart(id: number) {
  //   this.cartService.
  // }
}

