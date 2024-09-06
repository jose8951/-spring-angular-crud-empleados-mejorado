package com.gestion.empleados.service;

import java.util.Optional;

import com.gestion.empleados.repositorio.entity.Empleado;

public interface EmpleadoService {

	Iterable<Empleado> consultaTodos();
	
	//Optional evita que sea null
	Optional<Empleado> consultarEmpleado(Long id);
	
	Empleado altaEmpleado(Empleado empleado);
	
	public void borrarEmpleado(Long id);
	
	Optional<Empleado> modificarEmpleado(long id, Empleado empleado);
}
