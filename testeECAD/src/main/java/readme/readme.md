API

- Buscar combo unidades
GET: http://localhost:8080/retorno/unidades

- Buscar combo ocorrencias
GET: http://localhost:8080/retorno/ocorrencias

- Buscar retornos cadastrados
GET: http://localhost:8080/retorno/

- Buscar retornos cadastrados por id
GET: http://localhost:8080/retorno/**

- Buscar retornos cadastrados por nossoNumero
GET: http://localhost:8080/retorno/nossonumero/****
GET: http://localhost:8080/retorno?nossoNumero=****

- Consulta por campos (É nescessário preencher a Data Inicial e Data Final ou o Nosso Número)
POST: http://localhost:8080/retorno/consulta

- Cadastrar (Todos os campos sao requeridos)
POST: http://localhost:8080/retorno/

--- JSON PARA CADASTRO ---
{
"nossoNumero":"122432",
"datInicio":"13/11/2020",
"datFim":"11/12/2021",
"ocorrencia":"ocorrenciaalterada3",
"unidade":"unidade2"
}

- Excluir um cadastro por id
DELETE: http://localhost:8080/retorno/***

- Alterar um cadastro por id
PUT: http://localhost:8080/retorno/***

--- JSON PARA ALTERACOES ---
{
"nossoNumero":"122432",
"datInicio":"13/11/2020",
"datFim":"11/12/2021",
"ocorrencia":"ocorrenciaalterada3",
"unidade":"unidade2"
}




