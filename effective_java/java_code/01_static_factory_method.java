import java.math.BigInteger;
import java.util.Random;

public class effective {

    public static void main(String[] args){
        BigInteger a = new BigInteger(200,1,new Random());
        BigInteger b = BigInteger.probablePrime(200,new Random());

        System.out.println("a = " + a.toString() + ", b = " + b.toString());


    }
}
