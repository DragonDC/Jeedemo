package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Producent;
import com.example.jeedemo.domain.Tramwaj;
import com.example.jeedemo.service.ProducentManager;
import com.example.jeedemo.service.PrzypisanieTramwajuManager;

@SessionScoped
@Named("przypisanieBean")
public class PrzypisanieTramwajuFormBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private PrzypisanieTramwajuManager ptm;

	@Inject
	private ProducentManager pm;

	private Long tramwajId;
	private Long producentId;
	
	public Long getTramwajId() {
		return tramwajId;
	}
	public void setTramwajId(Long tramwajId) {
		this.tramwajId = tramwajId;
	}
	public Long getProducentId() {
		return producentId;
	}
	public void setProducentId(Long producentId) {
		this.producentId = producentId;
	}

	public List<Tramwaj> getAvailableTramwaje() {
		return ptm.getAvailableTramwaje();
	}

	public List<Producent> getAllProducent() {
		return pm.getAllProducent();
	}

	public String przypisanieTramwaj() {
		ptm.przypisanieTramwaju(producentId, tramwajId);
		return null;
	}
}
