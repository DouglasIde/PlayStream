package com.generation.playstream.model;

import java.time.LocalDate;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Título é OBRIGATÓRIO!!")
	@Size(min = 2, max = 100, message = "O atributo TÍTULO deve conter entre 1 - 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O atributo Descrição é OBRIGATÓRIO!!")
	@Size(min = 15, max = 500, message = "O atributo de descrição deve conter entre 15 - 500 caracteres")
	private String descricao;
	
	@NotBlank(message = "O atributo Desenvolvedor é OBRIGATÓRIO!!")
	@Size(min = 3, max = 100, message = "O atributo Desenvolvedor deve conter entre 3 - 100 caracteres")
	private String desenvolvedor;
	
	@NotNull(message = "O atributo Data de Lançamento é OBRIGATÓRIO!!")
	@Column(name = "data_lancamento", nullable = false)
	private LocalDate dataLancamento;
	
	@NotNull(message = "O atributo Preço é OBRIGATÓRIO!!")
	@NumberFormat(pattern = "#.###.##")
	private float  preco;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
