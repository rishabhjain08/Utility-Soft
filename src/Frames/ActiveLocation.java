package Frames;

import Frames.ProgramError.ErrorDisplay;
import Frames.ProgramError.Instruction;
import Frames.ProgramError.ProblemResolved;
import Frames.ProgramError.Report;
import Frames.ProgramError.Troubleshoot;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class ActiveLocation {
    static class ErrorHandling{
        public void activelocationMissing(String bugno,final Exception e,final String additional){
                    final ErrorDisplay err=new ErrorDisplay(bugno);
            err.setVisible(true);
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                        Instruction inst=new Instruction("Close the program on all the Computers on this Network rest this and proceed.");
                        inst.setVisible(true);
                        inst.addWindowListener(new WindowListener() {

                        public void windowOpened(WindowEvent e) {
                        }

                        public void windowClosing(WindowEvent e) {
                        }

                        public void windowClosed(WindowEvent e) {
                            File f=new File(pathlocation.getolocation()+"activelocation.txt");
                            boolean s=false,createNewFile = false;
                            try {
                                createNewFile = f.createNewFile();
                            } catch (IOException ex) {
                                s=true;
                                new Instruction("Create a text file named 'activelocation' (CASE SENSITIVE) in the data folder of the program and proceed").setVisible(true);
                            }
                            if(!s&&!createNewFile)
                                new Instruction("Create a text file named 'activelocation' (CASE SENSITIVE) in the data folder of the program and proceed").setVisible(true);
                            if(!s&&createNewFile){
                                Instruction inst=new Instruction("Restart the program.");
                                inst.setVisible(true);
                                inst.addWindowListener(new WindowListener() {

                                    public void windowOpened(WindowEvent e) {
                                    }

                                    public void windowClosing(WindowEvent e) {
                                    }

                                    public void windowClosed(WindowEvent e) {
                                        new ProblemResolved().setVisible(true);
                                    }

                                    public void windowIconified(WindowEvent e) {
                                    }

                                    public void windowDeiconified(WindowEvent e) {
                                    }

                                    public void windowActivated(WindowEvent e) {
                                    }

                                    public void windowDeactivated(WindowEvent e) {
                                    }
                                });
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
                    });
                }
            });
            err.addReportAction(new Report() {
                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting(additional);
                }
            });

        }
        public void restartProgram(String bug,final Exception e,final String additional){
            final ErrorDisplay err=new ErrorDisplay(bug);
            err.setVisible(true);
            err.addTroubleshootAction(new Troubleshoot() {
                public void doAction() {
                    new Instruction("Restart the program. If problem persists contact the administrator.").setVisible(true);
                }
            });
            err.addReportAction(new Report() {

                public void reportAction() {
                    err.setStackTraceElement(e.getStackTrace());
                    err.addAdditionalReporting(additional);
                }
            });
        }
    }
    public static int getActiveCount(){
        int i=0;
        Scanner scan=null;
        try{
            scan=new Scanner(pathlocation.getolocation()+"activelocation.txt");
        }catch(final Exception e){
            //bugno sem1217Yj_l[BtagAL
            new ErrorHandling().activelocationMissing("sem1217Yj_l[BtagAL",e,"activelocation.txt not found");
        }
        while(scan.hasNextLine()){
            i++;
            scan.nextLine();
        }
        scan.close();
        return i;
    }
    public static void addActiveLocation(String s) {
        File from=null;
        try{
             from=new File(pathlocation.getolocation()+"activelocation.txt");
        }catch(Exception e){
            //bugno sem1227Yj_l[BdaAdc
            new ErrorHandling().activelocationMissing("sem1227Yj_l[BdaAdc",e,"activelocation.txt not found");
            return;
        }
        Writer writer=null;
        File temp = null;
        try {
            temp = File.createTempFile("adding", ".txt");
        } catch (IOException ex) {
            //bugno sem1237Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem1237Yj_l[BdaAdc", ex,"temp cannot be made in addActiveLocation");
        }
        try {
            writer = new FileWriter(temp);
        } catch (IOException ex) {
            //bugno sem1247Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem1247Yj_l[BdaAdc", ex,"temp cannot be made or made to a writer in addActiveLocation");

        }
        Scanner scan = null;
        try {
            scan = new Scanner(from);
        } catch (FileNotFoundException ex) {
            //bugno sem1247Yj_l[BdaAdc
            new ErrorHandling().activelocationMissing("sem1247Yj_l[BdaAdc", ex,"activelocation cannot be found.");
        }
        while(scan.hasNextLine()){
            try {
                writer.write(scan.nextLine() + "\r\n");
            } catch (IOException ex) {
            //bugno sem1257Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem1257Yj_l[BdaAdc", ex,"could not write tontemp file in addactivelocation.");
            }
        }
        try {
            writer.write(s);
        } catch (IOException ex) {
            //bugno sem1267Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem1267Yj_l[BdaAdc", ex,"could not write tontemp file in addactivelocation.");        }
        try {
            writer.close();
        } catch (IOException ex) {
            //bugno sem1277Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem1277Yj_l[BdaAdc", ex,"could not close writer object of write class in addactivelocation.");
        }
        scan.close();
        try {
            writer = new FileWriter(from);
        } catch (IOException ex) {
            //bugno sem1287Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem1287Yj_l[BdaAdc", ex,"could not find the file named from in addactivelocation.");
        }
        try {
            scan = new Scanner(temp);
        } catch (FileNotFoundException ex) {
            //bugno sem1287Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem1287Yj_l[BdaAdc", ex,"could not find the temp file in addactivelocation.");
        }
        while(scan.hasNextLine()){
            try {
                writer.write(scan.nextLine() + "\r\n");
            } catch (IOException ex) {
            //bugno sem1297Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem1297Yj_l[BdaAdc", ex,"could not find the file named from in addactivelocation.");
            }
        }
        try {
            writer.close();
        } catch (IOException ex) {
            //bugno sem12107Yj_l[BdaAdc
            new ErrorHandling().restartProgram("sem12107Yj_l[BdaAdc", ex,"could not close the writer in addactivelocation.");
        }
        scan.close();
        temp.delete();
    }
    public static void removeActiveLocation(String s) {
        try {
            File from = null;
            try {
                from = new File(pathlocation.getolocation() + "activelocation.txt");
            } catch (Exception ex) {
                //bugno sem1217Yj_l[Beromv
                new ErrorHandling().activelocationMissing("sem1217Yj_l[Beromv", ex, "could not find activelocation in addactivelocation.");
            }
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter(from));
            File temp = File.createTempFile("copying", ".txt");
            Writer out = new FileWriter(temp);
            Scanner scan = new Scanner(from);
            String rem = "";
            while (scan.hasNextLine()) {
                rem = scan.nextLine();
                if (!rem.equalsIgnoreCase(s)) {
                    out.write(rem + "\r\n");
                }
            }
            scan.close();
            out.close();
            scan = new Scanner(temp);
            out = new FileWriter(from);
            while (scan.hasNextLine()) {
                out.write(scan.nextLine() + "\r\n");
            }
            scan.close();
            out.close();
            temp.delete();
        } catch (IOException ex) {
                //bugno sem1227Yj_l[Beromv
                new ErrorHandling().activelocationMissing("sem1227Yj_l[Beromv", ex, "ioexception in removeActiveLocation activelocation is present maybe problem with creation of temp file.");
            }
    }

    public static void removeAllActiveLocations () {
        try {
            File from = null;
            try {
                from = new File(pathlocation.getolocation() + "activelocation.txt");
            } catch (Exception ex) {
                //bugno sem1217Yj_l[Beromp
                new ErrorHandling().activelocationMissing("sem1217Yj_l[Beromp", ex, "could not find activelocation in removeAllActiveLocations.");
            }
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter(from));
            writer.write("");
            writer.close();
        } catch (IOException ex) {
                //bugno sem1227Yj_l[Beronp
                new ErrorHandling().activelocationMissing("sem1227Yj_l[Beronp", ex, "ioexception in removeAllActiveLocations activelocation is present maybe problem with writing to file.");
            }
    }

    public static boolean isActiveLocation(String s) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File(pathlocation.getolocation() + "activelocation.txt"));
        } catch (FileNotFoundException ex) {
            //bugno sem1217Yj_l[BsicAt
                new ErrorHandling().activelocationMissing("sem1217Yj_l[BsicAt",ex,"activelocation missing.");
        }
        while(scan.hasNextLine()){
            if(scan.nextLine().equalsIgnoreCase(s))
                return true;
        }
        return false;
    }
}