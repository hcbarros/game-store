package br.com.supera.game.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O CEP não deve ser nulo!")
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato do CEP inválido!")
	private String cep;
	
	@NotNull(message = "A rua não deve ser nula!")
	@NotBlank(message = "A rua não deve estar em branco!")
	@Size(max = 120, message = "A rua deve possuir no máximo 120 caracteres!")
	private String rua;
	
	@Pattern(regexp = "[0-9]+", message = "O número deve conter apenas dígitos!")
	private String numero;
	
	@Size(max = 50, message = "O complemento deve possuir no máximo 50 caracteres!")
	private String complemento;
	
	@Size(max = 100, message = "O bairro deve possuir no máximo 100 caracteres!")
	private String bairro;
	
	@NotNull(message = "A cidade não deve ser nula!")
	@NotBlank(message = "A cidade não deve estar em branco!")
	private String cidade;
	
	@NotNull(message = "O estado não deve ser nulo!")
	@NotBlank(message = "O estado não deve estar em branco!")
	private String estado;
	
	
	public Endereco(String cep, String rua, String numero, String complemento, 
					String bairro, String cidade, String estado) {

		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco() {
		
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

}
