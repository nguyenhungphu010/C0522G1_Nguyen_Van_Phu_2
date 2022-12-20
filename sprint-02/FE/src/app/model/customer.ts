import {User} from './user';

export interface Customer {
  id?: number;
  name?: string;
  phoneNumber?: string;
  dayOfBirth?: string;
  gender?: number;
  email?: string;
  address?: string;
  user?: User;
}
