package com.generation.playstream.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "O atributo Data de Lançamento é OBRIGATÓRIO!!")
	@Column(name = "data_lancamento", nullable = false)
	private LocalDate dataLancamento;
	
	@NotBlank(message = "O atributo Preço é OBRIGATÓRIO!!")
	@Digits(integer = 10000, fraction = 2, message = "O preço deve ser um valor numérico com até 10000 dígitos inteiros e 2 decimais")
	private BigDecimal preco;
	
}
