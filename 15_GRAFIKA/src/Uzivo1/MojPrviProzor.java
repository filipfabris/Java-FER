package Uzivo1;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MojPrviProzor extends JFrame {

	public MojPrviProzor() {
		this.setLocation(100, 100);
		this.setSize(400, 300);
		this.setTitle("Moj prvi prozor");
		this.setVisible(true);
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {

		// Anonimna klasa
//		SwingUtilities.invokeAndWait(new Runnable() {
//
//			@Override
//			public void run() {
//				JFrame f1 = new MojPrviProzor();
//
//			}
//		});

		// Lambda izraz
		SwingUtilities.invokeLater(() -> new MojPrviProzor());

		System.out.println("...");

	}

}
