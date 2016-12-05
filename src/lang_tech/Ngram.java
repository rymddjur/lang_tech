package lang_tech;

public class Ngram {

	public void ngram(int n, String input) {
		String[] split = input.split(" ");
		for (int i = 0; i < split.length; i++) {
			if ((i + n) <= split.length) {
				String conc = "";
				for (int j = 0; j < n; j++) {
					conc += split[i + j] + " ";
				}
				System.out.println(conc);
			}
		}
	}
}
