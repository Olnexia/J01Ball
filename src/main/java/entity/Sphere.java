package entity;

public class Sphere {
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;
    private double radius;

    public Sphere(double radius, double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
        this.radius = radius;
    }

    public double getXCoordinate() {

        return xCoordinate;
    }

    public double getYCoordinate() {

        return yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    public double getRadius() {

        return radius;
    }

    @Override
    public int hashCode() {
        int result =14;
        result = 41 * result + (int)radius;
        result = 31 * result + (int)xCoordinate;
        result = 21 * result + (int)yCoordinate;
        result = 11 * result + (int)zCoordinate;
        return  result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Center at ["+xCoordinate);
        sb.append(";"+yCoordinate);
        sb.append(";"+zCoordinate);
        sb.append("] radius: "+radius);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null ){
            return false;
        }
        if(!(obj instanceof Sphere)){
            return false;
        }
        if(obj==this){
            return true;
        }
        Sphere sphere = (Sphere)obj;

        return Double.compare(sphere.xCoordinate, xCoordinate) == 0 &&
                Double.compare(sphere.yCoordinate, yCoordinate) == 0 &&
                Double.compare(sphere.zCoordinate, zCoordinate) == 0 &&
                Double.compare(sphere.radius, radius) == 0;
    }
}
