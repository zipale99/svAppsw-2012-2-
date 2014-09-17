/**
 * Rappresenta la tipologia Transport di uno StayTemplateLeaf
 */
package composite;

import java.util.List;

import resources.Option;

/**
 * @author utente
 *
 */
public class Transport extends StayTemplateLeaf {
	
	private String vehicle;
	
	public Transport(String vehicle, String startLoc, String endLoc, int durata, String nome, double price, int timeOffset, List<Option> optionValueList) {
		super(startLoc, endLoc, durata, nome, "Transport", price, timeOffset, optionValueList);
		this.vehicle = vehicle;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +
				"\nVeicolo: " + vehicle;
	}
	
	
}
