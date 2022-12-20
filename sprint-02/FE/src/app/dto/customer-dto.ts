import {User} from '../model/user';

export interface CustomerDto {
  id?: number;
  name?: string;
  phoneNumber?: string;
  dayOfBirth?: string;
  gender?: number;
  email?: string;
  address?: string;
  user?: User;
}
