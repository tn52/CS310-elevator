package EventBarrier;

public class EventBarrier extends AbstractEventBarrier {

	public int numWaiters;
	public boolean eventSignaled;
	
	public EventBarrier(){
		numWaiters = 0;
		eventSignaled = false;
	}
	
	@Override
	public synchronized void arrive() {
		// TODO Auto-generated method stub
		numWaiters++;
		while(!eventSignaled){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//complete();
	}

	@Override
	public synchronized void raise() {
		// TODO Auto-generated method stub
		eventSignaled = true;
		
		System.out.println("Barrier raised");
		
		notifyAll();
		while(numWaiters!=0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		eventSignaled = false;
		
		System.out.println("Barrier down");
		
	}

	@Override
	public synchronized void complete() {
		// TODO Auto-generated method stub
		numWaiters--;
		while(numWaiters!=0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify(); //necessary? 
		
	}

	@Override
	public int waiters() {
		// TODO Auto-generated method stub
		return numWaiters;
	}
	

}
