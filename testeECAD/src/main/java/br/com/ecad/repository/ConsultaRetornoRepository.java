package br.com.ecad.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ecad.domain.ConsultaRetorno;

public interface ConsultaRetornoRepository extends JpaRepository<ConsultaRetorno, Long> {

	List<ConsultaRetorno> findByNossoNumero(String nossoNumero);

	/*
	 * Utilizando JPQL, e fazendo parse data para o padrao desejado conforme a regra de negocios.
	 */
	@Query("SELECT c FROM ConsultaRetorno c WHERE to_char(c.datInicio, 'yyyy/mm/dd') >= to_char(:datInicio, 'yyyy/mm/dd') AND to_char(c.datFim, 'yyyy/mm/dd') <= to_char(:datFim, 'yyyy/mm/dd')")
	List<ConsultaRetorno> buscarPorDatas(Date datInicio, Date datFim);
	
	
	@Query("SELECT c FROM ConsultaRetorno c WHERE c.nossoNumero = :nossoNumero and to_char(c.datInicio, 'yyyy/mm/dd') >= to_char(:datInicio, 'yyyy/mm/dd') AND to_char(c.datFim, 'yyyy/mm/dd') <= to_char(:datFim, 'yyyy/mm/dd')")
	List<ConsultaRetorno> buscarPorNossoNumeroeDatas(String nossoNumero, Date datInicio, Date datFim);

	

}
