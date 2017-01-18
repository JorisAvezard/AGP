package persistence;

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
		
		simulation.readSite(total);
		
		//simulation.countSite();
		
		//System.out.println("hello1");
				
		//simulation.readHotel(price);
		
	}

}
