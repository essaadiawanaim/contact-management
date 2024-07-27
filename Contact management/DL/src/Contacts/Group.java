package Contacts;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Group extends JFrame {


    private JPanel contentPane;
    private JTextField tfGroupName;
    private JTextArea taGroupMembers;
    private JTextArea resultTextArea;



    Connection conn;




    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Group frame = new Group();

                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }

    public Group() {

        conn = DataBaseConnection.dbConn();

        setFont(new Font("Dialog", Font.BOLD, 18));

        setBackground(SystemColor.activeCaption);

        setTitle(" les Groups");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 1273, 680);

        contentPane = new JPanel();

        contentPane.setBackground(new Color(176, 224, 230));

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        contentPane.setLayout(null);


        JLabel lblNewLabel = new JLabel("GESTION DE Group");

        lblNewLabel.setForeground(new Color(95, 158, 160));

        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));

        lblNewLabel.setBounds(192, 25, 642, 44);

        contentPane.add(lblNewLabel);



        JLabel groupNameLabel = new JLabel("Nom du groupe :");
        groupNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        groupNameLabel.setBounds(50, 100, 150, 30);
        contentPane.add(groupNameLabel);

        tfGroupName = new JTextField();
        tfGroupName.setBounds(250, 100, 150, 30);
        contentPane.add(tfGroupName);

        JLabel membersLabel = new JLabel("Membres (séparés par des virgules) :");
        membersLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        membersLabel.setBounds(50, 150, 200, 20);
        contentPane.add(membersLabel);

        taGroupMembers = new JTextArea();
        taGroupMembers.setBounds(290, 150, 290, 60);
        contentPane.add(taGroupMembers);

        JButton createGroupButton = new JButton("Créer groupe");
        createGroupButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        createGroupButton.setBounds(50, 230, 150, 30);
        contentPane.add(createGroupButton);

        JButton afficheGroupButton = new JButton("Afficher les groupe");
        afficheGroupButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        afficheGroupButton.setBounds(50, 290, 200, 30);
        contentPane.add(afficheGroupButton);

        JButton deleteGroupButton = new JButton("Supprimer groupe");
        deleteGroupButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        deleteGroupButton.setBounds(210, 230, 200, 30);
        contentPane.add(deleteGroupButton);

        JButton searchGroupButton = new JButton("Rechercher groupe");
        searchGroupButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        searchGroupButton.setBounds(420, 230, 200, 30);
        contentPane.add(searchGroupButton);


        JLabel lblNewLabel_erea = new JLabel("les groups et contacts associées: ");

        //lblNewLabel_erea.setForeground(new Color(95, 158, 160));
        lblNewLabel_erea.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNewLabel_erea.setBackground(new Color(51, 204, 204));

        lblNewLabel_erea.setFont(new Font("Tahoma", Font.BOLD, 15));

        lblNewLabel_erea.setBounds(698, 55, 321, 25);
        contentPane.add(lblNewLabel_erea);
        resultTextArea = new JTextArea();
        resultTextArea.setBounds(690, 80, 400, 500);
        contentPane.add(resultTextArea);


        // Associer les actions aux boutons
        createGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String groupName = tfGroupName.getText();
                String members = taGroupMembers.getText();
                createGroup(groupName, members);
                displayGroupsAndMembers();
            }
        });

        deleteGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String groupName = tfGroupName.getText();
                deleteGroup(groupName);
                resultTextArea.setText("");
                displayGroupsAndMembers();
            }
        });
        afficheGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayGroupsAndMembers();
            }
        });

        searchGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String groupName = tfGroupName.getText();
                searchGroupByName(groupName);
                //displayGroupsAndMembers();

            }
        });
    }

    private void searchGroupByName(String groupName) {
        resultTextArea.setText(""); // Effacer le contenu précédent

        try {

            // Requête SQL pour récupérer les groupes par nom
            String query = "SELECT group_name FROM `group` WHERE group_name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + groupName + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String groupResult = rs.getString("group_name");
                resultTextArea.append(groupResult + "\n");
            }

            //rs.close();
            //ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void createGroup(String groupName, String members) {
        // Logique de création d'un groupe

        try {

            String insertGroupQuery = "INSERT INTO `group` (group_name) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(insertGroupQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, groupName);

            // Exécutez la requête d'insertion pour créer le groupe
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {

                // Récupérez l'identifiant du groupe nouvellement inséré
                ResultSet generatedKeys = ps.getGeneratedKeys();
                int groupId = -1;
                if (generatedKeys.next()) {
                    groupId = generatedKeys.getInt(1);
                }

                // Traitez les membres du groupe si nécessaire
                if (members != null && !members.isEmpty()) {
                    String[] memberArray = members.split(",");
                    for (String member : memberArray) {
                        // Vérifiez si le membre existe déjà dans la table "contact"
                        String checkMemberQuery = "SELECT Id FROM contact WHERE Nom = ?";
                        PreparedStatement checkMemberPs = conn.prepareStatement(checkMemberQuery);
                        checkMemberPs.setString(1, member.trim());
                        ResultSet checkMemberResult = checkMemberPs.executeQuery();

                        int memberId = -1;
                        if (checkMemberResult.next()) {
                            // Le membre existe déjà dans la table "contact"
                            memberId = checkMemberResult.getInt("Id");
                        }else {
                            // Le membre n'existe pas, insérez-le dans la table "contact"
                            JOptionPane.showMessageDialog(null, "Le membre n'existe pas  !!");

                        }
                        checkMemberResult.close();
                        checkMemberPs.close();

                        // Si le membre a un identifiant valide, associez-le au groupe
                        if (memberId != -1) {
                            String insertGroupMemberQuery = "INSERT INTO group_contact (group_id, contact_id) VALUES (?, ?)";
                            PreparedStatement groupMemberPs = conn.prepareStatement(insertGroupMemberQuery);
                            groupMemberPs.setInt(1, groupId);
                            groupMemberPs.setInt(2, memberId);
                            groupMemberPs.executeUpdate();
                            groupMemberPs.close();
                        }
                    }
                }
                // Le groupe a été créé avec succès
                JOptionPane.showMessageDialog(null, "Le groupe a été créé avec succès !!");
            } else {
                // La création du groupe a échoué
                JOptionPane.showMessageDialog(null, "Échec de la création du groupe !!");
            }
            //ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteGroup(String groupName) {

        try {
            // Supprimer les enregistrements associés dans la table group_contact
            String deleteGroupContactQuery = "DELETE FROM group_contact WHERE group_id IN (SELECT group_id FROM `group` WHERE group_name = ?)";
            PreparedStatement psGroupContact = conn.prepareStatement(deleteGroupContactQuery);
            psGroupContact.setString(1, groupName);
            psGroupContact.executeUpdate();
            psGroupContact.close();

            // Supprimer le groupe de la table group
            String deleteGroupQuery = "DELETE FROM `group` WHERE group_name = ?";
            PreparedStatement psGroup = conn.prepareStatement(deleteGroupQuery);
            psGroup.setString(1, groupName);
            int rowsAffected = psGroup.executeUpdate();

            // Vérifiez si la suppression a réussi
            if (rowsAffected > 0) {
                // Le groupe a été supprimé avec succès
                JOptionPane.showMessageDialog(null, "Le groupe a été supprimé avec succès!");

            } else {
                // La suppression du groupe a échoué
                JOptionPane.showMessageDialog(null, "Échec de la suppression du groupe!");

            }

           // psGroup.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void displayGroupsAndMembers() {
        try {

            // Requête SQL pour récupérer les groupes avec leurs membres
            String selectQuery = "SELECT group_name, GROUP_CONCAT(Nom SEPARATOR ', ') AS members " +
                    "FROM `group` " +
                    "INNER JOIN group_contact ON `group`.group_id = group_contact.group_id " +
                    "INNER JOIN contact ON group_contact.contact_id = contact.Id " +
                    "GROUP BY group_name";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            // Effacer le contenu précédent de la JTextArea
            resultTextArea.setText("");

            // Parcourir les résultats de la requête et afficher les groupes avec leurs membres
            while (rs.next()) {
                String groupName = rs.getString("group_name");
                String members = rs.getString("members");

                // Ajouter le groupe avec ses membres à la JTextArea
                resultTextArea.append("Nom du groupe : " + groupName + "\n");
                resultTextArea.append("Membres du groupe : " + members + "\n\n");
            }
            //rs.close();
            //stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
