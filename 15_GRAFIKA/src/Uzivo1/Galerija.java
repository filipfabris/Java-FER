package Uzivo1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Galerija extends JFrame {

	public Galerija() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setSize(400, 300);
		this.setTitle("Moja GALERIJA");
		this.setVisible(true);

		JButton btn1 = new JButton("Slika 1");
		JButton btn2 = new JButton("Slika 2");

		this.setLayout(new BorderLayout());
		add(btn1, BorderLayout.SOUTH);
		add(btn2, BorderLayout.WEST);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Klik!");
			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Klak!");
			}
		});
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f1 = new MojDrugiProzor();

//				f1.pack();
			}
		});

	}

}
