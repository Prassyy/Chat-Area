import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;


public class ClientGUI extends javax.swing.JFrame implements ActionListener {

	private boolean connected;
	private Client client;
	private int defaultPort;
	private String defaultHost;
	String filename,dir;
	
	
    public ClientGUI(String host, int port,String nickname) {
    	super("Chat Area");
        initComponents(host,port,nickname);
    }
    void append(String str) {
		ta.append(str);
		ta.setCaretPosition(ta.getText().length() - 1);
	}
	void connectionFailed() {
		login.setEnabled(true);
		logout.setEnabled(false);
		whoIsIn.setEnabled(false);
		label.setText("Enter your username");
		tf.setText("Anonymous");
		tfPort.setText("" + defaultPort);
		tfServer.setText(defaultHost);
		// let the user change them
		tfServer.setEditable(false);
		tfPort.setEditable(false);
		// don't react to a <CR> after the username
		tf.removeActionListener(this);
		connected = false;
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == logout) {
			new ClientGUI("localhost", 1500,"Anonymous").setVisible(true);
			this.setVisible(false);
			client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
			return;
		}
		if(o == whoIsIn) {
			client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));				
			return;
		}

		if(connected) {
			client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, tf.getText()));				
			tf.setText("");
			return;
		}
		

		if(o == login) {
			String username = tf.getText().trim();
			// empty username ignore it
			if(username.length() == 0)
				return;
			// empty serverAddress ignore it
			String server = tfServer.getText().trim();
			if(server.length() == 0)
				return;
			// empty or invalid port numer, ignore it
			String portNumber = tfPort.getText().trim();
			if(portNumber.length() == 0)
				return;
			int port = 0;
			try {
				port = Integer.parseInt(portNumber);
			}
			catch(Exception en) {
				return;
			}

			client = new Client(server, port, username, this);
			// test if we can start the Client
			if(!client.start()) 
				return;
			tf.setText("");
			label.setText("Enter your message");
			connected = true;
			
			login.setEnabled(false);
			logout.setEnabled(true);
			whoIsIn.setEnabled(true);
			tfServer.setEditable(false);
			tfPort.setEditable(false);
			jButton1.setEnabled(true);
			tf.addActionListener(this);
		}

	}
    @SuppressWarnings("unchecked")                          
    private void initComponents(String host, int port, String nickname) {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfServer = new javax.swing.JTextField(host);
        jLabel2 = new javax.swing.JLabel();
        tfPort = new javax.swing.JTextField(""+port);
        label = new javax.swing.JLabel("Enter UserName : ");
        tf = new javax.swing.JTextField(nickname);
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new OpenAction());
        jPanel2 = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollBar2 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea("Welcome to the Chat room\n", 80, 80);
        jPanel4 = new javax.swing.JPanel();
        login = new javax.swing.JButton();
        login.addActionListener(this);
        logout = new javax.swing.JButton();
        logout.addActionListener(this);
        whoIsIn = new javax.swing.JButton();
        whoIsIn.addActionListener(this);;

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(135, 9, 228));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setForeground(new java.awt.Color(249, 236, 255));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Server address:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 20, 100, 30);

        tfServer.setBackground(new java.awt.Color(243, 230, 252));
        jPanel1.add(tfServer);
        tfServer.setBounds(140, 20, 210, 30);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Port number : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(380, 20, 90, 30);

        tfPort.setBackground(new java.awt.Color(243, 230, 252));
        jPanel1.add(tfPort);
        tfPort.setBounds(480, 20, 90, 30);

        label.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(label);
        label.setBounds(250, 67, 150, 20);

        tf.setBackground(new java.awt.Color(243, 230, 252));
        tf.setFont(new java.awt.Font("Franklin Gothic Book", 2, 13)); // NOI18N
        jPanel1.add(tf);
        tf.setBounds(10, 90, 560, 30);

        jButton1.setText("jButton1");
        jPanel1.add(jButton1);
        jButton1.setEnabled(false);
        jButton1.setBounds(580, 90, 20, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 610, 130);

        jPanel2.setLayout(null);
        jPanel2.add(jScrollBar1);
        jScrollBar1.setBounds(590, 0, 21, 310);

        jScrollBar2.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        jPanel2.add(jScrollBar2);
        jScrollBar2.setBounds(0, 310, 610, 20);

        ta.setColumns(20);
        ta.setFont(new java.awt.Font("Franklin Gothic Book", 2, 13)); // NOI18N
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 590, 310);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 130, 610, 330);

        jPanel4.setBackground(new java.awt.Color(238, 215, 255));
        jPanel4.setLayout(null);

        login.setText("Login");
        jPanel4.add(login);
        login.setBounds(170, 10, 63, 30);

        logout.setText("Logout");
        jPanel4.add(logout);
        logout.setBounds(270, 10, 71, 30);

        whoIsIn.setText("Who's in");
        jPanel4.add(whoIsIn);
        whoIsIn.setBounds(370, 10, 90, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 460, 610, 50);

        setSize(new java.awt.Dimension(628, 557));
        setLocationRelativeTo(null);
    }// </editor-fold>                        
    class OpenAction implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JFileChooser jfc = new JFileChooser();
			int rVal = jfc.showOpenDialog(ClientGUI.this);
			if(rVal == JFileChooser.APPROVE_OPTION){
				filename = (jfc.getSelectedFile().getName());
				dir = (jfc.getCurrentDirectory().toString());
				tf.setText(dir  +"'\'" +filename);
			}
			if(rVal == JFileChooser.CANCEL_OPTION){
				filename = "You Pressed Cancel";
				dir  = "";
			}
		}
	}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI("localhost", 1500,"Anonymous").setVisible(true);
            }
        });
    }
                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JButton login;
    private javax.swing.JButton logout;
    private javax.swing.JTextArea ta;
    private javax.swing.JTextField tf;
    private javax.swing.JTextField tfPort;
    private javax.swing.JTextField tfServer;
    private javax.swing.JButton whoIsIn;                   
}