import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroEventoRoutingModule } from './cadastro-evento-routing.module';
import { HospedagemComponent } from './hospedagem/hospedagem.component';
import { InscricaoComponent } from './inscricao/inscricao.component';
import { InscricaoFormComponent } from './inscricao-form/inscricao-form.component';
import { PagamentoComponent } from './pagamento/pagamento.component';
import { PaginaEventoComponent } from './pagina-evento/pagina-evento.component';


@NgModule({
  declarations: [
    HospedagemComponent,
    InscricaoComponent,
    InscricaoFormComponent,
    PagamentoComponent,
    PaginaEventoComponent
  ],
  imports: [
    CommonModule,
    CadastroEventoRoutingModule
  ]
})
export class CadastroEventoModule { }
