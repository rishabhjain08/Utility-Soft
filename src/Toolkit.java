
import Frames.scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Toolkit {
    public List decrypt(File f){
        List l=new LinkedList();
        scanner read = null;
                try {
                    read = new scanner(new InputStreamReader(new FileInputStream(f), "UTF-8"));
                } catch (Exception ex) {
                }
        String g;
        System.out.println("reading file at path : "+f.getPath());
        while(read.hasNextLine()){
            g=read.nextLine();
            System.err.println(g);
            l.add(g);
        }
        read.close();
        return l;
    }
    public static void main(String args[]){
        List decrypt = new Toolkit().decrypt(new File(System.getProperty("user.dir") + "/impinfo.txt"));
    }

}
