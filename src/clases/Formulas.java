package clases;

/**
 * Classe Formulas que conté mètodes matemàtics per a la simulació.
 */
public class Formulas {

	/**
	 * Mètode static que realitza una simulació basada en càlculs matemàtics.
	 * 
	 * @param type Tipus de simulació, que determina la durada del procés.
	 * @return El resultat d'un càlcul aleatori amb la funció sinus.
	 */
	public static double simulation(int type) {
		double calc = 0.0;
		double simulationTime = Math.pow(5, type);
		double startTime = System.currentTimeMillis();
		double endTime = startTime + simulationTime;
		while (System.currentTimeMillis() < endTime) {
			calc = Math.sin(Math.pow(Math.random(), 2));
		}
		return calc;
	}
}
