import java.util.*;

public class Find_Permutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while (tests-- > 0) {
			String str = sc.next();
			int num = 1;
			Stack<Integer> s = new Stack<>();
			s.push(num);
			List<Integer> res = new ArrayList<>();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'I') {
					while (!s.isEmpty()) {
						res.add(s.peek());
						s.pop();
					}
					s.push(++num);
				} else {
					s.push(++num);
				}
			}
			while (!s.isEmpty()) {
				res.add(s.pop());
			}
			for (int i : res) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
