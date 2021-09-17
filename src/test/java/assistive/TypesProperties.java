package assistive;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("app.properties")
public class TypesProperties {

    @Property("STARTSITE_P")
    public static String startSITE_P;

    @Property("LOGIN_P")
    public static String LOGIN_P;

    @Property("PASSWORD_P")
    public static String PASSWORD_P;

    @Property("PORT_P")
    public static int PORT_P;

    @Property("COOKIE_P")
    public static String COOKIE_P;

    @Property("KEY_P")
    public static String KEY_P;

    @Property("SITEEDIT_P")
    public static String SITEEDIT_P;

    @Property("USEREMAIL_P")
    public static String USEREMAIL_P;

    @Property("SITECALENDAR_P")
    public static String SITECALENDAR_P;

    private String EV() {
        String env = System.getenv("URL");
        if (env != null) {
            return env;
        }
        return "empty";
    }



    public String toggleVariable(String URLSITE) {
        URLSITE = null;
        if (EV().equals(startSITE_P) && (!EV().equals("empty"))) {
            return EV();
        } else if (startSITE_P.equals(URLSITE)) {
            return startSITE_P;
        } else {
            return URLSITE;
        }
    }

    protected TypesProperties() {
        PropertyLoader.newInstance().populate(this);
    }

}


