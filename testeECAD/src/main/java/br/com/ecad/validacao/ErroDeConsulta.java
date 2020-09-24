package br.com.ecad.validacao;

public class ErroDeConsulta {
	
	private String campo;
	private String erro;
	
	public ErroDeConsulta(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	

}
