package idwall.desafio.string;

public abstract class StringFormatter {

	private Integer limit;

	public StringFormatter() {
		this.limit = 40;
	}

	/**
	 * It receives a text and should return it formatted
	 *
	 * @param text
	 * @param limit
	 * @return
	 */
	public abstract String format(String text, int limit);

}
