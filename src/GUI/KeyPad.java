package GUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPad extends JPanel {
	
	JTextField txt;
	/**
	 * Create the panel.
	 */
	public KeyPad(JTextField TXT) {
		this.txt=TXT;
		setMinimumSize(new Dimension(360, 420));
		setMaximumSize(new Dimension(360, 420));
		setPreferredSize(new Dimension(360, 420));
		setLayout(null);
		
		JButton btnNewButton_1 = new JButton("7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_1.setBounds(10, 5, 110, 70);
		btnNewButton_1.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("8");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_3.setBounds(125, 5, 110, 70);
		btnNewButton_3.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_2.setBounds(240, 5, 110, 70);
		btnNewButton_2.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("4");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_6.setBounds(10, 80, 110, 70);
		btnNewButton_6.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_5.setBounds(125, 80, 110, 70);
		btnNewButton_5.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("6");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_4.setBounds(240, 80, 110, 70);
		btnNewButton_4.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("1");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_8.setBounds(10, 155, 110, 70);
		btnNewButton_8.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("2");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_9.setBounds(125, 155, 110, 70);
		btnNewButton_9.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_9);
		
		JButton btnNewButton_7 = new JButton("3");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_7.setBounds(240, 155, 110, 70);
		btnNewButton_7.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_7);
		
		JButton btnNewButton_11 = new JButton("0");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_11.setBounds(10, 230, 110, 70);
		btnNewButton_11.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("00");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton_12.setBounds(125, 230, 110, 70);
		btnNewButton_12.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton_12);
		
		JButton btnNewButton = new JButton("DEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnNewButton.setBounds(10, 305, 110, 70);
		btnNewButton.setPreferredSize(new Dimension(110, 70));
		add(btnNewButton);
		
		JButton btnClr = new JButton("CLR");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadInput(e);
			}
		});
		btnClr.setBounds(125, 305, 110, 70);
		btnClr.setPreferredSize(new Dimension(110, 70));
		add(btnClr);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KeyPadEnter();
			}
		});
		btnEnter.setPreferredSize(new Dimension(110, 140));
		btnEnter.setBounds(240, 230, 110, 145);
		add(btnEnter);
		
		
		setVisible(true);

	}
	
	public void KeyPadInput(ActionEvent e){
		JButton B = (JButton)e.getSource();
		this.txt.requestFocus();
		if(B.getText().equals("00")){
			if(!this.txt.getText().equals("")){
				this.txt.setText(this.txt.getText()+"00");
			}
		}
		else if(B.getText().equals("0")){
			if(!this.txt.getText().equals("")){
				this.txt.setText(this.txt.getText()+"0");
			}
			
		}
		else if(B.getText().equals("DEL")){
			if(this.txt.getText().length() == 0){
				this.txt.setText("");
			}else{
				this.txt.setText(this.txt.getText().substring(0, this.txt.getText().length()-1));
			}
		}
		else if(B.getText().equals("CLR")){
			this.txt.setText("");
		}
		else{
			if(this.txt.getText().equals("0")){
				this.txt.setText("");
			}
			this.txt.setText(this.txt.getText()+B.getText());
		}
	}
	
	public void KeyPadEnter(){
		this.txt.nextFocus();
	}
}
