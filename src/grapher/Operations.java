package grapher;

import java.util.ArrayList;

public class Operations {

    private static double meanX = 0;
    private static double meanY = 0;
    private static double correlation = 0;
    private static double slope = 0;
    private static double intercept = 0;

    public static void setMeanX(ArrayList<Double> xCoords, int pairs) {

        double sum = 0;

        for (int i = 0; i < xCoords.size(); i++) {

            sum += xCoords.get(i);
        }

        meanX = (sum / pairs);

    }

    public static void setMeanY(ArrayList<Double> yCoords, int pairs) {

        float sum = 0;

        for (int i = 0; i < yCoords.size(); i ++) {

            sum += yCoords.get(i);
        }

        meanY = (sum / pairs);

    }

    public static void setCorrelation(ArrayList<Double> coordsX, ArrayList<Double> coordsY, int pairs) {

        double topSum=0;
        double bottomLeftSum=0;
        double bottomRightSum=0;

        for (int i = 0; i < pairs; i++) {
            
            topSum+=((coordsX.get(i)-meanX)*(coordsY.get(i)-meanY));
            bottomLeftSum+=((coordsX.get(i)-meanX)*(coordsX.get(i)-meanX));
            bottomRightSum+=((coordsY.get(i)-meanY)*(coordsY.get(i)-meanY));
            
        }

        correlation=topSum/(Math.sqrt(bottomLeftSum*bottomRightSum));

    }

    public static void setSlope(ArrayList<Double> coordsX, ArrayList<Double> coordsY,int pairs) {
        
        double topSum=0;
        double bottomSum=0;

        for (int i = 0; i < pairs; i++) {
            
            topSum+=((coordsX.get(i)-meanX)*(coordsY.get(i)-meanY));
            bottomSum+=((coordsX.get(i)-meanX)*(coordsX.get(i)-meanX));
               
        }

        slope=topSum/bottomSum;
         
    }

    public static void setIntercept() {
        
        intercept=(meanY-(slope*meanX));
        
    }

    public static double getSlope() {
        return slope;
    }

    public static double getIntercept() {
        return intercept;
    }
    
    public static double getMeanX() {
        return meanX;
    }

    public static double getMeanY() {
        return meanY;
    }

    public static double getCorrelation() {
        return correlation;
    }

}
