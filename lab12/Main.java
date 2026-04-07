class CheckDigits {
    public static void main(String[] args) {
        String str = "123456";

        boolean onlyDigits = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                onlyDigits = false;
                break;
            }
        }

        if (onlyDigits) {
            System.out.println("Жол тек цифрлардан тұрады");
        } else {
            System.out.println("Жолда басқа символдар бар");
        }
    }
}