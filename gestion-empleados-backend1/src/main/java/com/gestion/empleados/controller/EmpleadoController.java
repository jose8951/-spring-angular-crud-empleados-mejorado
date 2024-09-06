package com.gestion.empleados.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.repositorio.entity.Empleado;
import com.gestion.empleados.service.EmpleadoService;

//http://localhost:8081/api/v1
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200") // esto es necesario por angular
public class EmpleadoController {

	@Autowired
	EmpleadoService empleadoService;

	@GetMapping("/test") // GET http://localhost:8081/api/v1/test
	public Empleado obtenerRestauranteTest() {
		Empleado empleado = null;
		System.out.println("Llamado obtener Test");
		empleado = new Empleado(1l, "pepe", "garciua", "correo@correo.com", LocalDateTime.now());
		return empleado;
	}

	// GET http://localhost:8081/api/v1
	@GetMapping
	public ResponseEntity<?> listarTodos() {
		ResponseEntity<?> responseEntity = null;
		Iterable<Empleado> lista_restaurante = null;
		lista_restaurante = this.empleadoService.consultaTodos();
		responseEntity = ResponseEntity.ok(lista_restaurante);
		// String saludo="hola";
		// saludo.charAt(10);
		return responseEntity;
	}

	// Optional es como un huevo kinder
	// GET http://localhost:8081/api/v1/1
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Optional<Empleado> or = null;
		or = this.empleadoService.consultarEmpleado(id);
		if (or.isPresent()) {
			Empleado restauranteleido = or.get();
			responseEntity = ResponseEntity.ok().body(restauranteleido);
		} else {
			// el cuerpo va sin nada con un 204
			responseEntity = ResponseEntity.noContent().build();
		}
		return responseEntity;
	}

	// POST http://localhost:8081/api/v1
	@PostMapping
	public ResponseEntity<?> insertarEmpleado(@RequestBody Empleado empleado) {
		ResponseEntity<?> responseEntity = null;
		Empleado empleadoNuevo = null;
		empleadoNuevo = this.empleadoService.altaEmpleado(empleado);
		responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(empleadoNuevo);

		return responseEntity;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> ModificarEmpleado(@RequestBody Empleado empelado, @PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Optional<Empleado> opRest = null;
		opRest = this.empleadoService.modificarEmpleado(id, empelado);
		if (opRest.isPresent()) {
			Empleado rm = opRest.get();
			responseEntity = ResponseEntity.ok(rm);
		} else {
			// devuelve un 400
			responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return responseEntity;
	}

	//// DELETE http://localhost:8081/api/v1/3
	@DeleteMapping("/{id}")
	public ResponseEntity<?> BorrarPorId(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		this.empleadoService.borrarEmpleado(id);
		responseEntity = ResponseEntity.ok().build();
		System.err.println(responseEntity);
		return responseEntity;
	}

}
