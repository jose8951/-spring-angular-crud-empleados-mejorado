export class Empleado {
  id!: number
  nombre!: string
  apellido!: string
  email!: string
  creadoEn!: Date | string

  constructor() {
    this.id = 0
    this.nombre = ''
    this.apellido = ''
    this.email = ''
    this.creadoEn = ''
  }
}
