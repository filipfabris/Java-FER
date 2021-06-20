package UZIVO;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class FindPrimes extends JFrame {

	private static final long serialVersionUID = 1L;

	JTextArea ta;
	JProgressBar pb;

	public FindPrimes() {
		this.setLocation(100, 100);
		this.setSize(400, 500);
		setTitle("FindPrimes...");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout()); // ne treba nužno jer je BorderLayout default za JFrame

		JTextField tf1 = new JTextField("100000", 10); // prvo je text, drugo širina
		JTextField tf2 = new JTextField("500000", 10);
		JButton btn = new JButton("OK");

		JPanel npanel = new JPanel();
		npanel.add(tf1);
		npanel.add(tf2);
		npanel.add(btn);

		this.add(npanel, BorderLayout.NORTH);

		ta = new JTextArea();
		ta.setLineWrap(true);
		// hoću da se ta može "scrollati", zato ga moram staviti u scrollpane
		JScrollPane sp = new JScrollPane(ta);
		// pa scrollpane u centar borderlayouta
		add(sp); // isto kao this.add(sp, BodredLayout.CENTER);

		// progress bar - na jug
		pb = new JProgressBar();
		pb.setMinimum(0);
		pb.setMaximum(100);
		this.add(pb, BorderLayout.SOUTH);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int start = Integer.parseInt(tf1.getText());
				int end = Integer.parseInt(tf2.getText());

				// petlja se vrti "dugo" i blokira GUI thread, zato ju mičemo u SwingWorker
//				boolean flag = false;
//				for (int i= start; i<end; i++) {
//					flag = false;
//					for (int j=2; j<i; j++) {
//						if (i%j==0) {
//							flag = true;
//							break;
//						}
//					}
//					if (!flag)
//						ta.append(i + ", ");
//				}

				// ovdje ne bi bilo loše i disableati button, dok ne završi računanje

				// stvaranje SwingWorker objekta
				PrimCalculator pc = new PrimCalculator(start, end);
				// pokretanje posla u posebnom threadu
				pc.execute();

			}
		});

	}

	// SwingWorker - prvi parametar klase je povratni tip metode doInBackground
	// drugi argument je tip međurezultata. Ovdje je to "postotak" pretraženih
	// brojeva
	// uočite da postotak neće biti "vremenski" ispravan jer za veće brojeve treba
	// raditi više provjera itd...
	private class PrimCalculator extends SwingWorker<List<Integer>, Integer> {

		int start;
		int end;
		List<Integer> lista;

		public PrimCalculator(int s, int e) {
			start = s;
			end = e;
			lista = new ArrayList<>();
		}

		@Override
		protected List<Integer> doInBackground() throws Exception {

			int jedanPosto = ((end - start) / 100);

			boolean flag = false;
			for (int i = start; i < end; i++) {
				flag = false;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						flag = true;
						break;
					}
				}
				if (!flag)
					lista.add(i);
				// koliko smo posto odradili?
				if ((i - start) % jedanPosto == 0)
					publish((i - start) / jedanPosto); // "javi" da je obrađeno x%
			}

			return lista;
		}

		@Override
		protected void process(List<Integer> chunks) {
			// metoda publish je u "chunks" ubacila nekoliko (0, 1, 2.... ne znamo točno)
			// process će se pozvati "svakih toliko" i u njoj ćemo updateati progress bar
//			for (Integer chunk : chunks)
//				pb.setValue(chunk); // mogli smo i samo zadnji broj ubaciti
			int chunk = chunks.get(chunks.size() - 1);
			pb.setValue(chunk);

		}

		protected void done() {
			try {
				ta.setText(String.valueOf(this.get())); // Ispisuje sve prim brojeve
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ovdje bi trebalo još počistiti progress bar (setvalue na 0)
			// i enableati button
		}

	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new Runnable() {

			@Override
			public void run() {
				JFrame f1 = new FindPrimes();
				// f1.pack();
				f1.setVisible(true);
			}
		});
	}

}
