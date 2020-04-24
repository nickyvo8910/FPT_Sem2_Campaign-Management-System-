/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Entity.Advertisement;
import Kernel.AdPC;

import Kernel.CommonConnection;
import Kernel.ProductPC;
import Kernel.Validation;
import Kernel.dataPC;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Asus
 */
public class AdvertisementManagement extends javax.swing.JFrame {
    dataPC conn;
    int row =0;
    int dateStt=0;
    int per=0;
    boolean clickable = true;
    Vector fieldData;
    
    Vector fieldName;
    DefaultTableModel model;
    public static PreparedStatement ps;
    public static ResultSet rs=null;
    
   
    /**
     * Creates new form AdvertisementManagement
     */
    public AdvertisementManagement() {
        initComponents();   
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("CIS-Advertisement Management");
        this.setSize(660, 610);
        this.setResizable(false);
         loadDataToTable();
         reset();
    }
   
    private Advertisement getAdvertisement()
    {
        Advertisement ad= new Advertisement();
        
        ad.setAdID(txt_AdID.getText().trim());
        ad.setAdType(txt_AdType.getText().trim());
        ad.setAdPrice(Float.parseFloat(txt_AdPrice.getText().trim()));
        ad.setAdPartner(txt_AdPartner.getText().trim());
        ad.setDescription(txt_AdDes.getText().trim());
        
        
        return ad;
    }
    
    private void reset()
    {
        loadDataToTable();
        Validation.setBlankField(new JTextComponent[]{txtFind,txt_AdID,txt_AdType,txt_AdPrice,txt_AdPartner,txt_AdDes});
        txtFind.setEnabled(true);
        txt_AdID.setEnabled(false);
        txt_AdType.setEnabled(false);
        txt_AdPrice.setEnabled(false);
        txt_AdPartner.setEnabled(false);
        txt_AdDes.setEnabled(false);
        
        btnFind.setEnabled(true);
        btnDelete.setEnabled(true);
        btnIns.setEnabled(true);
        btnIns.setText("Create");
        btnUpdate.setEnabled(true);
        btnUpdate.setText("Update");
        btnRefresh.setEnabled(true);
        
        txt_AdID.setEditable(true);
        txt_AdType.setEditable(true);
        txt_AdPrice.setEditable(true);
        txt_AdPartner.setEditable(true);
        txt_AdDes.setEditable(true);
        clickable = true;
        row =0;
        dateStt=0;
        per=0;
    }

     private void loadDataToTable()
    {
        Vector tit=new Vector();
        tit.add("ID");
        tit.add("Type");
        tit.add("Price");
        tit.add("Partner");
        tit.add("Description");
        Vector data=AdPC.readAdvertisement();
        tb_Ad.setModel(new DefaultTableModel(data, tit));
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
        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        rd_Type = new javax.swing.JRadioButton();
        rd_ID = new javax.swing.JRadioButton();
        btnIns = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Ad = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_AdID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_AdType = new javax.swing.JTextField();
        txt_AdPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_AdPartner = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_AdDes = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Advertisement Master");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));
        getContentPane().add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 140, -1));

        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnSearch.png"))); // NOI18N
        btnFind.setText("Find");
        btnFind.setMaximumSize(new java.awt.Dimension(95, 29));
        btnFind.setMinimumSize(new java.awt.Dimension(95, 29));
        btnFind.setPreferredSize(new java.awt.Dimension(95, 29));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        buttonGroup1.add(rd_Type);
        rd_Type.setText(" Ad Type");
        rd_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_TypeActionPerformed(evt);
            }
        });
        getContentPane().add(rd_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        buttonGroup1.add(rd_ID);
        rd_ID.setSelected(true);
        rd_ID.setText("Ad ID");
        rd_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_IDActionPerformed(evt);
            }
        });
        getContentPane().add(rd_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        btnIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnInsert.png"))); // NOI18N
        btnIns.setText("Create");
        btnIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsActionPerformed(evt);
            }
        });
        getContentPane().add(btnIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 95, -1));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnUpdate.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 95, -1));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnDelete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 95, -1));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnRefresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, -1, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnExit.png"))); // NOI18N
        btnExit.setText("Close");
        btnExit.setMaximumSize(new java.awt.Dimension(95, 29));
        btnExit.setMinimumSize(new java.awt.Dimension(95, 29));
        btnExit.setPreferredSize(new java.awt.Dimension(95, 29));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Advertisement List"));

        tb_Ad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "AdID", "AdType", "AdPrice", "AdPartner", "AdDes"
            }
        ));
        tb_Ad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_AdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Ad);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel2.setText("Advertisement ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));
        getContentPane().add(txt_AdID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 226, -1));

        jLabel3.setText("Advertisement Type:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));
        getContentPane().add(txt_AdType, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 226, -1));
        getContentPane().add(txt_AdPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 110, -1));

        jLabel4.setText("Advertisement Price:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));
        getContentPane().add(txt_AdPartner, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 226, -1));

        jLabel5.setText("Advertisement Partner:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, -1));

        txt_AdDes.setColumns(20);
        txt_AdDes.setRows(5);
        jScrollPane2.setViewportView(txt_AdDes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 226, -1));

        jLabel6.setText("Description:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jLabel31.setText("$");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, 20));

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("(*)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("(*)");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("(*)");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("(*)");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("(*)");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bgTemplete.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
            if(evt.getActionCommand().equals("Update")){
            if (tb_Ad.getSelectedRow() == -1) {
            new ShowMessageDialog(null, true, "Please choose a row",  ShowMessageDialog.MESSAGE);
            return;
            }else{
            clickable = false;
            btnUpdate.setText("Save");
            //Deactivate buttons
            btnDelete.setEnabled(false);
            btnFind.setEnabled(false);
            btnRefresh.setEnabled(true);
            btnIns.setEnabled(false);
            //Activate Edit for textbox and combobox and checkbox
            txtFind.setEnabled(false);
            txt_AdID.setEnabled(false);
            txt_AdType.setEnabled(true);
            txt_AdPrice.setEnabled(true);
            txt_AdPartner.setEnabled(true);
            txt_AdDes.setEnabled(true);
                  
            //Activate Edit for textbox and combobox and checkbox
            //Set marsk for CAMPID
             }
        }
        if(evt.getActionCommand().equals("Save")){
            if(!Validation.validateComponents(new JTextComponent[]{txt_AdType,txt_AdPrice,txt_AdPartner,txt_AdDes}))
        {
            return;
        }
            if(((txt_AdID.getText().trim()).length()>10))
        {
            Validation.showMess("Advertisement ID is restricted to 10 characters");
            txt_AdID.requestFocus();
            txt_AdID.setBackground(new Color(255,153,153));
            return;
        }
        if(((txt_AdType.getText().trim()).length()>30))
        {
            Validation.showMess("Advertisement Type is restricted to 30 characters");
            txt_AdType.requestFocus();
            txt_AdType.setBackground(new Color(255,153,153));
            return;
        }
            if(!Validation.isFloat(txt_AdPrice.getText().trim())){
            Validation.showMess("Only Float Value is Allowed");
            txt_AdPrice.setBackground(new Color(255,153,153));
            txt_AdPrice.requestFocus();
            return;
        }
           else if((Float.parseFloat(txt_AdPrice.getText().trim())>100000)||(Float.parseFloat(txt_AdPrice.getText().trim())<0)){
            
            Validation.showMess("Price must be in between of 0 and 100000");
            txt_AdPrice.setBackground(new Color(255,153,153));
            txt_AdPrice.requestFocus();
            return;
        }
            if(((txt_AdPartner.getText().trim()).length()>30))
        {
            Validation.showMess("Advertisement Partner is restricted to 30 characters");
            txt_AdPartner.requestFocus();
            txt_AdPartner.setBackground(new Color(255,153,153));
            return;
        }
        if(((txt_AdDes.getText().trim()).length()>150))
        {
            Validation.showMess("Advertisement Description is restricted to 150 characters");
            txt_AdDes.requestFocus();
            txt_AdDes.setBackground(new Color(255,153,153));
            return;
        }
       
        String mess=AdPC.updateAdvertisement(getAdvertisement());
        new ShowMessageDialog(null, true, mess, ShowMessageDialog.MESSAGE);
        btnUpdate.setText("Update");
        //clickable = true;
        //Reactivate buttons
        
        reset();
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsActionPerformed
        // TODO add your handling code here:
          if(evt.getActionCommand().equals("Create")){
            reset();
            clickable = false;
            btnIns.setText("Save");
            //Deactivate buttons
            btnDelete.setEnabled(false);
            btnFind.setEnabled(false);
            btnRefresh.setEnabled(true);
            btnUpdate.setEnabled(false);
            
            //Activate Edit for textbox and combobox and checkbox
            txtFind.setEnabled(false);
            txt_AdID.setEnabled(true);
            txt_AdType.setEnabled(true);
            txt_AdPrice.setEnabled(true);
            txt_AdPartner.setEnabled(true);
            txt_AdDes.setEnabled(true);
            
            
            }
            
        if(evt.getActionCommand().equals("Save")){   
        if(!Validation.validateComponents(new JTextComponent[]{txt_AdID,txt_AdType,txt_AdPrice,txt_AdPartner,txt_AdDes}))
        {
            return;
        }
        if(((txt_AdID.getText().trim()).length()>10))
        {
            Validation.showMess("Advertisement ID is restricted to 10 characters");
            txt_AdID.requestFocus();
            txt_AdID.setBackground(new Color(255,153,153));
            return;
        }
        if(((txt_AdType.getText().trim()).length()>30))
        {
            Validation.showMess("Advertisement Type is restricted to 30 characters");
            txt_AdType.requestFocus();
            txt_AdType.setBackground(new Color(255,153,153));
            return;
        }
        if(!Validation.isFloat(txt_AdPrice.getText().trim())){
            Validation.showMess("Only Float Value is Allowed");
            txt_AdPrice.setBackground(new Color(255,153,153));
            txt_AdPrice.requestFocus();
            return;
        }
        else if((Float.parseFloat(txt_AdPrice.getText().trim())>100000)||(Float.parseFloat(txt_AdPrice.getText().trim())<0)){
            
            Validation.showMess("Price must be in between of 0 and 100000");
            txt_AdPrice.setBackground(new Color(255,153,153));
            txt_AdPrice.requestFocus();
            return;
        }
        if(((txt_AdPartner.getText().trim()).length()>30))
        {
            Validation.showMess("Advertisement Partner is restricted to 30 characters");
            txt_AdPartner.requestFocus();
            txt_AdPartner.setBackground(new Color(255,153,153));
            return;
        }
        if(((txt_AdDes.getText().trim()).length()>150))
        {
            Validation.showMess("Advertisement Description is restricted to 150 characters");
            txt_AdDes.requestFocus();
            txt_AdDes.setBackground(new Color(255,153,153));
            return;
        }
        String mess=AdPC.insertAdvertisement(getAdvertisement());
        new ShowMessageDialog(null, true, mess, ShowMessageDialog.MESSAGE);
        btnIns.setText("Create");
        reset();
        loadDataToTable();
        }
    }//GEN-LAST:event_btnInsActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        
        int ByID=1;
        int ByType=2;
        Vector vt;
        if(Validation.isEmpty(txtFind.getText()))
        {
            Validation.showMess("Please enter any words to find");
            txtFind.requestFocus();
            txtFind.setBackground(new Color(255,153,153));
            return;
        }
        if(rd_ID.isSelected())
        {
            vt=AdPC.FindAdvertisement(txtFind.getText(), ByID);
        }
        else
        {
            vt=AdPC.FindAdvertisement(txtFind.getText(), ByType);
        }
        Vector tit=new Vector();
        tit.add("AdID");
        tit.add("AdType");
        tit.add("AdPrice");
        tit.add("AdPartner");
        tit.add("AdDes");
       
        tb_Ad.setModel(new DefaultTableModel(vt, tit));
        txtFind.setText("");
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
                if(tb_Ad.getSelectedRow()==-1)
        {
            new ShowMessageDialog(null, true,"Please chose a row",ShowMessageDialog.MESSAGE);
            return;
        }
        new ShowMessageDialog(null, true,"<html><Center>Do you really want delete this AD ?<br>All campaign associate with this AD will be deleted as well</Center></html>",ShowMessageDialog.CONFIRM);
        if(ShowMessageDialog.STATUS==ShowMessageDialog.OK)
        {
           String mess= AdPC.deleteAdvertisement(txt_AdID.getText());
           new ShowMessageDialog(null, true, mess, ShowMessageDialog.MESSAGE);
           loadDataToTable();
           reset();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
       reset();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void tb_AdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_AdMouseClicked
        // TODO add your handling code here:
          if(clickable == true){
            row = tb_Ad.getSelectedRow();
        //boolean fn=false;
         
        if(row!=-1){
            
            txt_AdID.setText(""+tb_Ad.getValueAt(row, 0));
            txt_AdType.setText(""+tb_Ad.getValueAt(row, 1));
            txt_AdPrice.setText(""+tb_Ad.getValueAt(row, 2));
            txt_AdPartner.setText(""+tb_Ad.getValueAt(row, 3));
            txt_AdDes.setText(""+tb_Ad.getValueAt(row, 4));
           
            }
        }    
    }//GEN-LAST:event_tb_AdMouseClicked

    private void rd_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_TypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_TypeActionPerformed

    private void rd_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_IDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnIns;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rd_ID;
    private javax.swing.JRadioButton rd_Type;
    private javax.swing.JTable tb_Ad;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextArea txt_AdDes;
    private javax.swing.JTextField txt_AdID;
    private javax.swing.JTextField txt_AdPartner;
    private javax.swing.JTextField txt_AdPrice;
    private javax.swing.JTextField txt_AdType;
    // End of variables declaration//GEN-END:variables

    
}
