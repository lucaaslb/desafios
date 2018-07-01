package idwall.desafio.string;

import java.util.Scanner;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 * 
 * Edit by Lucas Lacerda (@lucaaslb) on 2018-06-30 
 */

public class IdwallFormatter extends StringFormatter {

	/**
	 * Should format as described in the challenge
	 *
	 * @param text
	 * @param limit
	 * @return
	 */
	@Override
	public String format(String text, int limit) {

		StringBuffer textFormatted = new StringBuffer();
		Scanner scanMain = new Scanner(text);
		Scanner scanAux;
		
		String word = new String();
		StringBuffer line = new StringBuffer();

		while (scanMain.hasNextLine()) {
			scanAux = new Scanner(scanMain.nextLine());

			while (scanAux.hasNext()) {
				word = scanAux.next();
				if ((line.length() + word.length()) > limit) {
					textFormatted.append(line.toString().trim() +"\n");
					line.setLength(0);
					line.append(word + " ");
				} else {
					line.append(word + " ");
				}				
			}			
			textFormatted.append(line.toString().trim() + "\n");
			line.setLength(0);
			scanAux.close();
		}
		
		scanMain.close();		

		return textFormatted.toString();
	}
}
