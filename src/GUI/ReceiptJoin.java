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
	JLabel Baseday_label = new JLabel("현재 기준일 : ");
	JLabel SumSale_label = new JLabel("총 결제 금액 : ");
	JLabel Baseday = new JLabel("");
	JLabel SumSale = new JLabel("");
	private JButton onlyCash = new JButton("현금만 보기");
	private JButton onlyCard = new JButton("카드만 보기");
	
	int Sum_Gold=0;
	
	int [] Typecash = new int[2];//0은 현금 , 1은 카드
	
	private String colName[]={"승인일시","영수증번호","유형(1:현금, 2:카드)","금액"};
	private DefaultTableModel model =  new DefaultTableModel(colName,0);
	private JTable table = new JTable(model);
	
	JScrollPane p = new JScrollPane(table);
	Main MF;
	SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일");
	Date d = new Date();
	String date = format.format(d);
	int CurrentState=0; // 0이면 전체, 1이면 현금, 2이면 카드
	int receipt_no=0;
	int Cash_num=0;
	int Card_num=0;
	String Menu[][]= new String[4][1000];
	public ReceiptJoin(Main mf){
		this.MF = mf;
		
		 // 현재 영수증 총 인덱스
		
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
			table.setValueAt(Menu[0][i], i, 0); // 승인일시
			table.setValueAt(i+1+"", i, 1); // 영수증번호
			table.setValueAt(Menu[1][i], i, 2); // 유형
			table.setValueAt(Menu[2][i], i, 3); // 금액
		}
		
		System.out.println("현금  : " + Typecash[0] + " 카드  : "+Typecash[1]);
		
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
