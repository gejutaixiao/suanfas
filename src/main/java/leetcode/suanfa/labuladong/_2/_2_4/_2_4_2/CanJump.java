package leetcode.suanfa.labuladong._2._2_4._2_4_2;

public class CanJump {

    //跳跃游戏Ⅰ

    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i = 0; i < nums.length; i++) {
            //不断计算能跳到的最远距离
            farthest = Math.max(i + nums[i], farthest);
            //可能是碰到了0，卡住跳不动了
            if(farthest <= i) {
                return false;
            }
        }
        return farthest >= nums.length - 1;
    }
}
