package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
	
	@GetMapping("/proyecto")
	public List<Proyecto> listarProyecto(){
		return proyectoServiceImpl.listarProyecto();
	}
	
	
	@PostMapping("/proyecto")
	public Proyecto salvarProyecto(@RequestBody Proyecto proyecto) {
		
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
	
	
	@GetMapping("/proyecto/{id}")
	public Proyecto Proyecto(@PathVariable(name="id") int id) {
		
		Proyecto Proyecto = new Proyecto();
		
		Proyecto = proyectoServiceImpl.proyecto(id);
		 
		return Proyecto;
	}
	
	@PutMapping("/proyecto/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")int id,@RequestBody Proyecto Proyecto) {
		
		Proyecto Proyectoseleccionado = new Proyecto();
		Proyecto Proyectoactualizado = new Proyecto();
		
		Proyectoseleccionado = proyectoServiceImpl.proyecto(id);
		
		Proyectoseleccionado.setNombre(Proyecto.getNombre());
		Proyectoseleccionado.setAsignado(Proyecto.getAsignado());
		Proyectoseleccionado.setHoras(Proyecto.getHoras());
		
		Proyectoactualizado = proyectoServiceImpl.actualizarProyecto(Proyectoseleccionado);
		
		return Proyectoactualizado;
	}
	
	@DeleteMapping("/proyecto/{id}")
	public void eleiminarProyecto(@PathVariable(name="id")int id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}
	
}