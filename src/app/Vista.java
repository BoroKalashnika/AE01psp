package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JSpinner spinner1;
	JSpinner spinner2;
	JSpinner spinner3;
	JSpinner spinner4;
	JButton btnIniciarSim;
	JLabel lblTempsMultiprocesTxt;
	JLabel lblTempsMultifilTxt;

	public JSpinner getSpinner1() {
		return spinner1;
	}

	public JSpinner getSpinner2() {
		return spinner2;
	}

	public JSpinner getSpinner3() {
		return spinner3;
	}

	public JSpinner getSpinner4() {
		return spinner4;
	}

	public JButton getBtnIniciarSim() {
		return btnIniciarSim;
	}

	public JLabel getLblTempsMultiprocesTxt() {
		return lblTempsMultiprocesTxt;
	}

	public JLabel getLblTempsMultifilTxt() {
		return lblTempsMultifilTxt;
	}

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTipusProteina1 = new JLabel("Tipus de proteïna 1:");
		lblTipusProteina1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipusProteina1.setBounds(23, 25, 137, 26);
		contentPane.add(lblTipusProteina1);

		JLabel lblTipusProteina2 = new JLabel("Tipus de proteïna 2:");
		lblTipusProteina2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipusProteina2.setBounds(23, 62, 137, 26);
		contentPane.add(lblTipusProteina2);

		JLabel lblTipusProteina3 = new JLabel("Tipus de proteïna 3:");
		lblTipusProteina3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipusProteina3.setBounds(23, 99, 137, 26);
		contentPane.add(lblTipusProteina3);

		JLabel lblTipusProteina4 = new JLabel("Tipus de proteïna 4:");
		lblTipusProteina4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipusProteina4.setBounds(23, 136, 137, 26);
		contentPane.add(lblTipusProteina4);

		spinner1 = new JSpinner();
		spinner1.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner1.setBounds(170, 30, 124, 20);
		contentPane.add(spinner1);

		spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner2.setBounds(170, 65, 124, 20);
		contentPane.add(spinner2);

		spinner3 = new JSpinner();
		spinner3.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner3.setBounds(170, 104, 124, 20);
		contentPane.add(spinner3);

		spinner4 = new JSpinner();
		spinner4.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner4.setBounds(170, 141, 124, 20);
		contentPane.add(spinner4);

		btnIniciarSim = new JButton("Iniciar Simulacions");
		btnIniciarSim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarSim.setBounds(23, 173, 271, 34);
		contentPane.add(btnIniciarSim);

		lblTempsMultiprocesTxt = new JLabel("");
		lblTempsMultiprocesTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTempsMultiprocesTxt.setBounds(23, 218, 271, 26);
		contentPane.add(lblTempsMultiprocesTxt);

		lblTempsMultifilTxt = new JLabel("");
		lblTempsMultifilTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTempsMultifilTxt.setBounds(23, 255, 271, 26);
		contentPane.add(lblTempsMultifilTxt);
	}
}
