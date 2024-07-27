package Contacts;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Contact extends JFrame {



    private JPanel contentPane;

    private JTextField tf1;

    private JTextField tf2;

    private JTextField tf3;

    private JTextField tf5;

    private JTextField tf6;

    private JTextField tf7;

    private JTextField tf8;

    private JTextField tf9;

    private JTextField tf4;

    private JTable table;

    Connection conn;


    JComboBox<String> comboBox;


    private JTextField tf10;

    private JTextField tf11;

    private JTextField tf12;
    private JComboBox<String> comboBox_1;


    /**

     * Launch the application.

     */

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Contact frame = new Contact();

                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }


//Add Combo Box

    void addItemToComboBox()throws SQLException{

        String query = "SELECT * from contact";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(query);


        while(rs.next()) {

            comboBox.addItem(String.valueOf(rs.getInt("Id")));

        }

    }




    /**

     * Create the frame.

     */

    public Contact() {

        conn = DataBaseConnection.dbConn();

        setFont(new Font("Dialog", Font.BOLD, 18));

        setBackground(SystemColor.activeCaption);

        setTitle(" gestion de contact");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 1273, 680);

        contentPane = new JPanel();

        contentPane.setBackground(new Color(176, 224, 230));

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        contentPane.setLayout(null);


        JLabel lblNewLabel = new JLabel("GESTION DE CONTACT");

        lblNewLabel.setForeground(new Color(95, 158, 160));

        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));

        lblNewLabel.setBounds(192, 25, 642, 44);

        contentPane.add(lblNewLabel);


        JLabel lblNewLabel_1 = new JLabel("Nom");

        lblNewLabel_1.setForeground(new Color(0, 128, 128));

        lblNewLabel_1.setBackground(new Color(0, 128, 128));

        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNewLabel_1.setBounds(10, 95, 111, 27);

        contentPane.add(lblNewLabel_1);


        JLabel lblNewLabel_1_1 = new JLabel("Prenom");

        lblNewLabel_1_1.setForeground(new Color(0, 128, 128));

        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNewLabel_1_1.setBounds(10, 145, 123, 27);

        contentPane.add(lblNewLabel_1_1);


        JLabel lblNewLabel_1_2 = new JLabel("Telehpne1");

        lblNewLabel_1_2.setForeground(new Color(0, 128, 128));

        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNewLabel_1_2.setBounds(10, 195, 95, 27);

        contentPane.add(lblNewLabel_1_2);


        JLabel lblNewLabel_1_3 = new JLabel("Telehpone2");

        lblNewLabel_1_3.setForeground(new Color(0, 128, 128));

        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNewLabel_1_3.setBounds(10, 253, 111, 27);

        contentPane.add(lblNewLabel_1_3);


        JLabel lblNewLabel_1_2_1 = new JLabel("Adresse");

        lblNewLabel_1_2_1.setForeground(new Color(0, 125, 128));

        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNewLabel_1_2_1.setBounds(10, 320, 95, 27);

        contentPane.add(lblNewLabel_1_2_1);


        JLabel lblNewLabel_1_3_1 = new JLabel("Email Personnel");

        lblNewLabel_1_3_1.setForeground(new Color(0, 120, 128));

        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));

        lblNewLabel_1_3_1.setBounds(10, 367, 123, 27);

        contentPane.add(lblNewLabel_1_3_1);


        JLabel lblNewLabel_1_3_1_3 = new JLabel("Id");

        lblNewLabel_1_3_1_3.setForeground(new Color(0, 128, 128));

        lblNewLabel_1_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNewLabel_1_3_1_3.setBounds(10, 405, 123, 27);

        contentPane.add(lblNewLabel_1_3_1_3);

        JLabel lblNewLabel_1_3_1_1 = new JLabel("Email Professionnel");

        lblNewLabel_1_3_1_1.setForeground(new Color(0, 120, 128));

        lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));

        lblNewLabel_1_3_1_1.setBounds(10, 443, 123, 27);

        contentPane.add(lblNewLabel_1_3_1_1);




        JLabel lblNewLabel_1_3_1_2 = new JLabel("Genre");

        lblNewLabel_1_3_1_2.setForeground(new Color(0, 128, 128));

        lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNewLabel_1_3_1_2.setBounds(10, 488, 123, 27);

        contentPane.add(lblNewLabel_1_3_1_2);




        tf1 = new JTextField();

        tf1.setBackground(new Color(224, 255, 255));

        tf1.setForeground(new Color(0, 0, 0));

        tf1.setBounds(166, 95, 134, 32);

        contentPane.add(tf1);

        tf1.setColumns(20);


        tf2 = new JTextField();

        tf2.setBackground(new Color(224, 255, 255));

        tf2.setColumns(20);
        tf2.setBounds(166, 140, 134, 32);
        contentPane.add(tf2);


        tf3 = new JTextField();

        tf3.setBackground(new Color(224, 255, 255));

        tf3.setColumns(20);

        tf3.setBounds(166, 191, 134, 32);

        contentPane.add(tf3);

        tf4 = new JTextField();

        tf4.setBackground(new Color(224, 255, 255));

        tf4.setColumns(20);

        tf4.setBounds(166, 244, 134, 32);

        contentPane.add(tf4);


        tf5 = new JTextField();

        tf5.setBackground(new Color(224, 255, 255));

        tf5.setColumns(20);

        tf5.setBounds(166, 300, 134, 32);

        contentPane.add(tf5);


        tf6 = new JTextField();

        tf6.setBackground(new Color(224, 255, 255));

        tf6.setColumns(20);

        tf6.setBounds(166, 360, 134, 32);

        contentPane.add(tf6);


        tf7 = new JTextField();

        tf7.setBackground(new Color(224, 255, 255));

        tf7.setColumns(10);

        tf7.setBounds(166, 405, 134, 32);

        contentPane.add(tf7);


        tf8 = new JTextField();

        tf8.setBackground(new Color(224, 255, 255));

        tf8.setColumns(10);

        tf8.setBounds(166, 450, 134, 32);

        contentPane.add(tf8);





        comboBox_1 = new JComboBox<String>();

        comboBox_1.setForeground(new Color(0, 128, 0));

        comboBox_1.setBackground(new Color(224, 255, 255));

        comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 18));

        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[] {"Homme", "Femme"}));

        comboBox_1.setBounds(166, 490, 134, 27);
        contentPane.add(comboBox_1);



        JButton btnNewButton = new JButton("Affiche List");
        btnNewButton.setForeground(new Color(0, 0, 205));
        btnNewButton.setBackground(new Color(100, 149, 237));

        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));

        btnNewButton.setBounds(394, 600, 130, 32);

        contentPane.add(btnNewButton);


        JButton btnInsert = new JButton("Insérer");

        btnInsert.setForeground(new Color(0, 0, 205));

        btnInsert.setBackground(new Color(100, 149, 237));

        btnInsert.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String query = "Insert into contact values(?,?,?,?,?,?,?,?,?)";

                try {

                    PreparedStatement ps = conn.prepareStatement(query);

                    ps.setInt(1, Integer.parseInt(tf7.getText()));
                    ps.setString(2, tf1.getText());

                    ps.setString(3, tf2.getText());

                    ps.setString(4, tf3.getText());

                    ps.setString(5, tf4.getText());

                    ps.setString(6, tf5.getText());

                    ps.setString(7, tf6.getText());

                    ps.setString(8, tf8.getText());

                    ps.setString(9, String.valueOf(comboBox_1.getSelectedItem()));

                    ps.execute();

                    JOptionPane.showMessageDialog(null, "Data Insertion Successfully!");

                    showData();
                    addItemToComboBox();
                    reinitialiserChamps();


                } catch (SQLException e1) {

                    JOptionPane.showMessageDialog(null, "Data Insertion Failed!");
                    e1.printStackTrace();

                }

            }

        });


        btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));

        btnInsert.setBounds(572, 600, 105, 32);

        contentPane.add(btnInsert);




        JButton btnUpdate = new JButton("Update");

        btnUpdate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String q = "UPDATE contact SET Nom=?, Prenom=?, Telephone1=?, Telephone2=?, Adresse=?, Emailpersonnel=?, Emailprofessionnel=?, Genre=? WHERE Id=?";
                try {
                    PreparedStatement ps = conn.prepareStatement(q);
                    ps.setString(1, tf1.getText());
                    ps.setString(2, tf2.getText());
                    ps.setString(3, tf3.getText());
                    ps.setString(4, tf4.getText());
                    ps.setString(5, tf5.getText());
                    ps.setString(6, tf6.getText());
                    ps.setString(7, tf8.getText());
                    ps.setString(8, String.valueOf(comboBox_1.getSelectedItem()));
                    ps.setInt(9, Integer.parseInt(tf7.getText()));
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Données mises à jour avec succès !");
                    showData();
                    addItemToComboBox();
                    reinitialiserChamps();
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Échec de la mise à jour des données !");
                    e1.printStackTrace();
                }
            }
        });



        btnUpdate.setForeground(new Color(0, 0, 205));

        btnUpdate.setBackground(new Color(100, 149, 237));

        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));

        btnUpdate.setBounds(742, 600, 105, 32);

        contentPane.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");

        btnDelete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String query = "DELETE from contact where Id=?";

                try {

                    PreparedStatement ps = conn.prepareStatement(query);

                    ps.setInt(1, Integer.parseInt(tf7.getText()));

                    ps.execute();

                    JOptionPane.showMessageDialog(null, "Data Deleted Successfully!");

                    showData();

                } catch (SQLException e1) {

                    JOptionPane.showMessageDialog(null, "Data Deleted Failed!");

                    e1.printStackTrace();

                }

            }

        });


        btnDelete.setForeground(new Color(0, 0, 205));

        btnDelete.setBackground(new Color(100, 149, 237));

        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));

        btnDelete.setBounds(1084, 600, 105, 32);

        contentPane.add(btnDelete);


        table = new JTable();

        table.setBackground(new Color(240, 248, 255));

        table.setForeground(new Color(0, 100, 0));

        table.setFont(new Font("Tahoma", Font.PLAIN, 12));

        table.setModel(new DefaultTableModel(

                new Object[][] {

                        {"Id","Nom", "Prenom", "Telephone1", "Telephone2", "Adresse", "Emailpersonnel", "Emailprofessionnel", "Genre"},

                        {null, null, null, null, null, null, null, null, null},

                        {null, null, null, null, null, null, null, null, null},

                        {null, null, null, null, null, null, null, null, null},

                },

                new String[] {

                        "Id","Nom", "Prenom", "Telephone1", "Telephone2", "Adresse", "Emailpersonnel","Id", "Emailprofessionnel", "Genre"

                }

        ));

        table.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 0, 0)));

        table.setBounds(349, 154, 900, 435);

        contentPane.add(table);


        comboBox = new JComboBox<String>();

        comboBox.setBackground(new Color(224, 255, 255));
        comboBox.setBounds(90, 550, 237, 33);

        contentPane.add(comboBox);

        comboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String query = "SELECT * from contact where Id=?";

                try {

                    PreparedStatement ps = conn.prepareStatement(query);

                    ps.setString(1, String.valueOf(comboBox.getSelectedItem()));

                    ResultSet rs = ps.executeQuery();


                    if(rs.next()) {
                        tf7.setText(String.valueOf(rs.getInt("Id")));

                        tf1.setText(rs.getString("Nom"));

                        tf2.setText(rs.getString("Prenom"));

                        tf3.setText(rs.getString("Telephone1"));

                        tf4.setText(rs.getString("Telephone2"));

                        tf5.setText(rs.getString("Adresse"));

                        tf6.setText(rs.getString("Emailpersonnel"));

                        tf8.setText(rs.getString("Emailprofessionnel"));

                        tf9.setText(rs.getString("Genre"));

                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();

                }

            }

        });


        JLabel lblNewLabel_num = new JLabel("rechercher un contact par Telephone: ");

        lblNewLabel_num.setForeground(new Color(46, 139, 87));

        lblNewLabel_num.setBackground(new Color(51, 204, 204));

        lblNewLabel_num.setFont(new Font("Tahoma", Font.BOLD, 15));

        lblNewLabel_num.setBounds(758, 68, 321, 25);
        contentPane.add(lblNewLabel_num);


        tf10 = new JTextField();
        tf10.setBackground(new Color(224, 255, 255));
        tf10.setToolTipText("Search Here");
        tf10.setBounds(745, 106, 380, 31);
        contentPane.add(tf10);
        tf10.setColumns(10);

        tf10.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String q ="Select * from contact where Telephone1=? or Telephone2=?";
                try {

                    PreparedStatement ps = conn.prepareStatement(q);
                    ps.setString(1, tf10.getText());
                    ps.setString(2, tf10.getText());
                    ResultSet rs = ps.executeQuery();

                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (SQLException e1) {
                    e1.printStackTrace();

                }

            }

        });



        JLabel lblNewLabel_2 = new JLabel("rechercher un contact par nom : ");

        lblNewLabel_2.setForeground(new Color(46, 139, 87));

        lblNewLabel_2.setBackground(new Color(51, 204, 204));

        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));

        lblNewLabel_2.setBounds(375, 70, 421, 25);

        contentPane.add(lblNewLabel_2);

        tf11 = new JTextField();

        tf11.setBackground(new Color(224, 255, 255));

        tf11.setToolTipText("Search Here");
        tf11.setBounds(350, 106, 380, 31);

        contentPane.add(tf11);

        tf11.setColumns(10);

        tf11.addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                String q ="Select * from contact where Nom =?";

                try {

                    PreparedStatement ps = conn.prepareStatement(q);

                    ps.setString(1, tf11.getText());

                    ResultSet rs = ps.executeQuery();

                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (SQLException e1) {
                    e1.printStackTrace();

                }

            }
        });


        JButton btnGrpButton = new JButton("Group");
        btnGrpButton.setForeground(new Color(0, 0, 205));
        btnGrpButton.setBackground(new Color(100, 149, 237));
        btnGrpButton.setFont(new Font("Tahoma", Font.BOLD, 15));

        btnGrpButton.setBounds(920, 600, 105, 32);

        contentPane.add(btnGrpButton);
        btnGrpButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //showData();
                 new Group().setVisible(true);
            }
        });

    }

    private void reinitialiserChamps() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tf8.setText("");
        comboBox_1.setSelectedIndex(0);
    }


    protected void showData() {
        String query = "Select * from contact ORDER BY Nom ASC";

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e1) {
            e1.printStackTrace();

        }
    }








}