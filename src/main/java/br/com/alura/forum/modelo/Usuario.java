package br.com.alura.forum.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Usuario {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id; // chave primária
    private String nome;
    private String email;
    private String senha;


}
