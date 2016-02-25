import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUI implements ActionListener {

	Eliminate eliminate = new Eliminate();
	GrayCode gray =new GrayCode();
	
	public JFrame frame;
	public JTextField textField;
	public JTextField result;
	public JButton btnMnmze;
	public JButton exit;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public GUI() {
		initialize();
	}

	
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 505, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblQuery = new JLabel("Query:");
		lblQuery.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuery.setBackground(Color.GRAY);
		lblQuery.setBounds(10, 56, 64, 38);
		frame.getContentPane().add(lblQuery);
		
		textField = new JTextField();
		textField.setBounds(69, 59, 355, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnMnmze = new JButton("MINIMIZE");
		btnMnmze.setBackground(new Color(0, 191, 255));
		btnMnmze.setBounds(145, 147, 200, 50);
		btnMnmze.addActionListener(this);
		frame.getContentPane().add(btnMnmze);
		
		
	    result = new JTextField();
		result.setBounds(98, 208, 296, 40);
		frame.getContentPane().add(result);
		result.setColumns(10);
		result.setVisible(false);
		
		JLabel lblKmapMnmzer = new JLabel("K-MAP MINIMIZER");
		lblKmapMnmzer.setForeground(Color.WHITE);
		lblKmapMnmzer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblKmapMnmzer.setBounds(145, 10, 194, 38);
		frame.getContentPane().add(lblKmapMnmzer);
		
		JLabel lblLikeJavatoollinuxvisual = new JLabel("  like → java'.tool+linux.visual'+tool'.java.linux'  (max 4 variables)");
		lblLikeJavatoollinuxvisual.setForeground(Color.WHITE);
		lblLikeJavatoollinuxvisual.setBounds(69, 97, 387, 28);
		frame.getContentPane().add(lblLikeJavatoollinuxvisual);
		
		JButton exit = new JButton("EXIT");
		exit.setBackground(new Color(0, 191, 255));
		exit.setBounds(203, 260, 89, 23);
		frame.getContentPane().add(exit);
		exit.setVisible(false);
	}
	
public void actionPerformed(ActionEvent event) {
		
	
	    
		eliminate.SearchingEliminate(textField.getText());  
		eliminate.cal_truth_table();
		gray.BasicKarno(eliminate.return_variableCount()); 
		gray.BasicKarnoScanner(eliminate.return_variableCount(), eliminate.return_temps2());
		result.setText(gray.basic_end);	
		result.setVisible(true);
		
	
}




}



