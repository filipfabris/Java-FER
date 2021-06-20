package Zadatak1;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class LayoutDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	public LayoutDemo() {
		setTitle("Layouts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tp = new JTabbedPane();
		tp.addTab("Layout 1", new PanelWithLayout1());
		tp.addTab("Layout 2", new PanelWithLayout2());
		tp.addTab("Layout 3", new PanelWithLayout3());
		tp.addTab("Input Data Form", new InputDataForm());
		add(tp);
		pack();
		setLocation(100, 200);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new LayoutDemo().setVisible(true);
			}
		});
	}

}
