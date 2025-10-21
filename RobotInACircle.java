// This solution uses a logic where in after an iteration, if we reach at any position with same direction (other than zero index), we can consider we can never reach back the zero position
// For this we iterate over the grid based off of a directions array and moving based on index which is associated by each direction
class Solution {
    public boolean isRobotBounded(String instructions) {
        int index = 0, x=0, y=0;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        for(int i=0;i<instructions.length();i++) {
            char c = instructions.charAt(i);
            if(c=='L') {
                index--;
                if(index<0) {
                    index=3;
                }
            } else if(c=='R') {
                index++;
                if(index>dirs.length-1) {
                    index=0;
                }
            } else {
                int[] currDir = dirs[index];
                x=x+currDir[0];
                y=y+currDir[1];
            }
        }

        return index!=0 || (x==0 && y==0);
    }
}
