package clases;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

/**
 * Classe SimulacioMT que implementa l'execució d'una simulació multitasca (MT).
 * Aquesta classe representa una simulació que pot ser executada en un fil
 * separat.
 */
public class SimulacioMT implements Runnable {

	private int tipus;
	private int ordre;

	/**
	 * Constructor de la classe SimulacioMT.
	 * 
	 * @param tipus El tipus de simulació a executar.
	 * @param ordre L'ordre o identificador únic d'aquesta simulació.
	 */
	public SimulacioMT(int tipus, int ordre) {
		this.tipus = tipus;
		this.ordre = ordre;
	}

	/**
	 * Mètode run que s'executa quan el fil és iniciat. Realitza la simulació,
	 * mesura el temps d'execució i genera un fitxer amb els resultats.
	 */
	@Override
	public void run() {
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
	private void crearFitxer(int tipus, int ordre, String inici, String fi, double temps, double resultat) {

		new File("./proteinas/MT").mkdirs();

		String nomFitxer = String.format("./proteinas/MT/PROT_MT_%d_n%d_%s.sim", tipus, ordre, inici);

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
