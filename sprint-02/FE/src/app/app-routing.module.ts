import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeModule} from './modules/home/home.module';
import {CustomerModule} from './modules/customer/customer.module';
import {BookModule} from './modules/book/book.module';
import {SecurityModule} from './security/security.module';


const routes: Routes = [
  {
    path: 'home', loadChildren: () => HomeModule,
  },
  {
    path: 'login', loadChildren: () => SecurityModule,
  },
  {
    path: 'customer', loadChildren: () => CustomerModule,
  },
  {
    path: 'book', loadChildren: () => BookModule,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
