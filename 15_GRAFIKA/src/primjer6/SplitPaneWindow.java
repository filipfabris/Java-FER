package primjer6;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SplitPaneWindow extends JFrame {
	private Map<String, UserData> userData;
	private JSplitPane splitPane;
	private JPanel buttonsPanel;
	private ActionListener toggleButtonListener;
	private InputUserDataPanel userDataPanel;

	public SplitPaneWindow() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Primjer 6");

		// Crta koja razdvaja
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);

		// Lijevo
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(0, 1));

		// Desno
		userDataPanel = new InputUserDataPanel();

		// Postavljanje lijeve i desne strane
		splitPane.setLeftComponent(buttonsPanel);
		splitPane.setRightComponent(userDataPanel);

		// Ucitavamo podatke, od userDataFactory (zadano)
		userData = UserDataFactory.getData();

		toggleButtonListener = (actionEvent) -> {
			JToggleButton selectedButton = (JToggleButton) actionEvent.getSource();
			deselectOthers(selectedButton);
			String uid = actionEvent.getActionCommand();
			// Mogao je imati, a zasto ima ?

			userDataPanel.setUserData(userData.get(uid));
			selectedButton.setSelected(true);
		};

		for (var entry : userData.entrySet()) {
			JToggleButton button = new JToggleButton(
					entry.getValue().getFirstName() + " " + entry.getValue().getLastName());
			button.setActionCommand(entry.getKey());
			button.addActionListener(toggleButtonListener);
			buttonsPanel.add(button);
		}

		createToolbar();

		selectFirst();

	}

	private void deselectOthers(JToggleButton selectedButton) {
		for (Component c : selectedButton.getParent().getComponents()) {
			if (c instanceof JToggleButton) {
				JToggleButton button = (JToggleButton) c;
				if (button != selectedButton && button.isSelected()) {
					String uid = button.getActionCommand();
					UserData data = userDataPanel.getUserData();
					userData.put(uid, data);
					button.setText(data.getFirstName() + " " + data.getLastName());
					button.setSelected(false);
				}
			}
		}
	}

	// Paljenjem programa uvijek je samo prvi button stisnut
	private void selectFirst() {
		if (userData.size() > 0) {
			for (Component c : buttonsPanel.getComponents()) {
				if (c instanceof JToggleButton) { // Moze bit da nije sve Toogle Button zbog unutranje implementacije
					((JToggleButton) c).doClick();
					break;
				}
			}

		} else {
			splitPane.setVisible(false);
		}
	}

	private void createToolbar() {
		JToolBar toolbar = new JToolBar();
		add(toolbar, BorderLayout.NORTH);

		JButton newUserData = new JButton("New");
		toolbar.add(newUserData);

		var deleteUserData = new JButton("Delete");
		toolbar.add(deleteUserData);

		newUserData.addActionListener((actionEcent) -> {
			String uid = UUID.randomUUID().toString();
			userData.put(uid, new UserData());

			JToggleButton button = new JToggleButton("New User Data");
			button.setActionCommand(uid);
			button.addActionListener(toggleButtonListener);
			buttonsPanel.add(button);

			// Forsirano refresh jer je dodan novi gumb
			if (userData.size() == 1) {
				splitPane.getParent().revalidate();
				splitPane.setVisible(true);
			} else {
				buttonsPanel.revalidate();
			}
			button.doClick();
		});

		deleteUserData.addActionListener((actionEvent) -> {
			JToggleButton selectedTooglebutton = null;
			for (Component c : buttonsPanel.getComponents()) {
				if (c instanceof JToggleButton) { // Moze bit da nije sve Toogle Button zbog unutranje implementacije
					JToggleButton button = (JToggleButton) c;
					if (button.isSelected()) {
						selectedTooglebutton = button;
						break;
					}

				}
			}
			if (selectedTooglebutton != null) {
				buttonsPanel.remove(selectedTooglebutton);
				buttonsPanel.revalidate();
				userData.remove(selectedTooglebutton.getActionCommand());
				selectFirst();
			}

		});

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			SplitPaneWindow frame = new SplitPaneWindow();
			frame.setBounds(100, 100, 500, 400);
			frame.setVisible(true);
		});

	}

}
