package br.com.alura.business;


import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class AgendamentoEmailBusiness {

    public List<String> listarAgendamentoEmail(){
        List<String> emails = new ArrayList<>();
        emails.add("email@teste.com");
        emails.add("email@teste2.com");
        emails.add("fran@teste.com");
        return emails;
    }


}
