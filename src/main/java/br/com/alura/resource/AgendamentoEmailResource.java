package br.com.alura.resource;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.exception.BusinessException;
import jakarta.ejb.EJBException;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;

@Path("/agendamentoemail")
public class AgendamentoEmailResource {

    private static final Logger logger = Logger.getLogger(AgendamentoEmailResource.class.getName());

    @Inject
    private AgendamentoEmailBusiness agendamentoEmailBusiness;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarAgendamentoEmail(){

        List<AgendamentoEmail> emails = agendamentoEmailBusiness.listarAgendamentoEmail();
        return Response.ok(emails).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarAgendamentoEmail(@Valid AgendamentoEmail agendamentoEmail) throws BusinessException {
        agendamentoEmailBusiness.salvarAgendamentos(agendamentoEmail);
        return Response.status(201).build();
    }
}
