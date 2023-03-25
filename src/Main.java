import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        checkUserData("Mylogin_1988",
                "Password_1234",
                "Password_1234");

    }

    public static boolean checkUserData(String login, String password, String confirmPassword){
        boolean isLoginCorrect;
        boolean isPasswordCorrect;
        boolean isConfirmPasswordCorrect;

        try {
            isLoginCorrect = checkLogin(login);
            isPasswordCorrect = checkPassword(password);
            isConfirmPasswordCorrect = checkConfirmPassword(password, confirmPassword);
        } catch (WrongLoginException e){
            System.out.println("Error. The length of input login is more than 20 characters");
            return false;
        } catch (WrongPasswordException e){
            System.out.println("Error. Confirm password is wrong.");
            return false;
        }

        if (isLoginCorrect && isPasswordCorrect && isConfirmPasswordCorrect){
            System.out.println("User data are valid");
            return true;
        } else {
            System.out.println("User data are invalid");
            return false;
        }
    }

    public static boolean checkLogin (String login) {
        //добавить латинский алфавит и цифры
        if (login.matches("^\\w+$")) {
            if (login.length() > 20) {
                throw new WrongLoginException();
            }
            return true;
        } else{
            return false;
        }
    }

    public static boolean checkPassword (String password) {
        //добавить латинский алфавит и цифры
        if ((password.matches("^\\w+$")) && (password.length() < 19)) {
            return true;
        } else{
            return false;
        }
    }

    public static boolean checkConfirmPassword (String password, String confirmPassword) {
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException();
        }
        return true;
    }


}