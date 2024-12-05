package app;

/**
 * Classe principal Simulador que inicialitza l'aplicació. Configura la vista i
 * el controlador per gestionar la simulació.
 */
public class Simulador {

	/**
	 * Punt d'entrada de l'aplicació.
	 * 
	 * @param args Arguments de la línia de comandes (no utilitzats en aquesta
	 *             aplicació).
	 */
	public static void main(String[] args) {
		Vista vista = new Vista();

		new Controlador(vista);
	}
}
