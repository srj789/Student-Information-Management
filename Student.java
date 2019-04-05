package projectRAT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public Student(String title) 
	{
		super(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnViewSelfProfile = new JButton("View Self Profile");
		contentPane.add(btnViewSelfProfile, BorderLayout.NORTH);
		
		JButton btnViewAllNotices = new JButton("View All Notices");
		contentPane.add(btnViewAllNotices, BorderLayout.WEST);
		
		JButton btnSubmitFeedback = new JButton("Submit feedback");
		contentPane.add(btnSubmitFeedback, BorderLayout.EAST);
		
		JButton btnUpdateProfile = new JButton("Update Profile");
		contentPane.add(btnUpdateProfile, BorderLayout.SOUTH);
		
		JButton btnStudentSection = new JButton("<html><body><h1><font color='red'><center>STUDENT<br> SECTION</h1</body</html>");
		btnStudentSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnStudentSection, BorderLayout.CENTER);
	}

}
