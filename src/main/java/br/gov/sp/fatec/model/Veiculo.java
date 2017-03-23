package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "VEI_VEICULO")
public class Veiculo {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "VEI_ID")
	private Long id;
	
	@Column(name = "VEI_MODELO", unique = false, length = 25, nullable = false)
	private String modelo;
	
	@Column(name = "VEI_VALOR", unique = false, length = 10, nullable = false)
	private double valor;
	
	@Column(name = "VEI_CHASSI", unique = true, length = 15, nullable = false)
	private long chassi;
	
	@ManyToOne
	@JoinColumn(name="MON_ID")
	private Montadora montadora;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getChassi() {
		return chassi;
	}

	public void setChassi(long chassi) {
		this.chassi = chassi;
	}

	public void setMontadora(Montadora montadora){
		this.montadora = montadora;
	}
	
	public Montadora getMontadora(){
		return this.montadora;
	}
}
