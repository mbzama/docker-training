package zama.learning.event.processor;

public class EventProcessorDemo {
	private static Integer counter = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		while(true){
			System.out.println("Processing Event: "+counter);
			counter++;
			Thread.sleep(3000);
		}
	}
}
