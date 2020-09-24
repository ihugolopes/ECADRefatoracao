package br.com.ecad.validacao;

/*
 * Algumas importacoes necessitam ser realizadas manualmente, tais como as 3 abaixo.
 */
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
//import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*
 * Classe do Bean Validation para excessoes de validacao personalizadas.
 */

@Constraint(validatedBy = ConsistentDateParameterValidator.class)
@Target({ METHOD, CONSTRUCTOR })
@Retention(RUNTIME)
@Documented
public @interface ConsistentDateParameters {

	String message() default
    "A data de inicio deve ser menor que a data final, e a data final maior que a data inicio";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
