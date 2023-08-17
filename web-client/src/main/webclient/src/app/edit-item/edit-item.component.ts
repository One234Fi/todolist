import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../item.service';
import { Item } from '../item';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {
  id: number;
  item: Item;
  item_title: FormControl;
  item_body: FormControl;

  constructor(private activateRoute: ActivatedRoute,
              public itemService: ItemService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.id = Number(this.activateRoute.snapshot.paramMap.get('id'));
    this.itemService.getItem(this.id).subscribe((res) => {
      this.item_title = new FormControl(res.title);
      this.item_body = new FormControl(res.body);
    });
  }


  updateItem() {
    this.item = { id: this.id, title: this.item_title.value, body: this.item_body.value };
    this.itemService.updateItem(this.id, this.item).subscribe((res) => {
      this.router.navigateByUrl('items-list');
    });

  }

  cancel() {
    this.router.navigateByUrl('items-list');
  }

}
