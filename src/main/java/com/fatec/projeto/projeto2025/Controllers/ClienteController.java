package com.fatec.projeto.projeto2025.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.projeto.projeto2025.entities.Cliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
        private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName());

        private final List<Cliente> clientes = new ArrayList<>();
        private Long idCount = 1L;



    //http://localhost:8080/api/cliente/criarCliente => POST
    //http://localhost:9090/api/cliente/deletarCliente => DELETE
    // http://localhost:9090/api/cliente/atualizarCliente => UPDATE

    @PostMapping("/criarCliente")
    public String CriarCliente(@RequestBody Cliente cliente) {
        cliente.setId(idCount++);
        clientes.add(cliente);


        logger.info("Recebido JSON: Nome={}, Idade={}", cliente.getNome(), cliente.getIdade());
        return "O Cliente "+cliente.getNome()+ " de idade "+cliente.getIdade()+" anos foi criado";
    }

    @GetMapping("/listarClientes")
    public List<Cliente> ListarClientes(){
        return clientes;
    }

    @DeleteMapping("/deletarCliente/{id}")
    public String DeletarClientes(@PathVariable Long id){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                clientes.remove(cliente);
                return "Cliente deletado com sucesso";
            }
        }
        return "Não existe um cliente cadastrado com o id: "+id;
    }

    @PutMapping("/atualizarCliente/{id}")
    public String AtualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        for(Cliente c: clientes){
            if(c.getId().equals(id)){
                c.setNome(cliente.getNome());
                c.setIdade(cliente.getIdade());
                return "Cliente atualizado com sucesso";
            }
        }
        return "Não existe um cliente cadastrado com o id: "+id;
    }
}
