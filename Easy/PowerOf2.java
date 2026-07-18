class PowerOf2
  {
    public boolean Power(int n)
    {
      if(n<=0)
      return false;

      while(n%2==0)
        {
          n=n/2;
        }
      return n==1;
    }
  }
