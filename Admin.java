package projectRAT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

//import ViewStudent;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	
	static String id;

	/**
	 * Create the frame.
	 */
	public Admin(String title,String userid) 
	{
		id=userid;
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 3, 0, 0));
		
		JButton btnRegisterANew = new JButton("Register a new student");
		btnRegisterANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentReg obj=new StudentReg();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnRegisterANew);
		
		JButton btnNewButton = new JButton("View/Update/Delete a student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStudent obj=new ViewStudent();
				obj.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Upload a new notice");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNotice notice=new AddNotice();
				notice.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnViewupdatedeleteANotice = new JButton("View/Update/Delete a notice");
		contentPane.add(btnViewupdatedeleteANotice);
		
		JButton btnNewButton_2 = new JButton("View all student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frm=new JFrame("View All Students");
				frm.setSize(800,600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getStudents();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
				
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnViewAllNotice = new JButton("View all notice");
		btnViewAllNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frm=new JFrame("View All Notices");
				frm.setSize(800,600);
				frm.setLocationRelativeTo(Admin.this);
				GetValues.getNotices();
				JTable t=new JTable(GetValues.records,GetValues.header);
				JScrollPane pane=new JScrollPane(t);
				frm.getContentPane().add(pane);
				frm.setVisible(true);
			}
		});
		contentPane.add(btnViewAllNotice);
		
		JButton btnViewStudentFeedback = new JButton("View student feedback");
		contentPane.add(btnViewStudentFeedback);
		
		JButton btnChangeSelfPassword = new JButton("Change self password");
		contentPane.add(btnChangeSelfPassword);
	}

}
