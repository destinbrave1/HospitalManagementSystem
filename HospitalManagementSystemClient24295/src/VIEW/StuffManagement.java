/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.Department;
import SERVICE.StuffInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import MODEL.Stuff;
import SERVICE.DepartmentInterface;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author destin
 */
public class StuffManagement extends javax.swing.JFrame {
 DefaultTableModel tableModel = new DefaultTableModel();
    /**
     * Creates new form Stuff
     */
 Integer id =0;
    public StuffManagement() {
        initComponents();
        addFunctionItems();
        AddDepartmentToCombo();
        AddTableColumn();
        addRowData();
    }
    private void addFunctionItems()
    {
        FunctionCombo_stuff.removeAllItems();
        FunctionCombo_stuff.addItem(Functions.Doctor.toString());
        FunctionCombo_stuff.addItem(Functions.Nurse.toString());
        FunctionCombo_stuff.addItem(Functions.Receptionist.toString());
        FunctionCombo_stuff.addItem(Functions.Pharmacist.toString());
        FunctionCombo_stuff.addItem(Functions.Admin.toString());
    }

    public void AddDepartmentToCombo()
    {
        department_Combo.removeAllItems();
         try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        DepartmentInterface intf = (DepartmentInterface) registry.lookup("department");

        List<Department> department = intf.allDepartment();

        Iterator iterator = department.iterator();
            while(iterator.hasNext())
            {
                Department dep =(Department)iterator.next();
               
                    department_Combo.addItem(dep.getDep_name()); 
                        
            }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
     
  
    public void AddTableColumn()
    {
        tableModel.addColumn("Id");
        tableModel.addColumn("stuff id");
        tableModel.addColumn("Username");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone no");
        tableModel.addColumn("Department");
        tableModel.addColumn("Function");
        tableModel.addColumn("Password");
        tableModel.addColumn("Image Id");
        
        Table_stuffs.setModel(tableModel);
        
    }
    
   private void addRowData() {
    tableModel.setRowCount(0);

    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        StuffInterface intf = (StuffInterface) registry.lookup("stuffs");

        List<Stuff> stuffs = intf.allStuff();
        String department = null;
        for (Stuff obj : stuffs) {
             if (obj.getDepartment() != null) {
                department = obj.getDepartment() != null ? obj.getDepartment().getDep_name() : "";
                
            } else {
                department = "";
             }
           
            tableModel.addRow(new Object[]{
                    obj.getId(),
                    obj.getStuffId(),
                    obj.getStuffUsername(),
                    obj.getStuffEmail_address(),
                    obj.getStuffPhone_number(),
                    department,
                    obj.getStuffFunction(),
                    obj.getPassword(),
                    obj.getImage(),
            });
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Error in addRowData: " + e.getMessage());
    }
}

    private Department findDepartmentByName(String departmentName) {
    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        DepartmentInterface intf = (DepartmentInterface) registry.lookup("department");

        List<Department> departmentList = intf.allDepartment();

        for (Department department : departmentList) {
            if (department.getDep_name().equals(departmentName)) {
                return department;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return null; // Return null if the department is not found or an error occurs
}
private boolean isInteger(String input) {
    try {
        Integer.parseInt(input);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        UploadIMageBtn = new javax.swing.JButton();
        ImageP = new javax.swing.JLabel();
        ClearBtn = new javax.swing.JButton();
        AddUserbtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        National_id_stuff = new javax.swing.JTextField();
        usernameInp_stuff = new javax.swing.JTextField();
        email_stuff = new javax.swing.JTextField();
        Phone_stuff = new javax.swing.JTextField();
        FunctionCombo_stuff = new javax.swing.JComboBox<>();
        department_Combo = new javax.swing.JComboBox<>();
        password_stuff = new javax.swing.JPasswordField();
        RepeatPassword_stuff = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        Searchifinp = new javax.swing.JTextField();
        searchBtn_stuff = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_stuffs = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        UpdateUserbtn = new javax.swing.JButton();
        DeleteUserinput = new javax.swing.JButton();
        Gobackbtn = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel11.setText("STUFF MANAGEMENT");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/destin/Pictures/Project_Images/ICONS/user.resized.png")); // NOI18N
        jLabel1.setText("ACCOUNT CREATION");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(131, 170, 144));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        UploadIMageBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        UploadIMageBtn.setIcon(new javax.swing.ImageIcon("/home/destin/Pictures/Project_Images/ICONS/photo.resized.png")); // NOI18N
        UploadIMageBtn.setText("Upload");
        UploadIMageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadIMageBtnActionPerformed(evt);
            }
        });

        ImageP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ClearBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(162, 11, 11));
        ClearBtn.setText("CLEAR");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        AddUserbtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        AddUserbtn.setForeground(new java.awt.Color(165, 9, 9));
        AddUserbtn.setText("ADD USER");
        AddUserbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImageP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(UploadIMageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(AddUserbtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(ImageP, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(UploadIMageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddUserbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        jPanel5.setBackground(new java.awt.Color(138, 178, 152));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("National id no : ");

        jLabel3.setText("Username :");

        jLabel5.setText("Email address : ");

        jLabel6.setText("Function : ");

        jLabel7.setText("Phone_Number:");

        jLabel8.setText("Department");

        jLabel9.setText("Password :");

        jLabel10.setText("Repeat password :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(email_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameInp_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RepeatPassword_stuff)
                            .addComponent(National_id_stuff)
                            .addComponent(Phone_stuff)
                            .addComponent(FunctionCombo_stuff, 0, 260, Short.MAX_VALUE)
                            .addComponent(department_Combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password_stuff))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(National_id_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usernameInp_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(email_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Phone_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(FunctionCombo_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(department_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(password_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RepeatPassword_stuff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchBtn_stuff.setText("SEARCH");
        searchBtn_stuff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn_stuffActionPerformed(evt);
            }
        });

        Table_stuffs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_stuffs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_stuffsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_stuffs);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        UpdateUserbtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        UpdateUserbtn.setForeground(new java.awt.Color(193, 9, 9));
        UpdateUserbtn.setText("UPDATE");
        UpdateUserbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateUserbtnActionPerformed(evt);
            }
        });

        DeleteUserinput.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        DeleteUserinput.setForeground(new java.awt.Color(185, 5, 5));
        DeleteUserinput.setText("FIRE");
        DeleteUserinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUserinputActionPerformed(evt);
            }
        });

        Gobackbtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        Gobackbtn.setIcon(new javax.swing.ImageIcon("/home/destin/Pictures/Project_Images/ICONS/back.resized.png")); // NOI18N
        Gobackbtn.setText("GO BACK");
        Gobackbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GobackbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UpdateUserbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(DeleteUserinput, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Gobackbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateUserbtn)
                            .addComponent(DeleteUserinput)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Gobackbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(Searchifinp, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(searchBtn_stuff)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Searchifinp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn_stuff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UploadIMageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadIMageBtnActionPerformed
   JFileChooser chooser = new JFileChooser();
    int returnValue = chooser.showOpenDialog(null);

    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();
        String path = file.getAbsolutePath();

        try {
            BufferedImage bi = ImageIO.read(file);
            Image img = bi.getScaledInstance(230, 230, Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(img);
            ImageP.setIcon(ii);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(this, "No image selected.");
    }      
    }//GEN-LAST:event_UploadIMageBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
        // TODO add your handling code here:
         if(National_id_stuff.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Complete all input fields");
        }
        else if(usernameInp_stuff.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Complete all input fields");
        }
       
        else if(Phone_stuff.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Complete all input fields");
        }
     
        else if(password_stuff.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Complete all input fields");
        }
        else if(RepeatPassword_stuff.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Complete all input fields");
        }
       
        else
        {
            National_id_stuff.setText("");
            usernameInp_stuff.setText("");
           
            Phone_stuff.setText("");
            email_stuff.setText("");
            FunctionCombo_stuff.setSelectedItem(null);
            department_Combo.setSelectedItem(null);
            password_stuff.setText("");
            RepeatPassword_stuff.setText("");
            ImageP.setIcon(null);
        }                
                              

    }//GEN-LAST:event_ClearBtnActionPerformed

    private void AddUserbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserbtnActionPerformed
         
       if (National_id_stuff.getText().trim().isEmpty() ||
        usernameInp_stuff.getText().trim().isEmpty() ||
        department_Combo.getSelectedItem() == null ||
        Phone_stuff.getText().trim().isEmpty() ||
        password_stuff.getText().trim().isEmpty() ||
        RepeatPassword_stuff.getText().trim().isEmpty()) 
         {
        JOptionPane.showMessageDialog(this, "Complete all input fields ", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if(password_stuff.getText().trim().length() < 5)
    {
        JOptionPane.showMessageDialog(this, "password should be 5 characters or more ", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    if (!email_stuff.getText().endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(this, "Invalid email", "Email", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if(!isInteger(Phone_stuff.getText().trim())||
        Phone_stuff.getText().trim().length() != 10)
    {
        JOptionPane.showMessageDialog(this, "invalid phone number", "invalid", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!password_stuff.getText().trim().equals(RepeatPassword_stuff.getText())) {
        JOptionPane.showMessageDialog(this, "Passwords do not match", "Mismatch", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        StuffInterface intf = (StuffInterface) registry.lookup("stuffs");
        Stuff stuff = new Stuff();

        stuff.setStuffId(National_id_stuff.getText());
        stuff.setStuffUsername(usernameInp_stuff.getText());
        stuff.setStuffPhone_number(Phone_stuff.getText());
        stuff.setStuffEmail_address(email_stuff.getText());
        stuff.setPassword(password_stuff.getText());
        
        stuff.setStuffFunction(FunctionCombo_stuff.getSelectedItem().toString());
        String selectedDepartmentName = (String) department_Combo.getSelectedItem();
        Department selectedDepartment = findDepartmentByName(selectedDepartmentName);

        if (selectedDepartment != null) {
            stuff.setDepartment(selectedDepartment);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid department selected", "Department Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ImageIcon imageIcon = (ImageIcon) ImageP.getIcon();
            Image image = imageIcon.getImage();

            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics g = bufferedImage.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();

            // Convert the BufferedImage to a byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
            byte[] imageBytes = byteArrayOutputStream.toByteArray();

            // Set the imageBytes directly to the stuff object
            stuff.setImage(imageBytes);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error uploading image: " + e.getMessage(), "Image Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String feedback = intf.RegisterStuff(stuff);
        JOptionPane.showMessageDialog(this, feedback, "Success", JOptionPane.INFORMATION_MESSAGE);

        if (feedback != null) {
            National_id_stuff.setText("");
            usernameInp_stuff.setText("");
            email_stuff.setText("");
            Phone_stuff.setText("");
            password_stuff.setText("");
            RepeatPassword_stuff.setText("");
            ImageP.setIcon(null);
        }

        addRowData();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_AddUserbtnActionPerformed

    private void UpdateUserbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateUserbtnActionPerformed
    if(id!=0)
    {
        if(National_id_stuff.getText().trim().isEmpty() ||
        usernameInp_stuff.getText().trim().isEmpty() ||
        department_Combo.getSelectedItem() == null ||
        Phone_stuff.getText().trim().isEmpty() ||
        password_stuff.getText().trim().isEmpty() ||
        RepeatPassword_stuff.getText().trim().isEmpty() ||
        password_stuff.getText().trim().length() != 5) {
        JOptionPane.showMessageDialog(this, "Complete all input fields or check password length", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }

        if (!email_stuff.getText().endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Invalid email", "Email", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password_stuff.getText().trim().equals(RepeatPassword_stuff.getText())) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Mismatch", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
            StuffInterface intf = (StuffInterface) registry.lookup("stuffs");
            Stuff stuff = new Stuff();
            
            stuff.setId(id);
            
            stuff.setStuffId(National_id_stuff.getText());
            stuff.setStuffUsername(usernameInp_stuff.getText());
            stuff.setStuffPhone_number(Phone_stuff.getText());
            stuff.setStuffEmail_address(email_stuff.getText());
            stuff.setDepartment((Department) department_Combo.getSelectedItem());
            stuff.setStuffFunction(FunctionCombo_stuff.getSelectedItem().toString());
            try {
                BufferedImage image = ImageIO.read(new File(ImageP.getText()));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", byteArrayOutputStream);
                byte[] imageBytes = byteArrayOutputStream.toByteArray();
                 stuff.setImage(imageBytes);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error uploading image: " + e.getMessage(), "Image Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String feedback = intf.updateStuff(stuff);
            JOptionPane.showMessageDialog(this, feedback, "Updated successfully", JOptionPane.INFORMATION_MESSAGE);

            if (feedback != null) {
                id =0;
                addRowData();
                National_id_stuff.setText("");
                usernameInp_stuff.setText("");
                Phone_stuff.setText("");
                password_stuff.setText("");
                RepeatPassword_stuff.setText("");
                ImageP.setIcon(null);
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
       
    }//GEN-LAST:event_UpdateUserbtnActionPerformed

    private void DeleteUserinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteUserinputActionPerformed
      if(id!=0)
      {
          try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
           StuffInterface intf = (StuffInterface) registry.lookup("stuffs");
           
            Stuff object = new Stuff();
            
            object.setId(id);
            
            String feedback =intf.deleteStuff(object);
             
            if (feedback != null) {
                addRowData();
                JOptionPane.showMessageDialog(this, feedback, "Success", JOptionPane.INFORMATION_MESSAGE);
                National_id_stuff.setText("");
                usernameInp_stuff.setText("");
                email_stuff.setText("");
                Phone_stuff.setText("");
                password_stuff.setText("");
                id =0;
                
            } else {
                JOptionPane.showMessageDialog(this, "Stuff not found", "Fail", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
        
            
    }//GEN-LAST:event_DeleteUserinputActionPerformed

    private void GobackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GobackbtnActionPerformed
        // TODO add your handling code here:
        dispose();
        AdminHomePage home = new AdminHomePage();
        home.show();
    }//GEN-LAST:event_GobackbtnActionPerformed

    private void searchBtn_stuffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn_stuffActionPerformed
         
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
             StuffInterface intf = (StuffInterface) registry.lookup("stuffs");
           
            Stuff object = new Stuff();
            
            object.setStuffId(Searchifinp.getText());
            
            Stuff feedback =intf.getStuffsById(object);
             
            if (feedback != null) {
                National_id_stuff.setText(feedback.getStuffId());
                usernameInp_stuff.setText(feedback.getStuffUsername());
                email_stuff.setText(feedback.getStuffEmail_address());
                Phone_stuff.setText(feedback.getStuffPhone_number());
                password_stuff.setText(feedback.getPassword());
                RepeatPassword_stuff.setText(feedback.getPassword());
                department_Combo.setSelectedItem(feedback.getDepartment().getDep_name());
                FunctionCombo_stuff.setSelectedItem(feedback.getStuffFunction());
                
                tableModel.setRowCount(0);
                tableModel.addRow(new Object[]{
                feedback.getId(),
                feedback.getStuffId(),
                feedback.getStuffUsername(),
                feedback.getStuffEmail_address(),
                feedback.getStuffPhone_number(),
                feedback.getDepartment().getDep_name(),
                feedback.getStuffFunction(),
                feedback.getPassword(),
                feedback.getImage(),
                
                
               });
            }else {
                JOptionPane.showMessageDialog(this, "Stuff not found", "Fail", JOptionPane.ERROR_MESSAGE);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchBtn_stuffActionPerformed

    private void Table_stuffsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_stuffsMouseClicked

    String id = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 0).toString();
    String stuff_id = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 1).toString();
    String Username = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 2).toString();
    String Email = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 3).toString();
    String Phone_number = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 4).toString();
    String Department = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 5).toString();
    String Function = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 6).toString();
    String password = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 7).toString();
    String Image_id = tableModel.getValueAt(Table_stuffs.getSelectedRow(), 8).toString();
    
     
     National_id_stuff.setText(stuff_id);
     usernameInp_stuff.setText(Username);
     email_stuff.setText(Email);
     Phone_stuff.setText(Phone_number);
     department_Combo.setSelectedItem(Department);
     FunctionCombo_stuff.setSelectedItem(Function);
     password_stuff.setText(password);
     RepeatPassword_stuff.setText(password);
     ImageP.setIcon(null);
    
    }//GEN-LAST:event_Table_stuffsMouseClicked

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stuff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stuff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stuff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stuff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StuffManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserbtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton DeleteUserinput;
    private javax.swing.JComboBox<String> FunctionCombo_stuff;
    private javax.swing.JButton Gobackbtn;
    private javax.swing.JLabel ImageP;
    private javax.swing.JTextField National_id_stuff;
    private javax.swing.JTextField Phone_stuff;
    private javax.swing.JPasswordField RepeatPassword_stuff;
    private javax.swing.JTextField Searchifinp;
    private javax.swing.JTable Table_stuffs;
    private javax.swing.JButton UpdateUserbtn;
    private javax.swing.JButton UploadIMageBtn;
    private javax.swing.JComboBox<String> department_Combo;
    private javax.swing.JTextField email_stuff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPasswordField password_stuff;
    private javax.swing.JButton searchBtn_stuff;
    private javax.swing.JTextField usernameInp_stuff;
    // End of variables declaration//GEN-END:variables
}
