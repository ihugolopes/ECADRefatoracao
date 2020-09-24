package br.com.ecad.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	/*
	 * Ajuda e pegar mensagem de erro de acordo com a lingua.
	 * Pode ser testado passando o header Accept-Language, seguido do value do idioma.
	 */
	@Autowired
	private MessageSource messageSource;
	
	/*
	 * RestControllerAdvice para o tratamento de erros, interceptando qualquer erro que venha ser informado pelo bean validation.
	 * Anotei @ResponseStatus informando o o status code como BAD_REQUEST para que ele nao entenda ser um tratamento meu para o erro em si, sabendo que nao esta resolvido.
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeConsulta> handle(MethodArgumentNotValidException exception) {
		List<ErroDeConsulta> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeConsulta erro = new ErroDeConsulta(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}

}
