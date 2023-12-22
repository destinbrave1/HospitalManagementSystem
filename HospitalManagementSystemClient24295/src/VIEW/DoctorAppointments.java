/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.Appointments;
import MODEL.Department;
import MODEL.Discharged;
import MODEL.Appointments;
import MODEL.Rooms;
import MODEL.Transfered;
import SERVICE.DepartmentInterface;
import SERVICE.DischargedInterface;
import SERVICE.AppointmentsInterface;
import SERVICE.RoomInterface;
import SERVICE.TransferedInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author destin
 */
public class DoctorAppointments extends javax.swing.JFrame {
DefaultTableModel tableModel = new DefaultTableModel();
  Integer id =0;
    /**
     * Creates new form Appointments
     */
    public DoctorAppointments() {
        initComponents();
        AddTableColumn();
        AddTableRow();
        AddDepartmentToCombo();
        AddRoomsToCombo();
    }
    
       public void AddTableColumn()
            
    {
        tableModel.addColumn("Id");
        tableModel.addColumn("National id");
        tableModel.addColumn("Name");
        tableModel.addColumn("Date of birth");
        tableModel.addColumn("Sickness");
        tableModel.addColumn("Paid");
        tableModel.addColumn("Department");
        tableModel.addColumn("Room");
        tableModel.addColumn("phone no");
        tableModel.addColumn("Date in");
        
        AppointmentTable.setModel(tableModel);
        
    }
    public void AddDepartmentToCombo()
    {
       
        department_Combo.removeAllItems();
        try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        DepartmentInterface intf = (DepartmentInterface) registry.lookup("department");

        List<Department> departmentS = intf.allDepartment();

        Iterator iterator = departmentS.iterator();
        String department = null;
            while(iterator.hasNext())
            {
                Department dep =(Department)iterator.next();
                
                    department_Combo.addItem(dep.getDep_name()); 
                        
            }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
    public void AddRoomsToCombo()
    {
       
        Room_Combo.removeAllItems();
        try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
         RoomInterface intf = (RoomInterface) registry.lookup("rooms");

         List<Rooms> rooms = intf.allRooms();

        Iterator iterator = rooms.iterator();
       
            while(iterator.hasNext())
            {
                Rooms rm =(Rooms)iterator.next();
                
                    Room_Combo.addItem(rm.getRoom_no()); 
                        
            }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
        public void AddTableRow()
    {
        tableModel.setRowCount(0);

    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        AppointmentsInterface intf = (AppointmentsInterface) registry.lookup("appointment");

        List<Appointments> inp = intf.allAppointments();
        String department = null;
        String room =null;
        for (Appointments obj : inp) {
            if (obj.getDepartment() != null || obj.getRoom() != null) {
                department = obj.getDepartment() != null ? obj.getDepartment().getDep_name() : "";
                room = obj.getRoom() != null ? obj.getRoom().getRoom_no() : "";
            } else {
                department = "";
                room = "";
            }
            tableModel.addRow(new Object[]{
                obj.getId(),
                obj.getPatient_national_id(),
                obj.getInpatient_name(),
                obj.getDate_of_birth(),
                obj.getInpatient_sickness(),
                obj.getInpatient_amount_paid(),
                department,
                room,
                obj.getInpatient_phone_number(),
                obj.getInpatient_date_in(),
            });
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    }
          private Department findDepartmentByName(String depName) {
    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        DepartmentInterface depIntf = (DepartmentInterface) registry.lookup("department");

        List<Department> departmentList = depIntf.allDepartment();

        for (Department dep : departmentList) {
            if (dep.getDep_name().equals(depName)) {
                return dep;
            }
        }

        return null; // Department not found
    } catch (Exception e) {
        e.printStackTrace();
        return null; // Handle the exception accordingly
    }
}
    private Rooms findRoomByName(String roomName) {
    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        RoomInterface roomIntf = (RoomInterface) registry.lookup("rooms");

        List<Rooms> roomList = roomIntf.allRooms();

        for (Rooms room : roomList) {
            if (room.getRoom_no().equals(roomName)) {
                return room;
            }
        }

        return null; // Room not found
    } catch (Exception e) {
        e.printStackTrace();
        return null; // Handle the exception accordingly
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
        jScrollPane1 = new javax.swing.JScrollPane();
        AppointmentTable = new javax.swing.JTable();
        CUREbtn = new javax.swing.JButton();
        TRANSFERBTN = new javax.swing.JButton();
        Gobackbtn1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idInpt = new javax.swing.JTextField();
        nameInpt = new javax.swing.JTextField();
        DateoFbithINpatientCombo = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SicknessInp = new javax.swing.JTextField();
        AmountINp = new javax.swing.JTextField();
        department_Combo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Room_Combo = new javax.swing.JComboBox<>();
        phoneINp = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        SeachBtn = new javax.swing.JButton();
        SearchInp = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        PatientHistory = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        AppointmentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(AppointmentTable);

        CUREbtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        CUREbtn.setForeground(new java.awt.Color(221, 42, 42));
        CUREbtn.setIcon(new javax.swing.ImageIcon("/home/destin/Pictures/Project_Images/ICONS/pill.resized.png")); // NOI18N
        CUREbtn.setText("CURE");
        CUREbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CUREbtnActionPerformed(evt);
            }
        });

        TRANSFERBTN.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        TRANSFERBTN.setIcon(new javax.swing.ImageIcon("/home/destin/Pictures/Project_Images/ICONS/transfer.resized.png")); // NOI18N
        TRANSFERBTN.setText("TRANSFER");
        TRANSFERBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRANSFERBTNActionPerformed(evt);
            }
        });

        Gobackbtn1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        Gobackbtn1.setIcon(new javax.swing.ImageIcon("/home/destin/Pictures/Project_Images/ICONS/back.resized.png")); // NOI18N
        Gobackbtn1.setText("GO BACK");
        Gobackbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Gobackbtn1ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setText("Name :");

        jLabel16.setText("Id card :");

        jLabel2.setText("Date of birth :");

        jLabel3.setText("Sickness:");

        jLabel20.setText("Amount");

        jLabel4.setText("Department");

        jLabel18.setText("Room no:");

        jLabel19.setText("Phone:");

        Room_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Room_ComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel17)
                        .addComponent(jLabel16)))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idInpt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(DateoFbithINpatientCombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(nameInpt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(79, 79, 79)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(SicknessInp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel19))
                            .addComponent(department_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phoneINp, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(AmountINp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel18)
                        .addGap(27, 27, 27)
                        .addComponent(Room_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(249, 249, 249))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idInpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SicknessInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)
                                    .addComponent(phoneINp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameInpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(Room_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(AmountINp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(department_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(DateoFbithINpatientCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        SeachBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        SeachBtn.setForeground(new java.awt.Color(235, 65, 65));
        SeachBtn.setText("SEARCH/ID");
        SeachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeachBtnActionPerformed(evt);
            }
        });

        SearchInp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchInpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(SearchInp, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(SeachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeachBtn)
                    .addComponent(SearchInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Gobackbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TRANSFERBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CUREbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Gobackbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TRANSFERBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CUREbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(99, 99, 99))
        );

        jPanel2.setBackground(new java.awt.Color(104, 219, 158));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Yrsa Light", 1, 15)); // NOI18N
        jLabel1.setText("DOCTORS APPOINTMENTS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(509, 509, 509)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel3.setBackground(new java.awt.Color(97, 208, 151));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Patients");

        PatientHistory.setText("History");
        PatientHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientHistoryActionPerformed(evt);
            }
        });
        jMenu1.add(PatientHistory);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PatientHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientHistoryActionPerformed

       
        PatientHistory transfers_discharged = new PatientHistory();
        transfers_discharged.show();
         dispose();
    }//GEN-LAST:event_PatientHistoryActionPerformed

    private void Gobackbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Gobackbtn1ActionPerformed
           
        DoctorHomepage doctors= new DoctorHomepage();
        doctors.show();
        dispose();
    }//GEN-LAST:event_Gobackbtn1ActionPerformed

    private void CUREbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CUREbtnActionPerformed
        if(id!=0)
        {
          try {
            Registry registryAppointment = LocateRegistry.getRegistry("127.0.0.1", 6000);
            AppointmentsInterface intf = (AppointmentsInterface)registryAppointment.lookup("appointment");
            
            Registry registryDischarged = LocateRegistry.getRegistry("127.0.0.1", 6000);
            DischargedInterface intfs = (DischargedInterface)registryDischarged.lookup("discharge");
            
            Discharged inp = new Discharged();
            
            
           inp.setPatient_national_id(idInpt.getText());
           inp.setInpatient_name(nameInpt.getText());
        
           SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
         Date selectedDate = DateoFbithINpatientCombo.getDate();
         String formattedDate = dateFormat.format(selectedDate);

        inp.setDate_of_birth(formattedDate);
        inp.setInpatient_sickness(SicknessInp.getText());
        inp.setInpatient_amount_paid(AmountINp.getText());
       
        String selectedDepartmentName = String.valueOf(department_Combo.getSelectedItem());

        // Find the Department object by name
        Department selectedDepartment = findDepartmentByName(selectedDepartmentName);

        if (selectedDepartment != null) {
            inp.setDepartment(selectedDepartment);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid department selected", "Department Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
         Object selectedRoom = Room_Combo.getSelectedItem();

        // Find the Room object by name
        Rooms selectedRoomObject = findRoomByName(String.valueOf(selectedRoom));
       
        if (selectedRoomObject != null) {
            inp.setRoom(selectedRoomObject);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid room selected", "Room Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
         inp.setInpatient_phone_number(phoneINp.getText());
          
        int userChoice = JOptionPane.showConfirmDialog(this,"is patient cured?",
        "Confirmation",JOptionPane.YES_NO_OPTION);
        
        if (userChoice == JOptionPane.YES_OPTION) {
         
           String feedback = intfs.Registerdischarged(inp);   
         
            if(feedback!=null)
            {

               JOptionPane.showMessageDialog(this, feedback);
                    Appointments model = new Appointments();
                    model.setId(id);

                    String pt = intf.deleteAppointments(model);
                    id =0;
                    AddTableRow(); 
                  
                  
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Discharge process failed","failure",JOptionPane.ERROR_MESSAGE);
            }
                
         }
        
          
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
           
          
        }
         else
        {
            JOptionPane.showMessageDialog(this, "User is not available");
        }
        
        
      
    }//GEN-LAST:event_CUREbtnActionPerformed

    private void TRANSFERBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRANSFERBTNActionPerformed
       if(id!=0)
        {
          try {
            Registry registryAppointment = LocateRegistry.getRegistry("127.0.0.1", 6000);
            AppointmentsInterface intf = (AppointmentsInterface)registryAppointment.lookup("appointment");
            
            Registry registryTransfered = LocateRegistry.getRegistry("127.0.0.1", 6000);
            TransferedInterface intfs = (TransferedInterface)registryTransfered.lookup("transfered");
            
            Transfered inp = new Transfered();
            
            
           inp.setPatient_national_id(idInpt.getText());
           inp.setInpatient_name(nameInpt.getText());
        
           SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
         Date selectedDate = DateoFbithINpatientCombo.getDate();
         String formattedDate = dateFormat.format(selectedDate);

        inp.setDate_of_birth(formattedDate);
        inp.setInpatient_sickness(SicknessInp.getText());
        inp.setInpatient_amount_paid(AmountINp.getText());
       
        String selectedDepartmentName = String.valueOf(department_Combo.getSelectedItem());

        // Find the Department object by name
        Department selectedDepartment = findDepartmentByName(selectedDepartmentName);

        if (selectedDepartment != null) {
            inp.setDepartment(selectedDepartment);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid department selected", "Department Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
         Object selectedRoom = Room_Combo.getSelectedItem();

        // Find the Room object by name
        Rooms selectedRoomObject = findRoomByName(String.valueOf(selectedRoom));
       
        if (selectedRoomObject != null) {
            inp.setRoom(selectedRoomObject);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid room selected", "Room Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
         inp.setInpatient_phone_number(phoneINp.getText());
          
        int userChoice = JOptionPane.showConfirmDialog(this,"ready to be transfered",
        "Confirmation",JOptionPane.YES_NO_OPTION);
        
        if(userChoice == JOptionPane.YES_OPTION) {
         
           String feedback = intfs.RegisterTransfered(inp);   
         
            if(feedback!=null)
            {

               JOptionPane.showMessageDialog(this, feedback);
                    Appointments model = new Appointments();
                    model.setId(id);

                    String pt = intf.deleteAppointments(model);
                    id =0;
                    AddTableRow(); 
                  
                  
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Discharge process failed","failure",JOptionPane.ERROR_MESSAGE);
            }
                
         }
        
          
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
           
          
        }
         else
        {
            JOptionPane.showMessageDialog(this, "User is not available");
        }
        
    }//GEN-LAST:event_TRANSFERBTNActionPerformed

    private void Room_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Room_ComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Room_ComboActionPerformed

    private void SeachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeachBtnActionPerformed
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
            AppointmentsInterface intf = (AppointmentsInterface) registry.lookup("appointment");

            Appointments searchCriteria = new Appointments();
            searchCriteria.setPatient_national_id(SearchInp.getText());

            Appointments foundInpatient = intf.getappointmentsById(searchCriteria);

            if (foundInpatient != null) {

                idInpt.setText(SearchInp.getText());
                nameInpt.setText(foundInpatient.getInpatient_name());
                
                String dobString = foundInpatient.getDate_of_birth();

               
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
                Date dobDate = null;

                try {
                   
                    dobDate = dateFormat.parse(dobString);
                } catch (Exception e) {
                    e.printStackTrace(); 
                }


                DateoFbithINpatientCombo.setDate(dobDate);
                department_Combo.setSelectedItem(foundInpatient.getDepartment().getDep_name());
                Room_Combo.setSelectedItem(foundInpatient.getRoom().getRoom_no());
                AmountINp.setText(foundInpatient.getInpatient_amount_paid());
                phoneINp.setText(foundInpatient.getInpatient_phone_number());
                SicknessInp.setText(foundInpatient.getInpatient_sickness());
                id = foundInpatient.getId();
                

            } else {
                JOptionPane.showMessageDialog(this, "Inpatient not found", "Search Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_SeachBtnActionPerformed

    private void SearchInpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchInpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchInpActionPerformed

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
            java.util.logging.Logger.getLogger(DoctorAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorAppointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorAppointments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountINp;
    private javax.swing.JTable AppointmentTable;
    private javax.swing.JButton CUREbtn;
    private com.toedter.calendar.JDateChooser DateoFbithINpatientCombo;
    private javax.swing.JButton Gobackbtn1;
    private javax.swing.JMenuItem PatientHistory;
    private javax.swing.JComboBox<String> Room_Combo;
    private javax.swing.JButton SeachBtn;
    private javax.swing.JTextField SearchInp;
    private javax.swing.JTextField SicknessInp;
    private javax.swing.JButton TRANSFERBTN;
    private javax.swing.JComboBox<String> department_Combo;
    private javax.swing.JTextField idInpt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameInpt;
    private javax.swing.JTextField phoneINp;
    // End of variables declaration//GEN-END:variables
}
