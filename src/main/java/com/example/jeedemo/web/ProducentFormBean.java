package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.LokalizacjaOddzialuFirmy;
import com.example.jeedemo.domain.Producent;
import com.example.jeedemo.domain.Tramwaj;
import com.example.jeedemo.service.ProducentManager;
import com.example.jeedemo.service.PrzypisanieLokalizacjiManager;
import com.example.jeedemo.service.PrzypisanieTramwajuManager;
import com.example.jeedemo.service.TramwajManager;


@SessionScoped
@Named("producentBean")
public class ProducentFormBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Producent producent = new Producent();
	private ListDataModel<Producent> producenci = new ListDataModel<Producent>();
	
	private Producent producentToShow = new Producent();
	private ListDataModel<Tramwaj> ownedTramwaje = new ListDataModel<Tramwaj>();
	private ListDataModel<LokalizacjaOddzialuFirmy> ownedLokalizacje = new ListDataModel<LokalizacjaOddzialuFirmy>();
	
	private LokalizacjaOddzialuFirmy lokalizacja = new LokalizacjaOddzialuFirmy();
	private ListDataModel<LokalizacjaOddzialuFirmy> lokalizacje = new ListDataModel<LokalizacjaOddzialuFirmy>();
	
	private Tramwaj tramwaj = new Tramwaj();
	private ListDataModel<Tramwaj> tramwaje = new ListDataModel<Tramwaj>();
	
	

	@Inject
	private ProducentManager pm;
	
	@Inject
	private PrzypisanieTramwajuManager ptm;
	
	@Inject
	private PrzypisanieLokalizacjiManager plm;
	
	@Inject
	private TramwajManager tm;

	public Producent getProducent() {
		return producent;
	}
	public void setProducent(Producent producent) {
		this.producent = producent;
	}
	
	public LokalizacjaOddzialuFirmy getLokalizacja() {
		return lokalizacja;
	}
	public void setLokalizacja(LokalizacjaOddzialuFirmy lokalizacja) {
		this.lokalizacja = lokalizacja;
	}
	
	public Tramwaj getTramwaj() {
		return tramwaj;
	}
	public void setTramwaj(Tramwaj tramwaj) {
		this.tramwaj = tramwaj;
	}
	
	public ListDataModel<Producent> getAllProducent() {
		producenci.setWrappedData(pm.getAllProducent());
		return producenci;
	}

	public ListDataModel<Tramwaj> getOwnedTramwaje() {
		ownedTramwaje.setWrappedData(pm.getOwnedTramwaje(producentToShow));
		return ownedTramwaje;
	}
	
	public String editTramwaj() {
		//lm.editLokalizacja(lokalizacja);
		Tramwaj tramwajToUpdate = tramwaje.getRowData();
		setTramwaj(tramwajToUpdate);
		return "edycjaTramwajPro";
		//return null;
	}
	
	public ListDataModel<LokalizacjaOddzialuFirmy> getOwnedLokalizacje() {
		ownedLokalizacje.setWrappedData(pm.getOwnedLokalizacje(producentToShow));
		return ownedLokalizacje;
	}
	
	public String editLokalizacja() {
		LokalizacjaOddzialuFirmy lokalizacjaToUpdate = lokalizacje.getRowData();
		setLokalizacja(lokalizacjaToUpdate);
		return "edycjaLokalizacjiPro";
		//return null;
	}
	

	
	// Actions
	public String addProducent() {
		pm.addProducent(producent);
		return "showProducenci";
		//return null;
	}
	
	public String editProducent() {
		//lm.editLokalizacja(lokalizacja);
		Producent producentToUpdate = producenci.getRowData();
		setProducent(producentToUpdate);
		return "edycjaProducent";
		//return null;
	}
	
	public String updateProducent() {
		pm.updateProducent(producent);
		return "showProducenci";
	
		//return null;
	}

	public String deleteProducent() {
		Producent producentToDelete = producenci.getRowData();
		pm.deleteProducent(producentToDelete);
		return null;
	}
	
	public String showDetails() {
		producentToShow = producenci.getRowData();
		return "detailsProducent";
	}
	
	public String addingAddresses() {
		producentToShow = producenci.getRowData();
		return "addLokalizacja";
	}
	
	public String disposeTramwaj(){
		Tramwaj tramwajToDispose = ownedTramwaje.getRowData();
		ptm.disposeTramwaj(producentToShow, tramwajToDispose);
		return null;
	}
	
	public String disposeLokalizacja(){
		LokalizacjaOddzialuFirmy lokalizacjaToDispose = ownedLokalizacje.getRowData();
		plm.disposeLokalizacja(producentToShow, lokalizacjaToDispose);
		return null;
	}
}
