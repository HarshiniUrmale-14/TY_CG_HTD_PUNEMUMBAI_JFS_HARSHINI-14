import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeebookingComponent } from './employeebooking.component';

describe('EmployeebookingComponent', () => {
  let component: EmployeebookingComponent;
  let fixture: ComponentFixture<EmployeebookingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeebookingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeebookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
