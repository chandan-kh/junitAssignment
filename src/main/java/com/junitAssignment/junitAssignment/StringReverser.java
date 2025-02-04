package com.junitAssignment.junitAssignment;

import java.util.Stack;

public class StringReverser {
    public static String reverse(String input){
        if(input==null){
            return null;
        }

        Stack<Character> st = new Stack<>();

        for(char ch : input.toCharArray()){
            st.push(ch);
        }

        StringBuilder reversed = new StringBuilder();
        while(!st.isEmpty()){
            reversed.append(st.peek());
            st.pop();
        }

        return reversed.toString();
    }
}
