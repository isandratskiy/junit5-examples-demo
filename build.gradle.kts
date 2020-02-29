group = "automationpractice-java-demo"
version = "1.0.0"

plugins {
    java
}

repositories {
    mavenLocal()
    jcenter()
}

object Version {
    const val FLOGGER = "0.4"
    const val JUNIT = "5.6.0"
    const val LOMBOK = "1.18.10"
}

dependencies {
    compile("com.google.flogger", "flogger-system-backend", Version.FLOGGER)
    compile("com.google.flogger", "flogger", Version.FLOGGER)
    compile("org.projectlombok", "lombok", Version.LOMBOK)
    compile("org.junit.jupiter", "junit-jupiter", Version.JUNIT)
    annotationProcessor("org.projectlombok", "lombok", Version.LOMBOK)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    register<Test>("testAll") {
    }

    withType(Test::class) {
        testLogging {
            useJUnitPlatform()

            displayGranularity = 5
            showStackTraces = false
            showExceptions = true
            showStandardStreams = false
            events("passed", "failed")
        }
    }
}