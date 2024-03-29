package br.inf.datainfo.desafio.service;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;

import br.inf.datainfo.desafio.entities.Carro;

@ApplicationScoped
public class CarroService {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction userTransaction;

	public Carro salvar(@NotNull Carro carro) {
		try {
			userTransaction.begin();
			if (carro.getId() == null) {
				em.persist(carro);
			} else {
				em.merge(carro);
			}
			em.flush();
			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carro;
	}

	public void remover(@NotNull Carro carro) {
		try {
			userTransaction.begin();
			em.remove(em.find(Carro.class, carro.getId()));
			userTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Carro getById(@NotNull Integer id) {
		return em.find(Carro.class, id);
	}

	public List<Carro> getAll() {
		return em.createQuery("FROM Carro c ORDER BY c.marca, c.ano", Carro.class).getResultList();
	}

}