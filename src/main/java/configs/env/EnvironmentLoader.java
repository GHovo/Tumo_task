package configs.env;

import api.users.User;
import configs.reader.ConfigurationReader;

import static constants.base.BaseConstants.USER_PROPERTIES_PATH;

public class EnvironmentLoader extends ConfigurationReader {

    private static EnvironmentLoader INSTANCE;

    public EnvironmentLoader(String filePath) {
        super(filePath);
    }

    public static EnvironmentLoader getInstance() {
        if(INSTANCE == null){
            INSTANCE = new EnvironmentLoader(USER_PROPERTIES_PATH);
        }
        return INSTANCE;
    }

    public User getUser(){
       return new User(
                getProperty("username"),
                getProperty("password")
        );
    }

}
