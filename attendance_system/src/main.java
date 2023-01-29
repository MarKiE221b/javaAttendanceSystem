
import com.formdev.flatlaf.intellijthemes.*;
import com.github.sarxos.webcam.*;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author SPRITE
 */
public class main extends javax.swing.JFrame implements Runnable,ThreadFactory{
    ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("attend.png"));
    
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private final Executor executor = Executors.newSingleThreadExecutor();
    
    java.sql.Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
<<<<<<< HEAD
    DefaultTableModel model;
    
=======
   
>>>>>>> 878534cee27c5716075a4402950eff2a2fcf74f6
    popup pop = new popup();
        
    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        currentTimeInit();
<<<<<<< HEAD
        time();
=======
        initWebcam();
>>>>>>> 878534cee27c5716075a4402950eff2a2fcf74f6
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rs_field = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendLog = new javax.swing.JTable();
        timeLabel = new javax.swing.JLabel();
        eventSelector = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        eventIDEntry = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        eventSubmit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        eventNameEntry1 = new javax.swing.JTextField();
        inAttend = new javax.swing.JRadioButton();
        outAttend = new javax.swing.JRadioButton();
        evtDate = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        urlText = new javax.swing.JTextField();
        userText = new javax.swing.JTextField();
        passText = new javax.swing.JTextField();
        connectDbs = new javax.swing.JButton();
        closeConnectDbs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Attendance System");
        setIconImage(logo.getImage());
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 360, 280));
        jPanel1.add(rs_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 160, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Entries"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        attendLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Event", "Student Name", "In", "Out", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(attendLog);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 450, 240));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 470, 270));

        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(timeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 160, 20));

        eventSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventSelectorActionPerformed(evt);
            }
        });
        jPanel1.add(eventSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 160, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Set event"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(eventIDEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, -1));

        jLabel1.setText("Event ID :");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        eventSubmit.setText("Submit");
        eventSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventSubmitActionPerformed(evt);
            }
        });
        jPanel4.add(eventSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jLabel3.setText("Event Name :");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel4.add(eventNameEntry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 220, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 250, 180));

        buttonGroup1.add(inAttend);
        inAttend.setSelected(true);
        inAttend.setText("In");
        jPanel1.add(inAttend, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        buttonGroup1.add(outAttend);
        outAttend.setText("Out");
        jPanel1.add(outAttend, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));
        jPanel1.add(evtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 160, 30));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Connection"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("URL :");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 27, -1, -1));

        jLabel4.setText("USER :");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 55, -1, -1));

        jLabel5.setText("PASSWORD :");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 83, -1, -1));
        jPanel6.add(urlText, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 24, 284, -1));
        jPanel6.add(userText, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 52, 284, -1));
        jPanel6.add(passText, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 80, 284, -1));

        connectDbs.setBackground(new java.awt.Color(153, 204, 255));
        connectDbs.setForeground(new java.awt.Color(255, 255, 255));
        connectDbs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/global-network (3).png"))); // NOI18N
        connectDbs.setText("Connect");
        connectDbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectDbsActionPerformed(evt);
            }
        });
        jPanel6.add(connectDbs, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        closeConnectDbs.setBackground(new java.awt.Color(255, 153, 153));
        closeConnectDbs.setForeground(new java.awt.Color(255, 255, 255));
        closeConnectDbs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unlink (3).png"))); // NOI18N
        closeConnectDbs.setText("Close Connection");
        closeConnectDbs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConnectDbsActionPerformed(evt);
            }
        });
        jPanel6.add(closeConnectDbs, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eventSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventSelectorActionPerformed

    private void eventSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventSubmitActionPerformed
        String evt_ID = eventIDEntry.getText();
        String evt_Name = eventNameEntry1.getText();
        
        if(!evt_ID.isBlank() && !evt_Name.isBlank()){
            try{
<<<<<<< HEAD
                String insertQuery = "INSERT INTO event(event_ID, event_Name) VALUES (?,?)";
                pst = conn.prepareStatement(insertQuery);
                pst.setString(1, evt_ID);
                pst.setString(2, evt_Name);

                pst.execute();
            }catch(SQLException ex){
                System.out.print(ex);
            }
            eventIDEntry.setText("");
            eventNameEntry1.setText("");

            JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED!", "ADDED!", JOptionPane.INFORMATION_MESSAGE);

            addValueToComboBox();
        }else{
            JOptionPane.showMessageDialog(null, "EMPTY VALUES PLEASE ADD!", "CAUTION!", JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_eventSubmitActionPerformed

    private void connectDbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectDbsActionPerformed
        if(!urlText.getText().isBlank()&& !userText.getText().isBlank()){
            dbsConnect();
        }else{
            JOptionPane.showMessageDialog(null, "EMPTY VALUES PLEASE ADD!", "CAUTION!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_connectDbsActionPerformed

    private void closeConnectDbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConnectDbsActionPerformed
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
                webcam.close();
                eventSelector.removeAllItems();
                clearTable();
                urlText.setText("");
                userText.setText("");
                passText.setText("");
                JOptionPane.showMessageDialog(null, "SUCCESSFULLY DISCONNECTED", "DISCONNECT", JOptionPane.INFORMATION_MESSAGE);
            }else
                JOptionPane.showMessageDialog(null, "DBS NOT CONNECTED CAN'T DISCONNECT", "ALERT", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error\n\n" + e, "ERROR", JOptionPane.WARNING_MESSAGE);
        }
             
        
        
        
    }//GEN-LAST:event_closeConnectDbsActionPerformed

=======
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancesystem","root", "");

                String insertQuery = "INSERT INTO event(event_ID, event_Name) VALUES (?,?)";
                pst = conn.prepareStatement(insertQuery);
                pst.setString(1, evt_ID);
                pst.setString(2, evt_Name);

                pst.execute();

                conn.close();
            }catch(SQLException ex){
                System.out.print(ex);
            }
            eventIDEntry.setText("");
            eventNameEntry1.setText("");

            JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED!", "CAUTION!", JOptionPane.INFORMATION_MESSAGE);

            addValueToComboBox();
        }else{
            JOptionPane.showMessageDialog(null, "EMPTY VALUES PLEASE ADD!", "ADDED!", JOptionPane.WARNING_MESSAGE);
        }   
    }//GEN-LAST:event_eventSubmitActionPerformed

>>>>>>> 878534cee27c5716075a4402950eff2a2fcf74f6
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            FlatGrayIJTheme.setup();
        } catch (Exception e) {
<<<<<<< HEAD
        }
        java.awt.EventQueue.invokeLater(() -> {
            new main().setVisible(true);
=======
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
>>>>>>> 878534cee27c5716075a4402950eff2a2fcf74f6
        });
    }
    
    private void dbsConnect(){
        try {
            conn = DriverManager.getConnection(urlText.getText(),userText.getText(), passText.getText());
            initWebcam();
            addValueToComboBox();
            displayData();
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY CONNECTED", "LINKED", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Can't connect to database\n\n" + e, "DENIED", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void initWebcam(){
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(1);
        webcam.setViewSize(size);
        
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        
        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,360,280));
        executor.execute(this);
    }
    
    private void validateInsert(){
        String dateVar = sdf.format(evtDate.getDate());
        try {
            String sqlQuery = "SELECT * FROM attendance WHERE student_ID = ? AND event_ID = ? AND date = ?";
            pst = conn.prepareStatement(sqlQuery);
            
            pst.setString(1, rs_field.getText());
            pst.setString(2, eventSelector.getSelectedItem().toString());
            pst.setString(3, dateVar);
            
            rs = pst.executeQuery();
            
            if(!rs.next()){
                if(inAttend.isSelected()){
                    insertAttendVal();
                }
            }else{
                if(outAttend.isSelected() && rs.getString("attend_Out") == null){
                    updateAttendVal();
                }
            }
        } catch (SQLException e) {
        }
    }
        
    private void insertAttendVal(){
        String dateVar = sdf.format(evtDate.getDate());
        pop.show();
        pop.timerDispose();
        try {
            String insertQuery = "INSERT INTO attendance(event_ID, student_ID, attend_In, date) VALUES (?,?,?,?);";
            pst = conn.prepareStatement(insertQuery);
            pst.setString(1, eventSelector.getSelectedItem().toString());
            pst.setString(2, rs_field.getText());
            pst.setString(3, timeLabel.getText());
            pst.setString(4, dateVar);
            pst.execute();
        } catch (SQLException e) {

        }
        displayData();
    }    
    
    private void updateAttendVal(){
        String dateVar = sdf.format(evtDate.getDate());
        pop.show();
        pop.timerDispose();
        try {
            String insertQuery = "UPDATE attendance SET attend_Out= ? WHERE event_ID = ? AND student_ID = ? AND date = ?";
            pst = conn.prepareStatement(insertQuery);
            pst.setString(1, timeLabel.getText());
            pst.setString(2, eventSelector.getSelectedItem().toString());
            pst.setString(3, rs_field.getText());
            pst.setString(4, dateVar);
            pst.executeUpdate();
<<<<<<< HEAD
=======

            conn.close();
>>>>>>> 878534cee27c5716075a4402950eff2a2fcf74f6
        } catch (SQLException e) {

        }
        displayData();
    }
    
    private void studScanValidate(){
        try {
            String getQuery = "SELECT * FROM students WHERE student_ID = ?";
            
            pst = conn.prepareStatement(getQuery);
            
            pst.setString(1, rs_field.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                pop.setLblEntries(rs.getString("student_ID"), rs.getString("student_Name"), rs.getString("course"), rs.getString("yr"));
                validateInsert();
            }
        } catch (SQLException e) {
        }
    }
    
    private void clearTable(){
        model = (DefaultTableModel)attendLog.getModel();
        model.setRowCount(0);
    }
    
    private void displayData(){
        try {
            Statement stmt = conn.createStatement();
            String getQuery = "SELECT attendance_ID, event_ID, students.student_Name, attend_In, attend_Out, date FROM attendance, students WHERE attendance.student_ID = students.student_ID";
            rs = stmt.executeQuery(getQuery);
            clearTable();
            while(rs.next()){
                model.addRow(new String[]{rs.getString("attendance_ID"), rs.getString("event_ID"), rs.getString("students.student_Name"), rs.getString("attend_In"), rs.getString("attend_Out"), rs.getString("date")});
            }
        } catch (SQLException e) {
        }
    }
    
    private void currentTimeInit(){
        evtDate.getJCalendar().setMinSelectableDate(new Date());
        evtDate.setDate(new Date());
    }
    
    private void addValueToComboBox(){
        try{
<<<<<<< HEAD
=======
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendancesystem","root", "");
>>>>>>> 878534cee27c5716075a4402950eff2a2fcf74f6
            Statement stmt = conn.createStatement();
            
            String getQuery = "SELECT * FROM event;";
            rs = stmt.executeQuery(getQuery);
            
            eventSelector.removeAllItems();
            
            while(rs.next()){
                String dataRow = rs.getString("event_ID");
                eventSelector.addItem(dataRow);
            }
<<<<<<< HEAD
=======
            conn.close();
>>>>>>> 878534cee27c5716075a4402950eff2a2fcf74f6
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    //timer
    Timer t;
    SimpleDateFormat st;
    private void time(){
        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
               
               Date dt = new Date();
               st = new SimpleDateFormat("hh:mm:ss a");
               
               String tt = st.format(dt);
               timeLabel.setText(tt);
            }
        });
        t.start();
    }
    
    @Override
    public void run(){
       do {  
            Result result = null;
            BufferedImage image  = null;
            
            if(webcam.isOpen() || webcam.close()){
                if((image = webcam.getImage()) == null){
                    continue;
                }
            }
            
            LuminanceSource src = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(src));
            
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(result != null){
                rs_field.setText(result.getText());
                studScanValidate();
            }
            
        } while (true);
    }
    
    @Override
    public Thread newThread(Runnable r){
        Thread THREAD = new Thread(r, "My Thread");
        THREAD.setDaemon(true);
        return THREAD;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendLog;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeConnectDbs;
    private javax.swing.JButton connectDbs;
    private javax.swing.JTextField eventIDEntry;
    private javax.swing.JTextField eventNameEntry1;
    private javax.swing.JComboBox<String> eventSelector;
    private javax.swing.JButton eventSubmit;
    private com.toedter.calendar.JDateChooser evtDate;
    private javax.swing.JRadioButton inAttend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton outAttend;
    private javax.swing.JTextField passText;
    private javax.swing.JTextField rs_field;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField urlText;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables
}
