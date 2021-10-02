import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static int N,K;
	static HashMap<Line, Integer> lines = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		K=sc.nextInt();
		
		for (int i=0;i<N;i++) {
			
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			
			if (checkPoint(x,y)) {
				System.out.print(i+1);
				return;
			}
		}
	}

	private static boolean checkPoint(int x,int y) {
		// TODO Auto-generated method stub
		Line line = new Line(0,y,0); // horizontal line
		if (addLine(line)) {
			return true;
		}
		
		line = new Line(x,0,2); // vertical line
		if (addLine(line)) {
			return true;
		}
		
		
		return false;
	}

	private static boolean addLine(Line line) {
		// TODO Auto-generated method stub
		if (lines.containsKey(line)) {
			int pts = lines.get(line);
			pts++;
			if (pts>=K) {
				return true;
			}
			lines.put(line,pts);
			
		} else {
			lines.put(line, 1);
		}
		
		return false;
	}

}

class Line {
	
	int startx,starty;
	int direction;
	
	public Line(int x, int y, int dir) {
		this.startx= x;
		this.starty= y;
		this.direction = dir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + direction;
		result = prime * result + startx;
		result = prime * result + starty;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (direction != other.direction)
			return false;
		if (startx != other.startx)
			return false;
		if (starty != other.starty)
			return false;
		return true;
	}

	
	
	
}