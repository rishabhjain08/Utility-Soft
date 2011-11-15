package Frames;

import Printing.PageStock;
import Printing.PreviewPage;
import Printing.PreviewPane;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.AttributedString;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class print extends Thread {
	PrintJob pjob;
	int curheight=0,linesForThisPage = 0,linesForThisJob = 0,pageNum = 1,pageHeight=0;

	Graphics g;
	String s;
	Font heading=new Font("Times New Roman",1,18);
	Font billshead=new Font("Times New Roman",1,20);
	Font normal=new Font("Times New Roman",0,12);
	Font totalamount=new Font("Times New Roman",1,12);
	Font nameandadd=new Font("Times New Roman",1,14);
	Font f1=new Font("Times New Roman",1,13);
	File f;
	double width;
	String billno=null;
	String date;
	PageStock stock;
	PreviewPage page;
	String[] printfilepath;
	ProgressBar bar;
        static int LEFT_JUSTIFIED=-1,CENTER_JUSTIFIED=0,RIGHT_JUSTIFIED=1;

        print(String[] printfilepath1,PrintJob pjob1,String date1){
		pjob=pjob1;
		date=date1;
		printfilepath=printfilepath1;
		bar=new ProgressBar();
	}

        public void print(){
		if(pjob==null)
			return;
		bar.start();
		pageHeight=pjob.getPageDimension().height-20;
                width=pjob.getPageDimension().getWidth()-100;
		int count=0;
		stock=new PageStock(pjob);
		stock.setPageSize(new Dimension((int) pjob.getPageDimension().getWidth(),pjob.getPageDimension().height));

		while(count<printfilepath.length)    {
			pageNum=1;
			stock.addPage(new PreviewPage());
			curheight=0;
			f=new File(printfilepath[count]);
			File billnum=new File(pathlocation.getlocation()+"/"+f.getParentFile().getParentFile().getParentFile().getName()+"/"+f.getParentFile().getParentFile().getName()+"/billfromto.txt");
			scanner readbill=null;
			try {
				readbill = new scanner(new InputStreamReader(new FileInputStream(billnum), "UTF-8"));
			} catch (Exception ex) {
				Logger.getLogger(print.class.getName()).log(Level.SEVERE, null, ex);
			}
			billno="";
			if(readbill.hasNextLine())
				billno=readbill.nextLine();
			readbill.close();
			boolean iwas=false;
			curheight=0;
			printthebill();
			int remheight=curheight;
			while(pageNum==1&&curheight<pageHeight-stock.getFontMetrics(normal).getHeight()*3-remheight){
				printLine("",normal);
				iwas=true;
			}
			if(!iwas||pageNum!=1){
				stock.addPage(new PreviewPage());
				pageNum++;
				curheight=0;
			}
			printthebill();
			stock.dispose();
			count++;
		}
		new PreviewPane(stock).setVisible(true);
		bar.dispose();
	}

        public void printthebill(){
		AttributedString as = null;
		scanner read=null;
		try {
			read = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
		} catch (Exception ex) {
			Logger.getLogger(print.class.getName()).log(Level.SEVERE, null, ex);
		}
		int newnames=0;
		while(read.hasNextLine()){
			if(read.nextLine().equals("New Name,New"))
				newnames++;
		}
		try {
			read = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
		} catch (Exception ex) {
			Logger.getLogger(print.class.getName()).log(Level.SEVERE, null, ex);
		}

		String helpatt=null;
		printLine("",normal);
		String name=f.getName().substring(0, f.getName().lastIndexOf('.'));
		LinkedList namebreak=breakstring(width,name,heading,1.0);
		String name1=f.getParentFile().getParentFile().getName();
		String year=f.getParentFile().getParentFile().getParentFile().getName();
		String [] names=f.getParentFile().getParentFile().getParentFile().list();
		scanner s1 = null;
		try {
			s1 = new scanner(new InputStreamReader(new FileInputStream(new File(f.getParentFile().getParentFile().getPath().replace('\\', '/') + "/" + "serialno.txt")), "UTF-8"));
		} catch (Exception ex) {
			Logger.getLogger(print.class.getName()).log(Level.SEVERE, null, ex);
		}
		String serialno=s1.nextLine();
		int t=0;
		while(!names[t].equals(name1)){
			t++;
		}
		printLine("S.No.: "+serialno,normal,print.RIGHT_JUSTIFIED);
		printLine("Bill No.: "+billno,normal,print.RIGHT_JUSTIFIED);
		printLine("",normal);
		int op=0;
		while(op<namebreak.size()){
			printLine((String)namebreak.get(op),heading,print.CENTER_JUSTIFIED);
			op++;
		}
		helpatt=widthfont(width,billshead,"Bill",.5)+"Bill"+widthfont(width,billshead,"Bill",.5);
		as=new AttributedString(helpatt);
		as.addAttribute(TextAttribute.FONT, billshead);
		as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_DASHED,helpatt.length()-("Bill"+widthfont(width,billshead,"Bill",.5)).length(),helpatt.length()-widthfont(width,billshead,"Bill",.5).length());

		printLine(as,billshead);
		printLine("",normal);
		printLine("",normal);
		int total=0;
		int nametotal=0;

		double fac=1;
		String amount=null;
		String field=null;
		LinkedList breaks=new LinkedList();;
		while(read.hasNextLine()){
			String fieldandamount=read.nextLine();
			StringBuffer sbuff=new StringBuffer(fieldandamount);
			while(sbuff.indexOf("##")!=-1){
				sbuff.replace(sbuff.indexOf("##"), sbuff.indexOf("##")+2, year);
				fieldandamount=sbuff.toString();
			}
			if(!fieldandamount.equals("New Name,New")){
				field=fieldandamount.substring(0, fieldandamount.lastIndexOf(','));
				amount=fieldandamount.substring(fieldandamount.lastIndexOf(',')+1, fieldandamount.length());
			}
			breaks.clear();
			if(newnames!=0)
				fac=.65;
			else
				fac=.75;
			breaks=breakstring(width,field,normal,fac);
			if(fieldandamount.equals("New Name,New")){
				curheight-=stock.getFontMetrics(normal).getHeight();
				printLine(commate(String.valueOf(nametotal)),normal,print.RIGHT_JUSTIFIED);
				curheight-=stock.getFontMetrics(normal).getHeight();
				helpatt=widthfont(width-stock.getFontMetrics(normal).stringWidth("           9999999"),normal,"     ",1.0)+"         ";
				as=new AttributedString(helpatt);
				as.addAttribute(TextAttribute.FONT, normal);
				as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON,helpatt.length()-9-5-2-6,helpatt.length());

				printLine(as,normal);
				printLine("",normal);
				nametotal=0;
				continue;
			}

			int k=0;
			while(k<breaks.size()){
				k++;
			}
			//  System.exit(0);
			int i=0;
			while(i<breaks.size()-1){
				printLine((String)breaks.get(i),normal);
				i++;
			}
			if(newnames!=0)
				this.printLineAtEnds((String)breaks.get(i), commate(amount), normal, (int) (width - stock.getFontMetrics(normal).stringWidth("           9999999")));//,normal,breaks.get(i)+commate(amount),1.0)+commate(amount),normal);
			else
				this.printLineAtEnds((String) breaks.get(i),commate(amount), normal);
			if(!amount.equals(""))
				try{
					total+=Integer.parseInt(amount);
				}catch(Exception e){
				}
				if(!amount.equals(""))
					try{
						nametotal+=Integer.parseInt(amount);
					}catch(Exception e){
					}
		}
		if(newnames!=0){
			curheight-=stock.getFontMetrics(normal).getHeight();
			printLine(commate(String.valueOf(nametotal)),normal,print.RIGHT_JUSTIFIED);
			curheight-=stock.getFontMetrics(normal).getHeight();
			helpatt=widthfont(width-stock.getFontMetrics(normal).stringWidth("           9999999"),normal,"     ",1.0)+"         ";
			as=new AttributedString(helpatt);
			as.addAttribute(TextAttribute.FONT, normal);
			as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON,helpatt.length()-9-5-2-6,helpatt.length());
			printLine(as,normal);

			nametotal=0;
		}
		read.close();

		String amountstring=String.valueOf(total);
		printLine("",normal);
		helpatt=widthfont(width,normal,"     ",1.0)+"         ";
		as=new AttributedString(helpatt);
		as.addAttribute(TextAttribute.FONT, normal);
		as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL,helpatt.length()-9-5-5-3-4,helpatt.length());

		printLine(as,normal);
                this.printLineAtEnds("(Rs. "+towords(amountstring)+" only.)", commate(amountstring), totalamount);
		curheight-=stock.getFontMetrics(totalamount).getHeight();
		helpatt=widthfont(width,normal,"     ",1.0)+"         ";
		as=new AttributedString(helpatt);
		as.addAttribute(TextAttribute.FONT, normal);
		as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL,helpatt.length()-9-5-5-3-4,helpatt.length());

		printLine(as,normal);

		printLine("",normal);
		printLine("",normal);

		billhead head=new billhead();
		String[] firmadd=head.getFirmAddress();
		String[] firmname=head.getFirmName();
		helpatt=widthfont(width,normal,"",1.0)+"   ";
		as=new AttributedString(helpatt);
		as.addAttribute(TextAttribute.FONT, normal);
		as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON,helpatt.length()-(widthfont(stock.getFontMetrics(nameandadd).stringWidth(firmname[0]+"   "),normal,"",1.0)).length(),helpatt.length());
		printLine(firmadd.length==0?"":firmadd[0],nameandadd);
		curheight-=stock.getFontMetrics(nameandadd).getHeight();
		printLine(as,normal);
		int count=0;
		boolean in=false;
		if(firmadd.length-1<firmname.length)
			in=true;
		while(count<Math.max(firmadd.length-1,firmname.length)){
			String ui=((count)<firmname.length)?firmname[count]:"";
			String vi=((count+1)<firmadd.length)?firmadd[count+1]:"";
			if(in&&count==firmadd.length-1)
				vi="Date : " +date;
				this.printLineAtEnds(vi, ui, nameandadd);
			count++;
		}
		if(!in){
			printLine("Date : " +date,nameandadd);
		}
	}

        public   String widthfont(double width1,Font f,String s,double factor){
		FontMetrics fm = stock.getFontMetrics(f);
		int swidth=0;
		swidth+=stock.getFontMetrics(f).stringWidth(s);//.charWidth(s.charAt(i));
		int y=0;
		int i=0;
		String es="";
		while(stock.getFontMetrics(f).stringWidth(es)<(width1-swidth)*factor){
			es=es+" ";
		}
		return es;
	}

        public   String EmptySpaces(int width){
		String s="";
		int i=0;
		while(i<width){
			s+=" ";
			i++;
		}
		return s;
	}

        public void printLineAtEnds(String s1,String s2,Font helv){
            this.printLineAtEnds(s1, s2, helv, (int) width);
        }
        public void printLineAtEnds(String s1,String s2,Font helv,int width1){
            printLine(s1,helv,print.LEFT_JUSTIFIED,width1);
            curheight-=stock.getFontMetrics(helv).getHeight();
            printLine(s2,helv,print.RIGHT_JUSTIFIED,width1);
        }
        public boolean printLine(String s,Font helv){
            return printLine(s, helv,print.LEFT_JUSTIFIED,(int)width);
        }
        public boolean printLine(String s,Font helv,int just){
            return printLine(s, helv,just,(int)width);
        }
        public boolean printLine( String s,Font helv,int from,int width1) {
		stock.setFont(helv);
		FontMetrics fm = stock.getFontMetrics(helv);
		int fontHeight  = fm.getHeight();
		int fontDescent = fm.getDescent();
		try {

			if (s != null) {
				if ((curheight + fontHeight) > pageHeight) {
					pageNum++;
					linesForThisPage = 0;
					stock.addPage(new PreviewPage());
					if (stock != null) {
						stock.setFont(helv);
					}
					curheight = 0;
					printLine("",normal);
					printLine("",normal);
					printLine("",normal);
				}
				curheight += fontHeight;
				if (stock != null) {
                                    if(from==print.RIGHT_JUSTIFIED)
                                        stock.drawString(s, (int) (width1 + 50 - fm.stringWidth(s)), curheight-fontDescent);
                                    else if(from==print.CENTER_JUSTIFIED)
                                            stock.drawString(s, (int) (50 + (width1 - fm.stringWidth(s)) / 2), curheight-fontDescent);
                                    else //if(from == this.LEFT_JUSTIFIED)
					stock.drawString(s,50, curheight - fontDescent);

                                    linesForThisPage++;
                                    linesForThisJob++;
				} else {
					System.out.println("stock null");
				}
			}

		} catch (Exception eof) {
			System.out.println("Exception");
			// Fine, ignore
		}
		//System.out.println("" + linesForThisPage + " lines printed for page " + pageNum);
		//System.out.println("pages printed: " + pageNum);
		//System.out.println("total lines printed: " + linesForThisJob);
		return true;
	}

        public   boolean printLine( AttributedString s12,Font helv) {


		stock.setFont(helv);
		FontMetrics fm = stock.getFontMetrics(helv);
		int fontHeight = fm.getHeight();
		int fontDescent = fm.getDescent();
		try {

			if (s12 != null) {
				if ((curheight + fontHeight) > pageHeight) {
					System.exit(0);
					//System.out.println("" + linesForThisPage + " lines printed for page " + pageNum);
					pageNum++;
					linesForThisPage = 0;
					stock.addPage(new PreviewPage());
					if (stock != null) {
						stock.setFont(helv);
					}
					curheight = 0;
					return false;
				}

				curheight += fontHeight;
				if (stock != null) {
					stock.drawString(s12.getIterator(), 50, curheight - fontDescent);//.drawString(s, 50, curheight - fontDescent);
					linesForThisPage++;
					linesForThisJob++;
				} else {
					System.out.println("stock null");
				}
			}

		} catch (Exception eof) {
			System.out.println("Exception");
			// Fine, ignore
		}
		//System.out.println("" + linesForThisPage + " lines printed for page " + pageNum);
		//System.out.println("pages printed: " + pageNum);
		//System.out.println("total lines printed: " + linesForThisJob);
		return true;
	}

	public   LinkedList breakstring(double width2, String field2, Font normal2,double fac2) {
		//throw new UnsupportedOperationException("Not yet implemented");

		LinkedList l=new LinkedList();
                if(field2==null)
                    return l;
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
			while(i<words.size()&&stock.getFontMetrics(normal2).stringWidth(part)<width2*fac2){
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

	public static String commate(String s){

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
		if(h.equals(""))
			return "Zero";
		else
			return h;
	}

	@Override
 	public void run() {
		//throw new UnsupportedOperationException("Not supported yet.");
		this.print();
	}
}