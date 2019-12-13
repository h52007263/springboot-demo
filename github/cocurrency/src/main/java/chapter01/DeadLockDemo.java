package chapter01;

public class DeadLockDemo {
    private static String A="A";
    private static String B="B";
//    LinkedTransferQueue
    /*
        如何分析生成线程的日志信息：
        1.dos窗口下    jps | findstr DealLockDemo(程序名称)
        2.jstack pid > e:/git/analysis/thread.log   重定向到日志文件中
     */
    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
        /*
        输出结果：
            t1--占有--同步对象A并睡了两秒
            t1--准备占有--同步对象B
            t2--占有--同步对象B
            t2--准备占有--同步对象A
         结果分析：
            t1线程始终获取不到B对象
            t2线程始终获取不到A对象
            dump这个程序的日志信息，可以发现在26行和42行出现死锁。
         */
    }

    private void deadLock(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        System.out.println("t1--占有--同步对象A并睡了两秒");
                        System.out.println("t1--准备占有--同步对象B");
                        Thread.currentThread().sleep(2000);
                        synchronized (B){
                            System.out.println("t1--占有--同步对象B");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    System.out.println("t2--占有--同步对象B");
                    System.out.println("t2--准备占有--同步对象A");
                    synchronized (A){
                        System.out.println("t2--占有--同步对象A");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
