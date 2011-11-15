/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Printing;

import Printing.PreviewPage;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.print.PrinterJob;
import java.text.AttributedCharacterIterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ci
 */
public class PageStock{
private List<PreviewPage> previewpages=new LinkedList();
private List<Dimension> PAGE_LOCATION=new LinkedList();
  int TWO_FIT_WIDTH=1;
  int FIT_WIDTH=2;
  int FIT_HEIGHT=6;
  int CUSTOM_FIT=3;
  int NORMAL=4;
  private PrintJob pjob;
Dimension screendim=new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-35,Toolkit.getDefaultToolkit().getScreenSize().height);
private static double SCALE_FACTOR;
private int FIT_TYPE=FIT_WIDTH;
private static Dimension STOCK_PAGE_SIZE=new Dimension(800,800);
private Graphics pg;
     public PageStock(PrintJob p){
      SCALE_FACTOR=1.0;
      pjob=p;
      //System.out.println("SACLE_FACTOR in entry is:"+SCALE_FACTOR);
    }
     Graphics CURRENT_PAGE_GRAPHICS;

    PageStock() {
//        throw new UnsupportedOperationException("Not yet implemented");
    }
    public void dispose(){
        pg.dispose();
     }
    public PrintJob getPrintJob(){
        return pjob;
    }
    public void delete(){
        pjob.finalize();
    }
    public void addPage(PreviewPage page){
        if(this.stockSize()!=0)
            pg.dispose();
        pg=pjob.getGraphics();
        CURRENT_PAGE_GRAPHICS=page.getGraphics();
         page.scalePreview(SCALE_FACTOR);
        previewpages.add(page);
      }
    public PreviewPage[] getPages(){
        PreviewPage[] pages=new PreviewPage[previewpages.size()];
        int i=0;
        while(i<previewpages.size()){
            pages[i]=previewpages.get(i);
            i++;
        }
        return pages;
    }
     public void drawString(String s,int x,int y){
            if(CURRENT_PAGE_GRAPHICS==null)
                this.addPage(new PreviewPage());
        CURRENT_PAGE_GRAPHICS.drawString(s, x, y);
        pg.drawString(s, x, y);
     }
        public void setFont(Font f){
            if(CURRENT_PAGE_GRAPHICS==null)
                this.addPage(new PreviewPage());
        CURRENT_PAGE_GRAPHICS.setFont(f);
        pg.setFont(f);
    }
    public FontMetrics getFontMetrics(){
            if(CURRENT_PAGE_GRAPHICS==null)
                this.addPage(new PreviewPage());
        return CURRENT_PAGE_GRAPHICS.getFontMetrics();
    }
     public FontMetrics getFontMetrics(Font f){
            if(CURRENT_PAGE_GRAPHICS==null)
                this.addPage(new PreviewPage());
        return CURRENT_PAGE_GRAPHICS.getFontMetrics(f);
    }
    public void print(){
        pg.dispose();
        pjob.end();
    }
public void drawString(AttributedCharacterIterator s,int x,int y){
            if(CURRENT_PAGE_GRAPHICS==null)
                this.addPage(new PreviewPage());
        CURRENT_PAGE_GRAPHICS.drawString(s, x, y);
        pg.drawString(s, x, y);
     }
    public int stockSize(){
        return previewpages.size();
    }
    public List getLocations(){
        PAGE_LOCATION.clear();
          switch(FIT_TYPE){
            case 1:
                int i=0;
                int y=30;
                while(i<this.stockSize()){
                    int x;
                    if(i%2==0)
                        x=30;
                    else
                    x=screendim.width/2+30/2;
                    PAGE_LOCATION.add(new Dimension(x,y));
                    if(i%2!=0)
                            y+=STOCK_PAGE_SIZE.height*SCALE_FACTOR+30;
                    
                            i++;
                }
                break;
            case 2:
                  i=0;
                  y=30;
                while(i<this.stockSize()){
                    int x;
                    x=30;
                    PAGE_LOCATION.add(new Dimension(x,y));
                    y+=STOCK_PAGE_SIZE.height*SCALE_FACTOR+30;
                    i++;
                }
                break;

            case 3:
                  i=0;
                  y=30;
                while(i<this.stockSize()){
                    int x;
                    x=(int)((double)screendim.width-(double)STOCK_PAGE_SIZE.width*SCALE_FACTOR)/2;
                    ////System.out.println("x is:"+x);
                    if(x<0)
                        x=30;
                    PAGE_LOCATION.add(new Dimension(x,y));
                    y+=STOCK_PAGE_SIZE.height*SCALE_FACTOR+30;
                    i++;
                }
                break;
            case 4:
                  i=0;
                  y=30;
                while(i<this.stockSize()){
                    int x;
                    x=(screendim.width-STOCK_PAGE_SIZE.width)/2;
                    if(x<0)
                        x=30;
                    PAGE_LOCATION.add(new Dimension(x,y));
                    y+=STOCK_PAGE_SIZE.height*SCALE_FACTOR+30;
                    i++;
                }
                break;
               case 5:
                  i=0;
                  y=30;
                    int x=30;
                while(i<this.stockSize()){
                     PAGE_LOCATION.add(new Dimension(x,y));
                    x+=STOCK_PAGE_SIZE.width+30;
                    i++;
                }
                break;
              case 6:
                  i=0;
                  y=30;
                    x=(screendim.width-STOCK_PAGE_SIZE.width)/2;
                    if(x<0)
                        x=30;
                while(i<this.stockSize()){
                     PAGE_LOCATION.add(new Dimension(x,y));
                    y+=STOCK_PAGE_SIZE.height*SCALE_FACTOR+30;
                    i++;
                }
                break;
                  
            }
        return   PAGE_LOCATION;
     }
    public void setPreviewType(int i){
        FIT_TYPE=i;
        switch(FIT_TYPE){
    case  1:
        SCALE_FACTOR=(double)(screendim.width-(3*30))/(2*STOCK_PAGE_SIZE.width);
        ////System.out.println("SCALED to 1:"+SCALE_FACTOR+" screen width="+(screendim.width-(3*30))+" divided by="+2*STOCK_PAGE_SIZE.width+" result is:"+7/8);
        break;
            case 2:
        SCALE_FACTOR=(double)(screendim.width-(2*30))/(1*STOCK_PAGE_SIZE.width);
        ////System.out.println("SCALED to 2:"+SCALE_FACTOR);
        break;
            case 4:
        SCALE_FACTOR=1.0;
        ////System.out.println("SCALED to: 3"+SCALE_FACTOR);
        break;
        case 5:
        SCALE_FACTOR=1.0;
        ////System.out.println("SCALED to: 3"+SCALE_FACTOR);
        break;
        case 6:
            SCALE_FACTOR=(double)(screendim.height-150)/STOCK_PAGE_SIZE.height;
            break;
 }
        PreviewPage[] p=this.getPages();
        i=0;
        while(i<p.length){
            p[i].scalePreview(SCALE_FACTOR);
            i++;
        }
    }
    public void setPreviewType(int i,double scaleto){

        if(i==this.CUSTOM_FIT){
            SCALE_FACTOR=scaleto;
        FIT_TYPE=i;
        PreviewPage[] p=this.getPages();
         i=0;
        while(i<p.length){
            p[i].scalePreview(SCALE_FACTOR);
            i++;
        }
        }
        
    }
    
    public void setPageSize(Dimension dim){
        STOCK_PAGE_SIZE=dim; 
    }
}
