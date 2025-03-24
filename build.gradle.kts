plugins {
    id("java")
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.universegroup.testassignment"
version = "1.0-SNAPSHOT"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

repositories {
    mavenLocal()
    mavenCentral()
}

val restAssuredVersion = "5.5.1"
val cucumberVersion = "7.21.1"

dependencies {
    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.mockito")
    }

    // JUnit Platform
    implementation("org.junit.platform:junit-platform-suite")

    // Cucumber
    implementation(platform("io.cucumber:cucumber-bom:$cucumberVersion"))
    implementation("io.cucumber:cucumber-java")
    implementation("io.cucumber:cucumber-spring")
    implementation("io.cucumber:cucumber-junit-platform-engine")

    // Rest Assured
    implementation("io.rest-assured:rest-assured:$restAssuredVersion")

    // Jackson
    implementation("com.fasterxml.jackson.core:jackson-databind")

    // AssertJ
    implementation("org.assertj:assertj-core")

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}

tasks.test {
    useJUnitPlatform()

    val authTokenValue = System.getProperty("auth-token")
    if (authTokenValue != null) {
        systemProperty("test-assignment.auth-token", authTokenValue)
    }
}
