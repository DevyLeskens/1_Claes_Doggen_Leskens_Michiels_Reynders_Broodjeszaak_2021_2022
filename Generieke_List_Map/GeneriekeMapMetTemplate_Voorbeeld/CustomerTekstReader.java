package template;

public class CustomerTekstReader extends TekstLoadTemplate {
	@Override
	protected Customer maakObject(String[] tokens) {
		Customer customer = new Customer(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3]);
		return customer;
	}
	
	protected String getKey(String[] tokens){
		return tokens[1];
	}
}
