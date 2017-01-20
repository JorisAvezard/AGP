package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.model.Activity;
import business.model.HistoricSite;
import business.model.Hotel;
import business.model.TouristicSite;
import lucene.LuceneConstants;

/**
 * 
 * This class creates the link with the database and contains the method for the
 * sql queries
 * 
 */
public class JdbcPersistence implements StatisticPersistence {

	private static String host = "localhost";
	private static String base = "agp1";
	private static String user = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://" + host + "/" + base;

	/**
	 * Lazy singleton instance.
	 */
	private Connection connection;

	public JdbcPersistence() {
		prepareConnection();
	}

	private void prepareConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
	}

	/**
	 * This method returns every hotels which respect the price
	 */
	@Override
	public List<Hotel> readHotel(String priceHotel) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		try {

			String selectHotelQuery = "SELECT * FROM Hotel AS h WHERE h.price_per_night <= ?";

			PreparedStatement preparedStatement = connection.prepareStatement(selectHotelQuery);

			preparedStatement.setString(1, priceHotel);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Hotel readHotel = new Hotel();
				readHotel.setId(result.getString("id"));
				readHotel.setName(result.getString("name_hotel"));
				readHotel.setIdIsle(result.getString("id_isle"));
				readHotel.setStanding(result.getString("standing"));
				readHotel.setPrice(result.getString("price_per_night"));
				hotels.add(readHotel);

				// System.out.println(readHotel.toString());

				// System.out.println(result.getString("id"));
				// System.out.println(result.getString("id_isle"));
				// System.out.println(result.getString("standing"));
				// System.out.println(result.getString("price_per_night"));
			}

			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return hotels;
	}

	/**
	 * This method returns a list of touristic site
	 */
	@Override
	public List<List<String>> readTouristicSite(String keyId) {
		List<List<String>> touristicSites = new ArrayList<List<String>>();
		try {

			String selectSiteQuery = "SELECT * FROM " + LuceneConstants.TABLE + " AS ts WHERE ts." + LuceneConstants.KEY
					+ " = " + keyId + "";

			PreparedStatement preparedStatement = connection.prepareStatement(selectSiteQuery);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				List<String> readTouristicSite = new ArrayList<String>();
				readTouristicSite.add(result.getString("id_site"));
				readTouristicSite.add(result.getString("name_site"));
				readTouristicSite.add(result.getString("id_isle"));
				readTouristicSite.add(result.getString("type_site"));
				readTouristicSite.add(result.getString("price"));
				readTouristicSite.add(result.getString("visit_time"));
				touristicSites.add(readTouristicSite);
				// System.out.println(readActivity.toString());

			}

			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return touristicSites;
	}

}
