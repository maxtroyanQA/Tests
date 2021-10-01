package assistive;

import org.testng.annotations.BeforeClass;
import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("app.properties")
public class TypesProperties {

    @Property("SITE_P")
    public static String SITE_P;


    @Property("COOKIE_P")
    public static String COOKIE_P;


    @Property("BROWSER_P")
    public static String BROWSER_P;

    protected TypesProperties() {
        PropertyLoader.newInstance().populate(this);
    }

}


