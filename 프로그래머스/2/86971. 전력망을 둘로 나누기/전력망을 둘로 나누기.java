import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = n;
        
        HashMap<Integer, ArrayList<Integer>> wireHashMap = new HashMap<>();
        for(int[] wire : wires) {
            ArrayList<Integer> wireListA = wireHashMap.getOrDefault(wire[0], new ArrayList<>());
            ArrayList<Integer> wireListB = wireHashMap.getOrDefault(wire[1], new ArrayList<>());
            wireListA.add(wire[1]);
            wireListB.add(wire[0]);
            wireHashMap.put(wire[0], wireListA);
            wireHashMap.put(wire[1], wireListB);
        }
        
        // 하나씩 제거
        for (Map.Entry<Integer, ArrayList<Integer>> entrySet : wireHashMap.entrySet()) {
            Integer key = entrySet.getKey();
            ArrayList<Integer> values = entrySet.getValue();
            for (int i = 0; i < values.size(); i++) {
                int value = values.get(i);
                HashMap<Integer, ArrayList<Integer>> copyWireHashMap = new HashMap<>();
                for (Map.Entry<Integer, ArrayList<Integer>> entry : wireHashMap.entrySet()) {
                    ArrayList<Integer> copyV = new ArrayList<>();
                    for (Integer v : entry.getValue()) {
                        copyV.add(v);
                    }
                    copyWireHashMap.put(entry.getKey(), copyV);
                }
                
                ArrayList<Integer> keyList = copyWireHashMap.get(key);
                keyList.remove(Integer.valueOf(value));
                copyWireHashMap.put(key, keyList);
                
                ArrayList<Integer> valueList = copyWireHashMap.get(value);
                valueList.remove(Integer.valueOf(key));
                copyWireHashMap.put(value, valueList);
                
                int diff = getDiff(copyWireHashMap);
                if (diff < minDiff) minDiff = diff;
            }
        }
        
        
//        for (Map.Entry<Integer, ArrayList<Integer>> entrySet : wireHashMap.entrySet()) {
//            System.out.print(entrySet.getKey() + " : ");
//            for (Integer value : entrySet.getValue()) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
        
        return minDiff;
    }
    
    private int getDiff(HashMap<Integer, ArrayList<Integer>> wireHashMap) {
        // 구간 계산
        HashMap<Integer, Boolean> wireVisitedHashMap = new HashMap<>();
        for (Integer key : wireHashMap.keySet()) {
            wireVisitedHashMap.put(key, false);
        }
        
        ArrayDeque<Integer> wireDeque = new ArrayDeque<>();
        int[] partition = new int[] {0, 0};
        int index = 0;
        for (Integer key : wireHashMap.keySet()) {
            if (wireVisitedHashMap.get(key)) continue;
            
            wireVisitedHashMap.put(key, true);
            partition[index]++;
            
            ArrayList<Integer> wireList = wireHashMap.get(key);
            for (Integer wire : wireList) {
                wireDeque.add(wire);
            }
            
            while (wireDeque.size() > 0) {
                Integer nextKey = wireDeque.poll();
                if (wireVisitedHashMap.get(nextKey)) continue;
                
                wireVisitedHashMap.put(nextKey, true);
                partition[index]++;
                
                ArrayList<Integer> nextWireList = wireHashMap.get(nextKey);
                for (Integer nextWire : nextWireList) {
                    wireDeque.add(nextWire);
                }
            }
            
            index++;
        }
        
//        System.out.println(partition[0]);
//        System.out.println(partition[1]);
        return Math.abs(partition[0] - partition[1]);
    }
}