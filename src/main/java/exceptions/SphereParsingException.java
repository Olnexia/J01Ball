package exceptions;

public class SphereParsingException extends Exception {
    private String wrongLine;
    public String getWrongLine() {
        return wrongLine;
    }
    public SphereParsingException(String message,String wrongLine){
        super(message);
        this.wrongLine=wrongLine;
    }
}
