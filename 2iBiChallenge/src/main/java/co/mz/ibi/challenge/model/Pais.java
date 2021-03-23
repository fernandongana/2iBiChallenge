package co.mz.ibi.challenge.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Pais")
public class Pais implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="identificador ")
    private Long identificador ;
	
	@NotBlank(message = "* O Nome não pode ser nulo")
	@Column(name="nome")
	private String nome;
	
	@NotBlank(message = "* A capital não pode ser nula")
	@Column(name="capital")
	private String capital;
	
	@NotBlank(message = "* A região não pode ser nula")
	@Column(name="regiao")
	private String regiao;
	
	@NotBlank(message = "* A Sub Região não pode ser nula")
	@Column(name="subRegiao")
	private String subRegiao;
	
	@Min(value=0,message="O valor da área deve ser maior ou igual a 0")
    @Column(name = "area", nullable = false)
    private BigDecimal area;

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getSubRegiao() {
		return subRegiao;
	}

	public void setSubRegiao(String subRegiao) {
		this.subRegiao = subRegiao;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public Pais(Long identificador, @NotBlank(message = "* O Nome não pode ser nulo") String nome,
			@NotBlank(message = "* A capital não pode ser nula") String capital,
			@NotBlank(message = "* A região não pode ser nula") String regiao,
			@NotBlank(message = "* A Sub Região não pode ser nula") String subRegiao,
			@Min(value = 0, message = "O valor da área deve ser maior ou igual a 0") BigDecimal area) {
		super();
		this.identificador = identificador;
		this.nome = nome;
		this.capital = capital;
		this.regiao = regiao;
		this.subRegiao = subRegiao;
		this.area = area;
	}

	public Pais() {
		super();
	}

}
