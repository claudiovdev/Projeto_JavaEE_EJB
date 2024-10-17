package br.com.alura.timer;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;
import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

@Singleton
public class AgendamentoEmailTimer {
    @Inject
    private AgendamentoEmailBusiness agendamentoEmailBusiness;

    public static final Logger logger = Logger.getLogger(AgendamentoEmailTimer.class.getName());
    @Schedule(hour = "*", minute = "*")
    public void enviarEmailAgendados(){
        List<AgendamentoEmail> emailsNaoEnviados = agendamentoEmailBusiness.listarAgendamentoEmailNaoEnviados();
        emailsNaoEnviados.forEach(agendamentoEmail ->{
            logger.info(String.format("Enviando email para %s", agendamentoEmail.getEmail()));
            agendamentoEmailBusiness.enviarEmail(agendamentoEmail);
            logger.info(String.format("enviado email para %s", agendamentoEmail.getEmail()));

        });
    }
}
