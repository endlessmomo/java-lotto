package domain;

import java.util.*;

import static util.StringUtil.parseToList;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    public Lotto(String inputNumbers){
        this.numbers = parseToList(inputNumbers);
        validate(this.numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        checkLength(numbers);
        checkDuplication(numbers);
    }

    // TODO: 추가 기능 구현
    private void checkLength(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 잘못된 복권 번호입니다.");
        }
    }

    private void checkDuplication(List<Integer> numbers){
        Set <Integer> checkDup = new HashSet <>(numbers);

        if(checkDup.size() != 6){
            throw new IllegalArgumentException("[ERROR] 잘못된 복권 번호입니다.");
        }
    }

    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }

    public int sameNumberCount(WinningNumber winningNumber){
        return (int) this.numbers.stream().filter(number
                -> winningNumber.getWinningNumbers().getNumbers().contains(number)).count();
    }
}
