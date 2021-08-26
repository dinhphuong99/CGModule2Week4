package exercise.even_or_odd_number_display;

public  class TestThread {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Main thread running... ");

        OddThread threard1 = new OddThread();

        EvenThread threard2 = new EvenThread();

        threard1.start();
        try{
            threard1.join();
            threard2.start();
        }catch (Exception e){
            e.getMessage();
        }
        System.out.println("Main thread stopped!!! ");
    }
}
