package stacks;
import java.util.LinkedList;
import java.util.Queue;

public class PrintQueueSimulator 
{

	public static void main(String[] args) 
	{	
		PrintQueue queue = new PrintQueue();
		
		PrintJob job1 = new PrintJob(20250516, "Final Destination: Bloodlines Script.pdf", 180);
		queue.addJob(job1);
		
		PrintJob job2 = new PrintJob(20250718, "I Know What You Did Last Summer Script.pdf", 117);
		queue.addJob(job2);
		
		PrintJob job3 = new PrintJob(20260227, "Scream 7 Script.pdf", 112);
		queue.addJob(job3);
		
        queue.processJob();
        queue.peekNextJob();
        queue.displayAllJobs();
	}

}

class PrintJob
{
	private int jobId;
	private String documentName;
	private int pages;
	
	  public PrintJob(int jobId, String documentName, int pages) 
	  {
		  this.jobId = jobId;
          this.documentName = documentName;
          this.pages = pages;
      }
  
      public int getJobId() 
      {
          return jobId;
      }
      
      public String getDocumentName() 
      {
          return documentName;
      }
      
      public int getPages() 
      {
          return pages;
      }
      
      public String toString() 
      {
    	    return "[Job ID]: " + jobId + ", [Document]: \"" + documentName + "\", [Pages]: " + pages;
    	}

}

class PrintQueue
{
	private Queue<PrintJob> queue = new LinkedList<>();
	
	public void addJob(PrintJob job)
	{
		queue.add(job);
		System.out.println("ADDED: " + job);
	}
	
	public PrintJob processJob()
	{
		if (queue.isEmpty())
		{
			System.out.println();
			System.out.println("No jobs to process at the moment.");
			return null;
		}
		
		PrintJob job = queue.remove();
		System.out.println();
		System.out.println("PROCESSING: " + job);
		System.out.println();
		return job;
	}
	
	public PrintJob peekNextJob()
	{
		PrintJob job = queue.peek();
		
		if (job != null	)
		{
			System.out.println("NEXT JOB IN QUEUE: " + job);
		}
		
		else
		{
			System.out.println("QUEUE IS EMPTY.");
		}
		System.out.println();
		return job;
	}
	
	public void displayAllJobs()
	{
		if (queue.isEmpty()) 
		{
            System.out.println("NO JOBS IN QUEUE");
        } 
		
		else 
		{
			System.out.println("ALL JOBS IN QUEUE:");
            
			for (PrintJob job : queue) 
			{
                System.out.println(job);
            }
        }
        System.out.println();
	}
}