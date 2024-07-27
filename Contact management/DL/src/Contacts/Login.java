package Contacts;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {



    private JFrame loginsdm;

    private JTextField tf1;

    private JPasswordField tf2;

    Connection sdm;




    /**

     * Launch the application.

     */

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Login window = new Login();

                    window.loginsdm.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }



    /**

     * Create the application.

     */

    public Login() {

        sdm = DataBaseConnection.dbConn();

        initialize();

    }



    /**

     * Initialize the contents of the frame.

     */

    private void initialize() {

        loginsdm = new JFrame();

        loginsdm.getContentPane().setBackground(new Color(0, 0, 0));

        loginsdm.setTitle("CONTACT MANAGEMENT Login\r\n");

        loginsdm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\OneDrive\\Pictures\\AAA.png"));

        loginsdm.setBounds(100, 110, 858, 559);

        loginsdm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginsdm.getContentPane().setLayout(null);


        tf1 = new JTextField();

        tf1.setBackground(new Color(175, 238, 238));

        tf1.setBounds(117, 173, 265, 41);

        loginsdm.getContentPane().add(tf1);

        tf1.setColumns(10);


        JLabel lblNewLabel = new JLabel("Enter Username");

        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

        lblNewLabel.setForeground(new Color(135, 206, 250));

        lblNewLabel.setBounds(118, 131, 233, 41);

        loginsdm.getContentPane().add(lblNewLabel);


        JLabel lblEnterPassword = new JLabel("Enter Password");

        lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 20));

        lblEnterPassword.setForeground(new Color(135, 206, 250));

        lblEnterPassword.setBounds(117, 259, 198, 33);

        loginsdm.getContentPane().add(lblEnterPassword);


        tf2 = new JPasswordField();

        tf2.setBackground(new Color(175, 238, 238));

        tf2.setBounds(117, 292, 265, 41);

        loginsdm.getContentPane().add(tf2);


        JButton b = new JButton("Login");

        b.setFont(new Font("Tahoma", Font.BOLD, 20));

        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String q = "SELECT * from admin where user = ? and mdp = ?";

                try {

                    PreparedStatement ps = sdm.prepareStatement(q);

                    ps.setString(1, tf1.getText());

                    ps.setString(2, String.valueOf(tf2.getPassword()));

//unPrepared statement has prepared:
// "SELECT * from login where username = "essaadia" and pass ="aaa";


                    ResultSet rs = ps.executeQuery();

                    if(rs.next()) {

                        JOptionPane.showMessageDialog(null,"Bienvenue à la gestion de contact");

                        new Contact().setVisible(true);

                    }

                    else {

                        JOptionPane.showMessageDialog(null, "Username / Password Invalid!");

                    }

                } catch (SQLException e1) {

                    e1.printStackTrace();

                }


            }

        });

        b.setForeground(new Color(0, 0, 0));

        b.setBackground(new Color(30, 144, 255));

        b.setBounds(158, 361, 157, 41);

        loginsdm.getContentPane().add(b);


        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Pictures\\AAA.png"));

        lblNewLabel_1.setBounds(497, 0, 357, 416);

        loginsdm.getContentPane().add(lblNewLabel_1);


        JLabel lblNewLabel_2 = new JLabel("GESTION DE CONTACT");

        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));

        lblNewLabel_2.setForeground(new Color(0, 255, 255));

        lblNewLabel_2.setBounds(33, 38, 414, 50);

        loginsdm.getContentPane().add(lblNewLabel_2);

    }

}