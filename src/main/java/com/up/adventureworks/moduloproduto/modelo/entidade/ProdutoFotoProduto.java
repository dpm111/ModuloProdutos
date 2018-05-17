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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Produto_Foto_Produto")
public class ProdutoFotoProduto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Embeddable
	public static class IDComposto implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name="Produto_Id;")
		private int ProdutoId;
		
		@Column(name="Foto_Produto_id")
		private int FotoProdutoId;
	}
	@EmbeddedId
	private IDComposto id;
	
	@ManyToOne
	@MapsId("ProdutoId")
	@JoinColumn(name="Produto_Id")
	private Produto Produto;
	
	@ManyToOne
	@MapsId("FotoProdutoId")
	@JoinColumn(name="Foto_Produto_id")
	private FotoProduto FotoProduto;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Column(name="Primario",columnDefinition = "TINYINT(1)")
	private boolean Primario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;

	public ProdutoFotoProduto() {
		super();
	}

	public ProdutoFotoProduto(IDComposto id, com.up.adventureworks.moduloproduto.modelo.entidade.Produto produto,
			com.up.adventureworks.moduloproduto.modelo.entidade.FotoProduto fotoProduto,
			@NotNull(message = "O campo não pode ser nulo!") boolean primario, Date dataModificacao) {
		super();
		this.id = id;
		Produto = produto;
		FotoProduto = fotoProduto;
		Primario = primario;
		DataModificacao = dataModificacao;
	}

	public IDComposto getId() {
		return id;
	}

	public void setId(IDComposto id) {
		this.id = id;
	}

	public Produto getProduto() {
		return Produto;
	}

	public void setProduto(Produto produto) {
		Produto = produto;
	}

	public FotoProduto getFotoProduto() {
		return FotoProduto;
	}

	public void setFotoProduto(FotoProduto fotoProduto) {
		FotoProduto = fotoProduto;
	}

	public boolean isPrimario() {
		return Primario;
	}

	public void setPrimario(boolean primario) {
		Primario = primario;
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
		result = prime * result + ((FotoProduto == null) ? 0 : FotoProduto.hashCode());
		result = prime * result + (Primario ? 1231 : 1237);
		result = prime * result + ((Produto == null) ? 0 : Produto.hashCode());
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
		ProdutoFotoProduto other = (ProdutoFotoProduto) obj;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (FotoProduto == null) {
			if (other.FotoProduto != null)
				return false;
		} else if (!FotoProduto.equals(other.FotoProduto))
			return false;
		if (Primario != other.Primario)
			return false;
		if (Produto == null) {
			if (other.Produto != null)
				return false;
		} else if (!Produto.equals(other.Produto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
