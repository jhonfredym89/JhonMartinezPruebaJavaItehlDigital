import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListadoModalidadComponent } from './views/listado-modalidad/listado-modalidad.component';
import { RegistroComponent } from './views/registro/registro.component';

const routes: Routes = [
  { 
    path: '', 
    component: ListadoModalidadComponent 
  },
  { 
    path: 'registro/:codigo', 
    component: RegistroComponent 
  }
  ];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ]
})
export class CursosRoutingModule { }
