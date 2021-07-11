import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from '@shared/components/layout/layout.component';


const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { 
        path: '', 
        loadChildren: () => import('@feature/inicio/inicio.module').then(m => m.InicioModule) 
      }, 
      { 
        path: 'cursos', 
        loadChildren: () => import('@feature/cursos/cursos.module').then(m => m.CursosModule) 
      },
      { 
        path: 'descuentos', 
        loadChildren: () => import('@feature/descuentos/descuentos.module').then(m => m.DescuentosModule)
       }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
