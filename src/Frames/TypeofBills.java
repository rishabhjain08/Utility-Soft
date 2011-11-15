//done
package Frames;

import Frames.ProgramError.ErrorDisplay;
import Frames.ProgramError.Instruction;
import Frames.ProgramError.ProblemResolved;
import Frames.ProgramError.Report;
import Frames.ProgramError.Troubleshoot;
import Frames.ProgramError.UnabletoShoot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TypeofBills {
    List foldername;
    List tabhead;

    class ErrorHandling{
        public void couldNotHelp(String bugno,final Exception e,final String s){
                couldNotHelp(bugno,e,s,true);
        }

        public void couldNotHelp(String bugno,final Exception e,final String s,final boolean force){
            final ErrorDisplay err=new ErrorDisplay(bugno);
            err.setVisible(true);
            if(force)
                err.ignoreButton.setEnabled(false);
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                    UnabletoShoot unable=new UnabletoShoot(err,null,false);
                    unable.setVisible(true);
                    if(force)
                        unable.ignoreButton.setEnabled(false);
                }
            });
            err.addReportAction(new Report() {

                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting(s);
                }
            });
                    
        }
        public void restarttheProgram(String bugno,final Exception e,final String s){
        final ErrorDisplay err=new ErrorDisplay(bugno);
        err.setVisible(true);
        err.addTroubleshootAction(new Troubleshoot() {

            public void doAction() {
                new Instruction("Restart the program. If problem persists, contact the administrator.").setVisible(true);
            }
        });
        err.addReportAction(new Report() {

                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting(s);
                }
            });

        }
    }
    public TypeofBills(){
        foldername=new LinkedList();
        tabhead=new LinkedList();
        this.refresh();
    }
    private void refresh(){
        foldername.clear();
        tabhead.clear();
        File f=new File(System.getProperty("user.dir").replace('/', '\\')+"\\impinfo.txt");
        scanner scan=null;
        try {
            try {
                scan = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            } catch (FileNotFoundException ex) {
                //bugno sem121Jof[eerrfe
                new ErrorHandling().couldNotHelp("sem123Jof[eerrfe", ex, "impinfo was not found");
            }
        } catch (UnsupportedEncodingException ex) {
                //bugno sem122Jof[eerrfe
                new ErrorHandling().restarttheProgram("sem122Jof[eerrfe", ex, "UTF-8 not supported");
        }
        try{
        if(scan.hasNextLine()){
        String types=scan.nextLine();
        int startindex=0,capindex;
        while(startindex<types.length()){
            capindex=types.indexOf('^', startindex+1);
            foldername.add(types.substring(startindex+1, capindex));
            tabhead.add(types.substring(capindex+1,types.indexOf(')', capindex+1)));
            startindex=1+types.indexOf(')', capindex+1);
        }
        }
        scan.close();
        }catch(Exception e){
            //bugno sem123Jof[eerrfe
            new ErrorHandling().couldNotHelp("sem123Jof[eerrfe", e, "tampred with probably first line of impinfo file.");
        }
    }
    public String[] getFolderName(){
        this.refresh();
        String arr[]=new String[foldername.size()];
        int i=0;
        while(i<arr.length){
            arr[i]=foldername.get(i).toString();
            i++;
        }
        return arr;
    }
    public String getCorrespondingFolderName(String s){
        if(s==null)
            return null;
        String[] g=this.getTabHeadName();
        int i=0;
        while(i<g.length){
            if(g[i].equals(s))
                return this.getFolderName(i);
        }
        return null;
    }
    public boolean isFolderPresent(String s){
        if(s==null)
            return false;
        String folds[]=this.getFolderName();
        int y=0;
        while(y<folds.length){
            if(folds[y].equalsIgnoreCase(s))
                return true;
            y++;
        }
        return false;
    }
    public boolean isTabPresent(String s){
        if(s==null)
            return false;
        String folds[]=this.getTabHeadName();
        int y=0;
        while(y<folds.length){
            if(folds[y].equalsIgnoreCase(s))
                return true;
            y++;
        }
        return false;
    }
    public String getFolderName(int k){
        this.refresh();
        return (String)(foldername.get(k));
    }
    public void addNewBillType(final String folder,final String tab){
        File f=new File(System.getProperty("user.dir").replace('/', '\\')+"\\impinfo.txt");
        scanner scan1=null;
        try {
            try {
                scan1 = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            } catch (FileNotFoundException ex) {
                    //bugno sem121Jof[esaNde
                    new ErrorHandling().couldNotHelp("sem121Jof[esaNde", ex, "impinfo is missing.");
            }
        } catch (UnsupportedEncodingException ex) {
            //bugno sem122Jof[esaNde
            new ErrorHandling().restarttheProgram("sem122Jof[esaNde", ex, "UTF-8 format not supported.");
        }
        final File temp=null;
        try {
            temp.createTempFile("tab", ".txt");
        } catch (final IOException ex) {
            //bugno sem123Jof[esaNde
                    final ErrorDisplay err=new ErrorDisplay("sem123Jof[esaNde");
                    err.setVisible(true);
                    err.addTroubleshootAction(new Troubleshoot() {

                public void doAction() {
                    addNewBillType(folder,tab);
                }
            });
            err.addReportAction(new Report() {

                public void reportAction() {
                    err.setStackTraceElement(ex.getStackTrace());
                    err.addAdditionalReporting("Cannot create temporary file.");
                }
            });
        }

        writer o=new writer();
        try {
            o.init(new FileWriter(temp));
        } catch (IOException ex) {
            //bugno sem124Jof[esaNde
            new ErrorHandling().restarttheProgram("sem124Jof[esaNde", ex, "Could not initialize writer.");
        }
        try {
            o.write(((!scan1.hasNextLine())?"":scan1.nextLine())+"(" + folder + "^" + tab + ")"+"\r\n");
        } catch (IOException ex) {
            //bugno sem125Jof[esaNde
            new ErrorHandling().restarttheProgram("sem125Jof[esaNde", ex, "Could not write to writer.");        
        }
        while(scan1.hasNextLine()){
            try {
                o.write(scan1.nextLine()+"\r\n");
            } catch (IOException ex) {
                    //bugno sem126Jof[esaNde
                    new ErrorHandling().restarttheProgram("sem126Jof[esaNde", ex, "Could not write to writer object of temp file or could not scan impinfo.");
            }
        }
            try {
                o.close();
            } catch (IOException ex) {
                    //bugno sem127Jof[esaNde
                    new ErrorHandling().restarttheProgram("sem127Jof[esaNde", ex, "Could not close writer object of temp file");
            }
            scan1.close();
            try {
                o.init(new FileWriter(f));
            } catch (IOException ex) {
                    //bugno sem127Jof[esaNde
                    new ErrorHandling().restarttheProgram("sem127Jof[esaNde", ex, "Could not initialize writer object of impinfo.");
            }
        try {
            try {
                scan1 = new scanner(new InputStreamReader(new FileInputStream(temp), "UTF-8"));
            } catch (FileNotFoundException ex) {
                    //bugno sem128Jof[esaNde
                    ErrorDisplay err=new ErrorDisplay("sem128Jof[esaNde");
                    err.setVisible(true);
                    err.addTroubleshootAction(new Troubleshoot() {

                    public void doAction() {
                        boolean in=false,createNewFile = false;
                        try {
                             createNewFile = temp.createNewFile();
                        } catch (IOException ex1) {
                             in=true;
                             //bugno sem121Jof[eodcAt
                                new ErrorHandling().restarttheProgram("sem121Jof[eodcAt", ex1, "attemp to create temp as a trouble shoot measure failed.");
                        }
                        if(!in&&!createNewFile)//bugno sem122Jof[eodcAt
                            new ErrorHandling().restarttheProgram("sem122Jof[eodcAt", new Exception("null"), "attemp to create temp as a trouble shoot measure failed.");
                        if(createNewFile)
                            new ProblemResolved().setVisible(true);
                    }
                });
            }
        } catch (UnsupportedEncodingException ex) {
            //bugno sem129Jof[esaNde
            new ErrorHandling().restarttheProgram("sem129Jof[esaNde", ex, "UTF-8 format not supported.");
        }
            //
            while(scan1.hasNextLine()){
            try {
                o.write(scan1.nextLine()+"\r\n");
            } catch (IOException ex) {
                //bugno sem1210Jof[esaNde
                new ErrorHandling().restarttheProgram("sem1210Jof[esaNde", ex, "Error maybe in scan1 or write class's object");
            }
        }
            try {
                o.close();
            } catch (IOException ex) {
                //bugno sem1211Jof[esaNde
                new ErrorHandling().restarttheProgram("sem1211Jof[esaNde", ex, "Error in write class's object");
            }
            scan1.close();
            temp.delete();
            refresh();
            foldername.add(folder);
            tabhead.add(tab);
    }
    public void removeBillType(String folder,String tab){
        int k=0;
        boolean deleted=false;
        while(k<tabhead.size()){
            if(tabhead.get(k).equals(tab)&&foldername.get(k).equals(folder)){
                tabhead.remove(k);
                foldername.remove(k);
                k--;
                deleted=true;
            }
            k++;
        }
        if(!deleted){
            return;
        }
        File f=new File(System.getProperty("user.dir").replace('/', '\\')+"\\impinfo.txt");
        File temp=null;
        try {
            temp = File.createTempFile("tab", ".txt");
        } catch (IOException ex) {
            try {
                temp = File.createTempFile("tab", ".txt");
            } catch (IOException ex1) {
                //bugno sem121Jof[eeromv
                new ErrorHandling().restarttheProgram("sem121Jof[eeromv", ex1, "error generated by creation of temporary file.");
            }
        }
        scanner scan1=null;
        try {
            try {
                scan1 = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            } catch (FileNotFoundException ex) {
                //bugno sem122Jof[eeromv
                new ErrorHandling().couldNotHelp("sem122Jof[eeromv", ex, "impinfo is missing for removal of tab name.");
            }
        } catch (UnsupportedEncodingException ex) {
                //bugno sem123Jof[eeromv
            new ErrorHandling().restarttheProgram("sem123Jof[eeromv", ex, "UTF-8 format not supported.");
        }
        if(!scan1.hasNextLine()){
            scan1.close();
            return;
        }
        writer o=new writer();
        try {
            o.init(new FileWriter(temp));
        } catch (IOException ex) {
                //bugno sem124Jof[eeromv
            new ErrorHandling().restarttheProgram("sem124Jof[eeromv", ex, "io exception in writer of temp.");
        }
        String infos=scan1.nextLine();
        StringBuffer s=new StringBuffer(infos);
        int i=0,capindex1 = 0,remi=-1;
        try{
            while(i<infos.length()){
            remi=i;
            if(infos.substring(i+1,(infos.indexOf('^', i+1))).equalsIgnoreCase(folder)&&infos.substring(infos.indexOf('^', i+1)+1,infos.indexOf(')', infos.indexOf('^', i+1)+1)).equalsIgnoreCase(tab)){
                s.replace(remi,infos.indexOf(')', remi+1)+1,"");
                break;
            }
            capindex1=infos.indexOf('^', i+1);
            i=1+infos.indexOf(')', capindex1+1);
        }
        }catch(Exception e){
            //bugno sem125Jof[eeromv
            new ErrorHandling().couldNotHelp("sem125Jof[eeromv", e, "data of impinfo tampered mostprobably first line.");
        }
        try {
            o.write(s+"\r\n");
        } catch (IOException ex) {
            //bugno sem126Jof[eeromv
            new ErrorHandling().restarttheProgram("sem126Jof[eeromv", ex, "io exception in writer of temp.");
        }
        while(scan1.hasNextLine()){
            try {
                o.write(scan1.nextLine()+"\r\n");
            } catch (IOException ex) {
            //bugno sem127Jof[eeromv
            new ErrorHandling().restarttheProgram("sem127Jof[eeromv", ex, "io exception in writer of temp or scanner of impinfo.");
            }
        }
            try {
                o.close();
            } catch (IOException ex) {
            //bugno sem128Jof[eeromv
            new ErrorHandling().restarttheProgram("sem128Jof[eeromv", ex, "io exception in writer of temp, could not close it.");
            }
            scan1.close();
            try {
                o.init(new FileWriter(f));
            } catch (IOException ex) {
                    //bugno sem129Jof[eeromv
                    new ErrorHandling().restarttheProgram("sem129Jof[eeromv", ex, "io exception in writer of impinfo, could not initialize it.");
            }
        try {
            try {
                scan1 = new scanner(new InputStreamReader(new FileInputStream(temp), "UTF-8"));
            } catch (FileNotFoundException ex) {
                    //bugno sem1210Jof[eeromv
                    new ErrorHandling().restarttheProgram("sem1210Jof[eeromv", ex, "temp could not be found.");
            }
        } catch (UnsupportedEncodingException ex) {
                    //bugno sem1211Jof[eeromv
                    new ErrorHandling().restarttheProgram("sem1211Jof[eeromv", ex, "UTF-8 format not supported.");
        }
            while(scan1.hasNextLine()){
            try {
                o.write(scan1.nextLine()+"\r\n");
            } catch (IOException ex) {
                //bugno sem1212Jof[eeromv
                new ErrorHandling().restarttheProgram("sem1212Jof[eeromv", ex, "Error generated in scan1 or write's object o.");
            }
        }
            try {
                o.close();
            } catch (IOException ex) {
                //bugno sem1213Jof[eeromv
                new ErrorHandling().restarttheProgram("sem1213Jof[eeromv", ex, "Could not close write class's object.");
            }
            scan1.close();
            temp.delete();
            refresh();
    }
    public String[] getTabHeadName(){
        this.refresh();
        String arr[]=new String[tabhead.size()];
        int i=0;
        while(i<arr.length){
            arr[i]=tabhead.get(i).toString();
            i++;
        }
        return arr;
    }
    public String getTabHeadName(int k){
        this.refresh();
        return (String)tabhead.get(k);
    }
}
