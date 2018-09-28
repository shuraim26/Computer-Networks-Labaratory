

/*
Don't use this code for real Encryption, it's just a demonstration of how RSA algorith works.
*/

import java.math.BigInteger;
import java.util.Random;

public class JavaApplication67 {

    public static void main(String[] args) {

        Random r1 = new Random();
        Random r2 = new Random();
        int pkey = Integer.parseInt(args[0]);
        BigInteger p = BigInteger.probablePrime(8, r1);
        BigInteger q = BigInteger.probablePrime(8, r2);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        while (true) {
            BigInteger g = phi.gcd(new BigInteger("" + pkey));
            if (g.equals(BigInteger.ONE)) {
                break;
            }
            pkey++;
        }
        BigInteger pubkey = new BigInteger("" + pkey);
        BigInteger prvkey = pubkey.modInverse(phi);
        System.out.println("public key : " + pubkey + "," + n);
        System.out.println("private key : " + prvkey + "," + n);

        int m = Integer.parseInt(args[1]);
        BigInteger val = new BigInteger("" + m);
        BigInteger cipher = val.modPow(pubkey, n);
        System.out.println("Cipher text: " + cipher);
        BigInteger plain = cipher.modPow(prvkey, n);
        int plainVal = plain.intValue();
        System.out.println("Plain text:" + plainVal);

    }

}
