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
import java.awt.Font;
import java.awt.Color;


public class Server_clock {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_clock window = new Server_clock();
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
	public Server_clock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 427, 209);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    textField = new JTextField();
		textField.setBounds(225, 23, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Port Number");
		lblNewLabel.setBounds(98, 26, 117, 14);
		frame.getContentPane().add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(172, 98, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClockServer.port=textField.getText();
				ClockSync_server.init();
			}
		});
		btnNewButton.setBounds(84, 124, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.setBounds(240, 124, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		final JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(172, 73, 139, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Server");
		lblNewLabel_3.setForeground(new Color(153, 0, 0));
		lblNewLabel_3.setFont(new Font("Yu Gothic Light", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(10, 56, 117, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
Thread t=new Thread(){
			
			public void run()
			{
				while(true)
				{
					DateFormat date=new SimpleDateFormat("hh:mm:ss");
					String datestring=date.format(new Date()).toString();
					lblNewLabel_1.setText(datestring);
					lblNewLabel_2.setText(ClockServer.Cno+" clients Connected");
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
