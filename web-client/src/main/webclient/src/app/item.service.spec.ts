import { TestBed } from '@angular/core/testing';

import { ItemService } from './item.service';

describe('ItemServiceService', () => {
  let service: ItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
