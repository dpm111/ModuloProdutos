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
@Table(name="DocumentoProduto")
public class DocumentoProduto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Embeddable
	public static class IDComposto implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name="Produto_Id;")
		private int ProdutoId;
		
		@Column(name="Documento_Node")
		private char DocumentoNode;
	}
	@EmbeddedId
	private IDComposto id;
	
	@ManyToOne
	@MapsId("ProdutoId")
	@JoinColumn(name="Produto_Id")
	private Produto Produto;
	
	@ManyToOne
	@MapsId("DocumentoNode")
	@JoinColumn(name="Documento_Node")
	private Documento Documento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;

	public DocumentoProduto() {
		super();
	}

	public DocumentoProduto(IDComposto id, com.up.adventureworks.moduloproduto.modelo.entidade.Produto produto,
			com.up.adventureworks.moduloproduto.modelo.entidade.Documento documento, Date dataModificacao) {
		super();
		this.id = id;
		Produto = produto;
		Documento = documento;
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

	public Documento getDocumento() {
		return Documento;
	}

	public void setDocumento(Documento documento) {
		Documento = documento;
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
		result = prime * result + ((Documento == null) ? 0 : Documento.hashCode());
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
		DocumentoProduto other = (DocumentoProduto) obj;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (Documento == null) {
			if (other.Documento != null)
				return false;
		} else if (!Documento.equals(other.Documento))
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
