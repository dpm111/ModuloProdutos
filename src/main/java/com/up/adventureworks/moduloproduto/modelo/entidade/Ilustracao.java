package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Ilustracao")
public class Ilustracao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IlustracaoId;
	
	//XML
	@Column(name="Diagrama",columnDefinition = "TEXT")
	private String Diagrama;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;
	
	@OneToMany(mappedBy = "IlustracaoProduto")
    private Set<ProdutoIlustracaoModelo> produtoilustracaomodelo = new HashSet<ProdutoIlustracaoModelo>();

	public Ilustracao() {
		super();
	}

	public Ilustracao(String diagrama, Date dataModificacao) {
		super();
		Diagrama = diagrama;
		DataModificacao = dataModificacao;
	}

	public int getIlustracaoId() {
		return IlustracaoId;
	}

	public void setIlustracaoId(int ilustracaoId) {
		IlustracaoId = ilustracaoId;
	}

	public String getDiagrama() {
		return Diagrama;
	}

	public void setDiagrama(String diagrama) {
		Diagrama = diagrama;
	}

	public Date getDataModificacao() {
		return DataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		DataModificacao = dataModificacao;
	}

	public Set<ProdutoIlustracaoModelo> getProdutoilustracaomodelo() {
		return produtoilustracaomodelo;
	}

	public void setProdutoilustracaomodelo(Set<ProdutoIlustracaoModelo> produtoilustracaomodelo) {
		this.produtoilustracaomodelo = produtoilustracaomodelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((Diagrama == null) ? 0 : Diagrama.hashCode());
		result = prime * result + IlustracaoId;
		result = prime * result + ((produtoilustracaomodelo == null) ? 0 : produtoilustracaomodelo.hashCode());
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
		Ilustracao other = (Ilustracao) obj;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (Diagrama == null) {
			if (other.Diagrama != null)
				return false;
		} else if (!Diagrama.equals(other.Diagrama))
			return false;
		if (IlustracaoId != other.IlustracaoId)
			return false;
		if (produtoilustracaomodelo == null) {
			if (other.produtoilustracaomodelo != null)
				return false;
		} else if (!produtoilustracaomodelo.equals(other.produtoilustracaomodelo))
			return false;
		return true;
	}
	
	
}