package br.com.alura.forum.modelo;

import java.time.LocalDateTime;

public class Resposta {

    private Long id;
    private String mensagem;
    private Topico topico;
    private Usuario autor;
    private Boolean solucao = false;
}
