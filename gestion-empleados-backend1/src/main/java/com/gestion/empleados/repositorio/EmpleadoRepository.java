package com.gestion.empleados.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.repositorio.entity.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}
