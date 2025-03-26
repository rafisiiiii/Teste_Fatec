package com.fatec.projeto.projeto2025.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.projeto.projeto2025.domain.cliente.ClienteService;
import com.fatec.projeto.projeto2025.entities.Cliente;

//import org.hibernate.sql.results.LoadingLogger_.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired  
    private ClienteService clienteService;
        private static final Logger logger = LoggerFactory.getLogger(ClienteController.class.getName());
        //private final List<Cliente> clientes = new ArrayList<>();
        //private Long idCount = 1L;

    //http://localhost:8080/api/cliente/criarCliente => POST
    //http://localhost:9090/api/cliente/deletarCliente => DELETE
    //http://localhost:9090/api/cliente/atualizarCliente => UPDATE


    // ------------------- PRIMEIRA VERSÃO -------------------
    // Cria um novo cliente
    //@PostMapping("/criarCliente")
    //public String CriarCliente(@RequestBody Cliente cliente) {
        //cliente.setId(idCount++);
        //clientes.add(cliente);

        //logger.info("Recebido JSON: Nome={}, Idade={}", cliente.getNome(), cliente.getIdade());
        //return "O Cliente "+cliente.getNome()+ " de idade "+cliente.getIdade()+" anos foi criado";
    //}

    // Deleta um cliente
    /*@DeleteMapping("/deletarCliente/{id}")
    public String DeletarClientes(@PathVariable Long id){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                clientes.remove(cliente);
                return "Cliente deletado com sucesso";
            }
        }
        return "Não existe um cliente cadastrado com o id: "+id;
    }

    // Atualiza os dados de um cliente
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
    }*/

    // ------------------- VERSÃO UTILIZANDO O SERVICE -------------------
    @PostMapping("/criarCliente")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        logger.info("Cliente criado: Nome={}, Idade={}", novoCliente.getNome(), novoCliente.getIdade());
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @PutMapping("/atualizarCliente/{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        boolean atualizado = clienteService.atualizarCliente(id, clienteAtualizado);
        if (atualizado) {
            return ResponseEntity.ok("Cliente atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID " + id + " não encontrado.");
        }
    }

    @DeleteMapping("/deletarCliente/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        boolean removido = clienteService.deletarCliente(id);
        if (removido) {
            return ResponseEntity.ok("Cliente removido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe cliente com id: " + id);
        }
    }

    @GetMapping("/buscarCliente/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
        return cliente.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID " + id + " não encontrado."));
    }

}
