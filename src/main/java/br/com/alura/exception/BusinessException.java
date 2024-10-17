package br.com.alura.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception{

    private List<String> mensagens = new ArrayList<>();



    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
        mensagens.add(message);
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void addMensagens(String mensagens) {
        this.mensagens.add(mensagens);
    }


}
