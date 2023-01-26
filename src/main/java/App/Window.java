package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextField txURL;
	private JButton btAdd;
	private List<String> URLS = new ArrayList<String>();
	private JScrollPane scURLS;
	private JTextPane txAllURLS;
	private JButton btAnalyze;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTxURL());
		contentPane.add(getBtAdd());
		contentPane.add(getScURLS());
		contentPane.add(getBtAnalyze());
	}
	public List<String> getURLS() {
		return URLS;
	}
	private JTextField getTxURL() {
		if (txURL == null) {
			txURL = new JTextField();
			txURL.setBounds(20, 37, 406, 28);
			txURL.setColumns(10);
		}
		return txURL;
	}
	private JButton getBtAdd() {
		if (btAdd == null) {
			btAdd = new JButton("Add");
			btAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					URLS.add(getTxURL().getText());
					update();
					getTxURL().setText("");
				}
			});
			btAdd.setBounds(538, 40, 85, 21);
		}
		return btAdd;
	}
	
	private void update() {
		String text="";
		for (int i = 0; i < URLS.size(); i++) {
			
			if(i!=0) {
				text+="\n"+URLS.get(i);
			}
			else
				text=URLS.get(i);
		}
		getTxAllURLS().setText(text);
	}
	private JScrollPane getScURLS() {
		if (scURLS == null) {
			scURLS = new JScrollPane();
			scURLS.setBounds(20, 93, 349, 190);
			scURLS.setViewportView(getTxAllURLS());
		}
		return scURLS;
	}
	private JTextPane getTxAllURLS() {
		if (txAllURLS == null) {
			txAllURLS = new JTextPane();
			txAllURLS.setEditable(false);
		}
		return txAllURLS;
	}
	private JButton getBtAnalyze() {
		if (btAnalyze == null) {
			btAnalyze = new JButton("Analyze");
			btAnalyze.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FileCreator.createFile(URLS);
					GitHubAPI.update();
				}
			});
			btAnalyze.setBounds(572, 235, 85, 21);
		}
		return btAnalyze;
	}
}
