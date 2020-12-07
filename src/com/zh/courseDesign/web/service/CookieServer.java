package com.zh.courseDesign.web.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 这是一个简单的cookie服务类，用来实现用户id和cookie的映射关系，cookie长度为64位纯数字，采用随机数的方式生成。
 * @author MaCode
 * @date 2020-12-05
 * @github HappyOnion801
 */
public class CookieServer {
    private static final Map<String, Integer> cookies;

    static {
        cookies = new HashMap<>();
    }

    private static String createCookie() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 64; i++) {
            int j = (int) (Math.random() * 10);
            sb.append(j);
        }
        return sb.toString();
    }

    /**
     * 通过cookie找到用户，返回用户的id
     * @param cookie cookie字符串，必须为64位长度的字符串，否则返回-1；
     */
    public static Integer getUser(String cookie) {
        if (cookie==null || cookie.length() != 64) {
            return -1;
        }
        return cookies.get(cookie);
    }

    /**
     * 为用户创建一个cookie，并返回设置的cookie
     * @param id 用户id
     * @return 返回个设置的用户cookie
     */
    public static String setCookie(int id){
        String cookie = createCookie();
        cookies.put(cookie,id);
        return cookie;
    }

}
