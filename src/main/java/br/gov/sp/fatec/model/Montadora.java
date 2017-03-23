package br.gov.sp.fatec.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "MON_MONTADORA")
public class Montadora {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "MON_ID")
	private Long id;

	@Column(name = "MON_NOME", unique = false, length = 20, nullable = false)
	private String nome;

	@Column(name = "MON_CNPJ", unique = true, length = 20, nullable = false)
	private Long cnpj;

	@Column(name = "MON_CIDADE", unique = false, length = 25, nullable = false)
	private String cidade;

	@Column(name = "MON_ESTADO", unique = false, length = 2, nullable = false)
	private String estado;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "montadora")
	private Collection<Veiculo> veiculos = new HashSet<Veiculo>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
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

	public void setVeiculos(HashSet<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
