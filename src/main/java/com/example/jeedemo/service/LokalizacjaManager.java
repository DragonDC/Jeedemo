package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.LokalizacjaOddzialuFirmy;


@Stateless
public class LokalizacjaManager {
	@PersistenceContext
	EntityManager em;
	
	public void addLokalizacja(LokalizacjaOddzialuFirmy lokalizacja) {
		lokalizacja.setId(null);
		em.persist(lokalizacja);
	}
	
	
	public void updateLokalizacja(LokalizacjaOddzialuFirmy lokalizacja) {
		//lokalizacja.setId(null);
		em.merge(lokalizacja);
	}

	public void deleteLokalizacja(LokalizacjaOddzialuFirmy lokalizacja) {
		lokalizacja = em.find(LokalizacjaOddzialuFirmy.class, lokalizacja.getId());
		em.remove(lokalizacja);
	}

	@SuppressWarnings("unchecked")
	public List<LokalizacjaOddzialuFirmy> getAllLokalizacje() {
		return em.createNamedQuery("lokalizacje.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<LokalizacjaOddzialuFirmy> getAvailableLokalizacje() {
		return em.createNamedQuery("lokalizacja.unsold").getResultList();
	}
	
	
}
