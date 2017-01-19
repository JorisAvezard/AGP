package simulation;

import java.util.ArrayList;
import java.util.List;

import business.engine.Excursion;
import business.model.Hotel;
import business.model.TouristicSite;
import business.model.Transport;

public class BDeManager {
	
	private List<TouristicSite> sites = new ArrayList<TouristicSite>();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	
	public BDeManager() {
		
	}

	public List<TouristicSite> getSite() {
		return sites;
	}

	public void setSite(List<TouristicSite> site) {
		this.sites = site;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
}
