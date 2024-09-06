package com.gestion.empleados.repositorio.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados1")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	@Column(name = "apellido", length = 50, nullable = false)
	private String apellido;
	@Column(name = "email", length = 70, nullable = false, unique = true)
	private String email;	
	@Column(name = "creado_en")
	private LocalDateTime creadoEn;
	
	public Empleado() {
		super();
	}

	public Empleado(Long id, String nombre, String apellido, String email, LocalDateTime creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.creadoEn=creadoEn;
	}
	
	
	//un colbac lo llama el navegador al metodo
	@PrePersist //este metodo marcado asi, se ejecuta antes de insertar
	private void generarFechaCreacion() {
		this.creadoEn= LocalDateTime.now();		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	 public static String getFechaHoraActualFormateada() {
	        String patronFormato = "dd/MM/yyyy HH:mm:ss:SSSS";
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern(patronFormato);
	        LocalDateTime ahora = LocalDateTime.now();
	        return ahora.format(formato);
	    }

	    public static String mostrarHora() {
	        //obtener la hora actual
	        LocalTime hora = LocalTime.now();
	        //crear un formateador con el patrón "HH:mm:ss"
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
	        //formatear la hora actual utilizando el formateador
	        String hora_formato = hora.format(formato);
	        return hora_formato;
	    }
	
	
	
}
