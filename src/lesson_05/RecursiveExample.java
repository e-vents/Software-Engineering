package lesson_05;

public class RecursiveExample {

	public static void main(String[] args) {
		System.out.println(triangle(100));
		int[] ints = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		reverse(0,ints);
	}
	
	public static int triangle(int n) {
		if(n == 1) return 1;
		else
			return n+triangle(n-1);
	}
	
	public static void reverse(int pos, int[]values) {
		if(pos >= values.length/2); //basecase
		else {
			int tmp = values[pos];
			values[pos] = values[(values.length-1)-pos];
			values[values.length-1-pos] = tmp;
			reverse(pos++, values);
		}
	}
	public static int GCD(int x, int y) {
		if(y == 0) return x;
		else {
			int z = x%y;
			return GCD(y, z);
		}
	}
}
