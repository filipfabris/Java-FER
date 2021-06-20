package primjer2;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class BorderLayoutExample extends JFrame {

	public BorderLayoutExample() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Definiramo zatvaranje na windowu

		setLayout(new BorderLayout()); // Pocetak programa

		add(new JButton("Sjever"), BorderLayout.NORTH); // Dodajemo gumbe u window
		add(new JButton("Zapad"), BorderLayout.WEST);
		add(new JButton("Centar"), BorderLayout.CENTER);
		add(new JButton("Istok"), BorderLayout.EAST);
		add(new JButton("Jug"), BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				JFrame windows = new BorderLayoutExample(); // window-a
				windows.setLocation(100, 200); // Velicina windows
				windows.pack(); // Sto manje postora da zauzme
				windows.setVisible(true); // Da se pojavi objekt windowa
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Kraj");

	}

}
