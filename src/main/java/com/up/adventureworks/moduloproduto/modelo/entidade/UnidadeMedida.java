package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="UnidadeMedida")
public class UnidadeMedida {

	@Id
	@Column(columnDefinition="char(3)")
	private String UnidadeMedidaId;
	
	@NotBlank(message="O nome não pode ser em branco!")
	@NotNull(message="O nome não pode ser nulo!")
	@Size(max=100,message="O nome não pode ter mais que {max} caracteres!")
	@Column(name="Nome", length = 100, nullable = false)
	private String Nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;

	public UnidadeMedida() {
		super();
	}

	public UnidadeMedida(String unidadeMedidaId,
			@NotBlank(message = "O nome não pode ser em branco!") @NotNull(message = "O nome não pode ser nulo!") @Size(max = 100, message = "O nome não pode ter mais que {max} caracteres!") String nome,
			Date dataModificacao) {
		super();
		UnidadeMedidaId = unidadeMedidaId;
		Nome = nome;
		DataModificacao = dataModificacao;
	}

	public String getUnidadeMedidaId() {
		return UnidadeMedidaId;
	}

	public void setUnidadeMedidaId(String unidadeMedidaId) {
		UnidadeMedidaId = unidadeMedidaId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((UnidadeMedidaId == null) ? 0 : UnidadeMedidaId.hashCode());
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
		UnidadeMedida other = (UnidadeMedida) obj;
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
		if (UnidadeMedidaId == null) {
			if (other.UnidadeMedidaId != null)
				return false;
		} else if (!UnidadeMedidaId.equals(other.UnidadeMedidaId))
			return false;
		return true;
	}

	
	
}
