import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BankAccount extends JFrame	{
	
	public BankAccount(){createComponents();}
	
	public static JButton withdraw;
	public static JButton deposit;
	public static JLabel bal;
	public static JTextArea area;
	public static double  balance = 1000;

	
	public void createComponents() {
		JFrame frame = new JFrame();
		
		withdraw = new JButton("Withdraw");
		ActionListener listener = new WithdrawListener();
		withdraw.addActionListener(listener);
		
		deposit = new JButton("Deposit");
		ActionListener list = new DepositListener();
		deposit.addActionListener(list);
		
		bal = new JLabel("Current Balance: " + balance + "    ");
		area = new JTextArea(1,30);
		
		JPanel panel = new JPanel();
		panel.add(withdraw);
		panel.add(deposit);
		panel.add(area);
		panel.add(bal);
		frame.add(panel);
		
		final int FRAME_WIDTH = 400;
		final int FRAME_HEIGHT = 200;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Banking Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	class WithdrawListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			balance -= Double.parseDouble(area.getText());
			bal.setText("Current Balance: " + balance);
		}
	}
	class DepositListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			balance += Double.parseDouble(area.getText());
			bal.setText("Current Balance: " + balance);
			
		}
	}
	public static void main(String args[]){
		new BankAccount();
	}
}