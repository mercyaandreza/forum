package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.DetalharDTO;
import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.AtualizaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("cadastrar-curso")
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converterForm(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @GetMapping("list-all")
    public List<TopicoDTO> listaAll() {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDTO.converterDTO(topicos);
    }

    @GetMapping("listar-curso")
    public List<TopicoDTO> lista(@Valid String nomeCurso) {
        if(nomeCurso == null){
            return new ArrayList<>();
        } else{
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
            return TopicoDTO.converterDTO(topicos);
        }
    }

    @GetMapping ("detalhe/{id}")
    public DetalharDTO detalharTopico (@PathVariable Long id) {
        Topico topicoId = topicoRepository.getById(id);
        return new DetalharDTO(topicoId);
    }

    @PutMapping("atualizar/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaoTopicoForm atualizaoTopicoForm) {
        Topico topico = atualizaoTopicoForm.atualizar(id, topicoRepository);
        return ResponseEntity.ok(new TopicoDTO(topico));
    }

    @DeleteMapping ("remover/{id}")
    @Transactional
    public ResponseEntity <?>remover(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

