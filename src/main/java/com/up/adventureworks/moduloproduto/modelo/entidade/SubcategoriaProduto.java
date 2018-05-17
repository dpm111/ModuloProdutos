package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SubcategoriaProduto")
public class SubcategoriaProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SubcategoriaProdutoId;
	
	@NotNull(message="A categoria deve ser informada!")
	@ManyToOne
	@JoinColumn(name="LojaID")
	private CategoriaProduto CategoriaProduto;
	
	@NotBlank(message="O nome não pode ser em branco!")
	@NotNull(message="O nome não pode ser nulo!")
	@Size(max=100,message="O nome não pode ter mais que {max} caracteres!")
	@Column(name="Nome", length = 100, nullable = false)
	private String Nome;
	
	@Column(nullable = false, length=64)
	private String RowGuide;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;

	public SubcategoriaProduto() {
		super();
	}

	public SubcategoriaProduto(@NotNull(message = "A categoria deve ser informada!") @NotNull(message="A categoria deve ser informada!") CategoriaProduto categoriaproduto,
			@NotBlank(message = "O nome não pode ser em branco!") @NotNull(message = "O nome não pode ser nulo!") @Size(max = 100, message = "O nome não pode ter mais que {max} caracteres!") String nome,
			String rowGuide, Date dataModificacao) {
		super();
		CategoriaProduto = categoriaproduto;
		Nome = nome;
		RowGuide = rowGuide;
		DataModificacao = dataModificacao;
	}

	public SubcategoriaProduto(Optional<CategoriaProduto> cat,
			String string, String string2, java.sql.Date data) {
		// TODO Auto-generated constructor stub
	}

	public int getSubcategoriaProdutoId() {
		return SubcategoriaProdutoId;
	}

	public void setSubcategoriaProdutoId(int subcategoriaProdutoId) {
		SubcategoriaProdutoId = subcategoriaProdutoId;
	}

	public CategoriaProduto getCategoriaProduto() {
		return CategoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		CategoriaProduto = categoriaProduto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CategoriaProduto == null) ? 0 : CategoriaProduto.hashCode());
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((RowGuide == null) ? 0 : RowGuide.hashCode());
		result = prime * result + SubcategoriaProdutoId;
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
		SubcategoriaProduto other = (SubcategoriaProduto) obj;
		if (CategoriaProduto == null) {
			if (other.CategoriaProduto != null)
				return false;
		} else if (!CategoriaProduto.equals(other.CategoriaProduto))
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
		if (RowGuide == null) {
			if (other.RowGuide != null)
				return false;
		} else if (!RowGuide.equals(other.RowGuide))
			return false;
		if (SubcategoriaProdutoId != other.SubcategoriaProdutoId)
			return false;
		return true;
	}
	
	
}
