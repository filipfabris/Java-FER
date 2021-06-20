package Zadatak4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ComplexNumbersConverter extends JFrame {
	JLabel lbReal = new JLabel("Real part: ", SwingConstants.RIGHT);
	JLabel lbImag = new JLabel("Imaginary part: ", SwingConstants.RIGHT);
	JLabel lbModule = new JLabel(" Module:  ", SwingConstants.RIGHT);
	JLabel lbAngle = new JLabel(" Angle (in degrees)):  ", SwingConstants.RIGHT);

	JTextField txReal = new JTextField(JTextField.CENTER);
	JTextField txImag = new JTextField(JTextField.CENTER);
	JTextField txModule = new JTextField(JTextField.CENTER);
	JTextField txAngle = new JTextField(JTextField.CENTER);

	JToggleButton tbRectangular = new JToggleButton("To rectg");
	JToggleButton tbPolar = new JToggleButton("To polar");

	JTextArea taResult = new JTextArea();

	JMenuBar mb = new JMenuBar();
	JMenu mAction = new JMenu("Action");
	JMenuItem calculateItem = new JMenuItem("Calculate");
	JMenuItem clearItem = new JMenuItem("Clear");
	JMenuItem exitItem = new JMenuItem("Exit");

	JMenu mStyle = new JMenu("Style");
	JMenuItem boldItem = new JMenuItem("BOLD");
	JMenuItem plainItem = new JMenuItem("PLAIN");

	Font fontPlain = new Font("Monospaced", Font.PLAIN, 20);
	Font fontBold = new Font("Monospaced", Font.BOLD, 20);
	DecimalFormatSymbols decimalSeparator = new DecimalFormatSymbols();
	DecimalFormat formatter;

	public ComplexNumbersConverter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Rectangle - Polar *CALCULATOR*");
		setSize(400, 300);
		decimalSeparator.setDecimalSeparator('.');
		formatter = new DecimalFormat("###.##", decimalSeparator);

		JMenu actionMenu = createActionMenu();
		JMenu styleMenu = createStyleMenu();
		mb.add(actionMenu); // dodajemo u opcenit menu
		mb.add(styleMenu); // dodajemo u opcenit menu
		setJMenuBar(mb);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		tbPolar.setSelected(true);

		ButtonGroup buttonGroup = new ButtonGroup(); // Dodajemo ih u grupu tako da ne mogu oba dva biti aktivna
		buttonGroup.add(tbRectangular);
		buttonGroup.add(tbPolar); // Da nisu dodani u grupu oba dva bi bila neovisna, mogli bismo oba dva
									// aktivirati

		buttonPanel.add(tbRectangular);
		buttonPanel.add(tbPolar);

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(4, 0, 3, 3));
		labelPanel.add(lbReal);
		labelPanel.add(lbImag);
		labelPanel.add(lbModule);
		labelPanel.add(lbAngle);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 0, 3, 3));
		txModule.setEditable(false);
		txAngle.setEditable(false);
		inputPanel.add(txReal);
		inputPanel.add(txImag);
		inputPanel.add(txModule);
		inputPanel.add(txAngle);

		taResult.setEditable(false);
		taResult.setFont(fontPlain);

		add(buttonPanel, BorderLayout.PAGE_START); // Gore
		add(labelPanel, BorderLayout.LINE_START); // Desno
		add(inputPanel, BorderLayout.CENTER); // Centar
		add(taResult, BorderLayout.PAGE_END); // Dolje
		// Razlika je u tome sto se ovdje centar ne siri najvise sta moze

		txReal.setHorizontalAlignment(JTextField.CENTER); // Kada se unosi tekst u textfield bit ce na sredini
		txReal.setFont(fontPlain); // Postavljamo default font
		txImag.setHorizontalAlignment(JTextField.CENTER);
		txImag.setFont(fontPlain);
		txModule.setHorizontalAlignment(JTextField.CENTER);
		txModule.setFont(fontPlain);
		txAngle.setHorizontalAlignment(JTextField.CENTER);
		txAngle.setFont(fontPlain);

		tbRectangular.addActionListener((event) -> {
			clearItem.doClick();
			txReal.setEditable(false);
			txImag.setEditable(false);
			txModule.setEditable(true);
			txAngle.setEditable(true);
		});
		tbPolar.addActionListener((event) -> {
			clearItem.doClick();
			txReal.setEditable(true);
			txImag.setEditable(true);
			txModule.setEditable(false);
			txAngle.setEditable(false);
		});

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txReal.requestFocusInWindow();
			}
		});

	}

	private JMenu createStyleMenu() {
		mStyle.add(boldItem);
		boldItem.addActionListener(event -> {
			txReal.setFont(fontBold);
			txImag.setFont(fontBold);
			txModule.setFont(fontBold);
			txAngle.setFont(fontBold);
			taResult.setFont(fontBold);
		});

		mStyle.add(plainItem);
		plainItem.addActionListener(event -> {
			txReal.setFont(fontPlain);
			txImag.setFont(fontPlain);
			txModule.setFont(fontPlain);
			txAngle.setFont(fontPlain);
			taResult.setFont(fontPlain);
		});

		return mStyle;
	}

	private JMenu createActionMenu() {
		mAction.add(calculateItem); // Dodajemo u jedan općenitiji "glavniji" menu
		calculateItem.addActionListener((e) -> {
			taResult.setText("");
			if (tbPolar.isSelected()) {
				double real = 0.;
				double imag = 0.;
				try {
					real = Double.valueOf(txReal.getText());
					imag = Double.valueOf(txImag.getText());
				} catch (NumberFormatException ex) {
					taResult.setText("wrong input");
					txModule.setText("");
					txAngle.setText("");
					return;
				}
				double[] result = Calculator.toPolar(real, imag);
				txModule.setText(formatter.format(result[0]));
				txAngle.setText(formatter.format(result[1]));
				taResult.setText(formatter.format(result[0]) + "  |" + formatter.format(result[1]));
			}
			if (tbRectangular.isSelected()) {
				double module = 0.;
				double angle = 0.;
				try {
					module = Double.valueOf(txModule.getText());
					angle = Double.valueOf(txAngle.getText());
					if (module < 0.)
						throw new NumberFormatException();
				} catch (NumberFormatException ex) {
					taResult.setText("wrong input");
					txReal.setText("");
					txImag.setText("");
					return;
				}
				double[] result = Calculator.toRectg(module, angle);
				txReal.setText(formatter.format(result[0]));
				txImag.setText(formatter.format(result[1]));
				if (result[1] < 0.)
					taResult.setText(formatter.format(result[0]) + formatter.format(result[1]) + "i");
				else
					taResult.setText(formatter.format(result[0]) + "+" + formatter.format(result[1]) + "i");
			}

		});

		mAction.add(clearItem);
		clearItem.addActionListener(event -> {
			txReal.setText("");
			txImag.setText("");
			txModule.setText("");
			txAngle.setText("");
			taResult.setText("");
//			if (tbPolar.isSelected()) {
////				txReal.requestFocusInWindow();
//			} else {
////				txModule.requestFocusInWindow();
//			}
		});

		mAction.addSeparator();

		mAction.add(exitItem);
		exitItem.addActionListener(event -> System.exit(0));

		return mAction;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ComplexNumbersConverter().setVisible(true));
	}

}
