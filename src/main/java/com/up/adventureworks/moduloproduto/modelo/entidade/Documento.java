package com.up.adventureworks.moduloproduto.modelo.entidade;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Documento")
public class Documento {

	//hierarchyid
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private char DocumentNode;
	
	//Computed: [DocumentNode].[GetLevel]()
	@Column(name="LevelDocumento", columnDefinition = "smallint(6)",nullable = true)
	private int LevelDocumento;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Size(max=50,message="O titulo não pode ter mais que {max} caracteres!")
	@Column(name="Titulo", length = 50, nullable = false)
	private String Titulo;
	
	//Foreign key to Employee.BusinessEntityID
	@Column(name="Proprietario", nullable = false)
	private int Proprietario;
	
	@Column(name="FlagPasta", columnDefinition = "TINYINT(1)",nullable = false)
	private boolean FlagPasta;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Size(max=400,message="O nome do arquivo não pode ter mais que {max} caracteres!")
	@Column(name="NomeArquivo", length = 400, nullable = false)
	private String NomeArquivo;
	
	@NotNull(message="O campo não pode ser nulo!")
	@Size(max=8,message="O extenção não pode ter mais que {max} caracteres!")
	@Column(name="ExtensaoArquivo", length = 8, nullable = false)
	private String ExtensaoArquivo;
	
	@Column(name="Revisao",columnDefinition = "char(5)")
	private char Revisao;
	
	@Column(name="NumeroMudanca", nullable = false)
	private int NumeroMudanca;
	
	//1 = Pending approval, 2 = Approved, 3 = Obsolete
	@Column(name="Status", columnDefinition = "TINYINT(3)",nullable = false)
	@Range(min=1,max=3,message="Valor inválido")
	private int Status;
	
	@Lob
	@Column(name="SumarioDocumento", nullable = true)
	private String SumarioDocumento;
	
	@Lob
	@Column(name="Documento", length=100000, nullable = true)
	private byte Documento;
	
	@Column(nullable = false,length=64)
	private String RowGuide;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date DataModificacao;

	public Documento() {
		super();
	}

	public Documento(char documentNode, int levelDocumento,
			@NotNull(message = "O campo não pode ser nulo!") @Size(max = 50, message = "O titulo não pode ter mais que {max} caracteres!") String titulo,
			int proprietario, boolean flagPasta,
			@NotNull(message = "O campo não pode ser nulo!") @Size(max = 400, message = "O nome do arquivo não pode ter mais que {max} caracteres!") String nomeArquivo,
			@NotNull(message = "O campo não pode ser nulo!") @Size(max = 8, message = "O extenção não pode ter mais que {max} caracteres!") String extensaoArquivo,
			char revisao, int numeroMudanca, @Range(min = 1, max = 3, message = "Valor inválido") int status,
			String sumarioDocumento, byte documento, String rowGuide, Date dataModificacao) {
		super();
		DocumentNode = documentNode;
		LevelDocumento = levelDocumento;
		Titulo = titulo;
		Proprietario = proprietario;
		FlagPasta = flagPasta;
		NomeArquivo = nomeArquivo;
		ExtensaoArquivo = extensaoArquivo;
		Revisao = revisao;
		NumeroMudanca = numeroMudanca;
		Status = status;
		SumarioDocumento = sumarioDocumento;
		Documento = documento;
		RowGuide = rowGuide;
		DataModificacao = dataModificacao;
	}

	public char getDocumentNode() {
		return DocumentNode;
	}

	public void setDocumentNode(char documentNode) {
		DocumentNode = documentNode;
	}

	public int getLevelDocumento() {
		return LevelDocumento;
	}

	public void setLevelDocumento(int levelDocumento) {
		LevelDocumento = levelDocumento;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public int getProprietario() {
		return Proprietario;
	}

	public void setProprietario(int proprietario) {
		Proprietario = proprietario;
	}

	public boolean isFlagPasta() {
		return FlagPasta;
	}

	public void setFlagPasta(boolean flagPasta) {
		FlagPasta = flagPasta;
	}

	public String getNomeArquivo() {
		return NomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		NomeArquivo = nomeArquivo;
	}

	public String getExtensaoArquivo() {
		return ExtensaoArquivo;
	}

	public void setExtensaoArquivo(String extensaoArquivo) {
		ExtensaoArquivo = extensaoArquivo;
	}

	public char getRevisao() {
		return Revisao;
	}

	public void setRevisao(char revisao) {
		Revisao = revisao;
	}

	public int getNumeroMudanca() {
		return NumeroMudanca;
	}

	public void setNumeroMudanca(int numeroMudanca) {
		NumeroMudanca = numeroMudanca;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getSumarioDocumento() {
		return SumarioDocumento;
	}

	public void setSumarioDocumento(String sumarioDocumento) {
		SumarioDocumento = sumarioDocumento;
	}

	public byte getDocumento() {
		return Documento;
	}

	public void setDocumento(byte documento) {
		Documento = documento;
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
		result = prime * result + ((DataModificacao == null) ? 0 : DataModificacao.hashCode());
		result = prime * result + DocumentNode;
		result = prime * result + Documento;
		result = prime * result + ((ExtensaoArquivo == null) ? 0 : ExtensaoArquivo.hashCode());
		result = prime * result + (FlagPasta ? 1231 : 1237);
		result = prime * result + LevelDocumento;
		result = prime * result + ((NomeArquivo == null) ? 0 : NomeArquivo.hashCode());
		result = prime * result + NumeroMudanca;
		result = prime * result + Proprietario;
		result = prime * result + Revisao;
		result = prime * result + ((RowGuide == null) ? 0 : RowGuide.hashCode());
		result = prime * result + Status;
		result = prime * result + ((SumarioDocumento == null) ? 0 : SumarioDocumento.hashCode());
		result = prime * result + ((Titulo == null) ? 0 : Titulo.hashCode());
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
		Documento other = (Documento) obj;
		if (DataModificacao == null) {
			if (other.DataModificacao != null)
				return false;
		} else if (!DataModificacao.equals(other.DataModificacao))
			return false;
		if (DocumentNode != other.DocumentNode)
			return false;
		if (Documento != other.Documento)
			return false;
		if (ExtensaoArquivo == null) {
			if (other.ExtensaoArquivo != null)
				return false;
		} else if (!ExtensaoArquivo.equals(other.ExtensaoArquivo))
			return false;
		if (FlagPasta != other.FlagPasta)
			return false;
		if (LevelDocumento != other.LevelDocumento)
			return false;
		if (NomeArquivo == null) {
			if (other.NomeArquivo != null)
				return false;
		} else if (!NomeArquivo.equals(other.NomeArquivo))
			return false;
		if (NumeroMudanca != other.NumeroMudanca)
			return false;
		if (Proprietario != other.Proprietario)
			return false;
		if (Revisao != other.Revisao)
			return false;
		if (RowGuide == null) {
			if (other.RowGuide != null)
				return false;
		} else if (!RowGuide.equals(other.RowGuide))
			return false;
		if (Status != other.Status)
			return false;
		if (SumarioDocumento == null) {
			if (other.SumarioDocumento != null)
				return false;
		} else if (!SumarioDocumento.equals(other.SumarioDocumento))
			return false;
		if (Titulo == null) {
			if (other.Titulo != null)
				return false;
		} else if (!Titulo.equals(other.Titulo))
			return false;
		return true;
	}
	
	
	
}
