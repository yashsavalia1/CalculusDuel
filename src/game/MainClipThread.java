package game;

import java.util.LinkedList;
import java.util.Queue;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class MainClipThread implements Runnable {

    public Queue<String> clipCommandQueue;
    public Clip currentClip;
    private final Object obj;

    public MainClipThread() {
        clipCommandQueue = new LinkedList<String>();
        Thread thread = new Thread(this);
        obj = new Object();
        thread.start();

    }

    public void changeClip(String clipName) {

        clipCommandQueue.add(clipName);
        synchronized (obj) {
            obj.notify();
        }

    }

    @Override
    public void run() {
        while (true) {

            try {
                while (!clipCommandQueue.isEmpty()) {

                    if (currentClip != null) {
                        currentClip.stop();
                    }

                    currentClip = Utility.makeClip(clipCommandQueue.poll());
                    currentClip.start();

                }
                synchronized (obj) {
                    obj.wait();
                }

            } catch (Exception e) {
                System.out.println("Clip Change Error");
                e.printStackTrace();
            }
        }
    }

}
