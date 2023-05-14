import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResgistroUsuarioComponent } from './resgistro-usuario.component';

describe('ResgistroUsuarioComponent', () => {
  let component: ResgistroUsuarioComponent;
  let fixture: ComponentFixture<ResgistroUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResgistroUsuarioComponent]
    });
    fixture = TestBed.createComponent(ResgistroUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
