package br.inf.datainfo.desafio.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import br.inf.datainfo.desafio.entities.Carro;

@Stateless
public class CarroService {

	@PersistenceContext
	private EntityManager em;

	public Carro salvar(@NotNull Carro carro) {
		if (carro.getId() == null) {
			em.persist(carro);
		} else {
			em.merge(carro);
		}
		em.flush();
		return carro;
	}

	public void remover(@NotNull Carro carro) {
		em.remove(em.find(Carro.class, carro.getId()));
	}

	public Carro getById(@NotNull Integer id) {
		return em.find(Carro.class, id);
	}

	public List<Carro> getAll() {
		return em.createQuery("FROM Carro c ORDER BY c.marca, c.ano", Carro.class).getResultList();
	}

}