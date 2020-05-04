package com.liugui.springbootidempotence.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: TokenService
 * @Author: liugui
 * @Date: 2020-05-04 15:04
 **/
public interface TokenService {
    String createToken();

    Boolean checkToken(HttpServletRequest request)throws Exception;
}
