/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author Daisry Joy Ladignon 
 * @version    2018.10.28
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /** 
     * Create an object to analyze hourly web accesses.
     * @param name of the log file
     */
    public LogAnalyzer(String name)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    /**
     * Counts the number of accesses. 
     */
    public int numberOfAccesses(){
        int num_counts = 0;
            for(int i = 0; i < hourCounts.length; i++){
                num_counts += hourCounts.length;
            }      
        return num_counts; 
    }
    
    /**
     * Finds which hour is the busiest hour
     * @return returns int value of the busiest hour 
     */
    public int busiestHour(){
        int busiestHour=0;
        for(int i = 0; i < hourCounts.length; i++){
            if (busiestHour > hourCounts[i]){
                busiestHour = busiestHour; 
            }
        }
        return busiestHour;
    }
    
    /**
     * Finds which hour is the quietest hour
     * @return returns the int value of the quietest hour 
     */
    public int quietestHour(){
        int quietestHour = hourCounts[0];
        for(int i = 0; i < hourCounts.length; i++){
            if(quietestHour < hourCounts[i] && hourCounts[i] > 0){
                quietestHour = hourCounts[i];
            }
    }
    return quietestHour;
     }
    
     /**
      * 
      */
    public int busiestTwoHour(){
        int busiestOne = 0;
        int busiestTwo = 0; 
        for(int i = 0; i < hourCounts.length; 
        
    }
     

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
}
