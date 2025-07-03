package hdouyry.kafka.demo.event;

import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageEvent {
    private String name;
    private String user;
    private Date date;
    private long duration;
}
