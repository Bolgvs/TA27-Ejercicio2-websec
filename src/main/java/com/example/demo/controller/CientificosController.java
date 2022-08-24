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

import com.example.demo.dto.Cientificos;
import com.example.demo.service.CientificosServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificosController {

	@Autowired
	CientificosServiceImpl cientificosServiceImpl;
	
	@GetMapping("/cientificos")
	public List<Cientificos> listarCientificos(){
		return cientificosServiceImpl.listarCientificos();
	}
	
	
	@PostMapping("/cientificos")
	public Cientificos salvarCientificos(@RequestBody Cientificos cientificos) {
		
		return cientificosServiceImpl.guardarCientificos(cientificos);
	}
	
	
	@GetMapping("/cientificos/{id}")
	public Cientificos CientificosXID(@PathVariable(name="id") int id) {
		
		Cientificos Cientificos = new Cientificos();
		
		Cientificos = cientificosServiceImpl.cientificos(id);
		
		return Cientificos;
	}
	
	@PutMapping("/cientificos/{id}")
	public Cientificos actualizarCientificos(@PathVariable(name="id")int id,@RequestBody Cientificos Cientificos) {
		
		Cientificos Cientificosseleccionado = new Cientificos();
		Cientificos Cientificosactualizado = new Cientificos();
		
		Cientificosseleccionado = cientificosServiceImpl.cientificos(id);
		
		Cientificosseleccionado.setDni(Cientificos.getDni());
		Cientificosseleccionado.setNomApels(Cientificos.getNomApels());
		Cientificosseleccionado.setAsignado(Cientificos.getAsignado());
		
		Cientificosactualizado = cientificosServiceImpl.actualizarCientificos(Cientificosseleccionado);
		
		return Cientificosactualizado;
	}
	
	@DeleteMapping("/cientificos/{id}")
	public void eleiminarCientificos(@PathVariable(name="id")int id) {
		cientificosServiceImpl.eliminarCientificos(id);
	}
}
