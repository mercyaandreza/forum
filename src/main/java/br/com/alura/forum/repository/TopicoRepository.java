package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {


    List<Topico> findByCurso_Nome(String nomeCurso); // curso = entidade de relacionamento + nome do atributo dentro ( o _ sabe que é dentro de curso)

    @Query ("Select t from Topico t where t.curso.nome = :nomeCurso")
    List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso); // outra opção utilizando query
}
