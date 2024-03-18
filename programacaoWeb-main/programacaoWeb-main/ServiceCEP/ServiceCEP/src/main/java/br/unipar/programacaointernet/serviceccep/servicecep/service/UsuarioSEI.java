package br.unipar.programacaointernet.serviceccep.servicecep.service;

import br.unipar.programacaointernet.serviceccep.servicecep.model.Usuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface UsuarioSEI {

    @WebMethod
    String boasVindas(@WebParam(name = "nome") String nome);
    @WebMethod
    Usuario consultaUsuario(@WebParam(name = "idUsuario") Long idUsuario);
    @WebMethod
    String salvarUsuario(@WebParam(name = "nome") String nome, @WebParam(name = "login") String login, @WebParam(name = "senha") String senha);
    @WebMethod
    String editarUsuario(@WebParam(name = "idUsuario") Long idUsuario, @WebParam(name = "senha") String senha);
    @WebMethod
    String deletarUsuario(@WebParam(name = "idUsuario") Long idUsuario);
    @WebMethod
    List<Usuario> consultaUsuarios();

}
