package autotests;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("app.properties")
public  class TypesProperties extends TestBase {

//    public TypesProperties() {
//        PropertyLoader.populate(this); //инициализация полей класса значениями из файла
//    }
  //  private String login;
    @Property("STARTSITE")
    public String startSITE;

    @Property("LOGIN_P")
    public String LOGIN_P;

    @Property("PASSWORD_P")
    public String PASSWORD_P;

    public TypesProperties() {
        PropertyLoader.newInstance().populate(this);
    }

//       public TypesProperties() {
//        PropertyLoader.newInstance().populate(this);}

//    public String getLOGIN() {
//        return login;
//    }
//
//    public void setLOGIN() {
//        login = readProp("LOGIN");
//    }







//    public String readProp(String key) {
//        Properties prop = new Properties();
//        try {
//            prop.load(new InputStreamReader(new FileInputStream("src/test/resources/config.properties"), StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return prop.getProperty(key);
//    }

}


