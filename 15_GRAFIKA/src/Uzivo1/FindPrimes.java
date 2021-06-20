package Uzivo1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class FindPrimes extends JFrame {

	JTextField broj1;
	JTextField broj2;
	JButton btn;
	JTextArea ta;
	JProgressBar pb;

	public FindPrimes() {

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setSize(400, 300);
		this.setTitle("Find primes");
		this.setVisible(true);

		broj1 = new JTextField(10); // Velicina
		broj2 = new JTextField(10);
		btn = new JButton("Kreni");
		// Preskacemo borderlaytout

		ta = new JTextArea();
		ta.setLineWrap(true); // Prelama u novi red

		JPanel jp = new JPanel();
		jp.add(broj1);
		jp.add(broj2);
		jp.add(btn);
		this.add(jp, BorderLayout.NORTH);

		this.add(ta, BorderLayout.CENTER);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int start = Integer.parseInt(broj1.getText());
				int end = Integer.parseInt(broj2.getText());
				System.out.println("Start " + start + " End " + end);

				PrimCalculator pc = new PrimCalculator(start, end);
				pc.execute(); // Izvrsi na Thredu, non blocking naredba

			}
		});

	}

	private class PrimCalculator extends SwingWorker<List<Integer>, Integer> {

		// Klasa koje ce sama stvoriti svoj Thred, to je power od SwingWorkera
		// T vraća, V Međurezultat

		int start, end;
		List<Integer> retList;

		public PrimCalculator(int a, int b) {
			start = a;
			end = b;
		}

		@Override
		// Radi u pozadini, u novom Thredu, neće ometat nas frame
		protected List<Integer> doInBackground() throws Exception {
			retList = new ArrayList<>();

			boolean flag;
			for (int i = start; i < end; i++) {
				flag = false;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					retList.add(i);
				}
			}
			return retList;
		}

		@Override
		protected void done() {
			try {
				ta.setText(this.get().toString());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f1 = new FindPrimes();
				f1.setVisible(true);
//				f1.pack();
			}
		});

	}

}
