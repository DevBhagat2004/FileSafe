import java.security.MessageDigest;

public class logic {

    public static String cryptoLogic(String data, String prevHash,long timeStamp){
        String input = prevHash + Long.toString(timeStamp) + data;

        try {
            // 2. Initialize the SHA-256 Engine
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 3. Perform the hash on the input bytes
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));

            // 4. Convert the raw bytes into a readable Hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception e) {
            // This handles issues like "SHA-256" not being found (rare)
            throw new RuntimeException("Error generating hash", e);
        }
    }
}
