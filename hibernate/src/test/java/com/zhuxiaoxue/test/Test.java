package com.zhuxiaoxue.test;

import java.util.*;

public class Test {

    public static void sort(char[] ca){
        List list = new ArrayList();
        for(int i=0; i<ca.length; i++) {
            list.add(String.valueOf(ca[i]));
        }
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2){
                int result = 0;
                String s1 = o1.toString().toLowerCase();
                String s2 = o2.toString().toLowerCase();
                if(s1.equals(s2)){
                    result = o1.toString().compareTo(o2.toString());
                } else{
                    result = s1.compareTo(s2);
                }
                return result;
            }
        });
        for(int i=0; i<ca.length; i++) {
            ca[i] = (list.get(i).toString()).charAt(0);
        }
    }

    @org.junit.Test
    public void testOrder(){

        char[] ca = new char[]{'a','A','b','B','c','C'};
        sort(ca);
        for(int i=0; i<ca.length; i++) {
            System.out.print(ca[i]);
            if(i<ca.length-1) {
                System.out.print(", ");
            }
        }

    }


    public static void main(String args[]){
        String a[]={"a","A","h","f","H","F"};
        Comparator	c=new Comparator(){
            public int compare(Object el1, Object el2){
                String key1=el1.toString().toLowerCase()
                        +"_"+el1.toString();
                String key2=el2.toString().toLowerCase()
                        +"_"+el2.toString();

                return key1.compareTo(key2);
            }
        };
        Arrays.sort(a, c);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }


    @org.junit.Test
    public void testTable(){

        for(int i = 1;i <= 9;i++){
            for(int j = 1;j<=9; j++){
                if(i >= j){
                    System.out.print(i +"*"+j + "=" + i*j +" ");
                }
            }
            System.out.println("");
        }

    }


}
