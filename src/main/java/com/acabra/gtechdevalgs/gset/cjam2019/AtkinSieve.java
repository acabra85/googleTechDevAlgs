package com.acabra.gtechdevalgs.gset.cjam2019;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class AtkinSieve {
    /******************************************************************************
     *  Compilation:  javac AtkinSieve.java
     *  Execution:    java AtkinSieve [number] [verbose]
     *  @author: Luca F
     *
     *  % java AtkinSieve 1000
     *  Found 168 primes
     *
     *  verbose to show all results
     *  This file is intended for didactic purpose, to demonstrate how
     *  Atkin - Bernstein sieve works
     *  source: https://gist.githubusercontent.com/lucafmi/729f6516799163b1a167ea233abbb3c6/raw/d9ec7e58960602d8091cea22268b51833a816a0a/AtkinSieve.java
     *  consulted on: Apr 6 2019
     *
     ******************************************************************************/
    public static void main(String[] args) {
        new AtkinSieve().run("101");
    }

    public List<BigInteger> run(String N) {
        // Check if args[0] is specified and if it's valid
        int size = 1;
        try{
            size = Integer.parseInt(N);
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
        // Create a boolean array to manage Atkin Sieve
        boolean[] numbers = new boolean[size+1];
        // Create variables for temporary equations solutions
        int z = 0;

        // Setting 2,3,5 as primes
        numbers[2] = true;numbers[3] = true;numbers[5] = true;

        // instead of solving equations, we will generate results from x and y roots
        // the maximum admitted value for y is inferred by x
        // 1st equation
        for(int x=1; x<=(int)Math.sqrt(size/4);x++)
            for(int y=1;y<=(int)Math.sqrt(size-4*x*x);y++){
                z = 4 * x * x + y * y;
                // First condition: if z1 modulo 60 gives one of these remainders, we flip the number status:
                if( z % 60 == 1  ||
                        z % 60 == 13 ||
                        z % 60 == 17 ||
                        z % 60 == 29 ||
                        z % 60 == 37 ||
                        z % 60 == 41 ||
                        z % 60 == 49 ||
                        z % 60 == 53 )
                    numbers[z] = !numbers[z];
            }

        // 2nd equation
        for(int x=1; x<=(int)Math.sqrt(size/3);x++)
            for(int y=1;y<=(int)Math.sqrt(size- 3*x*x);y++){
                z = 3 * x * x + y * y;
                if( z % 60 == 7  ||
                        z % 60 == 19 ||
                        z % 60 == 31 ||
                        z % 60 == 43 )
                    numbers[z] = !numbers[z];
            }

        // 3rd equation; for this one, we can assume that y must be < x, so the condition is inverted
        for(int x=1; x<=(int)Math.sqrt(size);x++)
            for(int y=(int)Math.sqrt(3*x*x-size);y<=(int)Math.sqrt(3)*x;y++){

                z = 3 * x * x - y * y;

                if(z <= size){
                    if( z % 60 == 11  ||
                            z % 60 == 23 ||
                            z % 60 == 47 ||
                            z % 60 == 59 )
                        numbers[z] = !numbers[z];
                }else{
                    //         System.out.println(z +" exceeds " + x + " "+y);
                }
            }


        // removing al square multiples
        for (int i = 5; i <= (int)Math.sqrt(size); i++)
            for (int j = 1; j * i * i <= size; j++)
                numbers[j * i * i] = false;

        // We have done! Showing the result..
        List<BigInteger> primes = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            if (numbers[i] == true) {
                primes.add(new BigInteger("" + i));
            }
        }

        System.out.println("Found " + primes.size() + " primes");
        return primes;
    }

}