package br.com.ecad.domain;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session")
public class PesquisaUsuarioBean {
	
	private String data;
	private Long campoCodigoUsuario;
	private String campoNomeUsuario;
	private String campoCPFCNPJ;
	private String campoUf;
	String CpfCnpjFormatado = null;
	private Long codUsuario;
//	private Usuario usuario;


	private String redirectTo;
	private String from;

	private List<PesquisaUsuarioBean> usuarioBeanLista;
	private boolean usuarioNotificado;

//	public void wire() {
//
//	}
//
//	private UsuarioEAOLocal getUsuarioEAO() {
//		return (UsuarioEAOLocal) ServiceLocator.getInstance().lookup("sga-ear/aentities/pessoa/UsuarioEAO/local");
//	}

//	/**
//	 * Recupera informações no enum UnidadeFederaticaEnum
//	 * 
//	 * @author falbuquerque
//	 * @result SelectItem[] dos itens do enum
//	 */
//	public List<SelectItem> getUnidadeEnum() {
//
//		List<SelectItem> items = new ArrayList<SelectItem>(UnidadeFederativaEnum.values().length);
//
//		for (UnidadeFederativaEnum t : UnidadeFederativaEnum.values()) {
//			items.add(new SelectItem(t.getSigla(), t.getDescricao()));
//		}
//
//		return items;
//	}

	/**
	 * Valida se os valores informados no campo CPF/CNPJ não contem caracteres não
	 * permitidos. Se o campo estiver OK, já preenche uma variável global com o
	 * CPF/CNPJ sem traços, barras ou pontos.
	 * 
	 * @param cpfCnpj
	 * @return true or false
	 */
	public boolean validarCpfCnpj(String cpfCnpj) {
		cpfCnpj = cpfCnpj.replace(".", "");
		cpfCnpj = cpfCnpj.replace("/", "");
		cpfCnpj = cpfCnpj.replace("-", "");

		if (cpfCnpj.length() > 14)
			return false;

		try {
			Long.parseLong(cpfCnpj);
			CpfCnpjFormatado = cpfCnpj;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//	public void buscarUsuarios() {
//		CpfCnpjFormatado = null;
//
//		if (checarPreenchimento()) {
//			facesMessages.add(Severity.ERROR, "Informe o Código do Usuário ou a Razão Social/Nome e/ou CNPJ/CPF !");
//			return;
//		}
//
//		if (campoCPFCNPJ != null && !"".equals(campoCPFCNPJ.trim())) {
//			if (!validarCpfCnpj(campoCPFCNPJ.trim())) {
//				facesMessages.add(Severity.ERROR, "O valor informado do CPF/CNPJ não é um formato válido.");
//				return;
//			}
//		}
//
//		usuarioBeanLista = new ArrayList<UsuarioBean>();
//		numElementosLayout = 10;
//
//		/*
//		 * Retorna total de usuarios encontrados para exibir durante busca de mais
//		 * resultadis
//		 */
//		usuariosTotal = getUsuarioEAO().usuariosTotal(campoCodigoUsuario, isNull(campoNomeUsuario),
//				isNull(CpfCnpjFormatado), null, isNull(campoUf));
//
//		// O método isNull verifica se a String está nula ou vazia, e retorna
//		// null em ambos os casos.
//		// Ele foi criado para diminuir a quantidade de validações necessárias
//		// na query de usuários.
//
//		List<Usuario> usuariosEncontrados = getUsuarioEAO().pesquisarUsuarios(campoCodigoUsuario,
//				isNull(campoNomeUsuario), isNull(CpfCnpjFormatado), null, isNull(campoUf), FIRST_RESULT, MAX_RESULTS);
//
//		if (usuariosEncontrados == null || usuariosEncontrados.isEmpty()) {
//			facesMessages.add(Severity.INFO, "Nenhum Usuário encontrado com os dados fornecidos.");
//			return;
//		} else {
//			for (Usuario usuario : usuariosEncontrados) {
//				usuarioBeanLista.add(new UsuarioBean(usuario));
//			}
//		}
//
//	}

	/**
	 * Método que realiza busca por blocos de 100 quando o usuário desejar listar
	 * mais itens. Número máximo de linha = MAX_RESULTS e Número inicial de linha =
	 * FIRST_RESULT
	 */
	public void buscarMaisUsuarios() {
		CpfCnpjFormatado = null;

		if (checarPreenchimento()) {
//			facesMessages.add(Severity.ERROR, "Informe o Código do Usuário ou a Razão Social/Nome e/ou CNPJ/CPF !");
			return;
		}

		if (campoCPFCNPJ != null && !"".equals(campoCPFCNPJ.trim())) {
			if (!validarCpfCnpj(campoCPFCNPJ.trim())) {
//				facesMessages.add(Severity.ERROR, "O valor informado do CPF/CNPJ não é um formato válido.");
//				return;
			}
		}

		/*
		 * Retorna total de usuarios encontrados para exibir durante busca de mais
		 * resultadis
		 */
//		usuariosTotal = getUsuarioEAO().usuariosTotal(campoCodigoUsuario, isNull(campoNomeUsuario),
//				isNull(CpfCnpjFormatado), null, isNull(campoUf));

		// O método isNull verifica se a String está nula ou vazia, e retorna
		// null em ambos os casos.
		// Ele foi criado para diminuir a quantidade de validações necessárias
		// na query de usuários.
//		List<Usuario> usuariosEncontrados = getUsuarioEAO().pesquisarUsuarios(campoCodigoUsuario,
//				isNull(campoNomeUsuario), isNull(CpfCnpjFormatado), null, isNull(campoUf), FIRST_RESULT, MAX_RESULTS);

//		if (usuariosEncontrados == null) {
//			facesMessages.add(Severity.INFO, "Nenhum Usuário encontrado com os dados fornecidos.");
//			return;
//		} else {
//			for (Usuario usuario : usuariosEncontrados) {
//				usuarioBeanLista.add(new UsuarioBean(usuario));
//			}
//		}

	}

	/**
	 * Método que verifica se todos os campos de busca estão vazios ao mesmo tempo.
	 * 
	 * @return TRUE se estiverem, FALSE se ao menos um estiver preenchido.
	 */
	private boolean checarPreenchimento() {
		boolean retorno = (campoCodigoUsuario == null || campoCodigoUsuario <= 0)
				&& (campoCPFCNPJ == null || "".equals(campoCPFCNPJ))
				&& (campoNomeUsuario == null || "".equals(campoNomeUsuario));
		// && (campoUf == null || "".equals(campoUf));

		return retorno;
	}

	private String isNull(String string) {
		if (string == null)
			return null;
		else if (string.equals(""))
			return null;
		else
			return string;

	}

//	public void selecionarUsuario(Long codUsuario) {
//		showPanel = false;
//		if (usuario == null || !codUsuario.equals(usuario.getCodUsuario())) {
//			setNovoUsuario(codUsuario);
//		}
//		verificaSeUsuarioNotificado();
//	}
//
//	public String trocarUsuario() {
//		setUsuariosBean(null);
//		setShowPanel(true);
//		return "sucesso";
//	}
//
//	public void setNovoUsuario(Long cod) {
//
//		if (cod > 0) {
//			usuario = getUsuarioEAO().findById(cod);
//			usuarioBean = new UsuarioBean(usuario);
//			usuarioBean.setStatusBloqueado(getUsuarioEAO().getStatusUsuario(cod));
//		}
//
//		limparMemoria(false);
//	}

//	public void limparMemoria(Boolean apagarUsuario) {
//
//		// Método comum tanto a troca de usuário quanto à remoção do usuário -
//		// Libera a memória do servidor. Só é acionado pelo método de
//		// RemoverUsuario.
//		if (apagarUsuario) {
//			limparMemoriaUsuario();
//			Log.sysinfo(this, "O usuário de música foi deselecionado.");
//		} else {
//			Log.sysinfo(this, "O usuário de música foi trocado.");
//		}
//
//		// Aciona o evento de trocarUsuario, que acionará métodos nos backing
//		// beans de cobrança.
//		Events.instance().raiseEvent("trocarUsuario");
//
//		// Redireciona o usuário para o começo da tarefa e termina a
//		// conversação.
//		encerrarConversacao();
//	}
//
//	public void limparMemoriaUsuario() {
//		setUsuario(null);
//		setUsuarioBean(null);
//		limparCamposUsuario();
//		setShowPanel(false);
//	}

	/**
	 * Método que remove da sessão todas as informações da ultima busca de usuário
	 * realizada, incluindo o usuário escolhido.
	 * 
	 * @return Uma String contendo "sucesso" para fins de navegação.
	 */
//	public String removerUsuario() {
//		codUsuario = 0L;
//		limparMemoria(true);
//		return "sucesso";
//	}
//
//	public void exportar() {
//
//	}
//
//	public void setMaisElementosLayout() {
//
//		if (usuarioBeanLista == null || usuarioBeanLista.isEmpty()) {
//			return;
//		}
//
//		int validaLimite = 0;
//		int a = numElementosLayout;
//		int j = numElementosLayout + 10;
//
//		/*
//		 * Atribui o valor total da consulta a variavel de paginação ao um valor
//		 * superior ao total
//		 */
//		if (j > usuariosTotal.intValue()) {
//			numElementosLayout = usuariosTotal.intValue();
//			j = numElementosLayout;
//			a = numElementosLayout;
//
//			/* Indica que a busca atingiu o valor máximo */
//			validaLimite++;
//		}
//
//		/*
//		 * Quando a variavel de paginação atingir o mesmo valor máximo da consulta por
//		 * bloco (100), será realizada uma nova consulta
//		 */
//		if (numElementosLayout == MAX_RESULTS) {
//			FIRST_RESULT = MAX_RESULTS;
//			MAX_RESULTS += 100;
//
//			if (MAX_RESULTS > usuariosTotal.intValue()) {
//				MAX_RESULTS = MAX_RESULTS - usuariosTotal.intValue();
//			}
//
//			/* Realiza a consulta por bloco */
//			buscarMaisUsuarios();
//
//			/* Variavel de paginação recebe linha inicial da consulta */
//			numElementosLayout = FIRST_RESULT;
//		}
//
//		/* Realiza a paginação */
//		for (int i = a; i < j; i++) {
//			if (numElementosLayout < usuarioBeanLista.size()) {
//				numElementosLayout = numElementosLayout + 1;
//			} else {
//				validaLimite++;
//				break;
//			}
//		} // valida se usuário foi selecionado...
//
//		if (validaLimite > 0) {
//			facesMessages.add(Severity.INFO, "Todos os usuários já foram exibidos !");
//		}
//	}

//	@End(beforeRedirect = true)
//	private void encerrarConversacao() {
//
//		// Se nenhuma página foi especificada como o ínicio do fluxo, retorna à
//		// Home.
//		if (redirectTo == null) {
//			redirectTo = "/sga/home.seam";
//		}
//
//		try {
//			FacesContext.getCurrentInstance().getExternalContext().redirect(redirectTo);
//		} catch (IOException e) {
//			facesMessages.add(Severity.ERROR, "Erro ao tentar redirecionar o usuário para a página inicial.");
//			e.printStackTrace();
//		}
//
//	}
//
//	public boolean isUsuarioBloqueadoSGI(long codUsuario) throws SgiCallerException {
//		SgiServiceCaller caller = SgiServiceCaller.initialize("/campanha/verificarCampanhaUsuario");
//
//		Map<String, Object> request = new HashMap<String, Object>();
//		request.put("codUsuario", codUsuario);
//
//		try {
//			return caller.post(request).contains("true");
//		} catch (SgiCallerException e) {
//			// REMOVER ESSE TRY/CATCH NO FUTURO PROXIMO, QUANDO GARANTIRMOS QUE O SGI NAO
//			// VAI CAIR
//			// FOI INCLUIDO PARA EVITAR BLOQUEIO NA GERACAO DE ACORDO DE USUARIO
//			// CASO O SGI ESTEJA FORA DO AR
//			e.printStackTrace();
//
//			return false;
//		}
//	}
//
//	public boolean isUsuarioBloqueadoSGI() throws SgiCallerException {
//		return isUsuarioBloqueadoSGI(usuarioBean.getCod());
//	}
//
//	public String validaBloqueioUsuario() {
//		UsuarioSistema usuarioSistemaBean;
//		usuarioSistemaBean = pesquisaUsuarioSistema.getUsuarioSistema();
//		ArrayList<UsuarioBloqueado> usuarioBloquados = new ArrayList<UsuarioBloqueado>();
//		bloqueadoEAO = (UsuarioBloqueadoEAOLocal) ServiceLocator.getInstance()
//				.lookup("sga-ear/aentities/pessoa/UsuarioBloqueadoEAO/local");
//
//		usuarioBloquados = (ArrayList<UsuarioBloqueado>) bloqueadoEAO.getInfoBloqueioUsuario(usuarioBean.getCod());
//
//		// caso volte algum bloqueio
//		if (!usuarioBloquados.isEmpty()) {
//			// percorre todos os bloquios existentes
//			for (UsuarioBloqueado bloqueado : usuarioBloquados) {
//				// verifica se algum bloqueio está ativo e a origem parte de
//				// outro sistema
//				if (!bloqueado.getTipOrigemBloqueio().equals("SGA")) {
//
//					if (usuarioSistemaBean.getUnidade().equals("SEDE")
//							|| usuarioSistemaBean.getUnidade().equals("CENTRAL")
//							|| identity.hasRole("acordo.clientebloqueado")) {
//
//						return "";
//
//					} else {
//
//						facesMessages.add(Severity.WARN, "Usuario bloqueado para cobranças. Origem do bloqueio:"
//								+ bloqueado.getTipOrigemBloqueio());
//
//						// para com processo de pesquisa de crédito a cobranças
//						// para acordo
//
//						return "bloqueado";
//
//					}
//
//				}
//			}
//
//		}
//
//		return "";
//	}

//	public String validaBloqueioUsuario(long codUsuario) {
//		UsuarioSistema usuarioSistemaBean;
//		usuarioSistemaBean = pesquisaUsuarioSistema.getUsuarioSistema();
//		ArrayList<UsuarioBloqueado> usuarioBloquados = new ArrayList<UsuarioBloqueado>();
//		bloqueadoEAO = (UsuarioBloqueadoEAOLocal) ServiceLocator.getInstance()
//				.lookup("sga-ear/aentities/pessoa/UsuarioBloqueadoEAO/local");
//
//		usuarioBloquados = (ArrayList<UsuarioBloqueado>) bloqueadoEAO.getInfoBloqueioUsuario(codUsuario);
//
//		// caso volte algum bloqueio
//		if (!usuarioBloquados.isEmpty()) {
//			// percorre todos os bloquios existentes
//			for (UsuarioBloqueado bloqueado : usuarioBloquados) {
//				// verifica se algum bloqueio está ativo e a origem parte de
//				// outro sistema
//				if (!bloqueado.getTipOrigemBloqueio().equals("SGA")) {
//
//					if (usuarioSistemaBean.getUnidade().equals("SEDE")
//							|| usuarioSistemaBean.getUnidade().equals("CENTRAL")) {
//
//						return "";
//
//					} else {
//
//						facesMessages.add(Severity.WARN, "Usuario bloqueado para cobranças. Origem do bloqueio:"
//								+ bloqueado.getTipOrigemBloqueio());
//
//						// para com processo de pesquisa de crédito a cobranças
//						// para acordo
//
//						return "bloqueado";
//
//					}
//
//				}
//			}
//
//		}
//
//		return "";
//	}

	/**
	 * Método responsável pela verificação de Usuário já foi notificado ou não.
	 * 
	 * @author lfernando
	 */
//	public boolean verificaSeUsuarioNotificado() {
//		try {
//
//			SgaServiceCaller c = SgaServiceCaller.initialize("/r/usuario/ObterUsuarioResumidoPorCpfCnpj");
//
//			Map<String, Object> cpfcnpj = new HashMap<String, Object>();
//			cpfcnpj.put("NRO_CPFCNPJ", usuarioBean.getCpfCnpj());
//
//			Map<String, Object> request = new HashMap<String, Object>();
//			request.put("parametros", cpfcnpj);
//
//			String post = c.post(request);
//			ObjectMapper obj_ObjectMapper = new ObjectMapper();
//			ConsultaDadosMultiResponse srv = obj_ObjectMapper.readValue(post, ConsultaDadosMultiResponse.class);
//
//			for (Map<String, Object> item : srv.getListas().get("USUARIO_RESUMIDO")) {
//				if (item.get("DAT_NOTIFICACAO") != null) {
//					usuarioNotificado = true;
//				} else {
//					usuarioNotificado = false;
//				}
//
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return usuarioNotificado;
//
//	}

	/**
	 * Método responsável pela redirecionamento de tela de informações de usuário
	 * para tela de notificação
	 * 
	 * @author lfernando
	 */
//	public String redireciona() {
//		return "/usuario/ConsultaNotificacao.seam?codigoUsuario=" + usuarioBean.getCod() + "nomeUsuario"
//				+ usuarioBean.getNome();
//	}
//
//	public void limparCampos() {
//		limparCamposUsuario();
//		numElementosLayout = 10;
//		FIRST_RESULT = 0;
//		MAX_RESULTS = 100;
//		usuariosTotal = new BigDecimal(0);
//	}

	public void verificaRole(Long codCliente) {

	}

//	public String getUsuariosTotal() {
//		return usuariosTotal.toString();
//	}

	public Long getCampoCodigoUsuario() {
		return campoCodigoUsuario;
	}

	public void setCampoCodigoUsuario(Long campoCodigoUsuario) {
		this.campoCodigoUsuario = campoCodigoUsuario;
	}

	public String getCampoNomeUsuario() {
		return campoNomeUsuario;
	}

	public void setCampoNomeUsuario(String campoNomeUsuario) {
		this.campoNomeUsuario = campoNomeUsuario;
	}

	public String getCampoCPFCNPJ() {
		return campoCPFCNPJ;
	}

	public void setCampoCPFCNPJ(String campoCPFCNPJ) {
		this.campoCPFCNPJ = campoCPFCNPJ;
	}

	public String getCampoUf() {
		return campoUf;
	}

	public void setCampoUf(String campoUf) {
		this.campoUf = campoUf;
	}

	public Long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Long codUsuario) {
		this.codUsuario = codUsuario;
	}

//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//	public UsuarioBean getUsuarioBean() {
//		return usuarioBean;
//	}
//
//	public void setUsuarioBean(UsuarioBean usuarioBean) {
//		this.usuarioBean = usuarioBean;
//	}
//
//	public Integer getNumElementosLayout() {
//		if (numElementosLayout == null)
//			return 0;
//		else
//			return numElementosLayout;
//	}
//
//	public void setNumElementosLayout(Integer numElementosLayout) {
//		this.numElementosLayout = numElementosLayout;
//	}
//
//	public boolean isShowPanel() {
//		return showPanel;
//	}
//
//	public void setShowPanel(boolean showPanel) {
//		this.showPanel = showPanel;
//		setUsuariosBean(null);
//		setCampoCodigoUsuario(null);
//		setCampoNomeUsuario(null);
//		setCampoCPFCNPJ(null);
//		setCampoUf(null);
//	}

	public String getRedirectTo() {
		return redirectTo;
	}

	public void setRedirectTo(String redirectTo) {
		this.redirectTo = redirectTo;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	
	public boolean isUsuarioNotificado() {
		return usuarioNotificado;
	}

	public void setUsuarioNotificado(boolean usuarioNotificado) {
		this.usuarioNotificado = usuarioNotificado;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
