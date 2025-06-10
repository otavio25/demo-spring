package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Empresa;
import com.example.demo.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> findAll(){
		return repository.findAll();
	}
	
	public Empresa findById(Long id) {
	    Optional<Empresa> obj = repository.findById(id);
	    return obj.get();
	}
}
