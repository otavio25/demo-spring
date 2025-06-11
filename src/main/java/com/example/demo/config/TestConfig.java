package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.DetalheProduto;
import com.example.demo.entities.Empresa;
import com.example.demo.entities.Produto;
import com.example.demo.repositories.EmpresaRepository;
import com.example.demo.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Produto p1 = new Produto(null, "Bola");
		Produto p2 = new Produto(null, "Lápis");
		Produto p3 = new Produto(null, "Borracha");
		Produto p4 = new Produto(null, "Caneta");
		
		Empresa e1 = new Empresa(null, "Microsoft");
		Empresa e2 = new Empresa(null, "Apple");
		Empresa e3 = new Empresa(null, "Nokia");
		Empresa e4 = new Empresa(null, "Samsung");
		
		empresaRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
		
		// Associa produtos às empresas
		p1.getEmpresas().add(e1);
		p2.getEmpresas().add(e2);
		p3.getEmpresas().add(e3);
		p4.getEmpresas().add(e4);
		
		// Salva os produtos já com os relacionamentos
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		// Cria e associa o detalhe do produto
		DetalheProduto dp1 = new DetalheProduto(null, "Material de couro", p1);
		p1.setDetalheproduto(dp1);
		
		// Atualiza o produto com o detalhe
		produtoRepository.save(p1);
	}
}
