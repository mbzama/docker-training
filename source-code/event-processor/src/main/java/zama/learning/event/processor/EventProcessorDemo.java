package zama.learning.event.processor;

public class EventProcessorDemo {
	private static Integer counter = 0;
	
	public static void main(String[] args) throws InterruptedException {
		String javaVersion = "Running on "+System.getProperty("java.version")+" java version - ";
		
		while(true){
			System.out.println(javaVersion + new Date() +" - Processing Event: "+counter );
			counter++;
			Thread.sleep(3000);
		}
	}
}
