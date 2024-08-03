public class Main {
    public static void main(String[] args) {
        String login = "John_Doe000000000000000000000000";
        String password = "vvrrRRfq100";
        String confirmPassword = "vvrrRRfq101";
        checkLoginPassword(login, password, confirmPassword);
    }

    public static void checkLoginPassword(String login, String password, String confirmPassword) {
        try {
            check(login);
        } catch (WrongLoginException e) {
            System.out.println("Логин содержит недопустимые символы или длиннее 20 символов");
        } finally {
            System.out.println("Логин проверен");
        }
        try {
            check(password);
        } catch (WrongPasswordException e) {
            System.out.println("Пароль содержит недопустимые символы или длиннее 20 символов");
        } finally {
            System.out.println("Пароль проверен");
        }
        try {
            check(confirmPassword);
            checkIfPasswordsAreEqual(password, confirmPassword);
        } catch (WrongPasswordException e) {
            System.out.println("Неправильный пароль");
        }
    }

    public static void check(String string) {
        if (string.length() > 20 || string.isBlank() || !isValid(string)) {
            throw new WrongLoginException();
        }
    }

    public static void checkIfPasswordsAreEqual(String pass, String confirmPass) {
       if (!pass.equals(confirmPass)) {
           throw new WrongPasswordException();
       }
    }

    public static boolean isValid(String string) {
        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890_";
        char c1, c2;
        boolean charIsValid = false;
        for (int i = 0; i < string.length(); i++) {
            c1 = string.charAt(i);
            for (int j = 0; j < validChars.length(); j++) {
                c2 = validChars.charAt(j);
                if (c1 == c2) {
                    charIsValid = true;
                    break;
                } else {
                    charIsValid = false;
                }
            }
            if (!charIsValid) {
                return false;
            }
        }
        return charIsValid;
    }
}
