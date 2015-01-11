package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "lokalizacja.unsold", query = "Select l from LokalizacjaOddzialuFirmy l where l.sold = false"),
	@NamedQuery(name = "lokalizacje.all", query = "Select l from LokalizacjaOddzialuFirmy l")
})
public class LokalizacjaOddzialuFirmy {
	
	private Long id;
	private String kraj;
	private String wojewodztwo;
	private String miasto;
	private String ulica;
	private Boolean sold = false;
	private boolean canEdit;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	
	public String getWojewodztwo() {
		return wojewodztwo;
	}
	public void setWojewodztwo(String wojewodztwo) {
		this.wojewodztwo = wojewodztwo;
	}
	
	public String getMiasto() {
		return miasto;
	}
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	
	public Boolean getSold() {
		return sold;
	}
	public void setSold(Boolean sold) {
		this.sold = sold;
	}
	
	public boolean isCanEdit() {
		return canEdit;
	}
	public void setCanEdit(boolean canEdit) {
	    this.canEdit = canEdit;
	}
	
}
