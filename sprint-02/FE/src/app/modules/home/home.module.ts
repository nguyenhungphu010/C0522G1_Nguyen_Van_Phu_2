import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {HomeRoutingModule} from './home-routing.module';
import {BookListsHomeComponent} from './book-lists-home/book-lists-home.component';
import {PromotionListComponent} from './promotion-list/promotion-list.component';
import {BookDetailComponent} from './book-detail/book-detail.component';
import {CartComponent} from './cart/cart.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';



@NgModule({
  declarations: [BookListsHomeComponent, PromotionListComponent, BookDetailComponent, CartComponent],
    imports: [
        CommonModule,
        HomeRoutingModule,
        ReactiveFormsModule,
        FormsModule
    ]
})
export class HomeModule {
}
