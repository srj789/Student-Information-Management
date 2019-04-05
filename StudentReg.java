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
import java.awt.event.ActionEvent;

public class StudentReg extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentReg frame = new StudentReg();
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
	public StudentReg() 
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
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
		
		JLabel lblChoosePassword = new JLabel("Choose Password");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		Integer dd[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		Integer mm[]={1,2,3,4,5,6,7,8,9,10,11,12};
		Integer yy[]={2010,2011,2012,2013,2014,2015,2016,2017,2018};
		
		JComboBox comboBox = new JComboBox(dd);
		
		JComboBox comboBox_1 = new JComboBox(mm);
		
		JComboBox comboBox_2 = new JComboBox(yy);
		
		String gender[]={"Select","Male","Female","trans"};
		JComboBox comboBox_3 = new JComboBox(gender);
		String stream[]={"Select","IT","CSE","EC","MEC","CIVIL"};
		
		JComboBox comboBox_4 = new JComboBox(GetValues.getBranch());
		comboBox_4.insertItemAt("select", 0);
		comboBox_4.setSelectedIndex(0);
		
		Integer sem[]={1,2,3,4,5,6,7,8,9,10};
		JComboBox comboBox_5 = new JComboBox(sem);
		
		JComboBox comboBox_6 = new JComboBox(dd);
		
		JComboBox comboBox_8 = new JComboBox(mm);
		
		JComboBox comboBox_7 = new JComboBox(yy);
		
		String course[]={"BCA","MCA","BTECH","MTECH"};
		JComboBox comboBox_9 = new JComboBox(GetValues.getcourse());
		comboBox_9.insertItemAt("select", 0);
		comboBox_9.setSelectedIndex(0);
		
		JTextArea textArea_1 = new JTextArea();
		
		JButton btnSave_1 = new JButton("SAVE");
		btnSave_1.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				String enroll=textField.getText();
				String name=textField_1.getText();
				String roll=textField_2.getText();
				String mobile=textField_3.getText();
				String email=textField_4.getText();
				String password=textField_5.getText();
				int d1=(int) comboBox.getSelectedItem();
				int m1=(int) comboBox_1.getSelectedItem();
				int y1=(int) comboBox_2.getSelectedItem();
				String dob=d1+"/"+m1+"/"+y1;
				String gender=(String) comboBox_3.getSelectedItem();
				String branch=(String) comboBox_4.getSelectedItem();
				String course=(String) comboBox_9.getSelectedItem();
				String address=textArea_1.getText();
				int sem=(int) comboBox_5.getSelectedItem();
				int d2=(int) comboBox_6.getSelectedItem();
				int m2=(int) comboBox_8.getSelectedItem();
				int y2=(int) comboBox_7.getSelectedItem();
				String doj=d2+"/"+m2+"/"+y2;
				
				Connection con=(Connection) DBInfo.con;
				String query="insert into student_registration values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				int i=0;
				try
				{
					PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
					ps.setString(1, enroll);
					ps.setString(2, name);
					ps.setString(3, roll);
					ps.setString(4, dob);
					ps.setString(5, gender);
					ps.setString(6, mobile);
					ps.setString(7, email);
					ps.setString(8, branch);
					ps.setString(9, course);
					ps.setInt(10, sem);
					ps.setString(11, doj);
					ps.setString(12, address);
					ps.setString(13, password);
					i=ps.executeUpdate();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				if(i==1)
				{
					JOptionPane.showMessageDialog(StudentReg.this,"Record Inserted!!!!");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textArea_1.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					comboBox_4.setSelectedIndex(0);
					comboBox_5.setSelectedIndex(0);
					comboBox_6.setSelectedIndex(0);
					comboBox_7.setSelectedIndex(0);
					comboBox_8.setSelectedIndex(0);
					comboBox_9.setSelectedIndex(0);
					
				}
				if(i==0)
				{
					JOptionPane.showMessageDialog(StudentReg.this,"Registration Failed!!!!");
				}
			}
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
				textArea_1.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_4.setSelectedIndex(0);
				comboBox_5.setSelectedIndex(0);
				comboBox_6.setSelectedIndex(0);
				comboBox_7.setSelectedIndex(0);
				comboBox_8.setSelectedIndex(0);
				comboBox_9.setSelectedIndex(0);
				
			}
		});
		
		JButton btnLoginNow_1 = new JButton("Login Now");
		
		JLabel lblCourse = new JLabel("Course");
		
		
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
																	.addComponent(lblChoosePassword)
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(btnSave_1)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(btnReset_1)))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																	.addComponent(textField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																	.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
																	.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																	.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
																	.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(btnLoginNow_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(textField_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
																	.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
																		.addGroup(gl_contentPane.createSequentialGroup()
																			.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(ComponentPlacement.UNRELATED)
																			.addComponent(lblCourse)
																			.addPreferredGap(ComponentPlacement.RELATED)
																			.addComponent(comboBox_9, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																		.addComponent(textField_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
																.addGap(59)))))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblMobile)
											.addContainerGap())))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(174)
					.addComponent(lblNewLabel)
					.addContainerGap(274, Short.MAX_VALUE))
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
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChoosePassword)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoginNow_1)
						.addComponent(btnSave_1)
						.addComponent(btnReset_1))
					.addGap(338))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
