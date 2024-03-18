package br.unipar.programacaointernet.serviceccep.servicecep.service;

import br.unipar.programacaointernet.serviceccep.servicecep.dao.UsuarioDAO;
import br.unipar.programacaointernet.serviceccep.servicecep.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.serviceccep.servicecep.model.Usuario;
import br.unipar.programacaointernet.serviceccep.servicecep.util.EntityManagerUtil;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;

@WebService(endpointInterface = "br.unipar.programacaointernet.serviceccep.servicecep.service.UsuarioSEI")
public class UsuarioSIB implements UsuarioSEI{

    @Override
    public String boasVindas(String nome) {
        return "Bem vindo " + nome + " !";
    }

    @Override
    public Usuario consultaUsuario(Long idUsuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());

        Usuario usuario = usuarioDAO.findById(idUsuario);
        return usuario;
    }

    @Override
    public String salvarUsuario(String nome, String login, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());
        Usuario usuario = new Usuario();

        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);

        usuarioDAO.save(usuario);
        return "usuario"+ usuario.getNome() + "salvo";
    }

    @Override
    public String editarUsuario(Long idUsuario, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());

        Usuario usuario = usuarioDAO.findById(idUsuario);

        usuario.setSenha(senha);

        usuarioDAO.update(usuario);

        return "sucesso";
    }
    @Override
    public String deletarUsuario(Long idUsuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManager());

        Usuario usuario = usuarioDAO.findById(idUsuario);

        usuarioDAO.delete(usuario);

        return "sucesso";
    }

}

