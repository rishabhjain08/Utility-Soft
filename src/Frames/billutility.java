package Frames;


import java.awt.JobAttributes;
import java.awt.JobAttributes.DialogType;
import java.awt.PageAttributes;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * utility.java
 *
 * Created on Feb 2, 2011, 2:36:40 PM
 */

/**
 *
 * @author ci
 */
public class billutility extends javax.swing.JFrame {

    private   class datewindowlistener implements WindowListener{
        TypeofBills types=new TypeofBills();
        public void windowOpened(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent e) {
  //          throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosed(WindowEvent e) {
    //        throw new UnsupportedOperationException("Not supported yet.");
         
            int uppane=jTabbedPane1.getSelectedIndex();
            if(uppane==-1)
                return;
            JTabbedPane pane=((JTabbedPane)jTabbedPane1.getComponent(uppane));
            if(pane.getTabCount()==0)
                return;
            File f=new File(pathlocation.getlocation()+"/"+year+"/"+name+"/"+types.getFolderName(uppane));
            String[] billnames=new SortAlphabatically().sort(f.list());
            String[] paths=new String[billnames.length];
            int i=0;
            while(i<billnames.length){
                paths[i]=pathlocation.getlocation()+"/"+year+"/"+name+"/"+types.getFolderName(uppane)+"/"+billnames[i];
                i++;
            }
 JobAttributes att=new JobAttributes();
att.setDialog(DialogType.NATIVE);
PageAttributes pageatt=new PageAttributes();

            print print;
             print = new print(paths, getToolkit().getPrintJob(billutility.this, "Bill Print", att,pageatt),date.date);
             print.start();
    }

        public void windowIconified(WindowEvent e) {
      //      throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeiconified(WindowEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowActivated(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeactivated(WindowEvent e) {
  //          throw new UnsupportedOperationException("Not supported yet.");
        }

    }
    private billutility() {
    //    throw new UnsupportedOperationException("Not yet implemented");
    initComponents();
    }
    
    public  class deletebillwinlist implements WindowListener{
TypeofBills types=new TypeofBills();
        public void windowOpened(WindowEvent e) {
     //  throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosed(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");

            if(!deletebill.decision)
                return;

        int uppane=jTabbedPane1.getSelectedIndex();
        if(uppane==-1)
            return;
        JTabbedPane pane=((JTabbedPane)jTabbedPane1.getSelectedComponent());//.getTabComponentAt(uppane));
        int downpane=pane.getSelectedIndex();
        if(downpane==-1)
            return;
         File f=new File(pathlocation.getlocation()+year+"/"+name+"/"+types.getFolderName(uppane)+"/"+pane.getTitleAt(downpane)+".txt");
        boolean delete = f.delete();
        if(!delete){
             System.exit(0);
        }

         













        }

        public void windowIconified(WindowEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeiconified(WindowEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowActivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeactivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }





    }
    String name,year;

    /** Creates new form utility */
    public billutility(JTabbedPane pa,String year1,String name1) {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jTabbedPane1=pa;
        name=name1;
        year=year1;


     }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bill Utility");

        jPanel1.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 768));

        jButton1.setText("Delete the bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Rename the bill");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Print the bills");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(607, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(601, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
deletebill deletebill;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
   deletebill=new deletebill();
   deletebill.setVisible(true);
   deletebill.addWindowListener(new deletebillwinlist());
}//GEN-LAST:event_jButton1ActionPerformed
renamebillto renamebillto;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             // TODO add your handling code here:
        TypeofBills types=new TypeofBills();
        int uppane=jTabbedPane1.getSelectedIndex();
        if(uppane==-1)
            return;
        JTabbedPane pane=((JTabbedPane)jTabbedPane1.getComponent(uppane));
        int downpane=pane.getSelectedIndex();
        if(downpane==-1)
            return;
       renamebillto=new renamebillto(pathlocation.getlocation()+year+"/"+name+"/"+types.getFolderName(uppane),pane.getTitleAt(downpane));
       renamebillto.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseReleased
date date;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        date=new date();
        date.setVisible(true);
        date.addWindowListener(new datewindowlistener());
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new billutility()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    JComboBox jComboBox1;
    JTable jTable1;
    JTabbedPane jTabbedPane1;
}