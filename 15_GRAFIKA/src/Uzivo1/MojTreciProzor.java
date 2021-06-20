package Uzivo1;

import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MojTreciProzor extends JFrame {

	public MojTreciProzor() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setSize(400, 300);
		this.setTitle("Moj prvi prozor");
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f1 = new MojTreciProzor();

				JLabel l1 = new JLabel("OOP ");
				JTextField tf = new JTextField("I <3 Edgar"); // Vec ima tekst u textFiledu jes smo dodali u argument
																// tekst
				ImageIcon img = new ImageIcon("Screenshot_4");
				JLabel imgLabel = new JLabel(img);
				JButton btn = new JButton("Click me!");

				// Flow
//				f1.setLayout(new FlowLayout());
//				f1.add(l1);
//				f1.add(btn);
//				f1.add(tf);

				// Border
//				f1.setLayout(new BorderLayout());
//				f1.add(l1, BorderLayout.NORTH);
//				f1.add(btn, BorderLayout.SOUTH);
//				f1.add(tf); // Ostaje na sredini po defaultu

				// Grid
				f1.setLayout(new GridLayout(2, 0)); // Zadrzava 2 retka
				f1.add(l1);
				f1.add(btn);
				f1.add(tf);
				f1.add(new JButton("Klikni me 2"));
				f1.add(new JButton("Klikni me 2"));
				f1.add(new JButton("Klikni me 2"));
				f1.add(new JButton("Klikni me 2"));

//				f1.pack(); //Smanji na najmanju mogucu velicinu a da sve stane
				f1.setVisible(true);
			}
		});

		System.out.println("...");

	}

}
