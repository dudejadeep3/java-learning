
public class ThreadCreation {
    public static void main(String[] args){
        System.out.println("Inside the main thread");
        Thread a = new CustomThread();
        a.start();
    }
}

class CustomThread extends Thread {
        @Override
        public void run(){
            System.out.println("In the thread");
        }
}