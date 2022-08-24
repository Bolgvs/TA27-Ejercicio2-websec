package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Cientificos;

public interface ICientificosDAO extends JpaRepository<Cientificos, Integer> {
	 
}