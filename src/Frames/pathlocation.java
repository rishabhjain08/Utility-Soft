package Frames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pathlocation {
private static boolean firsttime=true;
private static String rems;
static int server=1;
static int client=0;
public static String actualLocation(){
        return pathlocation.getolocation()+"bills/";
    }
    public static String getlocation() {
//        System.out.println("RETURNINIG : "+pathlocation.getolocation()+"bills/");
        return pathlocation.getolocation()+"bills/";
    }

    static String getolocation()  {
        //throw new UnsupportedOperationException("Not yet implemented");
        if(firsttime){
            firsttime=false;
            Scanner scan=null;
            try {
                scan = new Scanner(new File(System.getProperty("user.dir").replace('\\', '/')+"/loaddatafrom.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(pathlocation.class.getName()).log(Level.SEVERE, null, ex);
            }
            String rem="";
            if(!scan.hasNextLine())
                rems=System.getProperty("user.dir").replace('\\', '/')+"/data/";
            else
                rems = scan.nextLine().replace('\\', '/')+"/";
            scan.close();
            return rems;
       }
        else{
         firsttime=false;
           return rems;
        }
    }
    public static void setLocation(String s,int i) {
        Writer o = null;
        try {
            File f = new File(System.getProperty("user.dir").replace('\\', '/') + "/" + "loaddatafrom.txt");
            o = new FileWriter(f);
            o.write(s+"\r\n");
            o.write(String.valueOf(i));
            pathlocation.firsttime = true;
        } catch (IOException ex) {
            Logger.getLogger(pathlocation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                o.close();
            } catch (IOException ex) {
                Logger.getLogger(pathlocation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static int getType(){
        File f = new File(System.getProperty("user.dir").replace('\\', '/') + "/" + "loaddatafrom.txt");
        Scanner scan=null;
        try {
            scan = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pathlocation.class.getName()).log(Level.SEVERE, null, ex);
        }
        scan.nextLine();
        int g=Integer.parseInt(scan.nextLine());
        scan.close();
        return g;
    }
}