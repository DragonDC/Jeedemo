package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Tramwaj;

@Stateless
public class TramwajManager {
	@PersistenceContext
	EntityManager em;

	public void addTramwaj(Tramwaj tramwaj) {
		tramwaj.setId(null);
		em.persist(tramwaj);
	}
	
	public void updateTramwaj(Tramwaj tramwaj) {
		//lokalizacja.setId(null);
		em.merge(tramwaj);
	}

	public void deleteTramwaj(Tramwaj tramwaj) {
		tramwaj = em.find(Tramwaj.class, tramwaj.getId());
		em.remove(tramwaj);
	}

	@SuppressWarnings("unchecked")
	public List<Tramwaj> getAllTramwaj() {
		return em.createNamedQuery("tramwaj.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tramwaj> getAvailableTramwaje() {
		return em.createNamedQuery("tramwaj.unsold").getResultList();
	}

}
