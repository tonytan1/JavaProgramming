package ShowMeCode.Concurrency;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tony.tan on 6/18/2015.
 *
 * search the file and controlling the interruption of a thread.
 *
 */
public class FileSearch implements Runnable {
    private String initPath;
    private String fileName;
    public FileSearch(String initPath, String fileName){
        this.initPath = initPath;
        this.fileName = fileName;
    }//constructor

    @Override
    public void run() {
        File file = new File(initPath);
        if(file.isDirectory()){
            try{
                directoryProcess(file);
            }catch (InterruptedException e){
                System.out.printf("%s: The search has been interrupted",
                        Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException{
        File list[] = file.listFiles();
        if(list != null){
            for(int i=0; i<list.length; i++){
                if(list[i].isDirectory()){
                    directoryProcess(list[i]);//recursive call
                }else{
                    fileProcess(list[i]);
                }
            }
        }
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)){
            System.out.printf("%s : %s\n", Thread.currentThread().getName(),
                    file.getAbsolutePath());
        }
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    public static void main(String[] args){
        FileSearch searcher = new FileSearch("C:\\", "FileSearch.java");
        Thread thread=new Thread(searcher);
        thread.start();

        try{
            TimeUnit.SECONDS.sleep(100);//concurrency API throws InterruptedException.
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
    }
}