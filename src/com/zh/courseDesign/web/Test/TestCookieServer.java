package com.zh.courseDesign.web.Test;

import com.zh.courseDesign.web.service.CookieServer;
import org.junit.Test;

/**
 * @author MaCode
 * @date 2020-12-05
 * @github HappyOnion801
 */
public class TestCookieServer {
    @Test
    public void getUser(){
        System.out.println(CookieServer.getUser("2325590094797160787701788774293354992227835795909095709849721058"));
    }
    @Test
    public void setCookie(){
        System.out.println(CookieServer.setCookie(14));
    }
}
