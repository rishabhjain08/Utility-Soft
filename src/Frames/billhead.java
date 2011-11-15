package Frames;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class billhead extends javax.swing.JFrame {
public boolean start;
    public billhead() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration Step-2");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));

        ta2.setColumns(20);
        ta2.setRows(5);
        ta2.setText("To be printed on Bills.");
        jScrollPane1.setViewportView(ta2);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Name & Designation"));

        ta1.setColumns(20);
        ta1.setRows(5);
        ta1.setText("To be printed on Bills.");
        jScrollPane2.setViewportView(ta1);

        jButton1.setText("Next >");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-536)/2, (screenSize.height-446)/2, 536, 446);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            scanner scan=new scanner(new InputStreamReader(new FileInputStream(new File(System.getProperty("user.dir") + "/impinfo.txt")), "UTF-8"));
            writer o = new writer();
            o.init(new FileWriter(new File(System.getProperty("user.dir") + "/impinfo.txt")));
            if(scan.hasNextLine()){
                o.write(scan.nextLine()+"\r\n");
            }
            else
                o.write("\r\n");
            StringBuffer g = new StringBuffer(ta1.getText());
            int remi = 0;
            int i = g.indexOf("\n", 0);
            while (i != -1) {
                o.write("~"+g.substring(remi, i).toString() + "%");
                remi = i + 1;
                i = g.indexOf("\n", remi);
            }
            o.write("~"+g.substring(remi)+"%\r\n");
            g = new StringBuffer(ta2.getText());
            remi = 0;
            i = g.indexOf("\n", 0);
            while(i != -1){
                o.write("~"+g.substring(remi,i).toString() + "%");
                remi=i+1;
                i = g.indexOf("\n", remi);
            }
            o.write("~"+g.substring(remi)+"%\r\n");
            if(scan.hasNextLine()){
                scan.nextLine();
            if(scan.hasNextLine()){
                scan.nextLine();
                while(scan.hasNextLine()){
                    o.write(scan.nextLine()+"\r\n");
                }
            }
            else
                scan.close();
            }
            else
                scan.close();
            o.close();
        } catch (IOException ex) {
        }
        start=true;
        dispose();
        new billhead1().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public String[] getFirmName(){
        scanner scan=null;
        try {
            File f = new File(System.getProperty("user.dir") + "/impinfo.txt");
             scan = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
        } catch (Exception ex) {
            Logger.getLogger(billhead.class.getName()).log(Level.SEVERE, null, ex);
        }
        scan.nextLine();
        String g=scan.nextLine();
        List <String>l=new LinkedList();
        int i=0,remi=g.indexOf('%', i);
        while(true){
            l.add(g.substring(i+1, remi));
            i=remi+1;
            if(i==g.length())
                break;
            remi=g.indexOf('%', i);
        }
        scan.close();
        String[] t=new String[l.size()];
        i=0;
        while(i<t.length){
            t[i]=l.get(i);
            i++;
        }
        return t;
    }
    public String[] getFirmAddress(){
        scanner scan=null;
        try {
            File f = new File(System.getProperty("user.dir") + "/impinfo.txt");
            scan = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
        } catch (Exception ex) {
            Logger.getLogger(billhead.class.getName()).log(Level.SEVERE, null, ex);
        }
        scan.nextLine();
        scan.nextLine();
        String g=scan.nextLine();
        List <String>l=new LinkedList();
        int i=0,remi=g.indexOf('%', i);
        while(true){
            l.add(g.substring(i+1, remi));
            i=remi+1;
            if(i==g.length())
                break;
            remi=g.indexOf('%', i);
        }
        scan.close();
        String[] t=new String[l.size()];
        i=0;
        while(i<t.length){
            t[i]=l.get(i);
            i++;
        }
        return t;
    }

    public boolean doAsk(){
        scanner scan=null;
        try {
            File f = new File(System.getProperty("user.dir") + "/impinfo.txt");
             scan = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
        } catch (Exception ex) {
            Logger.getLogger(billhead.class.getName()).log(Level.SEVERE, null, ex);
        }
        scan.nextLine();
        if(scan.hasNextLine())
            return false;
        return true;
        }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            writer o = new writer();
            o.init(new FileWriter(new File(System.getProperty("user.dir") + "/impinfo.txt")));
            o.write("\r\n");
            o.close();
            dispose();
            start = false;
        } catch (IOException ex) {
            Logger.getLogger(billhead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                billhead billhead=new billhead();
                billhead.setVisible(true);
                //System.out.println(billhead.doAsk());
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextArea ta2;
    // End of variables declaration//GEN-END:variables

}
