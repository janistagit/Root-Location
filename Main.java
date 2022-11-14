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

    private void bisection(double a, double b)
    {
        int n;
        int nmax = 100;
        double epsilon = 0.01;
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

    private void bisection2(double a, double b)
    {
        int n;
        int nmax = 100;
        double epsilon = 0.01;
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

    private void newton(double x, double delta)
    {
        int n;
        int nmax = 100;
        double epsilon = 0.01;
        double fx, fp, d;

        fx = f(x);
        System.out.println("n = 0" + " x: " + x + " f(x): " + fx);

        for(n = 1; n < nmax; n++)
        {
            fp = fPrime(x);
            if(Math.abs(fp) < delta)
            {
                System.out.println("Small derivative.");
                return;
            }

            d = fx/fp;
            x = x - d;
            fx = f(x);
            System.out.println("n = " + n + " x: " + x + " f(x): " + fx);

            if(n == 99)
            {
                System.out.println("Slowly converges. Maximum iterations reached.");
            }

            if(Math.abs(d) < epsilon)
            {
                System.out.println("Convergence.");
                return;
            }
        }
    }

    private void newton2(double x, double delta)
    {
        int n;
        int nmax = 100;
        double epsilon = 0.01;
        double fx, fp, d;

        fx = g(x);
        System.out.println("n = 0" + " x: " + x + " f(x): " + fx);

        for(n = 1; n < nmax; n++)
        {
            fp = gPrime(x);
            if(Math.abs(fp) < delta)
            {
                System.out.println("Small derivative.");
                return;
            }

            d = fx/fp;
            x = x - d;
            fx = g(x);
            System.out.println("n = " + n + " x: " + x + " f(x): " + fx);

            if(n == 99)
            {
                System.out.println("Slowly converges. Maximum iterations reached.");
            }

            if(Math.abs(d) < epsilon)
            {
                System.out.println("Convergence.");
                return;
            }
        }
    }

    private void secant(double a, double b)
    {
        int n;
        int nmax = 100;
        double epsilon = 0.01;
        double fa, fb, d;

        fa = f(a);
        fb = f(b);

        if(Math.abs(fa) > Math.abs(fb))
        {
            double temp = a;
            a = b;
            b = temp;

            temp = fa;
            fa = fb;
            fb = temp;
        }
        System.out.println("n = 0" + " a: " + a + " f(a): " + fa);
        System.out.println("n = 1" + " b: " + b + " f(b): " + fb);

        for(n = 2; n < nmax; n++)
        {
            if(Math.abs(fa) > Math.abs(fb))
            {
                double temp = a;
                a = b;
                b = temp;

                temp = fa;
                fa = fb;
                fb = temp;
            }

            d = (b - a) / (fb - fa);
            b = a;
            fb = fa;
            d = d * fa;

            if(Math.abs(d) < epsilon)
            {
                System.out.println("Convergence.");
                return;
            }

            a = a - d;
            fa = f(a);
            System.out.println("n = " + n + " a: " + a + " f(a): " + fa);

            if(n == 99)
            {
                System.out.println("Slowly converges. Maximum iterations reached.");
            }
        }
    }

    private void secant2(double a, double b)
    {
        int n;
        int nmax = 100;
        double epsilon = 0.01;
        double fa, fb, d;

        fa = g(a);
        fb = g(b);

        if(Math.abs(fa) > Math.abs(fb))
        {
            double temp = a;
            a = b;
            b = temp;

            temp = fa;
            fa = fb;
            fb = temp;
        }
        System.out.println("n = 0" + " a: " + a + " f(a): " + fa);
        System.out.println("n = 1" + " b: " + b + " f(b): " + fb);

        for(n = 2; n < nmax; n++)
        {
            if(Math.abs(fa) > Math.abs(fb))
            {
                double temp = a;
                a = b;
                b = temp;

                temp = fa;
                fa = fb;
                fb = temp;
            }

            d = (b - a) / (fb - fa);
            b = a;
            fb = fa;
            d = d * fa;

            if(Math.abs(d) < epsilon)
            {
                System.out.println("Convergence.");
                return;
            }

            a = a - d;
            fa = g(a);
            System.out.println("n = " + n + " a: " + a + " f(a): " + fa);

            if(n == 99)
            {
                System.out.println("Slowly converges. Maximum iterations reached.");
            }
        }
    }
 
 }