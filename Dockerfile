FROM openjdk:21

WORKDIR /app

# Copy the Gradle wrapper
COPY gradlew gradlew
COPY gradle/ gradle/

# Copy the project source code
COPY src/ src/
COPY build.gradle.kts build.gradle.kts
COPY settings.gradle.kts settings.gradle.kts

RUN ./gradlew build -x test --no-daemon

CMD ["sh", "-c", "./gradlew test -Dauth-token=$AUTH_TOKEN"]
