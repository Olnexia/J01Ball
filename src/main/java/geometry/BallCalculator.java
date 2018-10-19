package geometry;

public class BallCalculator {

    public double getSurfaceArea(Ball ball){
        double radius = ball.getRadius();
        return 4 * Math.PI * radius * radius;
    }

    public double getVolume(Ball ball){
        double radius = ball.getRadius();
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public double getVolumeRatio(Ball ball, CoordinatePlane plane){
        double segmentHeight =0;
        double radius = ball.getRadius();
        switch(plane){
            case OXY:
                segmentHeight=ball.getZCoordinate()+radius;
                break;
            case OXZ:
                segmentHeight=ball.getYCoordinate()+radius;
                break;
            case OYZ:
                segmentHeight=ball.getXCoordinate()+radius;
                break;
            default:
                //Add an exception
                break;
        }
        //FIXME
        double segmentVolume = Math.PI * segmentHeight*segmentHeight * (radius - ((1.0 / 3.0) * segmentHeight));
        if(segmentVolume==0){
            return 0.0;
        }else{
            return segmentVolume / (getVolume(ball) - segmentVolume);
        }
    }

    public boolean isBall(Ball ball){
        return ball.getRadius()>0;
    }

    public boolean isTouchedByPlane(Ball ball){
        double xCoordinate = ball.getXCoordinate();
        double yCoordinate = ball.getYCoordinate();
        double zCoordinate = ball.getZCoordinate();
        double radius = ball.getRadius();
        return ( radius>xCoordinate||radius>yCoordinate||radius>zCoordinate);
    }
}
