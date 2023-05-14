import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ResgistroUsuarioComponent } from './resgistro-usuario/resgistro-usuario.component';
import { RegistroOrganizacaoComponent } from './autencicao/registro-organizacao/registro-organizacao.component';
import { HospedagemIscricaoComponent } from './hospedagem-iscricao/hospedagem-iscricao.component';
import { HospedagemComponent } from './hospedagem/hospedagem.component';

@NgModule({
  declarations: [
    AppComponent,
    ResgistroUsuarioComponent,
    RegistroOrganizacaoComponent,
    HospedagemIscricaoComponent,
    HospedagemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
