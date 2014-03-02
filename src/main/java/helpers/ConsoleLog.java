package helpers;

/**
 * Console Logger for logs on the console
 * @author Amanzou Amine <amineamanzou@gmail.com>
 */
public class ConsoleLog {

    private boolean debugMode;

    public ConsoleLog(){
        this.debugMode = false;
    };

    public ConsoleLog(boolean debugEnabled){
        this.debugMode = debugEnabled;
    };

    /**
     * Classical display with line break
     * @param msg 
     */
    public void println(String msg){
        System.out.println(msg);
    };
    
    /**
     * Display a tab with informations
     * @param col
     */
    public void printTab(String[] col){
        System.out.printf("%-2s| %-10s%-10s%-10s%-7s%s%n",col[0],col[1],col[2],col[3],col[4],col[5]);
    }
    
    /**
     * Classical display without line break
     * @param msg 
     */
    public void print(String msg){
        System.out.print(msg);
    };

    /**
     * Méthode for logging in debug mode
     * @param msg 
     **/
    public void log(String msg){
        if(isDebugMode())
            System.out.println("#LOG : "+msg+"#");
    }

    /**
     * @return the debugMode
     */
    public boolean isDebugMode() {
        return debugMode;
    }

    /**
     * @param debugMode the debugMode to set
     */
    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }
}
