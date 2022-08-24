package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Asignado;

public interface IAsignadoService {
	
	public List<Asignado> listarAsignado();
	
	public Asignado guardarAsignado(Asignado asignado);
	
	public Asignado asignado(int id);
	
	public Asignado actualizarAsignado(Asignado asignado);
	
	public void eliminarAsignado(int id);
	
}
