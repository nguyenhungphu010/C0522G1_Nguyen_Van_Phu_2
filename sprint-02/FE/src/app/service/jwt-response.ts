import {User} from '../model/user';

export class JwtResponse {
  token: string;
  user: User;
  username: string;

  constructor(public jwtResponse: string) {
    this.token = jwtResponse;
  }
}
