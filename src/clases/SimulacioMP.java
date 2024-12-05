package clases;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

/**
 * Classe SimulacioMP que implementa una simulació mitjançant procés únic (MP).
 * Aquesta classe és el punt d'entrada principal i executa una simulació basada
 * en arguments passats des de la línia de comandes.
 */
public class SimulacioMP {

	/**
	 * Mètode principal de la classe. Llegeix els arguments de la línia de comandes,
	 * executa una simulació i genera un fitxer amb els resultats.
	 * 
	 * @param args Arguments de la línia de comandes: args[0]: Tipus de simulació
	 *             (enter). args[1]: Ordre o identificador de la simulació (enter).
	 */
	public static void main(String[] args) {

		int tipus = Integer.parseInt(args[0]);
		int ordre = Integer.parseInt(args[1]);

		String timestampInici = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));

		long start = System.currentTimeMillis();
		double resultat = Formulas.simulation(tipus);
		long end = System.currentTimeMillis();

		String timestampFinal = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
		double temps = (end - start) / 1000.0;

		crearFitxer(tipus, ordre, timestampInici, timestampFinal, temps, resultat);
	}

	/**
	 * Mètode privat per crear un fitxer amb els resultats de la simulació.
	 * 
	 * @param tipus    El tipus de simulació.
	 * @param ordre    L'ordre o identificador de la simulació.
	 * @param inici    El timestamp inicial.
	 * @param fi       El timestamp final.
	 * @param temps    El temps que ha trigat la simulació en segons.
	 * @param resultat El resultat obtingut de la simulació.
	 */
	private static void crearFitxer(int tipus, int ordre, String inici, String fi, double temps, double resultat) {

		new File("./proteinas/MP").mkdirs();

		String nomFitxer = String.format("./proteinas/MP/PROT_MP_%d_n%d_%s.sim", tipus, ordre, inici);

		try (FileWriter fw = new FileWriter(nomFitxer)) {
			fw.write(inici + "\n");
			fw.write(fi + "\n");
			fw.write(String.format("%.2f", temps).replace('.', '_') + "\n");
			fw.write(String.valueOf(resultat));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
		}
	}
}
