package simulation;

import java.util.ArrayList;
import java.util.List;

import business.engine.Excursion;
import business.engine.Travel;
import business.model.Boat;
import business.model.Bus;
import business.model.Hotel;
import business.model.SimulationEntry;
import business.model.TouristicSite;
import business.model.Transport;
import persistence.JdbcPersistence;

public class Simulation {
	
	private Travel travel;
	private SimulationEntry entry;
	private BDeManager manager;
	private List<TouristicSite> sites = new ArrayList<TouristicSite>();
	
	public Simulation(SimulationEntry entry) {
		this.entry = entry;
		travel = new Travel();
		manager = new BDeManager();
	}
	
	private static int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}
	
	public void createTravel(String budget) {
		List<String> morning = new ArrayList<String>();
		for(int i=0; i<manager.getHotels().size();i++) {
			int price = 0;
			int var = 0;
			int night = 1;
			int timeOfDay = 0;
			boolean beginningDay = true;
			Hotel hotel = new Hotel();
			Excursion excursion = new Excursion();
			excursion.clearList();
			hotel = manager.getHotels().get(i);
			price+=Integer.parseInt(hotel.getPrice());
			for(int z=0; z<manager.getSites().size(); z++) {
				TouristicSite site = manager.getSites().get(z);
				Transport transport;
				if(beginningDay == true) {
					morning.add(site.getName());
					beginningDay = false;
				}
				if(timeOfDay<12) {
				}
				else {
					night++;
					timeOfDay = 0;
					price+=Integer.parseInt(hotel.getPrice());
					beginningDay = true;
				}
				if(price + Integer.parseInt(site.getPrice()) < Integer.parseInt(budget)) {
					if(manager.getHotels().get(i).getIdIsle().equals(site.getIdIsle())) {
						int nb = getRandomNumber(1, 5);
						transport = new Bus(5, nb);
					}
					else {
						int nb = getRandomNumber(1, 5);
						transport = new Boat(10, nb);
					}
					excursion.addSite(site);
					excursion.addTransport(transport);
					timeOfDay += transport.getTimeOfUse() + Integer.parseInt(site.getVisitTime());
					price+=Integer.parseInt(excursion.getSites().get(var).getPrice()) + transport.getPricePerHour() * transport.getTimeOfUse();
					var++;
				}
				else {
					//Rajouter le retour du trajet puis adapter le chemin en fonction de ça
				}
				
			}
			System.out.println("\n---------------------------------------------------------------------\n");
			System.out.println("OFFRE :\nHOTEL : "+ hotel.getName() + " - " + night + " nuits - " + hotel.getPrice() + " par nuit !\n");
			int v = 0;
			excursion.getSites().toString();
			morning.toString();
			for(int k = 0; k < excursion.getSites().size(); k++) {
				if(v < morning.size()) {
					if(excursion.getSites().get(k).getName().equals(morning.get(v))) {
						v++;
						System.out.println("\nDAY " + v + " :");
					}
				}
				System.out.println(excursion.getSites().get(k).getName() + ", prix : " + excursion.getSites().get(k).getPrice() + ", prix du transport : " + excursion.getTransports().get(k).getPricePerHour()*excursion.getTransports().get(k).getTimeOfUse());
			}
			System.out.println("\nPrix total du séjour : " + price);
			System.out.println("\n---------------------------------------------------------------------\n");
		}
	}
	
	public void simulate() {
		String keyWord = entry.getKeyword();
		String budget = entry.getBudget();
		String comfort = entry.getStanding();
//		System.out.println(budget);
		JdbcPersistence jdbc = new JdbcPersistence();
		manager.setHotels(jdbc.readHotel(budget));
//		System.out.println(manager.toStringHotels());
		int nbActivities = getRandomNumber(0,5);
		int nbHistoricSite = 5-nbActivities;
		sites = jdbc.readActivity(nbActivities);
		for(int l=0;l<sites.size();l++) {
			manager.addSite(sites.get(l));
		}
		sites = jdbc.readSite(nbHistoricSite);
		for(int k=0;k<sites.size();k++) {
			manager.addSite(sites.get(k));
		}
		//System.out.println(manager.toStringSites());
		createTravel(budget);
		
	}
	
	public static void main(String[] strings) {
		SimulationEntry entry = new SimulationEntry("???", "5000", "???");
		Simulation simulation = new Simulation(entry);
		simulation.simulate();
	}

}
