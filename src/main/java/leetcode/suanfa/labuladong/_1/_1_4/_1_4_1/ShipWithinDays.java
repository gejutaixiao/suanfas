package leetcode.suanfa.labuladong._1._1_4._1_4_1;

public class ShipWithinDays {

    //在D天内送达包裹的能力
    /**
     * 要在 D 天内运输完所有货物，货物不可分割，如何确定运输的最小载重呢
     */

    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights), right = getSums(weights) + 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canFinish(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public int getMax(int[] weights) {
        int max = 0;
        for(int n : weights) {
            max = Math.max(max, n);
        }
        return max;
    }
    public int getSums(int[] weights) {
        int sum = 0;
        for(int n : weights) {
            sum += n;
        }
        return sum;
    }
    public boolean canFinish(int[] weights, int cap, int D) {
        int i = 0;
        for(int k = 0; k < D; k++) {
            int maxCap = cap;
            while((maxCap -= weights[i]) >= 0) {
                i++;
                if(i == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
