package br.com.alura.forum.modelo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Topico {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
    @ManyToOne // um usuario tem vários tópicos
    private Usuario autor;
    @ManyToOne // um curso tem vários tópicos
    private Curso curso;
    @OneToMany(mappedBy = "topico") // um topico pode ter várias respostas
    private List<Resposta> respostas = new ArrayList<>();
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Topico() {
    }

    public Topico(String titulo, String mensagem, Curso curso) {
        this.titulo = titulo;
        //this.mensagem = mensagem;
        this.curso = curso;
    }


}
