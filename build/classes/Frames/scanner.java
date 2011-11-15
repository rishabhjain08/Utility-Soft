package Frames;


import java.io.InputStreamReader;
import java.util.Scanner;

public class scanner {

    Scanner r;

public scanner(InputStreamReader t){
     r=new Scanner(t);
}
public boolean hasNextLine(){
     return r.hasNextLine();
}

public boolean hasNext(){
    return r.hasNext();
}

public String nextLine(){
      return passwordpro.decrypt(r.nextLine());
 }
public String next(){
     return passwordpro.decrypt(r.next());
 }

public void close(){
    r.close();
 }
 
}