import { Component, NgZone, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  itemForm: FormGroup;
  items: any = [];
  ngOnInit() {
    this.addItem();
  }
  constructor(public formBuilder: FormBuilder,
              private ngZone: NgZone,
              private router: Router,
              public itemService: ItemService) {}

  addItem() {
    this.itemForm = this.formBuilder.group({
      item_title: [''],
      item_body: [''],
    });
  }

  submitForm() {
    this.itemService.addItem(this.itemForm.value).subscribe((res) => {
      console.log("adding item");
      this.ngZone.run(() => this.router.navigateByUrl('/items-list'));
    });
  }
}
