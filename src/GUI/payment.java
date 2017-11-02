package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JRadioButton rdbtnCash = new JRadioButton("Cash");
	JRadioButton rdbtnCard = new JRadioButton("Card");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public payment() {
		setMaximumSize(new Dimension(700, 500));
		setMinimumSize(new Dimension(700, 500));
		setPreferredSize(new Dimension(700, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(700, 500));
		contentPane.setMinimumSize(new Dimension(700, 500));
		contentPane.setMaximumSize(new Dimension(700, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new KeyPad(new JTextField());
		panel.setMaximumSize(new Dimension(360, 420));
		panel.setMinimumSize(new Dimension(360, 420));
		panel.setPreferredSize(new Dimension(360, 420));
		panel.setBounds(328, 73, 360, 387);
		contentPane.add(panel);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Dialog", Font.BOLD, 34));
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setBounds(213, 12, 254, 49);
		contentPane.add(lblPayment);
		
		JLabel lblTotal = new JLabel("Total : ");
		lblTotal.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTotal.setBounds(32, 87, 93, 30);
		contentPane.add(lblTotal);
		
		JLabel label = new JLabel("0");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(168, 91, 114, 22);
		contentPane.add(label);
		
		JLabel lblInput = new JLabel("Input : ");
		lblInput.setFont(new Font("Dialog", Font.BOLD, 18));
		lblInput.setBounds(32, 146, 93, 30);
		contentPane.add(lblInput);
		
		textField = new JTextField();
		textField.setBounds(182, 148, 114, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblExchange = new JLabel("Exchange : ");
		lblExchange.setFont(new Font("Dialog", Font.BOLD, 18));
		lblExchange.setBounds(32, 220, 114, 30);
		contentPane.add(lblExchange);
		
		JLabel label_1 = new JLabel("0");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(168, 224, 114, 22);
		contentPane.add(label_1);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(32, 376, 130, 64);
		contentPane.add(btnAccept);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(180, 376, 130, 64);
		contentPane.add(btnCancel);
		
		ButtonGroup g = new ButtonGroup();
		
		g.add(rdbtnCash);
		g.add(rdbtnCard);
		rdbtnCash.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		
		
		rdbtnCash.setBounds(32, 305, 121, 23);
		contentPane.add(rdbtnCash);
		rdbtnCard.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		
		rdbtnCard.setBounds(175, 305, 121, 23);
		contentPane.add(rdbtnCard);
		
		
	}
}
