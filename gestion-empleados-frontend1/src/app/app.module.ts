import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component'
import { ListaEmpleadoComponent } from './componentes/lista-empleado/lista-empleado.component'
import { HttpClientModule } from '@angular/common/http'
import { RegistrarEmpleadoComponent } from './componentes/registrar-empleado/registrar-empleado.component'
import { ActualizarEmpleadoComponent } from './componentes/actualizar-empleado/actualizar-empleado.component'
import { EmpleadoDetallesComponent } from './componentes/empleado-detalles/empleado-detalles.component'
import { FormsModule } from '@angular/forms'

@NgModule({
  declarations: [
    AppComponent,
    ListaEmpleadoComponent,
    RegistrarEmpleadoComponent,
    ActualizarEmpleadoComponent,
    EmpleadoDetallesComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
