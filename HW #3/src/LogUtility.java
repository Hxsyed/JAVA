package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LogUtility {

        // Private variable Initalization.
        private final ArrayList<LogEntry> listLogEntries;

        // This default constructs a new empty arraylist.
        public LogUtility() {
        listLogEntries = new ArrayList<LogEntry>();
        }

        /**
         * This function reads all lines from the given network.log file.
         * @param filename The name of the file.
         * @return outputs a boolean value true after we finish parsing through the file.
         * @throws FileNotFoundException throws exception if the file is not found.
         */
        public boolean parseFile(String filename) throws FileNotFoundException {
                File file = new File(filename);
                try{
                        Scanner in = new Scanner(file);
                        while (in.hasNextLine()){
                                String line = in.nextLine();
                                String[] input = line.split(",");
                                try {
                                        LogEntry log = new LogEntry(input[0], input[1], input[2], input[3], input[4], input[5], input[6]);
                                        listLogEntries.add(log);
                                }catch(Exception e){
                                        System.out.printf("Skipping line: %s%n", line);
                                }
                        }
                        in.close();
                        return true;
                }catch(FileNotFoundException e){
                        return false;
                }
        }

        /**
         * This function returns a list of records between two given dates.
         * @param a The date of the start entry.
         * @param b The date of the end entry.
         * @return an ArrayList containing LogEntry objects between the given dates.
         * @throws ParseException This throws a ParseException if a date cannot be parsed.
         */
        public ArrayList<LogEntry> getBetween(String a, String b)throws ParseException{
                ArrayList<LogEntry> output = new ArrayList<LogEntry>();
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
                try {
                        Date dateStart = formatter.parse(a);
                        Date dateEnd = formatter.parse(b);
                        for(LogEntry log: listLogEntries){
                                try{
                                        Date dateLog =  formatter.parse(log.getDateTime());
                                        if(dateLog.after(dateStart) && dateLog.before(dateEnd) || (dateLog.equals(dateStart) || (dateLog.equals(dateEnd)))) {
                                                output.add(log);
                                        }
                                }
                                catch (ParseException e) {
                                        e.printStackTrace();
                                }
                        }
                } catch (ParseException e) {
                        e.printStackTrace();
                }
                return output;
        }

        /**
         * This functions searches for the first sequence instance within the ArrayList.
         * @param a The first sequence to look for.
         * @return returns the first LogEntry given the parameter.
         */
        public LogEntry findFirstId(String a){
                return CommonSearch(a,"sequence");
        }

        /**
         *  This functions searches for the first dateTime instance within the ArrayList.
         * @param a The first dateTime to look for.
         * @return returns the first LogEntry given the parameter.
         */
        public LogEntry findFirstTimeStamp(String a){
                return CommonSearch(a,"dateTime");
        }

        /**
         * This functions searches for the first sourceIP instance within the ArrayList.
         * @param a The first sourceIP to look for.
         * @return returns the first LogEntry given the parameter.
         */
        public LogEntry findFirstSourceIP(String a){
                return CommonSearch(a,"sourceIP");
        }

        /**
         * This functions searches for the first destinationIP instance within the ArrayList.
         * @param a The first destinationIP to look for.
         * @return returns the first LogEntry given the parameter.
         */
        public LogEntry findFirstDestinationIp(String a){
                return CommonSearch(a,"destinationIP");
        }

        /**
         * This functions searches for the first protocol instance within the ArrayList.
         * @param a The first protocol to look for.
         * @return returns the first LogEntry given the parameter.
         */
        public LogEntry findFirstProtocol(String a){
                return CommonSearch(a,"protocol");
        }

        /**
         * This functions searches for the first packetSize instance within the ArrayList.
         * @param a The first packetSize to look for.
         * @return returns the first LogEntry given the parameter.
         */
        public LogEntry findFirstLength(String a){
                return CommonSearch(a,"packetSize");
        }

        /**
         * This functions searches for the first comment instance within the ArrayList.
         * @param a The first comment to look for.
         * @return returns the first LogEntry given the parameter.
         */
        public LogEntry findFirstDescription(String a){
                return CommonSearch(a,"comment");
        }

        /**
         * This function  is a common method which is used to perform a subroutine search.
         * @param search takes in the value to search for.
         * @param Findin iterates through a switch loop to fetch the correct value.
         * @return the first LogEntry that matches the parameters.
         */
        private LogEntry CommonSearch(String search, String Findin){
                for(LogEntry log: listLogEntries){
                        String compareTo = "";
                        switch (Findin) {
                                case "sequence":
                                        compareTo = log.getSequence();
                                        break;
                                case "packetSize":
                                        compareTo = log.getPacketSize();
                                        break;
                                case "dateTime":
                                        compareTo = log.getDateTime();
                                        break;
                                case "sourceIP":
                                        compareTo = log.getSourceIP();
                                        break;
                                case "destinationIP":
                                        compareTo = log.getDestinationIP();
                                        break;
                                case "protocol":
                                        compareTo = log.getProtocol();
                                        break;
                                case "comment":
                                        compareTo = log.getComment();
                                        break;
                        }
                        if(compareTo.equals(search)) {
                                return log;
                        }
                }
                return null;
        }

        /**
         * This function returns the size of records within the ArrayList.
         * @return returns the number of entries in the ArrayList.
         */
        public String toString(){
                return "LogUtility: there are "+ listLogEntries.size()+ " records";
        }
}
