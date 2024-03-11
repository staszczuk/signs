import {ComponentFixture, TestBed} from '@angular/core/testing';

import {SignEditComponent} from './sign-edit.component';

describe('SignEditComponent', () => {
  let component: SignEditComponent;
  let fixture: ComponentFixture<SignEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SignEditComponent]
    });
    fixture = TestBed.createComponent(SignEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
