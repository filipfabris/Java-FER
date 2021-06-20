package primjer3;

import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GridLayoutExample extends JFrame {

	public GridLayoutExample() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Definiramo zatvaranje na windowu
		setLayout(new GridLayout(0, 3)); // Pocetak programa

		add(new JButton("Gumb 1")); // Dodajemo gumbe u window
		add(new JButton("2"));
		add(new JButton("Gumb 3"));
		add(new JButton("Dugi naziv Gumb 4"));
		add(new JButton("Gumb 5"));

	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				JFrame windows = new GridLayoutExample(); // window-a
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
