import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AutenticacaoRoutingModule } from './autenticacao-routing.module';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule,
    AutenticacaoRoutingModule
  ]
})
export class AutenticacaoModule { }
