package com.example.prisoner;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


//used for publish custom events ie MyEvent.class the listen to them in the application listen at prisonerApplication.java
//remember very important
@Component
public class Publisher {

    ApplicationEventPublisher publisher;

    public Publisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
        publishCustomEvent();
    }

    public void publishCustomEvent(){
        MyEvent event = new MyEvent(this,".............wtf");
        publisher.publishEvent(event);

    }
}
