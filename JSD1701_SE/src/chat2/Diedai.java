package chat2;

public class Diedai {
	/*
	 * x = 5x+6
	 */
	public static void main(String[] args) {
		double B = DEG(30.0);
		int i =1;
        while (true) {
            double t = B;
            
            System.out.println("t---"+DMS(t));
            B  =Math.atan(1 / (Math.cos(B) * Math.cos(B))-1) ;
            
            double t1 = B;
            System.out.println("第"+ i++ +"次t1迭代结果："+DMS(t1));
            System.out.println("t新：---"+DMS(t));
            if ((t1-t) < 0.00000001) {
                System.out.println("迭代最终结果: "+DMS(B));
                
                break;
            }
        }
	}

	private static double DMS(double ang) {
		ang += 1.0E-15;//加上一个小量，以保证进位
        int fuhao = (int)(ang / Math.abs(ang));
        ang = Math.abs(ang) * 180.0 / Math.PI;
        int d = (int)ang;
        ang = (ang - d) * 60.0;
        int m = (int)ang;
        double s = (ang - m) * 60.0;
        return (d + m / 100.0 + s / 10000.0) * fuhao;
	}

	private static double DEG(double ang) {
		 int fuhao = (int)(ang / Math.abs(ang));
         ang = Math.abs(ang);
         int d = (int)ang;
         int m = ((int)(ang * 100)) - d * 100;
         double s = ang * 10000 - m * 100 - d * 10000;
         return ((d + m / 60.0 + s / 3600.0) * fuhao) / 180.0 * Math.PI;
	}
}
