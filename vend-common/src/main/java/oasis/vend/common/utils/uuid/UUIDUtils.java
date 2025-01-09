package oasis.vend.common.utils.uuid;

/**
 * UUID generation 
 */
public class UUIDUtils {

	// 62 characters
	private static final char[] chars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	// generate a 8-character string from the uuid
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", ""); // generate a uuid, and remove the hyphens.
		StringBuffer shortBuffer = new StringBuffer();// immutable, synchronized, multiple threads

		// generate a 8-character string from the uuid
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]); // 0x3E = 62
		}

		return shortBuffer.toString();
	}
}
