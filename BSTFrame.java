/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam Sohn
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.logging.*;
import javax.swing.*;

public class BSTFrame extends JFrame {
    boolean jtf1 = true;
    boolean jtf2 = true;
    boolean jtf3 = true;
    public BSTFrame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Welcome to FoodBST!");
        jButton1.setText("Add Item");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("Search for Item");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.setText("Remove Item");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jLabel2.setText("Please enter the name of the item you want to add:");
        jLabel3.setText("Please enter the name of the item you want to search: ");
        jLabel4.setText("Please enter the name of the item you want to remove:");
        jTextField1.setText("cookie");
        jTextField2.setText("cookie");
        jTextField3.setText("cookie");
        jButton4.setText("Submit");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton3)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel2))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField1)
                                                                        .addComponent(jTextField2)
                                                                        .addComponent(jTextField3, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))))
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(136, 136, 136))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jButton4)
                                                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))
        );
        pack();
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        jTextField1.setVisible(true);
        jtf1 = true;
        jTextField2.setVisible(false);
        jtf2 = false;
        jTextField3.setVisible(false);
        jtf3 = false;
    }
    private void jButton2ActionPerformed(ActionEvent evt) {
        jTextField1.setVisible(false);
        jtf1 = false;
        jTextField2.setVisible(true);
        jtf2 = true;
        jTextField3.setVisible(false);
        jtf3 = false;
    }
    private void jButton3ActionPerformed(ActionEvent evt) {
        jTextField1.setVisible(false);
        jtf1 = false;
        jTextField2.setVisible(false);
        jtf2 = false;
        jTextField3.setVisible(true);
        jtf3 = true;
    }
    private void jButton4ActionPerformed(ActionEvent evt) {
        String asdf;
        if (jtf1)   {
            asdf = jTextField1.getText();
            BSTNode<FoodItem> b = makeItem(asdf);
            String[] i = new String[100];
            int j = 0;
            if (Driver.root.search(b) == null) {
                System.out.println("Please enter the ingredients. When finished, enter 'Done'");
                Scanner in = new Scanner(System.in);
                String newline = "";
                while (!newline.equals("Done")) {
                    newline = in.nextLine();
                    i[j] = newline;
                    j++;
                }
            }
            String[] ing = new String[j-1];
            for (int k = 0; k < j-1; k++)
                ing[k] = i[k];
            FoodItem fi = new FoodItem(asdf, ing);
            b.setInfo(fi);
            Driver.root.add(b);
        }
        else if (jtf2)
            Driver.root.search(makeItem(jTextField2.getText()));
        else
            Driver.root.remove(makeItem(jTextField3.getText()));
    }
    public BSTNode makeItem(String asdf)  {
        String[] a = {" "};
        FoodItem fi = new FoodItem(asdf, a);
        BSTNode<FoodItem> b = new BSTNode<FoodItem>();
        b.setInfo(fi);
        return b;
    }
    public void run()   {
        new BSTFrame().setVisible(true);
    }
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
}
