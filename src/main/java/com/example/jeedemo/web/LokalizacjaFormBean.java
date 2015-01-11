package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.LokalizacjaOddzialuFirmy;
import com.example.jeedemo.service.LokalizacjaManager;
/*import com.example.jeedemo.service.ProducentManager;
import com.example.jeedemo.service.PrzypisanieTramwajuManager;*/


@SessionScoped
@Named("lokalizacjaBean")
public class LokalizacjaFormBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private LokalizacjaOddzialuFirmy lokalizacja = new LokalizacjaOddzialuFirmy();
	private ListDataModel<LokalizacjaOddzialuFirmy> lokalizacje = new ListDataModel<LokalizacjaOddzialuFirmy>();
	
	//private Tramwaj tramwajToShow = new Tramwaj();

	/*@Inject
	private ProducentManager pm;*/

	@Inject
	private LokalizacjaManager lm;
	
	/*private Long lokalizacjaId;
	private Long producentId;*/
	//przypisanie lokalizacji do producenta

	public LokalizacjaOddzialuFirmy getLokalizacja() {
		return lokalizacja;
	}
	public void setLokalizacja(LokalizacjaOddzialuFirmy lokalizacja) {
		this.lokalizacja = lokalizacja;
	}
	
	public ListDataModel<LokalizacjaOddzialuFirmy> getAllLokalizacje() {
		lokalizacje.setWrappedData(lm.getAllLokalizacje());
		return lokalizacje;
	}
	
	public ListDataModel<LokalizacjaOddzialuFirmy> getAvailableLokalizacje() {
		lokalizacje.setWrappedData(lm.getAvailableLokalizacje());
		return lokalizacje;
	}
	
	// Actions
	public String addLokalizacja() {
		lm.addLokalizacja(lokalizacja);
		return "showLokalizacje";
		//return null;
	}
	
	public String editLokalizacja() {
		//lm.editLokalizacja(lokalizacja);
		LokalizacjaOddzialuFirmy lokalizacjaToUpdate = lokalizacje.getRowData();
		setLokalizacja(lokalizacjaToUpdate);
		return "edycjaLokalizacji";
		//return null;
	}
	
	public String updateLokalizacja() {
		lm.updateLokalizacja(lokalizacja);
		return "showLokalizacje";
	
		//return null;
	}

	public String deleteLokalizacja() {
		LokalizacjaOddzialuFirmy lokalizacjaToDelete = lokalizacje.getRowData();
		lm.deleteLokalizacja(lokalizacjaToDelete);
		return null;
	}
	
	/*public String editLokalizacja(){
		 LokalizacjaOddzialuFirmy lokalizacja = lokalizacje.getRowData();
		 //tm.deleteTramwaj(tramwajToDelete);
	     lokalizacja.setCanEdit(true);
	     return null;
	 }

	 public String saveLokalizacja(){
	     
	     for (Tramwaj tramwaj : tramwaje){
	        tramwaj.setCanEdit(false);
	     }
		 LokalizacjaOddzialuFirmy lokalizacja = lokalizacje.getRowData();
		 lm.addLokalizacja(lokalizacja);
		 //tramwaj.setCanEdit(false);
		 //Tramwaj nowyTram = tm.edycjaTramwaj(tramwaj);
		 
		 lm.deleteLokalizacja(lokalizacja);
		 
		 return null;
	 }*/
	
}
