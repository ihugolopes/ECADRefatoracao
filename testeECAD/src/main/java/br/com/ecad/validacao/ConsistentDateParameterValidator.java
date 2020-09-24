package br.com.ecad.validacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import br.com.ecad.domain.ConsultaRetorno;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentDateParameterValidator
		implements ConstraintValidator<ConsistentDateParameters, ConsultaRetorno> {

	@Override
	public boolean isValid(ConsultaRetorno consultaRetorno, ConstraintValidatorContext context) {

		if (consultaRetorno.validaData(consultaRetorno.getDatInicio(), consultaRetorno.getDatFim())) {
			return true;
		}

		return false;
	}
}
