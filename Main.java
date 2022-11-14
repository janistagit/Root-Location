/*
 * Project 3
 * By Janista Gitbumrungsin
 * CS3010.02 Fall 2022
 * Dr. Lajpat Rai Raheja
 */

 class Main
 {
    public static void main(String[] args)
    {

    }

    private double f(double x)
    {
        return (2 * Math.pow(x, 3)) - (11.7 * Math.pow(x, 2)) + (17.7 * x) -5;
    }

    private double fPrime(double x)
    {
        return (6 * Math.pow(x, 2)) - (23.4 * x) + 17.7;
    }

    private double g(double x)
    {
        return x + 10 - (x * Math.cosh(50/x));
    }

    private double gPrime(double x)
    {
        return 1 + (50 * Math.sinh(50/x) / x) - Math.cosh(50/x);
    }
 
 }