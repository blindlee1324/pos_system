package GUI;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TopMenu extends JPanel {
	JLabel lblType = new JLabel("");
	JLabel lblManager = new JLabel("");
	private Main MF;

	/**
	 * Create the panel.
	 */
	public TopMenu(Main mf,String type) {
		this.MF=mf;
		setPreferredSize(new Dimension(1280, 100));
		setLayout(null);
		
		
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Dialog", Font.BOLD, 26));
		lblType.setPreferredSize(new Dimension(420, 90));
		lblType.setBounds(472, 12, 329, 76);
		add(lblType);
		lblType.setText(type);
		
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogOut();
			}
		});
		btnLogOut.setBounds(1158, 53, 99, 24);
		add(btnLogOut);
		
		lblManager.setBounds(980, 58, 99, 19);
		add(lblManager);

	}
	
	public void LogOut(){
		this.MF.ShowLogin();
	}

}
