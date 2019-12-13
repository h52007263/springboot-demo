package chapter01;

public class ConcurrencyTest {
    private static final long count=100000001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
        /*
        输出结果：
            10万次：
            concurrency :0ms,b=-100001
            serial :10ms,b=-100001,a=500005

            100万次：
            concurrency :10ms,b=-1000001
            serial :10ms,b=-1000001,a=5000005

            一亿次：
            concurrency :50ms,b=-100000001
            serial :80ms,b=-100000001,a=500000005
         */
    }

    private static void concurrency() throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int a=0;
                for(long i=0;i<count;i++)
                    a+=5;
            }
        });
        thread.start();
        int b=0;
        for(long i=0;i<count;i++){
            b--;
        }
        thread.join();
        long time=System.currentTimeMillis()-start;
        System.out.println("concurrency :"+time+"ms,b="+b);
    }

    private static void serial(){
        long start=System.currentTimeMillis();
        int a=0;
        for (long i = 0; i < count; i++) {
            a+=5;
        }
        int b=0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time=System.currentTimeMillis()-start;
        System.out.println("serial :"+time+"ms,b="+b+",a="+a);

    }
}
