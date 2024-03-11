import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SigntypeViewComponent } from './signtype-view.component';

describe('SigntypeViewComponent', () => {
  let component: SigntypeViewComponent;
  let fixture: ComponentFixture<SigntypeViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SigntypeViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SigntypeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
