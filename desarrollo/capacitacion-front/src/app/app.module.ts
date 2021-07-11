import { BrowserModule } from '@angular/platform-browser/';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatListModule } from "@angular/material/list";
import { LayoutComponent } from '@shared/components/layout/layout.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatListModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
