import {Shipping} from './shipping';

export interface Order {
  id?: number;
  dateProcess?: string;
  paymentMethod?: string;
  status?: boolean;
  isDelete?: boolean;
  shipping?: Shipping;
}
