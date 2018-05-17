package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Cultura")
public class Cultura {

	
	@Id
	@Column(columnDefinition="char(6)")
	private String CulturaId;
	
	@NotBlank(message="O nome não pode ser em branco!")
	@NotNull(message="O nome não pode ser nulo!")
	@Size(max=100,message="O nome não pode ter mais que {max} caracteres!")
	@Column(name="Nome", length = 100, nullable = false)
	private String Nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;
	
	@OneToMany(mappedBy = "Cultura")
    private Set<ProdutoModeloDescricaoCultura> produtomodelodescricaocultura = new HashSet<ProdutoModeloDescricaoCultura>();

	public Cultura() {
		super();
	}
	
	public Cultura(String culturaId,
			@NotBlank(message = "O nome não pode ser em branco!") @NotNull(message = "O nome não pode ser nulo!") @Size(max = 100, message = "O nome não pode ter mais que {max} caracteres!") String nome,
			Date dataModificacao) {
		super();
		CulturaId = culturaId;
		Nome = nome;
		DataModificacao = dataModificacao;
	}

	public String getCulturaId() {
		return CulturaId;
	}

	public void setCulturaId(String culturaId) {
		CulturaId = culturaId;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Date getDataModificacao() {
		return DataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		DataModificacao = dataModificacao;
	}

	public Set<ProdutoModeloDescricaoCultura> getProdutomodelodescricaocultura() {
		return produtomodelodescricaocultura;
	}

	public void setProdutomodelodescricaocultura(Set<ProdutoModeloDescricaoCultura> produtomodelodescricaocultura) {
		this.produtomodelodescricaocultura = produtomodelodescricaocultura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CulturaId == null) ? 0 : CulturaId.hashCode());
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result
				+ ((produtomodelodescricaocultura == null) ? 0 : produtomodelodescricaocultura.hashCode());
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
		Cultura other = (Cultura) obj;
		if (CulturaId == null) {
			if (other.CulturaId != null)
				return false;
		} else if (!CulturaId.equals(other.CulturaId))
			return false;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (produtomodelodescricaocultura == null) {
			if (other.produtomodelodescricaocultura != null)
				return false;
		} else if (!produtomodelodescricaocultura.equals(other.produtomodelodescricaocultura))
			return false;
		return true;
	}

	
	
	
}
