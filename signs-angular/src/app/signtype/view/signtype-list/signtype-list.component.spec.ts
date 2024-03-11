import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SigntypeListComponent } from './signtype-list.component';

describe('SigntypeListComponent', () => {
  let component: SigntypeListComponent;
  let fixture: ComponentFixture<SigntypeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SigntypeListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SigntypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
