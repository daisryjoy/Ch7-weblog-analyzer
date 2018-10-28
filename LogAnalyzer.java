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
    private int[] dayCounts;
    private int[] monthCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /** 
     * Create an object to analyze hourly web accesses.
     * @param name of the log file
     */
    public LogAnalyzer(String name)
    { 
        // Create the array object to hold the hourly, daily, monthly
        // access counts.
        hourCounts = new int[24];
        dayCounts = new int[365];
        monthCounts = new int[12];
        
        // Create the reader to obtain the data.
        reader = new LogfileReader(name);
    }
    
    /**
     * Counts the number of accesses. 
     * @return number of accesses 
     */
    public int numberOfAccesses(){
        int num_counts = 0;
            for(int i = 0; i < hourCounts.length; i++){
                num_counts += hourCounts.length;
            }      
        return num_counts; 
    }
    
    /**
     * Finds the number of accesses per month
     * @return the number of accesses per month 
     */
    public int totalAccessesPerMonth(){
        int total_accesses = 0;
        for(int i = 0; i < monthCounts.length; i++){
                total_accesses += monthCounts.length;
            }      
        return total_accesses; 
    }
    
    /**
     * Finds the number of the average accesses per month 
     * @return average of accesses per month
     */
    public int averageAccessesPerMonth(){
        int total = 0;
        for(int i = 0; i < monthCounts.length; i++){
            total += monthCounts [i];
        }
        
        int average_accesses = total / 12;
        
        return average_accesses;
    }
    
    /**
     * Finds which hour is the busiest hour
     * @return returns int value of the busiest hour 
     */
    public int busiestHour(){
        int busiest = 0;
        for(int i = 0; i < hourCounts.length; i++){
            if (busiest > hourCounts[i]){
                busiest = busiest; 
            }
        }
        return busiest;
    }
    
    /**
     * Finds which hour is the quietest hour
     * @return returns the quietest hour 
     */
    public int quietestHour(){
        int quietest = hourCounts[0];
        for(int i = 0; i < hourCounts.length; i++){
            if(quietest < hourCounts[i] && hourCounts[i] > 0){
                quietest = hourCounts[i];
            }
    }
    return quietest;
     }
    
     /**
      * Finds the two busiest hours
      * @return returns the busiest hour 
      */
    public int busiestTwoHour(){
        int busiestOne = 0;
        int busiestTwo = 0; 
        for(int i = 0; i < hourCounts.length; i++){
            if (hourCounts[i] > busiestOne)
            {
                busiestTwo = busiestOne; 
                busiestOne = hourCounts[i];
            }
            else if(hourCounts[i] > busiestTwo)
            {
                busiestTwo = hourCounts[i];
            } 
    }
    return busiestOne;
    }

    /**
     * Finds the quietest day 
     * @returns the quietest day 
     */
    public int quietestDay(){
        int quietest = dayCounts[0]; 
        for (int i = 0; i < dayCounts.length; i++){
            if(quietest < dayCounts[i] && dayCounts[i] > 0){
                quietest = dayCounts[i];
        }
    }
    return quietest; 
    }
    
    /**
     * Finds the busiest day 
     * @returns the busiest day 
     */
    public int busiestDay(){
        int busiest = 0;
        for(int i = 0; i < dayCounts.length; i++){
            if (busiest > dayCounts[i]){
                busiest = busiest; 
            }
        }
        return busiest;
    }
    
    /**
     * Finds the quietest month 
     * @return the quietest month 
     */
    public int quietestMonth(){
         int quietest = monthCounts[0]; 
        for (int i = 0; i < monthCounts.length; i++){
            if(quietest < monthCounts[i] && monthCounts[i] > 0){
                quietest = monthCounts[i];
        }
    }
    return quietest; 
    }
    
    /**
     * Finds the busiest month 
     * @return the busiest month
     */
    public int busiestMonth(){
        int busiest = 0;
        for(int i = 0; i < monthCounts.length; i++){
            if (busiest > monthCounts[i]){
                busiest = busiest; 
            }
        }
        return busiest;
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
