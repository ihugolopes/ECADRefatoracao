package br.com.ecad.enums;

import java.util.ArrayList;
import java.util.List;

import br.com.ecad.domain.Ocorrencia;

public enum OcorrenciaBancariaEnum {

	OCORRENCIA1(1L, "Tipo ocorrencia 1", "1"), OCORRENCIA2(2L, "Tipo ocorrencia 2", "2"), OCORRENCIA3(3L, "Tipo ocorrencia 3", "3");

	private final Long idOcorrencia;
	private final String ocorrencia;
	private final String codOcorrencia;

	OcorrenciaBancariaEnum(Long idOcorrencia, String ocorrencia, String codOcorrencia) {
		this.idOcorrencia = idOcorrencia;
		this.ocorrencia = ocorrencia;
		this.codOcorrencia = codOcorrencia;
	}
	
	/*
	 * Retorna lista de tipo de ocorrencias bancarias
	 */
	public static List<Ocorrencia> listaTipoOcorrenciaBancaria(){
		List<Ocorrencia> listOcorrencias = new ArrayList<Ocorrencia>();
	
		for (final OcorrenciaBancariaEnum oc : OcorrenciaBancariaEnum.values()) {
			Ocorrencia o = new Ocorrencia();
			o.setId(oc.idOcorrencia);
			o.setOcorrencia(oc.ocorrencia);
			o.setCodOcorrencia(oc.codOcorrencia);
			listOcorrencias.add(o);
		}
		
		return  listOcorrencias;
	}
	
	public Long getIdOcorrencia() {
		return idOcorrencia;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public String getCodOcorrencia() {
		return codOcorrencia;
	}

}
