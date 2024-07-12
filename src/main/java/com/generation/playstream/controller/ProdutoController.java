package com.generation.playstream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.playstream.model.Produto;
import com.generation.playstream.repository.IProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private IProdutoRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id){
		return produtosRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
				
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produto>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(produtosRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtosRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){
		return produtosRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(produtosRepository.save(produto)))
						.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
}
