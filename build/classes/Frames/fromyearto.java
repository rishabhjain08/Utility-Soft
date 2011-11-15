package Frames;


import Exceptions.FileNotAvailableException;
import Exceptions.HostNotAvailableException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * fromyearto.java
 *
 * Created on Feb 2, 2011, 4:01:34 PM
 */

/**
 *
 * @author ci
 */
public class fromyearto extends javax.swing.JFrame {
public fromyearto(){
    
}
    private  class collideditemwinlistener implements WindowListener{

        public void windowOpened(WindowEvent e) {
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        public void windowClosed(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        int i=0;
        while(i<collideditems.re.size()){
                try {
                    delete((String) jComboBox2.getSelectedItem(), (String) collideditems.re.get(i));
                    bill bill = new bill((String) jComboBox2.getSelectedItem(), (String) collideditems.re.get(i), null,"");
                    CopyNamefor3years((String) jComboBox1.getSelectedItem(), (String) jComboBox2.getSelectedItem(), (String) collideditems.re.get(i));
                    i++;
                } catch (IOException ex) {
                    Logger.getLogger(fromyearto.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
        public void windowIconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeiconified(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowActivated(WindowEvent e) {
  //          throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeactivated(WindowEvent e) {
    //        throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public LinkedList threeyearbills(String string, String string0, String string1) {
        //throw new UnsupportedOperationException("Not yet implemented");
        String[] s1=new SortAlphabatically().sort((new File(string)).list());
        String[] s2=new SortAlphabatically().sort((new File(string0)).list());
        String[] s3=new SortAlphabatically().sort((new File(string1)).list());

        LinkedList lt=new LinkedList();
        int i=0;
         while(s1!=null&&i<s1.length){
          
            lt.add(s1[i]);
            i++;
        }
        i=0;
        int k=0;
        int match=0;
        while(s2!=null&&i<s2.length){
            k=0;
            match=0;
            while(k<lt.size()){
                if(s2[i]==lt.get(k))
                    match=1;
            k++;
            }
            if(match==0)
                lt.add(s2[i]);
            i++;
        }


        i=0;
         k=0;
         match=0;
        while(s3!=null&&i<s3.length){
            k=0;
            match=0;
            while(k<lt.size()){
                if(s3[i]==lt.get(k))
                    match=1;
            k++;
            }
            if(match==0)
                lt.add(s3[i]);
            i++;
        }
         return lt;




    }

    private  class copyreqfileswinlist implements WindowListener{

        public void windowOpened(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent e) {
  //          throw new UnsupportedOperationException("Not supported yet.");
         }

        public void windowClosed(WindowEvent e) {
    //        throw new UnsupportedOperationException("Not supported yet.");

        int i=0;
        while(filesbeingcopied!=null&&i<filesbeingcopied.req.size()){
                try {
                     bill bill = new bill((String) jComboBox2.getSelectedItem(), (String) filesbeingcopied.req.get(i), null,"");
                    CopyNamefor3years((String) jComboBox1.getSelectedItem(), (String) jComboBox2.getSelectedItem(), (String) filesbeingcopied.req.get(i));
                    i++;
                } catch (IOException ex) {
                    Logger.getLogger(fromyearto.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
  if(l.size()!=0){
             collideditems=new collideditems((String)jComboBox1.getSelectedItem(),(String)jComboBox2.getSelectedItem(),l);
            collideditems.setVisible(true);
            collideditems.addWindowListener(new collideditemwinlistener());        }
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

    /** Creates new form fromyearto */
    public fromyearto(JComboBox box,JTable table) {
        initComponents();
        combo=box;
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        int i=0;
        while(i<box.getItemCount()){
        jComboBox1.addItem(box.getItemAt(i));
        jComboBox2.addItem(box.getItemAt(i));
        i++;
        }
        jTable1=table;
        year=(String)box.getSelectedItem();

        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Copy Forward Data");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jLabel1.setText("From");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24));
        jLabel2.setText("To");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("OK");
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
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-351)/2, (screenSize.height-351)/2, 351, 351);
    }// </editor-fold>//GEN-END:initComponents
     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
filesbeingcopied filesbeingcopied;
LinkedList l;
collideditems collideditems;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        File f=new File(pathlocation.getlocation()+jComboBox1.getSelectedItem());
        String[] names=new SortAlphabatically().sort(f.list());
        int i=0;
         l=new LinkedList();
        LinkedList l1=new LinkedList();
        LinkedList l1billno=new LinkedList();
 scanner read = null;
        while(i<names.length){
            try {
                read = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names[i] + "/" + "billfromto.txt")), "UTF-8"));
            } catch (Exception ex) {
                Logger.getLogger(fromyearto.class.getName()).log(Level.SEVERE, null, ex);
            }
            if((new File(pathlocation.getlocation()+jComboBox2.getSelectedItem()+"/"+names[i])).exists())
                      l.add(names[i]);
                else{
                    l1.add(names[i]);
                    if(read.hasNextLine())
                    l1billno.add(read.nextLine());
                    else
                        l1billno.add("");

            }
            i++;
        }
if(l1.size()!=0){
filesbeingcopied=new filesbeingcopied(l1,l1billno);
filesbeingcopied.setVisible(true);
filesbeingcopied.addWindowListener(new copyreqfileswinlist());
        }
 else if(l.size()!=0){
            collideditems=new collideditems((String)jComboBox1.getSelectedItem(),(String)jComboBox2.getSelectedItem(),l);
            collideditems.setVisible(true);
            collideditems.addWindowListener(new collideditemwinlistener());
  }
         dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
 public void CopyNamefor3years(String year,String year1,String s) throws IOException {
            //throw new UnsupportedOperationException("Not yet implemented");
     String remyear=year;
                year=previous(year1);
                  String[] typeofbills=new TypeofBills().getFolderName();
                int k=0;
                while(k<typeofbills.length){
                    File f=new File(pathlocation.getlocation()+year+"/"+s+"/"+typeofbills[k]);

                LinkedList tax=threeyearbills(pathlocation.getlocation()+year+"/"+s+"/"+typeofbills[k],pathlocation.getlocation()+previous(year)+"/"+s+"/"+typeofbills[k],pathlocation.getlocation()+previous(previous(year))+"/"+s+"/"+typeofbills[k]);
                int i=0;
                while(i<tax.size()){
                    mix(true,pathlocation.getlocation()+year1+"/"+s+"/"+typeofbills[k]+"/"+tax.get(i), pathlocation.getlocation()+ year+"/"+s+"/"+typeofbills[k]+"/"+tax.get(i));
                    mix(true,pathlocation.getlocation()+year1+"/"+s+"/"+typeofbills[k]+"/"+tax.get(i), pathlocation.getlocation()+ previous(year)+"/"+s+"/"+typeofbills[k]+"/"+tax.get(i));
                    mix(true,pathlocation.getlocation()+year1+"/"+s+"/"+typeofbills[k]+"/"+tax.get(i), pathlocation.getlocation()+ previous(previous(year))+"/"+s+"/"+typeofbills[k]+"/"+tax.get(i));
                    i++;
                }
                 k++;
                }
             this.CopyFile(pathlocation.getlocation()+remyear+"/"+s+"/billfromto.txt", pathlocation.getlocation()+year1+"/"+s+"/billfromto.txt");
             this.CopyFile(pathlocation.getlocation()+remyear+"/"+s+"/serialno.txt", pathlocation.getlocation()+year1+"/"+s+"/serialno.txt");

    }
 public   void CopyYears(String dest) throws IOException {
            //throw new UnsupportedOperationException("Not yet implemented");
                String[] typeofbills=new TypeofBills().getFolderName();
                int l=0,m=0;
                while(l<combo.getItemCount()){
                String[] namesis=new SortAlphabatically().sort((new File(pathlocation.getlocation()+"/"+combo.getComponent(l)+"/")).list());
                String[] typis=new TypeofBills().getFolderName();
                while(m<namesis.length){
                    for(int yu=0;yu<typis.length;yu++)
                        new File(pathlocation.getlocation()+"/"+combo.getComponent(l)+"/"+namesis[m]+"/"+typis[yu]+"/").mkdirs();
                     int k=0;
                while(k<typeofbills.length){
                File f=new File(pathlocation.getlocation()+combo.getComponent(l)+"/"+namesis[m]+"/"+typeofbills[k]);
                int i=0;
                String[] tax=new SortAlphabatically().sort(f.list());
                while(i<tax.length){
                     CopyFile(pathlocation.getlocation()+"/"+combo.getComponent(l)+"/"+namesis[m]+"/"+typeofbills[k]+"/"+tax[i],dest+"/"+combo.getComponent(l)+"/"+namesis[m]+"/"+typeofbills[k]+"/"+tax[i]);
                        i++;
                }
                 k++;
                }
                CopyFile(pathlocation.getlocation()+combo.getComponent(l)+"/"+namesis[m]+"/billfromto.txt", dest+combo.getComponent(l)+"/"+namesis[m]+"/billfromto.txt");
                    m++;
                }
    l++;
                }
                
    }

   public String previous(String year1){

            if(year1==null||year1.equals("Year out of range"))
            return year1;
                int left=Integer.parseInt(year1.substring(0, year1.indexOf("-")))-1;
                int right=Integer.parseInt(year1.substring(year1.indexOf("-")+1, year1.length()))-1;
                if(left<0){
                    return "Year out of range";
                }
                String y0 ="";
                if(left<10)
                    y0="0";
                y0=y0+String.valueOf(left)+"-";
                if(right<10)
                    y0+="0";
                y0+=String.valueOf(right);
                return y0;

                }

  public boolean mix(boolean oncedone,String dest,String source) throws IOException{
    if(!(new File(source)).exists())
        return oncedone;
    File f=new File(dest);
        if(!f.exists())
            f.createNewFile();
    File f1=new File(f.getParent()+"/"+"1q2m.txt");
        f1.createNewFile();
        String newyear=f.getParentFile().getParentFile().getParentFile().getName();
        scanner readsource=new scanner(new InputStreamReader(new FileInputStream(new File(dest)), "UTF-8"));
        writer output=new writer();
        output.init((new FileWriter(f1)));
        while(readsource.hasNextLine()){
            String s=readsource.nextLine();
            if(s.equals("New Name,New"))
                continue;
            if(s.length()>5)
                if(s.charAt(s.length()-3)=='-'&&Character.isDigit(s.charAt(s.length()-5))&&Character.isDigit(s.charAt(s.length()-1))){
                    s=s.substring(0, s.length()-5)+newyear;
                    oncedone=true;
                }
            output.write(s.substring(0, s.lastIndexOf(','))+","+"0"+"\r\n");
         }
        readsource.close();
         scanner read=new scanner(new InputStreamReader(new FileInputStream(new File(source)), "UTF-8"));
         while(read.hasNextLine()){
             String h=read.nextLine();
             if(h.equals("New Name,New"))
                 continue;
        readsource=new scanner(new InputStreamReader(new FileInputStream(new File(dest)), "UTF-8"));
              int match=0;
            String hs=h.substring(0, h.lastIndexOf(','));
            while(readsource.hasNextLine()){
            String g=readsource.nextLine();
            String gs=g.substring(0, g.lastIndexOf(','));
            if(h.substring(0, h.lastIndexOf(',')).equalsIgnoreCase(g.substring(0, g.lastIndexOf(','))))
                match=1;
           }
           if(match==0){
               String hsub=h.substring(0, h.lastIndexOf(','));
                output.write(hsub+","+"0"+"\r\n");
             }
          readsource.close();
         }
         read.close();
         output.close();
        readsource.close();
        boolean delete = (new File(dest)).delete();
          f1.renameTo(new File(dest));
         return oncedone;
     }
    public void delete(String year,String s){

                int k=0;
                String[] typeofbills=new TypeofBills().getFolderName();
                while(k<typeofbills.length){
                    File f=new File(pathlocation.getlocation()+year+"/"+s+"/"+typeofbills[k]);
                String tax[]=new SortAlphabatically().sort(f.list());
                int i=0;
                while(i<tax.length){
                    (new File(pathlocation.getlocation()+year+"/"+s+"/"+typeofbills[k]+"/"+tax[i])).delete();
                    i++;
                }
                    (new File(pathlocation.getlocation()+year+"/"+s+"/"+typeofbills[k])).delete();

                k++;
                }
                (new File(pathlocation.getlocation()+year+"/"+s+"/billfromto.txt")).delete();
        boolean delete = (new File(pathlocation.getlocation() + year + "/" + s)).delete();
   }


    public void CopyFile(String source,String dest) throws FileNotFoundException, IOException{
        if(!(new File(source)).exists()){
            return;
        }
        scanner readsource=new scanner(new InputStreamReader(new FileInputStream(new File(source)), "UTF-8"));
        writer output=new writer();
        output.init( (new FileWriter(new File(dest))));
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
                new fromyearto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    JComboBox combo;
    JTable jTable1;
    String year;
}
