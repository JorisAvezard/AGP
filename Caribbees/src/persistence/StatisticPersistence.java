package persistence;

import model.Activity;
import model.Hotel;
import model.TouristicSite;

/**
 * 
 * @author phcar
 * 
 * General interface for persistence APIs.
 * Contains the methods in the class JdbcPersistence.java 
 *
 */
public interface StatisticPersistence {

	int countSite();
	Hotel readHotel(String priceHotel);
	TouristicSite readSite(int numberOfSites);
	Activity readActivity(int numberOfSites);
}
