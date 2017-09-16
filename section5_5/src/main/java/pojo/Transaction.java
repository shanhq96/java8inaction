package pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@ToString
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
}
