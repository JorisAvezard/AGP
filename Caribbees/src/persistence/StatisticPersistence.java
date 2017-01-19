package persistence;

import java.util.List;

import business.model.Hotel;
import business.model.TouristicSite;

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
	List<Hotel> readHotel(String priceHotel);
	List<TouristicSite> readSite(int numberOfSites);
	List<TouristicSite> readActivity(int numberOfSites);
}
