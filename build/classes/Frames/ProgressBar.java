//done
package Frames;

public class ProgressBar extends Thread{
    loadingdata loadingdata;
    public ProgressBar(){
         loadingdata=new loadingdata();
    }
    @Override
    public void run(){
        loadingdata.setVisible(true);
    }
    public void dispose(){
        loadingdata.dispose();
    }
}
