package FileHandling;

import java.io.File;
 public class Delete {

    public Delete(File f){
        delete(f);
    }
    private void delete(File f){
        File subs[]=f.listFiles();
        int i=0;
        while(i<subs.length){
            if(subs[i].isDirectory())
                delete(subs[i]);
            else
                subs[i].delete();
            i++;
         }
    }

}
