package assistive;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("app.properties")
public class TypesProperties {

    @Property("STARTSITE")
    public static String startSITE;

    @Property("LOGIN")
    public static String LOGIN;

    @Property("PASSWORD")
    public static String PASSWORD;

    @Property("PORT")
    public static int PORT;

    @Property("COOKIE")
    public static String COOKIE;

    @Property("KEY")
    public static String KEY;

    @Property("SITEEDIT")
    public static String SITEEDIT;

    @Property("USEREMAIL")
    public static String USEREMAIL;

    @Property("SITECALENDAR")
    public static String SITECALENDAR;

    @Property("BROWSER")
    public static String BROWSER;


    public String environments() {

        String ENV = System.getenv("BROWSER_ENV");
        String BROWSERSET;

        if (ENV == null) {
            BROWSERSET = BROWSER;
        } else {
            if (ENV.equals("")) {
                BROWSERSET = BROWSER;
            } else BROWSERSET = ENV;
        }

        return BROWSERSET;

    }


    protected TypesProperties() {
        PropertyLoader.newInstance().populate(this);
    }

}


