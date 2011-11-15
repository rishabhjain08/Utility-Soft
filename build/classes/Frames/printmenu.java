package Frames;


import Printing.PageStock;
import Printing.PreviewPage;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.PrintJob;
import java.awt.font.TextAttribute;
import java.io.File;
import java.text.AttributedString;
import java.util.LinkedList;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */

public class printmenu extends JFrame{
static PrintJob pjob;
static int curheight=0,linesForThisPage = 0,linesForThisJob = 0,pageNum = 1,pageHeight=0;

static String s;
static Font menuhead=new Font("Times New Roman",1,14);
Font heading=new Font("Times New Roman",1,18);
 Font billshead=new Font("Times New Roman",1,20);
static Font normal=new Font("Times New Roman",0,12);
Font totalamount=new Font("Times New Roman",1,12);
Font nameandadd=new Font("Times New Roman",1,14);
static Font f1=new Font("Times New Roman",1,13);
File f;
static double width;
String billno=null;
static String date;
    private static PageStock STOCK;
printmenu(){
}
public static void setStock(PageStock stock){
    STOCK=stock;
}
          public static boolean printLine( String s,Font helv) {
       STOCK.setFont(helv);
      FontMetrics fm = STOCK.getFontMetrics(helv);
      int fontHeight = fm.getHeight();
      int fontDescent = fm.getDescent();
       try {

             if (s != null) {
               if ((curheight + fontHeight) > pageHeight-STOCK.getFontMetrics(helv).getHeight()*3 ) {
                  ////System.out.println("" + linesForThisPage + " lines printed for page " + pageNum);
                  pageNum++;
                  linesForThisPage = 0;
                  STOCK.addPage(new PreviewPage());
                      STOCK.setFont(helv);
                  
                  curheight = 0;
     printLine("",normal);
    printLine("",normal);
    printLine("",normal);
double width2=STOCK.getPrintJob().getPageDimension().width-100;
String helpatt1="S.No."+"    "+"Name of Client"+widthfont(width2-100-100,f1,"S.No."+"    "+"Name of Client",1.0)+"Bill No."+widthfont(100,f1,"Bill No.",1.0)+"Remarks";
AttributedString asm=new AttributedString(helpatt1);
printLine(asm,f1);

    AttributedString asm1=new AttributedString(widthfont(width2,f1,"",1.0));
    asm1.addAttribute(TextAttribute.FONT, f1);
    asm1.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_DASHED,0,widthfont(width2,f1,"",1.0).length());
    printLine(asm1,f1);
                }
               curheight += fontHeight;
                   STOCK.drawString(s, 50, curheight - fontDescent);
                   linesForThisPage++;
                  linesForThisJob++;
               
            }

      } catch (Exception eof) {
      System.out.println("Exception");
          // Fine, ignore
      }
      ////System.out.println("" + linesForThisPage + " lines printed for page " + pageNum);
      ////System.out.println("pages printed: " + pageNum);
      ////System.out.println("total lines printed: " + linesForThisJob);
      return true;
          }

          public  static  String widthfont(double width1,Font f,String s,double factor){
    FontMetrics fm = STOCK.getFontMetrics(f);
     int swidth=0;
    swidth+=STOCK.getFontMetrics(f).stringWidth(s);//.charWidth(s.charAt(i));
int y=0;
int i=0;
String es="";
while(STOCK.getFontMetrics(f).stringWidth(es)<(width1-swidth)*factor){
    es=es+" ";
}
return es;
 }

       public static boolean printLine( AttributedString s12,Font helv) {


      STOCK.setFont(helv);
      FontMetrics fm = STOCK.getFontMetrics(helv);
      int fontHeight = fm.getHeight();
      int fontDescent = fm.getDescent();
       try {

             if (s12 != null) {
               if ((curheight + fontHeight) > pageHeight ) {
                   System.exit(0);
                   ////System.out.println("" + linesForThisPage + " lines printed for page " + pageNum);
                  pageNum++;
                  linesForThisPage = 0;
                  STOCK.addPage(new PreviewPage());
                  STOCK.setFont(helv);
                  
                  curheight = 0;

                }

               curheight += fontHeight;
                   STOCK.drawString(s12.getIterator(), 50, curheight - fontDescent);
                   linesForThisPage++;
                   linesForThisJob++;
             }

      } catch (Exception eof) {
      System.out.println("Exception");
          // Fine, ignore
      }
      ////System.out.println("" + linesForThisPage + " lines printed for page " + pageNum);
      /////System.out.println("pages printed: " + pageNum);
      ////System.out.println("total lines printed: " + linesForThisJob);
      return true;
          }



    public static LinkedList breakstring(double width2, String field2, Font normal2,double fac2) {
        //throw new UnsupportedOperationException("Not yet implemented");

        LinkedList l=new LinkedList();
        LinkedList words=new LinkedList();
        int i=0;
        int remi=-1;
        while(i<field2.length()){

                if(field2.charAt(i)==' '){
                   words.add(field2.substring(remi+1, i));
                             remi=i;
                 }
                  i++;
        }
        words.add(field2.substring(remi+1, i));
          String part="";
         String rempart=null;
         i=0;
         boolean firsttime;
while(i<words.size()){
         part="";
         rempart="";
         firsttime=true;
         while(i<words.size()&&STOCK.getFontMetrics(normal2).stringWidth(part)<width2*fac2){
         rempart=part;
         if(!firsttime)
             part+=" ";

         part=part+(String)words.get(i);
         i++;
         firsttime=false;
        }
          if(i==words.size()){
             l.add(part);
             break;
    }
    else
        l.add(rempart);
         i--;
        }
          return l;
      }

    printmenu(PageStock STOCK_1) {
         STOCK=STOCK_1;
         curheight=0;
    }

public String commate(String s){

String h="";
if(s.length()>3){

String job=s.substring(0, s.length()-3);
int begin=0;
int end;
if(job.length()%2!=0)
    end=1;
else
    end=2;
while(begin<job.length()){

    h+=job.substring(begin, end);
    h+=",";
    begin=end;
    end+=2;

}
h+=s.subSequence(s.length()-3, s.length());
}
 else
     h=s;
h+="/-";

 return h;
}

public   static String EmptySpaces(int width){
    String s="";
    int i=0;
    while(i<width){
        s+=" ";
        i++;
    }
    return s;
}

public String towords( String s){

String abrupttens[]={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Ninteen"};
String numbersatfirst[]={"Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eigthy","Ninty"};
String h="";
String units[]={"Hundred","Thousand","Lakh","Crore"};
String[] singlenum={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
if(s.length()>3){
String job=s.substring(0, s.length()-3);
int end=job.length();
int  begin;
if(job.length()>1)
    begin=end-2;
else
    begin=end-1;
int num=0;
int index=1;
while(end>0){
if(begin==-1)
    begin=0;
    num=Integer.parseInt(job.substring(begin, end));
    if(num>0&&num<10)
     h= (singlenum[num-1]+" "+units[index]+" ").concat(h);
    else if(num>=10&&num<20)
        h=(abrupttens[num-10]+" "+units[index]+" ").concat(h);
    else if(num>=20&&num<=99){
        if(num%10==0)
           h=  (numbersatfirst[num/10-2]+" "+units[index]+" ").concat( h);
        else
            h=((numbersatfirst[num/10-2]+" "+singlenum[num%10-1])+" "+units[index]+" ").concat(h);
     }
    index++;
    end-=2;
    begin=end-2;
}
}


    while(s.length()<3){
        s="0".concat(s);
    }


String lastthree=s.substring(s.length()-3, s.length());
if(Integer.parseInt(Character.toString(lastthree.charAt(0)))!=0){
    h=h+singlenum[Integer.parseInt(Character.toString(lastthree.charAt(0)))-1]+" Hundred ";

    }
if(Integer.parseInt(lastthree.substring(lastthree.length()-2, lastthree.length()))!=0)
    h=h+"and ";
    int num=Integer.parseInt(lastthree.substring(lastthree.length()-2, lastthree.length()));
if(num>0&&num<10)
     h=h+ singlenum[num-1];
    else if(num>=10&&num<20)
        h=h+abrupttens[num-10];
    else if(num>=20&&num<=99){
        if(num%10==0)
           h= h+ numbersatfirst[num/10-2];
        else
            h=h+(numbersatfirst[num/10-2]+" "+singlenum[num%10-1]);

}

return h;
}



}
