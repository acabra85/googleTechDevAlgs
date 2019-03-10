package com.acabra.gtechdevalgs.litcode.arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreakTest {

    WordBreak wb;

    @Before
    public void init() {
        wb = new WordBreak();
    }

    @After
    public void tearDown() {
        wb = null;
    }

    //TRUE
    @Test
    public void should_return_true_test_1() {
        String s = "hellohelloworld";
        String[] strings = {"hello", "world"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertTrue(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict)
        );
    }

    @Test
    public void should_return_true_test_2() {
        String s = "aaaaaaa";
        String[] strings = {"aaaa", "aaa"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertTrue(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }

    @Test
    public void should_return_true_test_3() {
        String s = "appotato";
        String[] strings = {"ap", "app", "potato"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertTrue(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }

    @Test
    public void should_return_true_test_4() {
        String s = "catsandog";
        String[] strings = {"cat", "cats", "sand", "an", "and", "dog", "dogs"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertTrue(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }

    @Test
    public void should_return_true_test_5() {
        String s = "appled";
        String[] strings = {"ap", "app", "led"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertTrue(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }

    @Test
    public void should_return_true_test_6() {
        String s = "aaaaaaa";
        String[] strings = {"aa", "aaa"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertTrue(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }

    @Test
    public void should_return_true_test_7() {
        String s = "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami";
        String[] strings = {"kfomka","hecagbngambii","anobmnikj","c","nnkmfelneemfgcl","ah","bgomgohl","lcbjbg","ebjfoiddndih","hjknoamjbfhckb","eioldlijmmla","nbekmcnakif","fgahmihodolmhbi","gnjfe","hk","b","jbfgm","ecojceoaejkkoed","cemodhmbcmgl","j","gdcnjj","kolaijoicbc","liibjjcini","lmbenj","eklingemgdjncaa","m","hkh","fblb","fk","nnfkfanaga","eldjml","iejn","gbmjfdooeeko","jafogijka","ngnfggojmhclkjd","bfagnfclg","imkeobcdidiifbm","ogeo","gicjog","cjnibenelm","ogoloc","edciifkaff","kbeeg","nebn","jdd","aeojhclmdn","dilbhl","dkk","bgmck","ohgkefkadonafg","labem","fheoglj","gkcanacfjfhogjc","eglkcddd","lelelihakeh","hhjijfiodfi","enehbibnhfjd","gkm","ggj","ag","hhhjogk","lllicdhihn","goakjjnk","lhbn","fhheedadamlnedh","bin","cl","ggjljjjf","fdcdaobhlhgj","nijlf","i","gaemagobjfc","dg","g","jhlelodgeekj","hcimohlni","fdoiohikhacgb","k","doiaigclm","bdfaoncbhfkdbjd","f","jaikbciac","cjgadmfoodmba","molokllh","gfkngeebnggo","lahd","n","ehfngoc","lejfcee","kofhmoh","cgda","de","kljnicikjeh","edomdbibhif","jehdkgmmofihdi","hifcjkloebel","gcghgbemjege","kobhhefbbb","aaikgaolhllhlm","akg","kmmikgkhnn","dnamfhaf","mjhj","ifadcgmgjaa","acnjehgkflgkd","bjj","maihjn","ojakklhl","ign","jhd","kndkhbebgh","amljjfeahcdlfdg","fnboolobch","gcclgcoaojc","kfokbbkllmcd","fec","dljma","noa","cfjie","fohhemkka","bfaldajf","nbk","kmbnjoalnhki","ccieabbnlhbjmj","nmacelialookal","hdlefnbmgklo","bfbblofk","doohocnadd","klmed","e","hkkcmbljlojkghm","jjiadlgf","ogadjhambjikce","bglghjndlk","gackokkbhj","oofohdogb","leiolllnjj","edekdnibja","gjhglilocif","ccfnfjalchc","gl","ihee","cfgccdmecem","mdmcdgjelhgk","laboglchdhbk","ajmiim","cebhalkngloae","hgohednmkahdi","ddiecjnkmgbbei","ajaengmcdlbk","kgg","ndchkjdn","heklaamafiomea","ehg","imelcifnhkae","hcgadilb","elndjcodnhcc","nkjd","gjnfkogkjeobo","eolega","lm","jddfkfbbbhia","cddmfeckheeo","bfnmaalmjdb","fbcg","ko","mojfj","kk","bbljjnnikdhg","l","calbc","mkekn","ejlhdk","hkebdiebecf","emhelbbda","mlba","ckjmih","odfacclfl","lgfjjbgookmnoe","begnkogf","gakojeblk","bfflcmdko","cfdclljcg","ho","fo","acmi","oemknmffgcio","mlkhk","kfhkndmdojhidg","ckfcibmnikn","dgoecamdliaeeoa","ocealkbbec","kbmmihb","ncikad","hi","nccjbnldneijc","hgiccigeehmdl","dlfmjhmioa","kmff","gfhkd","okiamg","ekdbamm","fc","neg","cfmo","ccgahikbbl","khhoc","elbg","cbghbacjbfm","jkagbmfgemjfg","ijceidhhajmja","imibemhdg","ja","idkfd","ndogdkjjkf","fhic","ooajkki","fdnjhh","ba","jdlnidngkfffbmi","jddjfnnjoidcnm","kghljjikbacd","idllbbn","d","mgkajbnjedeiee","fbllleanknmoomb","lom","kofjmmjm","mcdlbglonin","gcnboanh","fggii","fdkbmic","bbiln","cdjcjhonjgiagkb","kooenbeoongcle","cecnlfbaanckdkj","fejlmog","fanekdneoaammb","maojbcegdamn","bcmanmjdeabdo","amloj","adgoej","jh","fhf","cogdljlgek","o","joeiajlioggj","oncal","lbgg","elainnbffk","hbdi","femcanllndoh","ke","hmib","nagfahhljh","ibifdlfeechcbal","knec","oegfcghlgalcnno","abiefmjldmln","mlfglgni","jkofhjeb","ifjbneblfldjel","nahhcimkjhjgb","cdgkbn","nnklfbeecgedie","gmllmjbodhgllc","hogollongjo","fmoinacebll","fkngbganmh","jgdblmhlmfij","fkkdjknahamcfb","aieakdokibj","hddlcdiailhd","iajhmg","jenocgo","embdib","dghbmljjogka","bahcggjgmlf","fb","jldkcfom","mfi","kdkke","odhbl","jin","kcjmkggcmnami","kofig","bid","ohnohi","fcbojdgoaoa","dj","ifkbmbod","dhdedohlghk","nmkeakohicfdjf","ahbifnnoaldgbj","egldeibiinoac","iehfhjjjmil","bmeimi","ombngooicknel","lfdkngobmik","ifjcjkfnmgjcnmi","fmf","aoeaa","an","ffgddcjblehhggo","hijfdcchdilcl","hacbaamkhblnkk","najefebghcbkjfl","hcnnlogjfmmjcma","njgcogemlnohl","ihejh","ej","ofn","ggcklj","omah","hg","obk","giig","cklna","lihaiollfnem","ionlnlhjckf","cfdlijnmgjoebl","dloehimen","acggkacahfhkdne","iecd","gn","odgbnalk","ahfhcd","dghlag","bchfe","dldblmnbifnmlo","cffhbijal","dbddifnojfibha","mhh","cjjol","fed","bhcnf","ciiibbedklnnk","ikniooicmm","ejf","ammeennkcdgbjco","jmhmd","cek","bjbhcmda","kfjmhbf","chjmmnea","ifccifn","naedmco","iohchafbega","kjejfhbco","anlhhhhg"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertTrue(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }

    //FALSE
    @Test
    public void should_return_false_test_1() {
        String s = "hellohelloworld";
        String[] strings = {"hell", "world"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertFalse(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }

    @Test
    public void should_return_false_test_2() {
        String s = "catsandogs";
        String[] strings = {"cat", "sand", "and", "dogs"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertFalse(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }

    @Test
    public void should_return_false_test_3() {
        String s = "apie";
        String[] strings = {"ap", "pie"};
        List<String> wordDict = Arrays.asList(strings);
        Assert.assertFalse(wb.wordBreak_dynamicProgramming(s, wordDict)
                && wb.wordBreak_bfs(s, wordDict));
    }
}
