package br.com.alura.business;


import br.com.alura.dao.AgendamentoEmailDao;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.exception.BusinessException;
import br.com.alura.interceptor.Logger;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeMessage;


import java.util.List;
import java.util.Optional;

@Stateless
@Logger
public class AgendamentoEmailBusiness {

    @Inject
    private AgendamentoEmailDao agendamentoEmailDao;
    @Resource(lookup = "java:jboss/mail/AgendamentoMailSession")
    private Session sessaoEmail;
    private static String EMAIL_FROM = "mail.address";
    private static String EMAIL_USER = "mail.smtp.user";
    private static String EMAIL_PASSWORD = "mail.smtp.pass";


    public List<AgendamentoEmail> listarAgendamentoEmail(){
        return agendamentoEmailDao.listarAgendamentosEmail();
    }

    public void salvarAgendamentos(AgendamentoEmail agendamentoEmail) throws BusinessException {
        List<AgendamentoEmail> emailsAgendados = agendamentoEmailDao.listarAgendamentoEmailPorEmail(agendamentoEmail.getEmail());
        if(!emailsAgendados.isEmpty()){
            throw new BusinessException("O email já está agendado");
        }
        agendamentoEmail.setEnviado(false);
        agendamentoEmailDao.salvarAgendamentoEmail(agendamentoEmail);
    }

    public List<AgendamentoEmail> listarAgendamentoEmailNaoEnviados(){
        return agendamentoEmailDao.listarAgendamentoEmailNaoEnviados();
    }

    public void enviarEmail(AgendamentoEmail agendamentoEmail){
        try {
            MimeMessage mensagem = new MimeMessage(sessaoEmail);
            mensagem.setFrom(sessaoEmail.getProperty(EMAIL_FROM));
            mensagem.setRecipients(Message.RecipientType.TO, agendamentoEmail.getEmail());
            mensagem.setSubject(agendamentoEmail.getAssunto());
            mensagem.setText(Optional.ofNullable(agendamentoEmail.getMensagem()).orElse(""));
            Transport.send(mensagem,
                    sessaoEmail.getProperty(EMAIL_USER),
                    sessaoEmail.getProperty(EMAIL_PASSWORD));
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
