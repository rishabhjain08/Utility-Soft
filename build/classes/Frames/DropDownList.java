//done
package Frames;

import Frames.ProgramError.ErrorDisplay;
import Frames.ProgramError.Instruction;
import Frames.ProgramError.ProblemResolved;
import Frames.ProgramError.Report;
import Frames.ProgramError.Troubleshoot;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

public class DropDownList extends javax.swing.JFrame {

    private class exitwinlistener implements WindowListener{

        public exitwinlistener() {
        }

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
        }

        public void windowClosed(WindowEvent e) {
            ((DropDownList)e.getSource()).save();
        }

        public void windowIconified(WindowEvent e) {
        }

        public void windowDeiconified(WindowEvent e) {
        }

        public void windowActivated(WindowEvent e) {
        }

        public void windowDeactivated(WindowEvent e) {
        }
    }
Dimension SCREEN_SIZE=Toolkit.getDefaultToolkit().getScreenSize();
    private final JTable[] subtable;
    /** Creates new form DropDownList */
    public DropDownList() {
        this.setUndecorated(true);
        initComponents();
        this.addWindowListener(new exitwinlistener());
        this.setSize(SCREEN_SIZE);
        TypeofBills types=new TypeofBills();
        String[] tabhead=types.getTabHeadName();
        int i=0,k=0;
        List l;
        JScrollPane[] panes=new JScrollPane[tabhead.length];
        subtable=new JTable[tabhead.length];
        while(i<tabhead.length){
            panes[i]=new JScrollPane();
            subtable[i]=new JTable();
            DropDownModel ddmodel=new DropDownModel();
            subtable[i].setModel(ddmodel);
            subtable[i].setRowHeight(30);
            subtable[i].setFont(new Font("Times New Roman",0,20));
            subtable[i].setForeground(Color.MAGENTA);
            k=0;
            l=this.getListItems(tabhead[i]);
            while(k<l.size()){
                subtable[i].setValueAt(l.get(k), k, 0);
                k++;
            }
            panes[i].setViewportView(subtable[i]);
            mainpane.addTab(tabhead[i],panes[i]);
            i++;
        }
    }
    private void ddownMissing(String bug,final Exception ex){
                final File f=new File(System.getProperty("user.dir").replace('/', '\\')+"\\"+"ddown.txt");
                final ErrorDisplay err=new ErrorDisplay(bug);
            err.setVisible(true);
            err.addTroubleshootAction(new Troubleshoot() {

                public void doAction() {
                    try {
                        f.createNewFile();
                    } catch (Exception ex1) {
                    }
                    new ProblemResolved().setVisible(true);
                }
            });
            err.addReportAction(new Report() {

                public void reportAction() {
                err.setStackTraceElement(ex.getStackTrace());
                err.addAdditionalReporting("ddown file is missing.");
                }
            });

    }
    public void save(){
        final File f=new File(System.getProperty("user.dir").replace('/', '\\')+"\\"+"ddown.txt");
        int i=0;
        Writer o=null;
        try {
            o = new FileWriter(f);
        } catch (final IOException ex) {
            //bugno sem121:hef:easev
            this.ddownMissing("sem121:hef:easev", ex);
        }
        int k=0;
        JTable table;
        while(i<mainpane.getTabCount()){
            try {
                o.write(mainpane.getTitleAt(i));
            } catch (final Exception ex) {
                //bugno sem122:hef:easev
                final ErrorDisplay err=new ErrorDisplay("sem122:hef:easev");
                err.setVisible(true);
                err.addTroubleshootAction(new Troubleshoot() {

                    public void doAction() {
                        new Instruction("Restart the program. If the problem persists contact the Administrator.").setVisible(true);
                    }
                });
                err.addReportAction(new Report() {

                    public void reportAction() {
                        err.setStackTraceElement(ex.getStackTrace());}
                });
            }
              
            k=0;
            table=((JTable)((JViewport)((JScrollPane)(mainpane.getComponent(i))).getComponent(0)).getComponent(0));
            while(!table.getValueAt(k, 0).equals("")){
                try {
                    o.write("^" + (String) (table.getValueAt(k, 0)));
                } catch (IOException ex) {
                    //bugno sem123:hef:easev
                    this.restartProg("sem123:hef:easev", ex);
                }
                k++;
            }
            try {
                o.write("\r\n");
            } catch (IOException ex) {
                    //bugno sem124:hef:easev
                    this.restartProg("sem124:hef:easev", ex);

            }
            i++;
    }
        try {
            o.close();
        } catch (IOException ex) {
                    //bugno sem125:hef:easev
                    this.restartProg("sem125:hef:easev", ex);
        }
    }
public void restartProg(String bug,final Exception ex){
                final ErrorDisplay err=new ErrorDisplay(bug);
                err.setVisible(true);
                err.addTroubleshootAction(new Troubleshoot() {

                    public void doAction() {
                        new Instruction("Restart the program. If the problem persists contact the Administrator.").setVisible(true);
                    }
                });
                err.addReportAction(new Report() {

                    public void reportAction() {
                        err.setStackTraceElement(ex.getStackTrace());}
                });
}
    public List getListItems(String s){
        File f=new File(System.getProperty("user.dir").replace('/', '\\')+"\\"+"ddown.txt");
        Scanner scan=null;
        try {
            scan = new Scanner(f);
        } catch (FileNotFoundException ex) {
            //bugno sem121:hef:egLti
            this.ddownMissing("sem121:hef:egLti", ex);
        }
        List <String>l=new LinkedList();
        int index=0;
        String currline;
        while(scan.hasNextLine()){
            currline=scan.nextLine();
            if(currline.indexOf('^')!=-1&&currline.substring(0, currline.indexOf('^')).equalsIgnoreCase(s)){
                index=currline.indexOf('^');
                //System.out.println("index is : "+index);
                while(index!=-1){
                    //System.out.println(currline.substring(index+1, currline.indexOf('^', index+1)==-1?currline.length():currline.indexOf('^', index+1)));
                    l.add(currline.substring(index+1, currline.indexOf('^', index+1)==-1?currline.length():currline.indexOf('^', index+1)));
                    index=currline.indexOf('^', index+1);
                }
                break;
            }
        }
        scan.close();
        return l;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpane = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("DONE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(mainpane, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainpane, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DropDownList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTabbedPane mainpane;
    // End of variables declaration//GEN-END:variables
}
