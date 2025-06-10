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
	
	public Empresa insert(Empresa obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Empresa update(Long id, Empresa obj) {
		Empresa entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Empresa entity, Empresa obj) {
		entity.setNome_empresa(obj.getNome_empresa());
	}
}
