
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author admin
 */
public class MainFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame(String title) {
		super(title);
		try {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				// UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (UnsupportedLookAndFeelException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		initComponents();
	}
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		usernametextfield = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		Passwordtextfeild = new javax.swing.JPasswordField();
		jToggleButton1 = new javax.swing.JToggleButton();
		jLabel13 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		usernametextfeild = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		passwordtextfeild = new javax.swing.JPasswordField();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		Passwordtextfield1 = new javax.swing.JPasswordField();
		jToggleButton2 = new javax.swing.JToggleButton();
		jLabel14 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jPanel1.setLayout(null);

		jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\log.png")); // NOI18N
		jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel1.add(jLabel4);
		jLabel4.setBounds(40, 30, 240, 70);

		jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\u3.png")); // NOI18N
		jLabel5.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel1.add(jLabel5);
		jLabel5.setBounds(30, 140, 52, 50);

		usernametextfield.setBackground(new java.awt.Color(51, 51, 51));
		usernametextfield.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
		usernametextfield.setForeground(new java.awt.Color(255, 255, 255));
		usernametextfield.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel1.add(usernametextfield);
		usernametextfield.setBounds(80, 140, 210, 50);

		jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
		jLabel15.setForeground(new java.awt.Color(255, 255, 255));
		jLabel15.setText("User Name");
		jPanel1.add(jLabel15);
		jLabel15.setBounds(30, 120, 90, 16);

		jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\p3.png")); // NOI18N
		jLabel6.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel1.add(jLabel6);
		jLabel6.setBounds(30, 220, 50, 50);

		Passwordtextfeild.setBackground(new java.awt.Color(51, 51, 51));
		Passwordtextfeild.setForeground(new java.awt.Color(255, 255, 255));
		Passwordtextfeild.setBorder(new javax.swing.border.MatteBorder(null));
		Passwordtextfeild.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PasswordtextfeildActionPerformed(evt);
			}
		});
		jPanel1.add(Passwordtextfeild);
		Passwordtextfeild.setBounds(80, 220, 210, 50);

		jToggleButton1.setBackground(new java.awt.Color(51, 51, 51));
		jToggleButton1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
		jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
		jToggleButton1.setText("LOGIN");
		jToggleButton1.setBorder(new javax.swing.border.MatteBorder(null));
		jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton1ActionPerformed(evt);
			}
		});
		jPanel1.add(jToggleButton1);
		jToggleButton1.setBounds(30, 300, 260, 60);

		jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
		jLabel13.setForeground(new java.awt.Color(255, 255, 255));
		jLabel13.setText("Password");
		jPanel1.add(jLabel13);
		jLabel13.setBounds(30, 200, 58, 16);

		jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\smple2.jpg")); // NOI18N
		jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel1.add(jLabel2);
		jLabel2.setBounds(0, 0, 310, 450);

		getContentPane().add(jPanel1);
		jPanel1.setBounds(140, 80, 310, 450);

		jPanel2.setLayout(null);

		jLabel7.setBackground(new java.awt.Color(51, 51, 51));
		jLabel7.setForeground(new java.awt.Color(51, 51, 51));
		jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\r3.jpg")); // NOI18N
		jLabel7.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel2.add(jLabel7);
		jLabel7.setBounds(40, 20, 247, 78);

		usernametextfeild.setBackground(new java.awt.Color(51, 51, 51));
		usernametextfeild.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
		usernametextfeild.setForeground(new java.awt.Color(255, 255, 255));
		usernametextfeild.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel2.add(usernametextfeild);
		usernametextfeild.setBounds(80, 130, 210, 50);

		jLabel8.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
		jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\u3.png")); // NOI18N
		jLabel8.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel2.add(jLabel8);
		jLabel8.setBounds(30, 130, 50, 50);

		jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
		jLabel11.setForeground(new java.awt.Color(51, 51, 51));
		jLabel11.setText("Password");
		jPanel2.add(jLabel11);
		jLabel11.setBounds(30, 180, 170, 16);

		passwordtextfeild.setBackground(new java.awt.Color(51, 51, 51));
		passwordtextfeild.setForeground(new java.awt.Color(255, 255, 255));
		passwordtextfeild.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel2.add(passwordtextfeild);
		passwordtextfeild.setBounds(80, 200, 210, 50);

		jLabel9.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
		jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\p3.png")); // NOI18N
		jLabel9.setText("Password");
		jLabel9.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel2.add(jLabel9);
		jLabel9.setBounds(30, 200, 50, 50);

		jLabel10.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
		jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\p3.png")); // NOI18N
		jLabel10.setText("Confirm Password");
		jLabel10.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel2.add(jLabel10);
		jLabel10.setBounds(30, 270, 50, 50);

		jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
		jLabel12.setForeground(new java.awt.Color(51, 51, 51));
		jLabel12.setText("Confirm Password");
		jPanel2.add(jLabel12);
		jLabel12.setBounds(30, 250, 120, 16);

		Passwordtextfield1.setBackground(new java.awt.Color(51, 51, 51));
		Passwordtextfield1.setBorder(new javax.swing.border.MatteBorder(null));
		jPanel2.add(Passwordtextfield1);
		Passwordtextfield1.setBounds(80, 270, 210, 50);

		jToggleButton2.setBackground(new java.awt.Color(51, 51, 51));
		jToggleButton2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
		jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
		jToggleButton2.setText("SIGN UP");
		jToggleButton2.setBorder(new javax.swing.border.MatteBorder(null));
		jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton2ActionPerformed(evt);
			}
		});
		jPanel2.add(jToggleButton2);
		jToggleButton2.setBounds(40, 360, 250, 60);

		jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
		jLabel14.setForeground(new java.awt.Color(51, 51, 51));
		jLabel14.setText("User name");
		jPanel2.add(jLabel14);
		jLabel14.setBounds(30, 110, 100, 16);

		jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\smple3.jpg")); // NOI18N
		jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel2.add(jLabel3);
		jLabel3.setBounds(0, 0, 320, 450);

		getContentPane().add(jPanel2);
		jPanel2.setBounds(620, 80, 320, 450);

		jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\prasanna\\Desktop\\projects\\images\\smple1.jpg")); // NOI18N
		jLabel1.setText("jLabel1");
		jLabel1.setBorder(new javax.swing.border.MatteBorder(null));
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 1080, 650);

		setSize(new java.awt.Dimension(1097, 692));
		setLocationRelativeTo(null);
	}

	private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String name = usernametextfield.getText();
		String pwd = new String(Passwordtextfeild.getPassword());
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "");
			Statement stmt = connection.createStatement();
			stmt.executeQuery("Select username, password from memberInfo");
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				String dbUsername = rs.getString("username");
				String dbPassword = rs.getString("password");
				if (dbUsername.equals(name) && dbPassword.equals(pwd)) {
					flag = true;
				}
			}
			if (flag) {
				this.setVisible(false);
				new ClientGUI("localhost", 1500, usernametextfield.getText()).setVisible(true);
				connection.close();
			} else {
				JOptionPane.showMessageDialog(null, "Something Went Wrong, Error Detected", "ERROR 404!",
						JOptionPane.INFORMATION_MESSAGE);
				connection.close();
			}
		} catch (Exception e) {

		}
	}

	private void PasswordtextfeildActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jToggleButton2ActionPerformed
		// Sign-Up Button
		String name = usernametextfeild.getText();
		String pwd = new String(passwordtextfeild.getPassword());
		String nickname = new String(Passwordtextfield1.getPassword());
		if (nickname.equals(pwd)) {
			String exec = "INSERT INTO memberInfo VALUES (null,'" + name + "','" + pwd + "','" + nickname + "')";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "");
				Statement query = connection.createStatement();
				query.executeUpdate(exec);
				jPanel2.hide();
				jPanel1.setLocation(380, 55);
				connection.close();
			} catch (Exception e) {

			}
		} else {
			JOptionPane.showMessageDialog(null, "Something Went Wrong, Error Detected", "ERROR 404!",
					JOptionPane.INFORMATION_MESSAGE);
			usernametextfeild.setText("");
			passwordtextfeild.setText("");
			Passwordtextfield1.setText("");
		}

	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame("Chat Room").setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPasswordField Passwordtextfeild;
	private javax.swing.JPasswordField Passwordtextfield1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JToggleButton jToggleButton1;
	private javax.swing.JToggleButton jToggleButton2;
	private javax.swing.JPasswordField passwordtextfeild;
	private javax.swing.JTextField usernametextfeild;
	private javax.swing.JTextField usernametextfield;
	// End of variables declaration//GEN-END:variables
}
