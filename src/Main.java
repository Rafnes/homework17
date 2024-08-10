public class Main {
    public static void main(String[] args) {
        String login = "John_Doe";
        String password = "swordfish_100";
        String confirmPassword = "swordfish_1001";
        try {
            ServiceInterface.check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Данные обработаны");
        }
    }
}
