package EventBarrier;

public class Consumer implements Runnable{

	public EventBarrier eventBarrier;
	
	public Consumer(EventBarrier eb){
		eventBarrier = eb;		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			eventBarrier.arrive();
			System.out.println("EventBarrier.Consumer has arrived...");
			eventBarrier.complete();
			System.out.println("EventBarrier.Consumer has completed...");
		}
		
	}

}
