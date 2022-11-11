package org.soulcodeacademy.helpr.services;

import ch.qos.logback.core.net.server.Client;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() {
        return this.clienteRepository.findAll();
    }


    public Cliente getCliente(Integer idCliente){
        // Optional = pode existir ou não a entidade
        Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);

        if(cliente.isEmpty()){
            throw new RuntimeException("O cliente não foi encontrado");
        } else {
            return cliente.get();    //pega o valor da entidade encontrada
        }
    }

    public Cliente salvar(ClienteDTO dto) {
        // Criação da entidade Cliente, a partir dos dados validados do DTO
        Cliente novoCliente = new Cliente(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getTelefone());

        return this.clienteRepository.save(novoCliente);
    }
    // método atualizar, quem é o cliente e quais os dados
    public Cliente atualizar(Integer idCliente, ClienteDTO dto){
        Cliente clienteAtual = this.getCliente(idCliente);
        clienteAtual.setNome(dto.getNome());
        clienteAtual.setEmail(dto.getTelefone());
        clienteAtual.setCpf(dto.getSenha());
        clienteAtual.setSenha(dto.getSenha());
        return this.clienteRepository.save(clienteAtual);
    }
    public void deletar(Integer idCliente){
        Cliente cliente = this.getCliente(idCliente);
        this.clienteRepository.delete(cliente);
    }


    // Quando usar entidade e dto?
    // Entidade = retorno dos dados
    // DTO = entrada de dados
}
