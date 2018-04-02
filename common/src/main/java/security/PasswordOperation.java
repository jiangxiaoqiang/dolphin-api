package security;

import org.apache.commons.codec.digest.DigestUtils;


public class PasswordOperation {

    /**
     * add salt to password
     * @param originalPassword
     * @param salt
     * @return
     */
    public static String saltPassword(String originalPassword, String salt) {
        return DigestUtils.sha256Hex(salt + originalPassword);
    }

    /**
     * password match
     *
     * @param userInputPassword
     * @param salt
     * @param saltedPassword
     * @return
     */
    public static boolean matchPassword(String userInputPassword,String salt,String saltedPassword){
        String authSaltedPassword = DigestUtils.sha256Hex(salt + userInputPassword);
        return saltedPassword.equals(authSaltedPassword);
    }

}
