
group = "junit5.examples.demo"
version = "1.0.0"

plugins {
    java
    id("io.freefair.lombok") version "4.1.6"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.apacheCommons)
    implementation(libs.junit)
    implementation(libs.jackson)
}

tasks {
    withType(Test::class) {
        useJUnitPlatform()

        testLogging {
            displayGranularity = 2
            showStackTraces = false
            showExceptions = true
            showStandardStreams = false
            events("passed", "failed")
        }
    }
}
