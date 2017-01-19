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

		List<List<String>> touristicSites = new ArrayList<List<String>>();
		touristicSites = simulation.readTouristicSite("2");
		for (int i = 0; i < touristicSites.size(); i++) {
			System.out.println(touristicSites.get(i).toString());
		}

	}

}
