package exceptions;

public class InputFileNotFoundException extends Exception {
    private String wrongPath;
    public String getWrongPath() {
        return wrongPath;
    }
    public InputFileNotFoundException(String message,String wrongPath){
        super(message);
        this.wrongPath=wrongPath;
    }
}
