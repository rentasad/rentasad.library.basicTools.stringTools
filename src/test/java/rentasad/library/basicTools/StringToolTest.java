package rentasad.library.basicTools;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class StringToolTest
{

	/**
	 * Tests for the StringTool.stringReplacer method.
	 * <p>
	 * The stringReplacer method takes a HashMap and a String, then replaces all occurrences
	 * of the keys in the String, wrapped in "#" characters, with their corresponding values
	 * from the HashMap. If a key has a null value in the HashMap, it removes the corresponding
	 * placeholder from the String.
	 */

	@Test
	public void testStringReplacer_WithValidReplacements()
	{
		HashMap<String, String> replacements = new HashMap<>();
		replacements.put("name", "John");
		replacements.put("item", "book");
		String result = StringTool.stringReplacer(replacements, "Hello #NAME#, you borrowed a #ITEM#.");
		Assert.assertEquals("Hello John, you borrowed a book.", result);
	}

	@Test
	public void testStringReplacer_WithNullValueReplacements()
	{
		HashMap<String, String> replacements = new HashMap<>();
		replacements.put("name", null);
		String result = StringTool.stringReplacer(replacements, "Hello #NAME#, welcome!");
		Assert.assertEquals("Hello , welcome!", result);
	}

	@Test
	public void testStringReplacer_WithEmptyReplacements()
	{
		HashMap<String, String> replacements = new HashMap<>();
		String result = StringTool.stringReplacer(replacements, "Hello #NAME#, welcome!");
		Assert.assertEquals("Hello #NAME#, welcome!", result);
	}

	@Test
	public void testStringReplacer_WithNoPlaceholdersInString()
	{
		HashMap<String, String> replacements = new HashMap<>();
		replacements.put("name", "John");
		String result = StringTool.stringReplacer(replacements, "Hello world!");
		Assert.assertEquals("Hello world!", result);
	}

	@Test
	public void testStringReplacer_WithMultiplePlaceholders()
	{
		HashMap<String, String> replacements = new HashMap<>();
		replacements.put("greet", "Hi");
		replacements.put("user", "Alice");
		String result = StringTool.stringReplacer(replacements, "#GREET#, #USER#");
		Assert.assertEquals("Hi, Alice", result);
	}

	@Test
	public void testStringReplacer_WithCaseInsensitiveKeys()
	{
		HashMap<String, String> replacements = new HashMap<>();
		replacements.put("Value", "123");
		String result = StringTool.stringReplacer(replacements, "This is a #VALUE#.");
		Assert.assertEquals("This is a 123.", result);
	}

	@Test
	public void testEscapeStringToHtml_WithUmlauts()
	{
		String result = StringTool.escapeStringToHtml("ÄäÖöÜü");
		Assert.assertEquals("&Auml;&auml;&Ouml;&ouml;&Uuml;&uuml;", result);
	}

	@Test
	public void testEscapeStringToHtml_WithAccentedCharacters()
	{
		String result = StringTool.escapeStringToHtml("ÀÁÂÃÇÈÉÊÌÍÎÑÒÓÔÕÙÚÛÝ");
		Assert.assertEquals("&Agrave;&Aacute;&Acirc;&Atilde;&Ccedil;&Egrave;&Eacute;&Ecirc;&Igrave;&Iacute;&Icirc;&Ntilde;&Ograve;&Oacute;&Ocirc;&Otilde;&Ugrave;&Uacute;&Ucirc;&Yacute;", result);
	}

	@Test
	public void testEscapeStringToHtml_WithSpecialCharacters()
	{
		String result = StringTool.escapeStringToHtml("ŸÿŠšß");
		Assert.assertEquals("&Yuml;&yuml;&Scaron;&scaron;&szlig;", result);
	}

	@Test
	public void testEscapeStringToHtml_WithNonHtmlEntities()
	{
		String result = StringTool.escapeStringToHtml("Hello World!");
		Assert.assertEquals("Hello World!", result);
	}

	@Test
	public void testEscapeStringToHtml_WithMixedCharacters()
	{
		String result = StringTool.escapeStringToHtml("ÄäÖöÜüŸÿ");
		Assert.assertEquals("&Auml;&auml;&Ouml;&ouml;&Uuml;&uuml;&Yuml;&yuml;", result);
	}

	@Test
	public void testGetMd5HashFromString_WithValidInput() throws Exception
	{
		String input = "test";
		String expectedHash = "098f6bcd4621d373cade4e832627b4f6";
		String result = StringTool.getMd5HashFromString(input);
		Assert.assertEquals(expectedHash, result);
	}

	@Test
	public void testGetMd5HashFromString_WithEmptyInput() throws Exception
	{
		String input = "";
		String expectedHash = "d41d8cd98f00b204e9800998ecf8427e";
		String result = StringTool.getMd5HashFromString(input);
		Assert.assertEquals(expectedHash, result);
	}

	@Test
	public void testGetMd5HashFromString_WithSpecialCharacters() throws Exception
	{
		String input = "!@#$$%^&*()_+";
		String expectedHash = "13682b4696c35bfea2dea9392eca4151";
		String result = StringTool.getMd5HashFromString(input);
		Assert.assertEquals(expectedHash, result);
	}
}