package inventory_casheringsystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class LoginForm extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs;

    public LoginForm() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        panel.setBackground(new Color(0, 0, 0, 93));
        showDate();
        showTime();
       
    }

    void showDate() {

        DateFormat dateFormat = new SimpleDateFormat("MM-dd,yyyy");
        Date d = new Date();

        dateof.setText(dateFormat.format(d));

    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss a");
                timeof.setText(f.format(d));
            }
        }).start();
    }

    public void logIn_Out() {
        Statement st;
        ResultSet rs;

        String info = "Login";
        try {

            con = Connections.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into viewlogs(Date,Time,Details,userTypes) values(?,?,?,?)");
            ps.setString(1, dateof.getText());
            ps.setString(2, timeof.getText());
            ps.setString(3, info);
            ps.setString(4, user.getText());

            System.out.println("logs recorded!");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public void login_form() {
        try {
            con = Connections.getConnection();
            ps = con.prepareStatement("SELECT * FROM usertype_table WHERE user = ? AND pass= ? AND usertype=?");

            ps.setString(1, user.getText());
            ps.setString(2, pass.getText());
            ps.setString(3, String.valueOf(usertype.getSelectedItem()));
            rs = ps.executeQuery();
            

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Hello :) " + rs.getString("user") + "  Successfuly Login " + rs.getString("usertype"));
                if (usertype.getSelectedIndex() == 0) {

                    Home admin = new Home();

                    admin.setVisible(true);
                    admin.setLocationRelativeTo(null);
                    dispose();
                    admin.inven_pro.setVisible(true);
                    admin.Casher.setVisible(false);
                    admin.report.setVisible(true);
                    admin.textlogin.setText(rs.getString("user"));
                    logIn_Out();

                } else if (usertype.getSelectedIndex() == 1) {
                    Home casher = new Home();

                    casher.setVisible(true);
                    casher.setLocationRelativeTo(null);
                    dispose();
                    casher.inven_pro.setVisible(false);
                    casher.report.setVisible(false);
                    casher.inven_stock.setVisible(false);
                    casher.textlogin.setText(rs.getString("user"));
                    logIn_Out();

                } else if (usertype.getSelectedIndex() == 2) {
                    Home inventory = new Home();

                    inventory.setVisible(true);
                    inventory.setLocationRelativeTo(null);
                    dispose();
                    inventory.inven_pro.setVisible(false);
                    inventory.report.setVisible(false);
                    inventory.Casher.setVisible(false);
                    inventory.textlogin.setText(rs.getString("user"));
                    logIn_Out();
                }
            } else {
                JOptionPane.showMessageDialog(this, "username and password do not matched");

            }
        } catch (Exception ex) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        head = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        usertype = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        log = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        footercolor = new javax.swing.JPanel();
        timeof = new javax.swing.JLabel();
        dateof = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 589));
        setSize(new java.awt.Dimension(900, 589));
        getContentPane().setLayout(null);

        head.setBackground(new java.awt.Color(255, 255, 0));
        head.setMaximumSize(new java.awt.Dimension(900, 100));
        head.setMinimumSize(new java.awt.Dimension(900, 100));
        head.setPreferredSize(new java.awt.Dimension(900, 100));
        head.setLayout(null);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/tttttttt.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        head.add(jLabel9);
        jLabel9.setBounds(0, 0, 410, 100);

        jLabel7.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 24)); // NOI18N
        jLabel7.setText("JAF'S ");
        head.add(jLabel7);
        jLabel7.setBounds(420, 10, 200, 50);

        jLabel10.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 36)); // NOI18N
        jLabel10.setText("BURGER ");
        head.add(jLabel10);
        jLabel10.setBounds(440, 40, 290, 50);

        getContentPane().add(head);
        head.setBounds(0, 0, 900, 100);

        panel.setBackground(new java.awt.Color(36, 37, 42));

        usertype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Casher" }));
        usertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertypeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Select user type");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("username");

        user.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user.setMaximumSize(new java.awt.Dimension(6, 23));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("password");

        pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass.setMaximumSize(new java.awt.Dimension(6, 23));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/icons8-user-100.png"))); // NOI18N

        log.setBackground(new java.awt.Color(255, 255, 255));
        log.setText("Login");
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Forgot password ?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(168, 168, 168))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        getContentPane().add(panel);
        panel.setBounds(230, 100, 420, 450);

        footercolor.setBackground(new java.awt.Color(255, 255, 0));
        footercolor.setMaximumSize(new java.awt.Dimension(900, 40));

        timeof.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timeof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        dateof.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout footercolorLayout = new javax.swing.GroupLayout(footercolor);
        footercolor.setLayout(footercolorLayout);
        footercolorLayout.setHorizontalGroup(
            footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footercolorLayout.createSequentialGroup()
                .addContainerGap(584, Short.MAX_VALUE)
                .addComponent(timeof, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
            .addGroup(footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footercolorLayout.createSequentialGroup()
                    .addContainerGap(745, Short.MAX_VALUE)
                    .addComponent(dateof, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );
        footercolorLayout.setVerticalGroup(
            footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timeof, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(footercolorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dateof, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        getContentPane().add(footercolor);
        footercolor.setBounds(0, 550, 900, 60);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/3.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 40, 900, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        login_form();
    }//GEN-LAST:event_logActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Please Contact your Administrator!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertypeActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel dateof;
    private javax.swing.JPanel footercolor;
    private javax.swing.JPanel head;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton log;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField pass;
    private static javax.swing.JLabel timeof;
    private javax.swing.JTextField user;
    private javax.swing.JComboBox<String> usertype;
    // End of variables declaration//GEN-END:variables
}
