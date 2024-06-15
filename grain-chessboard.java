import java.math.BigInteger;

class Grains {


    BigInteger grainsOnSquare(final int square) {
        if(square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.valueOf(2).pow(square -1);
    }

    BigInteger grainsOnBoard() {

        return BigInteger.valueOf(2).pow(64).subtract(BigInteger.ONE);
    }

}


// nombre de grains sur une case : 2^(n - 1);
// nombre de grains sur la case + toutes case inferieures:  2^n -1;
