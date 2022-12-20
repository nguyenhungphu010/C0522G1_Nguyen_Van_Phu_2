import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookRoutingModule } from './book-routing.module';
import { BookListComponent } from './book-list/book-list.component';
import { BookEditComponent } from './book-edit/book-edit.component';
import { BookCreateComponent } from './book-create/book-create.component';


@NgModule({
  declarations: [BookListComponent, BookEditComponent, BookCreateComponent],
  imports: [
    CommonModule,
    BookRoutingModule
  ]
})
export class BookModule { }
