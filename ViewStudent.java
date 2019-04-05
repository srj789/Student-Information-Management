package projectRAT;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	int flag=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudent frame = new ViewStudent();
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
	public ViewStudent() 
	{
		setTitle("Student Registration Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 645);
		setLocationRelativeTo(this);
		//setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Register Here");
		
		JLabel lblEnrollmentNumber = new JLabel("Enrollment Number");
		
		
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblRoll = new JLabel("Roll");
		
		JLabel lblDob = new JLabel("D.O.B");
		
		JLabel lblGender = new JLabel("Gender");
		
		JLabel lblMobile = new JLabel("Mobile");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblBranch = new JLabel("Branch");
		
		JLabel lblSemester = new JLabel("Semester");
		
		JLabel lblAdmissionDate = new JLabel("Admission Date");
		
		JLabel lblAddress = new JLabel("Address");
		JTextArea textArea_1 = new JTextArea();
		
		
		textField = new JTextField();
		textField.setColumns(10);
		JComboBox comboBox_4 = new JComboBox(GetValues.getBranch());
		comboBox_4.insertItemAt("select", 0);
		comboBox_4.setSelectedIndex(0);
		
		Integer sem[]={1,2,3,4,5,6,7,8,9,10};
		JComboBox comboBox_5 = new JComboBox(sem);
		
		
		JComboBox comboBox_9 = new JComboBox(GetValues.getcourse());
		comboBox_9.insertItemAt("select", 0);
		comboBox_9.setSelectedIndex(0);
		
		textField_1 = new JTextField();
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{

				String enrollment=textField.getText();
				String query="select * from student_registration where enrollment=?";
				
				try
				{
					PreparedStatement ps=(PreparedStatement) DBInfo.con.prepareStatement(query);
					ps.setString(1, enrollment);
					ResultSet res=ps.executeQuery();
					
					while(res.next())
					{
						textField_1.setText(res.getString(2));
						textField_2.setText(res.getString(3));
						textField_3.setText(res.getString(4));
						textField_4.setText(res.getString(5));
						textField_5.setText(res.getString(6));
						textField_6.setText(res.getString(7));
						comboBox_4.setSelectedItem(res.getString(8));
						comboBox_9.setSelectedItem(res.getString(9));
						comboBox_5.setSelectedItem(res.getString(10));
						textField_7.setText(res.getString(11));
						textArea_1.setText(res.getString(12));
						flag=1;
						break;
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				if(flag==0)
				{
					flag=1;
					JOptionPane.showMessageDialog(ViewStudent.this, "No Match Found!!","Error!!",JOptionPane.ERROR_MESSAGE);
				
				}
				
			}
		});
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		
		
		
		
		
		JButton btnSave_1 = new JButton("SEARCH");
		btnSave_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String enrollment=textField.getText();
				String query="select * from student_registration where enrollment=?";
				int flag=0;
				try
				{
					PreparedStatement ps=(PreparedStatement) DBInfo.con.prepareStatement(query);
					ps.setString(1, enrollment);
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						textField_1.setText(res.getString(2));
						textField_2.setText(res.getString(3));
						textField_3.setText(res.getString(4));
						textField_4.setText(res.getString(5));
						textField_5.setText(res.getString(6));
						textField_6.setText(res.getString(7));
						comboBox_4.setSelectedItem(res.getString(8));
						comboBox_9.setSelectedItem(res.getString(9));
						comboBox_5.setSelectedItem(res.getString(10));
						textField_7.setText(res.getString(11));
						textArea_1.setText(res.getString(12));
						flag=1;
						break;
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			};
			
		});
		
		JButton btnReset_1 = new JButton("RESET");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				comboBox_4.setSelectedIndex(0);
				comboBox_9.setSelectedIndex(0);
				comboBox_5.setSelectedIndex(0);
				textArea_1.setText(null);
				
				
			}
		});
		
		JButton btnLoginNow_1 = new JButton("UPDATE");
		
		JLabel lblCourse = new JLabel("Course");
		
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enrollment=textField.getText();
				String query="delete from student_registration where enrollment=?";
				try
				{
					PreparedStatement ps=(PreparedStatement) DBInfo.con.prepareStatement(query);
					ps.setString(1, enrollment);
					ps.executeUpdate();
					
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(ViewStudent.this, "Record Deleted!!");
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				comboBox_4.setSelectedIndex(0);
				comboBox_9.setSelectedIndex(0);
				comboBox_5.setSelectedIndex(0);
				textArea_1.setText(null);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAddress)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblAdmissionDate)
								.addContainerGap())
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSemester)
									.addContainerGap())
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblBranch)
										.addContainerGap())
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblGender)
												.addContainerGap())
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblDob)
													.addContainerGap())
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblRoll)
														.addContainerGap())
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(lblName)
															.addContainerGap())
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
															.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblEnrollmentNumber, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
																.addContainerGap())
															.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																	.addComponent(lblEmail)
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(btnSave_1)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(btnReset_1)))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																	.addComponent(textField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																	.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(btnLoginNow_1)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
																	.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
																		.addGroup(gl_contentPane.createSequentialGroup()
																			.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.UNRELATED)
																			.addComponent(lblCourse)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(comboBox_9, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																		.addComponent(textField_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																		.addComponent(textField_7, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
																	.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(textField_5, Alignment.LEADING)
																		.addComponent(textField_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
																.addGap(58)))))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblMobile)
											.addContainerGap())))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(174)
					.addComponent(lblNewLabel)
					.addContainerGap(189, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnrollmentNumber, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRoll)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDob)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMobile)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBranch)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSemester)
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCourse)
						.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdmissionDate)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoginNow_1)
						.addComponent(btnSave_1)
						.addComponent(btnReset_1)
						.addComponent(btnDelete))
					.addGap(338))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
