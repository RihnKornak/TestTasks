package logic;

/**
 * Created by Rihn Kornak on 24.06.2017.
 */
public interface LoginedManager extends Manager{
    UserHelper getUser();
    MailBox getMail();

}
