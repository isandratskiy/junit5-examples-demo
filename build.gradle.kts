@file:Suppress("DEPRECATION")

group = "junit5.examples.demo"
version = "1.0.0"

plugins {
    java
    id("io.freefair.lombok") version "4.1.6"
}

repositories {
    mavenLocal()
    jcenter()
}

object Version {
    const val FLOGGER = "0.4"
    const val JUNIT = "5.6.0"
    const val LOMBOK = "1.18.10"
    const val APACHE_COMMONS = "3.9"
    const val JACKSON = "2.10.3"
}

dependencies {
    compile("com.google.flogger", "flogger-system-backend", Version.FLOGGER)
    compile("com.google.flogger", "flogger", Version.FLOGGER)
    compile("org.apache.commons", "commons-lang3", Version.APACHE_COMMONS)
    compile("org.junit.jupiter", "junit-jupiter", Version.JUNIT)
    compile("com.fasterxml.jackson.core", "jackson-databind", Version.JACKSON)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType(Test::class) {
        useJUnitPlatform()

        testLogging {
            displayGranularity = 5
            showStackTraces = false
            showExceptions = true
            showStandardStreams = false
            events("passed", "failed")
        }
    }
}
