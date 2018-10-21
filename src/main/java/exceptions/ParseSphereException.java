package exceptions;

public class ParseSphereException extends Exception {
    private String wrongLine;
    public String getWrongLine() {
        return wrongLine;
    }
    public ParseSphereException(String message,String wrongLine){
        super(message);
        this.wrongLine=wrongLine;
    }
}
