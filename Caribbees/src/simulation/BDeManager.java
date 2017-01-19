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
	
	public void addSite(TouristicSite site) {
		sites.add(site);
	}

	public List<TouristicSite> getSites() {
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

	public String toStringHotels() {
		return "BDeManager [getHotels()="
				+ getHotels() + "]";
	}
	
	public String toStringSites() {
		return "BDeManager [getSite()="
				+ getSites() + "]";
	}
	
	
}
