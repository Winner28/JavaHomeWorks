package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener("Session Listener")
public class SessionListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session for user created");
        System.out.println("Session id: " + httpSessionEvent.getSession().getId());
        if (httpSessionEvent.getSession().getAttribute("userInfo") == null) {
            System.out.println("User is not in system, yet");
        } else
            System.out.println("User-INFO: " + httpSessionEvent.getSession().getAttribute("userInfo"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session destroyed: " + httpSessionEvent.getSession().getId());
    }

}
