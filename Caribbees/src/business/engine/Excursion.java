package business.engine;

import java.util.ArrayList;
import java.util.List;

import business.model.TouristicSite;
import business.model.Transport;

public class Excursion {
	
	private List<TouristicSite> sites = new ArrayList<TouristicSite>();
	private List<Transport> transports = new ArrayList<Transport>();
	
	public void addSite(TouristicSite site) {
		sites.add(site);
	}

	public List<TouristicSite> getSites() {
		return sites;
	}
	
	public void clearList() {
		sites.clear();
		transports.clear();
	}

	public void setSites(List<TouristicSite> sites) {
		this.sites = sites;
	}
	
	public void addTransport(Transport transport) {
		transports.add(transport);
	}

	public List<Transport> getTransports() {
		return transports;
	}

	public void setTransports(List<Transport> transports) {
		this.transports = transports;
	}
	
	
	
//	public int calculatePrice() {
//		int price = 0;
//		for(int i=0; i<sites.size(); i++) {
//			TouristicSite site = sites.get(i);
//			price += site.getPrice();
//		}
//		for(int j=0; j<transports.size(); j++) {
//			Transport transport = transports.get(j);
//			price += transport.getPricePerHour() * transport.getTimeOfUse();
//		}
//		return price;
//	}
	
//	public void createExcursion() {
//		
//	}
	
	

}