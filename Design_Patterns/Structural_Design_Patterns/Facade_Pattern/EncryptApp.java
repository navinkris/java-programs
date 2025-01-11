
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncryptApp {
  public static void main(String[] args) throws NoSuchAlgorithmException,
  NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException,
  IllegalBlockSizeException, BadPaddingException{
    Facade facade = new Facade();
    String input = "Some text to encrypt";
    facade.encrpyt(input);
  }
}

class Facade {
  public void encrpyt(String input) throws NoSuchAlgorithmException,
  NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException,
  IllegalBlockSizeException, BadPaddingException {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(128);
    SecretKey key = keyGenerator.generateKey();

    SecureRandom random = SecureRandom.getInstanceStrong();
    byte[] iv = new byte[Cipher.getInstance("AES/CBC/PKCS5Padding").getBlockSize()];
    random.nextBytes(iv);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
    byte[] cipherText = cipher.doFinal(input.getBytes());
    var result = Base64.getEncoder()
            .encodeToString(cipherText);

    System.out.println("Encrypted String: " + result);
  }
}