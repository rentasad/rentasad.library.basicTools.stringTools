package rentasad.library.basicTools;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The StringTool class provides a collection of utility methods for
 * manipulating and converting strings.
 */
public class StringTool
{
	/**
	 * For String to HEX Conversions
	 */
	public final static char[] HEX_CHAR_ARRAY = "0123456789ABCDEF".toCharArray();

	/**
	 * Suchen und Ersetzen es wird nach dem Key gesucht und durch das Value des
	 * HASHMAPs ersetzt
	 * <p>
	 * ACHTUNG: Diese Funktion ist speziell angepasst: Er ändert den Suchbegriff
	 * "key" durch #KEY{@link #clone()}, bevor er danach sucht.
	 *
	 * @param hashMap
	 * @param toReplaceString -
	 *                        Der String, in dem die Ersetzunen durchgeführt werden sollen.
	 * @return
	 */
	public static String stringReplacer(HashMap<String, String> hashMap, String toReplaceString)
	{
		Set<String> keySet = hashMap.keySet();
		String[] contentSiteKeyStringArray = keySet.toArray(new String[0]);
		for (int i = 0; i < contentSiteKeyStringArray.length; i++)
		{
			String key = contentSiteKeyStringArray[i];
			String searchString = "#" + key.toUpperCase() + "#";
			String replaceValue = hashMap.get(key);
			if (replaceValue != null)
			{
				toReplaceString = toReplaceString.replaceAll(searchString, replaceValue);
			}
			else
			{
				toReplaceString = toReplaceString.replaceAll(searchString, "");

			}

		}
		return toReplaceString;
	}

	/**
	 * Description: Entfernt ungültige Zeichen aus einem String und erzeugt daraus einen
	 * gültigen Verwendungszweck für Zahlungen
	 *
	 * @param string valueString which needed to convert
	 * @return Creation: 25.08.2015 by mst
	 */
	public static String escapeStringToHtml(final String valueString) {
		String returnString = "";
		if (valueString != null) {
			returnString = valueString.replace("\u00C4", "&Auml;"); // Ä
			returnString = valueString.replace("\u00E4", "&auml;"); // ä
			returnString = valueString.replace("\u00CB", "&Euml;"); // Ë
			returnString = valueString.replace("\u00EB", "&euml;"); // ë
			returnString = valueString.replace("\u00CF", "&Iuml;"); // Ï
			returnString = valueString.replace("\u00EF", "&iuml;"); // ï
			returnString = valueString.replace("\u00D6", "&Ouml;"); // Ö
			returnString = valueString.replace("\u00F6", "&ouml;"); // ö
			returnString = valueString.replace("\u00DC", "&Uuml;"); // Ü
			returnString = valueString.replace("\u00FC", "&uuml;"); // ü
			returnString = valueString.replace("\u0178", "&Yuml;"); // Ÿ
			returnString = valueString.replace("\u00FF", "&yuml;"); // ÿ
			returnString = valueString.replace("\u00C0", "&Agrave;"); // À
			returnString = valueString.replace("\u00C1", "&Aacute;"); // Á
			returnString = valueString.replace("\u00C2", "&Acirc;"); // Â
			returnString = valueString.replace("\u00C3", "&Atilde;"); // Ã
			returnString = valueString.replace("\u00C5", "&Aring;"); // Å
			returnString = valueString.replace("\u00C6", "&AElig;"); // Æ
			returnString = valueString.replace("\u00C7", "&Ccedil;"); // Ç
			returnString = valueString.replace("\u00C8", "&Egrave;"); // È
			returnString = valueString.replace("\u00C9", "&Eacute;"); // É
			returnString = valueString.replace("\u00CA", "&Ecirc;"); // Ê
			returnString = valueString.replace("\u00CC", "&Igrave;"); // Ì
			returnString = valueString.replace("\u00CD", "&Iacute;"); // Í
			returnString = valueString.replace("\u00CE", "&Icirc;"); // Î
			returnString = valueString.replace("\u00D0", "&ETH;"); // Ð
			returnString = valueString.replace("\u00D1", "&Ntilde;"); // Ñ
			returnString = valueString.replace("\u00D2", "&Ograve;"); // Ò
			returnString = valueString.replace("\u00D3", "&Oacute;"); // Ó
			returnString = valueString.replace("\u00D4", "&Ocirc;"); // Ô
			returnString = valueString.replace("\u00D5", "&Otilde;"); // Õ
			returnString = valueString.replace("\u00D8", "&Oslash;"); // Ø
			returnString = valueString.replace("\u0152", "&OElig;"); // Œ
			returnString = valueString.replace("\u00D9", "&Ugrave;"); // Ù
			returnString = valueString.replace("\u00DA", "&Uacute;"); // Ú
			returnString = valueString.replace("\u00DB", "&Ucirc;"); // Û
			returnString = valueString.replace("\u00DD", "&Yacute;"); // Ý
			returnString = valueString.replace("\u00DE", "&THORN;"); // Þ
			returnString = valueString.replace("\u00E0", "&agrave;"); // à
			returnString = valueString.replace("\u00E1", "&aacute;"); // á
			returnString = valueString.replace("\u00E2", "&acirc;"); // â
			returnString = valueString.replace("\u00E3", "&atilde;"); // ã
			returnString = valueString.replace("\u00E5", "&aring;"); // å
			returnString = valueString.replace("\u00E6", "&aelig;"); // æ
			returnString = valueString.replace("\u00E7", "&ccedil;"); // ç
			returnString = valueString.replace("\u00E8", "&egrave;"); // è
			returnString = valueString.replace("\u00E9", "&eacute;"); // é
			returnString = valueString.replace("\u00EA", "&ecirc;"); // ê
			returnString = valueString.replace("\u00EC", "&igrave;"); // ì
			returnString = valueString.replace("\u00ED", "&iacute;"); // í
			returnString = valueString.replace("\u00EE", "&icirc;"); // î
			returnString = valueString.replace("\u00F0", "&eth;"); // ð
			returnString = valueString.replace("\u00F1", "&ntilde;"); // ñ
			returnString = valueString.replace("\u00F2", "&ograve;"); // ò
			returnString = valueString.replace("\u00F3", "&oacute;"); // ó
			returnString = valueString.replace("\u00F4", "&ocirc;"); // ô
			returnString = valueString.replace("\u00F5", "&otilde;"); // õ
			returnString = valueString.replace("\u00F8", "&oslash;"); // ø
			returnString = valueString.replace("\u0153", "&oelig;"); // œ
			returnString = valueString.replace("\u00F9", "&ugrave;"); // ù
			returnString = valueString.replace("\u00FA", "&uacute;"); // ú
			returnString = valueString.replace("\u00FB", "&ucirc;"); // û
			returnString = valueString.replace("\u00FD", "&yacute;"); // ý
			returnString = valueString.replace("\u00FE", "&thorn;"); // þ
			returnString = valueString.replace("\u0160", "&Scaron;"); // Š
			returnString = valueString.replace("\u0161", "&scaron;"); // š
			returnString = valueString.replace("\u00DF", "&szlig;"); // ß
		}
		return returnString;
	}

	/**
	 * Cleans and sanitizes a given string to remove invalid characters, transform special characters,
	 * and make it suitable for use as a Verwendungszweck (purpose) string in payment systems.
	 *
	 * @param string The input string to be cleaned and transformed.
	 * @return A sanitized string suitable for usage as a Verwendungszweck string.
	 */
	public static String getValidVerwendungszweckString(String string) {
		string = string.toLowerCase();
		string = string.trim();

		string = string.replaceAll("\u00E4", "ae"); // ä
		string = string.replaceAll("\u00FC", "ue"); // ü
		string = string.replaceAll("\u00F6", "oe"); // ö
		string = string.replace('\'', '#'); // '
		string = string.replace('"', '#'); // "
		string = string.replace('\u00B4', '-'); // ´
		string = string.replace('`', ' '); // `
		string = string.replace('\u00E1', 'a'); // á
		string = string.replace('\u00E0', 'a'); // à
		string = string.replace('\u00E9', 'e'); // é
		string = string.replace('\u00E8', 'e'); // è
		string = string.replace('\u00F3', 'o'); // ó
		string = string.replace('\u00F2', 'o'); // ò
		string = string.replace('\u00FA', 'u'); // ú
		string = string.replace('\u00F9', 'u'); // ù
		string = string.replaceAll("\u00DF", "ss"); // ß
		string = string.replace('%', ' '); // %
		string = string.replace('/', ' '); // /
		string = string.replace('-', ' '); // -
		string = string.replace('?', ' '); // ?
		string = string.replace('<', ' '); // <
		string = string.replace('>', ' '); // >

		string = string.replaceAll("###", "");
		string = string.replaceAll("#", "");
		string = string.replaceAll("<br>", "");
		string = string.replaceAll("\\.\\.", "");
		string = string.replaceAll("\\.\\.\\.", "");
		string = string.replaceAll("&#063;", "");
		string = string.replaceAll("\u201E", ""); // „
		string = string.replaceAll("\u201C", ""); // “
		string = string.replaceAll("\\.", ""); // .

		return string;
	}


	/**
	 * Entfernt ungültige Zeichen aus einem String und erzeugt daraus einen
	 * UNIX-tauglichen Dateinamen.
	 *
	 * @param string Dateiname (OHNE ENDUNG wie .html!!
	 * @return
	 */
	public static String getValidFileNameFromString(String string) {
		string = string.toLowerCase();
		string = string.trim();

		string = string.replaceAll("\u00E4", "ae"); // ä
		string = string.replaceAll("\u00FC", "ue"); // ü
		string = string.replaceAll("\u00F6", "oe"); // ö
		string = string.replace('\'', '#'); // '
		string = string.replace('"', '#'); // "
		string = string.replace('\u00B4', '-'); // ´
		string = string.replace('`', ' '); // `
		string = string.replace('\u00E1', 'a'); // á
		string = string.replace('\u00E0', 'a'); // à
		string = string.replace('\u00E9', 'e'); // é
		string = string.replace('\u00E8', 'e'); // è
		string = string.replace('\u00F3', 'o'); // ó
		string = string.replace('\u00F2', 'o'); // ò
		string = string.replace('\u00FA', 'u'); // ú
		string = string.replace('\u00F9', 'u'); // ù
		string = string.replaceAll("\u00DF", "ss"); // ß
		string = string.replace('%', '#'); // %
		string = string.replace('/', '#'); // /
		string = string.replace(' ', '-'); // space
		string = string.replace('?', '#'); // ?
		string = string.replace('<', '#'); // <
		string = string.replace('>', '#'); // >

		string = string.replace(' ', '-'); // space
		string = string.replaceAll("###", "");
		string = string.replaceAll("#", "");
		string = string.replaceAll("<br>", "");
		string = string.replaceAll("\\.\\.", "");
		string = string.replaceAll("\\.\\.\\.", "");
		string = string.replaceAll("&#063;", "");
		string = string.replaceAll("\u201E", ""); // „
		string = string.replaceAll("\u201C", ""); // “
		string = string.replaceAll("\\.", ""); // .

		return string;
	}


	/**
	 * Description: convert from UTF-8 -> internal Java String format
	 *
	 * @param s
	 * @return Creation: 11.12.2015 by mst
	 * @throws UnsupportedEncodingException
	 */
	public static String convertFromUTF8(String s) throws UnsupportedEncodingException
	{
		return new String(s.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
	}

	/**
	 * Description: convert from internal Java String format -> UTF-8
	 *
	 * @param s
	 * @return Creation: 11.12.2015 by mst
	 * @throws UnsupportedEncodingException
	 */
	public static String convertToUTF8(String s) throws UnsupportedEncodingException
	{
		return new String(s.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
	}

	/**
	 * Description:
	 *
	 * @param vector
	 * @return Creation: 11.12.2015 by mst
	 */
	public static String verketteStringVector2String(final Vector<String> vector)
	{
		StringBuilder string = new StringBuilder();

		String[] stringArray = vector.toArray(new String[0]);
		for (String s : stringArray)
		{
			string.append(s);
		}
		return string.toString();

	}

	/**
	 * Verkettet eine Arraylist mit Strings zu einem zusammenhängenden String
	 *
	 * @param arrayList
	 * @return
	 */
	public static String verketteStringArraylist2String(List<String> arrayList)
	{
		StringBuilder string = new StringBuilder();

		String[] stringArray = arrayList.toArray(new String[0]);
		for (String s : stringArray)
		{
			string.append(s);
		}
		return string.toString();

	}

	/**
	 * Converts an array of strings into a concatenated single string.
	 *
	 * @param stringArray The array of strings to be concatenated.
	 * @return A single string made up of all strings from the array concatenated together.
	 */
	public static String verketteStringArraylist2String(String[] stringArray)
	{
		StringBuilder string = new StringBuilder();

		for (String s : stringArray)
		{
			string.append(s);
		}
		return string.toString();

	}

	/**
	 * Converts an array of strings into a single string with each element separated by a newline character.
	 *
	 * @param stringArray The array of strings to be concatenated.
	 * @return A single string in which each element from the input array is separated by a newline character.
	 */
	public static String verketteStringArray2StringWithNewLine(String[] stringArray)
	{
		StringBuilder string = new StringBuilder();

		for (int i = 0; i < stringArray.length; i++)
		{
			if (i == 0)
			{
				string.append(stringArray[i]);
			}
			else
			{
				string.append("\n")
					  .append(stringArray[i]);
			}

		}
		return string.toString();

	}

	/**
	 * Converts a number string, potentially containing commas and periods, into a valid number string using periods
	 * as the decimal separator.
	 * example "z.B. -13.497,25" to "-13497.25"
	 *
	 * @param numberString the input string representing the number with commas and periods
	 * @return the converted string with periods as the only decimal separator
	 */
	public static String convertNumberStringToValidNumberString(String numberString)
	{
		numberString = numberString.replaceAll("[.]", "");
		numberString = numberString.replace(',', '.');
		return numberString;
	}

	/**
	 * Extracts substrings from the provided text that are found between specified start (anfang) and end (ende) strings.
	 *
	 * @param text   The input text from which substrings will be extracted.
	 * @param anfang The starting delimiter that indicates the beginning of the substring.
	 * @param ende   The ending delimiter that indicates the end of the substring.
	 * @return An array of strings that were found between the specified start and end delimiters.
	 */
	public static String[] getStringZwischen(String text, String anfang, String ende)
	{
		// Bei Ausdrücken (text) mit mehreren Klammern muss noch eine
		// Einschränkung bei .* getroffen werden
		Pattern p = Pattern.compile("(?<=" + anfang + ").*(?=" + ende + ")");
		Matcher m = p.matcher(text);
		ArrayList<String> ergebnisStringArray = new ArrayList<String>();
		while (m.find())
		{
			ergebnisStringArray.add(m.group());
		}
		return ergebnisStringArray.toArray(new String[0]);
	}

	/**
	 * Converts a boolean value to its corresponding string representation.
	 *
	 * @param booleanValue the boolean value to be converted
	 * @return "true" if the boolean value is true, otherwise "false"
	 */
	public static String getBooleanString(boolean booleanValue)
	{
		return convertBooleanToString(booleanValue);
	}

	/**
	 * Converts a boolean value to its corresponding string representation.
	 *
	 * @param booleanValue the boolean value to be converted
	 * @return "true" if the boolean value is true, otherwise "false"
	 */
	public static String convertBooleanToString(boolean booleanValue)
	{
		return booleanValue ? "true" : "false";
	}

	/**
	 * Splits the provided string into an array of substrings based on the specified separator.
	 *
	 * @param splittString The string to be split.
	 * @param separator    The delimiter by which the string is to be split.
	 * @return An array of substrings obtained by splitting the input string using the specified separator.
	 */
	public static String[] splittStringWithCommas(String splittString, String separator)
	{
		return splittString.split(separator);
	}

	/**
	 * Validates whether the provided byte array is a valid UTF-8 encoded sequence.
	 *
	 * @param input The byte array to validate.
	 * @return true if the byte array is valid UTF-8, otherwise false.
	 */
	public static boolean isValidUTF8(byte[] input)
	{

		CharsetDecoder cs = StandardCharsets.UTF_8
								   .newDecoder();

		try
		{
			cs.decode(ByteBuffer.wrap(input));
			return true;
		} catch (CharacterCodingException e)
		{
			return false;
		}
	}

	/**
	 * Checks if the given input string is misinterpreted as UTF-8 when using the specified encoding.
	 *
	 * @param input The input string to check for UTF-8 misinterpretation.
	 * @param encoding The encoding to be used for the initial byte conversion of the input string.
	 * @return true if the input string is misinterpreted as UTF-8, otherwise false.
	 */
	public static boolean isUTF8MisInterpreted(String input, String encoding)
	{

		// SortedMap<String, Charset> csMap = Charset.availableCharsets();
		// Set keySet = csMap.keySet();
		CharsetDecoder decoder = StandardCharsets.UTF_8
										.newDecoder();
		CharsetEncoder encoder = Charset.forName(encoding)
										.newEncoder();
		ByteBuffer tmp;
		try
		{
			tmp = encoder.encode(CharBuffer.wrap(input));
		} catch (CharacterCodingException e)
		{
			return false;
		}

		try
		{
			decoder.decode(tmp);
			return true;
		} catch (CharacterCodingException e)
		{
			return false;
		}
	}

	/**
	 * Removes specific Unicode glyphs and other non-graphical characters from the input string.
	 *
	 * @param stringValue The input string from which Unicode glyphs and other non-graphical characters will be removed.
	 * @return A string with the specified Unicode glyphs and other non-graphical characters removed.
	 */
	public static String removeUniCodeGlyphs(String stringValue)
	{

		stringValue = stringValue.replaceAll("\u00ef", "");
		stringValue = stringValue.replaceAll("\u00bf", "");
		stringValue = stringValue.replaceAll("\u00bb", "");
		stringValue = stringValue.replaceAll("\uFFFD", "");
		stringValue = stringValue.replaceAll("\u00DE", "");
		stringValue = stringValue.replaceAll("\u00FF", "");
		stringValue = stringValue.replaceAll("\ufffd", "");
		stringValue = stringValue.replaceAll("\"", "");
		stringValue = stringValue.replaceAll("[^\\p{Graph}\n\r\t ]", "");
		return stringValue;
	}

	/**
	 * Generates an MD5 hash from a given plaintext string.
	 *
	 * @param plaintext the input string to be hashed
	 * @return the MD5 hash of the input string in hexadecimal format
	 * @throws NoSuchAlgorithmException     if no Provider supports a MessageDigestSpi implementation for MD5
	 * @throws UnsupportedEncodingException if the named charset is not supported
	 */
	public static String getMd5HashFromString(String plaintext) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(plaintext.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		StringBuilder hashtext = new StringBuilder(bigInt.toString(16));
		// Now we need to zero pad it if you actually want the full 32 chars.
		while (hashtext.length() < 32)
		{
			hashtext.insert(0, "0");
		}
		return hashtext.toString();
	}
}
