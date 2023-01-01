import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';
import {AuthCustomerGuard} from './auth-customer.guard';
import {AuthGuard} from '../../security/auth.guard';


const routes: Routes = [
  {
    path: 'list', component: CustomerListComponent,
    canActivate: [AuthGuard],
    data: {
      roles: ['ROLE_ADMIN','ROLE_EMPLOYEE']
    }
  },
  {
    path: 'edit', component: CustomerEditComponent,
  },
  {
    path: 'create', component: CustomerCreateComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule {
}
