
package ObjectPageJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("emailAndSdtorPasswordIncorrectMsg")
    @Expose
    private String emailAndSdtorPasswordIncorrectMsg;
    @SerializedName("PhoneNumberIncorrectMsg")
    @Expose
    private String phoneNumberIncorrectMsg;
    @SerializedName("emailIncorrectMsg")
    @Expose
    private String emailIncorrectMsg;
    @SerializedName("emailSdtOrPasswordWrongMsg")
    @Expose
    private String emailSdtOrPasswordWrongMsg;
    @SerializedName("passwordNotEnoughtCharacterMsg")
    @Expose
    private String passwordNotEnoughtCharacterMsg;
    @SerializedName("passwordNotEnoughtCharacter")
    @Expose
    private String passwordNotEnoughtCharacter;
    @SerializedName("passwordWrong")
    @Expose
    private String passwordWrong;
    @SerializedName("passwordCorrect")
    @Expose
    private String passwordCorrect;
    @SerializedName("emailCorrect")
    @Expose
    private String emailCorrect;
    @SerializedName("phoneIncorrect")
    @Expose
    private String phoneIncorrect;
    @SerializedName("emailIncorrect")
    @Expose
    private String emailIncorrect;

    public String getEmailAndSdtorPasswordIncorrectMsg() {
        return emailAndSdtorPasswordIncorrectMsg;
    }

    public void setEmailAndSdtorPasswordIncorrectMsg(String emailAndSdtorPasswordIncorrectMsg) {
        this.emailAndSdtorPasswordIncorrectMsg = emailAndSdtorPasswordIncorrectMsg;
    }

    public String getPhoneNumberIncorrectMsg() {
        return phoneNumberIncorrectMsg;
    }

    public void setPhoneNumberIncorrectMsg(String phoneNumberIncorrectMsg) {
        this.phoneNumberIncorrectMsg = phoneNumberIncorrectMsg;
    }

    public String getEmailIncorrectMsg() {
        return emailIncorrectMsg;
    }

    public void setEmailIncorrectMsg(String emailIncorrectMsg) {
        this.emailIncorrectMsg = emailIncorrectMsg;
    }

    public String getEmailSdtOrPasswordWrongMsg() {
        return emailSdtOrPasswordWrongMsg;
    }

    public void setEmailSdtOrPasswordWrongMsg(String emailSdtOrPasswordWrongMsg) {
        this.emailSdtOrPasswordWrongMsg = emailSdtOrPasswordWrongMsg;
    }

    public String getPasswordNotEnoughtCharacterMsg() {
        return passwordNotEnoughtCharacterMsg;
    }

    public void setPasswordNotEnoughtCharacterMsg(String passwordNotEnoughtCharacterMsg) {
        this.passwordNotEnoughtCharacterMsg = passwordNotEnoughtCharacterMsg;
    }

    public String getPasswordNotEnoughtCharacter() {
        return passwordNotEnoughtCharacter;
    }

    public void setPasswordNotEnoughtCharacter(String passwordNotEnoughtCharacter) {
        this.passwordNotEnoughtCharacter = passwordNotEnoughtCharacter;
    }

    public String getPasswordWrong() {
        return passwordWrong;
    }

    public void setPasswordWrong(String passwordWrong) {
        this.passwordWrong = passwordWrong;
    }

    public String getPasswordCorrect() {
        return passwordCorrect;
    }

    public void setPasswordCorrect(String passwordCorrect) {
        this.passwordCorrect = passwordCorrect;
    }

    public String getEmailCorrect() {
        return emailCorrect;
    }

    public void setEmailCorrect(String emailCorrect) {
        this.emailCorrect = emailCorrect;
    }

    public String getPhoneIncorrect() {
        return phoneIncorrect;
    }

    public void setPhoneIncorrect(String phoneIncorrect) {
        this.phoneIncorrect = phoneIncorrect;
    }

    public String getEmailIncorrect() {
        return emailIncorrect;
    }

    public void setEmailIncorrect(String emailIncorrect) {
        this.emailIncorrect = emailIncorrect;
    }

}
