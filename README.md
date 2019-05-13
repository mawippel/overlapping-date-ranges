# overlapping-date-ranges - A Java Overlapping Verificator
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mawippel/overlapping-date-ranges.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mawippel/overlapping-date-ranges/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mawippel/overlapping-date-ranges.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mawippel/overlapping-date-ranges/context:java)

overlapping-date-ranges is a library to centralize and help people dealing with overlapping date ranges verifications!

## Compatibility

*   Requires JDK 1.8 or higher;

## Adding overlapping-date-ranges to your build

To add a dependency on overlapping-date-ranges using Maven, use the following:

```xml
<dependency>
  <groupId>com.github.mawippel</groupId>
  <artifactId>overlapping-date-ranges</artifactId>
  <version>1.0.4</version>
</dependency>
```

To add a dependency using Gradle:

```gradle
dependencies {
  implementation 'com.github.mawippel:overlapping-date-ranges:1.0.4'
}
```

## Examples

### Using LocalDate

In this case, the ```toCompare``` period overlaps the ```comparable``` one, so, it returns ```true``` as it's overlapping.
```java
LocalDate comparableInit = LocalDate.of(2019, 05, 01);
LocalDate comparableEnd = LocalDate.of(2019, 05, 05);
LocalDate toCompareInit = LocalDate.of(2019, 05, 03);
LocalDate toCompareEnd = LocalDate.of(2019, 05, 10);

boolean isOverlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
```

### Using LocalDateTime

In this case, the ```toCompare``` time period overlaps the ```comparable``` one, so, it returns ```true``` as it's overlapping.
```java
LocalDateTime comparableInit = LocalDateTime.of(2019, 05, 05, 9, 10);
LocalDateTime comparableEnd = LocalDateTime.of(2019, 05, 05, 10, 15);
LocalDateTime toCompareInit = LocalDateTime.of(2019, 05, 05, 10, 00);
LocalDateTime toCompareEnd = LocalDateTime.of(2019, 05, 05, 11, 00);

boolean isOverlapping = OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
```

### Exceptions

If some of the passed end dates is before than the initial dates, a ```DateTimeException``` will be thrown, as shown bellow

```
LocalDate comparableInit = LocalDate.of(2019, 05, 02);
LocalDate comparableEnd = LocalDate.of(2019, 05, 03);
LocalDate toCompareInit = LocalDate.of(2019, 05, 05);
LocalDate toCompareEnd = LocalDate.of(2019, 05, 04);
OverlappingVerificator.isOverlapping(comparableInit, comparableEnd, toCompareInit, toCompareEnd);
```

The behavior for the ```LocalDateTime```'s method is the same.
