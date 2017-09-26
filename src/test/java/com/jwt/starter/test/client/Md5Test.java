package com.jwt.starter.test.client;

import com.jwt.starter.utils.PHPMD5Utils;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class Md5Test {
    @Test
    public void test() throws NoSuchAlgorithmException {
        System.out.println(PHPMD5Utils.md5("123456"));
    }
}
