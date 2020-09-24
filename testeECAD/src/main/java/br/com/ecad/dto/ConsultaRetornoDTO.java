package br.com.ecad.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ecad.domain.ConsultaRetorno;

public class ConsultaRetornoDTO {

	private Long id;
	private String nossoNumero;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datFim;
	private String ocorrencia;
	private String unidade = "T";

	public ConsultaRetornoDTO(ConsultaRetorno cr) {
		super();
		this.id = cr.getId();
		this.nossoNumero = cr.getNossoNumero();
		this.datInicio = cr.getDatInicio();
		this.datFim = cr.getDatFim();
		this.ocorrencia = cr.getOcorrencia();
		this.unidade = cr.getUnidade();
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

	public void setDatInicio(Date datInicio) {
		this.datInicio = datInicio;
	}

	public Date getDatFim() {
		return datFim;
	}

	public void setDatFim(Date datFim) {
		this.datFim = datFim;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public static List<ConsultaRetornoDTO> converter(List<ConsultaRetorno> topicos) {
		return topicos.stream().map(ConsultaRetornoDTO::new).collect(Collectors.toList());
	}
	
	

}
