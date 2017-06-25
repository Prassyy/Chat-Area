import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class ServerGUI extends javax.swing.JFrame {

	private Server server;

	public ServerGUI(int port) {
		super("Chat Server");
		server = null;
		initComponents(port);
	}

	void appendRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}

	void appendEvent(String str) {
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);

	}

		@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents(int port) {

		jLabel1 = new javax.swing.JLabel();
		tPortNumber = new javax.swing.JTextField("  " + port);
		stopStart = new javax.swing.JToggleButton("Start");
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		chat = new javax.swing.JTextArea();
		jScrollBar1 = new javax.swing.JScrollBar();
		jScrollBar2 = new javax.swing.JScrollBar();
		jPanel3 = new javax.swing.JPanel();
		jScrollBar3 = new javax.swing.JScrollBar();
		event = new javax.swing.JTextArea();
		jScrollBar6 = new javax.swing.JScrollBar();
		jScrollPane2 = new javax.swing.JScrollPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(new java.awt.Dimension(400, 500));
		getContentPane().setLayout(null);

		jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
		jLabel1.setText("Port number:");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(220, 20, 100, 30);

		tPortNumber.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tPortNumberActionPerformed(evt);
			}
		});
		getContentPane().add(tPortNumber);
		tPortNumber.setBounds(320, 20, 110, 30);

		stopStart.setText("START");
		stopStart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopStartActionPerformed(evt);
			}
		});
		getContentPane().add(stopStart);
		stopStart.setBounds(470, 20, 80, 30);

		jPanel1.setLayout(null);
		getContentPane().add(jPanel1);
		jPanel1.setBounds(0, -2, 790, 70);

		jPanel2.setLayout(null);

		chat.setBackground(new java.awt.Color(177, 220, 174));
		chat.setColumns(20);
		chat.setRows(5);
		appendRoom("Chat Room.\n");
		jScrollPane1.setViewportView(chat);

		jPanel2.add(jScrollPane1);
		jScrollPane1.setBounds(0, 0, 770, 170);
		jPanel2.add(jScrollBar1);
		jScrollBar1.setBounds(770, 0, 21, 170);

		jScrollBar2.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
		jPanel2.add(jScrollBar2);
		jScrollBar2.setBounds(0, 170, 790, 20);

		getContentPane().add(jPanel2);
		jPanel2.setBounds(0, 70, 820, 190);

		jPanel3.setLayout(null);
		jPanel3.add(jScrollBar3);
		jScrollBar3.setBounds(770, 0, 20, 190);

		event.setBackground(new java.awt.Color(177, 220, 174));
		event.setColumns(20);
		event.setRows(5);
		appendEvent("Events log.\n");
		jPanel3.add(event);
		event.setBounds(0, 0, 770, 190);

		getContentPane().add(jPanel3);
		jPanel3.setBounds(0, 266, 790, 190);

		jScrollBar6.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
		getContentPane().add(jScrollBar6);
		jScrollBar6.setBounds(0, 459, 790, 20);
		getContentPane().add(jScrollPane2);
		jScrollPane2.setBounds(0, 260, 780, 190);

		setSize(new java.awt.Dimension(812, 528));
		setLocationRelativeTo(null);
	}// </editor-fold>

	private void tPortNumberActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void stopStartActionPerformed(java.awt.event.ActionEvent evt) {
		if (server != null) {
			server.stop();
			server = null;
			tPortNumber.setEditable(true);
			stopStart.setText("Start");
			return;
		}
		// OK start the server
		int port;
		try {
			port = Integer.parseInt(tPortNumber.getText().trim());
		} catch (Exception er) {
			appendEvent("Invalid port number");
			return;
		}
		// ceate a new Server
		server = new Server(port, this);
		// and start it as a thread
		new ServerRunning().start();
		stopStart.setText("Stop");
		tPortNumber.setEditable(false);
	}
	public void windowClosing(WindowEvent e) {
		// if my Server exist
		if (server != null) {
			try {
				server.stop(); // ask the server to close the conection
			} catch (Exception eClose) {
			}
			server = null;
		}
		// dispose the frame
		dispose();
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	class ServerRunning extends Thread {
		public void run() {
			server.start(); // should execute until if fails
			// the server failed
			stopStart.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Server crashed\n");
			server = null;
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
			java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ServerGUI(1500).setVisible(true);
			}
		});
	}
	private javax.swing.JTextArea chat;
	private javax.swing.JTextArea event;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollBar jScrollBar1;
	private javax.swing.JScrollBar jScrollBar2;
	private javax.swing.JScrollBar jScrollBar3;
	private javax.swing.JScrollBar jScrollBar6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JToggleButton stopStart;
	private javax.swing.JTextField tPortNumber;
	// End of variables declaration
}
