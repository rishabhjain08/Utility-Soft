//done
package Frames;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DropDownPanel extends javax.swing.JFrame {
    private Object selected;
    private Object[] items;
    private boolean changed=true;
    private Point loc;
    public boolean considerChanges(){
            return changed;
        }
    

    void setLocationing(int a, int i) {
        loc=new Point(a,i);
        this.setLocation(a, i);
    }

    class PanelKeyListener implements KeyListener{

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            int row=list.getSelectionModel().getLeadSelectionIndex();
            selected=(row==-1)?null:list.getValueAt(row, 0);
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                e.consume();
                dispose();
            }
            else if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                e.consume();
                changed=false;
                dispose();
            }
        }

        public void keyReleased(KeyEvent e) {
        }
    }
    class TextKeyListener implements KeyListener{

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            selected=write.getText();
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                e.consume();
                dispose();
            }
            else if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                e.consume();
                changed=false;
                dispose();
            }
        }

        public void keyReleased(KeyEvent e) {
            shortList();
        }
    }
    public void setText(String g){
        write.setText(g);
        shortList();
    }
    public DropDownPanel(String[] s) {
        this.setUndecorated(true);
        initComponents();
        scroll.setColumnHeaderView(null);
        list.addKeyListener(new PanelKeyListener());
        write.addKeyListener(new TextKeyListener());
        items=s;
        this.setListItems(items);
        jPanel2.setVisible(false);
    }
    public DropDownPanel(LinkedList s) {
        this.setUndecorated(true);
        initComponents();
        scroll.setColumnHeaderView(null);
        list.addKeyListener(new PanelKeyListener());
        write.addKeyListener(new TextKeyListener());
        int i=0;
        items=new String[s.size()];
        while(i<items.length){
            items[i]=s.get(i);
            i++;
        }
        this.setListItems(items);
        jPanel2.setVisible(false);
    }
    private void shortList(){
        LinkedList l=new LinkedList();
        int i=0;
        String text=write.getText();
        String g;
        int length=text.length();
        while(i<items.length){
            g=((String)items[i]);
            if(g.length()>=length&&g.substring(0,length).equalsIgnoreCase(text)){
                l.add(items[i]);
            }
            i++;
        }
        this.setListItems(l);
    }
    public Object getText(){
        return selected;
    }
    public JFrame getFrame(){
        return this;
    }
    public JTable getTable(){
        return list;
    }
    private void setListItems(LinkedList s){
        int i=0;
        Object[] d=new Object[s.size()];
        while(i<d.length){
            d[i]=s.get(i);
            i++;
        }
        this.setListItems(d);
    }
    private void setListItems(Object[] s){
        try{
            while(list.getRowCount()!=0)
                ((DefaultTableModel)list.getModel()).removeRow(0);
        }catch(Exception e){}
        int i=0;
        Object[] o=null;
        while(i<s.length){
            if(i<=list.getRowCount())
                ((DefaultTableModel)list.getModel()).addRow(o);
            list.setValueAt(s[i], i, 0);
            i++;
        }
        if(list.getRowCount()!=0){
            list.setRowSelectionInterval(0, 0);
            jPanel2.setVisible(false);
            jPanel1.setVisible(true);
            this.setLocation(loc==null?new Point(0,0):loc);
            this.setSize(new Dimension(this.getWidth(),(int) Math.min((list.getRowMargin()+list.getRowHeight())*(s.length)+write.getHeight(),Toolkit.getDefaultToolkit().getScreenSize().getHeight()*.45)));
        }
        else{
            jPanel1.setVisible(false);
            jPanel2.setVisible(true);
            this.setSize(new Dimension(this.getWidth(),write.getHeight()+100));
            if(write.getHeight()+100+this.getLocation().y>Toolkit.getDefaultToolkit().getScreenSize().height){
                this.setLocation(this.getLocation().x, this.getLocation().y-50-write.getHeight()-100);
            }
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

        write = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        write.setFont(new java.awt.Font("Times New Roman", 0, 16));
        write.setForeground(new java.awt.Color(153, 0, 153));
        write.setMargin(new java.awt.Insets(0, 0, 0, 0));
        write.setMaximumSize(new java.awt.Dimension(2147483647, 29));
        write.setMinimumSize(new java.awt.Dimension(6, 29));
        write.setPreferredSize(new java.awt.Dimension(6, 29));

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 100));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18));
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NO MATCH FOUND");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.getAccessibleContext().setAccessibleParent(this);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        scroll.setBackground(new java.awt.Color(153, 153, 255));

        list.setBackground(new java.awt.Color(102, 255, 102));
        list.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        list.setRowHeight(25);
        list.setSelectionBackground(new java.awt.Color(255, 255, 51));
        list.setSelectionForeground(new java.awt.Color(0, 0, 0));
        scroll.setViewportView(list);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );

        scroll.getAccessibleContext().setAccessibleParent(scroll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(write, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(write, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
        );

        write.setSize(this.getWidth(), 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DropDownPanel DropDownPanel=new DropDownPanel(new String[]{"A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A","B","C","D","E","A"});
                DropDownPanel.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable list;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField write;
    // End of variables declaration//GEN-END:variables

}
