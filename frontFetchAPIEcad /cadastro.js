const formCadastro = document.querySelector("[data-form]")

formCadastro.addEventListener("submit",
    event => { 
        event.preventDefault();
        const nossonumero = event.target.querySelector("[data-nossonumero]").value
        const datainicio = document.getElementById("data-datainicio").value
        const datafim = document.getElementById("data-datafim").value
        const ocorrencia = document.getElementById("data-ocorrencia").value
        const unidade = document.getElementById("idunidade").value
        cadastrarRetorno(nossonumero, datainicio, datafim, ocorrencia, unidade);
     
        
    }
)


const formPesquisa = document.querySelector("[data-formpesquisa]")

formPesquisa.addEventListener("submit",
    event => { 
        event.preventDefault();
        const nossonumero = document.querySelector('[data-nossonumero-pesquisa]')
        const datainicio = document.querySelector("[data-datainicio-pesquisa]")
        const datafim = document.querySelector("[data-datafim-pesquisa]")
        const ocorrencias = document.querySelector("[data-ocorrencia-pesquisa]")
        const unidades = document.querySelector("[data-unidade-pesquisa]")
        cadastrarRetorno(nossonumero, datainicio, datafim, ocorrencias, unidades);
     
        
    }
)
