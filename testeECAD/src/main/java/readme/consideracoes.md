Percepções e dificuldade:

O projeto original possui duas funções principais:

1 - Tela de Consulta Retorno

Contendo: Date datInicio, Date datFim, String nossoNumero, OcorrenciaBancariaEnum ocorrenciaEnum, String unidade, int numElementos, int tamPagina

Outros elementos foram retirados no novo projeto, pois não tenho conhecimento total da regra de negocios.

2 - Tela de Pesquisa de Usuario


BUSCA TODOS OS VALORES AQUI >>>	value="#{ConsultaRetorno.objetos}" var="_retornos"

Cliente = #{_retornos.usuarioBean.nome}
CPF/CNPJ = #{_retornos.usuarioBean.cpfCnpjFormatado}"
Nº Boleto = #{_retornos.nroBoleto}
Valor do Título = #{_retornos.getValorTituloFormatado()}
Tipo da Ocorrência = "#{_retornos.tipoOcorrenciaDesc}" />
Data da Ocorrência = #{_retornos.dataOcorrencia}"


Há consulta a Bradesco, por ex, usa-se a classe TituloCobrancaEAO, pela consultaRetorno: 

tituloCobrancaEAO.getTituloCobrancaByIdTituloBancario(Long.valueOf(controleBradesco.getNroBoleto()).

para recuperar um usuarioBean pelo id dele no titulo de cobrança.


Minhas dificuldades principais foram tempo, pois tive 6h para fazer tudo, vi ser algo que vai exigir bastante atenção, mas com o pessoal para tirar as duvidas creio que fluirá bem.

usei a fetch api para fazer o front, foi mais rapido para entregar algo que voces possam testar localmente.

Espero que gostem.