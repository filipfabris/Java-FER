package Zadatak6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RollingDieGUIUnresponsive extends JFrame {
	JLabel lbRollings = new JLabel("", JLabel.CENTER); // Čitac klizaca
	JSlider slRollings = new JSlider(0, 1000000, 6000); // Klizač
	JTextField[] txOccurences, txRelFrequency;
	JButton btStart = new JButton("Start");
	JButton btCalculate = new JButton("Calculate relative freq.");
	int total;
	int dieValue = 0;
	int DIE_VALUES = 6; // Broj stanja na koci

	public RollingDieGUIUnresponsive() {
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

				int noOfRolling = Integer.parseInt(lbRollings.getText());

				new Thread(() -> {
					intensiveTask(noOfRolling);
					btStart.setEnabled(true);
					slRollings.setEnabled(true);
				}).start(); // .start threda

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

	private void intensiveTask(int noOfRolling) {
		total = 0;
		Integer[] outcome = { 0, 0, 0, 0, 0, 0 };
		Random random = new Random();
		System.out.println(
				"Intensive task is running on Event Dispatch Thread? " + SwingUtilities.isEventDispatchThread());
		while (total < noOfRolling) {
			total++;
			dieValue = random.nextInt(DIE_VALUES);
			outcome[dieValue]++;

			try {
				SwingUtilities
						.invokeLater(() -> txOccurences[dieValue].setText(String.format("%d", outcome[dieValue])));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private JTextField[] makeTextFields() {
		JTextField[] texts = new JTextField[DIE_VALUES];
		for (int i = 0; i < texts.length; i++) {
			JTextField t = new JTextField(20); // 20 onzacava sirinu text fielda, samo izgleda ljepo
			t.setEditable(false);
			t.setHorizontalAlignment(JTextField.RIGHT); // Tekst unutra je desno centriran
			t.setText("0");
			texts[i] = t;
		}
		return texts;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new RollingDieGUIUnresponsive().setVisible(true));
	}

}
