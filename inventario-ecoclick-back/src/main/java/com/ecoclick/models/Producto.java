package com.ecoclick.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import com.ecoclick.models.Producto;

@Entity
@Table(name = "producto")
@Data
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private int id_producto;

	@Column(name = "nombre_producto")
	private String nombre;
	
	@Column(name = "descripcion_producto")
	private String descripcion;

    @Column(name = "precio")
	private int precio;

    @Column(name = "unidades")
	private int unidades;

	//Relaciones
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "productos")
	private List<Bodega> bodegas;

	@ManyToOne(optional=true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
}