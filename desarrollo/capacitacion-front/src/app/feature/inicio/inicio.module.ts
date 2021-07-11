import { NgModule } from '@angular/core';

import { InicioRoutingModule } from '@feature/inicio/inicio-routing.module';
import { InicioComponent } from '@feature/inicio/inicio.component';

@NgModule({
  declarations: [
    InicioComponent
  ],
  imports: [
    InicioRoutingModule
  ]
})
export class InicioModule { }
