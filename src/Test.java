import java.nio.ByteBuffer;


public class Test {
	public static void main(String[] args) {
		int a = 34567;
		byte[] b = new byte[4];
		b[0] = (byte) (a >> 24);
		b[1] = (byte) (a >> 16);
		b[2] = (byte) (a >> 8);
		b[3] = (byte) (a >> 0);
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		System.out.println(b[3]);
						
	}
}