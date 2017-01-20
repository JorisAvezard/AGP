package simulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.queryParser.ParseException;

import business.engine.Excursion;
import business.engine.Travel;
import business.model.Boat;
import business.model.Bus;
import business.model.Hotel;
import business.model.SimulationEntry;
import business.model.TouristicSite;
import business.model.Transport;
import lucene.LuceneUtility;
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
	
	public void createTravel(int budget) {
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
			price+=hotel.getPrice();
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
					price+=hotel.getPrice();
					beginningDay = true;
				}
				if(price + Integer.parseInt(site.getPrice()) < budget) {
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
				String[] split = String.valueOf(excursion.getTransports().get(k).getClass()).split("\\.");
				System.out.println(excursion.getSites().get(k).getName() + ", prix : " + excursion.getSites().get(k).getPrice() + ", prix du transport : " + excursion.getTransports().get(k).getPricePerHour()*excursion.getTransports().get(k).getTimeOfUse() + ", transport : " + split[2]);
			}
			System.out.println("\nPrix total du séjour : " + price);
			System.out.println("\n---------------------------------------------------------------------\n");
		}
	}
	
	public List<TouristicSite> sortingPerScore(List<TouristicSite> touristicSite, List<List<String>> idScore) {
		List<TouristicSite> site = new ArrayList<TouristicSite>();
		float score;
		String id = "";
		int id_table = 0;
		for(int y=0;y<touristicSite.size();y++) {
			score = 0;
			for(int i=0;i<idScore.size();i++) {
				if(Float.parseFloat(idScore.get(i).get(1)) > score ) {
					score = Float.parseFloat(idScore.get(i).get(1));
					id = idScore.get(i).get(0);
					id_table = i;
				}
			}
			idScore.remove(id_table);
			for(int j=0;j<touristicSite.size();j++) {
				if(touristicSite.get(j).getId().equals(id)) {
					site.add(touristicSite.get(j));
				}
			}
		}
		return site;
	}
	
	public List<TouristicSite> order(List<List<String>> idScore, List<TouristicSite> touristicSites) {
		List<TouristicSite> touristicSiteOrder = new ArrayList<TouristicSite>();
		List<TouristicSite> touristicSiteNoOrder = new ArrayList<TouristicSite>();
		for(int i=0; i<touristicSites.size(); i++) {
			for(int j=0; j<idScore.size(); j++) {
				if(touristicSites.get(i).getId().equals(idScore.get(j).get(0))) {
					touristicSiteNoOrder.add(touristicSites.get(i));
				}
			}
		}
		touristicSiteOrder = sortingPerScore(touristicSiteNoOrder, idScore);
		return touristicSiteOrder;
		
	}
	
	public void simulate() {
		String comfort = entry.getStanding();
		int budget = entry.getBudget();
		String keyWord = entry.getKeyword();
		List<List<String>> index = new ArrayList<List<String>>();
		List<TouristicSite> touristicSite = new ArrayList<TouristicSite>();
 //		System.out.println(budget);
		JdbcPersistence jdbc = new JdbcPersistence();
		LuceneUtility lucene;
		manager.setHotels(jdbc.readHotel(budget));
//		System.out.println(manager.toStringHotels());
//		int nbActivities = getRandomNumber(0,5);
//		int nbHistoricSite = 5-nbActivities;
//		sites = jdbc.readActivity(nbActivities);
//		for(int l=0;l<sites.size();l++) {
//			manager.addSite(sites.get(l));
//		}
//		sites = jdbc.readSite(nbHistoricSite);
//		for(int k=0;k<sites.size();k++) {
//			manager.addSite(sites.get(k));
//		}
		try {
			lucene = new LuceneUtility();
			lucene.createIndex();
			index = lucene.search(keyWord);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		touristicSite = (jdbc.readTouristicSite());
		manager.setSite(order(index, touristicSite));
		//System.out.println(manager.toStringSites());
		createTravel(budget);
		
	}

}
