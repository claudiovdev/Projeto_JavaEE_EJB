package br.com.alura.exception.exceptionMapper;

import br.com.alura.dto.MensagemErroDto;
import br.com.alura.exception.BusinessException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.stream.Collectors;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException>{

    @Override
    public Response toResponse(BusinessException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity( MensagemErroDto.build(
                        e.getMensagens()))
                .build();
    }
}
