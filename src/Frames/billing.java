package Frames;

import Listener.FileListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class billing extends javax.swing.JFrame {
    Thread mainThread;
    Dimension SCREEN_SIZE=Toolkit.getDefaultToolkit().getScreenSize();
    int width=(int)((SCREEN_SIZE.getWidth()-8*10)/7);
    private class finalbackupwinlistener extends utility implements WindowListener{

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
  //          throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosed(WindowEvent e) {
              mainThread=Thread.currentThread();
             String work=pathlocation.actualLocation();
             //System.out.println("actual work:"+work);
            if(!finalbackup.decision){
             }
            else{
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String today;
            today=dateFormat.format(calendar.getTime());
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if(calendar.get(Calendar.AM_PM) == 0)
        am_pm = "AM";
        else
        am_pm = "PM";
            File writeto = new File(System.getProperty("user.dir").replace('\\', '/') + "/" + "backupto.txt");
            scanner readit=null;
            try {
                 readit = new scanner(new InputStreamReader(new FileInputStream(writeto), "UTF-8"));
            } catch (Exception ex) {
                Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
            }
            String location=readit.nextLine();
             backup(location+"/"+today+"+"+String.valueOf(hour)+"."+String.valueOf(minute)+"."+String.valueOf(second)+am_pm+"/");
        readit.close();
         }
             System.exit(0);
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
static finalbackup finalbackup;
    public class billingwindowlistener implements WindowListener{

        public void windowOpened(WindowEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
           }

        public void windowClosing(WindowEvent e) {
            if(e!=null)
                return;
                 finalbackup=new finalbackup();
                 finalbackup.setVisible(true);
                 finalbackup.addWindowListener(new finalbackupwinlistener());
            }

        public void windowClosed(WindowEvent e) {
    //        throw new UnsupportedOperationException("Not supported yet.");
            //System.out.println("EXITING");
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

    public class utilitywinlistener implements WindowListener{

        public void windowOpened(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
          }

        public void windowClosed(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
         jTable1.getModel().addTableModelListener(new billlistener());
         refresh();
         }

        public void windowIconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeiconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowActivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeactivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

     }

    public  class deletionwinlistener implements WindowListener{

        public void windowOpened(WindowEvent e) {
           // throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosed(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        if(confirmdeletion.decision==1){
            int[] row=confirmdeletion.index;
            int m=0;
            while(m<row.length){
                if(jTable1.getValueAt(row[m],0)!=null){
                    scanner s12 = null;
                    try {
                             s12 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + (String) jTable1.getValueAt(row[m], 1) + "/" + "serialno.txt")), "UTF-8"));
                        } catch (Exception ex) {
                            Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
                        }
                            String g=s12.nextLine();
                    if(Character.isDigit( g.charAt(g.length()-1))){
                         updateserial((String)jComboBox1.getSelectedItem(),row[m],-1,0);
                 }
                            s12.close();
                            TypeofBills typeofbill=new TypeofBills();
                            String[] typeofbills=typeofbill.getFolderName();
                int k=0;
                while(k<typeofbills.length){
                    File f=new File(pathlocation.getlocation()+jComboBox1.getSelectedItem()+"/"+jTable1.getValueAt(row[m], 1)+"/"+typeofbills[k]);
                String tax[]=new SortAlphabatically().sort(f.list());
                int i=0;
                while(tax!=null&&i<tax.length){
                    (new File(pathlocation.getlocation()+jComboBox1.getSelectedItem()+"/"+jTable1.getValueAt(row[m], 1)+"/"+typeofbills[k]+"/"+tax[i])).delete();
                    i++;
                }
                    (new File(pathlocation.getlocation()+jComboBox1.getSelectedItem()+"/"+jTable1.getValueAt(row[m], 1)+"/"+typeofbills[k])).delete();

                k++;
                }
                (new File(pathlocation.getlocation()+jComboBox1.getSelectedItem()+"/"+jTable1.getValueAt(row[m], 1)+"/billfromto.txt")).delete();
                (new File(pathlocation.getlocation()+jComboBox1.getSelectedItem()+"/"+jTable1.getValueAt(row[m], 1)+"/serialno.txt")).delete();
                        boolean delete = (new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + jTable1.getValueAt(row[m], 1))).delete();
                 }
                m++;

            }
            new File(pathlocation.getlocation()).setLastModified(Calendar.getInstance().getTimeInMillis());
            refresh();
        }
        }
        public void windowIconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeiconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowActivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeactivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

     }

    public  class mod1 implements WindowListener {

      
        public void windowOpened(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosing(WindowEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowClosed(WindowEvent e) {
            try {
                //    throw new UnsupportedOperationException("Not supported yet.");
               rename((String)jComboBox1.getSelectedItem() ,mod.oldname, mod.newname );
                File f1 = new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + mod.newname + "/");
                writer output = new writer();
                output.init((new FileWriter(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + mod.newname + "/billfromto.txt"))));
                output.write(mod.newbillno);
                output.close();
             } catch (IOException ex) {
                Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
            }
            new File(pathlocation.getlocation()).setLastModified(Calendar.getInstance().getTimeInMillis());
            refresh();
        }

        public void windowIconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeiconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowActivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        public void windowDeactivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        
    }
    private void rename(String year,String s, String s1) throws IOException {
            //throw new UnsupportedOperationException("Not yet implemented");
            bill b;
            if(!s.equals(s1)){
                int e=0;
                String names[]=new SortAlphabatically().sort(new File(pathlocation.getlocation()+"/"+year).list());
                int rank=0,rank2=0;
                while(rank<names.length&&s1.compareTo(names[rank])>0){
                    rank++;
                }
                                    scanner s12 = null;
                    try {
                              s12 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + s + "/" + "serialno.txt")), "UTF-8"));
                        } catch (Exception ex) {
                            Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String g=s12.nextLine();

                String names1[]=new SortAlphabatically().sort(new File(pathlocation.getlocation()+"/"+year).list());
               while(rank2<names1.length&&s.compareTo(names1[rank2])>0){
                    rank2++;
                }
                    if(Character.isDigit( g.charAt(g.length()-1))){
                         updateserial((String)jComboBox1.getSelectedItem(),rank2,-1,0);
                 }
                            s12.close();
            
               String ser="",sno="";
       if(rank>0){
                try {
                      s12 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names[rank - 1] + "/" + "serialno.txt")), "UTF-8"));
                    ser = s12.nextLine();
                     s12.close();
                    if (!mod.lateentry) {
                        if(Character.isLetter(ser.charAt(ser.length()-1))){
                                sno=String.valueOf( Integer.parseInt(ser.substring(0, ser.length()-1))+1);
                        }
                         else{
                                        sno=String.valueOf( Integer.parseInt(ser)+1);
                          }
                        updateserial((String)jComboBox1.getSelectedItem(),rank,1,0);
                    }
                     else{
                                s12 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names[rank-1] + "/" + "serialno.txt")), "UTF-8"));
                                String as=s12.nextLine();
                                s12.close();
                                int y=rank-1;
                                while(rank>0&&Character.isLetter(as.charAt(as.length()-1))){
                                rank--;
                                s12 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names[rank] + "/" + "serialno.txt")), "UTF-8"));
                                as=s12.nextLine();
                                s12.close();
                                 y=rank;
                                }
                                ser=as;
                                int letter=0;
                                String ser1="123";
                                y++;
                                if(names.length>y){
                                      s12 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names[y] + "/" + "serialno.txt")), "UTF-8"));
                                    ser1=s12.nextLine();
                                    s12.close();
                                }
                                int rem=0;
                                while(y<names.length&&Character.isLetter(ser1.charAt(ser1.length()-1))){
                                    s12 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names[y] + "/" + "serialno.txt")), "UTF-8"));
                                    ser1 = s12.nextLine();
                                s12.close();
                                y++;
                                if(rem<Character.codePointAt(Character.toString(ser1.charAt(ser1.length()-1)).toCharArray(), 0)){
                                    rem=Character.codePointAt(Character.toString(ser1.charAt(ser1.length()-1)).toCharArray(), 0);
                                    letter=rem-Character.codePointAt(Character.toString('A').toCharArray(), 0)+1;
                                    }
                                }
                                sno=ser+Character.toString(Character.toChars(Character.codePointAt(Character.toString('A').toCharArray(), 0)+letter)[0]);
                                 updateserial((String)jComboBox1.getSelectedItem(),rank,0,0);

                     }
                } catch (Exception ex) {
                    Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                   sno="1";
                 updateserial((String)jComboBox1.getSelectedItem(),rank,1,0);

                }
                bill bill  = new bill(year, s1, null,sno);
                TypeofBills ty=new TypeofBills();
                String[] typeofbills=ty.getFolderName();
                int k=0;
                while(k<typeofbills.length){
                    File f=new File(pathlocation.getlocation()+year+"/"+s+"/"+typeofbills[k]);

                String tax[]=new SortAlphabatically().sort(f.list());
                int i=0;
                while(i<tax.length){
                    MoveFile(pathlocation.getlocation()+year+"/"+s+"/"+typeofbills[k]+"/"+tax[i], pathlocation.getlocation()+year+"/"+s1+"/"+typeofbills[k]+"/"+tax[i]);
                    i++;
                }
                boolean delete = f.delete();
                 k++;
                }
             MoveFile(pathlocation.getlocation()+year+"/"+s+"/billfromto.txt", pathlocation.getlocation()+year+"/"+s1+"/billfromto.txt");
             new File(pathlocation.getlocation()+year+"/"+s+"/serialno.txt").delete();
          boolean delete1 = (new File(pathlocation.getlocation() + year + "/" + s + "/")).delete();
             }
    }
    public void MoveFile(String source,String dest) throws FileNotFoundException, IOException{
        scanner readsource=new scanner(new InputStreamReader(new FileInputStream((new File(source))), "UTF-8"));
         writer output=new writer();
        output.init((new FileWriter(new File(dest))));
        if(readsource.hasNext()){
            do{
            output.write(readsource.next()+"\r\n");
        }while(readsource.hasNext());
        }
        output.close();
        readsource.close();
        File f= new File(source);
         boolean delete = f.delete();
     }

    public class win extends fromyearto implements WindowListener {
String name,billno;
        public void windowOpened(WindowEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet.");
         }

        public void windowClosing(WindowEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet.");
         }

        public void windowClosed(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
      if(info.decision==0)
          return;
            flag=1;
        name=info.name;
        billno=null;
        String sno="";
String[] names1=new SortAlphabatically().sort(new File(pathlocation.getlocation()+"/"+(String) jComboBox1.getSelectedItem()).list());
               int rank=0;
               while(rank<names1.length&&name.compareToIgnoreCase(names1[rank])>0){
                        rank++;
               }
               String ser="";
       if(rank>0){
                try {
                    scanner s = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names1[rank - 1] + "/" + "serialno.txt")), "UTF-8"));
                    ser = s.nextLine();
                     s.close();
                    if (!info.lateentry) {
                        if(Character.isLetter(ser.charAt(ser.length()-1))){
                                sno=String.valueOf( Integer.parseInt(ser.substring(0, ser.length()-1))+1);
                        }
                         else{
                                        sno=String.valueOf( Integer.parseInt(ser)+1);
                          }
                        updateserial((String)jComboBox1.getSelectedItem(),rank,1,0);
                    }
                     else{
                                s = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names1[rank-1] + "/" + "serialno.txt")), "UTF-8"));
                                String as=s.nextLine();
                                s.close();
                                int y=rank-1;
                                while(rank>0&&Character.isLetter(as.charAt(as.length()-1))){
                                rank--;
                                s = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names1[rank] + "/" + "serialno.txt")), "UTF-8"));
                                as=s.nextLine();
                                s.close();
                                y=rank;
                                }
                                 ser=as;
                                int letter=0;
                                String ser1="123";
                                y++;
                                if(names1.length>y){
                                     s = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names1[y] + "/" + "serialno.txt")), "UTF-8"));
                                    ser1=s.nextLine();
                                    s.close();
                                }
                                int rem=0;
                                while(y<names1.length&&Character.isLetter(ser1.charAt(ser1.length()-1))){
                                    s = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + names1[y] + "/" + "serialno.txt")), "UTF-8"));
                                    ser1 = s.nextLine();
                                s.close();
                                y++;
                                if(rem<Character.codePointAt(Character.toString(ser1.charAt(ser1.length()-1)).toCharArray(), 0)){
                                    rem=Character.codePointAt(Character.toString(ser1.charAt(ser1.length()-1)).toCharArray(), 0);
                                    letter=rem-Character.codePointAt(Character.toString('A').toCharArray(), 0)+1;
                                    }

                                }
                                sno=ser+Character.toString(Character.toChars(Character.codePointAt(Character.toString('A').toCharArray(), 0)+letter)[0]);
                                updateserial((String)jComboBox1.getSelectedItem(),rank,0,0);
                    
                     }
                } catch (Exception ex) {
                    Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                   sno="1";
                 updateserial((String)jComboBox1.getSelectedItem(),rank,1,0);

                }
               bill bill  = new bill((String) jComboBox1.getSelectedItem(), name, billno,sno);
                 try {
                    CopyNamefor3years(previous((String) jComboBox1.getSelectedItem()), (String) jComboBox1.getSelectedItem(), name);
                } catch (IOException ex) {
                    Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
                }
                new File(pathlocation.getlocation()).setLastModified(Calendar.getInstance().getTimeInMillis());
                refresh();
//                System.err.println(Calendar.getInstance().getTimeInMillis()+"**"+new File(pathlocation.getlocation()).lastModified());
                flag=0;
        }
        public void windowIconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
         }

        public void windowDeiconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
         }

        public void windowActivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
         }

        public void windowDeactivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
         }


     }

        private void updateserial(String string, int rank,int sign,int charinc) {
            //throw new UnsupportedOperationException("Not yet implemented");
                String[] names=new SortAlphabatically().sort(new File(pathlocation.getlocation()+"/"+string).list());
                   int i=0;
                   int add=0;
                   if(sign>0)
                       add=1;
                   else if(sign<0)
                       add=-1;

               scanner s = null;
               writer o;
               File f = null;
               String newsno="";
            

                   while(i<names.length){
                       if(i>=rank){
                try {
                         f = new File(pathlocation.getlocation() + string + "/" + names[i] + "/" + "serialno.txt");
                        s = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
                     String sno = s.nextLine();
                    s.close();
                     if(Character.isLetter(sno.charAt(sno.length()-1))){
                        newsno=String.valueOf(Integer.parseInt(sno.substring(0, sno.length()-1))+add)+Character.toString(Character.toChars(Character.codePointAt(Character.toString(sno.charAt(sno.length()-1)).toCharArray(), 0)+charinc)[0]);
                    }
                     else{
                         newsno=String.valueOf(Integer.parseInt(sno)+add);
                        charinc=0;
                     } 
                    o = new writer();
                    o.init(new FileWriter(f));
                    o.write(newsno);
                    o.close();
                } catch (IOException ex) {
                    Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
                }
                       }
                       i++;
                   } 
        }

    /** Creates new form billing */
    public billing() {
        initComponents();
        this.addWindowListener(new billingwindowlistener());
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jTable1.getModel().addTableModelListener(new billlistener());
        jTable1.setFont(new Font("Times New Roman",0,20));
        File f=new File(pathlocation.getlocation());
        String[] years=new SortAlphabatically().sort(f.list());
        int i=0;
        while(i<years.length){
         jComboBox1.addItem(years[i]);
        i++;
        }
        refresh();
        FileMonitoring monitor=new FileMonitoring(100);
        monitor.addFile(new File(pathlocation.getlocation()));
        //System.out.println("Adding file : "+pathlocation.getlocation());
        monitor.addListener(new filelisten());
        monitor.start();
 }
    class FileMonitoring extends Thread{
        int pollingtime;
        filelisten listener=null;
        File hookfile=null;
        long modifiedat;
        public FileMonitoring(int polling){
            pollingtime=polling;
        }

        private void addListener(filelisten filelisten) {
            listener=filelisten;
        }
        @Override
        public void run(){
            while(true){
                try {
                    Thread.sleep(this.pollingtime);
                } catch (InterruptedException ex) {
                    Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.err.println("modified time : "+hookfile.lastModified());
                if(modifiedat==hookfile.lastModified()){
                    continue;
                }
                modifiedat=hookfile.lastModified();
                listener.fileChanged(hookfile);
            }
        }

        private void addFile(File file) {
            hookfile=file;
            modifiedat=file.lastModified();
        }
    }
    class filelisten implements FileListener{

        public void fileChanged(File file){
           //System.exit(0);
           refresh();
        }

    }
    public class billlistener implements TableModelListener{

        public void tableChanged(TableModelEvent e) {
             if(flag==0&&jTable1.getValueAt(e.getFirstRow(),0)!=null&&jTable1.getValueAt(e.getFirstRow(),1)!=null){
            try {
                //throw new UnsupportedOperationException("Not supported yet.");
                int row = e.getFirstRow();
                File f = new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + jTable1.getValueAt(row, 1) + "/billfromto.txt");
                writer write = new writer();
                write.init((new FileWriter(f)));
                write.write((String) jTable1.getValueAt(row, 2));
                write.close();
                /*f = new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + jTable1.getValueAt(row, 1) + "/serialno.txt");
                write.init((new FileWriter(f)));
                write.write(String.valueOf(jTable1.getValueAt(row, 0)));//.equals("") ? "-" : String.valueOf(jTable1.getValueAt(row, 0)));
                write.close();
                 * 
                 */
            } catch (IOException ex) {
                Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
/*             if(flag==0&&jTable1.getValueAt(e.getFirstRow(),0)!=null&&jTable1.getValueAt(e.getFirstRow(),1)!=null){
                refresh();
            }
 * 
 */
        }

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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Make Bills (By RISHABH JAIN)");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setEnabled(false);
        jPanel2.setFocusTraversalPolicyProvider(true);
        jPanel2.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setVerifyInputWhenFocusTarget(false);
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel2KeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setAutoscrolls(true);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "S.No.", "Name", "Bill No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(30);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        jTable1.setSelectionBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTable1.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jButton2.setText("Add New");
        jButton2.setToolTipText("ShortCut Key : Ctrl + N");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton2.setMaximumSize(null);
        jButton2.setMinimumSize(null);
        jButton2.setPreferredSize(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modify");
        jButton3.setToolTipText("ShortCut Key : Ctrl + M");
        jButton3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton3.setMaximumSize(null);
        jButton3.setMinimumSize(null);
        jButton3.setPreferredSize(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.setToolTipText("ShortCut Key : Delete");
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton4.setMaximumSize(null);
        jButton4.setMinimumSize(null);
        jButton4.setPreferredSize(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Utility");
        jButton5.setToolTipText("ShortCut Key : Ctrl + 1");
        jButton5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton5.setMaximumSize(null);
        jButton5.setMinimumSize(null);
        jButton5.setPreferredSize(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setDoubleBuffered(true);
        jComboBox1.setMaximumSize(null);
        jComboBox1.setMinimumSize(null);
        jComboBox1.setPreferredSize(null);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18));
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Data Loaded From : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18));
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));

        jButton6.setText("Exit");
        jButton6.setToolTipText("ShortCut Key : Ctrl + Q");
        jButton6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton6.setMaximumSize(null);
        jButton6.setMinimumSize(null);
        jButton6.setPreferredSize(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.setToolTipText("ShortCut Key : Ctrl + N");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jComboBox1});

        jButton2.setMaximumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton2.setPreferredSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton2.setMinimumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton3.setMaximumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton3.setPreferredSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton3.setMinimumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton4.setMaximumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton4.setPreferredSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton4.setMinimumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton5.setMaximumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton5.setPreferredSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton5.setMinimumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jComboBox1.setMaximumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jComboBox1.setPreferredSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jComboBox1.setMinimumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton6.setMaximumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton6.setPreferredSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton6.setMinimumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton2.setMaximumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton2.setPreferredSize(new Dimension((int)(this.getWidth()-8*3)/7,17));
        jButton2.setMinimumSize(new Dimension((int)(this.getWidth()-8*3)/7,17));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel2KeyReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        confirmdeletion=new confirmdeletion(jTable1);
        confirmdeletion.setVisible(true);
        confirmdeletion.addWindowListener(new deletionwinlistener());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if(jTable1.getValueAt(jTable1.getSelectedRow(),0)!=null){
            mod=new modify((String)jComboBox1.getSelectedItem(),(String)jTable1.getValueAt(jTable1.getSelectedRow(), 1),(String)jTable1.getValueAt(jTable1.getSelectedRow(), 2));
            mod.setVisible(true);
            mod.addWindowListener(new mod1());
        }
  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        info=new info((String)jComboBox1.getSelectedItem());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                info.setVisible(true);
                info.addWindowListener(new win());//.addContainerListener(new conlist());
            }
        }
        );

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_jTable1KeyTyped

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
     }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
            this.jButton1ActionPerformed(null);
        else if(evt.isControlDown() && evt.getKeyCode() == evt.VK_N)
            this.jButton2ActionPerformed(null);
        else if(evt.isControlDown() && evt.getKeyCode() == evt.VK_M)
            this.jButton3ActionPerformed(null);
        else if(evt.getKeyCode() == evt.VK_DELETE)
            this.jButton4ActionPerformed(null);
        else if(evt.isControlDown()&&evt.getKeyCode()==evt.VK_1)
            this.jButton5ActionPerformed(null);
        else if(evt.isControlDown() && evt.getKeyCode() == evt.VK_Q)
            this.jButton6ActionPerformed(null);
        else if(Character.isDigit(evt.getKeyChar()) || Character.isLetter(evt.getKeyChar()))
        {
            search=new search(evt.getKeyChar(),jTable1);
            search.setVisible(true);
        }//mama
        else if(evt.isControlDown()&&evt.getKeyCode()==evt.VK_P){
            utility utility=new utility(jComboBox1,jTable1);
            utility.button4();
            utility.dispose();
        }
}//GEN-LAST:event_jTable1KeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        // TODO add your handling code here:%
    }//GEN-LAST:event_jPanel2KeyPressed
utility utility;

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        utility=new utility(jComboBox1,jTable1);
        utility.setVisible(true);
        utility.addWindowListener(new utilitywinlistener());
    }//GEN-LAST:event_jButton5ActionPerformed
bills bills;
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        dispose();
        new billingwindowlistener().windowClosing(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()==-1)
            return;
        if(jTable1.getValueAt(jTable1.getSelectedRow(), 0)!=null){
                ////System.out.println("check for : " + (pathlocation.actualLocation() + "\\" + (String) jComboBox1.getSelectedItem() + "\\" + (String) jTable1.getValueAt(jTable1.getSelectedRow(), 1)));
                if (ActiveLocation.isActiveLocation((String) jComboBox1.getSelectedItem() + "," + (String) jTable1.getValueAt(jTable1.getSelectedRow(), 1))) {
                    new AlreadyOpened().setVisible(true);
                    return;
                }
                try {
                    bills = new bills((String) jComboBox1.getSelectedItem(), (String) jTable1.getValueAt(jTable1.getSelectedRow(), 1), jComboBox1);
                } catch (Exception ex) {
                    Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
                }
                bills.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
info info;
public void addNextYear(String year){
        jComboBox1.addItem(year);
}
public void refresh(){
    flag=1;
    File f=new File (pathlocation.getlocation()+"/"+ jComboBox1.getSelectedItem()+"/");
    ////System.out.println(f.getPath());
    int k=0;
        while(k<jTable1.getRowCount()){
            jTable1.setValueAt(null, k, 0);
            jTable1.setValueAt(null, k, 1);
            jTable1.setValueAt(null, k, 2);
            k++;
        }
         String[] list=new SortAlphabatically().sort(f.list());
         int i=0;
         while(i<list.length){
            scanner read=null;
            scanner read1=null;
            try {
                 read = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + list[i] + "/" + "billfromto.txt")), "UTF-8"));
            } catch (Exception ex) {
                Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                 read1 = new scanner(new InputStreamReader(new FileInputStream(new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + list[i] + "/" + "serialno.txt")), "UTF-8"));
            } catch (Exception ex) {
                Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
            }
            String o;
                    if(read1.hasNextLine())
                     jTable1.setValueAt(o=read1.nextLine(), i, 0);
                    else
                        jTable1.setValueAt("", i, 0);
                      read1.close();
                    jTable1.setValueAt(list[i], i, 1);
                    if(read.hasNext())
                        jTable1.setValueAt(read.nextLine(), i, 2);
                    else
                        jTable1.setValueAt("", i, 2);
                        read.close();
                   i++;
              }
         jLabel2.setText(pathlocation.getlocation().replace('/', '\\'));
        flag=0;
}
modify mod;confirmdeletion confirmdeletion;search search;
    /**
    * @param args the command line arguments
    */
public static void main(String args[]){
    new billing().setVisible(true);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    int flag=0;
}
