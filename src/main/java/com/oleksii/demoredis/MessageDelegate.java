package com.oleksii.demoredis;

public class MessageDelegate {

        public void handleMessage(String message) {
            System.out.println("got message: " + message);
        }
}
