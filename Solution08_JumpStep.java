package offer66;

public class Solution08_JumpStep {
    public int JumpFloor(int target) {
        if(target < 0)
            return 0;
        if(target == 0 || target == 1 || target == 2)
            return target;
        int a = 1;
        int b = 2;
        int tmp;
        for(int i = 3;i <= target;i++){
            tmp = a;
            a = b;
            b = tmp + b;
        }
        return b;
    }
}
