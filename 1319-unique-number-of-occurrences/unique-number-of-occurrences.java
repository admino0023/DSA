class Solution {
    public boolean uniqueOccurrences(int[] arr) 
    {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr)
        {
       
          int value =  freq.getOrDefault(num, 0) + 1;
           freq.put(num,value);
        }
        for(int value : freq.values()){
          if(set.contains(value))
          {
            return false;
          }
         set.add(value);
        }
         return true;
    
    }
}
