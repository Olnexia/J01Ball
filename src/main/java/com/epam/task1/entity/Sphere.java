package com.epam.task1.entity;

import com.epam.task1.logics.idgenerator.IdGenerator;

public class Sphere {
    private final static IdGenerator ID_GENERATOR = IdGenerator.getGenerator();
    private Point center;
    private double radius;
    private long id;

    public Sphere(double radius, Point center) {
        this.radius = radius;
        this.center = center;
        this.id = ID_GENERATOR.getId();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public String toString() {
        return  "Sphere{" +
                "center=" + center +
                "; radius=" + radius +
                "; id=" + id +
                '}';
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
