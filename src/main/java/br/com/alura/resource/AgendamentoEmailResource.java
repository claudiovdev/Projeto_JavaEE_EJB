package br.com.alura.resource;

import br.com.alura.business.AgendamentoEmailBusiness;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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

        List<String> emails = agendamentoEmailBusiness.listarAgendamentoEmail();
        return Response.ok(emails).build();
    }
}
