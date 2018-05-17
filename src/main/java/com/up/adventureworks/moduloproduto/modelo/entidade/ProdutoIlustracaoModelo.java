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
@Table(name="ProdutoIlustracaoModelo")
public class ProdutoIlustracaoModelo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Embeddable
	public static class IDComposto implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@Column(name="ModeloProdutoId;")
		private Long ModeloProdutoId;
		
		@Column(name="IlustracaoProdutoId")
		private Long IlustracaoProdutoId;

		public Long getModeloProdutoId() {
			return ModeloProdutoId;
		}

		public void setModeloProdutoId(Long modeloProdutoId) {
			ModeloProdutoId = modeloProdutoId;
		}

		public Long getIlustracaoProdutoId() {
			return IlustracaoProdutoId;
		}

		public void setIlustracaoProdutoId(Long ilustracaoProdutoId) {
			IlustracaoProdutoId = ilustracaoProdutoId;
		}
		
		
	}
	@EmbeddedId
	private IDComposto id;
	
	@ManyToOne
	@MapsId("ModeloProdutoId")
	@JoinColumn(name="ModeloProdutoId")
	private ModeloProduto ModeloProduto;
	
	@ManyToOne
	@MapsId("IlustracaoProdutoId")
	@JoinColumn(name="IlustracaoProdutoId")
	private Ilustracao IlustracaoProduto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;

	
	
	public ProdutoIlustracaoModelo() {
		super();
	}

	public ProdutoIlustracaoModelo(ModeloProduto modeloProduto,Ilustracao ilustracaoProduto, Date dataModificacao) {
		super();
		ModeloProduto = modeloProduto;
		IlustracaoProduto = ilustracaoProduto;
		DataModificacao = dataModificacao;
	}

	public IDComposto getId() {
		return id;
	}

	public void setId(IDComposto id) {
		this.id = id;
	}

	public ModeloProduto getModeloProduto() {
		return ModeloProduto;
	}

	public void setModeloProduto(ModeloProduto modeloProduto) {
		ModeloProduto = modeloProduto;
	}

	public Ilustracao getIlustracaoProduto() {
		return IlustracaoProduto;
	}

	public void setIlustracaoProduto(Ilustracao ilustracaoProduto) {
		IlustracaoProduto = ilustracaoProduto;
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
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((IlustracaoProduto == null) ? 0 : IlustracaoProduto.hashCode());
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
		ProdutoIlustracaoModelo other = (ProdutoIlustracaoModelo) obj;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (IlustracaoProduto == null) {
			if (other.IlustracaoProduto != null)
				return false;
		} else if (!IlustracaoProduto.equals(other.IlustracaoProduto))
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
