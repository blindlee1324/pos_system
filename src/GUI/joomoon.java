package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import com.mysql.jdbc.Statement;


public class joomoon extends JPanel implements ActionListener{
	JButton SUB ;
	JPanel menubar = new JPanel();
	JPanel menubar_label = new JPanel();
	JLabel Menu_label = new JLabel("메   뉴");
	JLabel Sum_label = new JLabel("총   액   :");
	JLabel Sum_value = new JLabel("");
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton delete = new JButton("삭   제");
	JButton change = new JButton("수량변경");
	JButton Sign =  new JButton("결제");
	JButton btnSign =  new JButton("결제");
	String Ture_Sum;
	int Exchange=0;
	
	private String colName[]={"상품명","수량","금액"};
	private DefaultTableModel model =  new DefaultTableModel(colName,0);
	private JTable table = new JTable(model);
	JScrollPane p = new JScrollPane(table);
	String[][] Menu= new String[2][20]; // [0][x]는 이름, [1][x]는 가격
	JButton[] Menubutton = new JButton[20];
	String[][] Current_table = new String[20][5];
	int Per_Menu[][] = new int[2][20];
	int table_idx=0;
	int Current_idx=0;
	int receipt_no=1;
	Main MF;
	public joomoon(Main mf){
		this.MF=mf;
		for(int z=0;z<20;z++){
			Per_Menu[0][z]=-1;
			Per_Menu[1][z]=-1;
		}
		setMaximumSize(new Dimension(1280, 520));
		setMinimumSize(new Dimension(1280, 520));
		setPreferredSize(new Dimension(1280, 520));
		setLayout(null);
		
		menubar_label.setBackground(Color.LIGHT_GRAY);
		menubar_label.setBounds(750,30,450,70);
		menubar_label.add(Menu_label);
		
		menubar.setLayout(new GridLayout(4,5,1,1));
		menubar.setBounds(750,100,450,300);
		
		for(int i=0;i<10;i++){
			Menu[0][i] = new String("");
			Menu[1][i] = new String();
			
			try {
				String query="select * from menu where menuid='A"+i+"'";
				ResultSet rs=MF.db.getStmt().executeQuery(query);
				while(rs.next())
				{
					Menu[0][i]=rs.getString("menuname");
					Menu[1][i]=rs.getInt("menuPrice")+"";
				}
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			String Name = new String("<html>"+Menu[0][i]+"<br><br>"+Menu[1][i]+"</html>");
			Menubutton[i] = new JButton();
			Menubutton[i].setText(Name);
			
			menubar.add(Menubutton[i]);
			Menubutton[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JButton b = (JButton)e.getSource();
					int z= (b.getX()/90) +5*(b.getY()/75); // 현재 버튼의 인덱스값
					setMenu(z);
				}
			}
			);
		}
		
		for(int i=10;i<20;i++){
			Menubutton[i] = new JButton();
			Menubutton[i].setText("");
			menubar.add(Menubutton[i]);
		}
		add(menubar_label);
		add(menubar);
		table.setGridColor(Color.black);
		p.setBounds(100,30,450,300);
		add(p);
		
		Sum_label.setBounds(100,340,100,40);
		Sum_value.setBounds(210,340,100,40);
		
		add(Sum_label);
		add(Sum_value);
		
		plus.setBounds(500,340,50,35);
		plus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int x;
				int z = table.getSelectedRow(); // 현재 선택한 인덱스
				for(x=0;x<20;x++){
					if(z==Per_Menu[1][x]){
						break;
					}
				}
				Per_Menu[0][x]++;
				table.setValueAt(Per_Menu[0][x],Per_Menu[1][x], 1);
				
				set_Sum();
			}
		}
		);
		minus.setBounds(500,380,50,35);
		minus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int x;
				int z = table.getSelectedRow(); // 현재 선택한 인덱스
				for(x=0;x<20;x++){
					if(z==Per_Menu[1][x]){
						break;
					}
				}
				Per_Menu[0][x]--;
				if(Per_Menu[0][x]<0){
					Per_Menu[0][x]=0;
				}
				else{
					table.setValueAt(Per_Menu[0][x],Per_Menu[1][x], 1);
				}
				set_Sum();
			}
		}
		);
		add(plus);
		add(minus);
		btnSign.addActionListener(this);
		btnSign.setBounds(1100,412,100,60);
		add(btnSign);
	}
	
	void setMenu(int z /*현재버튼인덱스*/){ 
		if(Per_Menu[0][z]==-1){
			String[] A = new String[3];
			model.addRow(A);
			table.setValueAt(Menu[0][z], table_idx, 0);
			table.setValueAt(1,table_idx, 1);
			table.setValueAt(Menu[1][z],table_idx, 2);
			Per_Menu[0][z]=1;
			Per_Menu[1][z]=table_idx;
			table_idx++;
		}
		else{
			Per_Menu[0][z]++;
			table.setValueAt(Menu[0][z], Per_Menu[1][z], 0);
			table.setValueAt(Per_Menu[0][z],Per_Menu[1][z], 1);
			table.setValueAt(Menu[1][z],Per_Menu[1][z], 2);
		}
		set_Sum();
	}
	
	void set_Sum(){
		int Sum=0;
		int CC=0;
		
		for(int y=0;y<table_idx;y++){
			int per = (int)table.getValueAt(y, 1);
			int price = Integer.parseInt((String) table.getValueAt(y, 2));
			Sum+=per*price;
		}
		
		Sum_value.setText(Sum+"");
		Ture_Sum = Sum+"";
	}
	
	class Payment extends JFrame implements ActionListener{
		JPanel contentPane = new JPanel();
		JRadioButton rdbtnCash = new JRadioButton("Cash");
		JRadioButton rdbtnCard = new JRadioButton("Card");
		JTextField textField = new JTextField();
		JLabel label_1 = new JLabel("0");
		JLabel lblTotal;
		JButton btnAccept;
		int Sum,input;
		int CC=1;

		Main MF;
		
		public Payment(String Sum_value,Main mf){
			
			super("Payment");
			this.MF=mf;
			Sum = Integer.parseInt(Sum_value);
			
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
			
			JLabel lblPayment = new JLabel("Payment");
			lblPayment.setFont(new Font("Dialog", Font.BOLD, 34));
			lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
			lblPayment.setBounds(213, 12, 254, 49);
			contentPane.add(lblPayment);
			
			lblTotal = new JLabel("Total : ");
			lblTotal.setFont(new Font("Dialog", Font.BOLD, 18));
			lblTotal.setBounds(32, 87, 93, 30);
			contentPane.add(lblTotal);
			
			JLabel label = new JLabel(Sum_value);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("Dialog", Font.BOLD, 18));
			label.setBounds(168, 91, 114, 22);
			contentPane.add(label);
			
			JLabel lblInput = new JLabel("Input : ");
			lblInput.setFont(new Font("Dialog", Font.BOLD, 18));
			lblInput.setBounds(32, 146, 93, 30);
			contentPane.add(lblInput);
			
			textField.setBounds(182, 148, 114, 30);
			contentPane.add(textField);
			textField.setColumns(10);
			textField.setHorizontalAlignment(SwingConstants.RIGHT);
			textField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					getExchange();
				}
			});
			
			JLabel lblExchange = new JLabel("Exchange : ");
			lblExchange.setFont(new Font("Dialog", Font.BOLD, 18));
			lblExchange.setBounds(32, 220, 114, 30);
			contentPane.add(lblExchange);
			
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setFont(new Font("Dialog", Font.BOLD, 18));
			label_1.setBounds(168, 224, 114, 22);
			contentPane.add(label_1);
			
			btnAccept = new JButton("Accept");
			btnAccept.setBounds(32, 376, 130, 64);
			contentPane.add(btnAccept);
			btnAccept.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					store_receipt();
				}
			});
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setBounds(180, 376, 130, 64);
			contentPane.add(btnCancel);
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			
			ButtonGroup g = new ButtonGroup();
			
			g.add(rdbtnCash);
			g.add(rdbtnCard);
			rdbtnCash.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					CC = CashOrCard(e);
				}
			});
			
			
			rdbtnCash.setBounds(32, 305, 121, 23);
			contentPane.add(rdbtnCash);
			rdbtnCard.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					CC = CashOrCard(e);
				}
			});
			
			
			rdbtnCard.setBounds(175, 305, 121, 23);
			contentPane.add(rdbtnCard);
			
			JPanel panel = new KeyPad(textField);
			panel.setMaximumSize(new Dimension(360, 420));
			panel.setMinimumSize(new Dimension(360, 420));
			panel.setPreferredSize(new Dimension(360, 420));
			panel.setBounds(328, 73, 360, 387);
			contentPane.add(panel);
			
			
			setVisible(true);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
		}
		
		public void getExchange(){
			int Input=0;
			if(textField.getText().equals("")){
				Input=0;
			}
			else{
				Input=Integer.parseInt(textField.getText());
			}
			Exchange = Input - Sum;
			label_1.setText(Exchange+"");
		}
		
		public int CashOrCard(ItemEvent e){
			int CC=1;
			JRadioButton RB = (JRadioButton)e.getSource();
			
			if(RB.getText().equals("Cash")){
				CC=1;
			}
			else
				CC=2;
			
			return CC; 
		}
		public void store_receipt(){
			int receipt_no=1;
			try {
				ResultSet rs = this.MF.db.getStmt().executeQuery("select * from receipt");
				while(rs.next()){
					receipt_no++;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			String sql = "insert into receipt values(now(),"+receipt_no+","+CC+","+Sum+")";
			System.out.println(receipt_no);
			try {
				this.MF.db.getStmt().executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setVisible(false);
			this.MF.ShowCounter();
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Payment PM=new Payment(Ture_Sum,this.MF);
		
	}
}
