package models;

public class BotSource {
    private static final String BOTUSERNAME = "APC_Event_Bot";
    private static final String BOTTOKEN = "555239457:AAEBlB75fcLci40PqDzgrkaCALmgjjCEpTU";
    private static final String BotTestAnswer = "тестовый ответ";

    public static String getBotTestAnswer() {
        return BotTestAnswer;
    }

    public static String getBOTUSERNAME() {
        return BOTUSERNAME;
    }

    public static String getBOTTOKEN() {
        return BOTTOKEN;
    }
}
