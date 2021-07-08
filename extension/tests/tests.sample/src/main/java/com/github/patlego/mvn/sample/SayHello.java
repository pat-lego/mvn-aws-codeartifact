package com.github.patlego.mvn.sample;

/**
 * Hello world!
 *
 */
public class SayHello  {
    public String sayHello(String name) {
        if (null == name) {
            return "Hello World";
        } 

        return String.format("Hello %s", name);
    }
}
