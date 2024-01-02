import java.io.IOException;

public class Main{
    public static void main(String [] args){
        ProcessBuilder processBuilder=new ProcessBuilder("notepad.exe");
        try{
            Process process= processBuilder.start();
            while (true){
                try{
                    int exitCode=process.exitValue();
                    System.out.println("Process exited with code "+exitCode);
                    break;
                }catch (IllegalThreadStateException e){

                }
                Thread.sleep(1000);
            }

        }catch (IOException | InterruptedException e){{
            throw  new RuntimeException();

            }
        }
    }
}