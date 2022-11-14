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

    private void bisection(double a, double b, double epsilon)
    {
        int n;
        int nmax = 100;
        double c, fa, fb, fc, error;

        fa = f(a);
        fb = f(b);

        if(Math.signum(fa) == Math.signum(fb))
        {
            System.out.println("a: " + a + " b: " + b + " f(a): " + fa + " f(b): " + fb);
            System.out.println("Function has same signs at a and b.");
            return;
        }

        error = b-a;

        for(n = 0; n < nmax; n++)
        {
            error = error/2;
            c = a + error;
            fc = f(c);
            System.out.println("n = " + n + " c: " + c + " f(c): " + fc + " error: " + error);
            
            if(n == 99)
            {
                System.out.println("Slowly converges. Maximum iterations reached.");
            }

            if(Math.abs(error) < epsilon)
            {
                System.out.println("Convergence.");
                return;
            }

            if(Math.signum(fa) != Math.signum(fc))
            {
                b = c;
                fb = fc;
            }
            else
            {
                a = c;
                fa = fc;
            }
        }  
    }

    private void bisection2(double a, double b, double epsilon)
    {
        int n;
        int nmax = 100;
        double c, fa, fb, fc, error;

        fa = g(a);
        fb = g(b);

        if(Math.signum(fa) == Math.signum(fb))
        {
            System.out.println("a: " + a + " b: " + b + " f(a): " + fa + " f(b): " + fb);
            System.out.println("Function has same signs at a and b.");
            return;
        }

        error = b-a;

        for(n = 0; n < nmax; n++)
        {
            error = error/2;
            c = a + error;
            fc = g(c);
            System.out.println("n = " + n + " c: " + c + " f(c): " + fc + " error: " + error);

            if(n == 99)
            {
                System.out.println("Slowly converges. Maximum iterations reached.");
            }

            if(Math.abs(error) < epsilon)
            {
                System.out.println("Convergence.");
                return;
            }

            if(Math.signum(fa) != Math.signum(fc))
            {
                b = c;
                fb = fc;
            }
            else
            {
                a = c;
                fa = fc;
            }
        }  
    }
 
 }