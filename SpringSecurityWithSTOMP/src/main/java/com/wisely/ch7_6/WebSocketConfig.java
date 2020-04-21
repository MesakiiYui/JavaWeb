package com.wisely.ch7_6;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 通过注解@EnableWebSocketMessageBroker开启使用STOMP协议来传输基于代理(message broker)的消息，这时控制器支持使用@MessageMapping，
 * 就像使用@RequestMapping一样
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
// 通过继承AbstractWebSocketMessageBrokerConfigurer类，重写其方法来配置WebSocket
	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointWisely").withSockJS(); 
        registry.addEndpoint("/endpointChat").withSockJS();//1 注册一个STOMP协议的节点(endpoint)，并指定使用SocketJS协议
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { // 配置消息代理，Message Broker
        registry.enableSimpleBroker("/queue","/topic"); //2 广播式应配置一个/topic消息代理
    }

}
