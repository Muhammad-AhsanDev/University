import java.util.HashMap;

public class hashmap{
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("karachi",23499);
         map.put("Islamabad",5000);
         System.out.println(map.get("Islamabad"));

         
         if(map.containsKey("karachi")){
            System.out.println(map.containsKey("karachi"));

         }
         if(map.containsValue(23499)){
            System.out.println("Yes it does");
    
        }
        System.out.println(map.size());
        System.out.println(map.isEmpty());
       System.out.println(map.keySet());
       System.out.println(map.values());
       System.out.println(map.entrySet());
       WhatWHATAHWTAHAWTHAHAWTHAWTs
       
    }

}