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

import com.example.demo.dto.Asignado;
import com.example.demo.service.AsignadoServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoController {

	@Autowired
	AsignadoServiceImpl asignadoServiceImpl;
	
	@GetMapping("/asignado")
	public List<Asignado> listarAsignado(){
		return asignadoServiceImpl.listarAsignado();
	}
	
	
	@PostMapping("/asignado")
	public Asignado salvarAsignado(@RequestBody Asignado asignado) {
		
		return asignadoServiceImpl.guardarAsignado(asignado);
	}
	
	
	@GetMapping("/asignado/{id}")
	public Asignado Asignado(@PathVariable(name="id") int id) {
		
		Asignado Asignado = new Asignado();
		
		Asignado = asignadoServiceImpl.asignado(id);
		
		return Asignado;
	}
	
	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name="id")int id,@RequestBody Asignado asignado) {
		
		Asignado Asignadoseleccionado= new Asignado();
		Asignado Asignadoactualizado= new Asignado();
		
		Asignadoseleccionado = asignadoServiceImpl.asignado(id);
		
		
		Asignadoseleccionado.setCientificos(asignado.getCientificos());
		Asignadoseleccionado.setProyecto(asignado.getProyecto());
		
		Asignadoactualizado = asignadoServiceImpl.actualizarAsignado(Asignadoseleccionado);
		
		System.out.println("El asignado actualizado es: "+ Asignadoactualizado);
		
		return Asignadoactualizado;
	}
	
	@DeleteMapping("/asignado/{id}")
	public void eleiminarAsignado(@PathVariable(name="id")int id) {
		asignadoServiceImpl.eliminarAsignado(id);
	}
}