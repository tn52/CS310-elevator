package EventBarrier;

public class TestEventBarrier {
	
	
	
	  public static void main(String[] args) {
		  
		  	EventBarrier eb = new EventBarrier();
		  	
		  	Consumer consumer1 = new Consumer(eb);
		  	Consumer consumer2 = new Consumer(eb);
		  	Consumer consumer3 = new Consumer(eb);
		  	Consumer consumer4 = new Consumer(eb);
		  	
		  	Producer producer1 = new Producer(eb);
		  	Thread a = new Thread(consumer1);
		  	Thread b = new Thread(consumer2);
		  	Thread d = new Thread(consumer3);
		  	Thread e = new Thread(consumer4);
		  	Thread c = new Thread(producer1);
		  	
		  	a.start();
		  	b.start();
		  	d.start();
		  	e.start();
		  	
		  	c.start();
		  
//		    Jabber j = new Jabber("1");
//		    Jabber k = new Jabber("2");
//		    Thread t = new Thread(j);
//		    Thread u = new Thread(k);
//		    t.start();
//		    u.start();
		  
		  }
}
