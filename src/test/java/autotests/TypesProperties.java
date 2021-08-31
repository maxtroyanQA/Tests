package autotests;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("app.properties")
public  class TypesProperties extends TestBase {

    @Property("STARTSITE")
    public String startSITE;

    @Property("LOGIN_P")
    public String LOGIN_P;

    @Property("PASSWORD_P")
    public String PASSWORD_P;

    @Property("PASSWORD_TEST1")
    public String PASSWORD_TEST1;

    @Property("PASSWORD_TEST2")
    public String PASSWORD_TEST2;

    @Property("PASSWORD_TEST3")
    public String PASSWORD_TEST3;

    @Property("LOGIN_TEST1")
    public String LOGIN_TEST1;

    @Property("LOGIN_TEST2")
    public String LOGIN_TEST2;

    @Property("LOGIN_TEST3")
    public String LOGIN_TEST3;

    public TypesProperties() {
        PropertyLoader.newInstance().populate(this);
    }
}


