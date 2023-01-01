import {Books} from './books';
import {Order} from './order';

export interface Cart {
  id?: number;
  quantity?: number;
  user?: any;
  book?: Books;
  status?: boolean;
  order: Order;

}
