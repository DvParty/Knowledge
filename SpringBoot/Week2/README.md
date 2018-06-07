# Spring Boot 2.0 시작하기 \#2
일주일정도 바쁘고 의욕도 없어서 이제 다시 시작.. Week1 에서 생성한 Spring Boot Application을 계속 이용할 것이다.

## Spring Boot의 시작 지점
우선 start.spring.io 에서 생성한 스프링부트 프로젝트는 다음과 같은 디렉토리를 갖는다.
```
com
    +- dvparty15
        +- demo
            +- Application.java
```
여기서 Application.java는 우리가 흔히 JAVA에서 사용하는 main 메소드가 있다. 해당 클래스에는 ```@SpringBootApplication``` 이라는 어노테이션이 추가되어 있는데 이 main 메소드를 실행 시 tomcat이 실행되어 독립된 컨테이너로써 웹 어플리케이션을 실행한다.

## 그렇다면 컨트롤러는?
기본적으로 스프링부트는 스프링에 웹 컨테이너로 포장되어 있는 형태다. 즉, 스프링을 사용할때와 같다는 의미이다. 기존 스프링에서 ```@Controller``` 어노테이션을 추가하여 컨트롤러를 선언한것과 똑같다. 앞서 설명한 Main 클래스에 적용해도 상관 없지만, 컨트롤러 클래스를 분리할 경우 메인 클래스 하위 패키지에 컨트롤러는 둔다.
```
com
    +- dvparty15
        +- demo
            +- Application.java
            |
            +- controller
                +- Democontroller.java
```