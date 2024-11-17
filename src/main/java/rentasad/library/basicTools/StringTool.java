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
	 * Escapes special characters in the given string to their corresponding HTML entities.
	 *
	 * @param valueString The input string that may contain special characters to be converted to HTML entities.
	 * @return A string with special characters replaced by HTML entities, or an empty string if the input is null.
	 */
	public static String escapeStringToHtml(final String valueString)
	{
		String returnString = "";
		if (valueString != null)
		{
			returnString = valueString.replace("Ä", "&Auml;");
			returnString = returnString.replace("ä", "&auml;");
			returnString = returnString.replace("Ë", "&Euml;");
			returnString = returnString.replace("ë", "&euml;");
			returnString = returnString.replace("Ï", "&Iuml;");
			returnString = returnString.replace("ï", "&iuml;");
			returnString = returnString.replace("Ö", "&Ouml;");
			returnString = returnString.replace("ö", "&ouml;");
			returnString = returnString.replace("Ü", "&Uuml;");
			returnString = returnString.replace("ü", "&uuml;");
			returnString = returnString.replace("Ÿ", "&Yuml;");
			returnString = returnString.replace("ÿ", "&yuml;");
			returnString = returnString.replace("À", "&Agrave;");
			returnString = returnString.replace("Á", "&Aacute;");
			returnString = returnString.replace("Â", "&Acirc;");
			returnString = returnString.replace("Ã", "&Atilde;");
			// returnString = returnString.replace("�...", "&Aring;");
			returnString = returnString.replace("Æ", "&AElig;");
			returnString = returnString.replace("Ç", "&Ccedil;");
			returnString = returnString.replace("È", "&Egrave;");
			returnString = returnString.replace("É", "&Eacute;");
			returnString = returnString.replace("Ê", "&Ecirc;");
			returnString = returnString.replace("Ì", "&Igrave;");
			returnString = returnString.replace("Í", "&Iacute;");
			returnString = returnString.replace("Î", "&Icirc;");
			returnString = returnString.replace("Ð", "&ETH;");
			returnString = returnString.replace("Ñ", "&Ntilde;");
			returnString = returnString.replace("Ò", "&Ograve;");
			returnString = returnString.replace("Ó", "&Oacute;");
			returnString = returnString.replace("Ô", "&Ocirc;");
			returnString = returnString.replace("Õ", "&Otilde;");
			returnString = returnString.replace("Ø", "&Oslash;");
			returnString = returnString.replace("Œ", "&OElig;");
			returnString = returnString.replace("Ù", "&Ugrave;");
			returnString = returnString.replace("Ú", "&Uacute;");
			returnString = returnString.replace("Û", "&Ucirc;");
			returnString = returnString.replace("Ý", "&Yacute;");
			returnString = returnString.replace("Þ", "&THORN;");
			returnString = returnString.replace("à", "&agrave;");
			returnString = returnString.replace("á", "&aacute;");
			returnString = returnString.replace("â", "&acirc;");
			returnString = returnString.replace("ã", "&atilde;");
			returnString = returnString.replace("å", "&aring;");
			returnString = returnString.replace("æ", "&aelig;");
			returnString = returnString.replace("ç", "&ccedil;");
			returnString = returnString.replace("è", "&egrave;");
			returnString = returnString.replace("é", "&eacute;");
			returnString = returnString.replace("ê", "&ecirc;");
			returnString = returnString.replace("ì", "&igrave;");
			returnString = returnString.replace("í", "&iacute;");
			returnString = returnString.replace("î", "&icirc;");
			returnString = returnString.replace("ð", "&eth;");
			returnString = returnString.replace("ñ", "&ntilde;");
			returnString = returnString.replace("ò", "&ograve;");
			returnString = returnString.replace("ó", "&oacute;");
			returnString = returnString.replace("ô", "&ocirc;");
			returnString = returnString.replace("õ", "&otilde;");
			returnString = returnString.replace("ø", "&oslash;");
			returnString = returnString.replace("�", "&oelig;");
			returnString = returnString.replace("ù", "&ugrave;");
			returnString = returnString.replace("ú", "&uacute;");
			returnString = returnString.replace("û", "&ucirc;");
			returnString = returnString.replace("ý", "&yacute;");
			returnString = returnString.replace("þ", "&thorn;");
			returnString = returnString.replace("Š", "&Scaron;");
			returnString = returnString.replace("š", "&scaron;");
			// returnString = returnString.replace("ae�", "&Ccaron;");
			// returnString = returnString.replace("ae�", "&ccaron;");
			returnString = returnString.replace("ß", "&szlig;");
			/*
			 * returnString = returnString.replace("Α", "&Alpha;");
			 * returnString = returnString.replace("Β", "&Beta;");
			 * returnString = returnString.replace("�"", "&Gamma;");
			 * returnString = returnString.replace("�"", "&Delta;");
			 * returnString = returnString.replace("Ε", "&Epsilon;");
			 * returnString = returnString.replace("Ζ", "&Zeta;");
			 * returnString = returnString.replace("Η", "&Eta;");
			 * returnString = returnString.replace("Θ", "&Theta;");
			 * returnString = returnString.replace("Ι", "&Iota;");
			 * returnString = returnString.replace("Κ", "&Kappa;");
			 * returnString = returnString.replace("Λ", "&Lambda;");
			 * returnString = returnString.replace("Μ", "&Mu;");
			 * returnString = returnString.replace("Ν", "&Nu;");
			 * returnString = returnString.replace("Ξ", "&Xi;");
			 * returnString = returnString.replace("Ο", "&Omicron;");
			 * returnString = returnString.replace("Π", "&Pi;");
			 * returnString = returnString.replace("Ρ", "&Rho;");
			 * returnString = returnString.replace("Σ", "&Sigma;");
			 * returnString = returnString.replace("Τ", "&Tau;");
			 * returnString = returnString.replace("Υ", "&Upsilon;");
			 * returnString = returnString.replace("Φ", "&Phi;");
			 * returnString = returnString.replace("Χ", "&Chi;");
			 * returnString = returnString.replace("Ψ", "&Psi;");
			 * returnString = returnString.replace("Ω", "&Omega;");
			 * returnString = returnString.replace("α", "&alpha;");
			 * returnString = returnString.replace("β", "&beta;");
			 * returnString = returnString.replace("γ", "&gamma;");
			 * returnString = returnString.replace("δ", "&delta;");
			 * returnString = returnString.replace("ε", "&epsilon;");
			 * returnString = returnString.replace("ζ", "&zeta;");
			 * returnString = returnString.replace("η", "&eta;");
			 * returnString = returnString.replace("θ", "&theta;");
			 * returnString = returnString.replace("ι", "&iota;");
			 * returnString = returnString.replace("κ", "&kappa;");
			 * returnString = returnString.replace("λ", "&lambda;");
			 * returnString = returnString.replace("μ", "&mu;");
			 * returnString = returnString.replace("ν", "&nu;");
			 * returnString = returnString.replace("ξ", "&xi;");
			 * returnString = returnString.replace("ο", "&omicron;");
			 * returnString = returnString.replace("π", "&pi;");
			 * returnString = returnString.replace("ρ", "&rho;");
			 * returnString = returnString.replace("ς", "&sigmaf;");
			 * returnString = returnString.replace("σ", "&sigma;");
			 * returnString = returnString.replace("τ", "&tau;");
			 * returnString = returnString.replace("�...", "&upsilon;");
			 * returnString = returnString.replace("φ", "&phi;");
			 * returnString = returnString.replace("χ", "&chi;");
			 * returnString = returnString.replace("ψ", "&psi;");
			 * returnString = returnString.replace("ω", "&omega;");
			 */
		}
		return returnString;

	}

	/**
	 * Description: Entfernt ungültige Zeichen aus einem String und erzeugt daraus einen
	 * gültigen Verwendungszweck für Zahlungen
	 *
	 * @param string
	 * @return Creation: 25.08.2015 by mst
	 */
	public static String getValidVerwendungszweckString(String string)
	{
		// Dateiname in Kleinbuchstaben abbilden.
		string = string.toLowerCase();
		string = string.trim();

		// string = string.replaceAll("\\*\\*\\*", "");
		string = string.replaceAll("ä", "ae");
		string = string.replaceAll("ü", "ue");
		string = string.replaceAll("ö", "oe");
		string = string.replace('\'', '#');
		string = string.replace('\"', '#');
		string = string.replace('´', '-');
		string = string.replace('`', ' ');
		string = string.replace('á', 'a');
		string = string.replace('à', 'a');
		string = string.replace('é', 'e');
		string = string.replace('è', 'e');
		string = string.replace('ó', 'o');
		string = string.replace('ò', 'o');
		string = string.replace('ú', 'u');
		string = string.replace('ù', 'u');
		string = string.replaceAll("ß", "ss");
		string = string.replace('%', ' ');
		string = string.replace('/', ' ');
		string = string.replace('-', ' ');
		string = string.replace('?', ' ');
		string = string.replace('<', ' ');
		string = string.replace('>', ' ');

		string = string.replaceAll("###", "");
		string = string.replaceAll("#", "");
		string = string.replaceAll("<br>", "");
		string = string.replaceAll("\\.\\.", "");
		string = string.replaceAll("\\.\\.\\.", "");
		string = string.replaceAll("&#063;", "");
		string = string.replaceAll("„", "");
		string = string.replaceAll("“", "");
		string = string.replaceAll("\\.", "");

		return string;
	}

	/**
	 * Entfernt ungültige Zeichen aus einem String und erzeugt daraus einen
	 * UNIX-tauglichen Dateinamen.
	 *
	 * @param string Dateiname (OHNE ENDUNG wie .html!!
	 * @return
	 */
	public static String getValidFileNameFromString(String string)
	{
		// Dateiname in Kleinbuchstaben abbilden.
		string = string.toLowerCase();
		string = string.trim();

		// string = string.replaceAll("\\*\\*\\*", "");
		string = string.replaceAll("ä", "ae");
		string = string.replaceAll("ü", "ue");
		string = string.replaceAll("ö", "oe");
		string = string.replace('\'', '#');
		string = string.replace('\"', '#');
		string = string.replace('´', '-');
		string = string.replace('`', ' ');
		string = string.replace('á', 'a');
		string = string.replace('à', 'a');
		string = string.replace('é', 'e');
		string = string.replace('è', 'e');
		string = string.replace('ó', 'o');
		string = string.replace('ò', 'o');
		string = string.replace('ú', 'u');
		string = string.replace('ù', 'u');
		string = string.replaceAll("ß", "ss");
		string = string.replace('%', '#');
		string = string.replace('/', '#');
		string = string.replace(' ', '-');
		string = string.replace('?', '#');
		string = string.replace('<', '#');
		string = string.replace('>', '#');

		string = string.replace(' ', '-');
		string = string.replaceAll("###", "");
		string = string.replaceAll("#", "");
		string = string.replaceAll("<br>", "");
		string = string.replaceAll("\\.\\.", "");
		string = string.replaceAll("\\.\\.\\.", "");
		string = string.replaceAll("&#063;", "");
		string = string.replaceAll("„", "");
		string = string.replaceAll("“", "");
		string = string.replaceAll("\\.", "");

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
		return new String(s.getBytes("ISO-8859-1"), "UTF-8");
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
		return new String(s.getBytes("UTF-8"), "ISO-8859-1");
	}

	/**
	 * Description:
	 *
	 * @param vector
	 * @return Creation: 11.12.2015 by mst
	 */
	public static String verketteStringVector2String(final Vector<String> vector)
	{
		String string = "";

		String[] stringArray = vector.toArray(new String[0]);
		for (int i = 0; i < stringArray.length; i++)
		{
			string = string + stringArray[i];
		}
		return string;

	}

	/**
	 * Verkettet eine Arraylist mit Strings zu einem zusammenhängenden String
	 *
	 * @param arrayList
	 * @return
	 */
	public static String verketteStringArraylist2String(List<String> arrayList)
	{
		String string = "";

		String[] stringArray = arrayList.toArray(new String[0]);
		for (int i = 0; i < stringArray.length; i++)
		{
			string = string + stringArray[i];
		}
		return string;

	}

	/**
	 * Converts an array of strings into a concatenated single string.
	 *
	 * @param stringArray The array of strings to be concatenated.
	 * @return A single string made up of all strings from the array concatenated together.
	 */
	public static String verketteStringArraylist2String(String[] stringArray)
	{
		String string = "";

		for (int i = 0; i < stringArray.length; i++)
		{
			string = string + stringArray[i];
		}
		return string;

	}

	/**
	 * Converts an array of strings into a single string with each element separated by a newline character.
	 *
	 * @param stringArray The array of strings to be concatenated.
	 * @return A single string in which each element from the input array is separated by a newline character.
	 */
	public static String verketteStringArray2StringWithNewLine(String[] stringArray)
	{
		String string = "";

		for (int i = 0; i < stringArray.length; i++)
		{
			if (i == 0)
			{
				string = string + stringArray[i];
			}
			else
			{
				string = string + "\n" + stringArray[i];
			}

		}
		return string;

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
