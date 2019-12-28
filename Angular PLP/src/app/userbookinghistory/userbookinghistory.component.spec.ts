import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserbookinghistoryComponent } from './userbookinghistory.component';

describe('UserbookinghistoryComponent', () => {
  let component: UserbookinghistoryComponent;
  let fixture: ComponentFixture<UserbookinghistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserbookinghistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserbookinghistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
