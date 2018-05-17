package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CategoriaProduto")
public class CategoriaProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int CategoriaProdutoId;
	
	@NotBlank(message="O nome não pode ser em branco!")
	@NotNull(message="O nome não pode ser nulo!")
	@Size(max=100,message="O nome não pode ter mais que {max} caracteres!")
	@Column(name="Nome", length = 100, nullable = false)
	private String Nome;
	
	@Column(nullable = false,  length = 64)
	private String RowGuide;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;
	
	
	
	public CategoriaProduto() {
		super();
	}
	
	

	public CategoriaProduto(@NotBlank(message = "O nome não pode ser em branco!") @NotNull(message = "O nome não pode ser nulo!") @Size(max = 100, message = "O nome não pode ter mais que {max} caracteres!") String nome,
			String rowGuide, Date dataModificacao) {
		super();
		Nome = nome;
		RowGuide = rowGuide;
		DataModificacao = dataModificacao;
	}



	public int getCategoriaProdutoId() {
		return CategoriaProdutoId;
	}

	public void setCategoriaProdutoId(int categoriaProdutoId) {
		CategoriaProdutoId = categoriaProdutoId;
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
		result = prime * result + CategoriaProdutoId;
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((RowGuide == null) ? 0 : RowGuide.hashCode());
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
		CategoriaProduto other = (CategoriaProduto) obj;
		if (CategoriaProdutoId != other.CategoriaProdutoId)
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
		return true;
	}
	
	
	
	
}
