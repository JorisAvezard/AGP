package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Hotel;

/**
 * @author phcar
 * 
 * This class creates the link with the database 
 * and contains the method for the sql queries
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
	 * This method is a test
	 * It returns the number of touristic sites in the database
	 */
	@Override
	public int countSite(){
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
	public Hotel readHotel(String priceHotel) {
		Hotel readHotel = new Hotel();
		try {

			String selectHotelQuery = "SELECT * FROM Hotel AS h WHERE h.price_per_night = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(selectHotelQuery);

			preparedStatement.setString(1, priceHotel);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				readHotel.setId(result.getString("id"));
				readHotel.setIdIsle(result.getString("id_isle"));
				readHotel.setStanding(result.getString("standing"));
				readHotel.setPrice(result.getString("price_per_night"));
				
				System.out.println(readHotel.toString());
				
//				System.out.println(result.getString("id"));
//				System.out.println(result.getString("id_isle"));
//				System.out.println(result.getString("standing"));
//				System.out.println(result.getString("price_per_night"));
			}

			
			preparedStatement.close();

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
		
		
		return readHotel;
	}

}
