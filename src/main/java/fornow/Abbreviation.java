package fornow;

public class Abbreviation {
    public static void main(String[] args) {
//        String original = "FACEBOOK";
//        String abridged = "F6K";
//        String original = "FACEBOOK";
//        String abridged = "F2E2OK";
//        String original = "INTERNATIONALIZATION";
//        String abridged = "I18N";
//        String original = "PERSONALIZATION";
//        String abridged = "P13N";
        String original = "LOCALIZATION";
        String abridged = "L10N";
        System.out.println(isAbridgedValid4Original(original, abridged));
    }

    private static boolean isAbridgedValid4Original(String original, String abridged) {
        int i=0;
        int number = 0;
        for (Character ch:abridged.toCharArray()) {
            if (ch >= 48 && ch <= 57) {
                number = number*10 + (ch-48);
            }
            else {
                if (number > 0) {
                    i = i + number;
                    number=0;
                }
                if (i<original.length() && ch.equals(original.charAt(i))) i++;
                else return false;
            }
        }
        return true;
    }
}
