package Frames;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.JobAttributes.DialogType;
import java.awt.PageAttributes;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;

public class bills extends javax.swing.JFrame {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int flag = 0;
    String name, year, rems = "";
    bills current;
    askforupdate askforupdate;
    boolean done = true;
    billname billname;
    billutility billutility;
    date date;
    KeyListener keylistener = new keylistener();

    class WindowsFocusListenerDropDownPanel implements WindowFocusListener {

        public void windowGainedFocus(WindowEvent e) {
        }

        public void windowLostFocus(WindowEvent e) {
            try {
                DropDownPanel drop = ((DropDownPanel) e.getSource());
                if (drop.isVisible()) {
                    drop.dispose();
                }
            } catch (Exception exp) {
            }
        }
    }

    class DropDownPanelWindowListener implements WindowListener {

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
        }

        public void windowClosed(WindowEvent e) {
            DropDownPanel drop = (DropDownPanel) (e.getSource());
            JTable t = getTable();
            if (drop.considerChanges()) {
                t.setValueAt(drop.getText(), t.getSelectedRow(), t.getSelectedColumn());
            }
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

    class keylistener implements KeyListener {

        public void keyPressed(KeyEvent e) {
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P) {
                e.consume();
                jButton8ActionPerformed(null);
            } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X) {
                e.consume();
                jButton6ActionPerformed(null);
            } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
                e.consume();
                jButton5ActionPerformed(null);
            } else if ((e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Q) || (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_LEFT)) {
                e.consume();
                jButton2ActionPerformed(null);
            } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                e.consume();
                jButton4ActionPerformed(null);
            } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
                e.consume();
                jButton1ActionPerformed(null);
            } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_1) {
                e.consume();
                jButton7ActionPerformed(null);
            } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_B) {
                e.consume();
                jButton9ActionPerformed(null);
            } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_I) {
                e.consume();
                jButton3ActionPerformed(null);
            } else if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
                e.consume();
                String g = next((String) jComboBox1.getSelectedItem());
                if (g.equals("Year out of range") || g.equals("") || g == null) {
                    return;
                }
                try {
                    jComboBox1.setSelectedItem(g);
                    refreshing(g, name);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_SPACE) {
                JTable t = ((JTable) e.getSource());
                int row = t.getSelectedRow();
                int column = t.getSelectedColumn();
                if (column != 1) {
                    return;
                }
                e.consume();
                String name = jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex());
                DropDownPanel DropDownPanel = new DropDownPanel(ComboModel.getdrop(name, (String) jComboBox1.getSelectedItem()));
                DropDownPanel.setText((String) t.getValueAt(row, column));
                int yoffset = jTabbedPane1.getSelectedComponent().getY() + t.getParent().getY();
                Rectangle r = t.getCellRect(row, column, true);
                int a = (int) (r.getX()) + 10;
                int b = (int) (r.getY() + r.getHeight() * 2 + yoffset + 10);
                int b1 = (int) (r.getY() + r.getHeight() + yoffset - 10) - DropDownPanel.getHeight();
                if (b + DropDownPanel.getHeight() < screenSize.height) {
                    DropDownPanel.setLocationing(a, b);
                } else if (b1 > 0) {
                    DropDownPanel.setLocationing(a, b1);
                } else {
                    DropDownPanel.setLocationing(a, screenSize.height - b - 10);
                }
                DropDownPanel.setVisible(true);
                DropDownPanel.addWindowFocusListener(new WindowsFocusListenerDropDownPanel());
                DropDownPanel.addWindowListener(new DropDownPanelWindowListener());
            }
//            else if(e.getKeyCode()==KeyEvent.VK_SPACE){
//
//                System.out.println(e.getKeyChar()+","+e.getKeyCode()+","+e.getID()+","+e.getModifiers());
//
////                (new JTable().getActionForKeyStroke(KeyStroke.getKeyStroke(113, 0)));
//
//            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    class menulistener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
            jPanel1.setVisible(false);
            jPanel2.setVisible(true);
            JFrame frame = ((JFrame) (jPanel2.getParent().getParent().getParent().getParent()));
            frame.validate();
        }
    }

    class boxlistener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            jPanel2.setVisible(false);
            jPanel1.setVisible(true);
            JFrame frame = ((JFrame) (jPanel2.getParent().getParent().getParent().getParent()));
            frame.validate();
        }

        public void mouseExited(MouseEvent e) {
        }

    }

    class buttlistener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            jPanel2.setVisible(false);
            jPanel1.setVisible(true);
            JFrame frame = ((JFrame) (jPanel2.getParent().getParent().getParent().getParent()));
            frame.validate();
        }

        public void mouseExited(MouseEvent e) {
        }

    }

    private class datewindowlistener implements WindowListener {

        TypeofBills types = new TypeofBills();

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
        }

        public void windowClosed(WindowEvent e) {

            int uppane = jTabbedPane1.getSelectedIndex();
            if (uppane == -1) {
                return;
            }
            JTabbedPane pane = ((JTabbedPane) jTabbedPane1.getComponent(uppane));
            int downpane = pane.getSelectedIndex();
            if (downpane == -1) {
                return;
            }
            String[] pathis = {pathlocation.getlocation() + "/" + (String) jComboBox1.getSelectedItem() + "/" + name + "/" + types.getFolderName(uppane) + "/" + pane.getTitleAt(downpane) + ".txt"};
            JobAttributes att = new JobAttributes();
            att.setDialog(DialogType.NATIVE);
            PageAttributes pageatt = new PageAttributes();
            print print;
            print = new print(pathis, getToolkit().getPrintJob(bills.this, "Bill Print", att, pageatt), date.date);
            print.start();
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

    private class askforupdatewinlistener extends fromyearto implements WindowListener {

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
        }

        public void windowClosed(WindowEvent e) {
            if (!askforupdate.decision) {
                return;
            }
            try {
                bill bill = new bill(next((String) jComboBox1.getSelectedItem()), name, null, "");
                CopyNamefor3years((String) jComboBox1.getSelectedItem(), next((String) jComboBox1.getSelectedItem()), name);
            } catch (IOException ex) {
                Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
            }

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

    private class billutilitywinlistener implements WindowListener {

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
        }

        public void windowClosed(WindowEvent e) {
            int uppane = jTabbedPane1.getSelectedIndex();
            JTabbedPane pane = ((JTabbedPane) jTabbedPane1.getSelectedComponent());//.getTabComponentAt(uppane));
            int downpane = pane.getSelectedIndex();
            try {
                refreshing((String) jComboBox1.getSelectedItem(), name);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
            }

            jTabbedPane1.setSelectedIndex(uppane);
            pane = ((JTabbedPane) jTabbedPane1.getComponent(uppane));
            int selectedpane = -1;
            if (downpane < pane.getTabCount()) {
                pane.setSelectedIndex(selectedpane = downpane);
            } else if (downpane > 0) {
                pane.setSelectedIndex(selectedpane = downpane - 1);
            }
            if (selectedpane == downpane) {
                JViewport t1 = (JViewport) ((JScrollPane) ((JTabbedPane) jTabbedPane1.getComponent(uppane)).getComponent(downpane)).getComponent(0);//.getViewport();//.getComponent(0);
                JTable t = (JTable) t1.getComponent(0);
                selectrows(t, rem_selected_rows);
            }
            rem_selected_rows = null;

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

    public String next(String year1) {
        if (year1.equals("") || year1.equals("Year out of range")) {
            return year1;
        }
        int left = Integer.parseInt(year1.substring(0, year1.indexOf("-"))) + 1;
        int right = Integer.parseInt(year1.substring(year1.indexOf("-") + 1, year1.length())) + 1;
        if (year1.equals(jComboBox1.getItemAt(jComboBox1.getItemCount() - 1))) {
            return "Year out of range";
        }
        String y0 = "";
        if (left < 10) {
            y0 = "0";
        }
        y0 = y0 + String.valueOf(left) + "-";
        if (right < 10) {
            y0 += "0";
        }
        y0 += String.valueOf(right);
        return y0;

    }

    private bills() {
        this.setUndecorated(true);
        initComponents();
        JFrame f = new JFrame();
        jPanel1.setVisible(false);
        this.setSize(screenSize);
        jPanel1.addMouseListener(new menulistener());
        jPanel2.addMouseListener(new boxlistener());
        jButton1.addMouseListener(new buttlistener());
        jButton2.addMouseListener(new buttlistener());
        jButton3.addMouseListener(new buttlistener());
        jButton4.addMouseListener(new buttlistener());
        jButton5.addMouseListener(new buttlistener());
        jButton6.addMouseListener(new buttlistener());
        jButton7.addMouseListener(new buttlistener());
        jButton8.addMouseListener(new buttlistener());
        jButton9.addMouseListener(new buttlistener());
        jComboBox1.addMouseListener(new buttlistener());
    }

    public JTable getTable() {
        JTabbedPane pane = null;
        JViewport t1;
        JTable t = null;
        int uppane1 = jTabbedPane1.getSelectedIndex();
        int downpane1 = -1;
        if (uppane1 != -1) {
            pane = ((JTabbedPane) (jTabbedPane1.getComponent(uppane1)));
            downpane1 = pane.getSelectedIndex();
            if (downpane1 != -1) {
                t1 = (JViewport) ((JScrollPane) pane.getSelectedComponent()).getComponent(0);
                t = (JTable) t1.getComponent(0);
            }
        }
        return t;
    }

    public class billediting implements TableModelListener {

        public void tableChanged(TableModelEvent e) {
            if (flag == 0) {
                flag = 1;
                JTabbedPane pane = null;
                Rectangle visrect = null;
                JViewport t1;
                JTable t = null;
                int[] selectedrow = null;
                int[] defaultselec = {0};
                int uppane1 = jTabbedPane1.getSelectedIndex();
                int downpane1 = -1;
                if (uppane1 != -1) {
                    pane = ((JTabbedPane) (jTabbedPane1.getComponent(uppane1)));
                    downpane1 = pane.getSelectedIndex();
                    if (downpane1 != -1) {
                        t1 = (JViewport) ((JScrollPane) pane.getSelectedComponent()).getComponent(0);
                        t = (JTable) t1.getComponent(0);
                        selectedrow = t.getSelectedRows();
                        if (t.getSelectedRow() == -1) {
                            selectedrow = defaultselec;
                        }
                        visrect = t.getVisibleRect();
                    }
                }
                try {
                    save((String) jComboBox1.getSelectedItem());
                } catch (IOException ex) {
                    Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
                }
                int reml = 0;
                while (reml < t.getRowCount()) {
                    t.setValueAt("", reml, 0);
                    t.setValueAt("", reml, 1);
                    t.setValueAt("", reml, 2);
                    t.setValueAt("", reml, 3);
                    t.setValueAt("", reml, 4);
                    t.setValueAt("", reml, 5);
                    reml++;
                }
                try {
                    refreshTable((String) jComboBox1.getSelectedItem(), name, jTabbedPane1.getTitleAt(uppane1), pane.getTitleAt(downpane1) + ".txt", t);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
                }
                flag = 0;
            }
        }

    }

    public static String commate(String s) {

        String h = "";
        if (s.length() > 3) {

            String job = s.substring(0, s.length() - 3);
            int begin = 0;
            int end;
            if (job.length() % 2 != 0) {
                end = 1;
            } else {
                end = 2;
            }
            while (begin < job.length()) {

                h += job.substring(begin, end);
                h += ",";
                begin = end;
                end += 2;

            }
            h += s.subSequence(s.length() - 3, s.length());
        } else {
            h = s;
        }
        h += "/-";
        return h;
    }

    public class billnamewinlistener implements WindowListener {

        TypeofBills types = new TypeofBills();

        public void windowOpened(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
        }

        public void windowClosed(WindowEvent e) {
            try {
                if (!billname.decision) {
                    return;
                }
                boolean make = false;
                try {
                    make = (new File(pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + name + "/" + types.getFolderName(jTabbedPane1.getSelectedIndex()) + "/" + billname.newname.toUpperCase() + ".txt")).createNewFile();
                } catch (IOException ex) {
                    new error_1().setVisible(true);
                    return;
                }
                if (!make) {
                    new error_1().setVisible(true);
                    return;
                }
                boolean mix = mix(false, pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + name + "/" + types.getFolderName(jTabbedPane1.getSelectedIndex()) + "/" + billname.newname.toUpperCase() + ".txt", pathlocation.getlocation() + previous((String) jComboBox1.getSelectedItem()) + "/" + name + "/" + types.getFolderName(jTabbedPane1.getSelectedIndex()) + "/" + billname.newname.toUpperCase() + ".txt");
                boolean mix1 = mix(mix, pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + name + "/" + types.getFolderName(jTabbedPane1.getSelectedIndex()) + "/" + billname.newname.toUpperCase() + ".txt", pathlocation.getlocation() + previous(previous((String) jComboBox1.getSelectedItem())) + "/" + name + "/" + types.getFolderName(jTabbedPane1.getSelectedIndex()) + "/" + billname.newname.toUpperCase() + ".txt");
                mix(mix1, pathlocation.getlocation() + jComboBox1.getSelectedItem() + "/" + name + "/" + types.getFolderName(jTabbedPane1.getSelectedIndex()) + "/" + billname.newname.toUpperCase() + ".txt", pathlocation.getlocation() + previous(previous(previous((String) jComboBox1.getSelectedItem()))) + "/" + name + "/" + types.getFolderName(jTabbedPane1.getSelectedIndex()) + "/" + billname.newname.toUpperCase() + ".txt");
                int selected = jTabbedPane1.getSelectedIndex();
                try {
                    refreshing((String) jComboBox1.getSelectedItem(), name);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
                }
                jTabbedPane1.setSelectedIndex(selected);
                JTabbedPane pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
                int i = 0;
                while (i < pane.getComponentCount()) {
                    if (pane.getTitleAt(i).equals(billname.newname)) {
                        pane.setSelectedIndex(i);
                        break;
                    }
                    i++;
                }
            } catch (IOException ex) {
                Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    public boolean mix(boolean oncedone, String dest, String source) throws IOException {
        if (!(new File(source)).exists()) {
            return oncedone;
        }
        File f = new File(dest);
        File f1 = new File(f.getParent() + "/" + "1q2m.txt");
        f1.createNewFile();
        String newyear = f.getParentFile().getParentFile().getParentFile().getName();
        scanner readsource = new scanner(new InputStreamReader(new FileInputStream(new File(dest)), "UTF-8"));
        writer output = new writer();
        output.init((new FileWriter(f1)));
        while (readsource.hasNextLine()) {
            String s = readsource.nextLine();
            if (s.length() > 5) {
                if (s.charAt(s.length() - 3) == '-' && Character.isDigit(s.charAt(s.length() - 5)) && Character.isDigit(s.charAt(s.length() - 1))) {
                    s = s.substring(0, s.length() - 5) + newyear;
                    oncedone = true;
                }
            }
            output.write(s.substring(0, s.lastIndexOf(',')) + "," + "0" + "\r\n");
        }
        readsource.close();
        scanner read = new scanner(new InputStreamReader(new FileInputStream(new File(source)), "UTF-8"));
        while (read.hasNextLine()) {
            String h = read.nextLine();
            readsource = new scanner(new InputStreamReader(new FileInputStream(new File(dest)), "UTF-8"));
            int match = 0;
            String hs = h.substring(0, h.lastIndexOf(','));
            while (readsource.hasNextLine()) {
                String g = readsource.nextLine();
                String gs = g.substring(0, g.lastIndexOf(','));
                if (h.substring(0, h.lastIndexOf(',')).equalsIgnoreCase(g.substring(0, g.lastIndexOf(',')))) {
                    match = 1;
                } else if (hs.length() > 5 && gs.length() > 5) {
                    if (hs.charAt(hs.length() - 3) == '-' && gs.charAt(gs.length() - 3) == '-') {
                        if (hs.substring(0, hs.length() - 5).equalsIgnoreCase(gs.substring(0, gs.length() - 5))) {
                            match = 1;
                        }
                    }
                }
            }
            if (match == 0) {
                String hsub = h.substring(0, h.lastIndexOf(','));
                output.write(hsub + "," + "0" + "\r\n");
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

    public void CopyFields(String source, String dest) throws FileNotFoundException, IOException {
        scanner readsource = new scanner(new InputStreamReader(new FileInputStream(new File(source)), "UTF-8"));
        writer output = new writer();
        output.init((new FileWriter(new File(dest))));
        while (readsource.hasNextLine()) {
            String s = readsource.nextLine();
            output.write(s.substring(0, s.lastIndexOf(',')) + "," + "0" + "\r\n");
        }
        output.close();
        readsource.close();
    }

    public bills(String year1, String name1, JComboBox box) throws FileNotFoundException, IOException {
        current = (bills) this;
        year = year1;
        name = name1;
        if (!ActiveLocation.isActiveLocation((String) box.getSelectedItem() + "," + name)) {
            rems = (String) box.getSelectedItem();
            ActiveLocation.addActiveLocation((String) box.getSelectedItem() + "," + name);
        } else {
            new AlreadyOpened().setVisible(true);
            return;
        }
        this.setUndecorated(true);
        initComponents();
        jPanel1.setVisible(false);
        this.setSize(screenSize);
        jPanel1.addMouseListener(new menulistener());
        jPanel2.addMouseListener(new boxlistener());
        jButton1.addMouseListener(new buttlistener());
        jButton2.addMouseListener(new buttlistener());
        jButton3.addMouseListener(new buttlistener());
        jButton4.addMouseListener(new buttlistener());
        jButton5.addMouseListener(new buttlistener());
        jButton6.addMouseListener(new buttlistener());
        jButton7.addMouseListener(new buttlistener());
        jButton8.addMouseListener(new buttlistener());
        jButton9.addMouseListener(new buttlistener());
//    jButton10.addMouseListener(new buttlistener());
        jComboBox1.addMouseListener(new buttlistener());
        File f = new File(pathlocation.getlocation());
        String[] years = new SortAlphabatically().sort(f.list());
        int i = 0;
        while (i < years.length) {
            jComboBox1.addItem(years[i]);
            i++;
        }
        jComboBox1.setSelectedIndex(box.getSelectedIndex());
        refreshing(year, name);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("New Bill");

        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton3.setText("Insert Row");
        jButton3.setToolTipText("ShortCut Key : Ctrl + I");
        jButton3.setNextFocusableComponent(this.getCurrentTable());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jComboBox1.setToolTipText("ShortCut Key : Ctrl + -> (For Next Year)");
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox1MousePressed(evt);
            }
        });
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeVisible(evt);
            }
        });
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton4.setText("Delete Row");
        jButton4.setToolTipText("ShortCut Key : Delete");
        jButton4.setNextFocusableComponent(this.getCurrentTable());
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton1.setText("New Bill");
        jButton1.setToolTipText("ShortCut Key : Ctrl+ N");
        jButton1.setNextFocusableComponent(this.getCurrentTable());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton9.setText("New Name");
        jButton9.setToolTipText("ShortCut Key : Ctrl + B");
        jButton9.setNextFocusableComponent(this.getCurrentTable());
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton7.setText("Bill Utility");
        jButton7.setToolTipText("ShortCut Key : Ctrl + 1");
        jButton7.setNextFocusableComponent(this.getCurrentTable());
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton5.setText("Move Up");
        jButton5.setToolTipText("ShortCut Key ; Ctrl + Z");
        jButton5.setNextFocusableComponent(this.getCurrentTable());
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton8.setText("Print");
        jButton8.setToolTipText("Print this Bill\nShortCut Key : Ctrl + P");
        jButton8.setNextFocusableComponent(this.getCurrentTable());
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton2.setText("Done");
        jButton2.setToolTipText("ShortCut Key : Escape\nor\nShortCut Key : Alt + <-");
        jButton2.setNextFocusableComponent(this.getCurrentTable());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        jButton6.setText("Move Down");
        jButton6.setToolTipText("ShortCut Key : Ctrl + X");
        jButton6.setNextFocusableComponent(this.getCurrentTable());
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9, jComboBox1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9, jComboBox1});

        jPanel2.setBackground(new java.awt.Color(153, 180, 209));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(java.awt.SystemColor.activeCaptionText);
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OPTIONS");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                shortcut_listener(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Component getCurrentTable() {
        if (jTabbedPane1.getTabCount() == 0) {
            return null;
        }
        JTabbedPane pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
        if (pane.getTabCount() == 0) {
            return null;
        }

        int uppane = jTabbedPane1.getSelectedIndex();
        int billat = pane.getSelectedIndex();
        JViewport t1 = (JViewport) ((JScrollPane) pane.getSelectedComponent()).getComponent(0); //.getViewport();//.getComponent(0);
        JTable t = (JTable) t1.getComponent(0);
        return t;
    }

    public void click(Rectangle r) {
        this.click(r, 0, 0);
    }

    public void click(Rectangle r, int x, int y) {
        Robot robo = null;
        try {
            robo = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
        robo.mouseMove((int) (r.getX() + r.getWidth() * .5) + x, (int) (r.getY() + r.getHeight() * .5) + y);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mousePress(InputEvent.BUTTON1_MASK);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ActiveLocation.removeActiveLocation((String) jComboBox1.getSelectedItem() + "," + name);
        try {
            save((String) jComboBox1.getSelectedItem());
        } catch (IOException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ((jComboBox1.getSelectedIndex() != jComboBox1.getItemCount() - 1) && (!(new File(pathlocation.getlocation() + "/" + next((String) jComboBox1.getSelectedItem()) + "/" + name)).exists())) {
            askforupdate = new askforupdate((String) jComboBox1.getSelectedItem(), (String) jComboBox1.getItemAt(jComboBox1.getItemCount() - 1), name);
            askforupdate.setVisible(true);
            askforupdate.addWindowListener(new askforupdatewinlistener());
        }
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            //////////
            if (!done) {
                //System.out.println("two processes");
                System.exit(0);
                return;
            }
            done = false;
            if (rems.equals(jComboBox1.getSelectedItem())) {
                done = true;
                return;
            }
            if (ActiveLocation.isActiveLocation((String) jComboBox1.getSelectedItem() + "," + name)) {
                jComboBox1.setSelectedItem(rems);
                new AlreadyOpened().setVisible(true);
                done = true;
                return;
            }
            ActiveLocation.removeActiveLocation(rems + "," + name);
            ActiveLocation.addActiveLocation((String) jComboBox1.getSelectedItem() + "," + name);
            rems = (String) jComboBox1.getSelectedItem();
            /////////////
            int uppane = jTabbedPane1.getSelectedIndex();
            JTabbedPane p1;
            String downpane = "";
            if (uppane != -1) {
                p1 = ((JTabbedPane) jTabbedPane1.getComponent(uppane));
                if (p1.getTabCount() != 0) {
                    downpane = ((JTabbedPane) jTabbedPane1.getSelectedComponent()).getTitleAt(((JTabbedPane) jTabbedPane1.getSelectedComponent()).getSelectedIndex());
                }
            }
            try {
                // TODO add your handling code here:
                refreshing((String) jComboBox1.getSelectedItem(), name);
                //refreshing((String) jComboBox1.getSelectedItem(), name);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (uppane != -1 && jTabbedPane1.getTabCount() != 0) {
                jTabbedPane1.setSelectedIndex(uppane);
                JTabbedPane pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
                int i = 0;
                while (i < pane.getTabCount()) {
                    if (pane.getTitleAt(i).equals(downpane)) {
                        pane.setSelectedIndex(i);
                        break;
                    }
                    i++;
                }
                if (pane.getSelectedIndex() == -1) {
                    if (pane.getTabCount() != 0) {
                        pane.setSelectedIndex(0);
                    }
                }
            }
            done = true;
        } catch (Exception ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTabbedPane1.getSelectedIndex() == -1) {
            return;
        }
        billname = new billname((String) jComboBox1.getSelectedItem(), name, jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()));
        billname.setVisible(true);
        billname.addWindowListener(new billnamewinlistener());
//         jButton1.transferFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1MousePressed

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        //TODO add your handling code here:
        //System.err.println("YEAH!!!!  :  "+(String)jComboBox1.getSelectedItem());
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeVisible
        // TODO add your handling code here:
        try {
            save((String) jComboBox1.getSelectedItem());
        } catch (IOException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeVisible

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            if (jTabbedPane1.getTabCount() == 0) {
                return;
            }
            JTabbedPane pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
            if (pane.getTabCount() == 0) {
                return;
            }
            int uppane = jTabbedPane1.getSelectedIndex();
            int billat = pane.getSelectedIndex();
            JViewport t1 = (JViewport) ((JScrollPane) pane.getSelectedComponent()).getComponent(0); //.getViewport();//.getComponent(0);
            JTable t = (JTable) t1.getComponent(0);
            flag = 1;
            // t.getModel().removeTableModelListener(new billediting());
            int insert = t.getSelectedRow();
            int i = 0;
            while (!t.getValueAt(i, 0).equals("")) {
                i++;
            }
            if (insert != -1) {
                while (i > insert) {
                    if (t.getValueAt(i - 1, 0) != " ") {
                        t.setValueAt((Integer) t.getValueAt(i - 1, 0) + 1, i, 0);
                    } else {
                        t.setValueAt(" ", i, 0);
                    }
                    t.setValueAt(t.getValueAt(i - 1, 1), i, 1);
                    t.setValueAt(t.getValueAt(i - 1, 2), i, 2);
                    t.setValueAt(t.getValueAt(i - 1, 3), i, 3);
                    t.setValueAt(t.getValueAt(i - 1, 4), i, 4);
                    t.setValueAt(t.getValueAt(i - 1, 5), i, 5);
                    i--;
                }
            }

            t.setValueAt("", insert, 1);
            t.setValueAt("0", insert, 2);
            t.setValueAt("--", insert, 3);
            t.setValueAt("--", insert, 4);
            t.setValueAt("--", insert, 5);
            flag = 0;
            save((String) jComboBox1.getSelectedItem());
        } catch (IOException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        try {
            // TODO add your handling code here:
            if (jTabbedPane1.getTabCount() == 0) {
                return;
            }
            JTabbedPane pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
            if (pane.getTabCount() == 0) {
                return;
            }
            int uppaneIndex = jTabbedPane1.getSelectedIndex();
            String uppaneTitle  = jTabbedPane1.getTitleAt(uppaneIndex);
            int billat = pane.getSelectedIndex();
            JViewport t1 = (JViewport) ((JScrollPane) pane.getSelectedComponent()).getComponent(0); //.getViewport();//.getComponent(0);
            JTable t = (JTable) t1.getComponent(0);
            flag = 1;
            // t.getModel().removeTableModelListener(new billediting());
            int[] delete = t.getSelectedRows();
            int i = 0;
            if (delete.length != 0) {
                while (i < delete.length) {
//            t.setValueAt("" , delete[i], 0);
                    t.setValueAt("", delete[i], 1);
                    t.setValueAt("", delete[i], 2);
//             t.setValueAt("" , delete[i], 3);
//            t.setValueAt("" , delete[i], 4);
//             t.setValueAt("" , delete[i], 5);
                    i++;
                }
            }
            flag = 0;
            save((String) jComboBox1.getSelectedItem());
//            refreshing((String) jComboBox1.getSelectedItem(),name);
            refreshTable((String) jComboBox1.getSelectedItem(), name, uppaneTitle, pane.getTitleAt(pane.getSelectedIndex()) + ".txt", t);
            t.clearSelection();
            selectrows(t, delete);
        } catch (IOException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            if (jTabbedPane1.getTabCount() == 0) {
                return;
            }
            JTabbedPane pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
            int uppane1 = jTabbedPane1.getSelectedIndex();
            if (pane.getTabCount() == 0) {
                return;
            }
            int downpane1 = pane.getSelectedIndex();
            JViewport t1 = (JViewport) ((JScrollPane) pane.getSelectedComponent()).getComponent(0); //.getViewport();//.getComponent(0);
            JTable t = (JTable) t1.getComponent(0);
            flag = 1;
            int[] rows = t.getSelectedRows();
            int[] newrows = t.getSelectedRows();
//            t.clearSelection();
            int i = 0;
            flag = 1;
            int nomoverow = 0;
            while (i < rows.length) {
                if (rows[i] != nomoverow) {
                    if (t.getValueAt(rows[i], 1).equals("New Name") || t.getValueAt(rows[i] - 1, 1).equals("New Name")) {
                        String temp = String.valueOf(t.getValueAt(rows[i], 0));
                        t.setValueAt(t.getValueAt(rows[i] - 1, 0), rows[i], 0);
                        t.setValueAt(temp, rows[i] - 1, 0);
                    }
                    String temp1 = (String) t.getValueAt(rows[i] - 1, 1);
                    String temp2 = (String) t.getValueAt(rows[i] - 1, 2);
                    t.setValueAt(t.getValueAt(rows[i], 1), rows[i] - 1, 1);
                    t.setValueAt(t.getValueAt(rows[i], 2), rows[i] - 1, 2);
                    t.setValueAt(temp1, rows[i], 1);
                    t.setValueAt(temp2, rows[i], 2);
                    newrows[i] -= 1;
                }
                i++;
                nomoverow++;
            }
            flag = 0;
            save((String) jComboBox1.getSelectedItem());
            selectrows(t, newrows);
        } catch (IOException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public void selectrows(JTable t, int[] newrows) {
        if (newrows == null) {
            return;
        }
        int i = 0;
        t.setRowSelectionInterval(0, newrows[newrows.length - 1] + 1);
        int k = 0;
        while (i <= newrows[newrows.length - 1] + 1) {
            if (k >= newrows.length || i != newrows[k]) {
                t.removeRowSelectionInterval(i, i);
            } else {
                k++;
            }
            i++;
        }
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        /*      try {
            // TODO add your handling code here:
            if (jTabbedPane1.getTabCount() == 0) {
                return;
            }
            JTabbedPane pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
            int uppane1 = jTabbedPane1.getSelectedIndex();
            if (pane.getTabCount() == 0) {
                return;
            }
            int downpane1 = pane.getSelectedIndex();
            JViewport t1 = (JViewport) ((JScrollPane)pane.getSelectedComponent()).getComponent(0); //.getViewport();//.getComponent(0);
            JTable t = (JTable) t1.getComponent(0);
            flag = 1;
            int[] rows = t.getSelectedRows();
            int[] newrows = t.getSelectedRows();
            int i = rows.length-1;
            flag = 1;
            int nomoverow = 0;
            while(t.getValueAt(nomoverow, 0)!=""){
                nomoverow++;
            }
            nomoverow--;
            while (i >=0) {
                if (rows[i] < nomoverow) {
                    String temp1 = (String) t.getValueAt(rows[i]+1 ,1);
                    String temp2 = (String) t.getValueAt(rows[i]+1 ,2);
                    t.setValueAt(t.getValueAt(rows[i], 1), rows[i] + 1, 1);
                    t.setValueAt(t.getValueAt(rows[i], 2), rows[i] + 1, 2);
                    t.setValueAt(temp1, rows[i], 1);
                    t.setValueAt(temp2, rows[i], 2);
                    newrows[i] += 1;
                }
                if(rows[i]>nomoverow)
                    nomoverow++;
                i--;
                nomoverow--;
            }
            flag = 0;
            save((String) jComboBox1.getSelectedItem());
            refreshTable((String) jComboBox1.getSelectedItem(),name,jTabbedPane1.getTitleAt(uppane1),pane.getTitleAt(downpane1)+".txt",t);
            //refreshing((String) (jComboBox1.getSelectedItem()), name);
            //jTabbedPane1.setSelectedIndex(uppane);
            //((JTabbedPane) jTabbedPane1.getComponent(uppane)).setSelectedIndex(downpane);
            //pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
            //t1 = (JViewport) ((JScrollPane)pane.getSelectedComponent()).getComponent(0); //.getViewport();//.getComponent(0);
            //t = (JTable) t1.getComponent(0);
            selectrows(t, newrows);
        } catch (IOException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
        


         */

//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if (jTabbedPane1.getTabCount() == 0) {
                return;
            }
            JTabbedPane pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
            int uppane1 = jTabbedPane1.getSelectedIndex();
            if (pane.getTabCount() == 0) {
                return;
            }
            int downpane1 = pane.getSelectedIndex();
            JViewport t1 = (JViewport) ((JScrollPane) pane.getSelectedComponent()).getComponent(0); //.getViewport();//.getComponent(0);
            JTable t = (JTable) t1.getComponent(0);
            flag = 1;
            int[] rows = t.getSelectedRows();
            int[] newrows = t.getSelectedRows();
            int i = rows.length - 1;
            flag = 1;
            int nomoverow = 0;
            while (!t.getValueAt(nomoverow, 0).equals("")) {
                nomoverow++;
            }
            nomoverow--;
            //System.err.println("*"+"nommoverow="+nomoverow+" i="+i+" rows");
            while (i >= 0) {
                if (rows[i] < nomoverow) {
                    if (t.getValueAt(rows[i], 1).equals("New Name") || t.getValueAt(rows[i] + 1, 1).equals("New Name")) {
                        String temp = String.valueOf(t.getValueAt(rows[i], 0));
                        t.setValueAt(t.getValueAt(rows[i] + 1, 0), rows[i], 0);
                        t.setValueAt(temp, rows[i] + 1, 0);
                    }
                    String temp1 = (String) t.getValueAt(rows[i] + 1, 1);
                    String temp2 = (String) t.getValueAt(rows[i] + 1, 2);
                    t.setValueAt(t.getValueAt(rows[i], 1), rows[i] + 1, 1);
                    t.setValueAt(t.getValueAt(rows[i], 2), rows[i] + 1, 2);
                    t.setValueAt(temp1, rows[i], 1);
                    t.setValueAt(temp2, rows[i], 2);
//                    System.err.println("its : "+t.getValueAt(rows[i], 1));
                    newrows[i] += 1;
                }
                if (rows[i] > nomoverow) {
                    nomoverow++;
                }
                i--;
                nomoverow--;
            }
            flag = 0;
            save((String) jComboBox1.getSelectedItem());
//            refreshTable((String) jComboBox1.getSelectedItem(),name,jTabbedPane1.getTitleAt(uppane1),pane.getTitleAt(downpane1)+".txt",t);
            /*        refreshing((String) (jComboBox1.getSelectedItem()), name);
            jTabbedPane1.setSelectedIndex(uppane);
            ((JTabbedPane) jTabbedPane1.getComponent(uppane)).setSelectedIndex(downpane);
            pane = (JTabbedPane) jTabbedPane1.getSelectedComponent();
            t1 = (JViewport) ((JScrollPane)pane.getSelectedComponent()).getComponent(0); //.getViewport();//.getComponent(0);
            t = (JTable) t1.getComponent(0);
     * 
             */
//         jButton6.transferFocus();
            selectrows(t, newrows);
        } catch (IOException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private int[] rem_selected_rows;

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int uppane = jTabbedPane1.getSelectedIndex();
        if (uppane == -1) {
            return;
        }
        JTabbedPane pane = ((JTabbedPane) jTabbedPane1.getSelectedComponent());//.getTabComponentAt(uppane));
        int downpane = pane.getSelectedIndex();
        if (downpane == -1) {
            return;
        }
        JViewport t1 = (JViewport) ((JScrollPane) ((JTabbedPane) jTabbedPane1.getComponent(uppane)).getComponent(downpane)).getComponent(0);//.getViewport();//.getComponent(0);
        JTable t = (JTable) t1.getComponent(0);
        rem_selected_rows = t.getSelectedRows();
        billutility = new billutility(jTabbedPane1, (String) jComboBox1.getSelectedItem(), name);
        billutility.setVisible(true);
        billutility.addWindowListener(new billutilitywinlistener());
//         jButton7.transferFocus();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        date = new date();
        date.setVisible(true);
        date.addWindowListener(new datewindowlistener());
//jButton8.transferFocus();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int uppane = jTabbedPane1.getSelectedIndex();
        if (uppane == -1) {
            return;
        }
        JTabbedPane pane = ((JTabbedPane) jTabbedPane1.getComponent(uppane));
        int downpane = pane.getSelectedIndex();
        if (downpane == 1) {
            return;
        }
        flag = 1;
        JTabbedPane tpane = (JTabbedPane) jTabbedPane1.getComponent(uppane);
        JViewport t1 = (JViewport) ((JScrollPane) tpane.getComponent(downpane)).getComponent(0);//.getViewport();//.getComponent(0);
        JTable t = (JTable) t1.getComponent(0);
        if (t.getSelectedRow() == -1) {
            return;
        }
        t.setValueAt(" ", t.getSelectedRow(), 0);
        t.setValueAt("New Name", t.getSelectedRow(), 1);
        flag = 0;
        t.setValueAt("New", t.getSelectedRow(), 2);
        try {
            save((String) jComboBox1.getSelectedItem());
        } catch (IOException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
//              jButton9.transferFocus();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void shortcut_listener(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_shortcut_listener
        keylistener.keyPressed(evt);
    }//GEN-LAST:event_shortcut_listener

    public void save(String syear) throws IOException {
        TypeofBills types = new TypeofBills();
        int k = 0;
        while (k < jTabbedPane1.getTabCount()) {
            JTabbedPane tpane = (JTabbedPane) jTabbedPane1.getComponent(k);
            int i = 0;
            while (i < tpane.getComponentCount()) {
                File f = new File(pathlocation.getlocation() + syear + "/" + name + "/" + types.getFolderName(k) + "/" + tpane.getTitleAt(i) + ".txt");
                JViewport t1 = (JViewport) ((JScrollPane) tpane.getComponent(i)).getComponent(0);
                JTable t = (JTable) t1.getComponent(0);
                int m = 0;
                writer output = new writer();
                output.init((new FileWriter(f)));
                StringBuffer sbuff = null;
                int hashindex;
                while (m < t.getRowCount()) {
                    if (!((String) t.getValueAt(m, 1)).equals("") || !((String) t.getValueAt(m, 2)).equals("")) {
                        sbuff = new StringBuffer((String) t.getValueAt(m, 1));
                        while ((hashindex = sbuff.indexOf(String.valueOf(syear))) != -1) {
                            sbuff.replace(hashindex, hashindex + 5, "##");
                        }
                        output.write(sbuff.toString() + ",");
                        if (((String) t.getValueAt(m, 2)).equals("") && !((String) t.getValueAt(m, 1)).equals("")) {
                            output.write("" + "\r\n");
                        } else {
                            output.write((String) t.getValueAt(m, 2) + "\r\n");
                        }
                    }
                    m++;
                }
                output.close();
                i++;
            }
            k++;
        }
    }

    public String previous(String year1) {

        if (year1.equals("Year out of range")) {
            return year1;
        }
        int left = Integer.parseInt(year1.substring(0, year1.indexOf("-"))) - 1;
        int right = Integer.parseInt(year1.substring(year1.indexOf("-") + 1, year1.length())) - 1;
        if (left < 0) {
            return "Year out of range";
        }
        String y0 = "";
        if (left < 10) {
            y0 = "0";
        }
        y0 = y0 + String.valueOf(left) + "-";
        if (right < 10) {
            y0 += "0";
        }
        y0 += String.valueOf(right);
        return y0;

    }

    public void refreshing(String iyear, String iname) throws FileNotFoundException {
        JTable[][] billtable;
        TypeofBills types = new TypeofBills();

        jTabbedPane1.removeAll();
        if (!(new File(pathlocation.getlocation() + iyear + "/" + iname)).exists()) {
            return;
        }
        JTabbedPane typeofpane[] = new JTabbedPane[types.getFolderName().length];
        int k = 0;
        int temp = 0;
        int length;
        while (k < types.getFolderName().length) {
            File f = new File(pathlocation.getlocation() + iyear + "/" + iname + "/" + types.getFolderName(k));
            length = new SortAlphabatically().sort(f.list()) == null ? 0 : f.list().length;
            if (temp < length) {
                temp = length;
            }
            k++;
        }
        billtable = new JTable[types.getFolderName().length][temp];
        JScrollPane[][] billpane = new JScrollPane[types.getFolderName().length][temp];
        k = 0;
        while (k < types.getFolderName().length) {
            File f = new File(pathlocation.getlocation() + iyear + "/" + iname + "/" + types.getFolderName(k));
            typeofpane[k] = new JTabbedPane();
            jTabbedPane1.add(types.getTabHeadName(k), typeofpane[k]);
            String[] billname1 = new SortAlphabatically().sort(f.list());
            int i = 0;
            final String[] drop = ComboModel.getdrop(types.getTabHeadName(k), iyear).clone();
            while (i < (billname1 == null ? 0 : billname1.length)) {

                ComboModel ComboModel = new ComboModel(iyear);
                ComboModel = new ComboModel(iyear);

                JComboBox combo = new JComboBox(drop);
                combo.setEditable(true);
                DefaultCellEditor editor = new DefaultCellEditor(combo);
                billtable[k][i] = new JTable();
                billpane[k][i] = new JScrollPane();
                billtable[k][i].setModel(ComboModel);
                billtable[k][i].getColumnModel().getColumn(0).setMaxWidth(50);
                billtable[k][i].getColumnModel().getColumn(1).setMinWidth(550);

                billtable[k][i].getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {

                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        JComboBox box = new JComboBox(drop);
                        box.setEditable(true);
                        box.setSelectedItem(value);
                        return box;
                    }
                });

//                 ActionMap actionMap = billtable[k][i].getActionMap();
//                 Object[] allKeys = actionMap.allKeys();
//
//                for(int y=0;y<actionMap.allKeys().length;y++)
//                    System.out.println(actionMap.allKeys()[y]);
//                System.out.println("**************************************");
//
//                actionMap.put(actionMap.get(allKeys[37]),actionMap.get(3));
                billtable[k][i].getColumnModel().getColumn(1).setCellEditor(editor);
                billtable[k][i].setRowHeight(25);
                Font font = new Font("Times New Roman", 1, 15);
                billtable[k][i].setFont(font);
                billpane[k][i].setViewportView(billtable[k][i]);
                //billtable[k][i].getModel().removeTableModelListener(new billediting());
                typeofpane[k].add(billname1[i].substring(0, billname1[i].lastIndexOf(".")), billpane[k][i]);
                billtable[k][i].setColumnSelectionAllowed(true);
                billtable[k][i].setRowSelectionAllowed(true);
                billtable[k][i].getModel().addTableModelListener(new billediting());
                billtable[k][i].addKeyListener(keylistener);

                refreshTable(iyear, iname, types.getFolderName(k), billname1[i], billtable[k][i]);
                i++;
            }
            k++;
        }
    }

    public void refreshTable(String iyear, String iname, String itype, String billname, JTable t) throws FileNotFoundException {
        if (t == null) {
            return;
        }
        flag = 1;
//        JTable jTable = new JTable();
//        jTable.setModel(new ComboModel());
//        t=jTable;

        for (int i = 0; i < t.getRowCount(); i++) {
            t.setValueAt("", i, 0);
            t.setValueAt("", i, 1);
            t.setValueAt("", i, 2);
            t.setValueAt("", i, 3);
            t.setValueAt("", i, 4);
            t.setValueAt("", i, 5);
        }

        File f1 = new File(pathlocation.getlocation() + iyear + "/" + iname + "/" + itype + "/" + billname);
        if (!f1.exists()) {
            flag = 0;
            return;
        }
        File f2 = new File(pathlocation.getlocation() + previous(iyear) + "/" + iname + "/" + itype + "/" + billname);
        File f3 = new File(pathlocation.getlocation() + previous(previous(iyear)) + "/" + iname + "/" + itype + "/" + billname);
        File f4 = new File(pathlocation.getlocation() + previous(previous(previous(iyear))) + "/" + iname + "/" + itype + "/" + billname);

        scanner read = null;
        try {
            read = new scanner(new InputStreamReader(new FileInputStream(f1), "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
        int totalcolumn1 = 0, totalcolumn2 = 0, totalcolumn3 = 0, totalcolumn4 = 0, nrows = 0;
        while (read.hasNextLine()) {
            nrows++;
            read.nextLine();
        }
        read.close();
        String[][] a = new String[nrows][6];
        try {
            read = new scanner(new InputStreamReader(new FileInputStream(f1), "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }
        int kl = 0;
        String line;
        while (read.hasNextLine()) {
            line = read.nextLine();
            a[kl][0] = new String();
            a[kl][0] = line.substring(0, line.lastIndexOf(','));
            a[kl][1] = new String();
            a[kl][1] = line.substring(line.lastIndexOf(',') + 1);
            try {
                totalcolumn1 += Integer.parseInt(a[kl][1]);
            } catch (Exception e) {
            }
            kl++;
        }
        read.close();

        kl = 0;
        int u = 0;
        while (kl < nrows) {
            u = kl + 1;
            while (u < nrows) {
                if (a[kl][0].equalsIgnoreCase(a[u][0])) {
                    a[u][5] = "";
                }
                u++;
            }
            kl++;
        }

        String lines;
        if (f2.exists()) {
            try {
                read = new scanner(new InputStreamReader(new FileInputStream(f2), "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (read.hasNextLine()) {
                lines = read.nextLine();
                kl = 0;
                while (kl < nrows) {
                    if (lines.substring(0, lines.lastIndexOf(',')).equalsIgnoreCase(a[kl][0]) && !a[kl][0].equals("New Name")) {
                        if (a[kl][2] == null) {
                            a[kl][2] = lines.substring(lines.lastIndexOf(',') + 1);
                        } else if (!lines.substring(lines.lastIndexOf(',') + 1).equals("")) {
                            a[kl][2] = a[kl][2] + "," + lines.substring(lines.lastIndexOf(',') + 1);
                        }
                    }
                    kl++;
                }
            }
            read.close();
        }
        if (f3.exists()) {
            try {
                read = new scanner(new InputStreamReader(new FileInputStream(f3), "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (read.hasNextLine()) {
                lines = read.nextLine();
                kl = 0;
                while (kl < nrows) {
                    if (lines.substring(0, lines.lastIndexOf(',')).equalsIgnoreCase(a[kl][0]) && !a[kl][0].equals("New Name")) {
                        if (a[kl][3] == null) {
                            a[kl][3] = lines.substring(lines.lastIndexOf(',') + 1);
                        } else if (!lines.substring(lines.lastIndexOf(',') + 1).equals("")) {
                            a[kl][3] = a[kl][3] + "," + lines.substring(lines.lastIndexOf(',') + 1);
                        }
                    }
                    kl++;
                }
            }
            read.close();
        }
        if (f4.exists()) {
            try {
                read = new scanner(new InputStreamReader(new FileInputStream(f4), "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (read.hasNextLine()) {
                lines = read.nextLine();
                kl = 0;
                while (kl < nrows) {
                    if (lines.substring(0, lines.lastIndexOf(',')).equalsIgnoreCase(a[kl][0]) && !a[kl][0].equals("New Name")) {
                        if (a[kl][4] == null) {
                            a[kl][4] = lines.substring(lines.lastIndexOf(',') + 1);
                        } else if (!lines.substring(lines.lastIndexOf(',') + 1).equals("")) {
                            a[kl][4] = a[kl][4] + "," + lines.substring(lines.lastIndexOf(',') + 1);
                        }
                    }
                    kl++;
                }
            }
            read.close();
        }
        int counter = 0;
        int indices = 0;
        int ind = 0;
        while (counter < nrows) {
            StringBuffer r = new StringBuffer(a[counter][0]);
            while (r.indexOf("##") != -1) {
                r.replace(r.indexOf("##"), r.indexOf("##") + 2, iyear);
            }
            t.setValueAt(r.toString(), counter, 1);
            //t.setValueAt(a[counter][0],counter, 1);
            if (a[counter][0].equals("New Name")) {
                indices++;
                t.setValueAt(" ", counter, 0);
            } else {
                t.setValueAt(counter - indices + 1, counter, 0);
            }
            t.setValueAt(a[counter][1] == null ? "--" : a[counter][1], counter, 2);
            /*    if(a[counter][5]!=null){
       Rectangle rect=t.getCellRect(counter, 3, true);
       Graphics graphics=t.getGraphics();
       graphics.setColor(Color.red);
       graphics.fillRect((int)rect.getX(), (int)rect.getY(), rect.width, rect.height);
    }
 *
             */
            if (a[counter][5] == null) {
                int rem;
                if (a[counter][2] != null) {
                    if (a[counter][2].indexOf(',') == -1) {
                        totalcolumn2 += Integer.parseInt(a[counter][2]);
                    } else {
                        ind = 0;
                        do {
                            rem = a[counter][2].indexOf(',', ind + 1);
                            try {
                                totalcolumn2 += Integer.parseInt(a[counter][2].substring(ind, rem == -1 ? a[counter][2].length() : rem));
                            } catch (Exception e) {
                            }
                            ind = rem + 1;
                        } while (ind != 0);
                    }
                }
                if (a[counter][3] != null) {
                    if (a[counter][3].indexOf(',') == -1) {
                        totalcolumn3 += Integer.parseInt(a[counter][3]);
                    } else {
                        ind = 0;
                        do {
                            rem = a[counter][3].indexOf(',', ind + 1);
                            try {
                                totalcolumn3 += Integer.parseInt(a[counter][3].substring(ind, rem == -1 ? a[counter][3].length() : rem));
                            } catch (Exception e) {

                            }
                            ind = rem + 1;
                        } while (ind != 0);
                    }
                }
                if (a[counter][4] != null) {
                    if (a[counter][4].indexOf(',') == -1) {
                        totalcolumn4 += Integer.parseInt(a[counter][4]);
                    } else {
                        ind = 0;
                        do {
                            rem = a[counter][4].indexOf(',', ind + 1);
                            try {
                                totalcolumn4 += Integer.parseInt(a[counter][4].substring(ind, rem == -1 ? a[counter][4].length() : rem));
                            } catch (Exception e) {

                            }
                            ind = rem + 1;
                        } while (ind != 0);
                    }
                }
            }
            t.setValueAt(a[counter][2] == null ? "--" : a[counter][2], counter, 3);
            t.setValueAt(a[counter][3] == null ? "--" : a[counter][3], counter, 4);
            t.setValueAt(a[counter][4] == null ? "--" : a[counter][4], counter, 5);
            counter++;
        }
        t.getColumnModel().getColumn(2).setHeaderValue("Total = " + commate(String.valueOf(totalcolumn1)) + "  Rs.");
        t.getColumnModel().getColumn(3).setHeaderValue(commate(String.valueOf(totalcolumn2)) + "  Rs. for " + previous(iyear));
        t.getColumnModel().getColumn(4).setHeaderValue(commate(String.valueOf(totalcolumn3)) + "  Rs. for " + previous(previous(iyear)));
        t.getColumnModel().getColumn(5).setHeaderValue(commate(String.valueOf(totalcolumn4)) + "  Rs. for " + previous(previous(previous(iyear))));
        t.getTableHeader().repaint();
        flag = 0;
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(bills.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new bills()).setVisible(true);

            }

        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;

    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
