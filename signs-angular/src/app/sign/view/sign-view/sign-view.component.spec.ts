import {ComponentFixture, TestBed} from '@angular/core/testing';

import {SignViewComponent} from './sign-view.component';

describe('SignViewComponent', () => {
  let component: SignViewComponent;
  let fixture: ComponentFixture<SignViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SignViewComponent]
    });
    fixture = TestBed.createComponent(SignViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
