const removeRetorno  = id => {
  if(confirm("Deseja deletar o retorno?")) {
    deletaRetorno(id)
  }
}


const exibeCliente = (id, nossoNumero, datInicio, datFim, ocorrencia, unidade) => {
  const linha = document.createElement("tr");
  const conteudoLinha = `
  <td>${nossoNumero}</td>
  <td>${datInicio}</td>
  <td>${datFim}</td>
  <td>${ocorrencia}</td>
  <td>${unidade}</td>
  <button type="button" class="btn btn-danger" onclick="removeRetorno(${id})">Deletar</button>
  <a href="edita-retorno.html?id=${id}"
  <button type="button" class="btn btn-info" onclick="">Editar</button>
  `;

  linha.innerHTML = conteudoLinha;
  return linha;
};

const corpoTabela = document.querySelector("[data-conteudo-tabela]");

listarClientes().then( exibe =>{
  
exibe.forEach(indice => {
  corpoTabela.appendChild(exibeCliente(indice.id, indice.nossoNumero, indice.datInicio, indice.datFim, indice.ocorrencia, indice.unidade))
})
}
)

//LISTAR PARA COMBO UNIDADES
const exibeUnidades = (sigla) => {
  return `<option>${sigla}</option> `;
  };

  const corpoTabela2 = document.getElementById("idunidade");

  listarUnidades().then( exibe2 =>{
    
  exibe2.forEach(indice2 => {
    corpoTabela2.innerHTML = exibeUnidades(indice2.sigla);
  })
  }
)

//LISTAR PARA COMBO OCORRENCIAS
const exibeOcorrencias = (ocorrencia) => {
  return `<option>${ocorrencia}</option> `;
  };

  const corpoTabela3 = document.getElementById("data-ocorrencia");

  listarOcorrencias().then( exibe3 =>{
    
  exibe3.forEach(indice3 => {
    corpoTabela3.innerHTML = exibeOcorrencias(indice3.ocorrencia);
  })
  }
)

