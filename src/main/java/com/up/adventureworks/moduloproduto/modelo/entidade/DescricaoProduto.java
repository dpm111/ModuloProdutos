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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="DescricaoProduto")
public class DescricaoProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int DescricaoProdutoId;
	
	@NotBlank(message="A descrição não pode ser em branco!")
	@NotNull(message="A descrição não pode ser nula!")
	@Size(max=400,message="A descrição não pode ter mais que {max} caracteres!")
	@Column(name="Descricao", length = 400, nullable = false)
	private String Descricao;
	
	@Column(nullable = false, length= 64)
	private String RowGuide;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;
	
	@OneToMany(mappedBy = "DescricaoProduto")
    private Set<ProdutoModeloDescricaoCultura> produtomodelodescricaocultura = new HashSet<ProdutoModeloDescricaoCultura>();

	public DescricaoProduto() {
		super();
	}

	public DescricaoProduto(@NotBlank(message = "A descrição não pode ser em branco!") @NotNull(message = "A descrição não pode ser nula!") @Size(max = 400, message = "A descrição não pode ter mais que {max} caracteres!") String descricao,
			String rowGuide, Date dataModificacao) {
		super();
		Descricao = descricao;
		RowGuide = rowGuide;
		DataModificacao = dataModificacao;
	}

	public int getDescricaoProdutoId() {
		return DescricaoProdutoId;
	}

	public void setDescricaoProdutoId(int descricaoProdutoId) {
		DescricaoProdutoId = descricaoProdutoId;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getRowGuide() {
		return RowGuide;
	}

	public void setRowGuide(String rowGuide) {
		RowGuide = rowGuide;
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
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((Descricao == null) ? 0 : Descricao.hashCode());
		result = prime * result + DescricaoProdutoId;
		result = prime * result + ((RowGuide == null) ? 0 : RowGuide.hashCode());
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
		DescricaoProduto other = (DescricaoProduto) obj;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (Descricao == null) {
			if (other.Descricao != null)
				return false;
		} else if (!Descricao.equals(other.Descricao))
			return false;
		if (DescricaoProdutoId != other.DescricaoProdutoId)
			return false;
		if (RowGuide == null) {
			if (other.RowGuide != null)
				return false;
		} else if (!RowGuide.equals(other.RowGuide))
			return false;
		if (produtomodelodescricaocultura == null) {
			if (other.produtomodelodescricaocultura != null)
				return false;
		} else if (!produtomodelodescricaocultura.equals(other.produtomodelodescricaocultura))
			return false;
		return true;
	}
	
	
}
