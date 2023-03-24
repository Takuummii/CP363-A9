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

public class GUI {
    public GUI() {
        JFrame frame = new JFrame(); //GUI window
        JPanel panel = new JPanel(); //Series of buttons on left
        JPanel panel2 = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        JButton button = new JButton("Drop Table");
        JButton button2 = new JButton("Create Table");
        JButton button3 = new JButton("Insert into table");
        JButton button4 = new JButton("Exit");
        JTextField query = new JTextField("Enter Query", 50);
        String[] tables = {"Employee","Customer","Equipment","Location","Maintenance","Payments","Rental Fees","Rentals"};
        JTable table = new JTable();
        table.setBounds(30,40,100,500);
        JScrollPane scrollbar = new JScrollPane(table);
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
        panel2.add(query,gbc);

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
        frame.setSize(800,600);
        frame.add(panel,BorderLayout.WEST);
        frame.add(panel2,BorderLayout.EAST);
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

}