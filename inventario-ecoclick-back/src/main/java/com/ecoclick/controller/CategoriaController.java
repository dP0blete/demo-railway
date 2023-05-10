package com.ecoclick.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecoclick.models.Categoria;
import com.ecoclick.services.interfaces.ICategoria;

@RestController
public class CategoriaController {
    @Autowired
	ICategoria categoriaService;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/categorias", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> getCategorias(){
		List<Categoria> categorias = categoriaService.getAllCategorias();
		if(categorias != null) {
			return ResponseEntity.ok(categorias);
		}
		return ResponseEntity.notFound().build();
	}

    @CrossOrigin(origins = "*")
	@GetMapping(value = "/categorias/{id_categoria}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id_categoria){
		Optional<Categoria> categoria = categoriaService.getCategoriaById(id_categoria);
		try {
			if(categoria.isPresent()) {
				return ResponseEntity.ok(categoria.get());
			}
			return ResponseEntity.notFound().build();
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/categorias/{id_categoria}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> deleteCategoria(@PathVariable int id_categoria){
		try {
			categoriaService.deleteCategoria(id_categoria);
			return ResponseEntity.ok().build();
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
}
