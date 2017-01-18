package persistence;

/**
 * 
 * @author phcar
 * 
 * Here is the class to test the simulation
 *
 */
public class TestSimulation {

	public static void main(String[] args) {
		JdbcPersistence simulation = new JdbcPersistence();
		
		String price="50";
		
		simulation.countSite();
		
//		System.out.println("hello1");
				
		simulation.readHotel(price);
		
//		System.out.println("hello2");

	}

}
