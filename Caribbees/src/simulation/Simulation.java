package simulation;

import business.engine.Excursion;
import business.engine.Travel;
import business.model.Boat;
import business.model.Bus;
import business.model.Hotel;
import business.model.SimulationEntry;
import business.model.Transport;
import persistence.JdbcPersistence;

public class Simulation {
	
	private Travel travel;
	private SimulationEntry entry;
	private BDeManager manager;
	private Excursion excursion;
	
	public Simulation(SimulationEntry entry) {
		this.entry = entry;
		travel = new Travel();
		manager = new BDeManager();
		excursion = new Excursion();
	}
	
	public void createTravel(String budget) {
		for(int i=0; i<manager.getHotels().size();i++) {
			int price = 0;
			int night = 0;
			Hotel hotel = new Hotel();
			for(int j=0; j<manager.getSite().size(); j++) {
				hotel = manager.getHotels().get(i);
				Transport transport;
				int timeOfDay = 0;
				price += Integer.parseInt(hotel.getPrice());
				if(timeOfDay<12) {
					if(price + Integer.parseInt(manager.getSite().get(j).getPrice()) < Integer.parseInt(budget)) {
						if(manager.getHotels().get(i).getIdIsle().equals(manager.getSite().get(j).getIdIsle())) {
							int nb = 5 + (int)(Math.random()*(5+1));
							transport = new Bus(0, nb);
						}
						else {
							int nb = 5 + (int)(Math.random()*(5+1));
							transport = new Boat(0, nb);
						}
						price += Integer.parseInt(excursion.getSites().get(j).getPrice()) + transport.getPricePerHour() * transport.getTimeOfUse();
						excursion.addSite(manager.getSite().get(j));
						excursion.addTransport(transport);
						timeOfDay = transport.getTimeOfUse() + Integer.parseInt(manager.getSite().get(j).getVisitTime());
					}
					else {
						//Rajouter le retour du trajet puis adapter le chemin en fonction de ça
					}
				}
				else {
					night = 1;
					timeOfDay = 0;
					price += Integer.parseInt(hotel.getPrice());
				}
			}
			System.out.println("OFFRE :\nHOTEL : "+ hotel.getName() + " - " + night + " nuits - " + hotel.getPrice() + " par nuit !\n");
			for(int k = 0; k < excursion.getSites().size(); k++) {
				System.out.println(excursion.getSites().get(k).getName() + ", détails en cours !\n");
			}
			System.out.println("Prix total du séjour : " + price);
		}
	}
	
	public void simulate() {
		String keyWord = "";
		String budget = "";
		String comfort = "";
		
		JdbcPersistence jdbc = new JdbcPersistence();
		manager.setHotels(jdbc.readHotel(budget));
		//manager.setSite(jdbc.);
		
	}
	
	public static void main(String[] strings) {
		
	}

}
