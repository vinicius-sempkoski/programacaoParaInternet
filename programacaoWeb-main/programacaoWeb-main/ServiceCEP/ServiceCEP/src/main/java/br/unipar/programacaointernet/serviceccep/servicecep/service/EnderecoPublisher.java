package br.unipar.programacaointernet.serviceccep.servicecep.service;

import jakarta.xml.ws.Endpoint;

public class UsuarioPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8000/endereco", new EnderecoSIB());

        System.out.println("Endereco Endpoint publicado com sucesso");
    }
}