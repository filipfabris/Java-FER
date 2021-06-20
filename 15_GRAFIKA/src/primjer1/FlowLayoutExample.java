package primjer1;

import java.awt.FlowLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class FlowLayoutExample extends JFrame {
	// ONO STA NA STANE IDE U NOVI RED; KARAKTERISTICNO ZA FlowLayout

	public FlowLayoutExample() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Definiramo zatvaranje na windowu
		FlowLayout layout = new FlowLayout(); // Stvaranje razmjestaja
		layout.setAlignment(FlowLayout.RIGHT); // Poravnanje na jednu stranu
		setLayout(layout); // Pocetak programa

		add(new JButton("Gumb 1")); // Dodajemo gumbe u window
		add(new JButton("2"));
		add(new JButton("Gumb 3"));
		add(new JButton("Dugi naziv Gumb 4"));
		add(new JButton("Gumb 5"));

	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				JFrame windows = new FlowLayoutExample(); // window-a
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
