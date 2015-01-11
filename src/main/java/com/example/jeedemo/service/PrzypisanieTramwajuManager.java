package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Producent;
import com.example.jeedemo.domain.Tramwaj;

@Stateless
public class PrzypisanieTramwajuManager {
	@PersistenceContext
	EntityManager em;

	public void przypisanieTramwaju(Long producentId, Long tramwajId) {
		
		if(producentId == null || tramwajId ==null)
		{
			
		}
		else
		{
			Producent producent = em.find(Producent.class, producentId);
			Tramwaj tramwaj = em.find(Tramwaj.class, tramwajId);
			tramwaj.setSold(true);;
		
			producent.getTramwaje().add(tramwaj);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tramwaj> getAvailableTramwaje() {
		return em.createNamedQuery("tramwaj.unsold").getResultList();
	}

	public void disposeTramwaj(Producent producent, Tramwaj tramwaj) {

		producent = em.find(Producent.class, producent.getId());
		tramwaj = em.find(Tramwaj.class, tramwaj.getId());

		Tramwaj toRemove = null;
		// lazy loading here (person.getCars)
		for (Tramwaj aTramwaj : producent.getTramwaje())
			if (aTramwaj.getId().compareTo(tramwaj.getId()) == 0) {
				toRemove = aTramwaj;
				break;
			}

		if (toRemove != null)
			producent.getTramwaje().remove(toRemove);
		
		tramwaj.setSold(false);
	}
}
