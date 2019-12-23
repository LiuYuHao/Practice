/*
Task: finding the self dividing numbers between range, self dividing number is the number that is able divided his own digits
Input: two int left and right
Output: a int list
*/
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> l = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean check = true;
            if (i < 10) {
                l.add(i);
            }
            else {
                int hold = i;
                while (hold != 0) {
                    int r = hold % 10;
                    if (r == 0) {
                        check = false;
                        break;
                    }
                    hold = hold / 10;
                    if (i % r != 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    l.add(i);
                }
            }
        }
        return l;
    }
}
