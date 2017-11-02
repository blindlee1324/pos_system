package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.text.SimpleDateFormat;
import java.util.*;

public class ReceiptJoin extends JPanel{
	JPanel Information = new JPanel();
	JLabel Baseday_label = new JLabel("���� ������ : ");
	JLabel SumSale_label = new JLabel("�� ���� �ݾ� : ");
	JLabel Baseday = new JLabel("");
	JLabel SumSale = new JLabel("");
	private JButton onlyCash = new JButton("���ݸ� ����");
	private JButton onlyCard = new JButton("ī�常 ����");
	
	int Sum_Gold=0;
	
	int [] Typecash = new int[2];//0�� ���� , 1�� ī��
	
	private String colName[]={"�����Ͻ�","��������ȣ","����(1:����, 2:ī��)","�ݾ�"};
	private DefaultTableModel model =  new DefaultTableModel(colName,0);
	private JTable table = new JTable(model);
	
	JScrollPane p = new JScrollPane(table);
	Main MF;
	SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��");
	Date d = new Date();
	String date = format.format(d);
	int CurrentState=0; // 0�̸� ��ü, 1�̸� ����, 2�̸� ī��
	int receipt_no=0;
	int Cash_num=0;
	int Card_num=0;
	String Menu[][]= new String[4][1000];
	public ReceiptJoin(Main mf){
		this.MF = mf;
		
		 // ���� ������ �� �ε���
		
		Typecash[0]=0;
		Typecash[1]=0;
		
		
		
		try {
			ResultSet rs = this.MF.db.getStmt().executeQuery("select * from receipt");
			while(rs.next()){
				Menu[0][receipt_no]=rs.getString("date");
				Menu[1][receipt_no]=rs.getInt("type")+"";
				Menu[2][receipt_no]=rs.getInt("account")+"";
				Menu[3][receipt_no]=receipt_no+1+"";
				Sum_Gold+=Integer.parseInt(Menu[2][receipt_no]);
				if(Menu[1][receipt_no].equals("1")){
					Typecash[0]+=Integer.parseInt(Menu[2][receipt_no]);
					Cash_num++;
				}
				else{
					Typecash[1]+=Integer.parseInt(Menu[2][receipt_no]);
					Card_num++;
				}
				receipt_no++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setMaximumSize(new Dimension(1280, 520));
		setMinimumSize(new Dimension(1280, 520));
		setPreferredSize(new Dimension(1280, 520));
		setLayout(null);
		
		Information.setBounds(30,10,200,80);
		Information.setLayout(new GridLayout(2,2,5,5));
		Information.setBackground(Color.lightGray);
		Information.add(Baseday_label);
		Information.add(Baseday);
		Information.add(SumSale_label);
		Information.add(SumSale);
		add(Information);
		
		SumSale.setText(Sum_Gold+"");
		Baseday.setText(date);
		for(int i=0;i<receipt_no;i++){
			String[] A = new String[4];
			model.addRow(A);
			table.setValueAt(Menu[0][i], i, 0); // �����Ͻ�
			table.setValueAt(i+1+"", i, 1); // ��������ȣ
			table.setValueAt(Menu[1][i], i, 2); // ����
			table.setValueAt(Menu[2][i], i, 3); // �ݾ�
		}
		
		System.out.println("����  : " + Typecash[0] + " ī��  : "+Typecash[1]);
		
		onlyCash.setBounds(950,10,130,80);
		onlyCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onlyCash();
			}
		});
		add(onlyCash);
		
		onlyCard.setBounds(1100,10,130,80);
		onlyCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onlyCard();
			}
		});
		add(onlyCard);
		
		
		p.setBounds(30,100,1200,350);
		add(p);
		
	}
	
	public void onlyCash(){
		if(CurrentState==0){
			for(int i=0;i<receipt_no;i++){
				model.removeRow(0);
			}
			
			for(int i=0;i<receipt_no;i++){
				String[] A = new String[4];
				A[0] = Menu[0][i];
				A[1] = Menu[3][i]+"";
				A[2] = Menu[1][i];
				A[3] = Menu[2][i];
				
				if(Menu[1][i].equals("1"))	{
					model.addRow(A);
				}
			}
			
		}
		else if(CurrentState==1){
		}
		else if(CurrentState==2){
			for(int i=0;i<Card_num;i++){
				model.removeRow(0);
			}
			
			for(int i=0;i<receipt_no;i++){
				String[] A = new String[4];
				A[0] = Menu[0][i];
				A[1] = Menu[3][i]+"";
				A[2] = Menu[1][i];
				A[3] = Menu[2][i];
				
				if(Menu[1][i].equals("1"))	{
					model.addRow(A);
				}
			}
		}
		CurrentState=1;
	}
	
	public void onlyCard(){
		if(CurrentState==0){
			for(int i=0;i<receipt_no;i++){
				model.removeRow(0);
			}
			for(int i=0;i<receipt_no;i++){
				String[] A = new String[4];
				A[0] = Menu[0][i];
				A[1] = Menu[3][i]+"";
				A[2] = Menu[1][i];
				A[3] = Menu[2][i];
				if(Menu[1][i].equals("2"))	{
					model.addRow(A);
				}
			}
		}
		else if(CurrentState==1){
			for(int i=0;i<Cash_num;i++){
				model.removeRow(0);
			}
			for(int i=0;i<receipt_no;i++){
				String[] A = new String[4];
				A[0] = Menu[0][i];
				A[1] = Menu[3][i]+"";
				A[2] = Menu[1][i];
				A[3] = Menu[2][i];
				if(Menu[1][i].equals("2"))	{
					model.addRow(A);
				}
			}
		}
		else if(CurrentState==2){

		}
		CurrentState=2;
	}
}
