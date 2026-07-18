class Solve
  {
    public int Arr(int[] nums)//Read Array Elements
    {
      int k=1;//at 0 index position means first element is always unique
      for(int i=1;i<nums.length;i++)//traverse array elements 1 by 1
        {
          if(nums[i]!=nums[i-1])//check if index of i element is not equals to i-1
          {
            nums[k]=nums[i];//if condition true assign index of k element value to index of i element value  
            k++;//unique element found so we increase k value
          }
        }
      return k;//return unique elements
    }
  }
