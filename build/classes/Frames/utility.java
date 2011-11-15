package Frames;

import Printing.PageStock;
import Printing.PreviewPage;
import Printing.PreviewPane;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.JobAttributes;
import java.awt.JobAttributes.DialogType;
import java.awt.PageAttributes;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.AttributedString;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class utility extends javax.swing.JFrame {

    private   class datewindowlistener implements WindowListener{

        public void windowOpened(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent e) {
  //          throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosed(WindowEvent e) {
    //        throw new UnsupportedOperationException("Not supported yet.");
        if(jTable1.getSelectedRowCount()==0)
            return;
        int[] indices=jTable1.getSelectedRows();
         File f;
         int i=0,m=0,k=0;
         LinkedList l=new LinkedList();
         while(m<indices.length){
         if(jTable1.getValueAt(m, 0)==null){
             m++;
             continue;
             }
         TypeofBills types=new TypeofBills();
            k=0;
            String[] fname=types.getFolderName();
            while (k < fname.length) {
            f=new File(pathlocation.getlocation()+"/"+jComboBox1.getSelectedItem()+"/"+jTable1.getValueAt(indices[m], 1)+"/"+fname[k]);
            String[] billnames=new SortAlphabatically().sort(f.list());
            String[] paths=new String[billnames.length];
             i=0;
            while(i<billnames.length){
                l.add(pathlocation.getlocation()+"/"+jComboBox1.getSelectedItem()+"/"+jTable1.getValueAt(indices[m], 1)+"/"+fname[k]+"/"+billnames[i]);
                i++;
            }
            k++;
        }
         m++;
        }
         String[] pathis1=new String[l.size()];
         i=0;
         while(i<l.size()){
             pathis1[i]=(String)l.get(i);
             i++;
         }
   JobAttributes att=new JobAttributes();
    att.setDialog(DialogType.NATIVE);
    PageAttributes pageatt=new PageAttributes();
         print print;
         print = new print(pathis1, getToolkit().getPrintJob(utility.this, "Bill Print", att,pageatt),date.date);
         print.start();
         }

        public void windowIconified(WindowEvent e) {
      //      throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeiconified(WindowEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowActivated(WindowEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeactivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

     }

    /** Creates new form utility */
    public utility(JComboBox combo,JTable table) {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jComboBox1=combo;
        jTable1=table;
    }

    public utility() {
      //  throw new UnsupportedOperationException("Not yet implemented");
        initComponents();
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
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Utility");

        jPanel1.setMinimumSize(new java.awt.Dimension(795, 569));
        jPanel1.setPreferredSize(new java.awt.Dimension(795, 569));

        jButton1.setText("Copy Data");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(59, 35));
        jButton1.setMinimumSize(new java.awt.Dimension(59, 35));
        jButton1.setPreferredSize(new java.awt.Dimension(59, 35));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Next Year");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(59, 35));
        jButton2.setMinimumSize(new java.awt.Dimension(59, 35));
        jButton2.setPreferredSize(new java.awt.Dimension(59, 35));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        jButton4.setText("Print the Bills");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed1(evt);
            }
        });

        jButton5.setText("Print the Menu");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(59, 35));
        jButton5.setMinimumSize(new java.awt.Dimension(59, 35));
        jButton5.setPreferredSize(new java.awt.Dimension(59, 35));
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("BackUp Data");
        jButton6.setMaximumSize(new java.awt.Dimension(59, 35));
        jButton6.setMinimumSize(new java.awt.Dimension(59, 35));
        jButton6.setPreferredSize(new java.awt.Dimension(59, 35));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Auto BackUp to");
        jButton7.setMaximumSize(new java.awt.Dimension(59, 35));
        jButton7.setMinimumSize(new java.awt.Dimension(59, 35));
        jButton7.setPreferredSize(new java.awt.Dimension(59, 35));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("EXIT");
        jToggleButton2.setActionCommand("CLIENT");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Load Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToggleButton3.setText("Add New Tab");
        jToggleButton3.setActionCommand("CLIENT");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Edit Drop Down List");
        jToggleButton4.setActionCommand("CLIENT");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton6, jButton7, jToggleButton3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton4, jButton5, jToggleButton2, jToggleButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jToggleButton2, jToggleButton3, jToggleButton4});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        fromyearto fromyearto=new fromyearto(jComboBox1,jTable1);
        fromyearto.setVisible(true);
}//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            String s = (String) jComboBox1.getItemAt(jComboBox1.getItemCount()-1);
            int left=Integer.parseInt(s.substring(0, s.indexOf("-"))) + 1;
            int right=Integer.parseInt(s.substring(s.indexOf("-") + 1, s.length())) + 1;
            String nextyear;
            if(left<10)
                 nextyear = "0"+String.valueOf(left);
            else
                nextyear=String.valueOf(left);
            nextyear+="-";
            if(right<10)
                nextyear+="0";
            nextyear+=String.valueOf(right);
            jComboBox1.addItem(nextyear);
            confirmnextyear confirmnextyear = new confirmnextyear(nextyear);
            confirmnextyear.setVisible(true);
            (new File(pathlocation.getlocation()+nextyear)).mkdir();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_jButton2MouseReleased

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

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here: 
JobAttributes att=new JobAttributes();
att.setDialog(DialogType.NATIVE);
PageAttributes pageatt=new PageAttributes();
printthemenu printthemenu=new printthemenu();
printthemenu.init(jTable1,getToolkit().getPrintJob(utility.this, "Menu Print", att,pageatt),(String)jComboBox1.getSelectedItem());
printthemenu.start();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseReleased
     private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
            JFileChooser file  = new JFileChooser();
            file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            file.showOpenDialog(null);
            if(file.getSelectedFile()==null)
                return;
           String dest=file.getSelectedFile().getPath().replace('\\', '/')+"/bills/";
           String[] typeofbills=new TypeofBills().getFolderName();
                int l=0,m=0;
        new File(file.getSelectedFile().getPath().replace('\\', '/')).mkdirs();
        try {
            new File(file.getSelectedFile().getPath().replace('\\', '/') + "/activelocation.txt").createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
        }
                 while(l<jComboBox1.getItemCount()){
                     (new File(dest+"/"+jComboBox1.getItemAt(l))).mkdirs();
                     String[] namesis=new SortAlphabatically().sort((new File(pathlocation.getlocation()+"/"+jComboBox1.getItemAt(l)+"/")).list());
                     String[] typis=new TypeofBills().getFolderName();
                 while(m<namesis.length){
                     for(int yu=0;yu<typis.length;yu++)
                            new File(dest+"/"+jComboBox1.getItemAt(l)+"/"+namesis[m]+"/"+typis[yu]+"/").mkdirs();

         int k=0;
                while(k<typeofbills.length){
                File f=new File(pathlocation.getlocation()+jComboBox1.getItemAt(l)+"/"+namesis[m]+"/"+typeofbills[k]);
                int i=0;
                String[] tax=new SortAlphabatically().sort(f.list());
                while(i<tax.length){
                        try {
                            CopyFile(pathlocation.getlocation() + "/" + jComboBox1.getItemAt(l)+ "/" + namesis[m] + "/" + typeofbills[k] + "/" + tax[i], dest + "/" + jComboBox1.getItemAt(l) + "/" + namesis[m] + "/" + typeofbills[k] + "/" + tax[i]);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i++;
                }
                 k++;
                }
                try {
                    CopyFile(pathlocation.getlocation() + jComboBox1.getItemAt(l) + "/" + namesis[m] + "/billfromto.txt", dest + jComboBox1.getItemAt(l) + "/" + namesis[m] + "/billfromto.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    CopyFile(pathlocation.getlocation() + jComboBox1.getItemAt(l) + "/" + namesis[m] + "/serialno.txt", dest + jComboBox1.getItemAt(l) + "/" + namesis[m] + "/serialno.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                }
                    m++;
                }
    l++;
                }

    
         

    }//GEN-LAST:event_jButton6ActionPerformed

    public void backup(String dest){
        new File(dest).mkdirs();
        try {
            new File(dest + "/activelocation.txt").createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        dest=dest+"/bills/";
        boolean mkdirs = (new File(dest)).mkdirs();
        if(!mkdirs) {
            System.out.println("Could not make one");
            System.exit(0);
        }
        String[] typeofbills=new TypeofBills().getFolderName();
                int l=0,m=0;
String[] yearsrange=new SortAlphabatically().sort((new File(pathlocation.getlocation()+"/")).list());
                 while(l<yearsrange.length){
                     (new File(dest+"/"+yearsrange[l])).mkdirs();
                     String[] namesis=new SortAlphabatically().sort((new File(pathlocation.getlocation()+"/"+yearsrange[l]+"/")).list());
                     String typis[]=new TypeofBills().getFolderName();
                 while(m<namesis.length){
                     for(int yu=0;yu<typis.length;yu++)
                        new File(dest+"/"+yearsrange[l]+"/"+namesis[m]+"/"+typis[yu]+"/").mkdirs();

         int k=0;
                while(k<typeofbills.length){
                File f=new File(pathlocation.getlocation()+yearsrange[l]+"/"+namesis[m]+"/"+typeofbills[k]);
                int i=0;
                String[] tax=new SortAlphabatically().sort(f.list());
                while(i<tax.length){
                        try {
                            CopyFile(pathlocation.getlocation() + "/" + yearsrange[l]+ "/" + namesis[m] + "/" + typeofbills[k] + "/" + tax[i], dest + "/" + yearsrange[l] + "/" + namesis[m] + "/" + typeofbills[k] + "/" + tax[i]);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        i++;
                }
                 k++;
                }
                try {
                    CopyFile(pathlocation.getlocation() + yearsrange[l] + "/" + namesis[m] + "/billfromto.txt", dest + yearsrange[l]+ "/" + namesis[m] + "/billfromto.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    CopyFile(pathlocation.getlocation() + yearsrange[l] + "/" + namesis[m] + "/serialno.txt", dest + yearsrange[l] + "/" + namesis[m] + "/serialno.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
                }
                    m++;
                }
    l++;
                }
    }
    private void jButton4ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed1
        // TODO add your handling code here:
this.button4();
}//GEN-LAST:event_jButton4ActionPerformed1
public void button4(){
         date=new date();
     date.setVisible(true);
     date.addWindowListener(new datewindowlistener());



}
    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            File writeto = new File(System.getProperty("user.dir").replace('\\', '/') + "/" + "backupto.txt");
            scanner readbackup = new scanner(new InputStreamReader(new FileInputStream(writeto), "UTF-8"));
            String a=null;
            if(readbackup.hasNextLine()) {
                a=readbackup.nextLine();
             fileChooser.setCurrentDirectory(new File(a.replace('\\', '/')+"/"));
             }
                readbackup.close();
                fileChooser.showOpenDialog(null);
            if (fileChooser.getSelectedFile() != null) {
                writer o = new writer();
                o.init((new FileWriter(writeto)));
                o.write(fileChooser.getSelectedFile().getPath().replace('\\', '/'));
                o.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(utility.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            JFileChooser filechooser=new JFileChooser();
            filechooser.setVisible(true);
            filechooser.setCurrentDirectory(new File(pathlocation.getolocation().replace('\\', '/')));
            filechooser.setDialogTitle("SELECT DATA LOCATION");
            filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            filechooser.showOpenDialog(null);
            if(filechooser.getSelectedFile()!=null)
                pathlocation.setLocation(filechooser.getSelectedFile().getPath(), pathlocation.server);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        new NewTabName().setVisible(true);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        new DropDownList().setVisible(true);
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    public void CopyFile(String source,String dest) throws FileNotFoundException, IOException{
        if(!(new File(source)).exists())
            return; 
        scanner readsource=new scanner(new InputStreamReader(new FileInputStream(new File(source)), "UTF-8"));
         writer output=new writer();
        output.init((new FileWriter(new File(dest))));
        while(readsource.hasNextLine()){
             output.write(readsource.nextLine()+"\r\n");
         }
        output.close();
        readsource.close();
     }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new utility().setVisible(true);
            }
        });
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration//GEN-END:variables
    JComboBox jComboBox1;
    JTable jTable1;
}
class GlobalValues{
    static loadingdata load;
    public static void setNewloadingdata(){
        load=new loadingdata();
    }
    public static loadingdata getloadingdata(){
        return load;
    }
}
class printthemenu extends Thread{
static JTable t;
static PrintJob pjob1;
static String year;
public static void init(JTable t1,PrintJob pjob2,String year1){
    t=t1;
    pjob1=pjob2;
    year=year1;
    }
@Override
public void run(){
    if(pjob1==null)
        return;
    ProgressBar bar=new ProgressBar();
    bar.start();
    Font f1;
    PageStock STOCK=new PageStock(pjob1);
    STOCK.setPreviewType(4);
    STOCK.addPage(new PreviewPage());
    STOCK.setPageSize(new Dimension(STOCK.getPrintJob().getPageDimension()));
    int nonzero=0;
    printmenu pmenu=new printmenu(STOCK);
        while(t.getValueAt(nonzero, 0)!=null)
            nonzero++;
    LinkedList l = new LinkedList();
    f1=new Font("Times New Roman",1,12);
    Font menuhead=new Font("Times New Roman",1,14);
    int i=0;
    double width2=STOCK.getPrintJob().getPageDimension().getWidth()-100;
    scanner reader1=null;
    int index=0;
    AttributedString as1;
   String helpatt1;
    pmenu.pageHeight=STOCK.getPrintJob().getPageDimension().height-20;
     pmenu.printLine("",f1);
    pmenu.printLine("",f1);
    String[] headis=new billhead1().getIndexSheetHead();
    String main=headis[0];
    StringBuffer d=null;
    if(!main.equals("")){
    d=new StringBuffer(headis[0]);
    int yu=0;
    System.err.println(headis[0]);
    while((yu=d.indexOf("##"))!=-1)
        d.replace(yu, yu+2, year);
    main=d.toString();
            helpatt1=pmenu.widthfont(width2,menuhead,main,.5)+main+pmenu.widthfont(width2,menuhead,main,.5);
    as1=new AttributedString(helpatt1);
    as1.addAttribute(TextAttribute.FONT, menuhead);
    as1.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL,helpatt1.length()-(main+pmenu.widthfont(width2,menuhead,main,.5)).length(),helpatt1.length()-pmenu.widthfont(width2,menuhead,main,.5).length());
    pmenu.printLine(as1,menuhead);
    }
    if(!(main=headis[1]).equals("")){
    d=new StringBuffer(headis[1]);
    int yu=0;
    while((yu=d.indexOf("##"))!=-1)
        d.replace(yu, yu+2, year);
    main=d.toString();
    helpatt1=pmenu.widthfont(width2,menuhead,main,.5)+main+pmenu.widthfont(width2,menuhead,main,.5);
    as1=new AttributedString(helpatt1);
    as1.addAttribute(TextAttribute.FONT, menuhead);
    as1.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL,helpatt1.length()-(main+pmenu.widthfont(width2,menuhead,main,.5)).length(),helpatt1.length()-pmenu.widthfont(width2,menuhead,main,.5).length());
    pmenu.printLine(as1,menuhead);
    }
    if(!headis[2].equals("")){
    d=new StringBuffer(headis[2]);
    int yu=0;
    while((yu=d.indexOf("##"))!=-1)
        d.replace(yu, yu+2, year);
    main=d.toString();
    helpatt1=pmenu.widthfont(width2,menuhead,main,.5)+main+pmenu.widthfont(width2,menuhead,main,.5);
    as1=new AttributedString(helpatt1);
    as1.addAttribute(TextAttribute.FONT, menuhead);
    as1.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_TWO_PIXEL,helpatt1.length()-(main+pmenu.widthfont(width2,menuhead,main,.5)).length(),helpatt1.length()-pmenu.widthfont(width2,menuhead,main,.5).length());
    pmenu.printLine(as1,menuhead);
    }
        pmenu.printLine("",f1);
    pmenu.printLine("",f1);
    pmenu.printLine("",f1);
  helpatt1="S.No."+"    "+"Name of Client"+pmenu.widthfont(width2-100-100,f1,"S.No."+"    "+"Name of Client",1.0)+"Bill No."+pmenu.widthfont(100,f1,"Bill No.",1.0)+"Remarks";
 AttributedString asm=new AttributedString(helpatt1);
 pmenu.printLine(asm,f1);
    AttributedString asm1=new AttributedString(pmenu.widthfont(width2,f1,"",1.0));
    asm1.addAttribute(TextAttribute.FONT, f1);
    asm1.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_DASHED,0,pmenu.widthfont(width2,f1,"",1.0).length());
    pmenu.printLine(asm1,f1);
    while(i<nonzero){
     String billnumber="";
        if(t.getValueAt(i, 0)==null){
        i++;
        continue;
    }
            try {
                reader1 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + "/" + year + "/" + (String) t.getValueAt(i, 1) + "/billfromto.txt")), "UTF-8"));
            } catch (Exception ex) {
                Logger.getLogger(printthemenu.class.getName()).log(Level.SEVERE, null, ex);
            }
    l.clear();
  scanner s12=null;
            try {
                s12 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + year + "/" + (String) t.getValueAt(i, 1) + "/" + "serialno.txt")), "UTF-8"));
            } catch (Exception ex) {
                Logger.getLogger(printthemenu.class.getName()).log(Level.SEVERE, null, ex);
            }
  String serial=s12.nextLine();
  s12.close();

    l=pmenu.breakstring(width2-100-100-80,(String)t.getValueAt(i, 1),f1,1.0);
/*    int y=0;
            while(y<l.size()){
                System.out.println("Broken into :"+l.get(y));
                y++;
            }
 * 
 */
    int k=0;
   FontMetrics fontmetricf1=STOCK.getFontMetrics(f1);
   int serialwidth=fontmetricf1.stringWidth("S.No."+"    ");
    while(k<l.size()-1){
     if(k==0)
/**/    pmenu.printLine(serial+"."+pmenu.widthfont(serialwidth-fontmetricf1.stringWidth(serial+"." ),f1,"",1.0)+(String)l.get(k)+pmenu.widthfont(width2-100-100-serialwidth,f1,(String)l.get(k)+(String)l.get(k),1.0)+billnumber,f1);
    else
/**/        pmenu.printLine(pmenu.widthfont(serialwidth,f1,"",1.0)+(String)l.get(k),f1);
    k++;
    }
    if(reader1.hasNextLine())
        billnumber=reader1.nextLine();
    if(k==0){
    //System.out.println("HERE");
/**/    pmenu.printLine(serial+"."+pmenu.widthfont(serialwidth-fontmetricf1.stringWidth( serial+"."),f1,"",1.0)+(String)l.get(k)+pmenu.widthfont(width2-100-100-serialwidth,f1,(String)l.get(k),1.0)+billnumber,f1);
    }
    else
/**/    pmenu.printLine(pmenu.widthfont(serialwidth,f1,"",1.0)+(String)l.get(k)+pmenu.widthfont(width2-100-100-serialwidth,f1,(String)l.get(k),1.0)+billnumber,f1);
     pmenu.printLine(asm1,f1);

    i++;
    index++;
    reader1.close();
    }
     new PreviewPane(STOCK).setVisible(true);
     bar.dispose();
    }
}