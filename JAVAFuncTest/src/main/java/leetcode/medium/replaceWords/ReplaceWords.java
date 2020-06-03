package leetcode.medium.replaceWords;

import leetcode.Util.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 *  
 *
 * 示例：
 *
 * 输入：dict(词典) = ["cat", "bat", "rat"] sentence(句子) = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 */
public class ReplaceWords {

    public String myReplaceWords(List<String> dict, String sentence) {
        if(null == dict || dict.size() < 1 || null == sentence || sentence.length() < 1) {
            return null;
        }
        // 0.对这个dic按照字符串的长度进行排序
        Collections.sort(dict, new MyComparator());

        // 1.按照空格拆分为字符串数组
        ArrayList<String> sentenceArrList = new ArrayList<>();
        String[] sentenceList = sentence.split(" ");
        Collections.addAll(sentenceArrList, sentenceList);
        System.out.println(sentenceArrList.toString());
        // 2.遍历数组中的每一个单词
        for(String strEle : sentenceArrList){

        }


        return null;
    }

    public static void main(String[] args){
        ReplaceWords replaceWords = new ReplaceWords();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String res = replaceWords.myReplaceWords(dict, sentence);
        System.out.println(res);
    }


}
