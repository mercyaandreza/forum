package br.com.alura.forum.controller;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TopicosController {

    @RequestMapping("/topicos")
    public List<Topico> lista() {

        Topico topico = new Topico("Titulo 1", "adicionando titulo 1", new Curso("Programacao", "BackEnd"));
        return Arrays.asList(topico);

    }
}
