package Uzivo1;

import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MojDrugiProzor extends JFrame {

	public MojDrugiProzor() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocation(100, 100);
		this.setSize(400, 300);
		this.setTitle("Moj prvi prozor");
		this.setVisible(true);
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f1 = new MojDrugiProzor();

				JLabel l1 = new JLabel("OOP ");
				f1.add(l1);

				JTextField tf = new JTextField("I <3 Edgar");
				f1.add(tf);

				ImageIcon img = new ImageIcon("Screenshot_4");
				JLabel imgLabel = new JLabel(img);
				f1.add(imgLabel);

				JButton btn = new JButton("Click me!");
				f1.add(btn);

				f1.pack();
			}
		});

		System.out.println("...");

	}

}
