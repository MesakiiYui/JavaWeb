package com.mesakiiyui.springdatamysql.common.service;

import java.awt.image.BufferedImage;

public interface VerifyCode {

    String drawRandomText(int width, int height, BufferedImage verifyImg);
}