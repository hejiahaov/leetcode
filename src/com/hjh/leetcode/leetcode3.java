package com.hjh.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hejiahao
 * @version 1.0
 * @date 2019/10/16 11:25
 * @projct_name leetcode
 */
public class leetcode3 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String s2 = "aab"; //1
        String s3 = " "; //0
        String s = "pwwdewndiewkew"; //ndiewk
        String s1 = "pwwkew";
        leetcode3 l = new leetcode3();
//        int i = l.lengthOfLongestSubstring(s);
//        int i1 = l.lengthOfLongestSubstring(s1);
        int i2 = l.lengthOfLongestSubstring(s2);
        int i3 = l.lengthOfLongestSubstring(s3);
        System.out.println(i2+"====="+i3);
    }

    public int lengthOfLongestSubstring(String s) {
        String str = "";
        int longest = 0;
        for (int i = 0; i<s.length(); i++){
            int i1 = str.indexOf(s.charAt(i));
            if(i1 != -1){
                if(longest < str.length()){
                    longest = str.length();
                }
                str += s.charAt(i);
                str = str.substring(i1+1);
            }else {
                str += s.charAt(i);
                if(longest < str.length()){
                    longest = str.length();
                }
            }
        }
        return longest;
    }

    //大神解题思路
    public int lengthOfLongestSubstring1(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = left; j < i; j++) {
                if (arr[i] == arr[j]) {
                    res = Math.max(res, i - left);
                    left = j + 1;
                    break;
                }
            }
        }
        return Math.max(res, arr.length - left);
    }
}
