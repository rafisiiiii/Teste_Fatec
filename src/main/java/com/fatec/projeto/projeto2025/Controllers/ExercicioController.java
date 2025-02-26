package com.fatec.projeto.projeto2025.Controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioController {

    

    @GetMapping("")
    public String verificaIdade(){
        return "Informe a idade: ";
    }

    @GetMapping("{idade}")
    public String verificaIdade(@PathVariable Optional<String> idade){
        idade.ifPresent(value -> System.out.println("Idade: " + value));
        int idadeInt = Integer.parseInt(idade.get());
            if (idadeInt >= 18) {
                return "Idade é 18 ou mais";
            } else {
                return "Idade é menor que 18";
            }
    }
}   
