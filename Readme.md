
# Möglichkeit 1

`check(everyType()).isPublic();`
`check(everyType()).following(...).is(not(...));`
`check(everyMethod()).following(...).is(...);`

# Möglichkeit 2
`check(Filter).is(Condition);`



```java
@Architecture()
public void foo() {
  assertThat(everyMethod()).is()
}
```


Element: CtElement.class + FQN \n
expected: methodName \n
actual: methodName \n