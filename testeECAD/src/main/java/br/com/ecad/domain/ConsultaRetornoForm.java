package br.com.ecad.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ecad.validacao.ConsistentDateParameters;

@Component
@Entity
public class ConsultaRetornoForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nossoNumero;
	
	@JsonFormat(pattern = "dd/MM/yyyy") 
	private Date datInicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy") 
	private Date datFim;

	private String ocorrencia;
	
	private String unidade = "T";

	public ConsultaRetornoForm() {
	}

	@ConsistentDateParameters
	public ConsultaRetornoForm(Long id, String nossoNumero, Date datInicio, Date datFim, String ocorrencia,
			String unidade) {
		this.id = id;
		this.nossoNumero = nossoNumero;
		this.datInicio = datInicio;
		this.datFim = datFim;
		this.ocorrencia = ocorrencia;
		this.unidade = unidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public Date getDatInicio() {
		return datInicio;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public void setDatInicio(Date datInicio) {
		this.datInicio = datInicio;
	}

	public Date getDatFim() {
		return datFim;
	}

	public void setDatFim(Date datFim) {
		this.datFim = datFim;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public boolean validaData(Date dataInicial, Date dataFinal) {
		return dataFinal.after(dataInicial);
		
	}

	public ConsultaRetorno converter(@Valid ConsultaRetornoForm form) {
		
		ConsultaRetorno c = new ConsultaRetorno(form);

		return c;
	}
	


}
