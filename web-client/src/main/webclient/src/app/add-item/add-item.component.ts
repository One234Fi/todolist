import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { ItemService } from '../item.service';
import { Item } from '../item';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent {
  item_title = new FormControl('');
  item_body = new FormControl('');

  constructor(private router: Router, public itemService: ItemService) {}

  addItem() {
    let newItem: Item = { id: 0, title: this.item_title.value, body: this.item_body.value };
    this.itemService.addItem(newItem).subscribe(() => {
      this.router.navigateByUrl("items-list");
    });
  }

  cancel() {
    this.router.navigateByUrl("items-list");
  }
}
