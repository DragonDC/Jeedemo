package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.LokalizacjaOddzialuFirmy;
import com.example.jeedemo.domain.Producent;

@Stateless
public class PrzypisanieLokalizacjiManager {
	@PersistenceContext
	EntityManager em;
	
	public void przypisanieLokalizacji(Long producentId, Long lokalizacjaId) {
		
		if(producentId == null || lokalizacjaId == null)
		{
			
		}
		else
		{
			Producent producent = em.find(Producent.class, producentId);
			LokalizacjaOddzialuFirmy lokalizacja = em.find(LokalizacjaOddzialuFirmy.class, lokalizacjaId);
			lokalizacja.setSold(true);;

			producent.getLokalizacje().add(lokalizacja);
		}
	}

	@SuppressWarnings("unchecked")
	public List<LokalizacjaOddzialuFirmy> getAvailableLokalizacje() {
		return em.createNamedQuery("lokalizacja.unsold").getResultList();
	}

	public void disposeLokalizacja(Producent producent, LokalizacjaOddzialuFirmy lokalizacja) {

		producent = em.find(Producent.class, producent.getId());
		lokalizacja = em.find(LokalizacjaOddzialuFirmy.class, lokalizacja.getId());

		LokalizacjaOddzialuFirmy toRemove = null;
		// lazy loading here (person.getCars)
		for (LokalizacjaOddzialuFirmy aLokalizacja : producent.getLokalizacje())
			if (aLokalizacja.getId().compareTo(lokalizacja.getId()) == 0) {
				toRemove = aLokalizacja;
				break;
			}

		if (toRemove != null)
			producent.getLokalizacje().remove(toRemove);
		
		lokalizacja.setSold(false);
	}
	
}
