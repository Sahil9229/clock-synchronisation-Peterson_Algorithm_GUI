import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;


public class Client_Clock {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_Clock window = new Client_Clock();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
	}

	/**
	 * Create the application.
	 */
	public Client_Clock() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = 
				new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(180, 51, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 20, 186, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Port Number of Server");
		lblNewLabel.setBounds(29, 51, 147, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Host IP");
		lblNewLabel_1.setBounds(96, 23, 71, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Synchronize");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClockClient.port=textField.getText();
				ClockClient.hostName=textField_1.getText();
				ClockSync_client.init();
				
			}
		});
		btnNewButton.setBounds(44, 90, 121, 23);
		frame.getContentPane().add(btnNewButton);
		
		final JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(180, 94, 96, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Client");
		lblNewLabel_3.setFont(new Font("Yu Gothic Light", Font.PLAIN, 30));
		lblNewLabel_3.setForeground(new Color(0, 204, 153));
		lblNewLabel_3.setBounds(338, 127, 96, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
           Thread t=new Thread(){
			
			public void run()
			{
				while(true)
				{
					DateFormat date=new SimpleDateFormat("hh:mm:ss");
					String datestring=date.format(new Date()).toString();
					lblNewLabel_2.setText(datestring);
					try
					{
						Thread.sleep(1);
					}catch(Exception e){e.printStackTrace();}
					
					
				}
				
				
			}
		};
		t.start();
	}
}
