/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.Department;
import SERVICE.DepartmentInterface;
import SERVICE.RoomInterface;
import MODEL.Rooms;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author destin
 */
public class Rooms_Departments extends javax.swing.JFrame {
 DefaultTableModel tableModel = new DefaultTableModel(); //FOR THE ROOMS
 
 DefaultTableModel tModel = new DefaultTableModel();   // FOR THE DEPARTMENTS

    public Rooms_Departments() {
        initComponents();
        AddTableColumnDepartments();
   
        addDepartmentItemsDep();
        
        addRowDataDepartment();
       
        AddDepartmentToComboRoom(); 
        AddTableColumnRoom();
        addRowDataRooms();
        
      
         
    }
    public void AddTableColumnRoom()
    {
        tableModel.addColumn("Id");
        tableModel.addColumn("room id");
        tableModel.addColumn("Department");
 
        
        Room_table.setModel(tableModel);
        
    }
    
      private void addRowDataRooms() {
    tableModel.setRowCount(0);

    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        RoomInterface intf = (RoomInterface) registry.lookup("rooms");

        List<Rooms> rooms = intf.allRooms();

        for (Rooms rm : rooms) {
            Department department = rm.getDepartment();
            String departmentName = (department != null) ? department.getDep_name() : "N/A";

            tableModel.addRow(new Object[]{
                rm.getId(),
                rm.getRoom_no(),
                departmentName,
            });
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

       public void AddTableColumnDepartments()
    {
        tModel.addColumn("Id");
        tModel.addColumn("dep id");
        tModel.addColumn("Department");
        tModel.addColumn("Started date");
        
       Department_table.setModel(tModel);
        
    }    
   private void addRowDataDepartment(){
    tModel.setRowCount(0);

    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        DepartmentInterface intf = (DepartmentInterface) registry.lookup("department");

        List<Department> dobject = intf.allDepartment();
        
        for (Department dp : dobject)
        {
      
        tModel.addRow(new Object[]{
        dp.getId(),
        dp.getDep_id(),
        dp.getDep_name(), 
        dp.getStarted_date(),
                           
          });
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
        
        
        
      public void AddDepartmentToComboRoom()
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
         
     private void addDepartmentItemsDep()
    {
        department_Combobox.removeAllItems();
        department_Combobox.addItem(Departments.Emergency.toString());
        department_Combobox.addItem(Departments.Cardiology.toString());
        department_Combobox.addItem(Departments.Administration.toString());
        department_Combobox.addItem(Departments.Pharmacy.toString());
        department_Combobox.addItem(Departments.Anesthesiology.toString());
        department_Combobox.addItem(Departments.Internal_Medicine.toString());
        
        department_Combobox.addItem(Departments.Neurology.toString());
        department_Combobox.addItem(Departments.Nutrition_and_Dietetics.toString());
        department_Combobox.addItem(Departments.Obstetrics_and_Gynecology.toString());
        department_Combobox.addItem(Departments.Oncology.toString());
        
        department_Combobox.addItem(Departments.Orthopedics.toString());
        department_Combobox.addItem(Departments.Pediatrics.toString());
        department_Combobox.addItem(Departments.Radiology.toString());
        
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Room_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        SearchroomINpt = new javax.swing.JTextField();
        SearchRoombtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        RegisterRoombtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        room_numberInput = new javax.swing.JTextField();
        department_Combo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        RegisterDepartmentbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        depart_id_input = new javax.swing.JTextField();
        department_Combobox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Department_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        SearchDepartment = new javax.swing.JTextField();
        searchDepartmentbtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        UpdateRoombtn = new javax.swing.JButton();
        New_room = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        INpatients = new javax.swing.JMenuItem();
        PatientHistory = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(196, 216, 212));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(155, 185, 173));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Room_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(Room_table);

        jLabel1.setFont(new java.awt.Font("Yrsa Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 245, 244));
        jLabel1.setText("Hospital Rooms");

        SearchroomINpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchroomINptActionPerformed(evt);
            }
        });

        SearchRoombtn.setFont(new java.awt.Font("Yrsa Light", 1, 18)); // NOI18N
        SearchRoombtn.setForeground(new java.awt.Color(217, 21, 21));
        SearchRoombtn.setText("Search room");
        SearchRoombtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchRoombtnActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        RegisterRoombtn.setFont(new java.awt.Font("Ubuntu Light", 1, 15)); // NOI18N
        RegisterRoombtn.setForeground(new java.awt.Color(211, 27, 27));
        RegisterRoombtn.setText("New room");
        RegisterRoombtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterRoombtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Room  no : ");

        jLabel9.setText("Department : ");

        department_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_ComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(room_numberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(department_Combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(RegisterRoombtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(room_numberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(department_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(RegisterRoombtn))
        );

        RegisterDepartmentbtn.setFont(new java.awt.Font("Ubuntu Light", 1, 15)); // NOI18N
        RegisterDepartmentbtn.setForeground(new java.awt.Color(211, 27, 27));
        RegisterDepartmentbtn.setText("New Department");
        RegisterDepartmentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterDepartmentbtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Department id : ");

        jLabel6.setText("Department name :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(41, 41, 41)
                        .addComponent(depart_id_input, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(department_Combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(RegisterDepartmentbtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(depart_id_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(department_Combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(RegisterDepartmentbtn)
                .addContainerGap())
        );

        jLabel3.setText("Room management");

        jLabel4.setText("Department management");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(SearchroomINpt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SearchRoombtn)
                            .addContainerGap())
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchroomINpt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchRoombtn))))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(167, 192, 183));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Department_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(Department_table);

        jLabel2.setFont(new java.awt.Font("Yrsa Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(235, 245, 244));
        jLabel2.setText("Hospital Departments");

        searchDepartmentbtn.setFont(new java.awt.Font("Yrsa Light", 1, 18)); // NOI18N
        searchDepartmentbtn.setForeground(new java.awt.Color(225, 22, 22));
        searchDepartmentbtn.setText("Search Dep");
        searchDepartmentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDepartmentbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(367, 367, 367))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(SearchDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchDepartmentbtn))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchDepartmentbtn))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(175, 204, 188));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton7.setFont(new java.awt.Font("Ubuntu Light", 1, 15)); // NOI18N
        jButton7.setForeground(new java.awt.Color(215, 31, 31));
        jButton7.setText("Update Department");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        UpdateRoombtn.setFont(new java.awt.Font("Ubuntu Light", 1, 15)); // NOI18N
        UpdateRoombtn.setForeground(new java.awt.Color(215, 31, 31));
        UpdateRoombtn.setText("Update room");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(623, 623, 623)
                .addComponent(UpdateRoombtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(173, 173, 173))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateRoombtn)
                    .addComponent(jButton7))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(915, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu7.setText("Patients");

        INpatients.setText("Inpatients");
        INpatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INpatientsActionPerformed(evt);
            }
        });
        jMenu7.add(INpatients);

        PatientHistory.setText("Patient_history");
        PatientHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientHistoryActionPerformed(evt);
            }
        });
        jMenu7.add(PatientHistory);

        New_room.add(jMenu7);

        setJMenuBar(New_room);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchroomINptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchroomINptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchroomINptActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void RegisterDepartmentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterDepartmentbtnActionPerformed
        if(depart_id_input.getText().trim().isEmpty())
                
        {
            JOptionPane.showMessageDialog(this, "Complete all input fields","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
             try {
                Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
                DepartmentInterface intf = (DepartmentInterface) registry.lookup("department");

                Department dep = new Department();
                dep.setDep_id(depart_id_input.getText());

                Object selectedDepartment = department_Combobox.getSelectedItem();
 
                String selectedDepartmentName = String.valueOf(selectedDepartment);

                dep.setDep_name(selectedDepartmentName);
                
                String feedback = intf.Registerdepartment(dep);
                if(feedback!=null)
                {
                    
                    JOptionPane.showMessageDialog(this,feedback,"success",JOptionPane.INFORMATION_MESSAGE);
                    depart_id_input.setText("");
                    AddDepartmentToComboRoom();
                    addRowDataDepartment();
                   
                }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }
    }//GEN-LAST:event_RegisterDepartmentbtnActionPerformed

    private void RegisterRoombtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterRoombtnActionPerformed
         try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        RoomInterface intf = (RoomInterface) registry.lookup("rooms");

        Rooms rm = new Rooms();
        rm.setRoom_no(room_numberInput.getText());

        Object selectedDepartment = department_Combo.getSelectedItem();
        String selectedDepartmentName = String.valueOf(selectedDepartment);

        Department department = findDepartmentByName(selectedDepartmentName);
        rm.setDepartment(department);

        String feedback = intf.Registerroom(rm);
        if(feedback != null) {
            JOptionPane.showMessageDialog(this, feedback, "Success", JOptionPane.INFORMATION_MESSAGE);
            depart_id_input.setText("");
            department_Combobox.setSelectedItem(null);
        }
        addRowDataRooms();
    } catch (Exception e) {
        e.printStackTrace();
        
    }
    }//GEN-LAST:event_RegisterRoombtnActionPerformed

    private void department_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_ComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_ComboActionPerformed

    private void SearchRoombtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchRoombtnActionPerformed
         try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
            RoomInterface intf=(RoomInterface)registry.lookup("rooms");
            
            Rooms rm = new Rooms();
            rm.setRoom_no(SearchroomINpt.getText());
            
            Rooms rms = intf.getroomById(rm);
            if(rms!=null)
            {
                tableModel.setRowCount(0);
                tableModel.addRow(new Object[]{
                rms.getId(),
                rms.getRoom_no(),
                rms.getDepartment().getDep_name(),
                });
            }
            else
            {
                JOptionPane.showMessageDialog(this, "The room does not exist");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }//GEN-LAST:event_SearchRoombtnActionPerformed

    private void searchDepartmentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDepartmentbtnActionPerformed
         try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",6000);
            DepartmentInterface intf=(DepartmentInterface)registry.lookup("department");
            
            Department depat = new Department();
           depat.setDep_id(SearchDepartment.getText());
            
            Department dep = intf.getdepartmentById(depat);
            if(dep!=null)
            {
                tModel.setRowCount(0);
                tModel.addRow(new Object[]{
                dep.getId(),
                dep.getDep_id(),
                dep.getDep_name(),
                dep.getStarted_date(),
                });
            }
             else
            {
                JOptionPane.showMessageDialog(this, "The department does not exist");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        } 
    }//GEN-LAST:event_searchDepartmentbtnActionPerformed

    private void INpatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INpatientsActionPerformed
       CheckInpatient_admin admin = new CheckInpatient_admin();
       admin.show();
       dispose();
    }//GEN-LAST:event_INpatientsActionPerformed

    private void PatientHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientHistoryActionPerformed
        PatientHistory patients = new PatientHistory();
        patients.show();
        dispose();
    }//GEN-LAST:event_PatientHistoryActionPerformed

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
            java.util.logging.Logger.getLogger(Rooms_Departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rooms_Departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rooms_Departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rooms_Departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rooms_Departments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Department_table;
    private javax.swing.JMenuItem INpatients;
    private javax.swing.JMenuBar New_room;
    private javax.swing.JMenuItem PatientHistory;
    private javax.swing.JButton RegisterDepartmentbtn;
    private javax.swing.JButton RegisterRoombtn;
    private javax.swing.JTable Room_table;
    private javax.swing.JTextField SearchDepartment;
    private javax.swing.JButton SearchRoombtn;
    private javax.swing.JTextField SearchroomINpt;
    private javax.swing.JButton UpdateRoombtn;
    private javax.swing.JTextField depart_id_input;
    private javax.swing.JComboBox<String> department_Combo;
    private javax.swing.JComboBox<String> department_Combobox;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField room_numberInput;
    private javax.swing.JButton searchDepartmentbtn;
    // End of variables declaration//GEN-END:variables
}
