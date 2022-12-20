import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookDetailComponent} from './book-detail/book-detail.component';
import {CartComponent} from './cart/cart.component';
import {BookListsHomeComponent} from './book-lists-home/book-lists-home.component';


const routes: Routes = [
  {
    path: 'list', component: BookListsHomeComponent,
  },
  {
    path: 'cart', component: CartComponent,
  },
  {
    path: 'detail/:id', component: BookDetailComponent,
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
