package exercise.even_or_odd_number_display;

public class OddThread extends Thread implements Runnable{
    private Thread t;
    private final Thread myOddThread;

    public OddThread() throws InterruptedException {
        myOddThread = new Thread(this, "odd thread");
        System.out.println("odd thread created" + myOddThread);
//        myOddThread.start();
//        myOddThread.join();
    }

    public Thread getMyThread() {
        return myOddThread;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i+=2) {
                System.out.println("Odd count " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("odd thread interrupted");
        }
        System.out.println("odd thread run is over");
    }

//    public void start() {
//        System.out.println("Starting " + myOddThread);
//        if (t == null) {
//            t = new Thread(this, String.valueOf(myOddThread));
//            System.out.println(t.hashCode());
//            t.start();
//        }
//    }


}
