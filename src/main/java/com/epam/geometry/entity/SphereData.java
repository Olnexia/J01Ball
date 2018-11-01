package com.epam.geometry.entity;

public class SphereData {
    private final double surfaceArea;
    private final double volume;
    private final double volumeRatioByOXY;
    private final double volumeRatioByOXZ;
    private final double volumeRatioByOYZ;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        SphereData data = (SphereData) o;
        return  Double.compare(data.getSurfaceArea(), getSurfaceArea()) == 0 &&
                Double.compare(data.getVolume(), getVolume()) == 0 &&
                Double.compare(data.getVolumeRatioByOXY(), getVolumeRatioByOXY()) == 0 &&
                Double.compare(data.getVolumeRatioByOXZ(), getVolumeRatioByOXZ()) == 0 &&
                Double.compare(data.getVolumeRatioByOYZ(), getVolumeRatioByOYZ()) == 0;
    }

    @Override
    public int hashCode() {
        int result =17;
        final int prime = 31;
        result = prime * result + Double.valueOf(getSurfaceArea()).hashCode();
        result = prime * result + Double.valueOf(getVolume()).hashCode();
        result = prime * result + Double.valueOf(getVolumeRatioByOXY()).hashCode();
        result = prime * result + Double.valueOf(getVolumeRatioByOXZ()).hashCode();
        result = prime * result + Double.valueOf(getVolumeRatioByOYZ()).hashCode();
        return  result;
    }

    @Override
    public String toString() {
        return "SphereData{" +
                "surfaceArea=" + surfaceArea +
                ", volume=" + volume +
                ", volumeRatioByOXY=" + volumeRatioByOXY +
                ", volumeRatioByOXZ=" + volumeRatioByOXZ +
                ", volumeRatioByOYZ=" + volumeRatioByOYZ +
                '}';
    }
}
