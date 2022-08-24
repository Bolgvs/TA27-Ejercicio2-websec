package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;

public interface IProyectoService {

			public List<Proyecto> listarProyecto();
			
			public Proyecto guardarProyecto(Proyecto proyecto);	
			
			public Proyecto proyecto(int id); 
			
			public Proyecto actualizarProyecto(Proyecto proyecto);
			
			public void eliminarProyecto(int id);
			
}