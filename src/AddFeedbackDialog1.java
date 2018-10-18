import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddFeedbackDialog1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddFeedbackDialog1 dialog = new AddFeedbackDialog1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Connection connection = null;
	/**
	 * Create the dialog.
	 */
	public AddFeedbackDialog1() {
		connection = sqliteConnection.dbConnector();
		setTitle("AddFeedbackDialog");
		setBounds(100, 100, 430, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(10, 52, 1, 323);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 52, 375, 1);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(384, 52, 1, 323);
			contentPanel.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 374, 375, 1);
			contentPanel.add(separator);
		}
		{
			JLabel label = new JLabel("Feedback");
			label.setFont(new Font("Tahoma", Font.BOLD, 12));
			label.setBounds(20, 11, 73, 29);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("First Name:");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(20, 64, 85, 23);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Last Name:");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(21, 93, 84, 29);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("E-mail address: ");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(21, 127, 111, 23);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(115, 67, 256, 20);
			contentPanel.add(textField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(115, 99, 256, 20);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(115, 130, 256, 20);
			contentPanel.add(textField_2);
		}
		{
			JLabel label = new JLabel("Remarks:");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setBounds(21, 155, 84, 28);
			contentPanel.add(label);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(21, 182, 349, 181);
			contentPanel.add(scrollPane);
			{
				JTextArea textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
			}
		}
		{
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						String query = "insert into TableInfo (FirstName, LastName, Email) values (?, ?, ?)";
						PreparedStatement pst = connection.prepareStatement(query);
						
						pst.setString(1, textField.getText());
						pst.setString(2, textField_1.getText());
						pst.setString(3, textField_2.getText());
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "Data saved");
						
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						
						pst.close();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnAdd.setBounds(296, 386, 89, 23);
			contentPanel.add(btnAdd);
		}
		{
			JButton btnReset = new JButton("Reset");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					
				}
			});
			btnReset.setBounds(199, 386, 89, 23);
			contentPanel.add(btnReset);
		}
	}

}
