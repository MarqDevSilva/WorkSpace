import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UtilitariosRoutingModule } from './utilitarios-routing.module';
import { RelatorioComponent } from './relatorio/relatorio.component';
import { RelatorioInscricoesComponent } from './relatorio-inscricoes/relatorio-inscricoes.component';
import { RelatorioFinanceiroComponent } from './relatorio-financeiro/relatorio-financeiro.component';
import { SendEmailComponent } from './send-email/send-email.component';


@NgModule({
  declarations: [
    RelatorioComponent,
    RelatorioInscricoesComponent,
    RelatorioFinanceiroComponent,
    SendEmailComponent
  ],
  imports: [
    CommonModule,
    UtilitariosRoutingModule
  ]
})
export class UtilitariosModule { }
