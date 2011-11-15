//done
package Frames;
import Frames.ProgramError.ErrorDisplay;
import Frames.ProgramError.Report;
import Frames.ProgramError.Troubleshoot;
import Frames.ProgramError.UnabletoShoot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class passwordpro extends javax.swing.JFrame {

    passwordpro() {
        try{
            initComponents();
        }catch(final Exception e){
            //bugno sem121fWiimapssw
            final ErrorDisplay err=new ErrorDisplay("sem121fWiimapssw");
            err.setVisible(true);
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                    new UnabletoShoot(err,null,false).setVisible(true);
                }
            });
            err.addReportAction(new Report() {
                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting("initcomponents of passwordpro in constructor has a problem");
                }
            });
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enter Password");

        jLabel1.setFont(new java.awt.Font("Vani", 1, 24));
        jLabel1.setText("PASSWORD : ");

        jButton1.setText("OK");
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

        jButton3.setText("Change");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-513)/2, (screenSize.height-239)/2, 513, 239);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed
      private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
             if (jPasswordField1.getText() == null){
                return;
            }
            scanner readpass=null;
        try {
            try {
                readpass = new scanner(new InputStreamReader(new FileInputStream(new File(System.getProperty("user.dir").replace('\\', '/') + "/" + "pass.txt")), "UTF-8"));
            } catch (final FileNotFoundException e) {
            this.jButton1.setEnabled(false);
            this.jButton3.setEnabled(false);
            //bugno sem122fWiimBjtut
            final ErrorDisplay err=new ErrorDisplay("sem122fWiimBjtut");
            err.setVisible(true);
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                    new UnabletoShoot(err,null,false).setVisible(true);
                }
            });
            err.addReportAction(new Report() {
                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting("file with pass is missing maybe somebody has tempered with it");
                }
            });
            }
        } catch (final UnsupportedEncodingException e) {
            //bugno sem123fWiimBjtut
            final ErrorDisplay err=new ErrorDisplay("sem123fWiimBjtut");
            err.setVisible(true);
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                    new UnabletoShoot(err,null,false).setVisible(true);
                }
            });
            err.addReportAction(new Report() {
                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting("Encoding exception on this computer to UTF-8");
                }
            });
        }
            String str=null;
            try{
                str = readpass.nextLine();
            }catch(final Exception e){
            this.jButton3.setEnabled(false);
            //bugno sem124fWiimBjtut
            final ErrorDisplay err=new ErrorDisplay("sem124fWiimBjtut");
            err.setVisible(true);
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                    new UnabletoShoot(err,null,false).setVisible(true);
                }
            });
            err.addReportAction(new Report() {
                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting("Somebody removed the line from pass file");
                }
            });
            return;
            }
             if (jPasswordField1.getText().equals(str)){
                billhead billhead=new billhead();
                if(!billhead.doAsk())
                    new billing().setVisible(true);
                else
                    billhead.setVisible(true);
                dispose();
           }
            try{
            readpass.close();
          }catch(final Exception e){
              //bugno sem125fWiimBjtut
            final ErrorDisplay err=new ErrorDisplay("sem125fWiimBjtut");
            err.setVisible(true);
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                }
            });
            err.addReportAction(new Report() {
                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting("Could not close the pass file");
                }
            });
          }
    }//GEN-LAST:event_jButton1ActionPerformed
      class showLoad extends Thread{
            loadingdata load;
          public showLoad(){

          }
          public void newLoad(){
              load=new loadingdata();
          }
       public loadingdata getLoad(){
              return load;
          }

        @Override
        public void run(){
                 load.beginShow();
                 load.setVisible(true);
           }
       }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        changepass changepass=new changepass();
        changepass.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static String encrypt(String s){
int i=0;
String h="";
char[] a=s.toCharArray();
while(i<s.length()){
    try{
h+=Character.toChars(Character.codePointAt(a, i)-10)[0];
    }catch(final Exception e){
            //bugno sem126fWiimBjtut
            final ErrorDisplay err=new ErrorDisplay("sem126fWiimBjtut");
            err.setVisible(true);
            err.troubleshootButton.setEnabled(false);
            err.reportButton.setEnabled(false);
            err.ignoreButton.setEnabled(false);
            err.setWarning("Note the Error ID, contact the Administrator and Exit the program to prevent corruption of data");
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                    UnabletoShoot shoot=new UnabletoShoot(err,null,false);
                    shoot.setVisible(true);
                }
            });
            err.addReportAction(new Report() {
                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting("string cannot be encrypted");
                }
            });
            Thread.currentThread().stop();
        }
i++; 
}
return h;
}
    public static String decrypt(String s){
int i=0;
String h="";
char[] a=s.toCharArray();
while(i<s.length()){
try{
    h+=Character.toChars(Character.codePointAt(a, i)+10)[0];
}catch(final Exception e){
                //bugno sem127fWiimBjtut
            final ErrorDisplay err=new ErrorDisplay("sem127fWiimBjtut");
            err.setVisible(true);
            err.troubleshootButton.setEnabled(false);
            err.reportButton.setEnabled(false);
            err.ignoreButton.setEnabled(false);
            err.setWarning("Note the Error ID, contact the Administrator and Exit the program to prevent corruption of data");
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                    UnabletoShoot shoot=new UnabletoShoot(err,null,false);
                    shoot.setVisible(true);
                }
            });
            err.addReportAction(new Report() {
                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting("string cannot be dencrypted");
                }
            });
            Thread.currentThread().stop();
}
i++;
} 
return h;
}

     public static void main(String args[]) {
                     //System.out.println(passwordpro.decrypt("jm_dab["));
                     try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
            }
/*         UIManager.put("nimbusBase", Color.red);
         UIManager.put("nimbusBlueGrey", Color.yellow);
         UIManager.put("control", Color.blue);
 * 
 *//*
         try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
    * 
    */
        try {
            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {
                    new passwordpro().setVisible(true);
                }
            }); 
        } catch (Exception ex) {
            Logger.getLogger(passwordpro.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    billing billmenu;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables

}
