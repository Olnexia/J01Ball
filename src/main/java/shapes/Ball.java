package shapes;

public class Ball {
    private int xCoord;
    private int yCoord;
    private int zCoord;
    private int radius;

    public Ball(int xCoord,int yCoord,int zCoord,int radius) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
        this.radius = radius;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getzCoord() {
        return zCoord;
    }

    public void setzCoord(int zCoord) {
        this.zCoord = zCoord;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
