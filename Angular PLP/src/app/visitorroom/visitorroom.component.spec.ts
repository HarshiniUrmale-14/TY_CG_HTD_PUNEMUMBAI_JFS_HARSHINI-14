import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisitorroomComponent } from './visitorroom.component';

describe('VisitorroomComponent', () => {
  let component: VisitorroomComponent;
  let fixture: ComponentFixture<VisitorroomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisitorroomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisitorroomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
