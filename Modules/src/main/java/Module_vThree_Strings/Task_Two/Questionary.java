package Module_vThree_Strings.Task_Two;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Questionary implements QuestionaryAPI {

    private Locale langLocale;

    private ResourceBundle bundle;

    public Questionary(Language language) {
        switch (language) {
            case ENGLISH:
                langLocale = new Locale("en", "US");
                bundle = ResourceBundle.getBundle("prop", langLocale);
                break;
            case RUSSIAN:
                langLocale = new Locale("ru", "RU");
                bundle = ResourceBundle.getBundle("prop", langLocale);
                break;
        }
    }





    @Override
    public String getQuestionAnswer(String question) {
        return bundle.getString(question);
    }



    @Override
    public String getQuestionList() {
        Enumeration<String> enumeration = bundle.getKeys();
        while (enumeration.hasMoreElements()) {
            System.out.println("0" + enumeration.nextElement());
        }
        return null;
    }

}
