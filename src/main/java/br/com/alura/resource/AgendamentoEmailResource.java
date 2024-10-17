package br.com.alura.resource;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/agendamentoemail")
public class AgendamentoEmailResource {

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
    public Response salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail){
        agendamentoEmailBusiness.salvarAgendamentos(agendamentoEmail);
        return Response.status(201).build();
    }
}
