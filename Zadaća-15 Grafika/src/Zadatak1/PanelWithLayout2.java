package Zadatak1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelWithLayout2 extends JPanel {

	JButton b1 = new JButton("Button1");
	JButton b2 = new JButton("Button2 is very very long");
	JButton b3 = new JButton("Button3");
	JButton b4 = new JButton("Button4 is very very long");
	JButton b5 = new JButton("Button5");

	public PanelWithLayout2() {
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);

	}

}
