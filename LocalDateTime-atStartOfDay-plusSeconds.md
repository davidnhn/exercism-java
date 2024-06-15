![image](https://github.com/davidnhn/exercism-java/assets/34092600/e2cb16f4-85e9-4129-9b17-e92e3823ec57)
![image](https://github.com/davidnhn/exercism-java/assets/34092600/d1cc52a0-7508-434b-b711-f23bbb8cfc4f)
![image](https://github.com/davidnhn/exercism-java/assets/34092600/cb199463-7ed3-4063-8ae6-c9eedb2bf356)
![image](https://github.com/davidnhn/exercism-java/assets/34092600/dec46766-86a3-4659-9819-74066eb00b6d) <br>
**Tests unitaires** : 
  ```java
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import static org.assertj.core.api.Assertions.assertThat;

public class GigasecondTest {

    @Test
    public void modernTime() {
        Gigasecond gigaSecond = new Gigasecond(LocalDate.of(2011, Month.APRIL, 25));
        assertThat(gigaSecond.getDateTime()).isEqualTo(LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40));
    }

    @Test
    public void afterEpochTime() {
        Gigasecond gigaSecond = new Gigasecond(LocalDate.of(1977, Month.JUNE, 13));
        assertThat(gigaSecond.getDateTime()).isEqualTo(LocalDateTime.of(2009, Month.FEBRUARY, 19, 1, 46, 40));
    }

    @Test
    public void beforeEpochTime() {
        Gigasecond gigaSecond = new Gigasecond(LocalDate.of(1959, Month.JULY, 19));
        assertThat(gigaSecond.getDateTime()).isEqualTo(LocalDateTime.of(1991, Month.MARCH, 27, 1, 46, 40));
    }

    @Test
    public void withFullTimeSpecified() {
        Gigasecond gigaSecond = new Gigasecond(LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0));
        assertThat(gigaSecond.getDateTime()).isEqualTo(LocalDateTime.of(2046, Month.OCTOBER, 2, 23, 46, 40));
    }

    @Test
    public void withFullTimeSpecifiedAndDayRollover() {
        Gigasecond gigaSecond = new Gigasecond(LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59));
        assertThat(gigaSecond.getDateTime()).isEqualTo(LocalDateTime.of(2046, Month.OCTOBER, 3, 1, 46, 39));
    }

    @Test
    public void doesNotMutateInput() {
        LocalDateTime input = LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59);
        new Gigasecond(input).getDateTime();
        assertThat(input).isEqualTo(LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59));
    }
}

```

![image](https://github.com/davidnhn/exercism-java/assets/34092600/d5a25fae-399d-4a9f-b6f1-8b620a4a30c7)
![image](https://github.com/davidnhn/exercism-java/assets/34092600/6e2fa5e0-af3c-4cf1-b1b2-0cb25176d473)
![image](https://github.com/davidnhn/exercism-java/assets/34092600/66f5ef05-2427-4745-9148-1075351e97d8)

