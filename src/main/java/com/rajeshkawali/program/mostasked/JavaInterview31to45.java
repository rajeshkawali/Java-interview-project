package com.rajeshkawali.program.mostasked;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaInterview31to45 {
    public static void main(String[] args) {
        // 31 Longest substring without repeating characters
        String s31 = "abcabcbb";
        Map<Character,Integer> last = new HashMap<>();
        int left=0, bestStart=0, bestLength=0;
        for(int right=0;right<s31.length();right++) {
            char c=s31.charAt(right);
            if(last.containsKey(c) && last.get(c)>=left) left=last.get(c)+1;
            last.put(c,right);
            if(right-left+1>bestLength){bestLength=right-left+1;bestStart=left;}
        }
        System.out.println("31. Longest unique substring: " + s31.substring(bestStart,bestStart+bestLength) + " (length=" + bestLength + ")");

        // 32 Longest palindromic substring
        String s32="babad"; int start=0,maxLength=0;
        for(int i=0;i<s32.length();i++) for(int type=0;type<2;type++) {
            int l=i,r=i+type;
            while(l>=0 && r<s32.length() && s32.charAt(l)==s32.charAt(r)) {
                if(r-l+1>maxLength){maxLength=r-l+1;start=l;}
                l--;r++;
            }
        }
        System.out.println("32. Longest palindrome: " + s32.substring(start,start+maxLength));

        // 33 String rotation
        String a33="ABCD",b33="CDAB";
        System.out.println("33. String rotation: " + (a33.length()==b33.length() && (a33+a33).contains(b33)));

        // 34 Word frequencies
        String s34="java python java spring python java";
        Map<String,Long> freq34=Arrays.stream(s34.split("\\s+"))
            .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println("34. Word frequencies: " + freq34);

        // 35 Longest word
        String s35="Java programming interview";
        System.out.println("35. Longest word: " + Arrays.stream(s35.split("\\s+"))
            .max(Comparator.comparingInt(String::length)).orElse(""));

        // 36 Remove special characters
        String s36="Ja@va#123! Interview";
        System.out.println("36. Remove special characters: " + s36.replaceAll("[^a-zA-Z0-9 ]",""));

        // 37 Reverse without StringBuilder
        char[] a37="Java".toCharArray();
        for(int l=0,r=a37.length-1;l<r;l++,r--){char t=a37[l];a37[l]=a37[r];a37[r]=t;}
        System.out.println("37. Reverse without StringBuilder: " + new String(a37));

        // 38 Substring check
        System.out.println("38. Contains substring: " + "JavaProgramming".contains("Program"));

        // 39 Common distinct characters in second-string order
        Set<Character> first39=new HashSet<>(), common39=new LinkedHashSet<>();
        for(char c:"apple".toCharArray()) first39.add(c);
        for(char c:"plane".toCharArray()) if(first39.contains(c)) common39.add(c);
        System.out.println("39. Common characters: " + common39);

        // 40 Longest common prefix
        String[] words40={"flower","flow","flight"}; String prefix=words40[0];
        for(int i=1;i<words40.length;i++) while(!words40[i].startsWith(prefix)) prefix=prefix.substring(0,prefix.length()-1);
        System.out.println("40. Longest common prefix: " + prefix);

        // 41 Run-length encoding
        String s41="aaabbcccc";StringBuilder compressed=new StringBuilder();
        for(int i=0;i<s41.length();){char c=s41.charAt(i);int count=0;
            while(i<s41.length() && s41.charAt(i)==c){i++;count++;}
            compressed.append(c).append(count);
        }
        System.out.println("41. Compressed String: " + compressed);

        // 42 Balanced parentheses
        String s42="{[()]}";Deque<Character> stack=new ArrayDeque<>();boolean valid=true;
        for(char c:s42.toCharArray()){
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else if(c==')'||c=='}'||c==']'){
                if(stack.isEmpty()){valid=false;break;}
                char open=stack.pop();
                if((c==')'&&open!='(')||(c=='}'&&open!='{')||(c==']'&&open!='[')){valid=false;break;}
            }
        }
        System.out.println("42. Balanced parentheses: " + (valid&&stack.isEmpty()));

        // 43 Uppercase without built-in method (ASCII)
        char[] a43="java interview".toCharArray();
        for(int i=0;i<a43.length;i++) if(a43[i]>='a'&&a43[i]<='z') a43[i]=(char)(a43[i]-32);
        System.out.println("43. Uppercase without built-in: " + new String(a43));

        // 44 Duplicate words
        List<String> duplicates44=freq34.entrySet().stream().filter(e->e.getValue()>1)
            .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("44. Duplicate words: " + duplicates44);

        // 45 Group anagrams
        String[] words45={"eat","tea","tan","ate","nat","bat"};
        Map<String,List<String>> groups=new LinkedHashMap<>();
        for(String word:words45){char[] chars=word.toCharArray();Arrays.sort(chars);
            groups.computeIfAbsent(new String(chars),k->new ArrayList<>()).add(word);
        }
        System.out.println("45. Anagram groups: " + new ArrayList<>(groups.values()));
    }
}
