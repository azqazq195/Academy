package ���α׷��ӽ�;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_�ٸ���_������_Ʈ��_Level2 {
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
        // Ʈ�� ����
        int trucks = truck_weights.length;
        // Ʈ�� ����ð�
        Queue<Integer> truckTime = new LinkedList<Integer>();
        // ���� �ٸ��� Ʈ�� ����
        int onBridge = 0;
        // Ʈ�� ī��Ʈ
        int inputCount = 0;
        int outputCount = 0;
        
        while(outputCount != trucks) {
        	// ����˻�
        	if(inputCount < trucks) {
        		if(onBridge + truck_weights[inputCount] <= weight) {
            		onBridge += truck_weights[inputCount];
            		inputCount++;
            		truckTime.add(time + bridge_length);
            	} else {
            	}
        	}
        	time++;
        	// ����˻�
        	if(truckTime.peek()==time) {
        		truckTime.poll();
        		onBridge -= truck_weights[outputCount];
        		outputCount++;
        	}
        }
        return time;
    }
}
