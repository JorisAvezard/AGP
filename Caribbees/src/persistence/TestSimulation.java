package persistence;

import java.util.ArrayList;
import java.util.List;

import business.model.TouristicSite;

/**
 * 
 * Here is the class to test the JDBC simulation
 *
 */
public class TestSimulation {

	public static void main(String[] args) {
		JdbcPersistence simulation = new JdbcPersistence();
		List<String> ids = new ArrayList<String>();
		ids.add("3");
		ids.add("9");
		List<TouristicSite> touristicSites = new ArrayList<TouristicSite>();
		touristicSites = simulation.readTouristicSite(ids);
		for (int i = 0; i < touristicSites.size(); i++) {
			System.out.println(touristicSites.get(i).toString());
		}

	}

}
