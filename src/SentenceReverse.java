
public class SentenceReverse {
	
	public static void main(String[] args) {
		SentenceReverse sr = new SentenceReverse();
		String str = "monil shah";
		StringBuilder sb = new StringBuilder();
		String[] wordArray = str.split(" ");
		for (int i=0; i < wordArray.length; i++) {
			sb.append(sr.reverse(wordArray[i]));
			if (i != wordArray.length - 1)
				sb.append(" ");
		}
		System.out.println(sb);
	}
	
	
	public String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i=s.length()-1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
