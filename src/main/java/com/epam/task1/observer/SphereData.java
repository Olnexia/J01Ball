package com.epam.task1.observer;

public class SphereData {
    private double surfaceArea;
    private double volume;
    private double volumeRatioByOXY;
    private double volumeRatioByOXZ;
    private double volumeRatioByOYZ;

    public SphereData(double surfaceArea, double volume, double volumeRatioByOXY, double volumeRatioByOXZ, double volumeRatioByOYZ) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
        this.volumeRatioByOXY = volumeRatioByOXY;
        this.volumeRatioByOXZ = volumeRatioByOXZ;
        this.volumeRatioByOYZ = volumeRatioByOYZ;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getVolumeRatioByOXY() {
        return volumeRatioByOXY;
    }

    public double getVolumeRatioByOXZ() {
        return volumeRatioByOXZ;
    }

    public double getVolumeRatioByOYZ() {
        return volumeRatioByOYZ;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setVolumeRatioByOXY(double volumeRatioByOXY) {
        this.volumeRatioByOXY = volumeRatioByOXY;
    }

    public void setVolumeRatioByOXZ(double volumeRatioByOXZ) {
        this.volumeRatioByOXZ = volumeRatioByOXZ;
    }

    public void setVolumeRatioByOYZ(double volumeRatioByOYZ) {
        this.volumeRatioByOYZ = volumeRatioByOYZ;
    }
}
