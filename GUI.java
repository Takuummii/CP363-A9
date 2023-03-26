import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GUI implements ItemListener {
    private static java.sql.Connection con;
    public GUI() {
        JFrame frame = new JFrame(); //GUI window
        JPanel panel = new JPanel(); //Series of buttons on left
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        JButton button = new JButton("Drop Table");
        JButton button2 = new JButton("Create Table");
        JButton button3 = new JButton("Insert into table");
        JButton button4 = new JButton("Exit");
        JTextField query = new JTextField("Enter Query", 50);
        String[] tables = {"Employee","Customer","Equipment","Location","Maintenance","Payments","Rental Fees","Rentals"};
        String[] emptabs = {"Name","Phone #","Email","Role","Employee ID","Login","Pay","Store ID"};
        String[] custtabs = {"Name","Phone #","Address","Purchase History","Equipment ID"};
        String[] equiptabs = {"Equipment ID","Name","Type","Model","Serial #","Quantity","Rental Price","Rental Status","Purchase Date","Manufacturer","Condition","Accessories"};
        String[] locationtabs = {"Store ID","Address","Equipment ID"};
        String[] maintabs = {"Parts Replaced","Status","Work Order #","Date","Cost","Employee ID"};
        String[] paytabs = {"Payment ID","Payment Date","Payment Method","Amount Paid","Phone #"};
        String[] rentfeetabs = {"Invoice #","Deposit","Rental Fee","Due Date","Additional Charges","Equipment ID"};
        String[] renttabs = {"Rental Date","Order #","Equipment ID","Employee ID"};
        String[] mytabs = {"id","name","age"};
        JTable emptable = new JTable();
        JTable table = new JTable();
        JTable custtable = new JTable();
        JTable equiptable = new JTable();
        JTable locationtable = new JTable();
        JTable maintable = new JTable();
        JTable paytable = new JTable();
        JTable rentfeetable = new JTable();
        JTable renttable = new JTable();
        JTable mytable = new JTable();
        DefaultTableModel model = (DefaultTableModel) emptable.getModel();
        DefaultTableModel model2 = (DefaultTableModel) custtable.getModel();
        DefaultTableModel model3 = (DefaultTableModel) equiptable.getModel();
        DefaultTableModel model4 = (DefaultTableModel) locationtable.getModel();
        DefaultTableModel model5 = (DefaultTableModel) maintable.getModel();
        DefaultTableModel model6 = (DefaultTableModel) paytable.getModel();
        DefaultTableModel model7 = (DefaultTableModel) rentfeetable.getModel();
        DefaultTableModel model8 = (DefaultTableModel) renttable.getModel();
        DefaultTableModel mymodel = (DefaultTableModel) mytable.getModel();
        String sql = "SELECT * FROM employee";
        String sql2 = "SELECT * FROM customer";
        String sql3 = "SELECT * FROM equipment";
        String sql4 = "SELECT * FROM location";
        String sql5 = "SELECT * FROM maintenance";
        String sql6 = "SELECT * FROM payments";
        String sql7 = "SELECT * FROM rental_fees";
        String sql8 = "SELECT * FROM rentals";
        String sql9 = "SELECT * FROM my_table";
        model.setColumnIdentifiers(emptabs);
        model2.setColumnIdentifiers(custtabs);
        model3.setColumnIdentifiers(equiptabs);
        model4.setColumnIdentifiers(locationtabs);
        model5.setColumnIdentifiers(maintabs);
        model6.setColumnIdentifiers(paytabs);
        model7.setColumnIdentifiers(rentfeetabs);
        model8.setColumnIdentifiers(renttabs);
        mymodel.setColumnIdentifiers(mytabs);
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String name = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String role = rs.getString(4);
                String employeeid = rs.getString(5);
                String login = rs.getString(6);
                String pay = rs.getString(7);
                String storeid = rs.getString(8);
                String[] row = {name,phone,email,role,employeeid,login,pay,storeid};
                model.addRow(row);
            }
        } catch (Exception ex) {

        }
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql2);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String name = rs.getString(3);
                String phone = rs.getString(1);
                String address = rs.getString(2);
                String purch = rs.getString(4);
                String rents = rs.getString(5);
                String[] row = {name,phone,address,purch,rents};
                model2.addRow(row);
            }
        } catch (Exception ex) {

        }
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql3);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String equipid = rs.getString(1);
                String name = rs.getString(2);
                String type = rs.getString(3);
                String models = rs.getString(4);
                String serial = rs.getString(5);
                String quantity = rs.getString(6);
                String rentp = rs.getString(7);
                String rents = rs.getString(8);
                String purchd = rs.getString(9);
                String manu = rs.getString(10);
                String cond = rs.getString(11);
                String acc = rs.getString(12);
                String[] row = {name,equipid,type,models,serial,quantity,rentp,rents,purchd,manu,cond,acc};
                model3.addRow(row);
            }
        } catch (Exception ex) {

        }
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql4);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String storeid = rs.getString(1);
                String address = rs.getString(2);
                String equipid = rs.getString(3);
                String[] row = {storeid,address,equipid};
                model4.addRow(row);
            }
        } catch (Exception ex) {

        }
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql5);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String parts = rs.getString(1);
                String status = rs.getString(2);
                String worko = rs.getString(3);
                String date = rs.getString(4);
                String cost = rs.getString(5);
                String empid = rs.getString(6);
                String[] row = {parts,status,worko,date,cost,empid};
                model5.addRow(row);
            }
        } catch (Exception ex) {

        }
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql6);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String payid = rs.getString(1);
                String payd = rs.getString(2);
                String paym = rs.getString(3);
                String amt = rs.getString(4);
                String custp = rs.getString(5);
                String[] row = {payid,payd,paym,amt,custp};
                model6.addRow(row);
            }
        } catch (Exception ex) {

        }
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql7);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String inv = rs.getString(1);
                String dep = rs.getString(2);
                String rentf = rs.getString(3);
                String due = rs.getString(4);
                String add = rs.getString(5);
                String equip = rs.getString(6);
                String[] row = {inv,dep,rentf,due,add,equip};
                model7.addRow(row);
            }
        } catch (Exception ex) {

        }
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql8);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String rentd = rs.getString(1);
                String order = rs.getString(2);
                String equip = rs.getString(3);
                String empid = rs.getString(4);
                String[] row = {rentd,order,equip,empid};
                model8.addRow(row);
            }
        } catch (Exception ex) {

        }
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql9);
            //emptable.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String age = rs.getString(3);
                String[] row = {id,name,age};
                mymodel.addRow(row);
            }
        } catch (Exception ex) {

        }
        emptable.setModel(model);
        custtable.setModel(model2);
        equiptable.setModel(model3);
        table.setModel(model);
        locationtable.setModel(model4);
        maintable.setModel(model5);
        paytable.setModel(model6);
        rentfeetable.setModel(model7);
        renttable.setModel(model8);
        mytable.setModel(mymodel);
        table.setBounds(30,40,100,500);
        emptable.setBounds(30,40,100,500);
        custtable.setBounds(30,40,100,500);
        equiptable.setBounds(30,40,100,500);
        locationtable.setBounds(30,40,100,500);
        JScrollPane scrollbar = new JScrollPane(table);
        JScrollPane empscroll = new JScrollPane(emptable);
        JScrollPane custscroll = new JScrollPane(custtable);
        JScrollPane equipscroll = new JScrollPane(equiptable);
        JScrollPane locationscroll = new JScrollPane(locationtable);
        JScrollPane mainscroll = new JScrollPane(maintable);
        JScrollPane payscroll = new JScrollPane(paytable);
        JScrollPane rentfeescroll = new JScrollPane(rentfeetable);
        JScrollPane rentscroll = new JScrollPane(renttable);
        JScrollPane myscroll = new JScrollPane(mytable);
        DefaultComboBoxModel<String> dropmodel = new DefaultComboBoxModel<>(tables);
        JComboBox<String> dropdown = new JComboBox<>(dropmodel);
        dropdown.setBounds(80,50,140,20);
        //panel.setSize(300,300);
        panel.setLayout(layout);
        panel2.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        //add components here
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(button,gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(button2,gbc);
        
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(button3,gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(button4,gbc);
        
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(dropdown,gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel3.add(query,gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel2.add(scrollbar,gbc);
        
        //action listeners
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                Statement statement = con.createStatement();
                String current = dropdown.getItemAt(dropdown.getSelectedIndex());
                String command = "DROP TABLE "+ current;
                statement.executeUpdate(command);
                dropmodel.removeElement(current);
                }
                catch(Exception ex) {

                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current = dropdown.getItemAt(dropdown.getSelectedIndex());
                try {
                String query1 = "CREATE TABLE IF NOT EXISTS my_table (" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name VARCHAR(50) NOT NULL, " +
                        "age INT, " +
                        "PRIMARY KEY (id)" + ")";
                PreparedStatement statement = con.prepareStatement(query1);
                statement.execute();
                if (dropmodel.getIndexOf("my_table") == -1) {
                    dropmodel.addElement("my_table");
                }    
            }
                catch (Exception ex) {

                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(frame, "Enter info with fields separated by commas");
                String current = dropdown.getItemAt(dropdown.getSelectedIndex());
                String command = "INSERT INTO " + current + " VALUES (" + input + ")"  ;
                try {
                PreparedStatement statement = con.prepareStatement(command);
                statement.execute();
                mymodel.addRow(mytabs);
                }
                catch(Exception ex) {

                }
            }
        });
        dropdown.addItemListener(new ItemListener() {
            //@Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (dropdown.getSelectedItem().toString().equals("Employee")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(empscroll);
                        panel2.revalidate();
                        panel2.repaint();    
                    }
                    else if (dropdown.getSelectedItem().toString().equals("Customer")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(custscroll);
                        panel2.revalidate();
                        panel2.repaint();   
                    }
                    else if (dropdown.getSelectedItem().toString().equals("Equipment")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(equipscroll);
                        panel2.revalidate();
                        panel2.repaint();  
                    }
                    else if (dropdown.getSelectedItem().toString().equals("Location")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(locationscroll); 
                        panel2.revalidate();
                        panel2.repaint();  
                    }
                    else if (dropdown.getSelectedItem().toString().equals("Maintenance")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(mainscroll); 
                        panel2.revalidate();
                        panel2.repaint();  
                    }
                    else if (dropdown.getSelectedItem().toString().equals("Payments")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(payscroll); 
                        panel2.revalidate();
                        panel2.repaint();  
                    }
                    else if (dropdown.getSelectedItem().toString().equals("Rental Fees")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(rentfeescroll); 
                        panel2.revalidate();
                        panel2.repaint();  
                    }
                    else if (dropdown.getSelectedItem().toString().equals("Rentals")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(rentscroll); 
                        panel2.revalidate();
                        panel2.repaint();  
                    }
                    else if (dropdown.getSelectedItem().toString().equals("my_table")) {
                        panel2.remove(scrollbar);
                        panel2.remove(custscroll);
                        panel2.remove(equipscroll);
                        panel2.remove(locationscroll);
                        panel2.remove(empscroll);
                        panel2.remove(mainscroll);
                        panel2.remove(payscroll);
                        panel2.remove(rentfeescroll);
                        panel2.remove(rentscroll);
                        panel2.remove(myscroll);
                        panel2.add(myscroll); 
                        panel2.revalidate();
                        panel2.repaint();  
                    }
                }
            }
        });
        frame.setSize(800,600);
        frame.add(panel,BorderLayout.WEST);
        frame.add(panel2,BorderLayout.EAST);
        frame.add(panel3,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Database GUI");
        frame.pack();
        frame.setVisible(true);

        
        

        //Droptable = Label("Drop Table");
    }
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "1234";
        Statement statement = null;
        try {
            //connect to mysql database
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            //------------
            System.out.println("Connected");
             
        }
        catch (Exception e) {
            System.out.println(e);
        }
        new GUI();
        


    }
    void loaddata() {
        
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    }

}