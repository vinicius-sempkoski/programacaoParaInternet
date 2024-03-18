package br.unipar.programacaointernet.serviceccep.servicecep.service;

import br.unipar.programacaointernet.serviceccep.servicecep.dao.EnderecoDAO;
import br.unipar.programacaointernet.serviceccep.servicecep.dao.EnderecoDAOImpl;
import br.unipar.programacaointernet.serviceccep.servicecep.model.Endereco;
import br.unipar.programacaointernet.serviceccep.servicecep.util.EntityManagerUtil;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;

@WebService(endpointInterface = "br.unipar.programacaointernet.serviceccep.servicecep.service.EnderecoSEI")
public class EnderecoSIB implements EnderecoSEI {

    @Override
    public Endereco consultaEndereco(Long idEndereco) {
        EnderecoDAO enderecoDAO = new EnderecoDAOImpl(EntityManagerUtil.getManager());

        Endereco endereco = enderecoDAO.findById(idEndereco);
        return endereco;
    }

    @Override
    public Endereco consultaCEP(String cep) {
        EnderecoDAO enderecoDAO = new EnderecoDAOImpl(EntityManagerUtil.getManager());

        Endereco endereco = enderecoDAO.findByCep(cep);

        return endereco;
    }
    @Override
    public String deletarEndereco(String cep) {
        EnderecoDAO enderecoDAO = new EnderecoDAOImpl(EntityManagerUtil.getManager());

        Endereco endereco = enderecoDAO.findByCep(cep);

        enderecoDAO.delete(endereco);

        return "sucesso" + endereco.getCep();
    }
    @Override
    public Endereco consultaCep(String cep) {
        EnderecoDAO enderecoDAO = new EnderecoDAOImpl(EntityManagerUtil.getManager());

        try {
            Endereco endereco = enderecoDAO.findByCep(cep);

            return endereco;
        } catch (Exception e) {
            try {
                URL url = new URL("http://viacep.com.br/ws/" +  cep.replace("-",
                        "").replace(".", "") + "/xml/");

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                String inputLine;
                String result = "";

                while ((inputLine = in.readLine()) != null)
                    result += inputLine;

                in.close();
                Endereco endereco = new Endereco();
//            endereco = Endereco.unmarshalFromString(endereco);
//            endereco.toString();

                enderecoDAO.save(endereco);

                return endereco;
            } catch (Exception a) {
                Endereco endereco = new Endereco();
                return endereco;
            }
        }
    }
    @Override
    public String editarUsuario(String cep) {
        EnderecoDAO enderecoDAO = new EnderecoDAOImpl(EntityManagerUtil.getManager());

        Endereco endereco = enderecoDAO.findByCep(cep);

        endereco.setComplemento(complemento);

        enderecoDAO.update(endereco);

        return "Endereço " + endereco.getCep() + " editado com sucesso!";    }
}