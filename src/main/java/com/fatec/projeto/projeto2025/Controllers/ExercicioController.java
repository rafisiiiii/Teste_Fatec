package com.fatec.projeto.projeto2025.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExercicioController {
    
    // Usuário informa a idade e o programa faz a verificação, informando se é criança, adolescente, adulto ou idoso.
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

    // Usuário informa um número e o programa verifica se é um número válido, se sim, verifica se é impar ou par
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

    // Usuário informa o peso e a altura e o programa calcula o IMC, informando em qual situação se enquadra
    @GetMapping("/calc-imc/{peso}/{altura}")
        public String CalcIMC(@PathVariable String peso, @PathVariable String altura){
            try{
                double pesoDouble = Double.parseDouble(peso);
                double alturaDouble = Double.parseDouble(altura);

                if (pesoDouble <= 0 || alturaDouble <= 0){
                    return "Dados inválidos";
                }

                double imc = pesoDouble / (alturaDouble * alturaDouble);

                if (imc < 18.5){
                    return "Abaixo do peso";
                }else if (imc >= 18.5 && imc <= 24.9){
                    return "Peso normal";
                }else if (imc >= 25.0 && imc <= 29.9){
                    return "Sobrepeso";
                }else if (imc >= 30.0 && imc <= 34.9){
                    return "Obesidade grau 1";
                }else if (imc >= 35.0 && imc <= 39.9){
                    return "Obesidade grau 2";
                }else{
                    return "Obesidade garu 3";
                }
            }catch (NumberFormatException e){
                return "Dados inválidos";
            }
        }
}