package br.com.alura.business;


import br.com.alura.dao.AgendamentoEmailDao;
import br.com.alura.entity.AgendamentoEmail;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class AgendamentoEmailBusiness {

    @Inject
    private AgendamentoEmailDao agendamentoEmailDao;

    public List<AgendamentoEmail> listarAgendamentoEmail(){
        return agendamentoEmailDao.listarAgendamentosEmail();
    }

    public void salvarAgendamentos(@Valid AgendamentoEmail agendamentoEmail){
        agendamentoEmail.setEnaviado(false);
        agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
    }

}
