package com.gestion.empleados.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.repositorio.EmpleadoRepository;
import com.gestion.empleados.repositorio.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Override
	@Transactional(readOnly = true) //permitimos acceso concurrente al la tabla empleado
	public Iterable<Empleado> consultaTodos() {		
		return this.empleadoRepository.findAll();
	}	

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado> consultarEmpleado(Long id) {
		return this.empleadoRepository.findById(id);		 
	}

	@Override
	@Transactional
	public Empleado altaEmpleado(Empleado empleado) {
		return this.empleadoRepository.save(empleado);	
	}

	@Override
	@Transactional
	public void borrarEmpleado(Long id) {
		this.empleadoRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public Optional<Empleado> modificarEmpleado(long id, Empleado empleado) {
		Optional<Empleado> opRest= Optional.empty();
		opRest=this.empleadoRepository.findById(id);
		if(opRest.isPresent()) {
			Empleado empleadoLeido=opRest.get();
			BeanUtils.copyProperties(empleado, empleadoLeido,"id","credoEm"); //copia menos estos dos campos
			//BeanUtils.copyProperties(empleado, empleadoLeido,"id");
			opRest=Optional.of(empleadoLeido);//devuelve el relleno el optinal
		}		
		return opRest;
	}

}
