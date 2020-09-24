const pegaURL = new URL(window.location)

const id = pegaURL.searchParams.get('id')

const nossonumero = document.querySelector('[data-nossonumero]')
const datainicio = document.querySelector("[data-datainicio]")
const datafim = document.querySelector("[data-datafim]")
const ocorrencias = document.querySelector("[data-ocorrencia]")
const unidades = document.querySelector("[data-unidade]")

detalhaRetorno(id).then( dados => {

    nossonumero.value = dados.nossoNumero;
    datainicio.value = dados.datInicio;
    datafim.value = dados.datFim;
    ocorrencias.value = dados.ocorrencia;
    unidades.value = dados.unidade;

})

const formEdicao = document.querySelector('[data-form]')

const alerta = (classe, mensagem) => { 
    const linha = document.createElement('tr');

    const conteudoLinha = `
    <div class="${classe}">${mensagem}</div>
    
`
  
    linha.innerHTML = conteudoLinha;
    return linha;
} 

formEdicao.addEventListener('submit', event => { 
    event.preventDefault()
    
    editaRetorno(id, nossonumero.value, datainicio.value, datafim.value, ocorrencias.value, unidades.value)
    .then( resposta => { 
        if( resposta.status === 200){
            formEdicao.appendChild(alerta(
                "alert alert-success",
                "Retorno editado com sucesso!"
            ))
        } else { 
            formEdicao.appendChild(alerta(
                "alert alert-warning",
                "Retorno não editado! Verifique se todos os campos estão preenchidos corretamente."
            ))
        }
    })
    
    

})


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