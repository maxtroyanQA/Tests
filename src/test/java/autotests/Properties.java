package autotests;

import ru.qatools.properties.Property;
import ru.qatools.properties.Resource;

@Resource.Classpath("app.properties")
public class Properties {
    @Property("STARTSITE")
    public String SITE;
}
