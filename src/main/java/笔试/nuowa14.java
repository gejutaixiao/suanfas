package 笔试;

public class nuowa14 {


    public void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int Index = partsort(array, left, right);
        quickSort(array, left, Index - 1);
        quickSort(array, Index + 1, right);
    }
    public int partsort(int[] array, int left, int right) {
        int Index = left;
        int ponit = array[Index];
        while (left < right) {
            while (left < right) {
                if (array[right] < ponit)
                    break;
                else
                    --right;
            }
            while (left < right) {
                if (array[left] > ponit)
                    break;
                else
                    ++left;
            }
            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
        }
        int num = array[left];
        array[left] = array[Index];
        array[Index] = num;
        return left;
    }
}
