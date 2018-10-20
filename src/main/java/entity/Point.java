package entity;

public class Point {
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
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

    @Override
    public int hashCode() {
        int result =14;
        result = 31 * result + (int)xCoordinate;
        result = 21 * result + (int)yCoordinate;
        result = 11 * result + (int)zCoordinate;
        return  result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Point at ["+xCoordinate);
        sb.append(";"+yCoordinate);
        sb.append(";"+zCoordinate);
        sb.append("]");
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
        Point point = (Point)obj;

        return Double.compare(xCoordinate, xCoordinate) == 0 &&
                Double.compare(yCoordinate, yCoordinate) == 0 &&
                Double.compare(zCoordinate, zCoordinate) == 0;
    }
}
