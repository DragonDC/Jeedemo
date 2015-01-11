package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.LokalizacjaOddzialuFirmy;
import com.example.jeedemo.domain.Producent;
import com.example.jeedemo.service.ProducentManager;
import com.example.jeedemo.service.PrzypisanieLokalizacjiManager;

@SessionScoped
@Named("przypisanieLokBean")
public class PrzypisanieLokalizacjiFormBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private PrzypisanieLokalizacjiManager plm;

	@Inject
	private ProducentManager pm;

	private Long lokalizacjaId;
	private Long producentId;
	
	public Long getLokalizacjaId() {
		return lokalizacjaId;
	}
	public void setLokalizacjaId(Long lokalizacjaId) {
		this.lokalizacjaId = lokalizacjaId;
	}
	public Long getProducentId() {
		return producentId;
	}
	public void setProducentId(Long producentId) {
		this.producentId = producentId;
	}

	public List<LokalizacjaOddzialuFirmy> getAvailableLokalizacje() {
		return plm.getAvailableLokalizacje();
	}

	public List<Producent> getAllProducent() {
		return pm.getAllProducent();
	}

	public String przypisanieLokalizacji() {
		plm.przypisanieLokalizacji(producentId, lokalizacjaId);
		return null;
	}
}
