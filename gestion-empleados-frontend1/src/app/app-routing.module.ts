import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router'
import { ListaEmpleadoComponent } from './componentes/lista-empleado/lista-empleado.component'
import { RegistrarEmpleadoComponent } from './componentes/registrar-empleado/registrar-empleado.component'
import { ActualizarEmpleadoComponent } from './componentes/actualizar-empleado/actualizar-empleado.component'
import { EmpleadoDetallesComponent } from './componentes/empleado-detalles/empleado-detalles.component'

const routes: Routes = [
  { path: 'empleados', component: ListaEmpleadoComponent },
  { path: '', redirectTo: 'empleados', pathMatch: 'full' },
  { path: 'registrar-empleado', component: RegistrarEmpleadoComponent },
  { path: 'actualizar-empleado/:id', component: ActualizarEmpleadoComponent },
  { path: 'empleado-detalles/:id', component: EmpleadoDetallesComponent },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
