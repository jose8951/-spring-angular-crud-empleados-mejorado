import { Component, OnInit } from '@angular/core'
import { ActivatedRoute } from '@angular/router'
import { Empleado } from 'src/app/entity/empleado'
import { EmpleadoService } from 'src/app/servicio/empleado.service'
import swal from 'sweetalert2'

@Component({
  selector: 'app-empleado-detalles',
  templateUrl: './empleado-detalles.component.html',
  styleUrls: ['./empleado-detalles.component.css'],
})
export class EmpleadoDetallesComponent implements OnInit {
  id!: number
  empleado: Empleado = new Empleado()

  constructor(
    private route: ActivatedRoute,
    private empleadoService: EmpleadoService,
  ) {}

  ngOnInit(): void {
    //obtiene el id que se le pasa por el navegador
    this.id = this.route.snapshot.params['id']
    // this.id=Number(this.route.snapshot.paramMap.get('id'))
    this.empleadoService.obtenerEmpleadoPorId(this.id).subscribe({
      next: (dato) => {
        this.empleado = dato
        swal.fire(`Detalles del empleado ${this.empleado.nombre}`)
      },
      error: (err) => console.error('Error fetching employee details:', err),
    })
  }
}
