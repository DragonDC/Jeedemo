package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Tramwaj;
import com.example.jeedemo.service.TramwajManager;


@SessionScoped
@Named("tramwajBean")
public class TramwajFormBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Tramwaj tramwaj = new Tramwaj();
	private ListDataModel<Tramwaj> tramwaje = new ListDataModel<Tramwaj>();
	
	//private Tramwaj tramwajToShow = new Tramwaj();


	@Inject
	private TramwajManager tm;
	

	public Tramwaj getTramwaj() {
		return tramwaj;
	}
	public void setTramwaj(Tramwaj tramwaj) {
		this.tramwaj = tramwaj;
	}
	
	public ListDataModel<Tramwaj> getAllTramwaj() {
		tramwaje.setWrappedData(tm.getAllTramwaj());
		return tramwaje;
	}
	
	public ListDataModel<Tramwaj> getAvailableTramwaje() {
		tramwaje.setWrappedData(tm.getAvailableTramwaje());
		return tramwaje;
	}
	
	// Actions
	public String addTramwaj() {
		tm.addTramwaj(tramwaj);
		return "showTramwaje";
		//return null;
	}
	
	public String editTramwaj() {
		//lm.editLokalizacja(lokalizacja);
		Tramwaj tramwajToUpdate = tramwaje.getRowData();
		setTramwaj(tramwajToUpdate);
		return "edycjaTramwaj";
		//return null;
	}
	
	public String updateTramwaj() {
		tm.updateTramwaj(tramwaj);
		return "showTramwaje";
	
		//return null;
	}

	public String deleteTramwaj() {
		Tramwaj tramwajToDelete = tramwaje.getRowData();
		tm.deleteTramwaj(tramwajToDelete);
		return null;
	}
	
	
	
	/*public String showDetails() {
		tramwajToShow = tramwaje.getRowData();
		return "detailsTramwaj";
	}*/
	
	/*public String editTramwaj(){
		 Tramwaj tramwaj = tramwaje.getRowData();
		 //tm.deleteTramwaj(tramwajToDelete);
	     tramwaj.setCanEdit(true);
	     return null;
	 }

	 public String saveTramwaje(){
	     
	     for (Tramwaj tramwaj : tramwaje){
	        tramwaj.setCanEdit(false);
	     }
		 Tramwaj tramwaj = tramwaje.getRowData();
		 tm.addTramwaj(tramwaj);
		 //tramwaj.setCanEdit(false);
		 //Tramwaj nowyTram = tm.edycjaTramwaj(tramwaj);
		 
		 tm.deleteTramwaj(tramwaj);
		 
		 return null;
	 }*/

}
