package com.fatec.projeto.projeto2025.entities;
 
import jakarta.persistence.*;
 
@Entity

@Table(name = "usuarios")

public class Usuario {
 
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
 
    @Column(nullable = false)

    private String nome;
 
    @Column(nullable = false, unique = true)

    private String email;
 
    @Column(nullable = false)

    private String senha;
 
    public Usuario() {

    }
 
    public Usuario(String nome, String email, String senha) {

        this.nome = nome;

        this.email = email;

        this.senha = senha;

    }
 
    public Long getId() {

        return id;

    }
 
    public void setId(Long id) {

        this.id = id;

    }
 
    public String getNome() {

        return nome;

    }
 
    public void setNome(String nome) {

        this.nome = nome;

    }
 
    public String getEmail() {

        return email;

    }
 
    public void setEmail(String email) {

        this.email = email;

    }
 
    public String getSenha() {

        return senha;

    }
 
    public void setSenha(String senha) {

        this.senha = senha;

    }

}
 