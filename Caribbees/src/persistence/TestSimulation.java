package persistence;

import java.util.ArrayList;
import java.util.List;

import business.model.TouristicSite;

/**
 * 
 * @author phcar
 * 
 * Here is the class to test the JDBC simulation
 *
 */
public class TestSimulation {

	public static void main(String[] args) {
		JdbcPersistence simulation = new JdbcPersistence();
		
		String price="50";
		
		int total=3;
		
		List<TouristicSite> site = new ArrayList<TouristicSite>();
		site = simulation.readSite(total);
		for(int i=0; i<site.size(); i++) {
			System.out.println(site.get(i).toString());
		}
		
		//simulation.countSite();
		
		//System.out.println("hello1");
				
		//simulation.readHotel(price);
		
	}

}
