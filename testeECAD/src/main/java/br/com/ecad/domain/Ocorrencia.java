package br.com.ecad.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Ocorrencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ocorrencia;
	private String codOcorrencia;
	
	public Ocorrencia() {
	}

	public Ocorrencia(Long id, String ocorrencia, String codOcorrencia) {
		super();
		this.id = id;
		this.ocorrencia = ocorrencia;
		this.codOcorrencia = codOcorrencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public String getCodOcorrencia() {
		return codOcorrencia;
	}

	public void setCodOcorrencia(String codOcorrencia) {
		this.codOcorrencia = codOcorrencia;
	}
	
	
	
	
	
	

}
