package br.com.alura.forum.modelo;


import java.util.ArrayList;
import java.util.List;

public class Topico {

    private Long id;
    private String titulo;
    private String mensagem;
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    private Curso curso;
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(String titulo, String mensagem, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.curso = curso;
    }
}
