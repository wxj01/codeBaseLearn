JVM的参数类型
    a.标配参数
        -verison
        -help
        java -showversion
    b.X参数（了解）
        -Xint   解释执行
        -Xcomp  第一次使用就编译成本地代码
        -Xmixed 混合模式
    c.XX参数(重要)
        Boolean类型
            公式
                -XX：+或者-  某个属性值
                +表示开启
                -表示关闭
            Case
                是否打印GC收集细节
                    -XX：+PrintGCDetails
                    -XX：-PrintGCDetails
                是否使用串行垃圾收集器
                    -XX：-UseSerialGC
                    -XX：+UseSerialGC
        KV设值类型
                公式
                    -XX：属性key=属性值value
                Case
                    -XX:MetaspaceSize=128m
                    -XX:MaxTenuringThreshold=15
        jinfo举例，如何查看当前运行程序的配置
                公式
                    jinfo -flag 配置项 进程编号
        题外话（坑题）
            两个经典参数：-Xms和-Xmx
            这个你如何解释
                -Xms 等价于 -XX:InitialHeapSize
                -Xmx 等价于-XX:MaxHeapSize

查看JVM默认值
    -XX:+PrintFlagsInitial
        查看初始默认值
        公式
            java -XX:+PrintFlagsInitial -version
            java -XX:+PrintFlagsInitial
    -XX:+PrintFlagsFinal
        主要查看修改更新
        公式
            java -XX:+PrintFlagsFinal
            java -XX:+PrintFlagsFinal -version
    PrintFlagsFinal举例，运行Java命令的同时打印出参数
    -XX:+PrintCommandLineFlags

你平时工作用过的M常用基本配置参数有哪些?
    基础知识复习
    常用参数
        -Xms
            初始大小内存，默认为物理内存1/64
            等价于-XX:InitialHeapSize
        -Xmx
            最大分配内存，默认为物理内存1/4
            等价于-XX:MaxHeapSize
        -Xss
            设置单个线程的大小，一般默认为512K~1024K
            等价于-XX:ThreadStackSize
        -Xmn
            设置年轻代大小
        -XX:MetaspaceSize
            设置元空间大小,(元空间不在虚拟机中，而是使用本地内存)
            -Xms10m -Xmx10m -XX:MetaspaceSize=1024m -XX:+PrintFlagsFinal
        -XX:+PrintGCDetails
            输出详细GC收集日志信息
        -XX:SurvivoRatio
            配置年轻代和老年代再堆结构的占比，默认 -XX:NewRatio=2 新生代占1，老年代占2，年轻代占整个堆的1/3
        -XX:MaxTenuringThreshold
            设置垃圾最大年龄

强引用、软引用、弱引用、虚引用分别是什么?
    强引用（默认支持模式）
        JVM 开始垃圾回收，对于强引用对象，就算出现类OOM 也不回收 即使该对象以后永远都不会用到，JVM也不会回收
    软引用
        当系统内存充足时   不会 被回收
        当系统内存不足时    会  被回收
        用于高速缓存，内存够用就保留，不够用就回收
    弱引用
        只要垃圾回收，不管JVM的内存空间是否足够，都会回收对象占用的内存
        WeakHashMap
    虚引用
        如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都有可能被垃圾回收器回收

请谈谈你对ooM的认识
    Java.lang.StackOverflowError
    Java.lang.OutOfMemoryError:Java heap space
    Java.lang.OutOfMemoryError:GC overhead limit exceeded
    Java.lang.OutOfMemoryError:Direct buffer memory
    Java.lang.OutOfMemoryError:unable to create new native thread