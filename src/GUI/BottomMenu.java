package GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BottomMenu extends JPanel {
	Main MF;
	JButton btnCounter = new JButton("Counter");
	JButton btnReceipt = new JButton("Receipt");
	JButton btnDailyReport = new JButton("DailyReport");
	JButton btnQuit = new JButton("Quit");
	private String type="";
	/**
	 * Create the panel.
	 */
	public BottomMenu(Main mf) {
		setPreferredSize(new Dimension(1280, 100));
		setMinimumSize(new Dimension(1280, 100));
		setMaximumSize(new Dimension(1280, 100));
		this.MF=mf;
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnCounter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowCounter();
			}
		});
		
		btnCounter.setPreferredSize(new Dimension(310, 90));
		add(btnCounter);
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowReceipt();
			}
		});
		
		btnReceipt.setPreferredSize(new Dimension(310, 90));
		add(btnReceipt);
		btnDailyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowDailyReport();
			}
		});
		
		btnDailyReport.setPreferredSize(new Dimension(310, 90));
		add(btnDailyReport);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		
		btnQuit.setPreferredSize(new Dimension(310, 90));
		add(btnQuit);

	}
	
	public void ShowCounter(){
		this.MF.ShowCounter();
	}
	
	public void ShowReceipt(){
		this.MF.ShowReceipt();
	}
	
	public void ShowDailyReport(){
		this.MF.ShowDailyReport();
	}

}
