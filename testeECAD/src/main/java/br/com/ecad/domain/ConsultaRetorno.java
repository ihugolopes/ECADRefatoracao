package br.com.ecad.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ecad.repository.ConsultaRetornoRepository;
import br.com.ecad.validacao.ConsistentDateParameters;

@Component
@Entity
public class ConsultaRetorno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @NotEmpty @NotBlank
	private String nossoNumero;
	
	@JsonFormat(pattern = "dd/MM/yyyy") @NotNull
	private Date datInicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy") @NotNull
	private Date datFim;
	
	@NotNull @NotEmpty @NotBlank
	private String ocorrencia;
	
	@NotNull @NotEmpty @NotBlank
	private String unidade = "T";

	public ConsultaRetorno() {
	}

	@ConsistentDateParameters
	public ConsultaRetorno(Long id, String nossoNumero, Date datInicio, Date datFim, String ocorrencia,
			String unidade) {
		this.id = id;
		this.nossoNumero = nossoNumero;
		this.datInicio = datInicio;
		this.datFim = datFim;
		this.ocorrencia = ocorrencia;
		this.unidade = unidade;
	}
	
	public ConsultaRetorno(ConsultaRetornoForm form) {
		this.id = form.getId();
		this.nossoNumero = form.getNossoNumero();
		this.datInicio = form.getDatInicio();
		this.datFim = form.getDatFim();
		this.ocorrencia = form.getOcorrencia();
		this.unidade = form.getUnidade();
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

	/*
	 * Atualizando um objeto usando o controle de transacao de estado do hibernate para a alteracao/atualizacao.
	 */
	public ConsultaRetorno atualizar(Long id, ConsultaRetornoRepository repository) {
		 ConsultaRetorno cr = repository.findById(id).get(); //O getOne pode ter problemas de serializacao, entao pode-se realizar a busca de um objeto passando o .get().
		 cr.setDatInicio(this.datInicio);
		 cr.setDatFim(this.datFim);
		 cr.setNossoNumero(this.nossoNumero);
		 cr.setOcorrencia(this.ocorrencia);
		 cr.setUnidade(this.unidade);
		 
		return cr;
	}
	
	/*
	 * Metodo para validacao de campos do form de consulta.
	 */
	public Exception validar(ConsultaRetorno consultaRetorno) {
		
		if(((consultaRetorno.getNossoNumero() == null || consultaRetorno.getNossoNumero().isEmpty()) &&
				consultaRetorno.getDatInicio() == null && consultaRetorno.getDatFim() == null)){
			return new Exception("É nescessário preencher a Data Inicial e Data Final ou o Nosso Número");
		}
			
		if(consultaRetorno.getDatInicio() != null && consultaRetorno.getDatFim() !=null){
			if(!consultaRetorno.validaData(consultaRetorno.getDatInicio(), consultaRetorno.getDatFim())){
				return new Exception("A data inicial não pode ser maior que a data final.");
				
			}
		}	
		
		return null;
	}
	
	public boolean validaData(Date dataInicial, Date dataFinal) {
//		Caso precise fazer parte de String to Date.
		
//		String strDataInicial = "14/01/2017 23:45";
//		String strDataFinal = "14/01/2017 00:00";
//
//		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//
//		dataFinal = sdf1.parse(strDataFinal);
//		dataInicial = sdf2.parse(strDataInicial);
		
		return dataFinal.after(dataInicial);
		
	}

	public List<ConsultaRetorno> buscaConsulta(ConsultaRetorno consultaRetorno, ConsultaRetornoRepository repository) {
		
		if(((consultaRetorno.getNossoNumero() == null || consultaRetorno.getNossoNumero().isEmpty()) &&
				consultaRetorno.getDatInicio() != null && consultaRetorno.getDatFim() != null)){
			return repository.buscarPorDatas(consultaRetorno.getDatInicio(), consultaRetorno.getDatFim());
		}
		
		if(((consultaRetorno.getNossoNumero() != null || !consultaRetorno.getNossoNumero().isEmpty()) &&
				consultaRetorno.getDatInicio() == null && consultaRetorno.getDatFim() == null)){
			return repository.findByNossoNumero(consultaRetorno.getNossoNumero());
		}
		
		if(((consultaRetorno.getNossoNumero() != null || !consultaRetorno.getNossoNumero().isEmpty()) &&
				consultaRetorno.getDatInicio() != null && consultaRetorno.getDatFim() != null)){
			return repository.buscarPorNossoNumeroeDatas(consultaRetorno.getNossoNumero(), consultaRetorno.getDatInicio(), consultaRetorno.getDatFim());
		}
			
		return null;
				
	}
	

}
