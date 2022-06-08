package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Resposta;
import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class DetalharDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao ;
    private String nomeAutor;
    private StatusTopico statusTopico;
    private List<RespostaDTO> resposta;


    public DetalharDTO(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.statusTopico = topico.getStatus();
        this.resposta = new ArrayList<>();
        this.resposta.addAll(topico.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));

    }


}
