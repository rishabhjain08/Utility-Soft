package Frames;

public class loadingdata extends javax.swing.JFrame{

 
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOADING...");

        jProgressBar1.setBackground(new java.awt.Color(204, 255, 204));
        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setString("WAIT");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-180)/2, (screenSize.height-55)/2, 180, 55);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */ 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    public loadingdata() {
        beginShow();
    }
    public void beginShow(){
             initComponents();
             this.setUndecorated(true);
             jProgressBar1.setIndeterminate(true);
             jProgressBar1.setVisible(true);
             jProgressBar1.setDoubleBuffered(true);
     }
/*     public static loadingdata init(){
             Thread t=new Thread(prog=new loadingdata());
              t.start();
             return prog;
      }
    static loadingdata prog;
     public void run() {
            initComponents();
             jProgressBar1.setIndeterminate(true);
             jProgressBar1.setVisible(true);

      }
 * 
 */
 }
