# Spring Boot 2.0 시작하기 \#1
스터디겸 개인 블로그 포스팅을 위한 Spring Boot 2.0 정리다. ver 1.5 에 대한 지식도 부족한데 ver 2.0을 잠깐 살펴보니 많은것이 바뀌었기 때문에 고인물이 되지 않기위해 공부중이다.

## Spring Boot 1.5 - 뭐가 뭔지 모르겠다. 그냥 써보자.
입사 후 처음 시작한 프로젝트는 스프링부트 1.5 기반이였다. 틀이 완성된 샘플프로젝트 소스를 받아 그 안에서 작업을 해야했기에 프로젝트에 필요한 패키지들은 이미 추가되어 있었고, Rest API를 위한 라이브러리도 이미 기존 개발자분에 의해 개발되어 있었다. 여전히 그 소스를 활용하여 메인 프로젝트가 진행중이긴 하지만 개인적으로 맡았던 Spring Cloud 개발을 위해 삽질을 하며 나름 정리한 Spring Boot의 특징이 몇가지 있다.

* Spring을 사용하기 위한 설정이 간결하다.  
Spring MVC를 마지막으로 사용한 날로부터 어느덧 1년이 넘게 지나 정확한 설정은 가물가물하다. 하지만 Spring Boot에서는 이러한 설정을 따로 잡아주지 않았고 단순히 ```application.properties``` 에서 필요한 환경변수, 설정을 추가하여 비교적 쉽게 사용할 수 있다.

* 독립된 Web Container로써 실행합니다.  
기존 Spring MVC 에서는 웹 컨테이너에 빌드되어 웹서버 구동 시 컨테이너에 포함된 모든 프로그램이 웹서버에 실행되었다면, Spring Boot는 각각 독립된 컨테이너에 빌드되어 해당 프로그램을 실행하기 때문에 클라우드 환경에서의 마이크로서비스, Docker와 같은 컨테이너 환경에서 사용하기 좋다. 여기에 Nexflix OSS를 올린 Spring Cloud는 마이크로 서비스에 필요한 API gateway, Service Discovery, High Availability 등 을 지원한다.

## Spring Boot2.0 - 음? 내가 알던거랑 많이 달라졌네?
1. Boot 2.0은 비동기 통신을 지원하면서 MSA에 적합한 구조로 변화하였다.  

    * 마이크로서비스에서 동기식 통신을 하는것은 심각한 성능저하를 일으킨다. 이제서야 생각났지만 그동안 Boot 1.5 Spring Cloud MSA 자료를 찾으면서 봤던 여러 기업들의 적용기에서 역시 기존 Monolithic 구조가 성능상 더  빠르지만 레거시 시스템이 거대해 짐에 따라 개발, 운영에 있어 생산성이 떨어졌기 때문에 MSA를 적용한다고 밝혀져 있었다.  

    * 마이크로서비스는 서비스간 통신을 위한 소켓을 잡게 되는데, 동기식 통신에서는 요청에 대한 응답을 받을때 까지 해당 소켓을 계속 잡고있는다. 이 부분이 기존 Boot의 단점이다. 하지만 Boot2.0 업데이트로 이러한 문제가 어느정도 해소되었다. 비동기 통신의 지원으로 각 서비스들은 응답을 받을때 까지 기다려야할 필요가 없어졌고, 더욱 MSA 환경에 적합한 프레임웍으로 변화한것.

2. Spring 5와 Spring Boot 2.0의 가장 큰 변화는 **Reactive**라고 한다. Reactive, Web-Flux(RestTemplate의 deprecate...) 이 부분은 공부를 하면서 계속 정리할 필요가 있을듯...

## maven vs gradle
maven을 사용하면서 불편했던 점은 패키지 파일들은 다운받은 뒤 컴파일을 하기 때문에 실행 속도가 상당히 느리고 xml 포맷을 사용하기 때문에 가독성이 상당히 좋지가 않았다. 그리고 ant 빌드를 따로 해줘야 하기 때문에 상당히 번거롭다.  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.dvparty</groupId>
	<artifactId>1.5 demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>1.5 demo</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.13.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>
```
  
하지만 gradle은 groovy 스크립트를 사용하여, 패키지 파일들을 따로 다운받지 않아도 컴파일 시점에 함께 빌드하여 속도가 빠르고 빌드과정까지 한번에 이루어져 상대적으로 편리하고 가독성이 좋다.
```gradle
buildscript {
	ext {
		springBootVersion = '2.0.2.RELEASE'
	}
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
	}
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group = 'com.dvparty'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = 1.8

repositories {
	mavenCentral()
}


dependencies {
	compile('org.springframework.boot:spring-boot-starter-web')
	testCompile('org.springframework.boot:spring-boot-starter-test')
}
```

위 두개의 spring boot 패키지 설정파일의 버전은 다르지만 spring-boot-starter-web을 만을 사용하는 프로젝트이다. 한눈에 봐도 가독성에서 gradle이 월등히 뛰어나다는 것을 알수 있고 DI한 패키지가 많을수록 빌드에 소비되는 시간 역시 gradle이 더 뛰어나다.