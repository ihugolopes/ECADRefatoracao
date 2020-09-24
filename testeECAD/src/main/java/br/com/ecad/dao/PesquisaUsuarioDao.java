package br.com.ecad.dao;

import java.util.List;

import br.com.ecad.domain.PesquisaUsuarioBean;

public interface PesquisaUsuarioDao {

	List<PesquisaUsuarioBean> buscarUsuario(PesquisaUsuarioBean usuario);
	
}
