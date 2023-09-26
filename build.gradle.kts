import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.8"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	kotlin("plugin.lombok") version "1.9.10"
	id("io.freefair.lombok") version "8.1.0"
	java
	kotlin("jvm") version "1.9.10"
}

group = "com.gls"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.flywaydb:flyway-core")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.9.10")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor ("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
	useJUnitPlatform()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
	jvmTarget = "1.8"
}