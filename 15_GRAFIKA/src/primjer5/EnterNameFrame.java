package primjer5;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class EnterNameFrame extends JFrame {

	public EnterNameFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // Nije potrebno

		JPanel panel = (JPanel) getContentPane();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JLabel labelTitle = new JLabel("Naslov");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelTitle, BorderLayout.NORTH);

		panel.add(new JLabel("Unesite ime i preime: "), BorderLayout.WEST);

		JTextField textInput = new JTextField(); // UNOS TEXTA
		panel.add(textInput, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		JButton btnOK = new JButton("OK");
		southPanel.add(btnOK);
		add(southPanel, BorderLayout.SOUTH); // Svugdje se je moglo bez panel.add znaci samo add

		// Prvi Listener
		ActionListener listener = (e) -> {
			JOptionPane.showMessageDialog(EnterNameFrame.this, "Hello " + textInput.getText());
		};
		btnOK.addActionListener(listener);

		// Drugi Listener
		btnOK.addActionListener((e) -> JOptionPane.showMessageDialog(EnterNameFrame.this, "Ovo je drugi listener "));

		// Dodavanje gumba za otkazivanje Listenera
		JButton btnCancelListener = new JButton("Cancel Listener");
		btnCancelListener.addActionListener((e) -> btnOK.removeActionListener(listener));
		southPanel.add(btnCancelListener);
	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				JFrame windows = new EnterNameFrame(); // window-a
				windows.setBounds(100, 100, 250, 200); // DEFINIRANJE VELICINE PROZORA
				windows.setVisible(true); // Da se pojavi objekt windowa
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Kraj");

	}

}
