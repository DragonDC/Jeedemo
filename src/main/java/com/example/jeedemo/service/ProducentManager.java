package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.LokalizacjaOddzialuFirmy;
import com.example.jeedemo.domain.Producent;
import com.example.jeedemo.domain.Tramwaj;

@Stateless
public class ProducentManager {
	@PersistenceContext
	EntityManager em;

	public void addProducent(Producent producent) {
		producent.setId(null);
		em.persist(producent);
	}

	public void deleteProducent(Producent producent) {
		producent = em.find(Producent.class, producent.getId());
		em.remove(producent);
	}
	
	public void updateProducent(Producent producent) {
		//lokalizacja.setId(null);
		em.merge(producent);
	}

	@SuppressWarnings("unchecked")
	public List<Producent> getAllProducent() {
		return em.createNamedQuery("producent.all").getResultList();
	}

	public List<Tramwaj> getOwnedTramwaje(Producent producent) {
		producent = em.find(Producent.class, producent.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Tramwaj> tramwaje = new ArrayList<Tramwaj>(producent.getTramwaje());
		return tramwaje;
	}
	
	public List<LokalizacjaOddzialuFirmy> getOwnedLokalizacje(Producent producent) {
		producent = em.find(Producent.class, producent.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<LokalizacjaOddzialuFirmy> lokalizacje = new ArrayList<LokalizacjaOddzialuFirmy>(producent.getLokalizacje());
		return lokalizacje;
	}
	
}
