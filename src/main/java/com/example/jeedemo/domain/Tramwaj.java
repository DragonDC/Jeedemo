package com.example.jeedemo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
	@NamedQuery(name = "tramwaj.unsold", query = "Select t from Tramwaj t where t.sold = false"),
	@NamedQuery(name = "tramwaj.all", query = "Select t from Tramwaj t")
})
public class Tramwaj {
		
		private Long id;
		private String wysPodlogi;
		private String model;
		private String rozstawOsi;
		private int liczbaMiejsc;
		private String zdjecie;
		private String kolor;
		private Boolean sold = false;
		private String kodTramwaju;
		private Date dataProdukcji = new Date();
		private boolean canEdit;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getKodTramwaju(){
			return kodTramwaju;
		}
			
		public void setKodTramwaju(String kodTramwaju){
			this.kodTramwaju = kodTramwaju;
		}
		
		@Temporal(TemporalType.DATE)
		public Date getDataProdukcji() {
			return dataProdukcji;
		}
		public void setDataProdukcji(Date dataProdukcji) {
			this.dataProdukcji = dataProdukcji;
		}
		
		public String getWysPodlogi(){
			return wysPodlogi;
		}

		public void setWysPodlogi(String wysPodlogi){
			this.wysPodlogi = wysPodlogi;
		}

		public String getModel(){
			return model;
		}

		public void setModel(String model){
			this.model = model;
		}



		public int getLiczbaMiejsc(){
			return liczbaMiejsc;
		}

		public void setLiczbaMiejsc(int liczbaMiejsc){
			this.liczbaMiejsc = liczbaMiejsc;
		}



		public String getRozstawOsi(){
			return rozstawOsi;
		}

		public void setRozstawOsi(String rozstawOsi){
			this.rozstawOsi = rozstawOsi;
		}



		public String getZdjecie(){
			return zdjecie;
		}

		public void setZdjecie(String zdjecie){
			this.zdjecie = zdjecie;
		}


		public String getKolor(){
			return kolor;
		}
		
		public void setKolor(String kolor){
			this.kolor=kolor;
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
