import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from './item';

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
  constructor(private httpClient: HttpClient, private items: Item[]) { }

  // GET
  getItems() {
    this.httpClient.get<Item[]>(this.baseurl + '/items')
      .subscribe(data => {
      this.items = data;
    });
  }

  // GET id
  getItem(id: number) {
    this.httpClient.get<Item>(this.baseurl + '/items/' + id)
      .subscribe(data => {
      this.items.push(data);
    });
  }

  // POST
  addItem(item: Item) {
    this.httpClient.post<Item>(
      this.baseurl + '/items',
      JSON.stringify(item),
      this.httpOptions
    );
  }

  // PUT
  updateItem(id: number, item: Item) {
    this.httpClient.put<Item>(
      this.baseurl + '/items/' + id,
      JSON.stringify(item),
      this.httpOptions
    );
  }

  // DELETE
  deleteItem(id: number) {
    this.httpClient.delete<Item>(this.baseurl + '/items/' + id, this.httpOptions);
  }

}
