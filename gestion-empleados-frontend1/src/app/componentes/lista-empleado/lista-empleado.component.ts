import { Component, OnInit } from '@angular/core'
import { Router } from '@angular/router'
import { Empleado } from 'src/app/entity/empleado'
import { EmpleadoService } from 'src/app/servicio/empleado.service'
import swal from 'sweetalert2'

@Component({
  selector: 'app-lista-empleado',
  templateUrl: './lista-empleado.component.html',
  styleUrls: ['./lista-empleado.component.css'],
})
export class ListaEmpleadoComponent implements OnInit {
  empleados!: Empleado[]

  constructor(
    private empleadoServicio: EmpleadoService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.obtenerEmpleados()
  }

  private obtenerEmpleados(): void {
    this.empleadoServicio.obtenerListaDeEmpleados().subscribe({
      next: (dato) => {
        this.empleados = dato
      },
      error: (error) => {
        console.log('Error al obtener la lista de empleados:', error)
      },
      complete: () => {
        console.log('lista de empeados obtenida existosamente')
      },
    })
  }

  eliminarEmpleado(id: number): void {
    swal.fire({
        title: '¿Estás seguro?',
        text: 'Confirma si deseas eliminar al empleado',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'No, cancelar',
        buttonsStyling: true,
      })
      .then((result) => {
        if (result.isConfirmed) {
          this.empleadoServicio.eliminarEmpleado(id).subscribe({
            next: (dato) => {
              console.log(`Empleado con ID ${id} eliminado exitosamente.`)
              this.obtenerEmpleados()
              swal.fire(
                'Empleado Eliminado',
                'El empleado ha sido eliminado con exito',
                "success"
              )
            },
            error: (err) => {
              console.error(`Error al eliminar el empleado con ID ${id}:`, err)
            },
            complete: () => {
              console.log('Proceso de eliminación completado.')
            },
          })
        }
      })
  }

  actualizarEmpleado(id: number): void {
    this.router.navigate(['actualizar-empleado', id])
  }

  verDetallesDeEmpleado(id: number): void {
    this.router.navigate(['empleado-detalles', id])
  }
}
