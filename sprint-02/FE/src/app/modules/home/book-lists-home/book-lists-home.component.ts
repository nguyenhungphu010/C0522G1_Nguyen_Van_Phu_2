import {Component, OnInit} from '@angular/core';
import {BookService} from '../../../service/book.service';
import {Title} from '@angular/platform-browser';
import {ActivatedRoute, Router} from '@angular/router';
import {Books} from '../../../model/books';
import {BehaviorSubject, Observable} from 'rxjs';
import {logger} from 'codelyzer/util/logger';

@Component({
  selector: 'app-book-lists-home',
  templateUrl: './book-lists-home.component.html',
  styleUrls: ['./book-lists-home.component.css']
})
export class BookListsHomeComponent implements OnInit {

  bookNameSearch = '';
  bookAuthorSearch = '';
  pageSize = 5;
  page = 1;
  bookList$: Observable<Books[]> | undefined;
  bookList: Books[];
  total$: Observable<number>;
  action: boolean;

  constructor(private bookService: BookService,
              private title: Title,
              private router: Router,
              private activeRoute: ActivatedRoute) {
    this.title.setTitle('Home Page');
  }

  ngOnInit(): void {
    this.paginate();
  }

  paginate() {
    this.bookService.paginate(this.page, this.pageSize, this.bookNameSearch, this.bookAuthorSearch).subscribe(value => {
      console.log(value);
      if (value != null) {
        this.action = true;
        this.bookList = value.content;
        this.total$ = new BehaviorSubject<number>(value.totalElements);
      } else {
        this.action = false;
      }
    });
  }
  loadMore() {
    this.pageSize += 5;
    this.paginate();
  }
  loadLess() {
    this.pageSize -= 5;
    this.paginate();
  }
}
