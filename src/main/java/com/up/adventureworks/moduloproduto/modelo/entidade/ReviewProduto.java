package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.util.Date;

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

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="ReviewProduto")
public class ReviewProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int AvaliacaoProdutoId;
	
	@ManyToOne
	@JoinColumn(name="Produto_Id")
	private Produto ProdutoId;
	
	@NotBlank(message="O nome do avaliador não pode ser em branco!")
	@NotNull(message="O nome do avaliador não pode ser nulo!")
	@Size(max=100,message="O nome do avaliador não pode ter mais que {max} caracteres!")
	@Column(name="NomeAvaliador", length = 100, nullable = false)
	private String NomeAvaliador;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataAvaliacao;
	
	@NotBlank(message="O email do avaliador não pode ser em branco!")
	@NotNull(message="O email do avaliador não pode ser nulo!")
	@Size(max=50,message="O email do avaliador não pode ter mais que {max} caracteres!")
	@Column(name="Email", length = 50, nullable = false)
	private String Email;
	
	@Column(name="Avaliacao")
	@Range(min=1,max=5)
	private int Avaliacao;
	
	@Column(name="Comentarios", length = 3850)
	@Size(max=3850,message="O comentário não pode ter mais que {max} caracteres!")
	private String Comentarios;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;

	public ReviewProduto() {
		super();
	}

	public ReviewProduto(Produto produtoId,
			@NotBlank(message = "O nome do avaliador não pode ser em branco!") @NotNull(message = "O nome do avaliador não pode ser nulo!") @Size(max = 100, message = "O nome do avaliador não pode ter mais que {max} caracteres!") String nomeAvaliador,
			Date dataAvaliacao,
			@NotBlank(message = "O email do avaliador não pode ser em branco!") @NotNull(message = "O email do avaliador não pode ser nulo!") @Size(max = 50, message = "O email do avaliador não pode ter mais que {max} caracteres!") String email,
			@Range(min = 1, max = 5) int avaliacao,
			@Size(max = 3850, message = "O comentário não pode ter mais que {max} caracteres!") String comentarios,
			Date dataModificacao) {
		super();
		ProdutoId = produtoId;
		NomeAvaliador = nomeAvaliador;
		DataAvaliacao = dataAvaliacao;
		Email = email;
		Avaliacao = avaliacao;
		Comentarios = comentarios;
		DataModificacao = dataModificacao;
	}

	public int getAvaliacaoProdutoId() {
		return AvaliacaoProdutoId;
	}

	public void setAvaliacaoProdutoId(int avaliacaoProdutoId) {
		AvaliacaoProdutoId = avaliacaoProdutoId;
	}

	public Produto getProdutoId() {
		return ProdutoId;
	}

	public void setProdutoId(Produto produtoId) {
		ProdutoId = produtoId;
	}

	public String getNomeAvaliador() {
		return NomeAvaliador;
	}

	public void setNomeAvaliador(String nomeAvaliador) {
		NomeAvaliador = nomeAvaliador;
	}

	public Date getDataAvaliacao() {
		return DataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		DataAvaliacao = dataAvaliacao;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getAvaliacao() {
		return Avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		Avaliacao = avaliacao;
	}

	public String getComentarios() {
		return Comentarios;
	}

	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
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
		result = prime * result + Avaliacao;
		result = prime * result + AvaliacaoProdutoId;
		result = prime * result + ((Comentarios == null) ? 0 : Comentarios.hashCode());
		result = prime * result + ((DataAvaliacao == null) ? 0 : DataAvaliacao.hashCode());
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((NomeAvaliador == null) ? 0 : NomeAvaliador.hashCode());
		result = prime * result + ((ProdutoId == null) ? 0 : ProdutoId.hashCode());
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
		ReviewProduto other = (ReviewProduto) obj;
		if (Avaliacao != other.Avaliacao)
			return false;
		if (AvaliacaoProdutoId != other.AvaliacaoProdutoId)
			return false;
		if (Comentarios == null) {
			if (other.Comentarios != null)
				return false;
		} else if (!Comentarios.equals(other.Comentarios))
			return false;
		if (DataAvaliacao == null) {
			if (other.DataAvaliacao != null)
				return false;
		} else if (!DataAvaliacao.equals(other.DataAvaliacao))
			return false;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (NomeAvaliador == null) {
			if (other.NomeAvaliador != null)
				return false;
		} else if (!NomeAvaliador.equals(other.NomeAvaliador))
			return false;
		if (ProdutoId == null) {
			if (other.ProdutoId != null)
				return false;
		} else if (!ProdutoId.equals(other.ProdutoId))
			return false;
		return true;
	}
	
	
	
}
