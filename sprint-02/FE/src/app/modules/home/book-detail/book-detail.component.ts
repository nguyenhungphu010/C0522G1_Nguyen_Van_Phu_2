import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {Books} from '../../../model/books';
import {Title} from '@angular/platform-browser';
import {BookService} from '../../../service/book.service';
import {CartService} from '../../../service/cart.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {
  bookId: number;
  book: Books;
  bookAddTocartId: number;
  bookImage: string;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private title: Title,
              private bookService: BookService,
              private cartService: CartService) {
    this.title.setTitle('Book Detail');
  }

  bookFormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    image: new FormControl(),
    supplier: new FormControl(),
    author: new FormControl(),
    translator: new FormControl(),
    publisher: new FormControl(),
    publishYear: new FormControl(),
    weight: new FormControl(),
    dimension: new FormControl(),
    pages: new FormControl(),
    price: new FormControl(),
    cover: new FormControl(),
    stock: new FormControl(),
    details: new FormControl(),
  });

  ngOnInit(): void {
    this.bookId = Number(this.activatedRoute.snapshot.params.id);
    console.log(this.bookId);
    this.bookService.getById(this.bookId).subscribe(value => {
      this.book = value;
      this.bookFormGroup.patchValue(this.book);
      console.log(this.book);
    });
  }

  addToCart(){
    this.cartService.addToCart(this.bookId).subscribe(data => {
      this.cartService.getAllCart().subscribe();
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: ' them vao gio hang thanh cong!',
        showConfirmButton: false,
        timer: 2000
      })
    })

  }

}
