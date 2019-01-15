package buscarAereoCercano;

import java.awt.event.ActionListener;

public class JavaSetTimeOut {
    // Asynchronous implementation with JDK 1.8:
    public static void setTimeout(int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                System.out.println("120");
                Thread.
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
    //Use this with caution in main thread – it will suspend everything after the call until timeout expires and runnable executes.

}
