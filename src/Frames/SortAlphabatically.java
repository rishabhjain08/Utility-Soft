//done
package Frames;

import java.util.LinkedList;
import java.util.List;

public class SortAlphabatically {
    public SortAlphabatically(){
    }
    public String[] sort(String[] s){
        if(s==null)
            return null;
        List <String>l=new LinkedList();
        int i=0,k=0;
        while(i<s.length){
            k=0;
            while(k<l.size()&&l.get(k).compareToIgnoreCase(s[i])<0){
                k++;
            }
            l.add(k,s[i]);
            i++;
        }

        String[] g=new String[l.size()];
        i=0;
        while(i<l.size()){
            g[i]=(String)l.get(i);
            i++;
        }
        return g;
    }
}