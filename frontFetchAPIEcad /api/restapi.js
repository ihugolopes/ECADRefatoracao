
const listarClientes = () => {
  
  return fetch("http://localhost:8080/retorno", {
      method: "get",
      mode: 'cors'
    }).then(resposta =>{
      return resposta.json();
    }).then(json => {
      console.log(json)
       return json;
    })

}

const listarOcorrencias = () => {
  
  return fetch("http://localhost:8080/retorno/ocorrencias", {
      method: "get",
      mode: 'cors'
    }).then(resposta =>{
      return resposta.json();
    }).then(json => {
      console.log(json)
       return json;
    })

}

const listarUnidades = () => {
  
  return fetch("http://localhost:8080/retorno/unidades", {
      method: "get",
      mode: 'cors'
    }).then(resposta =>{
      return resposta.json();
    }).then(json => {
      console.log(json)
       return json;
    })

}

const cadastrarRetorno = (nossoNumero, datInicio, datFim, ocorrencia, unidade) => {
  const json = JSON.stringify({
    nossoNumero: nossoNumero,
    datInicio: datInicio,
    datFim: datFim,
    ocorrencia: ocorrencia,
    unidade: unidade
  })


  return fetch("http://localhost:8080/retorno", {
      method: "POST",
      headers: {
        'Content-type':'application/json'
      },
      body: json
    }).then(resposta =>{
      return resposta.json();
    }).then(json => {
      console.log(json)
       return json;
    })
    .then(resp => {
      return resp.body;
    })

}

const consultar = (nossoNumero, datInicio, datFim, ocorrencia, unidade) => {
  const json = JSON.stringify({
    nossoNumero: nossoNumero,
    datInicio: datInicio,
    datFim: datFim,
    ocorrencia: ocorrencia,
    unidade: unidade
  })


  return fetch("http://localhost:8080/retorno/consulta", {
      method: "POST",
      headers: {
        'Content-type':'application/json'
      },
      body: json
    }).then(resposta =>{
      return resposta.json();
    }).then(json => {
      console.log(json)
       return json;
    })
    .then(resp => {
      return resp.body;
    })

}


const deletaRetorno = id => {
  return fetch(`http://localhost:8080/retorno/${id}`, {
      method: "DELETE",
    })

}

const detalhaRetorno = id => {
  return fetch(`http://localhost:8080/retorno/${id}`, {
      method: "GET",
      mode: 'cors'
    }) 
  .then(resposta =>{
    return resposta.json();
  }).then(json => {
    console.log(json)
     return json;
  })
  }

  const editaRetorno = (id, nossoNumero, datInicio, datFim, ocorrencia, unidade) => {
    const json = JSON.stringify({
      nossoNumero: nossoNumero,
      datInicio: datInicio,
      datFim: datFim,
      ocorrencia: ocorrencia,
      unidade: unidade
    })

    return fetch(`http://localhost:8080/retorno/${id}`,{
      method: 'PUT',
      headers: {
        'Content-type': 'application/json'
      },
      body: json
    })
  }
