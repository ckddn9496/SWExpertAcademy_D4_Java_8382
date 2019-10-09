import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] points = sc.nextLine().split(" ");
			
			int dx = Math.abs(Integer.parseInt(points[0]) - Integer.parseInt(points[2]));
			int dy = Math.abs(Integer.parseInt(points[1]) - Integer.parseInt(points[3]));

			int min = 0;
			int diff = 0;
			if (dx > dy) {
				min = dy;
				diff = dx - dy;
			} else {
				min = dx;
				diff = dy - dx;				
			}
			int step = min*2;
			if (diff % 2 == 0) {
				step += 2*diff;
			} else {
				step += 2*diff - 1;
			}
			
			System.out.println("#"+test_case+" "+step);
	
		}
	}
}