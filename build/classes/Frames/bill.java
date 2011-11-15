package Frames;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bill {
    String year,name,billno,serialno;
    private boolean init() throws IOException, Exception {

        writer output = new writer();
        boolean exists=false;
        File bfile=new File(pathlocation.getlocation()+"/"+year+"/"+name);
        bfile.mkdir();
        String[] names=new SortAlphabatically().sort((new File(pathlocation.getlocation()+"/"+year)).list());
        int i=0;
        while(i<names.length){
            if(names[i].equals(name)){
                exists=true;
                break;
            }
            i++;
        }
        TypeofBills types=new TypeofBills();
        String ty[]=types.getFolderName();
        if(exists){
            for(int y=0;y<ty.length;y++){
                new File(pathlocation.getlocation()+"/"+year+"/"+name+"/"+ty[y]+"/").mkdir();
            }
         if (billno==null)
                 billno="";

         File f=new File(pathlocation.getlocation()+"/"+year+"/"+name+"/"+"billfromto.txt");

        output.init((new FileWriter(f)));
        output.write(billno);
        output.close();
        f=new File(pathlocation.getlocation()+"/"+year+"/"+name+"/"+"serialno.txt");
        writer writer=new writer();
        writer.init((new FileWriter(f)));
        writer.write(serialno);
        writer.close();

          }

        if(!exists){
        i=0;
         while(i<names.length){
             if(!(new File(pathlocation.getlocation()+"/"+year+"/"+names[i]+"/"+"billfromto.txt").exists()))
                 (new File(pathlocation.getlocation()+"/"+year+"/"+names[i])).delete();
            i++;
         }
        throw new Exception("Could Not Make the new Name");
        }

             return exists;



         }

    bill(String year1,String name1,String billno1,String serial)  {
        year=year1;
        name=name1;
        billno=billno1;
        serialno=serial;
        try {
            boolean possible = init();
        } catch (IOException ex) {
            Logger.getLogger(bill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            if(ex.getMessage().equals("Could Not Make the new Name"))
             (new error_1()).setVisible(true);
        }


}
}
