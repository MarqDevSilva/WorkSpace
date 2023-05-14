import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelatorioInscricoesComponent } from './relatorio-inscricoes.component';

describe('RelatorioInscricoesComponent', () => {
  let component: RelatorioInscricoesComponent;
  let fixture: ComponentFixture<RelatorioInscricoesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RelatorioInscricoesComponent]
    });
    fixture = TestBed.createComponent(RelatorioInscricoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
