package az.sibdtm.multi_thread;

public class Main {
    public static void main(String[] args) {
        System.out.println("salam main thread");
        Thread thread=new ThreadExample();
        thread.setName("Baxtiyar");
        thread.start();
        System.out.println("main thread 2");
        new Thread(() -> System.out.println("anonymous class thread ")).start();
        Thread myRunableThread=new Thread(new MyRunnable());
        myRunableThread.start();
        Thread myRunable=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous runnable thread");
                try {
                    thread.join();
                }catch (InterruptedException e){
                    System.out.println("interrupted");
                }
            }
        });
        myRunable.start();
        thread.interrupt();

    }
}
