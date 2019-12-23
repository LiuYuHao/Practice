/*
Task:given a IPv4 address, convert the . into [.]
Input: a string which contains valid IPv4 address
Output: a string after the convertion.
*/
class Solution {
    public String defangIPaddr(String address) {
        String result = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.') {
                result += address.charAt(i);
            }
            else {
                result += "[";
                result += address.charAt(i);
                result += "]";
            }
        }
        return result;
    }
}
