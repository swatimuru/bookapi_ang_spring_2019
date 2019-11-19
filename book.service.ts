import {Http, RequestOptions, Response, Headers} from '@angular/http';
import {Injectable} from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book';
// import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';
// import 'rxjs/add/operator/catch';

@Injectable()
export class BookService{

    constructor(private httpService: Http){}

        getAllBooks():Observable<Book[]>{
            return this.httpService.get("http://localhost:8080/bookapi/api/book").pipe(
            map((response: Response) => response.json()))
            // .catch(this.handleErrors);
        }
    
        private handleErrors(error: Response){
            return Observable.throw(error);
        }

        addBook(book: Book){
            let body = JSON.stringify(book);
            let headers = new Headers({'Content-Type' : 'application/json'});
            let options = new RequestOptions({headers: headers});

            if(book.id){
                return this.httpService.put("http://localhost:8080/bookapi/api/book/"+book.id, body, options);
            }else{
                return this.httpService.post("http://localhost:8080/bookapi/api/book", body, options);
            }
        }

        deletebook(bookid: string){
            return this.httpService.delete('http://localhost:8080/bookapi/api/book/'+bookid);
        }

        getbookbyid(bookid: string) : Observable<Book>{
            return this.httpService.get('http://localhost:8080/bookapi/api/book/'+bookid).pipe(
            map((response : Response) => response.json()))
            
        }
}