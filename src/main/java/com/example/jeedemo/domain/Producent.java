package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

//import com.example.jeedemo.web.UrlData;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "producent.all", query = "Select p from Producent p")
})
public class Producent {
	private Long id;

	private String producentNazwa = "unknown";
	private String stronaProducenta = "";
	private Date dataPowstaniaFirmy = new Date();
	//private UrlData adresStrony;

	private List<Tramwaj> tramwaje = new ArrayList<Tramwaj>();
	private List<LokalizacjaOddzialuFirmy> lokalizacje = new ArrayList<LokalizacjaOddzialuFirmy>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 20)
	public String getProducentNazwa() {
		return producentNazwa;
	}
	public void setProducentNazwa(String producent) {
		this.producentNazwa = producent;
	}

	@Size(min = 2)
	public String getStronaProducenta() {
		return stronaProducenta;
	}
	public void setStronaProducenta(String stronaProducenta) {
		this.stronaProducenta = stronaProducenta;
	}

	@Temporal(TemporalType.DATE)
	public Date getDataPowstaniaFirmy() {
		return dataPowstaniaFirmy;
	}
	public void setDataPowstaniaFirmy(Date dataPowstaniaFirmy) {
		this.dataPowstaniaFirmy = dataPowstaniaFirmy;
	}

	// Be careful here, both with lazy and eager fetch type
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Tramwaj> getTramwaje() {
		return tramwaje;
	}
	public void setTramwaje(List<Tramwaj> tramwaje) {
		this.tramwaje = tramwaje;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<LokalizacjaOddzialuFirmy> getLokalizacje() {
		return lokalizacje;
	}
	public void setLokalizacje(List<LokalizacjaOddzialuFirmy> lokalizacje) {
		this.lokalizacje = lokalizacje;
	}
	
	/*public UrlData getAdresStrony() {
		return adresStrony;
	}	

	public void setAdresStrony(UrlData adresStrony) {
	    this.adresStrony = adresStrony;
	}*/
}
