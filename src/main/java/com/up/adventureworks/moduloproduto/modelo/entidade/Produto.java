package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Produto")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ProdutoId;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Size(max=100,message="O nome não pode ter mais que {max} caracteres!")
	@Column(name="Nome", length = 100, nullable = false)
	private String Nome;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Size(max=25,message="O número do produto não pode ter mais que {max} caracteres!")
	@Column(name="NumeroProduto", length = 25, nullable = false)
	private String NumeroProduto;
	
	@Column(name="Marcar",columnDefinition="tinyint(1)", nullable = false)
	private byte Marcar;
	
	@Column(name="MarcarFinalizado",columnDefinition="tinyint(1)", nullable = false)
	private byte MarcarFinalizado;
	
	@Size(max=15,message="A cor do produto não pode ter mais que {max} caracteres!")
	@Column(name="Cor", length = 15, nullable = true)
	private String Cor;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Column(name="NivelSeguroStock", nullable = false)
	private short NivelSeguroStock;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Column(name="PontoReabastecimento", nullable = false)
	private short PontoReabastecimento;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Column(name="PrecoPadrao", precision=19, scale=4, nullable = false)
	private BigDecimal PrecoPadrao;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Column(name="PrecoVenda", precision=19, scale=4, nullable = false)
	private BigDecimal PrecoVenda;
	
	@Size(max=5,message="O tamanho não pode ter mais que {max} caracteres!")
	@Column(name="Tamanho", length = 5, nullable = true)
	private String Tamanho;
	
	@ManyToOne
	@JoinColumn(name="Unidade_Medida_Tamanho_Id", nullable = true)
	private UnidadeMedida CodigoUnidadeMedidaTamanho;
	
	@ManyToOne
	@JoinColumn(name="Unidade_Medida_Peso_Id", nullable = true)
	private UnidadeMedida CodigoUnidadeMedidaPeso;
	
	@Column(name="Peso", precision=8, scale=2, nullable = true)
	private BigDecimal Peso;
	
	@Column(name="DiasParaProduzir", nullable = false)
	private int DiasParaProduzir;
	
	@Size(max=2,message="A linha de producao não pode ter mais que {max} caracteres!")
	@Column(name="LinhaProducao", length = 2, nullable = true)
	private String LinhaProducao;
	
	@Size(max=2,message="A classe não pode ter mais que {max} caracteres!")
	@Column(name="Classe", length = 2, nullable = true)
	private String Classe;
	
	@Size(max=2,message="O estilo não pode ter mais que {max} caracteres!")
	@Column(name="Estilo", length = 2, nullable = true)
	private String Estilo;
	
	@ManyToOne
	@JoinColumn(name="Subcategoria_Produto_Id", nullable = true)
	private SubcategoriaProduto SubcategoriaProduto;
	
	@ManyToOne
	@JoinColumn(name="Modelo_Produto_id", nullable = true)
	private ModeloProduto ModeloProduto;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataInicioVenda;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date DataFimVenda;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date DataDiscontinuacao;
	
	@Column(nullable = false, length=64)
	private String RowGuide;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;
	
	@OneToMany(mappedBy = "Produto")
    private Set<ProdutoFotoProduto> produtofotoproduto = new HashSet<ProdutoFotoProduto>();

	public Produto() {
		super();
	}

	public Produto(@NotNull(message = "O campo não pode ser nulo!") @Size(max = 100, message = "O nome não pode ter mais que {max} caracteres!") String nome,
			@NotNull(message = "O campo não pode ser nulo!") @Size(max = 25, message = "O número do produto não pode ter mais que {max} caracteres!") String numeroProduto,
			byte marcar, byte marcarFinalizado,
			@NotNull(message = "O campo não pode ser nulo!") short nivelSeguroStock,
			@NotNull(message = "O campo não pode ser nulo!") short pontoReabastecimento,
			@NotNull(message = "O campo não pode ser nulo!") BigDecimal precoPadrao,
			@NotNull(message = "O campo não pode ser nulo!") BigDecimal precoVenda,
			int diasParaProduzir,Date dataInicioVenda,
			Date dataFimVenda, Date dataDiscontinuacao, String rowGuide, Date dataModificacao) {
		super();
		Nome = nome;
		NumeroProduto = numeroProduto;
		Marcar = marcar;
		MarcarFinalizado = marcarFinalizado;
		NivelSeguroStock = nivelSeguroStock;
		PontoReabastecimento = pontoReabastecimento;
		PrecoPadrao = precoPadrao;
		PrecoVenda = precoVenda;
		DiasParaProduzir = diasParaProduzir;
		DataInicioVenda = dataInicioVenda;
		DataFimVenda = dataFimVenda;
		DataDiscontinuacao = dataDiscontinuacao;
		RowGuide = rowGuide;
		DataModificacao = dataModificacao;
	}
	
	

	public Produto(@NotNull(message = "O campo não pode ser nulo!") @Size(max = 100, message = "O nome não pode ter mais que {max} caracteres!") String nome,
			@NotNull(message = "O campo não pode ser nulo!") @Size(max = 25, message = "O número do produto não pode ter mais que {max} caracteres!") String numeroProduto,
			byte marcar, byte marcarFinalizado,
			@Size(max = 15, message = "A cor do produto não pode ter mais que {max} caracteres!") String cor,
			@NotNull(message = "O campo não pode ser nulo!") short nivelSeguroStock,
			@NotNull(message = "O campo não pode ser nulo!") short pontoReabastecimento,
			@NotNull(message = "O campo não pode ser nulo!") BigDecimal precoPadrao,
			@NotNull(message = "O campo não pode ser nulo!") BigDecimal precoVenda,
			@Size(max = 5, message = "O tamanho não pode ter mais que {max} caracteres!") String tamanho,
			BigDecimal peso, int diasParaProduzir,
			@Size(max = 2, message = "A linha de producao não pode ter mais que {max} caracteres!") String linhaProducao,
			@Size(max = 2, message = "A classe não pode ter mais que {max} caracteres!") String classe,
			@Size(max = 2, message = "O estilo não pode ter mais que {max} caracteres!") String estilo,
			Date dataInicioVenda, Date dataFimVenda, Date dataDiscontinuacao, String rowGuide, Date dataModificacao) {
		super();
		Nome = nome;
		NumeroProduto = numeroProduto;
		Marcar = marcar;
		MarcarFinalizado = marcarFinalizado;
		Cor = cor;
		NivelSeguroStock = nivelSeguroStock;
		PontoReabastecimento = pontoReabastecimento;
		PrecoPadrao = precoPadrao;
		PrecoVenda = precoVenda;
		Tamanho = tamanho;
		Peso = peso;
		DiasParaProduzir = diasParaProduzir;
		LinhaProducao = linhaProducao;
		Classe = classe;
		Estilo = estilo;
		DataInicioVenda = dataInicioVenda;
		DataFimVenda = dataFimVenda;
		DataDiscontinuacao = dataDiscontinuacao;
		RowGuide = rowGuide;
		DataModificacao = dataModificacao;
	}


	public int getProdutoId() {
		return ProdutoId;
	}

	public void setProdutoId(int produtoId) {
		ProdutoId = produtoId;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getNumeroProduto() {
		return NumeroProduto;
	}

	public void setNumeroProduto(String numeroProduto) {
		NumeroProduto = numeroProduto;
	}

	public byte getMarcar() {
		return Marcar;
	}

	public void setMarcar(byte marcar) {
		Marcar = marcar;
	}

	public byte getMarcarFinalizado() {
		return MarcarFinalizado;
	}

	public void setMarcarFinalizado(byte marcarFinalizado) {
		MarcarFinalizado = marcarFinalizado;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public short getNivelSeguroStock() {
		return NivelSeguroStock;
	}

	public void setNivelSeguroStock(short nivelSeguroStock) {
		NivelSeguroStock = nivelSeguroStock;
	}

	public short getPontoReabastecimento() {
		return PontoReabastecimento;
	}

	public void setPontoReabastecimento(short pontoReabastecimento) {
		PontoReabastecimento = pontoReabastecimento;
	}

	public BigDecimal getPrecoPadrao() {
		return PrecoPadrao;
	}

	public void setPrecoPadrao(BigDecimal precoPadrao) {
		PrecoPadrao = precoPadrao;
	}

	public BigDecimal getPrecoVenda() {
		return PrecoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		PrecoVenda = precoVenda;
	}

	public String getTamanho() {
		return Tamanho;
	}

	public void setTamanho(String tamanho) {
		Tamanho = tamanho;
	}

	public UnidadeMedida getCodigoUnidadeMedidaTamanho() {
		return CodigoUnidadeMedidaTamanho;
	}

	public void setCodigoUnidadeMedidaTamanho(UnidadeMedida codigoUnidadeMedidaTamanho) {
		CodigoUnidadeMedidaTamanho = codigoUnidadeMedidaTamanho;
	}

	public UnidadeMedida getCodigoUnidadeMedidaPeso() {
		return CodigoUnidadeMedidaPeso;
	}

	public void setCodigoUnidadeMedidaPeso(UnidadeMedida codigoUnidadeMedidaPeso) {
		CodigoUnidadeMedidaPeso = codigoUnidadeMedidaPeso;
	}

	public BigDecimal getPeso() {
		return Peso;
	}

	public void setPeso(BigDecimal peso) {
		Peso = peso;
	}

	public int getDiasParaProduzir() {
		return DiasParaProduzir;
	}

	public void setDiasParaProduzir(int diasParaProduzir) {
		DiasParaProduzir = diasParaProduzir;
	}

	public String getLinhaProducao() {
		return LinhaProducao;
	}

	public void setLinhaProducao(String linhaProducao) {
		LinhaProducao = linhaProducao;
	}

	public String getClasse() {
		return Classe;
	}

	public void setClasse(String classe) {
		Classe = classe;
	}

	public String getEstilo() {
		return Estilo;
	}

	public void setEstilo(String estilo) {
		Estilo = estilo;
	}

	public SubcategoriaProduto getSubcategoriaProduto() {
		return SubcategoriaProduto;
	}

	public void setSubcategoriaProduto(SubcategoriaProduto subcategoriaProduto) {
		SubcategoriaProduto = subcategoriaProduto;
	}

	public ModeloProduto getModeloProduto() {
		return ModeloProduto;
	}

	public void setModeloProduto(ModeloProduto modeloProduto) {
		ModeloProduto = modeloProduto;
	}

	public Date getDataInicioVenda() {
		return DataInicioVenda;
	}

	public void setDataInicioVenda(Date dataInicioVenda) {
		DataInicioVenda = dataInicioVenda;
	}

	public Date getDataFimVenda() {
		return DataFimVenda;
	}

	public void setDataFimVenda(Date dataFimVenda) {
		DataFimVenda = dataFimVenda;
	}

	public Date getDataDiscontinuacao() {
		return DataDiscontinuacao;
	}

	public void setDataDiscontinuacao(Date dataDiscontinuacao) {
		DataDiscontinuacao = dataDiscontinuacao;
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

	public Set<ProdutoFotoProduto> getProdutofotoproduto() {
		return produtofotoproduto;
	}

	public void setProdutofotoproduto(Set<ProdutoFotoProduto> produtofotoproduto) {
		this.produtofotoproduto = produtofotoproduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Classe == null) ? 0 : Classe.hashCode());
		result = prime * result + ((CodigoUnidadeMedidaPeso == null) ? 0 : CodigoUnidadeMedidaPeso.hashCode());
		result = prime * result + ((CodigoUnidadeMedidaTamanho == null) ? 0 : CodigoUnidadeMedidaTamanho.hashCode());
		result = prime * result + ((Cor == null) ? 0 : Cor.hashCode());
		result = prime * result + ((DataDiscontinuacao == null) ? 0 : DataDiscontinuacao.hashCode());
		result = prime * result + ((DataFimVenda == null) ? 0 : DataFimVenda.hashCode());
		result = prime * result + ((DataInicioVenda == null) ? 0 : DataInicioVenda.hashCode());
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + DiasParaProduzir;
		result = prime * result + ((Estilo == null) ? 0 : Estilo.hashCode());
		result = prime * result + ((LinhaProducao == null) ? 0 : LinhaProducao.hashCode());
		result = prime * result + Marcar;
		result = prime * result + MarcarFinalizado;
		result = prime * result + ((ModeloProduto == null) ? 0 : ModeloProduto.hashCode());
		result = prime * result + NivelSeguroStock;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((NumeroProduto == null) ? 0 : NumeroProduto.hashCode());
		result = prime * result + ((Peso == null) ? 0 : Peso.hashCode());
		result = prime * result + PontoReabastecimento;
		result = prime * result + ((PrecoPadrao == null) ? 0 : PrecoPadrao.hashCode());
		result = prime * result + ((PrecoVenda == null) ? 0 : PrecoVenda.hashCode());
		result = prime * result + ProdutoId;
		result = prime * result + ((RowGuide == null) ? 0 : RowGuide.hashCode());
		result = prime * result + ((SubcategoriaProduto == null) ? 0 : SubcategoriaProduto.hashCode());
		result = prime * result + ((Tamanho == null) ? 0 : Tamanho.hashCode());
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
		Produto other = (Produto) obj;
		if (Classe == null) {
			if (other.Classe != null)
				return false;
		} else if (!Classe.equals(other.Classe))
			return false;
		if (CodigoUnidadeMedidaPeso == null) {
			if (other.CodigoUnidadeMedidaPeso != null)
				return false;
		} else if (!CodigoUnidadeMedidaPeso.equals(other.CodigoUnidadeMedidaPeso))
			return false;
		if (CodigoUnidadeMedidaTamanho == null) {
			if (other.CodigoUnidadeMedidaTamanho != null)
				return false;
		} else if (!CodigoUnidadeMedidaTamanho.equals(other.CodigoUnidadeMedidaTamanho))
			return false;
		if (Cor == null) {
			if (other.Cor != null)
				return false;
		} else if (!Cor.equals(other.Cor))
			return false;
		if (DataDiscontinuacao == null) {
			if (other.DataDiscontinuacao != null)
				return false;
		} else if (!DataDiscontinuacao.equals(other.DataDiscontinuacao))
			return false;
		if (DataFimVenda == null) {
			if (other.DataFimVenda != null)
				return false;
		} else if (!DataFimVenda.equals(other.DataFimVenda))
			return false;
		if (DataInicioVenda == null) {
			if (other.DataInicioVenda != null)
				return false;
		} else if (!DataInicioVenda.equals(other.DataInicioVenda))
			return false;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (DiasParaProduzir != other.DiasParaProduzir)
			return false;
		if (Estilo == null) {
			if (other.Estilo != null)
				return false;
		} else if (!Estilo.equals(other.Estilo))
			return false;
		if (LinhaProducao == null) {
			if (other.LinhaProducao != null)
				return false;
		} else if (!LinhaProducao.equals(other.LinhaProducao))
			return false;
		if (Marcar != other.Marcar)
			return false;
		if (MarcarFinalizado != other.MarcarFinalizado)
			return false;
		if (ModeloProduto == null) {
			if (other.ModeloProduto != null)
				return false;
		} else if (!ModeloProduto.equals(other.ModeloProduto))
			return false;
		if (NivelSeguroStock != other.NivelSeguroStock)
			return false;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (NumeroProduto == null) {
			if (other.NumeroProduto != null)
				return false;
		} else if (!NumeroProduto.equals(other.NumeroProduto))
			return false;
		if (Peso == null) {
			if (other.Peso != null)
				return false;
		} else if (!Peso.equals(other.Peso))
			return false;
		if (PontoReabastecimento != other.PontoReabastecimento)
			return false;
		if (PrecoPadrao == null) {
			if (other.PrecoPadrao != null)
				return false;
		} else if (!PrecoPadrao.equals(other.PrecoPadrao))
			return false;
		if (PrecoVenda == null) {
			if (other.PrecoVenda != null)
				return false;
		} else if (!PrecoVenda.equals(other.PrecoVenda))
			return false;
		if (ProdutoId != other.ProdutoId)
			return false;
		if (RowGuide == null) {
			if (other.RowGuide != null)
				return false;
		} else if (!RowGuide.equals(other.RowGuide))
			return false;
		if (SubcategoriaProduto == null) {
			if (other.SubcategoriaProduto != null)
				return false;
		} else if (!SubcategoriaProduto.equals(other.SubcategoriaProduto))
			return false;
		if (Tamanho == null) {
			if (other.Tamanho != null)
				return false;
		} else if (!Tamanho.equals(other.Tamanho))
			return false;
		if (produtofotoproduto == null) {
			if (other.produtofotoproduto != null)
				return false;
		} else if (!produtofotoproduto.equals(other.produtofotoproduto))
			return false;
		return true;
	}
	
	
	
}
