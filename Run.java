package offer66;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Run {


    public static void main(String[] args) {

        /*//Solution01_FindFrom2DArray
        int array[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 9;
        System.out.println(new Solution01_FindFrom2DArray().Find(target,array));*/

        /*//Solution02_ReplaceSpace
        StringBuffer str = new StringBuffer("We are happy");
        System.out.println(new Solution02_ReplaceSpace().replaceSpace(str));*/

        /*//Solution05_QueueWithStack
        Solution05_QueueWithStack test = new Solution05_QueueWithStack();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        test.push(6);
        test.push(7);
        test.push(8);
        System.out.println(test.pop());*/


        /*Solution06_RotateMinNumberOfArray test = new Solution06_RotateMinNumberOfArray();
        int [] array = {3,4,5,6,7,1,2};
        System.out.println(test.minNumberInRotateArray(array));*/

        /*Solution07_Fibonacci test = new Solution07_Fibonacci();
        System.out.println(test.Fibonacci(7));*/

        /*Solution08_JumpStep test = new Solution08_JumpStep();
        System.out.println(test.JumpFloor(3));
        System.out.println(test.JumpFloor(4));*/

      /*  Solution11_NumOf1InBinary test = new Solution11_NumOf1InBinary();
        System.out.println(test.NumberOf1(9));
        System.out.println(test.NumberOf1(4));*/

//        Solution12_BaseExponent test = new Solution12_BaseExponent();
//        System.out.println(test.Power(2,-5));

        /*Solution13_OddBeforeEven test = new Solution13_OddBeforeEven();
        int [] array = {1,2,3,4,5};
        test.reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/

        /*Solution14_ReciprocalKNodeInLinkList test = new Solution14_ReciprocalKNodeInLinkList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode listNode = test.FindKthToTail(n1, 3);
        System.out.println(listNode.val);*/

        /*Solution15_InverseLinkList test = new Solution15_InverseLinkList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode listNode = test.ReverseList(n1);
        System.out.println(listNode.next.val);*/

        /*Solution21_SequenceOfPushPopStack test = new Solution21_SequenceOfPushPopStack();
        int [] pushA = {1,2,3,4,5};
        int [] popA ={4,3,5,1,2};
        System.out.println(test.IsPopOrder(pushA, popA));*/

        /*Solution22_PrintBTFromUpToDown test = new Solution22_PrintBTFromUpToDown();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        ArrayList<Integer> list = test.PrintFromTopToBottom(null);
        System.out.println(list);*/

        /*Solution23_BSTPostOrderSequence test = new Solution23_BSTPostOrderSequence();
        int [] sequence = {5,7,6,9,11,10,8};
        System.out.println(test.VerifySquenceOfBST(null));*/

        /*Solution24_FindSumPathInBT test = new Solution24_FindSumPathInBT();
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t12 = new TreeNode(12);
        t10.left = t5;
        t10.right = t12;
        t5.left = t4;
        t5.right = t7;

        ArrayList<ArrayList<Integer>> lists = test.FindPath(t10, 22);
        System.out.println(lists);*/

   /*     ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>path=new ArrayList<Integer>();
        path.add(10);
        path.add(5);
        path.add(7);
        result.add(new ArrayList(path));
        System.out.println(result);
        path.remove(path.size()-1);
        System.out.println(result);
        path.remove(path.size()-1);
        path.add(12);
        System.out.println(result);
        result.add(new ArrayList(path));
        System.out.println(result);*/

        /*ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>path2=new ArrayList<Integer>();
        path2.add(10);
        path2.add(5);
        result.add(new ArrayList(path2));
        ArrayList<Integer>path=new ArrayList<Integer>();
        path.add(10);
        path.add(5);
        path.add(7);
        result.add(new ArrayList(path));
        ArrayList<Integer>path1=new ArrayList<Integer>();
        path1.add(10);
        path1.add(5);
        path1.add(7);
        path1.add(6);
        result.add(new ArrayList(path1));
        System.out.println(result);

        Solution24_FindSumPathInBT test = new Solution24_FindSumPathInBT();
        test.order(result);
        System.out.println(result);*/

        /*ArrayList<Integer> tmp = result.get(0);
        result.set(0,result.get(1));
        result.set(1,tmp);
        System.out.println(result);*/

        /*Solution26_BSTAndDoubleLinkList test = new Solution26_BSTAndDoubleLinkList();
        TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t12 = new TreeNode(12);
        t10.left = t5;
        t10.right = t12;
        t5.left = t4;
        t5.right = t7;

        System.out.println(test.Convert(t10).val);*/

        /*Solution27_PermutationOfString test = new Solution27_PermutationOfString();
        ArrayList<String> list = test.Permutation("abb");
        System.out.println(list);*/

        /*Solution28_MoreThanHalfNumInArray test = new Solution28_MoreThanHalfNumInArray();
        int [] array = {1,2,3,2,2,2,5,4,2};
        int [] array1 = {1,2,3,2,4,2,5,2,3};
        int num = test.MoreThanHalfNum_Solution(array1);
        System.out.println(num);*/

        /*int [] data = {6,8,7,9,0,1,3,2,4,5};
        int [] data1 = {9,8,7,6,5,4,3,2,1,0};
        QuickSort test = new QuickSort();
        test.quickSort(data1);
        for (int i = 0; i < data1.length; i++) {
            System.out.print(data1[i]+" ");
        }*/

/*        Solution29_GetLeastKNumbers test = new Solution29_GetLeastKNumbers();
        int [] data = {6,8,7,9,0,1,3,2,4,5};
        ArrayList<Integer> list = test.GetLeastNumbers_Solution(data, 5);
        System.out.println(list);*/
 /*       int [] data = {3,2,4,5,1};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        maxHeap.offer(data[0]);
        maxHeap.offer(data[1]);
        maxHeap.offer(data[2]);
        maxHeap.offer(data[3]);
        maxHeap.offer(data[4]);
        System.out.println(maxHeap.poll());
        System.out.println("========");
//        maxHeap.offer(0);
        for (Integer i:maxHeap) {
            System.out.println(i);
        }*/

        /*Solution30_FindGreatestSumOfSubArray test = new Solution30_FindGreatestSumOfSubArray();
        int [] array = {1,-2,3,10,-4,7,2,-5};
        int maxSum = test.FindGreatestSumOfSubArray(array);
        System.out.println(maxSum);*/

        /*Solution31_NumberOf1Between1AndN test = new Solution31_NumberOf1Between1AndN();
        System.out.println(test.NumberOf1Between1AndN_Solution(0));*/

        /*Solution32_ArrangeArrayToMinNumber test = new Solution32_ArrangeArrayToMinNumber();
        int [] numbers= {3,32,321};
        System.out.println(test.PrintMinNumber(numbers));*/

        /*Solution33_UglyNumber test = new Solution33_UglyNumber();
        System.out.println(test.GetUglyNumber_Solution(12));*/

        /*Solution34_FirstNotRepeatingChar test = new Solution34_FirstNotRepeatingChar();
        System.out.println(test.FirstNotRepeatingChar("google"));*/

        /*int [] a = {9,8,7,6,5,4,3,2,1};
        int [] b = {1,2,3,4,5,6,7,0};
        Solution35_InversePairs test = new Solution35_InversePairs();
        int pairs = test.InversePairs(a);
        System.out.println(pairs);*/

        /*int [] b = {1,2,3,4,5,5,5,5,6,7};
        Solution37_GetNumberOfKInSortedArray test = new Solution37_GetNumberOfKInSortedArray();
        System.out.println(test.GetNumberOfK(b, 0));*/

        /*Solution42_FindNumbersWithSum test = new Solution42_FindNumbersWithSum();
        int [] array = {1,2,4,7,8,11,13,15};
        System.out.println(test.FindNumbersWithSum(array, 15));*/

//        Solution41_FindContinuousSequenceSumEqualS test = new Solution41_FindContinuousSequenceSumEqualS();
//        System.out.println(test.FindContinuousSequence(15));
/*        String str = "  123  ";
        String str1 = str.trim();
        System.out.println(str);*/

        /*Solution44_ReverseSentence test = new Solution44_ReverseSentence();
        System.out.println(test.ReverseSentence("I am a student."));*/

        /*Solution43_LeftRotateString test = new Solution43_LeftRotateString();
        String str = "abcXYZdef";
        System.out.println(test.LeftRotateString(str, 3));*/

        /*Solution45_CardsOrder test = new Solution45_CardsOrder();
        int [] numbers = {0,1,3,4,5};
        System.out.println(test.isContinuous(numbers));*/

/*        Solution46_LastRemainingInCircle test = new Solution46_LastRemainingInCircle();
        System.out.println(test.LastRemaining_Solution(5, 3));*/
        /*Solution47_Sum1_n test =new Solution47_Sum1_n();
        System.out.println(test.Sum_Solution(5));*/

        /*Solution48_AddWithoutAddSubMulDiv test = new Solution48_AddWithoutAddSubMulDiv();
        System.out.println(test.Add(5,17));*/

        /*Solution49_StrToInt test = new Solution49_StrToInt();
        System.out.println(test.StrToInt("-2147483649"));*/

        /*Solution52_RegexMatch test = new Solution52_RegexMatch();
        String str1 = "a";
        String str2 = "ab*";
        System.out.println(test.match(str1.toCharArray(), str2.toCharArray()));*/

        /*Solution53_isNumeric test = new Solution53_isNumeric();
        char[]str = "100".toCharArray();
        System.out.println(test.isNumeric(str));*/

    /*    Solution54_FirstNotRepeatCharInStream test = new Solution54_FirstNotRepeatCharInStream();
        test.Insert('g');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('o');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('o');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('g');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('l');
        System.out.println(test.FirstAppearingOnce());
        test.Insert('e');
        System.out.println(test.FirstAppearingOnce());*/


/*        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        Solution56_DeleteDuplicationNodeInLinkedList test= new Solution56_DeleteDuplicationNodeInLinkedList();
        ListNode listNode = test.deleteDuplication(n0);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);*/
//        System.out.println(listNode.next.next.val);

//        Solution59_PrintBTWithZ test = new Solution59_PrintBTWithZ();
//        Solution60_PrintBTAsMulLines test = new Solution60_PrintBTAsMulLines();
/*        Solution62_KthNodeInBST test = new Solution62_KthNodeInBST();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(test.KthNode(t1, 3).val);*/


        Solution63_MeidanInDataFlow test = new Solution63_MeidanInDataFlow();
        //[5,2,3,4,1,6,7,0,8]
        test.Insert(5);
        System.out.println(test.GetMedian());
        test.Insert(2);
        System.out.println(test.GetMedian());
        test.Insert(3);
        System.out.println(test.GetMedian());
        test.Insert(4);
        System.out.println(test.GetMedian());

    }
}

