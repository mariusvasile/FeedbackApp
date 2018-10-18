import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Feed {

	private JFrame frmLoggingForm;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feed window = new Feed();
					window.frmLoggingForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	/**
	 * Create the application.
	 */
	public Feed() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoggingForm = new JFrame();
		frmLoggingForm.setTitle("Login Form");
		frmLoggingForm.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmLoggingForm.setBounds(100, 100, 450, 300);
		frmLoggingForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoggingForm.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(31, 83, 82, 22);
		frmLoggingForm.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(31, 116, 82, 22);
		frmLoggingForm.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(123, 86, 188, 20);
		frmLoggingForm.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 119, 188, 20);
		frmLoggingForm.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = passwordField.getText();
				String username = textField.getText();
				
			
				
				if (username.length() == 0 || password.length() == 0) { 
					JOptionPane.showMessageDialog(null, "Username/Password required.", "Error", 
					JOptionPane.WARNING_MESSAGE);
				return; }
				else {
					JOptionPane.showMessageDialog(null, "Username and password are correct.");
					frmLoggingForm.dispose();
					MenuInput Menu = new MenuInput();
					Menu.setVisible(true);
					
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(31, 172, 92, 23);
		frmLoggingForm.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoggingForm = new JFrame("Cancel");
				if (JOptionPane.showConfirmDialog(frmLoggingForm, "Confirm if you want to cancel", "Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				
				}
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(216, 172, 92, 23);
		frmLoggingForm.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("To proceed, please enter your login credentials.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 25, 334, 22);
		frmLoggingForm.getContentPane().add(lblNewLabel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				passwordField.setText(null);
				textField.setText(null);
			}
				
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(123, 172, 92, 23);
		frmLoggingForm.getContentPane().add(btnReset);
	}
}
