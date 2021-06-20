package Zadatak7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RollingDieSwingWorker extends JFrame {
	JLabel lbRollings = new JLabel("", JLabel.CENTER); // Čitac klizaca
	JSlider slRollings = new JSlider(0, 1000000, 6000); // Klizač
	JTextField[] txOccurences, txRelFrequency;
	JButton btStart = new JButton("Start");
	JButton btCalculate = new JButton("Calculate relative freq.");
	int total;
	int dieValue = 0;
	int DIE_VALUES = 6; // Broj stanja na koci

	public RollingDieSwingWorker() {
		setTitle("Rolling Die - GUI not responsive");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocation(200, 300);

		JPanel pnSlider = new JPanel();
		pnSlider.setLayout(new BorderLayout());
		lbRollings.setBackground(Color.WHITE);
		lbRollings.setOpaque(true);
		slRollings.setMajorTickSpacing(200000);
		slRollings.setMinorTickSpacing(100000);
		slRollings.setPaintTicks(true);
		slRollings.setPaintLabels(true);
		lbRollings.setText(String.valueOf(slRollings.getValue())); // citanje klizaca
		pnSlider.add(lbRollings, BorderLayout.NORTH);
		pnSlider.add(slRollings, BorderLayout.SOUTH);

		add(pnSlider, BorderLayout.NORTH); // DODAJEM U FRAME

		JPanel pnResults = new JPanel();
		pnResults.setLayout(new GridLayout(DIE_VALUES, 0, 3, 3));
		txOccurences = makeTextFields();
		txRelFrequency = makeTextFields();
		for (int i = 0; i < txOccurences.length; i++) {
			pnResults.add(txOccurences[i]);
			pnResults.add(txRelFrequency[i]);
		}
		add(pnResults, BorderLayout.CENTER);

		JPanel pnButtons = new JPanel();
		pnButtons.add(btStart);
		pnButtons.add(btCalculate);
		add(pnButtons, BorderLayout.SOUTH);

		slRollings.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				lbRollings.setText(String.valueOf(slRollings.getValue()));
			}
		});

		btStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btStart.setEnabled(false);
				slRollings.setEnabled(false);
				for (int i = 0; i < DIE_VALUES; i++) {
					txOccurences[i].setText("0");
					txRelFrequency[i].setText("0");
				}

				new RollingTask(Integer.parseInt(lbRollings.getText())).execute(); // .execute();
				// POZIV SWINGA
			}
		});

		btCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (total == 0) {
					System.out.println("Nema elemenata");
					return;
				}
				for (int i = 0; i < DIE_VALUES; i++) {
					try {
						txRelFrequency[i].setText(
								String.format("%5.4f  ", Integer.valueOf(txOccurences[i].getText()) / (double) total));
					} catch (NumberFormatException ex) {
						System.out.println(ex);
					}
				}
			}
		});
		pack();
	}

	private class RollingTask extends SwingWorker<Void, Integer[]> {
		// Prvi argument povrat informacije dugotrajnog procesa
		// Drugi argument predstavlja međurezultat dugotrajnog posla, objavljeni <-
		// MEĐUREZULTAT

		// <T> the result type returned by this SwingWorker's doInBackground and get
		// methods
		// <V> the type used for carrying out intermediate results by this
		// SwingWorker's publish and process methods
		private int noOfRolling;

		public RollingTask(int noRolling) {
			this.noOfRolling = noRolling;
		}

		// Ovo se izvodi na nekom novom THREDU
		// Uvijek Override
		@Override
		protected Void doInBackground() throws Exception {
			total = 0;
			Integer[] outcome = { 0, 0, 0, 0, 0, 0 };
			Random random = new Random();
			System.out.println(
					"Intensive task is running on Event Dispatch Thread? " + SwingUtilities.isEventDispatchThread());

			// While lista
			while (total < noOfRolling) {
				total++;
				dieValue = random.nextInt(DIE_VALUES);
				outcome[dieValue]++;

				if (total % 1000 == 0) { // ovo mozemo izbrisat dodano je samo da se vidi kao se brojevi povecavaju
					try { // Jer je SwingWorker sada jako brz
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
				publish(outcome); // Međurezultat ("intermediate results") Pa je zato
									// Integer[] kako sto je <V>
			}
			// While lista

			return null;
		}

		// OVO SE IZVODI NA GLAVNOM THREDU EDT
		@Override
		protected void process(List<Integer[]> progress) { // List<Međurezultat[]> progress
			Integer[] lastOutcome = progress.get(progress.size() - 1); // only last is taken
			for (int i = 0; i < DIE_VALUES; i++) {
				txOccurences[i].setText(String.format("%d", lastOutcome[i]));
			}
		}

		// OVO SE IZVODI NA GLAVNOM THREDU EDT
		@Override
		protected void done() { // Kada si gotov pusti gumbe da se opet mogu aktivirati
			btStart.setEnabled(true);
			slRollings.setEnabled(true);
		}

	}

	private JTextField[] makeTextFields() {
		JTextField[] texts = new JTextField[DIE_VALUES];
		for (int i = 0; i < texts.length; i++) {
			JTextField t = new JTextField(20);
			t.setEditable(false);
			t.setHorizontalAlignment(JTextField.RIGHT);
			t.setText("0");
			texts[i] = t;
		}
		return texts;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new RollingDieSwingWorker().setVisible(true);
			}
		});
	}
}
