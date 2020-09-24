
package br.com.ecad.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ecad.domain.ConsultaRetorno;
import br.com.ecad.domain.ConsultaRetornoForm;
import br.com.ecad.domain.Ocorrencia;
import br.com.ecad.domain.Unidades;
import br.com.ecad.dto.ConsultaRetornoDTO;
import br.com.ecad.enums.OcorrenciaBancariaEnum;
import br.com.ecad.enums.UnidadeFederativaEnum;
import br.com.ecad.repository.ConsultaRetornoRepository;
import br.com.ecad.validacao.ConsistentDateParameters;

/*
 * RestController me facilita de ter o trabalho de anotar os metodos com @ResponseBody, ja que todos serao.
 */
@RestController
@RequestMapping("/retorno")
public class ConsultaRetornoController {

	@Autowired
	private ConsultaRetornoRepository repository;

	/*
	 * Utilizei dos verbos http, utilizando neste caso a anottation para resposta do
	 * status no metodo. No if verifico a existencia do paramentro na url
	 * nossoNumero, se for null busco tudo, se o conter faco a busca pelo
	 * nossoNumero.
	 * 
	 * Com o validator do spring e possivel adicionar restricoes de parametros
	 * cruzados
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ConsultaRetornoDTO> listar(String nossoNumero) {
		if (nossoNumero == null) {
			List<ConsultaRetorno> cr = repository.findAll();
			return ConsultaRetornoDTO.converter(cr);
		} else {
			List<ConsultaRetorno> cr = repository.findByNossoNumero(nossoNumero);
			return ConsultaRetornoDTO.converter(cr);
		}
	}

	/*
	 * Aqui ao inves de buscar como parametro de url, busco como parte da url. Por
	 * isso anoto @PathVariable, onde se eu quiser trocar o nome do atributo, devo
	 * declarar por ex:
	 * 
	 * @PathVariable("nossoNumero") String nomeDiferenteNossoNumero
	 * 
	 */
	@GetMapping("/nossonumero/{nossoNumero}")
	@ResponseStatus(HttpStatus.OK)
	public List<ConsultaRetornoDTO> findByNossoNumero(@PathVariable String nossoNumero) {
		return ConsultaRetornoDTO.converter(repository.findByNossoNumero(nossoNumero));

	}

	/*
	 * Exemplo de fazer get por id
	 */
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ConsultaRetorno> findById(@PathVariable Long id) {

		// Usarei o Optional afim de fazer a validacao de um objeto que pode ser
		// retornado, ou nao.
		Optional<ConsultaRetorno> optional = repository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.ok(repository.findById(id).get()); // ou getOne() passando um id.
		}

		return ResponseEntity.notFound().build(); // Usa-se para fazer um tratamento caso nao tenha retornado o objeto.
													// Retornando 404.
		// Importante para evitar que a exception seja devolvida para o cliente no corpo
		// da resposta.

	}

	/*
	 * Lista para combo unidade
	 */
	@GetMapping("/unidades")
	@ResponseStatus(HttpStatus.OK)
	public List<Unidades> listaUnidades() {

		List<Unidades> unidades = UnidadeFederativaEnum.listaUnidades();

		System.out.println(unidades);

		return unidades;

	}

	/*
	 * Lista para combo tipo de ocorrencias bancarias
	 */
	@GetMapping("/ocorrencias")
	@ResponseStatus(HttpStatus.OK)
	public List<Ocorrencia> listaTiposDeOcorrencia() {

		List<Ocorrencia> tiposOcorrencias = OcorrenciaBancariaEnum.listaTipoOcorrenciaBancaria();

		System.out.println(tiposOcorrencias);

		return tiposOcorrencias;

	}

	@PostMapping("/consulta")
	@ResponseStatus(HttpStatus.OK)
	public List<ConsultaRetorno> consulta(@RequestBody @Valid ConsultaRetornoForm form) throws Exception {

		ConsultaRetorno consultaRetorno = form.converter(form);

		if (consultaRetorno.validar(consultaRetorno) != null) {
			throw new Exception(consultaRetorno.validar(consultaRetorno));
		}

		List<ConsultaRetorno> retorno = consultaRetorno.buscaConsulta(consultaRetorno, repository);

		retorno.forEach(retoro -> {
			System.out.println(retoro.getNossoNumero());
		});

		return ResponseEntity.ok(retorno).getBody(); // ou getOne() passando um id.

	}

	/*
	 * Aqui utilizo o UriComponentsBuilder para dar uma resposta created junto com a
	 * URI de localizacao do que foi criado. Uso "/retorno/id" estaticamente, e dou
	 * get no id dinamicamente. Levando a URI no metodo created. Passo o proprio
	 * objeto no retorno da requisicao, sendo necessario de acordo com a regra de
	 * negocios um DTO para nao exibir todos os dados. Sendo a forma mais
	 * apropriada.
	 * 
	 * @Valid faz validacoes do bean validation
	 */
	@PostMapping
	@Transactional
	@ConsistentDateParameters
	public ResponseEntity<ConsultaRetorno> cadastrar(@RequestBody @Valid ConsultaRetorno consultaRetorno,
			UriComponentsBuilder uriBuilder) throws Exception {

		if (!consultaRetorno.validaData(consultaRetorno.getDatInicio(), consultaRetorno.getDatFim())) {
			throw new Exception("data fim deve ser maior que data inicio");

		}

		repository.save(consultaRetorno);

		URI uri = uriBuilder.path("/retorno/{id}").buildAndExpand(consultaRetorno.getId()).toUri();
		return ResponseEntity.created(uri).body(consultaRetorno);
	}

	@DeleteMapping("/{id}")
	@Transactional
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	/*
	 * @Transacional para commitar a requisicao ao fim da transacao
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ConsultaRetorno> alterar(@PathVariable Long id,
			@RequestBody @Valid ConsultaRetorno consultaRetorno) {

		Optional<ConsultaRetorno> optional = repository.findById(id);

		if (optional.isPresent()) {
			ConsultaRetorno cr = consultaRetorno.atualizar(id, repository);
			return ResponseEntity.ok(cr);
		}

		return ResponseEntity.notFound().build();
	}

}
