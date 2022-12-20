import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {BookListComponent} from './book-list/book-list.component';
import {BookEditComponent} from './book-edit/book-edit.component';
import {BookCreateComponent} from './book-create/book-create.component';


const routes: Routes = [
  {
    path: 'list', component: BookListComponent,
  },
  {
    path: 'edit', component: BookEditComponent,
  },
  {
    path: 'create', component: BookCreateComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule {
}
