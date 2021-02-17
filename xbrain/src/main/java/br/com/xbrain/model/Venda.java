package br.com.xbrain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "Venda")
public class Venda {

	@Id
	@Column(name = "vendaId")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key, Auto Increment
	private Long idVenda;
	
	@Column(name = "vendaValor", nullable = false)
	private double valor;
	
	@Column(name = "vendaData")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dataVenda;
	
	@ManyToOne
	@JoinColumn(name = "vendaVendedor") // Foreign Key
	private Vendedor vendedor;

	public Venda(){}
	
	public Venda(Long idVenda, double valor, Date dataVenda, Vendedor vendedor){
		super();
		this.idVenda = idVenda;
		this.valor = valor;
		this.dataVenda = dataVenda;
		this.vendedor = vendedor;
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataVenda == null) ? 0 : dataVenda.hashCode());
		result = prime * result + ((idVenda == null) ? 0 : idVenda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (dataVenda == null) {
			if (other.dataVenda != null)
				return false;
		} else if (!dataVenda.equals(other.dataVenda))
			return false;
		if (idVenda == null) {
			if (other.idVenda != null)
				return false;
		} else if (!idVenda.equals(other.idVenda))
			return false;
		return true;
	}
}
