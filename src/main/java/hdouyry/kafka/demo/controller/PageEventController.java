package hdouyry.kafka.demo.controller;

import hdouyry.kafka.demo.event.PageEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class PageEventController {

    private final StreamBridge streamBridge;

    public PageEventController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/publish")
    public PageEvent publish(String pageName,String topic){
       PageEvent event = new PageEvent(pageName,
               Math.random()>0.5? "U1":"U2",
               new Date(),
               10 + new Random().nextInt(10000));

        streamBridge.send(topic, event);
        return event;
    }
}
