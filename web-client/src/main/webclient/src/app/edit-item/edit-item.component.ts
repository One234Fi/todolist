import { Component, NgZone, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {
  items: any = [];
  updateItemForm: FormGroup;

  ngOnInit(): void {
      this.updateForm();
  }

  constructor(private activateRoute: ActivatedRoute,
              public itemService: ItemService,
              public formBuilder: FormBuilder,
              private ngZone: NgZone,
              private router: Router) {
    var id = Number(this.activateRoute.snapshot.paramMap.get('id'));
    this.itemService.getItem(id).subscribe((data) => {
      this.updateItemForm = this.formBuilder.group({
        item_title: [data.title],
        item_body: [data.body]
      });
    });
  }

  updateForm() {
    this.updateItemForm = this.formBuilder.group({
      item_title: [''],
      item_body: ['']
    });
  }

  submitForm() {
    var id = Number(this.activateRoute.snapshot.paramMap.get('id'));
    this.itemService.updateItem(id, this.updateItemForm.value).subscribe((res) => {
      this.ngZone.run(() => this.router.navigateByUrl('/issues-list'));
    });
  }

}
