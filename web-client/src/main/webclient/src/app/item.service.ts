import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from './item';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  baseurl = 'http://localhost:8080';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  constructor(private httpClient: HttpClient) { }

  // GET
  getItems(): Observable<Item[]> {
    return this.httpClient.get<Item[]>(this.baseurl + '/items');
  }

  // GET id
  getItem(id: number): Observable<Item> {
    return this.httpClient.get<Item>(this.baseurl + '/items/' + id);
  }

  // POST
  addItem(item: Item): Observable<Item> {
    return this.httpClient.post<Item>(
      this.baseurl + '/items',
      JSON.stringify(item),
      this.httpOptions
    );
  }

  // PUT
  updateItem(id: number, item: Item): Observable<Item> {
    return this.httpClient.put<Item>(
      this.baseurl + '/items/' + id,
      JSON.stringify(item),
      this.httpOptions
    );
  }

  // DELETE
  deleteItem(id: number): Observable<Item> {
    return this.httpClient.delete<Item>(this.baseurl + '/items/' + id, this.httpOptions);
  }

}
