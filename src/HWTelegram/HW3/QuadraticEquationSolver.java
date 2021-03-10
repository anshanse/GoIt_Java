package HWTelegram.HW3;

public class QuadraticEquationSolver {
    public double[] solve(int a, int b, int c){
        double diskr = b*b-4*a*c;
        double [] roots0 = new double[0];
        if (diskr>0){
            double [] roots2 = new double[2];
            roots2[0] = (-b + Math.sqrt(diskr))/(2*a);
            roots2[1] = (-b - Math.sqrt(diskr))/(2*a);
            return roots2;
        }
        else if (diskr==0){
            double [] roots1 = new double[1];
            roots1[0] = (-b + Math.sqrt(diskr))/(2*a);
            return roots1;
        }
        else{
            return roots0;
        }
    }
}
