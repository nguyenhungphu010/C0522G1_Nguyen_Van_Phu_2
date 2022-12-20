import {Shipping} from './shipping';
import {Customer} from './customer';

export interface Order {
  id?: number;
  dateProcess?: string;
  paymentMethod?: string;
  status?: number;
  customer?: Customer;
  shipping?: Shipping;
}
