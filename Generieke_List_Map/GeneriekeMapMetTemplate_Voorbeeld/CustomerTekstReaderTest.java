package template;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
public class CustomerTekstReaderTest {
	public static void main (String [] args){
		File file = new File("src/template/bestanden/Customer.txt");
		
		Map<String, Customer> resultMap;
		try {
			resultMap = new CustomerTekstReader().load(file);
			System.out.println(resultMap);
			ArrayList<Customer> customers = new ArrayList<Customer>(resultMap.values()) ;
			Collections.sort(customers);
			System.out.println(customers);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
