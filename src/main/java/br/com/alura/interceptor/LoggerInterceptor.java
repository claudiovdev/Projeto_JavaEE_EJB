package br.com.alura.interceptor;

import br.com.alura.resource.AgendamentoEmailResource;
import jakarta.annotation.Priority;
import jakarta.ejb.EJBException;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.validation.ConstraintViolationException;

import java.util.logging.Logger;

@Interceptor
@Priority(1)
@br.com.alura.interceptor.Logger
public class LoggerInterceptor {

    @AroundInvoke
    public Object treatException(InvocationContext context) throws Exception {
        Logger logger = Logger.getLogger(context.getTarget().getClass().getName());
        try {
            return context.proceed();
        }catch (Exception e){
            if (e.getCause() instanceof ConstraintViolationException){
                logger.info(e.getMessage());
            }else {
                logger.severe(e.getMessage());
            }
            throw e;
        }
    }
}
