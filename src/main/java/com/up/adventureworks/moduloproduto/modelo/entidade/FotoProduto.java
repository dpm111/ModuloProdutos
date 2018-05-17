package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FotoProduto")
public class FotoProduto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int FotoProdutoId;
	
	@Lob
	@Column(name="MiniaturaFoto", length=100000, nullable = true)
	private byte MiniaturaFoto;
	
	@Column(name="NomeMiniaturaFoto", length = 50, nullable = true)
	private String NomeMiniaturaFoto;
	
	@Lob
	@Column(name="FotoGrande", length=100000, nullable = true)
	private byte FotoGrande;
	
	@Column(name="NomeFotoGrande", length = 50, nullable = true)
	private String NomeFotoGrande;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;
	
	@OneToMany(mappedBy = "FotoProduto")
    private Set<ProdutoFotoProduto> produtofotoproduto = new HashSet<ProdutoFotoProduto>();

	public FotoProduto() {
		super();
	}

	public FotoProduto(int fotoProdutoId, byte miniaturaFoto, String nomeMiniaturaFoto, byte fotoGrande,
			String nomeFotoGrande, Date dataModificacao, Set<ProdutoFotoProduto> produtofotoproduto) {
		super();
		FotoProdutoId = fotoProdutoId;
		MiniaturaFoto = miniaturaFoto;
		NomeMiniaturaFoto = nomeMiniaturaFoto;
		FotoGrande = fotoGrande;
		NomeFotoGrande = nomeFotoGrande;
		DataModificacao = dataModificacao;
		this.produtofotoproduto = produtofotoproduto;
	}

	public int getFotoProdutoId() {
		return FotoProdutoId;
	}

	public void setFotoProdutoId(int fotoProdutoId) {
		FotoProdutoId = fotoProdutoId;
	}

	public byte getMiniaturaFoto() {
		return MiniaturaFoto;
	}

	public void setMiniaturaFoto(byte miniaturaFoto) {
		MiniaturaFoto = miniaturaFoto;
	}

	public String getNomeMiniaturaFoto() {
		return NomeMiniaturaFoto;
	}

	public void setNomeMiniaturaFoto(String nomeMiniaturaFoto) {
		NomeMiniaturaFoto = nomeMiniaturaFoto;
	}

	public byte getFotoGrande() {
		return FotoGrande;
	}

	public void setFotoGrande(byte fotoGrande) {
		FotoGrande = fotoGrande;
	}

	public String getNomeFotoGrande() {
		return NomeFotoGrande;
	}

	public void setNomeFotoGrande(String nomeFotoGrande) {
		NomeFotoGrande = nomeFotoGrande;
	}

	public Date getDataModificacao() {
		return DataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		DataModificacao = dataModificacao;
	}

	public Set<ProdutoFotoProduto> getProdutofotoproduto() {
		return produtofotoproduto;
	}

	public void setProdutofotoproduto(Set<ProdutoFotoProduto> produtofotoproduto) {
		this.produtofotoproduto = produtofotoproduto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + FotoGrande;
		result = prime * result + FotoProdutoId;
		result = prime * result + MiniaturaFoto;
		result = prime * result + ((NomeFotoGrande == null) ? 0 : NomeFotoGrande.hashCode());
		result = prime * result + ((NomeMiniaturaFoto == null) ? 0 : NomeMiniaturaFoto.hashCode());
		result = prime * result + ((produtofotoproduto == null) ? 0 : produtofotoproduto.hashCode());
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
		FotoProduto other = (FotoProduto) obj;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (FotoGrande != other.FotoGrande)
			return false;
		if (FotoProdutoId != other.FotoProdutoId)
			return false;
		if (MiniaturaFoto != other.MiniaturaFoto)
			return false;
		if (NomeFotoGrande == null) {
			if (other.NomeFotoGrande != null)
				return false;
		} else if (!NomeFotoGrande.equals(other.NomeFotoGrande))
			return false;
		if (NomeMiniaturaFoto == null) {
			if (other.NomeMiniaturaFoto != null)
				return false;
		} else if (!NomeMiniaturaFoto.equals(other.NomeMiniaturaFoto))
			return false;
		if (produtofotoproduto == null) {
			if (other.produtofotoproduto != null)
				return false;
		} else if (!produtofotoproduto.equals(other.produtofotoproduto))
			return false;
		return true;
	}
	
	
}
