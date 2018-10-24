package com.epam.task1.entity;

//TODO; .ctor gets central point and radius

public class Sphere {
    private Point center;
    private double radius;

    public Sphere(double radius, double xCoordinate, double yCoordinate, double zCoordinate) {
        center = new Point(xCoordinate,yCoordinate,zCoordinate);
        this.radius = radius;
    }

    public double getXCoordinate() {
        return center.getXCoordinate();
    }

    public double getYCoordinate() {

        return center.getYCoordinate();
    }

    public double getZCoordinate() {

        return center.getZCoordinate();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public int hashCode() {
        int result =17;
        final int prime = 31;
        result = prime * result + Double.valueOf(getRadius()).hashCode();
        result = prime * result + Double.valueOf(getXCoordinate()).hashCode();
        result = prime * result + Double.valueOf(getYCoordinate()).hashCode();
        result = prime * result + Double.valueOf(getZCoordinate()).hashCode();
        return  result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Center: "+center);
        sb.append(" radius: "+radius);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Sphere sphere = (Sphere) o;

        return  Double.compare(sphere.getRadius(), getRadius()) == 0 &&
                Double.compare(sphere.getXCoordinate(),getXCoordinate()) == 0 &&
                Double.compare(sphere.getYCoordinate(),getYCoordinate()) == 0 &&
                Double.compare(sphere.getZCoordinate(),getZCoordinate()) == 0;
    }
}
