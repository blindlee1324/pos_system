package GUI;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class DailyReport extends JPanel implements ActionListener {
	JLabel[] cash = new JLabel[8];
	JTextField[] cashCountField = new JTextField[8];
	JLabel[] cashSum = new JLabel[8];
	JPanel Turnover = new JPanel();
	private JTextField turnovervalue;
	JLabel lblSales1 = new JLabel("Cash");
	JLabel lblSalesOnCash = new JLabel("0");
	JLabel lblmoreorlessvalue= new JLabel("0");
	KeyPad keyPad=new KeyPad(cashCountField[0]);
	private Integer[] Sum = {new Integer(0),new Integer(0),new Integer(0),new Integer(0),new Integer(0),new Integer(0),new Integer(0),new Integer(0)};
	
	/**
	 * Create the panel.
	 */
	public DailyReport() {
		setMaximumSize(new Dimension(1280, 520));
		setMinimumSize(new Dimension(1280, 520));
		setPreferredSize(new Dimension(1280, 520));
		setLayout(null);
		
		JPanel CashCounter = new JPanel();
		CashCounter.setBounds(480, 55, 353, 290);
		add(CashCounter);
		CashCounter.setLayout(new GridLayout(9, 3, 0, 0));
		
		
		Turnover.setBounds(480, 346, 353, 145);
		add(Turnover);
		Turnover.setLayout(null);
		
		JLabel lblmoreorless = new JLabel("MoreOrLess");
		lblmoreorless.setBounds(0, 0, 136, 72);
		Turnover.add(lblmoreorless);
		
		
		lblmoreorlessvalue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblmoreorlessvalue.setBounds(138, 0, 214, 72);
		Turnover.add(lblmoreorlessvalue);
		
		JLabel lblturnover = new JLabel("TurnOver");
		lblturnover.setBounds(0, 72, 136, 72);
		Turnover.add(lblturnover);
		
		turnovervalue = new JTextField("");
		turnovervalue.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				getFocused(e);
			}
		});
		turnovervalue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				KeyInput(e);
			}
		});
		turnovervalue.setHorizontalAlignment(SwingConstants.RIGHT);
		turnovervalue.setBounds(138, 72, 215, 72);
		Turnover.add(turnovervalue);
		turnovervalue.setColumns(10);
		
		JLabel lblCashcounter = new JLabel("CashCounter");
		lblCashcounter.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCashcounter.setBounds(480, 12, 353, 31);
		add(lblCashcounter);
		
		JLabel lblSafeState = new JLabel("DailySales");
		lblSafeState.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSafeState.setBounds(47, 12, 353, 31);
		add(lblSafeState);
		
		JPanel DailySalesPane = new JPanel();
		DailySalesPane.setBounds(47, 55, 377, 205);
		add(DailySalesPane);
		DailySalesPane.setLayout(new GridLayout(3, 2, 0, 0));
		
		
		lblSales1.setHorizontalAlignment(SwingConstants.CENTER);
		DailySalesPane.add(lblSales1);
		
		
		lblSalesOnCash.setHorizontalAlignment(SwingConstants.RIGHT);
		DailySalesPane.add(lblSalesOnCash);
		
		JLabel lblSales2 = new JLabel("Card");
		lblSales2.setHorizontalAlignment(SwingConstants.CENTER);
		DailySalesPane.add(lblSales2);
		
		JLabel lblSalesOnCard = new JLabel("0");
		lblSalesOnCard.setHorizontalAlignment(SwingConstants.RIGHT);
		DailySalesPane.add(lblSalesOnCard);
		
		JLabel lblSales3 = new JLabel("Total");
		lblSales3.setHorizontalAlignment(SwingConstants.CENTER);
		DailySalesPane.add(lblSales3);
		
		JLabel lblSalesTotal = new JLabel("0");
		lblSalesTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		DailySalesPane.add(lblSalesTotal);
		
		JLabel lblSafestate = new JLabel("SafeState");
		lblSafestate.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSafestate.setBounds(47, 260, 353, 31);
		add(lblSafestate);
		
		JPanel SafeStatePane = new JPanel();
		SafeStatePane.setBounds(47, 296, 377, 195);
		add(SafeStatePane);
		SafeStatePane.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblPrevious = new JLabel("Previous");
		lblPrevious.setHorizontalAlignment(SwingConstants.CENTER);
		SafeStatePane.add(lblPrevious);
		
		JLabel lblSafeOnPrevious = new JLabel("0");
		lblSafeOnPrevious.setHorizontalAlignment(SwingConstants.RIGHT);
		SafeStatePane.add(lblSafeOnPrevious);
		
		JLabel lblCash = new JLabel("Cash");
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		SafeStatePane.add(lblCash);
		
		JLabel lblSafeOnCash = new JLabel("0");
		lblSafeOnCash.setHorizontalAlignment(SwingConstants.RIGHT);
		SafeStatePane.add(lblSafeOnCash);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		SafeStatePane.add(lblTotal);
		
		JLabel lblTotalSafe = new JLabel("0");
		lblTotalSafe.setHorizontalAlignment(SwingConstants.RIGHT);
		SafeStatePane.add(lblTotalSafe);
		
		
		cash[0]=new JLabel("50000");
		cash[1]=new JLabel("10000");
		cash[2]=new JLabel("5000");
		cash[3]=new JLabel("1000");
		cash[4]=new JLabel("500");
		cash[5]=new JLabel("100");
		cash[6]=new JLabel("50");
		cash[7]=new JLabel("10");
		
		for(int i=0;i<8;i++){
			cashCountField[i]=new JTextField("");
			cashCountField[i].setHorizontalAlignment(SwingConstants.RIGHT);
			cashSum[i]=new JLabel("0");
			cashSum[i].setHorizontalAlignment(SwingConstants.RIGHT);
			CashCounter.add(cash[i]);
			CashCounter.add(cashCountField[i]);
			CashCounter.add(cashSum[i]);
			cashCountField[i].addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					cashSum(e);
				}
			});
			cashCountField[i].addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					getFocused(e);
				}
			});
			cashCountField[i].addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					KeyInput(e);
				}
			});
		}
		keyPad=new KeyPad(cashCountField[0]);
		
		keyPad.setBounds(875, 12, 365, 386);
		add(keyPad);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(this);
		btnAccept.setBounds(985, 410, 240, 76);
		add(btnAccept);
	}
	
	public void cashSum(FocusEvent e){
		JTextField T = (JTextField)e.getSource();
		Integer SumofSum = new Integer(0);
		String count = T.getText();
		
		if(count.equals("")){
			count="0";
		}
		
		
		if(T==cashCountField[0]){
			Sum[0] = Integer.parseInt(cash[0].getText())*Integer.parseInt(count);
			cashSum[0].setText(Sum[0].toString());
		}
		else if(T==cashCountField[1]){
			Sum[1] = Integer.parseInt(cash[1].getText())*Integer.parseInt(count);
			cashSum[1].setText(Sum[1].toString());
		}
		else if(T==cashCountField[2]){
			Sum[2] = Integer.parseInt(cash[2].getText())*Integer.parseInt(count);
			cashSum[2].setText(Sum[2].toString());
		}
		else if(T==cashCountField[3]){
			Sum[3] = Integer.parseInt(cash[3].getText())*Integer.parseInt(count);
			cashSum[3].setText(Sum[3].toString());
		}
		else if(T==cashCountField[4]){
			Sum[4] = Integer.parseInt(cash[4].getText())*Integer.parseInt(count);
			cashSum[4].setText(Sum[4].toString());
		}
		else if(T==cashCountField[5]){
			Sum[5] = Integer.parseInt(cash[5].getText())*Integer.parseInt(count);
			cashSum[5].setText(Sum[5].toString());
		}
		else if(T==cashCountField[6]){
			Sum[6] = Integer.parseInt(cash[6].getText())*Integer.parseInt(count);
			cashSum[6].setText(Sum[6].toString());
		}
		else if(T==cashCountField[7]){
			Sum[7] = Integer.parseInt(cash[7].getText())*Integer.parseInt(count);
			cashSum[7].setText(Sum[7].toString());
		}
		else{
			
		}
		
		for(int i=0;i<8;i++){
			if(!Sum[i].equals(0))
				SumofSum += Sum[i];
			lblmoreorlessvalue.setText(SumofSum.toString());
		}
	}
	
	public void getFocused(FocusEvent e){
		JTextField T = (JTextField)e.getSource();
		if(T==cashCountField[0]){
			keyPad.removeAll();
			keyPad=new KeyPad(cashCountField[0]);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
		else if(T==cashCountField[1]){
			keyPad.removeAll();
			keyPad=new KeyPad(cashCountField[1]);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
		else if(T==cashCountField[2]){
			keyPad.removeAll();
			keyPad=new KeyPad(cashCountField[2]);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
		else if(T==cashCountField[3]){
			keyPad.removeAll();
			keyPad=new KeyPad(cashCountField[3]);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
		else if(T==cashCountField[4]){
			keyPad.removeAll();
			keyPad=new KeyPad(cashCountField[4]);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
		else if(T==cashCountField[5]){
			keyPad.removeAll();
			keyPad=new KeyPad(cashCountField[5]);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
		else if(T==cashCountField[6]){
			keyPad.removeAll();
			keyPad=new KeyPad(cashCountField[6]);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
		else if(T==cashCountField[7]){
			keyPad.removeAll();
			keyPad=new KeyPad(cashCountField[7]);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
		else{
			keyPad.removeAll();
			keyPad=new KeyPad(turnovervalue);
			keyPad.setBounds(875, 12, 365, 386);
			add(keyPad);
		}
	}
	
	public void KeyInput(KeyEvent e){
		int KC=e.getKeyCode();
		JTextField T = (JTextField)e.getSource();
		
		if(KC==10){
			T.nextFocus();
		}
		else if (KC==27){
			cashCountField[0].requestFocus();
		}
		else{
			
		}
	}
	 public void actionPerformed(ActionEvent e) {
	       
	 }
}
