package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clases.SimulacioMT;

/**
 * Classe Controlador que gestiona la lògica de la interfície gràfica i les
 * simulacions. Connecta la vista amb la funcionalitat i coordina l'execució de
 * simulacions en multiprocés i multifil.
 */
public class Controlador {
	private Vista vista;
	private ActionListener actionListener_calcular;
	List<Process> process = new ArrayList<>();

	/**
	 * Constructor del controlador. Configura la vista i inicialitza els
	 * controladors d'esdeveniments.
	 * 
	 * @param vista L'objecte Vista que representa la interfície gràfica.
	 */
	public Controlador(Vista vista) {
		this.vista = vista;
		control();
	}

	/**
	 * Configura els controladors d'esdeveniments per a la vista.
	 */
	private void control() {
		vista.setVisible(true);

		actionListener_calcular = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] quantitats = { (int) vista.getSpinner1().getValue(), (int) vista.getSpinner2().getValue(),
						(int) vista.getSpinner3().getValue(), (int) vista.getSpinner4().getValue() };

				executarMP(quantitats);
				simulacioMultifil(quantitats);
			}
		};

		vista.getBtnIniciarSim().addActionListener(actionListener_calcular);
	}

	/**
	 * Executa la simulació en mode multiprocés.
	 * 
	 * @param quantitats Nombre de simulacions per a cada tipus.
	 */
	void executarMP(int[] quantitats) {
		long startMP = System.currentTimeMillis();

		simulacioMultiproces(quantitats);

		process.forEach(pro -> {
			try {
				pro.waitFor();
			} catch (InterruptedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", 0);
			}
		});

		long endMP = System.currentTimeMillis();
		vista.getLblTempsMultiprocesTxt()
				.setText(String.format("Temps multiprocés: %.2f segons\n", (endMP - startMP) / 1000.0));
	}

	/**
	 * Configura i inicia les simulacions en mode multiprocés.
	 * 
	 * @param quantitats Nombre de simulacions per a cada tipus.
	 */
	void simulacioMultiproces(int[] quantitats) {
		for (int tipus = 1; tipus <= 4; tipus++) {
			for (int i = 1; i <= quantitats[tipus - 1]; i++) {
				String classe = "clases.SimulacioMP";

				String javaHome = System.getProperty("java.home");
				String javaBin = javaHome + File.separator + "bin" + File.separator + "java";

				String classpath = System.getProperty("java.class.path");

				List<String> command = new ArrayList<>();
				command.add(javaBin);
				command.add("-cp");
				command.add(classpath);
				command.add(classe);
				command.add(String.valueOf(tipus));
				command.add(String.valueOf(i));

				ProcessBuilder builder = new ProcessBuilder(command);
				try {
					Process proces = builder.start();
					process.add(proces);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
				}
			}
		}
	}

	/**
	 * Executa la simulació en mode multifil.
	 * 
	 * @param quantitats Nombre de simulacions per a cada tipus.
	 */
	void simulacioMultifil(int[] quantitats) {
		long startMT = System.currentTimeMillis();
		List<Thread> fils = new ArrayList<>();

		for (int tipus = 1; tipus <= 4; tipus++) {
			for (int i = 1; i <= quantitats[tipus - 1]; i++) {
				Thread thread = new Thread(new SimulacioMT(tipus, i));
				fils.add(thread);
				thread.start();
			}
		}

		fils.forEach(fil -> {
			try {
				fil.join();
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
			}
		});

		long endMT = System.currentTimeMillis();
		vista.getLblTempsMultifilTxt()
				.setText(String.format("Temps multifil: %.2f segons\n", (endMT - startMT) / 1000.0));
	}
}
