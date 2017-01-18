package persistence;

import model.Hotel;

/**
 * 
 * @author phcar
 * 
 * General interface for persistence APIs.
 */
public interface StatisticPersistence {

	int countSite();
	Hotel readHotel(String priceHotel);
}
