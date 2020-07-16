package leetcode.medium.wordSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
 * 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。
 * 你可以按任意顺序以列表形式返回 A 中所有的通用单词。
 * 示例 1：
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * 输出：["facebook","google","leetcode"]
 * 示例 2：
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * 输出：["apple","google","leetcode"]
 * 示例 3：
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * 输出：["facebook","google"]
 * 示例 4：
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * 输出：["google","leetcode"]
 * 示例 5：
 * 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * 输出：["facebook","leetcode"]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordSubsets {
    public static List<String> wordSubsets(String[] A, String[] B) {
        List<String> alA = new ArrayList<String>(Arrays.asList(A));
        List<String> alB = new ArrayList<String>(Arrays.asList(B));
        List<String> answerStr = new ArrayList<>();
        Set setB = new HashSet();
        for (String strBEle : alB) {
            char[] tempB = strBEle.toCharArray();
            for (char charBEle : tempB) {
                setB.add(charBEle);
            }
        }

        for (String strAEle : A) {
            boolean generalWorldFlag = true;
            for (Iterator it = setB.iterator(); it.hasNext(); ) {
                String tempEle = it.next().toString();
                System.out.println("value=" + tempEle);
                if (!strAEle.contains(tempEle)) {
                    generalWorldFlag = false;
                    break;
                }
            }
            if(generalWorldFlag){
                answerStr.add(strAEle);
            }
        }
        return answerStr;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = new String[]{"ec", "oc", "ceo"};
        List<String> ans = wordSubsets(A, B);
        System.out.println(ans.toString());
    }
}
