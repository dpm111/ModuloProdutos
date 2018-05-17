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
@Table(name="ModeloProduto")
public class ModeloProduto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ModeloProdutoId;
	
	@NotBlank(message="O nome não pode ser em branco!")
	@NotNull(message="O nome não pode ser nulo!")
	@Size(max=100,message="O nome não pode ter mais que {max} caracteres!")
	@Column(name="Nome", length = 100, nullable = false)
	private String Descricao;
	
	//XML
	@Column(nullable = true, columnDefinition = "TEXT")
	private String DescricaoCatalogo;
	
	//XML
	@Column(nullable = true, columnDefinition = "TEXT")
	private String Instrucoes;
	
	@Column(nullable = false, length=64)
	private String RowGuide;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;
	
	@OneToMany(mappedBy = "ModeloProduto")
    private Set<ProdutoIlustracaoModelo> produtoilustracaomodelo = new HashSet<ProdutoIlustracaoModelo>();
	
	@OneToMany(mappedBy = "ModeloProduto")
    private Set<ProdutoModeloDescricaoCultura> produtomodelodescricaocultura = new HashSet<ProdutoModeloDescricaoCultura>();

	public ModeloProduto() {
		super();
	}

	public ModeloProduto(@NotBlank(message = "O nome não pode ser em branco!") @NotNull(message = "O nome não pode ser nulo!") @Size(max = 100, message = "O nome não pode ter mais que {max} caracteres!") String descricao,
			String descricaoCatalogo, String instrucoes, String rowGuide, Date dataModificacao) {
		super();
		Descricao = descricao;
		DescricaoCatalogo = descricaoCatalogo;
		Instrucoes = instrucoes;
		RowGuide = rowGuide;
		DataModificacao = dataModificacao;
	}

	public int getModeloProdutoId() {
		return ModeloProdutoId;
	}

	public void setModeloProdutoId(int modeloProdutoId) {
		ModeloProdutoId = modeloProdutoId;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getDescricaoCatalogo() {
		return DescricaoCatalogo;
	}

	public void setDescricaoCatalogo(String descricaoCatalogo) {
		DescricaoCatalogo = descricaoCatalogo;
	}

	public String getInstrucoes() {
		return Instrucoes;
	}

	public void setInstrucoes(String instrucoes) {
		Instrucoes = instrucoes;
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

	public Set<ProdutoIlustracaoModelo> getProdutoilustracaomodelo() {
		return produtoilustracaomodelo;
	}

	public void setProdutoilustracaomodelo(Set<ProdutoIlustracaoModelo> produtoilustracaomodelo) {
		this.produtoilustracaomodelo = produtoilustracaomodelo;
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
		result = prime * result + ((DescricaoCatalogo == null) ? 0 : DescricaoCatalogo.hashCode());
		result = prime * result + ((Instrucoes == null) ? 0 : Instrucoes.hashCode());
		result = prime * result + ModeloProdutoId;
		result = prime * result + ((RowGuide == null) ? 0 : RowGuide.hashCode());
		result = prime * result + ((produtoilustracaomodelo == null) ? 0 : produtoilustracaomodelo.hashCode());
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
		ModeloProduto other = (ModeloProduto) obj;
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
		if (DescricaoCatalogo == null) {
			if (other.DescricaoCatalogo != null)
				return false;
		} else if (!DescricaoCatalogo.equals(other.DescricaoCatalogo))
			return false;
		if (Instrucoes == null) {
			if (other.Instrucoes != null)
				return false;
		} else if (!Instrucoes.equals(other.Instrucoes))
			return false;
		if (ModeloProdutoId != other.ModeloProdutoId)
			return false;
		if (RowGuide == null) {
			if (other.RowGuide != null)
				return false;
		} else if (!RowGuide.equals(other.RowGuide))
			return false;
		if (produtoilustracaomodelo == null) {
			if (other.produtoilustracaomodelo != null)
				return false;
		} else if (!produtoilustracaomodelo.equals(other.produtoilustracaomodelo))
			return false;
		if (produtomodelodescricaocultura == null) {
			if (other.produtomodelodescricaocultura != null)
				return false;
		} else if (!produtomodelodescricaocultura.equals(other.produtomodelodescricaocultura))
			return false;
		return true;
	}
	
	
	
}
