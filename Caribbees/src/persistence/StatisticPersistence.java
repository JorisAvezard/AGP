package persistence;

import java.util.List;

import business.model.Hotel;
import business.model.TouristicSite;

/**
 * 
 * General interface for persistence APIs. Contains the methods in the class
 * JdbcPersistence.java
 *
 */
public interface StatisticPersistence {

	List<Hotel> readHotel(String priceHotel);

	List<List<String>> readTouristicSite(String keyWord);

}
