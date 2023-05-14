import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroOrganizacaoComponent } from './registro-organizacao.component';

describe('RegistroOrganizacaoComponent', () => {
  let component: RegistroOrganizacaoComponent;
  let fixture: ComponentFixture<RegistroOrganizacaoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistroOrganizacaoComponent]
    });
    fixture = TestBed.createComponent(RegistroOrganizacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
