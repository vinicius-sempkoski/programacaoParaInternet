package br.unipar.programacaointernet.serviceccep.servicecep.service;

import br.unipar.programacaointernet.serviceccep.servicecep.model.Endereco;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface EnderecoSEI {

    @WebMethod
    Endereco consultaEndereco(@WebParam(name = "idEndereco") Long idEndereco);
    Endereco consultaCEP(@WebParam(name = "cep") String cep);
    String salvarEndereco(@WebParam(name = "cep") String cep);
    String editarEndereco(@WebParam(name = "idEndereco") Long id, @WebParam(name = "cep") String cep);
    String deletarEndereco(@WebParam(name = "cep") String cep);

}