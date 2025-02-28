package com.fatec.projeto.projeto2025.Controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioController {
    
    @GetMapping("get-idade")
    public String verificaIdade(){
        return "Informe a idade: ";
    }

    @GetMapping("/get-idade/{idade}")
    public String verificaIdade(@PathVariable Optional<String> idade){
        idade.ifPresent(value -> System.out.println("Idade: " + value));
        int idadeInt = Integer.parseInt(idade.get());
            if (idadeInt > 0 && idadeInt < 12) {
                return "Criança";
            } else if (idadeInt >= 12 && idadeInt <= 18) {
                return "Adolescente";
            }else if (idadeInt >= 19 && idadeInt <= 60){
                return "Adulto";
            }else if (idadeInt > 60){
                return "Idoso";
            }else{
                return "Idade inváida";
            }
    } 

    @GetMapping("")
    public String verificaParImpar(){
        return "Informe um número para verificar se é ímpar ou par: ";
    }

    @GetMapping("/get-numero/{numero}")
    public String verificaParImpar(@PathVariable Optional<String> numero){
        try{
            int numInt = Integer.parseInt(numero.get());
            if (numInt % 2 == 0 && numInt > 0) {
                return "Numero é par";
            }else if (numInt % 2 != 0 && numInt > 0){
                return "Número é impar";
            }else if (numInt == 0){
                return "Informe um número maior do que 0!";
            }else{
                return "Número inválido";
            }
        }catch (NumberFormatException e){
            return "O valor informado não é um número";
        }
            
    }
    
}