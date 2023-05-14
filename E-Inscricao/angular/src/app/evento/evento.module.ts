import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventoRoutingModule } from './evento-routing.module';
import { PaginaEventoComponent } from './pagina-evento/pagina-evento.component';
import { PagamentoComponent } from './pagamento/pagamento.component';


@NgModule({
  declarations: [
    PaginaEventoComponent,
    PagamentoComponent
  ],
  imports: [
    CommonModule,
    EventoRoutingModule
  ]
})
export class EventoModule { }
