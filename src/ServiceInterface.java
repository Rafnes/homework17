public interface ServiceInterface {
    static void check(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не может быть длиннее 20 символов");
        }

        if (!containsValidCharacters(login)) {
            throw new WrongLoginException("Логин содержит недопустимые символы");
        }

        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль не может быть длиннее 20 символов");
        }

        if (!containsValidCharacters(password)) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Не удалось подтвердить пароль: password и confirmPassword не совпадают");
        }
    }

    static boolean containsValidCharacters(String string) {
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
