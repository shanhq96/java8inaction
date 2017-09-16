package pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@ToString
public class Trader {
    private final String name;
    private final String city;
}
