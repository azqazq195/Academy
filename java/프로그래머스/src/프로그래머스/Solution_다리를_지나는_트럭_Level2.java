package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를_지나는_트럭_Level2 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10};
		
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
//		System.out.println("bridge_length : " + bridge_length);
//		System.out.println("weight : " + weight);
//		System.out.println("truck_weights[0] : " + truck_weights[0]);
//		System.out.println();
		
		solution(bridge_length, weight, truck_weights);
	}
	// return 8
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        // 트럭 개수
        int trucks = truck_weights.length;
        // 트럭 입장시간
        Queue<Integer> truckTime = new LinkedList<Integer>();
        // 현재 다리위 트럭 무게
        int onBridge = 0;
        // 트럭 카운트
        int inputCount = 0;
        int outputCount = 0;
        
        while(outputCount != trucks) {
        	// 입장검사
        	if(inputCount < trucks) {
        		if(onBridge + truck_weights[inputCount] <= weight) {
            		onBridge += truck_weights[inputCount];
            		inputCount++;
            		truckTime.add(time + bridge_length);
            	} else {
            	}
        	}
        	time++;
        	// 퇴장검사
        	if(truckTime.peek()==time) {
        		truckTime.poll();
        		onBridge -= truck_weights[outputCount];
        		outputCount++;
        	}
        }
        return time;
    }
}
