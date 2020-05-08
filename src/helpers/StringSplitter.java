package helpers;

public class StringSplitter {

	public static String[] splitByChar(String str) {
		String[] stringArr = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			stringArr[i] = Character.toString(str.charAt(i));
		}
		return stringArr;
	}
}
