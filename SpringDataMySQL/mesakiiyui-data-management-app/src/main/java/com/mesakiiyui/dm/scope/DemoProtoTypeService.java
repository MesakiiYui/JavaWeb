package com.mesakiiyui.dm.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Author: jintienan
 * @Date: 2021/1/4 15:01
 */
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DemoProtoTypeService {
}
