package listener;

import javax.servlet.http.*;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/4/3
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Attribute create : "+httpSessionBindingEvent.getName()+":"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("Attribute remove : "+httpSessionBindingEvent.getName()+":"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
