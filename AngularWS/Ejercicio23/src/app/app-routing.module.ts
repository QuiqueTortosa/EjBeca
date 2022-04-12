import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { VideojuegosComponent } from './components/videojuegos/videojuegos.component'
import { DetailGameComponent } from './components/detailGame/detailGame.component';
import { ContactarComponent } from './components/contactar/contactar.component';
import { AboutmeComponent } from './components/aboutme/aboutme.component';



const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'videojuegos/:idU', component: VideojuegosComponent},
  {path: 'videojuegos/:idU/juego/:idV', component: DetailGameComponent},
  {path: 'contactar/:idU', component: ContactarComponent},
  {path: 'aboutme/:idU', component: AboutmeComponent},
  {path: '**', redirectTo: '/login', pathMatch: 'full'}, //Redirigue todas las rutas inexistentes al login
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
