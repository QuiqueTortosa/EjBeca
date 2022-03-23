import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { VideojuegosComponent } from './components/videojuegos/videojuegos.component';
import { VideojuegoComponent } from './components/videojuego/videojuego.component';
import { DetailGameComponent } from './components/detailGame/detailGame.component';
import { HeaderComponent } from './components/header/header.component';
import { ContactarComponent } from './components/contactar/contactar.component';
import { AboutmeComponent } from './components/aboutme/aboutme.component';


import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    VideojuegosComponent,
    VideojuegoComponent,
    DetailGameComponent,
    HeaderComponent,
    ContactarComponent,
    AboutmeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
