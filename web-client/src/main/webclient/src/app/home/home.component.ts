import { Component, OnInit } from '@angular/core';
import { ItemService } from '../item.service';
import { Item } from '../item';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  items: Item[] = [];
  constructor(private itemService: ItemService) { }

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    return this.itemService.getItems().subscribe((data) => {
      this.items = data;
    });
  }

  deleteItem(data: Item) {
    var index = this.items.map(n => {return n.title}).indexOf(data.title);
    return this.itemService.deleteItem(data.id).subscribe((res) => {
      this.items.splice(index, 1);
    });
  }

}

