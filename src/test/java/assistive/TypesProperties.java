package assistive;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("app.properties")
public class TypesProperties {

    @Property("SITE")
    public static String SITE;


    @Property("COOKIE")
    public static String COOKIE;


    @Property("BROWSER")
    public static String BROWSER;

    protected TypesProperties() {
        PropertyLoader.newInstance().populate(this);
    }

}


