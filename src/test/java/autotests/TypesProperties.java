package autotests;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

import java.net.URL;


@Resource.Classpath("app.properties")
public  class TypesProperties {


    @Property("STARTSITE")
    public URL SITE;

    @Property("LOGIN")
    public String LOGIN;

    @Property("PASSWORD")
    public String PASSWORD;


    public TypesProperties() {
        PropertyLoader.newInstance().populate(this);
    }
}
