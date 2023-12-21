/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;
import MODEL.Appointments;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import MODEL.Department;
import MODEL.Inpatients;
import MODEL.Rooms;
import SERVICE.AppointmentsInterface;
import SERVICE.DepartmentInterface;
import SERVICE.InpatientInterface;
import SERVICE.RoomInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author destin
 */
public class ReceptionistHomepage extends javax.swing.JFrame {
DefaultTableModel tableModel = new DefaultTableModel();
 private int id =0;
    /**
     * Creates new form ReceptionistHomepage
     */
    public ReceptionistHomepage() {
        initComponents();
        AddTableColumn();
        AddDepartmentToCombo();
        AddRoomsToCombo();
        addRowData();
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
        
        InpatientTable.setModel(tableModel);
        
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
    
    private void addRowData() {
    tableModel.setRowCount(0);

    try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        InpatientInterface intf = (InpatientInterface) registry.lookup("inpatient");

        List<Inpatients> inp = intf.allInpatients();
        String department = null;
        String room =null;
        for (Inpatients obj : inp) {
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
    private void appointmentRegistration()
    {
        try{
               Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
                AppointmentsInterface appointmentsInterface = (AppointmentsInterface) registry.lookup("appointment");
                Appointments appointments = new Appointments();

                appointments.setPatient_national_id(idInpt.getText());
                appointments.setInpatient_name(nameInpt.getText());

                SimpleDateFormat dateFormats = new SimpleDateFormat("MMM d, yyyy");
                Date selectedDates = DateoFbithINpatientCombo.getDate();
                String formattedDates = dateFormats.format(selectedDates);

                appointments.setDate_of_birth(formattedDates);
                appointments.setInpatient_sickness(SicknessInp.getText());
                appointments.setInpatient_amount_paid(AmountINp.getText());

                String selectedDepartmentNames = String.valueOf(department_Combo.getSelectedItem());
                Department selectedDepartments = findDepartmentByName(selectedDepartmentNames);

                if (selectedDepartments != null) {
                    appointments.setDepartment(selectedDepartments);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid department selected", "Department Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Object selectedRooms = Room_Combo.getSelectedItem();
                Rooms selectedRoomObjects = findRoomByName(String.valueOf(selectedRooms));

                if (selectedRoomObjects != null) {
                    appointments.setRoom(selectedRoomObjects);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid room selected", "Room Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                appointments.setInpatient_phone_number(phoneINp.getText());

                int userChoice = JOptionPane.showConfirmDialog(this, "Book appointment with doctor",
                        "Confirmation", JOptionPane.YES_NO_OPTION);

                if (userChoice == JOptionPane.YES_OPTION) {
                    String feedbackAppointments = appointmentsInterface.RegisterAppointments(appointments);
                    JOptionPane.showMessageDialog(this, feedbackAppointments);
                }
                
                }
            catch(Exception e)
            {
                e.printStackTrace();
                
               JOptionPane.showMessageDialog(this, "Error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        idInpt = new javax.swing.JTextField();
        nameInpt = new javax.swing.JTextField();
        AmountINp = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        phoneINp = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        Registerbtn = new javax.swing.JButton();
        Room_Combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        SicknessInp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        department_Combo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        DateoFbithINpatientCombo = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        ReceiptBtn = new javax.swing.JButton();
        SAVEBILL = new javax.swing.JButton();
        Logoutbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BillArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InpatientTable = new javax.swing.JTable();
        UpdateBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        SearchInp = new javax.swing.JTextField();
        SeachBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        TransferedMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBackground(new java.awt.Color(97, 182, 137));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("Id card :");

        jLabel17.setText("Name :");

        jLabel18.setText("Room no:");

        jLabel19.setText("Phone:");

        jLabel20.setText("Amount");

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Registerbtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        Registerbtn.setForeground(new java.awt.Color(219, 23, 23));
        Registerbtn.setText("REGISTER");
        Registerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Registerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Registerbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        Room_Combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Room_ComboActionPerformed(evt);
            }
        });

        jLabel3.setText("Sickness:");

        jLabel1.setText("Date of birth :");

        jLabel2.setText("Department");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AmountINp, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(0, 27, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SicknessInp)
                                    .addComponent(department_Combo, 0, 125, Short.MAX_VALUE)
                                    .addComponent(DateoFbithINpatientCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idInpt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phoneINp, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(Room_Combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameInpt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idInpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(nameInpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateoFbithINpatientCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(SicknessInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AmountINp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(department_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(Room_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneINp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(55, 55, 55)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(91, 184, 133));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ReceiptBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        ReceiptBtn.setText("RECEIPT");
        ReceiptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiptBtnActionPerformed(evt);
            }
        });

        SAVEBILL.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        SAVEBILL.setText("SAVE");
        SAVEBILL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEBILLActionPerformed(evt);
            }
        });

        Logoutbtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        Logoutbtn.setIcon(new javax.swing.ImageIcon("/home/destin/Pictures/Project_Images/ICONS/logout.resized.png")); // NOI18N
        Logoutbtn.setText("LOG-OUT");
        Logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(SAVEBILL, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(ReceiptBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReceiptBtn)
                    .addComponent(SAVEBILL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(75, 158, 116));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon("/home/destin/Pictures/Project_Images/ICONS/inpatient (1).resized.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BillArea.setColumns(20);
        BillArea.setRows(5);
        BillArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BillArea);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        InpatientTable.setModel(new javax.swing.table.DefaultTableModel(
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
        InpatientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InpatientTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(InpatientTable);

        UpdateBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        UpdateBtn.setForeground(new java.awt.Color(177, 33, 33));
        UpdateBtn.setText("UPDATE");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addComponent(UpdateBtn)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 75, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        SeachBtn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        SeachBtn.setText("SEARCH/ID");
        SeachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeachBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(SearchInp, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(SeachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchInp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeachBtn))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMenu7.setText("Doctors");

        TransferedMenu.setText("Appointments");
        TransferedMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferedMenuActionPerformed(evt);
            }
        });
        jMenu7.add(TransferedMenu);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterbtnActionPerformed
       try {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
        InpatientInterface inpatientInterface = (InpatientInterface) registry.lookup("inpatient");
        

        Inpatients inpatient = new Inpatients();

        inpatient.setPatient_national_id(idInpt.getText());
        inpatient.setInpatient_name(nameInpt.getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
        Date selectedDate = DateoFbithINpatientCombo.getDate();
        String formattedDate = dateFormat.format(selectedDate);

        inpatient.setDate_of_birth(formattedDate);
        inpatient.setInpatient_sickness(SicknessInp.getText());
        inpatient.setInpatient_amount_paid(AmountINp.getText());

        String selectedDepartmentName = String.valueOf(department_Combo.getSelectedItem());
        Department selectedDepartment = findDepartmentByName(selectedDepartmentName);

        if (selectedDepartment != null) {
            inpatient.setDepartment(selectedDepartment);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid department selected", "Department Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object selectedRoom = Room_Combo.getSelectedItem();
        Rooms selectedRoomObject = findRoomByName(String.valueOf(selectedRoom));

        if (selectedRoomObject != null) {
            inpatient.setRoom(selectedRoomObject);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid room selected", "Room Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        inpatient.setInpatient_phone_number(phoneINp.getText());

        String feedbackInpatient = inpatientInterface.RegisterInpatients(inpatient);

        if (feedbackInpatient != null) {
            JOptionPane.showMessageDialog(this, feedbackInpatient);
            addRowData();
            appointmentRegistration();
            
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    
    }//GEN-LAST:event_RegisterbtnActionPerformed

    private void Room_ComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Room_ComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Room_ComboActionPerformed

    private void ReceiptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiptBtnActionPerformed
        Inpatients inp = new Inpatients();
    if(idInpt.getText().trim().isEmpty() ||
                nameInpt.getText().trim().isEmpty()||
                SicknessInp.getText().trim().isEmpty()||
                AmountINp.getText().trim().isEmpty()||
                phoneINp.getText().trim().isEmpty()
                )
        {
           JOptionPane.showMessageDialog(this, "Complete all patient information");
        }
   
    else
    {     
        BillArea.setText("********************************************************************************\n");
        BillArea.setText(BillArea.getText() + "\n\t\t* Inpatient fees Receipt * \n\nDate : "+inp.getInpatient_date_in()+"\n");
        BillArea.setText(BillArea.getText() + "---------------------------------------------------------------------------------------------------------------------\n\n");
        BillArea.setText(BillArea.getText() + "Inpatient Info \n\n");
        BillArea.setText(BillArea.getText() + "Id Card no : " + idInpt.getText() + "\n\n");
        BillArea.setText(BillArea.getText() + "Mr/Mm/Dr: " + nameInpt.getText() + "\t Phone : " + phoneINp.getText()+"\n\n");
        BillArea.setText(BillArea.getText() + "---------------------------------------------------------------------------------------------------------------------\n\n");

        BillArea.setText(BillArea.getText() + "\t\t\tAmount paid : " + AmountINp.getText() + "Frw\n\n");

        BillArea.setText(BillArea.getText() + "\t\t\tSignature: \n\n");
        BillArea.setText(BillArea.getText() + "---------------------------------------------------------------------------------------------------------------------\n\n");

    }
        
    }//GEN-LAST:event_ReceiptBtnActionPerformed

    private void LogoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutbtnActionPerformed
           LoginPage login = new LoginPage();
           dispose();
           login.show();
           
    }//GEN-LAST:event_LogoutbtnActionPerformed

    private void BillAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillAreaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BillAreaMouseClicked

    private void InpatientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InpatientTableMouseClicked

    
    }//GEN-LAST:event_InpatientTableMouseClicked

    private void SeachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeachBtnActionPerformed
           try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
            InpatientInterface intf = (InpatientInterface) registry.lookup("inpatient");

            Inpatients searchCriteria = new Inpatients();
            searchCriteria.setPatient_national_id(SearchInp.getText());

            Inpatients foundInpatient = intf.getinpatientsById(searchCriteria);

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

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
       if(id!=0)
       {
            if(idInpt.getText().trim().isEmpty()||nameInpt.getText().trim().isEmpty()||
                SicknessInp.getText().trim().isEmpty()||DateoFbithINpatientCombo.getDate()==null||
                phoneINp.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Complete all fields","Empty fields",JOptionPane.ERROR_MESSAGE);
        }
        else if(SearchInp.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Search user to update","Search",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
          try {
             Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6000);
             InpatientInterface intf = (InpatientInterface) registry.lookup("inpatient");
             SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
             Date selectedDate = DateoFbithINpatientCombo.getDate();
             
             String UpdatedDate = dateFormat.format(selectedDate);
             String updatedName = nameInpt.getText();
             String updatedAmount = AmountINp.getText();
             String updatedPhone = phoneINp.getText();
             String updatedSickness = SicknessInp.getText();
             String selectDepartment = String.valueOf(department_Combo.getSelectedItem());
             Department updatedDepartment = findDepartmentByName(selectDepartment);
             
             Object selectedRoom = Room_Combo.getSelectedItem();

             Rooms updatedRoom = findRoomByName(String.valueOf(selectedRoom));
            
             Inpatients updatedInpatient = new Inpatients();
             
             updatedInpatient.setId(id);
             updatedInpatient.setPatient_national_id(SearchInp.getText());
             updatedInpatient.setInpatient_name(updatedName);
             updatedInpatient.setInpatient_amount_paid(updatedAmount);
             updatedInpatient.setInpatient_phone_number(updatedPhone);
             updatedInpatient.setInpatient_sickness(updatedSickness);
             updatedInpatient.setDate_of_birth(UpdatedDate);
             updatedInpatient.setDepartment(updatedDepartment);
             updatedInpatient.setRoom(updatedRoom);
             // Invoke the update operation
             String updateResult = intf.updateInpatients(updatedInpatient);
             if(updateResult!=null)
             {
                 JOptionPane.showMessageDialog(this, updateResult, "Success", JOptionPane.INFORMATION_MESSAGE);
                 id =0;
                 addRowData();
             }
             

         } catch (Exception e) {
             e.printStackTrace();
         }   
        }
       }
       
       
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void SAVEBILLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEBILLActionPerformed
      try {
        if (BillArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "BillArea is empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
       
            String chosenFilePath = fileChooser.getSelectedFile().getAbsolutePath();

            if (!chosenFilePath.toLowerCase().endsWith(".csv")) {
                chosenFilePath += ".csv";
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(chosenFilePath))) {
               
                writer.write("Bill Data\n");

                writer.write(BillArea.getText());
            }

            JOptionPane.showMessageDialog(this, "Bill data saved to " + chosenFilePath, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error saving bill data to CSV", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_SAVEBILLActionPerformed

    private void TransferedMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferedMenuActionPerformed
        Appointment_receptionist check = new Appointment_receptionist();
        dispose();
        check.show();
    }//GEN-LAST:event_TransferedMenuActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistHomepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmountINp;
    private javax.swing.JTextArea BillArea;
    private com.toedter.calendar.JDateChooser DateoFbithINpatientCombo;
    private javax.swing.JTable InpatientTable;
    private javax.swing.JButton Logoutbtn;
    private javax.swing.JButton ReceiptBtn;
    private javax.swing.JButton Registerbtn;
    private javax.swing.JComboBox<String> Room_Combo;
    private javax.swing.JButton SAVEBILL;
    private javax.swing.JButton SeachBtn;
    private javax.swing.JTextField SearchInp;
    private javax.swing.JTextField SicknessInp;
    private javax.swing.JMenuItem TransferedMenu;
    private javax.swing.JButton UpdateBtn;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameInpt;
    private javax.swing.JTextField phoneINp;
    // End of variables declaration//GEN-END:variables
}
