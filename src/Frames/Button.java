package Frames;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;

public class Button extends JButton{
    public Button(){
        this.setBorderPainted(false);
        this.setOpaque(false);
    }
    @Override
    public void paintComponent(Graphics g1){
        Graphics2D g=(Graphics2D)g1.create();
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.7f));
        super.paintComponent(g);
        g.dispose();
        return;
      /*Image img=null;
        try {
            img = ImageIO.read(new File("C:/Users/ci/Desktop/butt1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Button.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage trans=new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TRANSLUCENT);// img;
        Graphics2D gi=trans.createGraphics();
        gi.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.5f));
        System.err.println(trans.getTransparency());
        gi.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),0,0,trans.getWidth(),trans.getHeight(),this);
        g.drawImage(trans, null, 0,0);
         * 
         */
    }

}
