import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import { StudentDAOComponent } from './student-dao/student-dao.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentDetailComponent,
    StudentDAOComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
