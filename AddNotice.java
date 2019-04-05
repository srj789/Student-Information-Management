package projectRAT;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNotice extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public AddNotice() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 433);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel lblDate = new JLabel("Date");
		
		JLabel lblCourse = new JLabel("Course");
		
		JLabel lblBranch = new JLabel("Branch");
		
		JLabel lblNotice = new JLabel("Notice");
	
		java.util.Date d=new java.util.Date();
		textField = new JTextField(String.valueOf(d));
		textField.setEditable(false);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox(GetValues.getcourse());
		
		JComboBox comboBox_1 = new JComboBox(GetValues.getBranch());
		
		TextArea textArea = new TextArea();
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String date=textField.getText();
				String course=(String) comboBox.getSelectedItem();
				String stream=(String) comboBox_1.getSelectedItem();
				String notice=textArea.getText();
				String id=Admin.id;
				String query="insert into notice values(?,?,?,?,?,?)";
				Connection con=(Connection) DBInfo.con;
				int flag=0;
				try
				{
					PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
					ps.setInt(1, 0);
					ps.setString(2, date);
					ps.setString(3, course);
					ps.setString(4, stream);
					ps.setString(5, notice);
					ps.setString(6, id);
					flag=ps.executeUpdate();
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				if(flag==1)
				{
					JOptionPane.showMessageDialog(AddNotice.this, "Notice Added!!","Added",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(AddNotice.this, "Notice Not Added!!","Not Added",JOptionPane.ERROR_MESSAGE);
				}
				}
		});
		
		JButton btnReset = new JButton("RESET");
		
		JButton btnNewButton = new JButton("View All Notices");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDate)
								.addComponent(lblCourse)
								.addComponent(lblBranch)
								.addComponent(lblNotice))
							.addGap(97)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textArea, 0, 0, Short.MAX_VALUE)
								.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSubmit)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(494))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(194)
					.addComponent(lblNewLabel)
					.addContainerGap(635, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDate)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCourse)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNotice)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnReset)
						.addComponent(btnNewButton))
					.addGap(50))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
