公平锁
    是指多个线程按照申请锁的顺序来获取锁类似排队打饭 先来后到
非公平锁
    是指在多线程获取锁的顺序并不是按照申请锁的顺序,有可能后申请的线程比先申请的线程优先获取到锁,在高并发的情况下,有可能造成优先级反转或者饥饿现象


并发包ReentrantLock的创建可以指定构造函数的boolean类型来得到公平锁或者非公平锁 默认是非公平锁

可重入锁/递归锁：线程可以进入任何一个它已经标记的锁所同步的代码块

独占锁：该锁一次只能被一个线程所持有，ReentrantLock和Synchronized 都是。

共享锁：该锁可被多个线程持有。 ReentrantReadWriteLock 的读是共享锁，写是独占锁。