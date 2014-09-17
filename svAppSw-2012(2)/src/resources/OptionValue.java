/**
 * Rappresent oggetti di tipo optionValue, specifica un determinato valore per un opzione con un prezzo associato.
 * Questa classe è in relazione solo con la classe Option, in particolare un oggetto di tipo Option può contenere 
 * zero o più oggetti di tipo optionValue
 */
package resources;

/**
 * @author utente
 *
 */
public class OptionValue {

		String value;
		double price;
		
		
		public OptionValue(String value, double price) {
			this.value = value;
			this.price = price;
		}


		public String getValue() {
			return value;
		}


		public void setValue(String value) {
			this.value = value;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}
		
		
		
}
