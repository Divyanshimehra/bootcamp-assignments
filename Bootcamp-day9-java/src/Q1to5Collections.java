/*
Q1. What is the Java Collections Framework? Explain its advantages.

The Java Collection Framework is a set of classes and interfaces that provide
ready-made data structures to store and manipulate groups of objects efficiently.

Java provides built-in collection classes like List, Set, Map and Queue.

The collection Framework improves productivity by making code more reusable,
maintainable and faster to develop.

Advantages of Collection
1. Reusability : Ready-to-use data structures.
2. Type Safety (Generics) : Compile-time checking.
3. Performance Optimization : Well-tuned and efficient implementations.
4. Reduced Development Time : No need to build data structures from scratch.
5. Inter-operability : Common methods across collections (e.g., add(), remove(), size()).


Q2. List the differences between Vector, ArrayList, LinkedList, and HashSet.

Key Differences
1. Underlying Data Structure: Vector and ArrayList use dynamic arrays; LinkedList uses a doubly linked list; HashSet uses a hash table (via HashMap).
2. Synchronization: Vector is synchronized; ArrayList, LinkedList, and HashSet are not synchronized by default.
3. Duplicates: Vector, ArrayList, and LinkedList allow duplicates; HashSet does not.
4. Order: Vector, ArrayList, and LinkedList maintain insertion order; HashSet does not.

 */

import java.util.*;

//Q3. Find the First Non-Repeating Character
class FirstNonRepeatingChar{
    void findChar(String input){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : input.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                System.out.println("First Non-Repeating Character: " + entry.getKey());
                return;
            }
        }
        System.out.println("No Non-Repeating Character found.");
    }
}

//Q4. Given an array of integers and a target sum, return the indices of the two numbers that add up to the target
class TwoSum{
    void findTwoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int value = target - nums[i];
            if(map.containsKey(value)){
                System.out.println("Indices: "+ map.get(value) + " and " + i);
                return;
            }
            map.put(nums[i], i);
        }
        System.out.println("No pair found");
    }
}

//5. You are given two sorted ArrayLists<Integer>. Merge them into a single sorted list.
class MergeSortedList{
    void mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        Collections.sort(merged);
        System.out.println("Merged Sorted List: "+merged);
    }
}

public class Q1to5Collections {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Finding the First Non-Repeating Character");
        System.out.print("Enter a word: ");
        String input = sc.nextLine();
        new FirstNonRepeatingChar().findChar(input);

        System.out.println("\nTwo Sum finding indices");
        int[] nums = {1,2,3,4,6,7};
        int target = 6;
        new TwoSum().findTwoSum(nums, target);

        System.out.println("\nMerge Sorted List");
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,5,7,2));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2,6,7,4));
        System.out.println("List1: "+ list1);
        System.out.println("List2: "+list2);
        new MergeSortedList().mergeLists(list1, list2);
    }


}
