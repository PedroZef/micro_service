import java.util.Date

plugins {
	java
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "br.com.storefront"
version = "0.0.1-SNAPSHOT"
description = "Storefront"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

var mapstructVersion = "1.6.3"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	compileOnly("org.projectlombok:lombok")
	

	implementation("org.mapstruct:mapstruct-processor:$mapstructVersion")
	implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
	
	
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}
tasks.named("build") {
	doLast {
		val trigger = file("src/main/resources/trigger.txt")
		trigger.parentFile?.mkdirs()
		trigger.writeText("Build triggered at: ${Date().time}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
