package exercise.even_or_odd_number_display;

public class EvenThread extends Thread implements Runnable {
    private Thread t;
    private final Thread myEvenThread;

    public EvenThread() throws InterruptedException {
        myEvenThread = new Thread(this, "even thread");
        System.out.println("even thread created" + myEvenThread);
//        myEvenThread.start();
//        myEvenThread.join();
    }


    public Thread getMyThread() {
        return myEvenThread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i+=2) {
                System.out.println("Even count " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("even thread interrupted");
        }
        System.out.println("even thread run is over");
    }

//    public void start() {
//        System.out.println("Starting " + myEvenThread);
//        if (t == null) {
//            t = new Thread(this, String.valueOf(myEvenThread));
//            System.out.println(t.hashCode());
//            t.start();
//        }
//    }
}