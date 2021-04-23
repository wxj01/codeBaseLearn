CountDownLatch :让一些线程阻塞直到另外一些完成后才被唤醒。
CountDownLatch主要有两个方法,当一个或多个线程调用await方法时,调用线程会被阻塞.
其他线程调用countDown方法计数器减1(调用countDown方法时线程不会阻塞),当计数器的值变为0,因调用await方法被阻塞的线程会被唤醒,继续执行


CyclicBarrier：
CyclicBarrier的字面意思是可循环(Cyclic) 使用的屏障(barrier).
它要做的事情是,让一组线程到达一个屏障(也可以叫做同步点)时被阻塞,
直到最后一个线程到达屏障时,屏障才会开门,所有被屏障拦截的线程才会继续干活,线程进入屏障通过CyclicBarrier的await()方法.


Semaphore:
信号量的主要用户两个目的,一个是用于多核共享资源的相互排斥使用,另一个用于并发资源数的控制.