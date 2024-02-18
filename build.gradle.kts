plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "ai.sahaj"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

application {
    mainClass = "ai.sahaj.MainKt"
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}