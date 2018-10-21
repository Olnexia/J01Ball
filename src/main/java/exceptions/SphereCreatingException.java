package exceptions;

public class SphereCreatingException extends Exception {
    private double[] wrongSphereData;
    public double[] getWrongSphereData(){
        return wrongSphereData;
    }
    public SphereCreatingException(String message,double[] wrongSphereData){
        super(message);
        this.wrongSphereData=wrongSphereData;
    }
}
