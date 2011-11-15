package Frames;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class writer {

    Writer w;

   public void write(String s) throws IOException{
       
       if( s.length()>1&&(s.substring(0, s.length()-2)+"\r\n").equals(s)){
                      w.write(passwordpro.encrypt(s.substring(0, s.length()-2))+"\r\n");
                   return;
        } 
       w.write(passwordpro.encrypt(s));
   }
   public void close() throws IOException{
       w.close();
   }
   public void init(FileWriter f){
        w=f;
   }

   public void init(BufferedWriter f){
        w=f;
   }
  }
