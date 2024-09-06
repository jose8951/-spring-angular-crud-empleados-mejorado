import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Empleado } from '../entity/empleado'
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root',
})
export class EmpleadoService {
  private static readonly baseURL = 'http://localhost:8081/api/v1'

  constructor(private httpClient: HttpClient) {}

  //este metodo nos sirve para obtener los empleados
  obtenerListaDeEmpleados(): Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(`${EmpleadoService.baseURL}`)
  }

  registrarEmpleado(empleado: Empleado): Observable<Object> {
    return this.httpClient.post(`${EmpleadoService.baseURL}`, empleado)
  }

  actualizarEmpleado(id: number, empleado: Empleado): Observable<Object> {
    return this.httpClient.put(`${EmpleadoService.baseURL}/${id}`, empleado)
  }

  obtenerEmpleadoPorId(id: number): Observable<Empleado> {
    return this.httpClient.get<Empleado>(`${EmpleadoService.baseURL}/${id}`)
  }

  eliminarEmpleado(id: number): Observable<Object> {
    return this.httpClient.delete(`${EmpleadoService.baseURL}/${id}`)
  }
}
