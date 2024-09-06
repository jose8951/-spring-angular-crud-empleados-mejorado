import { Component, OnInit } from '@angular/core'
import { ActivatedRoute, Router } from '@angular/router'
import { Empleado } from 'src/app/entity/empleado'
import { EmpleadoService } from 'src/app/servicio/empleado.service'
import Swal from 'sweetalert2'

@Component({
  selector: 'app-actualizar-empleado',
  templateUrl: './actualizar-empleado.component.html',
  styleUrls: ['./actualizar-empleado.component.css'],
})
export class ActualizarEmpleadoComponent implements OnInit {
  id!: number
  empleado: Empleado = new Empleado()

  constructor(
    private empleadoService: EmpleadoService,
    private router: Router,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.empleadoService.obtenerEmpleadoPorId(this.id).subscribe({
      next: (dato) => {
        this.empleado = dato
      },
      error: (err) => {
        console.log('Error al obtener el empleado:', err)
      },
      complete: () => {
        console.log('Carga del empleado completada')
      },
    })
  }

  irAlaListaDeEmpleados(): void {
    this.router.navigate(['/empleados'])
    //si todo es correcto se confirma

    Swal.fire({
      title: '!Empleado Actualizado!',
      text: `Empleado ${this.empleado.nombre} ha sido actualizado con éxito`,
      icon: 'success',
      showConfirmButton: true,
      confirmButtonText: 'Aceptar',
      timer: 6000,
      timerProgressBar: true,
      backdrop: `
      rgba(0,0,0,0.6)
      url("/images/nyan-cat.git")
      left top
      no-repeat
      `,
    })
  }

  onSubmit() {
    if (this.empleado) {
      this.empleadoService
        .actualizarEmpleado(this.id, this.empleado).subscribe({
          next: (dato) => {
            this.irAlaListaDeEmpleados()
          },
          error: (err) => {
            console.log(err)
          },
          complete: () => {
            console.log('actualizacion completada')
          },
        })
    }
  }
}
