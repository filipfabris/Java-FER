package Zadatak1;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class InputDataForm extends JPanel {
	JTextField txName = new JTextField();
	JCheckBox chVaccinated = new JCheckBox("Vaccinated");
	JTextField txAddress = new JTextField();

	public InputDataForm() {
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2); // broj tickness
		setBorder(border);
		setLayout(new GridLayout(3, 2, 5, 5));

		// Ovako ne radi!!!
//		JLabel lb1 = new JLabel("Name: ");
//		add(lb1, SwingConstants.RIGHT);

		JLabel lb1 = new JLabel("Name:", SwingConstants.RIGHT);
		add(lb1);
		add(txName);

		JLabel lb2 = new JLabel();
		add(lb2);
		add(chVaccinated);

		JLabel lb3 = new JLabel("Address:", SwingConstants.RIGHT);
		add(lb3);
		add(txAddress);

		// ili
//		add(new JLabel("Address:", SwingConstants.RIGHT));
//		add(txAddress);

	}

}
