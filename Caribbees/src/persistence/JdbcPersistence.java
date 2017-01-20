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

/**
 * 
 * This class creates the link with the database and contains the method for the
 * sql queries
 * 
 */
public class JdbcPersistence implements StatisticPersistence {

	private static String host = "localhost";
	private static String base = "agp";
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
	 * This method is a test It returns the number of touristic sites in the
	 * database
	 */
	@Override
	public int countSite() {
		int count = 0;
		try {

			String selectCountQuery = "SELECT count(*) AS co FROM TouristicSites";

			PreparedStatement preparedStatement = connection.prepareStatement(selectCountQuery);

			ResultSet result = preparedStatement.executeQuery();

			result.next();
			count = result.getInt("co");

			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		System.out.println(count);
		return count;
	}

	/**
	 * This method returns every hotels which respect the price
	 */
	@Override
	public List<Hotel> readHotel(int priceHotel) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		try {

			String selectHotelQuery = "SELECT * FROM Hotel AS h WHERE h.price_per_night <= ?";

			PreparedStatement preparedStatement = connection.prepareStatement(selectHotelQuery);

			preparedStatement.setInt(1, priceHotel);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Hotel readHotel = new Hotel();
				readHotel.setId(result.getString("id"));
				readHotel.setName(result.getString("name_hotel"));
				readHotel.setIdIsle(result.getString("id_isle"));
				readHotel.setStanding(result.getString("standing"));
				readHotel.setPrice(result.getInt("price_per_night"));
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
	 * This method returns a limit of number of Historistic site
	 */
	@Override
	public List<TouristicSite> readSite(int numberOfHistoricSites) {
		List<TouristicSite> historics = new ArrayList<TouristicSite>();
		try {

			String selectHistoricSiteQuery = "SELECT * FROM TouristicSites AS ts WHERE ts.type_site ='HistoricSite' LIMIT "
					+ numberOfHistoricSites + "";

			PreparedStatement preparedStatement = connection.prepareStatement(selectHistoricSiteQuery);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				HistoricSite readSite = new HistoricSite();
				readSite.setId(result.getString("id_site"));
				readSite.setName(result.getString("name_site"));
				readSite.setIdIsle(result.getString("id_isle"));
				readSite.setPrice(result.getString("price"));
				readSite.setVisitTime(result.getString("visit_time"));
				historics.add(readSite);
				// System.out.println(readSite.toString());
			}

			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return historics;
	}

	/**
	 * This method returns a limit of number of activity
	 */
	@Override
	public List<TouristicSite> readActivity(int numberOfSearchActivity) {
		List<TouristicSite> activities = new ArrayList<TouristicSite>();
		try {

			String selectActivityQuery = "SELECT * FROM TouristicSites AS ts WHERE ts.type_site ='Activity' LIMIT "
					+ numberOfSearchActivity + "";

			PreparedStatement preparedStatement = connection.prepareStatement(selectActivityQuery);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				Activity readActivity = new Activity();
				readActivity.setId(result.getString("id_site"));
				readActivity.setName(result.getString("name_site"));
				readActivity.setIdIsle(result.getString("id_isle"));
				readActivity.setPrice(result.getString("price"));
				readActivity.setVisitTime(result.getString("visit_time"));
				activities.add(readActivity);
				// System.out.println(readActivity.toString());

			}

			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}

		return activities;
	}

	/**
	 * This method returns a list of touristic site
	 */
	@Override
	public List<TouristicSite> readTouristicSite(List<String> keyIds) {
		List<TouristicSite> touristicSites = new ArrayList<TouristicSite>();
		for(int i=0;i<keyIds.size();i++) {
			try {
				String keyId = keyIds.get(i);
				String selectSiteQuery = "SELECT * FROM TouristicSites AS ts WHERE ts.id_site = " + keyId + "";
	
				PreparedStatement preparedStatement = connection.prepareStatement(selectSiteQuery);
	
				ResultSet result = preparedStatement.executeQuery();
	
				while (result.next()) {
					TouristicSite touristicSite;
					if(result.getString("type_site").equals("Activity")) {
						touristicSite = new Activity();
					}
					else {
						touristicSite = new HistoricSite();
					}
					touristicSite.setId(result.getString("id_site"));
					touristicSite.setName(result.getString("name_site"));
					touristicSite.setIdIsle(result.getString("id_isle"));
					touristicSite.setPrice(result.getString("price"));
					touristicSite.setVisitTime(result.getString("visit_time"));
					touristicSites.add(touristicSite);
					// System.out.println(readActivity.toString());
	
				}
	
				preparedStatement.close();
	
			} catch (SQLException se) {
				System.err.println(se.getMessage());
			}
		}

		return touristicSites;
	}

}
