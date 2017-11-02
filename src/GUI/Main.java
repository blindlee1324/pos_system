package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Process.Database;

import java.awt.Font;

public class Main extends JFrame {
	
	private JPanel Center = new JPanel();
	private JPanel Bottom = new JPanel();
	private JPanel Top = new JPanel();
	JLabel TEST = new JLabel("Restaurant Management");
	public Database db=new Database();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		super("Restaurant Management");
		db.connectionDB();
		setMaximumSize(new Dimension(1280, 720));
		setMinimumSize(new Dimension(1280, 720));
		setPreferredSize(new Dimension(1280, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1280, 720));
		contentPane.setMaximumSize(new Dimension(1280, 720));
		contentPane.setPreferredSize(new Dimension(1280, 720));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(Center, BorderLayout.CENTER);
		Center.add(new Login_GUI(this));
		
		
		Bottom.setMinimumSize(new Dimension(1280, 100));
		Bottom.setPreferredSize(new Dimension(1280, 100));
		contentPane.add(Bottom, BorderLayout.SOUTH);
		Bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Top.setPreferredSize(new Dimension(1280, 100));
		contentPane.add(Top, BorderLayout.NORTH);
		Top.setLayout(new BorderLayout(0, 0));
		TEST.setFont(new Font("Dialog", Font.BOLD, 40));
		
		TEST.setHorizontalAlignment(SwingConstants.CENTER);
		Top.add(TEST, BorderLayout.CENTER);
		
		
		
	}
	
	public void ShowCounter(){
		Center.removeAll();
		contentPane.add(Center, BorderLayout.CENTER);
		Center.add(new joomoon(this));
		Bottom.add(new BottomMenu(this));
		Top.removeAll();
		Top.add(new TopMenu(this,"Counter"));
		setVisible(false);
		setVisible(true);
	}
	
	public void ShowReceipt(){
		Center.removeAll();
		contentPane.add(Center, BorderLayout.CENTER);
		Center.add(new ReceiptJoin(this));
		Top.removeAll();
		Top.add(new TopMenu(this,"Receipt"));
		setVisible(false);
		setVisible(true);
	}
	
	public void ShowDailyReport(){
		Top.removeAll();
		Top.add(new TopMenu(this,"DailyReport"));
		
		Center.removeAll();
		contentPane.add(Center, BorderLayout.CENTER);
		Center.add(new DailyReport());
		
		setVisible(false);
		setVisible(true);
	}
	
	public void ShowLogin(){
		Top.removeAll();
		TEST.setHorizontalAlignment(SwingConstants.CENTER);
		Top.add(TEST, BorderLayout.CENTER);
		
		Center.removeAll();
		contentPane.add(Center, BorderLayout.CENTER);
		Center.add(new Login_GUI(this));
		
		Bottom.removeAll();
		setVisible(false);
		setVisible(true);
		
	}
}
