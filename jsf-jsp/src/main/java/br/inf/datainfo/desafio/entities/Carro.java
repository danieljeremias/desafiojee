package br.inf.datainfo.desafio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.inf.datainfo.desafio.core.entities.AbstractEntity;

@Entity
public class Carro implements AbstractEntity<Integer> {

	private static final long serialVersionUID = 1091142526548579487L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private Integer ano;
	private String cor;
	private Double preco;
	private Boolean vendido;

	public Carro() {

	}

	public Carro(Integer id, String marca, Integer ano, String cor, Double preco, Boolean vendido) {
		super();
		this.id = id;
		this.marca = marca;
		this.ano = ano;
		this.cor = cor;
		this.preco = preco;
		this.vendido = vendido;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((vendido == null) ? 0 : vendido.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
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
		Carro other = (Carro) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		if (vendido == null) {
			if (other.vendido != null)
				return false;
		} else if (!vendido.equals(other.vendido))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carro [id=");
		builder.append(id);
		builder.append(", ano=");
		builder.append(ano);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", cor=");
		builder.append(cor);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", vendido=");
		builder.append(vendido);
		builder.append("]");
		return builder.toString();
	}

}
