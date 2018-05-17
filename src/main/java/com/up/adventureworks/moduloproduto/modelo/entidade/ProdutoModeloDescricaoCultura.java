package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ProdutoModeloDescricaoCultura")
public class ProdutoModeloDescricaoCultura implements Serializable{

	private static final long serialVersionUID = 1L;

	@Embeddable
	public static class IDComposto implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@Column(name="ModeloProdutoId;")
		private int ModeloProdutoId;
		
		@Column(name="DescricaoProdutoId")
		private int DescricaoProdutoId;
		
		@Column(name="CulturaId",columnDefinition="char(6)")
		private char CulturaId;
	}
	@EmbeddedId
	private IDComposto id;
	
	@ManyToOne
	@MapsId("ModeloProdutoId")
	@JoinColumn(name="Descricao_Produto_id")
	private DescricaoProduto DescricaoProduto;
	
	@ManyToOne
	@MapsId("DescricaoProdutoId")
	@JoinColumn(name="Modelo_Produto_id")
	private ModeloProduto ModeloProduto;
	
	@ManyToOne
	@MapsId("CulturaId")
	@JoinColumn(name="Cultura_Id",columnDefinition="char(6)")
	private Cultura Cultura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;

	public ProdutoModeloDescricaoCultura() {
		super();
	}

	public ProdutoModeloDescricaoCultura(IDComposto id,
			com.up.adventureworks.moduloproduto.modelo.entidade.DescricaoProduto descricaoProduto,
			com.up.adventureworks.moduloproduto.modelo.entidade.ModeloProduto modeloProduto,
			com.up.adventureworks.moduloproduto.modelo.entidade.Cultura cultura, Date dataModificacao) {
		super();
		this.id = id;
		DescricaoProduto = descricaoProduto;
		ModeloProduto = modeloProduto;
		Cultura = cultura;
		DataModificacao = dataModificacao;
	}

	public IDComposto getId() {
		return id;
	}

	public void setId(IDComposto id) {
		this.id = id;
	}

	public DescricaoProduto getDescricaoProduto() {
		return DescricaoProduto;
	}

	public void setDescricaoProduto(DescricaoProduto descricaoProduto) {
		DescricaoProduto = descricaoProduto;
	}

	public ModeloProduto getModeloProduto() {
		return ModeloProduto;
	}

	public void setModeloProduto(ModeloProduto modeloProduto) {
		ModeloProduto = modeloProduto;
	}

	public Cultura getCultura() {
		return Cultura;
	}

	public void setCultura(Cultura cultura) {
		Cultura = cultura;
	}

	public Date getDataModificacao() {
		return DataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		DataModificacao = dataModificacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cultura == null) ? 0 : Cultura.hashCode());
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((DescricaoProduto == null) ? 0 : DescricaoProduto.hashCode());
		result = prime * result + ((ModeloProduto == null) ? 0 : ModeloProduto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProdutoModeloDescricaoCultura other = (ProdutoModeloDescricaoCultura) obj;
		if (Cultura == null) {
			if (other.Cultura != null)
				return false;
		} else if (!Cultura.equals(other.Cultura))
			return false;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (DescricaoProduto == null) {
			if (other.DescricaoProduto != null)
				return false;
		} else if (!DescricaoProduto.equals(other.DescricaoProduto))
			return false;
		if (ModeloProduto == null) {
			if (other.ModeloProduto != null)
				return false;
		} else if (!ModeloProduto.equals(other.ModeloProduto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
}
