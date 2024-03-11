import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SigntypeAddComponent } from './signtype-add.component';

describe('SigntypeAddComponent', () => {
  let component: SigntypeAddComponent;
  let fixture: ComponentFixture<SigntypeAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SigntypeAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SigntypeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
