import java.util.Date

plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "br.com.warehouse"
version = "0.0.1-SNAPSHOT"
description = "Project Warehouse"

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

val mapstructVersion = "1.5.5.Final"

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
		var trigger = file("src/main/resources/trigger.txt")
		trigger.parentFile?.mkdirs()
		trigger.writeText("Build triggered at: ${Date().time}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
