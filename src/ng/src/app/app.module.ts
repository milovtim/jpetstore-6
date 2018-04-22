import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {HttpClientModule} from "@angular/common/http";
import {ModalModule} from "ngx-bootstrap";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    NgxDatatableModule,
    ModalModule.forRoot(),
    BrowserModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
