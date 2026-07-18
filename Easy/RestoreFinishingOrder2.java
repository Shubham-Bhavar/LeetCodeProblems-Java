/*Description:
Given the race finishing order and a list of friends' IDs,
return the friends' IDs in the order they finished the race.

Approach:
- Store all friends' IDs in a HashSet.
- Traverse the order array.
- If an ID belongs to a friend, add it to the result.
- Return the result array.
  */
class Solution {
    public int[] recoverOrder(int[] order, int[] friends) 
    {
            int index=0;
            int[] s=new int[friends.length];
            for(int i=0;i<order.length;i++)
            {
                for(int j=0;j<friends.length;j++)
                {
                    if(order[i]==friends[j])
                    {
                        s[index++]=order[i];    
                    }
                }
            }   
            return s; 
    }
}
