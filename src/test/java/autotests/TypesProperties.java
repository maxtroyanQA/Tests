package autotests;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("app.properties")
public class TypesProperties extends TestBase {

    @Property("STARTSITE")
    protected String startSITE;

    @Property("LOGIN_P")
    protected String LOGIN_P;

    @Property("PASSWORD_P")
    protected String PASSWORD_P;

    @Property("PASSWORD_TEST1")
    protected String PASSWORD_TEST1;

    @Property("PASSWORD_TEST2")
    protected String PASSWORD_TEST2;

    @Property("PASSWORD_TEST3")
    protected String PASSWORD_TEST3;

    @Property("LOGIN_TEST1")
    protected String LOGIN_TEST1;

    @Property("LOGIN_TEST2")
    protected String LOGIN_TEST2;

    @Property("LOGIN_TEST3")
    protected String LOGIN_TEST3;

    @Property("REQUEST_URL")
    protected String REQUEST_URL;


//    @NotNull
//    private String EV(){
//        String env = System.getenv("URL");
//        if (env != null){
//            return env;
//        }
//        return "empty";
//    }
//
//    String URLSITE = null;
//
//    public String toggleVariable(String URLSITE){
//
//        if (EV().equals(startSITE) && (!EV().equals("empty"))){
//            return EV();
//        }else if (startSITE.equals(URLSITE)){
//            return startSITE;
//        }else {
//            return URLSITE;
//        }
//    }

    protected TypesProperties() {
        PropertyLoader.newInstance().populate(this);
    }


}


