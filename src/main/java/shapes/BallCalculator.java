package shapes;

public class BallCalculator {

    public double getSurfaceArea(Ball ball){
        int radius = ball.getRadius();
        return 4*Math.PI*radius*radius;
    }

    public double getVolume(Ball ball){
        int radius = ball.getRadius();
        return (4.0/3.0)*Math.PI*radius*radius*radius;
    }

    public double getVolumeRatio(Ball ball,CoordPlane plane){
        //code here
        return 0.0;
    }

    public boolean isBall(Ball ball){
        return ball.getRadius()>0;
    }

    public boolean isTouchedByPlane(Ball ball){
        //code here
        return false;
    }
}
