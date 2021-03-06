/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PreviewPage.java
 *
 * Created on Mar 11, 2011, 10:59:25 PM
 */

package Printing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

/**
 *
 * @author ci
 */
public class PreviewPage extends javax.swing.JPanel {
static Dimension PANEL_DIMENSION=new Dimension(600,800);
private Graphics IMAGE_GRAPHICS=null;
BufferedImage IMAGE;
Dimension SCALED_PANEL_DIMENSION=PANEL_DIMENSION;
    private Image SCALED_IMAGE=null;
    /** Creates new form PreviewPage */
    public PreviewPage() {
        initComponents();
        IMAGE_GRAPHICS=this.createImageGraphics();
        IMAGE_GRAPHICS.setColor(Color.WHITE);
        IMAGE_GRAPHICS.fillRect(0, 0, PANEL_DIMENSION.width, PANEL_DIMENSION.height);
        IMAGE_GRAPHICS.setColor(Color.BLACK);
      } 
    public void reSize(Dimension d){
        PANEL_DIMENSION=d;
        this.setSize(d);
    } 
    @Override
    public Dimension getSize(Dimension d){
        return PANEL_DIMENSION;
    }
    @Override
    public void paint(Graphics g){
    if(IMAGE_GRAPHICS==null)
        return;
    if(SCALED_IMAGE!=null)
        g.drawImage(SCALED_IMAGE,0, 0 , null);
        else{
        //SCALED_IMAGE=IMAGE;
        g.drawImage(IMAGE,0, 0 , null);
        }
      }
    @Override
    public Graphics getGraphics(){
        return IMAGE_GRAPHICS;
    }
    private Graphics createImageGraphics(){
        IMAGE = new BufferedImage(PANEL_DIMENSION.width,PANEL_DIMENSION.height,BufferedImage.TYPE_INT_RGB);
        IMAGE_GRAPHICS=IMAGE.createGraphics();
        return IMAGE_GRAPHICS;
     }
    public Image scalePreview(double fac){
        
        SCALED_PANEL_DIMENSION=new Dimension((int) (PANEL_DIMENSION.width * fac),(int) (PANEL_DIMENSION.height * fac));
        SCALED_IMAGE=IMAGE.getScaledInstance(SCALED_PANEL_DIMENSION.width, SCALED_PANEL_DIMENSION.height,Image.SCALE_SMOOTH);
        this.setSize(SCALED_PANEL_DIMENSION);
        return SCALED_IMAGE;
 }

//    private BufferedImage scaleImage(BufferedImage img,double scale_factor_x,double scale_factor_y){
//        if(img==null)
//            return null;
//        int w=img.getWidth();
//        int h=img.getHeight();
//        int pix[]=new int[w*h];
//        PixelGrabber grab=new PixelGrabber(img,0,0,img.getWidth(),img.getHeight(),pix,0,w);
//        try {
//            grab.grabPixels();
//        } catch (InterruptedException ex) {
//            //Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        BufferedImage img1=new BufferedImage((int)(w*scale_factor_x),(int)(scale_factor_y*h),BufferedImage.TYPE_INT_RGB);
//        int[] newpix=new int[(int)(w*scale_factor_x*h*scale_factor_y)];
//        int i=0;
//        int w1,h1,color,x,y;
//        while(i<w*h){
//            w1=i%w;
//            h1=(int)i/w;
//            color=pix[i];
//            for(x=(int)(w1*scale_factor_x);x<(int)((w1+1)*scale_factor_x);x++)
//                            for(y=(int)(h1*scale_factor_y);y<(int)((h1+1)*scale_factor_y);y++)
//                                newpix[x+(int)(y*w*scale_factor_x)]=color;
//            i++;
//        }
//        img1.setRGB(0, 0, (int)(w*scale_factor_x), (int)(h*scale_factor_y), newpix, 0, (int)(w*scale_factor_x));
//        return img1;
//    }

public static void main(String args[]){

    new PreviewPage().setVisible(true);
}
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
