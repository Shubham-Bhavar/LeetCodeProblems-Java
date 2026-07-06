// Problem:
// Given an array gain where gain[i] represents the net altitude change 
// between point i and i+1, starting from altitude 0,
// return the highest altitude reached.

class Solution {
    public int largestAltitude(int[] gain) {
        
        int currentAltitude = 0;  // Starting altitude
        int maxAltitude = 0;      // Stores highest altitude reached

        // Traverse through gain array
        for (int i = 0; i < gain.length; i++) {
            
            // Update current altitude
            currentAltitude += gain[i];

            // Update maximum altitude if needed
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }

        // Return highest altitude reached
        return maxAltitude;
    }
}
