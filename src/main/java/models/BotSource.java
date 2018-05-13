package models;

public class BotSource {
    private static final String BOTUSERNAME = "________________";
    private static final String BOTTOKEN = "_________________";
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
