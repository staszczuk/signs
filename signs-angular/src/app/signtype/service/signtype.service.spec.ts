import {TestBed} from '@angular/core/testing';

import {SignTypeService} from './signtype.service';

describe('SignTypeService', () => {
  let service: SignTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SignTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
