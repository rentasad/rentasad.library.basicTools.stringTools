# StringTool

## Overview
`StringTool` is a utility class that provides various helpful methods for working with strings. It includes features for encoding/decoding, hashing, and manipulating strings in different ways. The class is particularly useful for developers dealing with string formatting, encoding conversions, and hashing operations.

## Features
- **String Encoding and Decoding**: Convert strings to different character sets.
- **Hashing Strings**: Generate MD5 or SHA hash values for strings.
- **String Manipulation**: Various methods for manipulating strings, such as padding and character conversions.

## Installation
To use `StringTool`, include it in your Java project by adding the source code to your project structure.

## Usage
Here are some example use cases for `StringTool`:

### Hash a String (MD5)
```java
String md5Hash = StringTool.hashString("example", "MD5");
System.out.println(md5Hash); // Output: MD5 hash of the string "example"
```

### Encode a String to UTF-8
```java
String utf8Encoded = StringTool.encodeString("example", "UTF-8");
System.out.println(utf8Encoded); // Output: Encoded version of "example" in UTF-8
```

### Decode a Byte Array to a String
```java
byte[] byteArray = {72, 101, 108, 108, 111};
String decodedString = StringTool.decodeBytes(byteArray, "UTF-8");
System.out.println(decodedString); // Output: "Hello"
```

## Methods Summary
1. **`hashString(String input, String algorithm)`**: Generates a hash value for the provided string using the specified algorithm (e.g., MD5, SHA-256).
    - **Parameters**: `String input`, `String algorithm`
    - **Returns**: `String` (hashed value)

2. **`encodeString(String input, String charset)`**: Encodes the given string to the specified character set.
    - **Parameters**: `String input`, `String charset`
    - **Returns**: `String` (encoded string)

3. **`decodeBytes(byte[] bytes, String charset)`**: Decodes a byte array to a string using the specified character set.
    - **Parameters**: `byte[] bytes`, `String charset`
    - **Returns**: `String` (decoded string)

## Contributing
Feel free to contribute to `StringTool` by forking the repository, making changes, and submitting a pull request. Contributions for bug fixes, new features, or optimizations are always welcome.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

