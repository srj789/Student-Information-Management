package projectRAT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.security.KeyStore.PasswordProtection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel lblUsernameenrollmentempid = new JLabel("Username(enrollment/empid)");
		
		JLabel lblPassword = new JLabel("Password");
		
		textField = new JTextField();
		textField.setColumns(10);
JLabel lblUsertype = new JLabel("UserType");
		
		String type[]={"Select","Admin","Student"};
		
		JComboBox comboBox = new JComboBox(type);
		
		JButton btnLoginNow = new JButton("Login Now");
		btnLoginNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userid=textField.getText();
				
				char ch[]=passwordField.getPassword();
				String password=String.valueOf(ch);
				String type=(String) comboBox.getSelectedItem();
				Connection con=(Connection) DBInfo.con;
				int flag=0;
				if(type.equalsIgnoreCase("admin"))
				{
					String query="select * from faculty_registration where empid=? and password=?";
					try
					{
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
						ps.setString(1,userid);
						ps.setString(2, password);
						ResultSet res=ps.executeQuery();
						while(res.next())
						{
							flag=1;
							break;
							
						}
						
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					if(flag==1)
					{
					Admin a=new Admin("Admin Page",userid);
					a.setVisible(true);
					dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(LoginPage.this, "Wrong Username or password","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			if(type.equalsIgnoreCase("student"))
			{
				String query="select * from student_registration where enrollment=? and password=?";
				try
				{
					PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);
					ps.setString(1,userid);
					ps.setString(2, password);
					ResultSet res=ps.executeQuery();
					while(res.next())
					{
						flag=1;
						break;
						
					}
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				if(flag==1)
				{
				Student s=new Student("Student Page");
				s.setVisible(true);
				dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(LoginPage.this, "Wrong Username or password","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
				
			
			}
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton = new JButton("New User SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(177)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsernameenrollmentempid)
										.addComponent(lblPassword)
										.addComponent(lblUsertype))
									.addGap(99)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
										.addComponent(comboBox, 0, 160, Short.MAX_VALUE)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLoginNow)
									.addGap(32)
									.addComponent(btnReset)
									.addGap(18)
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsernameenrollmentempid)
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsertype))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoginNow)
						.addComponent(btnReset)
						.addComponent(btnNewButton))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
