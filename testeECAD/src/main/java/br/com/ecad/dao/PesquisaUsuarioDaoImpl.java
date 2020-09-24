package br.com.ecad.dao;
//package br.com.ecad.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import br.com.ecad.domain.ConsultaRetorno;
//import br.com.ecad.domain.PesquisaUsuarioBean;
//import br.com.ecad.exception.NaoExisteDaoException;
//
//@Repository
//public class PesquisaUsuarioDaoImpl implements PesquisaUsuarioDao {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	@Autowired
//	private ConsultaRetorno consultaRetorno;
//	
//	@Autowired
//	private PesquisaUsuarioBean pesquisaUsuario;
//	
//	
//	public Long pesquisaUsuario(PesquisaUsuarioBean pesquisaUsuario) {
//		
//		
//		PesquisaUsuarioBean result = entityManager.find(PesquisaUsuarioBean.class, pesquisaUsuario.getCodUsuario());
//		
//		if (result == null) {
//            throw new NaoExisteDaoException("Retorno não encontrado para nosso usuario = " + pesquisaUsuario.getCodUsuario() + ".");
//        }
//        return pesquisaUsuario.getCodUsuario();
//	}
//	
//	
//	
//	
////	@Override
////	public List<UsuarioBean> buscarUsuario(UsuarioBean usuario) {
////		
////
////		if (usuario.checarPreenchimento(usuario)) {
//////			facesMessages.add(Severity.ERROR, "Informe o Código do Usuário ou a Razão Social/Nome e/ou CNPJ/CPF !");
//////			return;
////		}
////		
////		if (usuario.getCampoCPFCNPJ() != null && !"".equals(usuario.getCampoCPFCNPJ() .trim())) {
////			if (!usuario.validarCpfCnpj2(usuario.getCampoCPFCNPJ() .trim())) {
//////				facesMessages.add(Severity.ERROR, "O valor informado do CPF/CNPJ não é um formato válido.");
//////				return;
////			}
////		}
////		
////		
////		
////		
////		return null;
////	}
//
//	@Override
//	public List<PesquisaUsuarioBean> buscarUsuario(PesquisaUsuarioBean usuario) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
////	public void buscarUsuarios() {
//		
//
////		usuarioBeanLista = new ArrayList<UsuarioBean>();
////		
////
////		/*
////		 * Retorna total de usuarios encontrados para exibir durante busca de mais
////		 * resultadis
////		 */
//////		MOCADO NO UsuarioBean
//////		usuariosTotal = getUsuarioEAO().usuariosTotal(campoCodigoUsuario, isNull(campoNomeUsuario),
//////				isNull(CpfCnpjFormatado), null, isNull(campoUf));
////
////		// O método isNull verifica se a String está nula ou vazia, e retorna
////		// null em ambos os casos.
////		// Ele foi criado para diminuir a quantidade de validações necessárias
////		// na query de usuários.
////
//////		PASSAR QUANTIDADE DE USUARIOS NO JSON
//////		List<Usuario> usuariosEncontrados = getUsuarioEAO().pesquisarUsuarios(campoCodigoUsuario,
//////				isNull(campoNomeUsuario), isNull(CpfCnpjFormatado), null, isNull(campoUf), FIRST_RESULT, MAX_RESULTS);
////
////		if (usuariosEncontrados == null || usuariosEncontrados.isEmpty()) {
////			facesMessages.add(Severity.INFO, "Nenhum Usuário encontrado com os dados fornecidos.");
////			return;
////		} else {
////			for (Usuario usuario : usuariosEncontrados) {
////				usuarioBeanLista.add(new UsuarioBean(usuario));
////			}
////		}
////
////	}
//
//
//
//}
