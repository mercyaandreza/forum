package br.com.alura.forum.validacao;

import lombok.Getter;
import org.springframework.context.MessageSource;

@Getter
public class ErrorDTO {

    private String campo;
    private String mensagem;

    public ErrorDTO(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }
}
