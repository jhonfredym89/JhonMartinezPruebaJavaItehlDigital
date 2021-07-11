import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DescuentosRoutingModule } from './descuentos-routing.module';
import { DescuentosComponent } from './descuentos.component';


@NgModule({
  declarations: [DescuentosComponent],
  imports: [
    CommonModule,
    DescuentosRoutingModule
  ]
})
export class DescuentosModule { }
