package br.com.alura.dao;

import br.com.alura.entity.AgendamentoEmail;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class AgendamentoEmailDao {
    @PersistenceContext(unitName = "agendamentoemailPU")
    private EntityManager entityManager;

    public List<AgendamentoEmail> listarAgendamentosEmail(){
        String jpql = "SELECT a FROM AgendamentoEmail a";
        TypedQuery<AgendamentoEmail> query =  entityManager.createQuery(jpql, AgendamentoEmail.class);
        return query.getResultList();
    }

    public void salvarAgendamentoEmail(AgendamentoEmail agendamentoEmail){
        entityManager.persist(agendamentoEmail);
    }
}
