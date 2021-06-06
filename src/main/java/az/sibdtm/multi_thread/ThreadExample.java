package az.sibdtm.multi_thread;

public class ThreadExample extends Thread{
    @Override
    public void run() {
        System.out.println("salam thredexample "+this.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("woke me up");
            return;
        }

        System.out.println(" 5 sayiy' gozedim");
    }
}
