package com.kyrie.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 一、用于解决多线程安全问题的方式：
 *
 * synchronized:隐式锁
 * 1. 同步代码块
 *
 * 2. 同步方法
 *
 * jdk 1.5 后：
 * 3. 同步锁 Lock
 * 注意：是一个显示锁，需要通过 lock() 方法上锁，必须通过 unlock() 方法进行释放锁
 */
public class TestLock {

	public static void main(String[] args) {

	  	Lock lock = new ReentrantLock();
		Ticket ticket = new Ticket(lock);



		new Thread(ticket, "1号窗口").start();
		new Thread(ticket, "2号窗口").start();
		new Thread(ticket, "3号窗口").start();
	}

}

class Ticket implements Runnable{

  private Lock lock ;

	private int tick = 100;
	public Ticket(Lock lock ){
	  this.lock = lock;
  }



	@Override
	public void run() {
		while(tick > 0){

			lock.lock(); //上锁

			try{
				if(tick > 0){
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
					}

					System.out.println(Thread.currentThread().getName() + " 完成售票，余票为：" + --tick);
				}
			}finally{
				lock.unlock(); //释放锁
			}
		}
	}

}
