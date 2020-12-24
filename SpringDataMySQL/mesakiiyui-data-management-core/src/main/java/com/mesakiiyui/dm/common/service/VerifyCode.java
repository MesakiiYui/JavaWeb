package com.mesakiiyui.dm.common.service;

import java.awt.image.BufferedImage;

public interface VerifyCode {

    String drawRandomText(int width, int height, BufferedImage verifyImg);
}
