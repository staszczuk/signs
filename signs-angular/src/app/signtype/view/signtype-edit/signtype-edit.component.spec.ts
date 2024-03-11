import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SigntypeEditComponent } from './signtype-edit.component';

describe('SigntypeEditComponent', () => {
  let component: SigntypeEditComponent;
  let fixture: ComponentFixture<SigntypeEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SigntypeEditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SigntypeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
