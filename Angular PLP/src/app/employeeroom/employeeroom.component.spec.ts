import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeroomComponent } from './employeeroom.component';

describe('EmployeeroomComponent', () => {
  let component: EmployeeroomComponent;
  let fixture: ComponentFixture<EmployeeroomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeroomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
