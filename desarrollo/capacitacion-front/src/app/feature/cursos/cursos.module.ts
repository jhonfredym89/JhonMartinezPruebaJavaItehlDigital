import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CursosRoutingModule } from './cursos-routing.module';
import { ListadoModalidadComponent } from './views/listado-modalidad/listado-modalidad.component';
import { RegistroComponent } from './views/registro/registro.component';
import { HttpClientModule } from '@angular/common/http';
import { CursosApiService } from './services/cursos-api.service';
import { CursosService } from './services/cursos.service';
import { MaterialModule } from '@shared/modules/material/material.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    ListadoModalidadComponent,
    RegistroComponent
  ],
  imports: [
    CommonModule,
    CursosRoutingModule,
    HttpClientModule,
    MaterialModule,
    RouterModule
  ],
  providers: [
    CursosApiService,
    CursosService
  ]
})
export class CursosModule { }
