import { Component, OnInit } from '@angular/core'
import { Router } from '@angular/router'
import { Empleado } from 'src/app/entity/empleado'
import { EmpleadoService } from 'src/app/servicio/empleado.service'
import Swal from 'sweetalert2'

@Component({
  selector: 'app-registrar-empleado',
  templateUrl: './registrar-empleado.component.html',
  styleUrls: ['./registrar-empleado.component.css'],
})
export class RegistrarEmpleadoComponent implements OnInit {
  empleado: Empleado = new Empleado()

  constructor(
    private empleadoService: EmpleadoService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    const fechaAtual = new Date()
    console.log(fechaAtual) //Wed Aug 28 2024 19:18:51 GMT+0200
    console.log(fechaAtual.toISOString()) //2024-08-28T17:18:51.338Z
    console.log(fechaAtual.toLocaleString()) //28/8/2024, 19:18:51
  }

  onSubmit(): void {
    this.empleadoService.registrarEmpleado(this.empleado).subscribe({
      next: (dato) => {
        console.log(dato)
        this.router.navigate(['/empleados'])
        Swal.fire(
          'Empleado registrado',
          `El empleado ${this.empleado.nombre} ha sido registrado con exito`,
          'success',
        )
      },
      error: (error) => console.log(error),
      complete: () => console.log('registro de empleo completado'),
    })
  }
}
