import java.sql.Connection;

import javax.swing.BorderFactory;
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
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GUI {
public class GUI implements ItemListener {
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
        String[][] empdata = {{null,null,null,null,null,null,null,null}};
        String[][] custdata = {{null,null,null,null,null}};
        String[][] equipdata = {{null,null,null,null,null,null,null,null,null,null,null,null}};
        String[][] locationdata = {{null,null,null}};
        String[][] maindata = {{null,null,null,null,null,null}};
        String[][] paydata = {{null,null,null,null,null}};
        String[][] rentfeedata = {{null,null,null,null,null,null}};
        String[][] rentdata = {{null,null,null,null}};
        JTable table = new JTable(empdata,emptabs);
        JTable emptable = new JTable(empdata,emptabs);
        JTable custtable = new JTable(custdata,custtabs);
        JTable equiptable = new JTable(equipdata,equiptabs);
        JTable locationtable = new JTable(locationdata,locationtabs);
        JTable maintable = new JTable(maindata,maintabs);
        JTable paytable = new JTable(paydata,paytabs);
        JTable rentfeetable = new JTable(rentfeedata,rentfeetabs);
        JTable renttable = new JTable(rentdata,renttabs);
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
        JComboBox<String> dropdown = new JComboBox<>(tables);
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
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(frame, "Enter info");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(frame, "Enter info");
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
                        panel2.add(rentscroll); 
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
        new GUI();
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");

        }
        catch (Exception e) {
            System.out.println(e);
        }


    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    }

}