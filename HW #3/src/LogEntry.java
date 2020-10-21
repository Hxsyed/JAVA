package src;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry {
    // Private variable Initalization, total of 7 variables
    private final String sequence;
    private final String packetSize;
    private final String dateTime;
    private final String sourceIP;
    private final String destinationIP;
    private final String protocol;
    private final String comment;

    /**
     * This non default constructor takes 7 parameters as strings and stores them as private variables.
     * @param sequence The value to be given to this.sequence.
     * @param dateTime The value to be given to this.dateTime.
     * @param sourceIP The value to be given to this.sourceIP.
     * @param destinationIP The value to be given to this.destinationIP.
     * @param protocol The value to be given to this.protocol.
     * @param packetSize The value to be given to this.packetSize.
     * @param comment The value to be given to this.comment.
     * @throws InstantiationException This throws an InstantiationException when a restiction occured.
     */
    public LogEntry(String sequence, String dateTime, String sourceIP, String destinationIP, String protocol, String packetSize, String comment) throws InstantiationException {
        try{
            int a = Integer.parseInt(sequence);
            if(a<1 || a>Integer.MAX_VALUE){
                throw new InstantiationException();
            }
            int b = Integer.parseInt(packetSize);
            if(b<1|| b>1500){
                throw new InstantiationException();
            }
            if(dateTime.length()!=19){
                throw new InstantiationException();
            }
            if(sourceIP.length()==0 || sourceIP==null){
                throw new InstantiationException();
            }
            if(destinationIP.length()==0|| destinationIP==null){
                throw new InstantiationException();
            }
            if(!protocol.equals("UDP") &&!protocol.equals("TCP")){
                throw new InstantiationException();
            }
        }catch(InstantiationException e){
            throw new InstantiationException("One or more values are invalid");
        }
        this.sequence=sequence;
        this.packetSize=packetSize;
        this.dateTime = dateTime;
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.protocol = protocol;
        this.comment = comment;
    }

    /**
     * This function returns the output string to Log Utility File
     * @return returns a string the the order: sequnce, datetime, sourceIP, destinationIP, protocol, comment, packetsize.
     */
    public String toString(){
        String output = this.sequence + "," + this.dateTime + "," + this.sourceIP + "," + this.destinationIP + "," + this.protocol + "," + this.packetSize + "," +this.comment;
        return output;
    }

    /**
     * This Function to return DateTime in a specific format
     * @return returns the value of dateTime as a Date object.
     * @throws ParseException throws a ParseException if the dateTime is not in sync with the SimpleDateFormat.
     */
    public Date getDateTimeAsDate() throws ParseException {
        SimpleDateFormat huh = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date log;
        try{
            log = huh.parse(dateTime);
        }
        catch(ParseException e){
            return null;
        }
        return log;
    }

    // 7 getters methods
    /**
     * @return the value of sequence as a string.
     */
    public String getSequence(){
        return this.sequence;
    }
    /**
     * @return the value of dateTime as a string.
     */
    public String getDateTime(){
        return this.dateTime;
    }
    /**
     * @return the value of sourceIP as a string.
     */
    public String getSourceIP(){
        return this.sourceIP;
    }
    /**
     * @return the value of destinationIP as a string.
     */
    public String getDestinationIP(){
        return this.destinationIP;
    }
    /**
     * @return the value of protocol as a string.
     */
    public String getProtocol(){
        return this.protocol;
    }
    /**
     * @return the value of comment as a string.
     */
    public String getComment(){ return this.comment; }
    /**
     * @return the value of packetSize as a string.
     */
    public String getPacketSize(){ return this.packetSize; }
}
