package com.fatec.projeto.projeto2025.domain.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatec.projeto.projeto2025.entities.Cliente;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
