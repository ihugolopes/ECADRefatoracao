package br.com.ecad;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
 * Quando habilitamos CORS em aplicações Spring, por padrão não é permitido acesso à recursos via método OPTIONS. 
 * Isso pode causar problemas à aplicações consumidoras desses recursos, que continuarão a ter problemas com respostas 
 * “No ‘Access-Control-Allow-Origin’ header is present on the requested resource”.
 * Para habilitar todos os métodos HTTP, precisamos fazê-lo explicitamente na classe de configuração.
 */

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}
}
