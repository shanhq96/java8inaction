package solution;

import pojo.Trader;
import pojo.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );


    /**
     * 找出2011年发生的所有交易,并按交易额排序(从低到高)
     */
    public List<Transaction> solution01() {
        return transactions.stream()
                .filter(a -> a.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
    }

    /**
     * 交易员都在哪些不同的城市工作过?
     *
     * @return
     */
    public List<String> solution02() {
        return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        /*return transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toSet());*/
    }

    public List<Trader> solution03() {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(a -> a.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }

    /**
     * 返回所有交易员的姓名字符串,按字母顺序排序.
     *
     * @return
     */
    public String solution04() {
        return transactions.stream()
                .map(a -> a.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a, b) -> a + b);
    }

    /**
     * 有没有交易员是在米兰工作的
     *
     * @return
     */
    public boolean solution05() {
        return transactions.stream()
                .anyMatch(a -> a.getTrader().getCity().equals("Milan"));
    }

    /**
     * 打印生活在剑桥的交易员的所有交易额
     *
     * @return
     */
    public void solution06() {
        transactions.stream()
                .filter(a -> a.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    /**
     * 所有交易中,最高的交易额是多少?
     *
     * @return
     */
    public Optional<Integer> solution07() {
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
    }

    public Optional<Transaction> solution08() {
        return transactions.stream()
                .reduce((a, b) -> a.getValue() < b.getValue() ? a : b);

    }


    public static void main(String[] args) {
        Main solution = new Main();
        //找出2011年发生的所有交易,并按交易额排序(从低到高)
        solution.solution01().forEach(System.out::println);


        //交易员都在哪些不同的城市工作过?
        solution.solution02().forEach(System.out::println);

        //查找所有来自剑桥的交易员,并按姓名排序
        solution.solution03().forEach(System.out::println);

        //返回所有交易员的姓名字符串,按字母顺序排序.
        System.out.println(solution.solution04());

        //有没有交易员是在米兰工作的
        System.out.println(solution.solution05());

        //打印生活在剑桥的交易员的所有交易额
        solution.solution06();

        //所有交易中,最高的交易额是多少?
        solution.solution07().ifPresent(System.out::println);

        //找到交易额最小的交易
        solution.solution08().ifPresent(System.out::println);

    }


}
