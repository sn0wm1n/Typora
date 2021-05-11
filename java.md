# 线程池

线程池就是线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，省资源

线程池自行实现____LinkedList<Tread>

程序第一次启动就创建多个线程，保存到一个集合中，当我们需要使用的时候，就remove这个线程获取它的返回值  

`Tread t = list.remove(0) ;`

当我们使用完毕之后需要把线程归还给线程池；

list.add(t); 

### JDK  1.5之后自带了线程池  
java.util.concurrent.Executors——线程池的工厂类，用来生成线程池  

Executors类中的静态方法：

​	static ExecutorService newFixedThreadPool（int nThread）————创建一个可重用固定线程数的线程池（参数为线程池包含的线程数量）

返回值：

​	ExecutorService接口，返回的是ExecutorService接口的实现类对象，我们可以使用ExecutorService接口来接收

方法：

​	submit(Runnable Task) 提交一个Runnable任务用于执行

​	void shutdown（）——销毁线程  

步骤：

```
//通过Executors类静态方法newFixedThreadPool()获取线程池
ExecutorService executorService = Executors.newFixedThreadPool(3);
//加入实现了Runnable接口的实现类对象--自动start()
executorService.submit(new Pro());
executorService.submit(new Pro());
executorService.submit(new Pro());
executorService.shutdown();
//线程池再不能用了
```



​	



