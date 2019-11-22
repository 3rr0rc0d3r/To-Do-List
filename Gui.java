import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;
import java.time.*;
import java.math.*;
import java.util.*;

import static javax.swing.JOptionPane.CLOSED_OPTION;
import static javax.swing.JOptionPane.showInputDialog;

public class Gui {

    String index;  //for deletion of element
    int int_del;  //for deletion of element index
    String entry = "";  //for addition of element

    JFrame f_main = new JFrame("To-Do List by 3rr0rc0d3r");

    //INITIALIZING FRAME COMPONENTS

    JButton b_add = new JButton("Add Items");
    JButton b_del = new JButton("Delete Items");
    JButton b_disp = new JButton("Disp/Refresh");
    JButton b_exit = new JButton("Exit Program");
    JTextArea area = new JTextArea();
    JTextField field = new JTextField();
    JLabel label = new JLabel("Click on what you want to do!");


   /* public void main_components()
    {
        //JFrame defined in class
        //JButton defined in class

    }*/

    public void component_settings() //FOR SETTINGS OF COMPONENTS
    {
        f_main.setBounds(1000, 150, 300, 400);
        f_main.setLayout(null);
        f_main.setVisible(true);

        //BOUNDS, VISIBILITY, EDITABILITY
        b_add.setBounds(2, 310, 140, 20);
        b_add.setVisible(true);
        b_del.setBounds(150, 310, 140, 20);
        b_del.setVisible(true);
        b_disp.setBounds(2, 340, 140, 20);
        b_disp.setVisible(true);
        b_exit.setBounds(150, 340, 140, 20);
        b_exit.setVisible(true);
        area.setBounds(5, 10, 280, 230);
        area.setVisible(true);
        field.setBounds(5, 250, 280, 30);
        label.setBounds(5, 275, 280, 40);
        field.setEditable(false);
        area.setEditable(false);
        //area.setAutoscrolls(true);


        //ADD TO FRAME
        f_main.add(b_add);
        f_main.add(b_del);
        f_main.add(b_disp);
        f_main.add(b_exit);
        f_main.add(area);
        f_main.add(field);
        f_main.add(label);
        f_main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // ACTION LISTENERS FOR TODOLIST CLASS

        Todolist obj2 = new Todolist(); //object for Todolist.java class

        b_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                label.setText("Type here ^ and press ENTER");
                field.setEditable(true);


            }
        });

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


                obj2.list.add(field.getText());
                entry = field.getText();        //entry VARIABLE FOR CHECKING CONDITIONS
                if(entry.isEmpty())
                {
                    obj2.list.remove(obj2.list.size()-1);
                    area.setText("NULL insertions are not allowed");
                }
                else
                {
                    area.setText('"' + entry + '"' + "  added");
                    field.setText(null);
                }
                //entry = field.getText();
                //obj2.list.add(entry);
            }
        });

        b_disp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                field.setText(null);
                field.setEditable(false);
                label.setText(" ");
                StringBuilder str = new StringBuilder();

                for(int i=0;i<obj2.list.size();i++)
                {
                    str.append("\n" + (i+1) +". " + obj2.list.get(i));
                }
                area.setText(String.valueOf(str));
                /*for (int i = 0; i < obj2.list.size(); i++) {
                    area.setText(String.valueOf(obj2.list));
                    //area.setText(String.valueOf(System.out.println(obj2.list(i))));
                }*/
            }
        });

        b_del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                field.setEditable(false);
                index = JOptionPane.showInputDialog("Enter INDEX to delete or C to clear list");
                if(obj2.list.isEmpty())
                {
                    area.setText("List is empty!");
                }
                else if(index.equals("C") || index.equals("c"))
                {
                    obj2.list.clear();
                    area.setText("List cleared. Add more items by \nclicking on 'Add Items' button");
                }
                else
                {
                    try {
                        int_del = Integer.parseInt(index);  //WILL TRY TO PARSE STRING NUMBER TO INT AND STORE IN A VAR
                        try {                               //IF PARSING IS SUCCESSFUL
                            obj2.list.remove((int_del - 1));          //WILL TRY TO DELETE ENTERED ELEMENT
                            area.setText("Item deleted! Refresh the list");
                        }
                        catch(IndexOutOfBoundsException e)  //IF ELEMENT ISN'T ABLE TO BE DELETED, IT IS NOT AVAILABLE
                        {
                            area.setText("Index not found in the list"); //NOT AVAILABLE = NOT FOUND
                        }
                    }
                    catch (NumberFormatException e) //IF PARSING FAILED. IT MEANS THAT USER ENTERED ALPHABET OR SYMBOL
                    {
                        area.setText("Invalid Input!");
                    }
                }
            }
        });

        b_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                f_main.dispose();
            }
        });
    }

    /*
    public void field_action()
    {

    }*/

    public static void main(String args[])
    {
        Gui object = new Gui();
        object.component_settings();
        //object.main_components();
    }
}
