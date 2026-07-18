class Palindrome
  {
    public boolean isPalindrome(int x)
    {
      int original=x;
      int digit,reverse=0;
      if(x<0)
      {
        return false;
      }
      while(x!=0)
        {
          digit=x%10;
          reverse=reverse*10+digit;
          x=x/10;
        }
      return original=reverse;
    }
  }
