import { Component, OnInit } from '@angular/core';
import {Book} from './book';
import { BookService } from './book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {

  books: Book[];
  book = new Book();
  
  constructor(private bookService: BookService) { }

  getBooks(): void{
    this.bookService.getAllBooks().subscribe(
        (bookd) => {this.books = bookd, console.log(bookd)},
        (error) => {console.log(error);}
        )
  }

  ngOnInit() {
    this.getBooks();
  }

  addBook() :void{
    this.bookService.addBook(this.book)
    .subscribe((response) => 
      {console.log(response); 
        this.reset();
        this.getBooks();
      }, 
      (error) => {console.log(error)});
  }

  private reset(){
    this.book.id=null;
    this.book.title=null;
    this.book.author=null;
  }

  deletebook(bookid: string){
    this.bookService.deletebook(bookid)
      .subscribe((response) => {console.log(response); this.getBooks();},
      (error) => {console.log(error);}
      )
  }

  getbookbyid(bookid: string){
    this.bookService.getbookbyid(bookid)
    .subscribe((bookd) => {this.book = bookd; this.getBooks();},
      (error) => {console.log(error);} )
  }

}
