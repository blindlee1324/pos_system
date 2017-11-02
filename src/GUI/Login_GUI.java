package GUI;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Process.Database;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login_GUI extends JPanel {
	private JTextField txtID;
	private JPasswordField txtPW;
	private Main MF;

	/**
	 * Create the panel.
	 */
	public Login_GUI(Main mf) {
		this.MF=mf;
		setMaximumSize(new Dimension(1280, 520));
		setMinimumSize(new Dimension(1280, 520));
		setPreferredSize(new Dimension(1280, 520));
		setLayout(null);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10){
					Login_Process();
				}
			}
		});
		txtID.setBounds(607, 177, 114, 18);
		add(txtID);
		txtID.setColumns(10);
		
		txtPW = new JPasswordField();
		txtPW.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10){
					Login_Process();
				}
			}
		});
		txtPW.setBounds(607, 229, 114, 18);
		add(txtPW);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(509, 179, 56, 14);
		add(lblId);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(509, 231, 56, 14);
		add(lblPw);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login_Process();
			}
		});
		btnOk.setBounds(509, 281, 99, 24);
		add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtID.setText("");
				txtPW.setText("");
			}
		});
	
		btnCancel.setBounds(620, 281, 99, 24);
		add(btnCancel);

	}
	
	public void Login_Process(){
		this.MF.ShowCounter();
	}
}
