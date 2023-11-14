plugins {
    kotlin("jvm") version "1.9.20" apply false
    id("com.github.johnrengelman.shadow") version "8.1.1" apply false
}

group = "nl.sbmf21.aoc"

val annotationsVersion by extra { "24.0.1" }
val asciiTableVersion by extra { "0.3.2" }
val gsonVersion by extra { "2.10.1" }
val junitJupiterVersion by extra { "5.10.1" }
val reflectionsVersion by extra { "0.10.2" }
val sbmfMathVersion by extra { "1.4.2" }
val slf4jVersion by extra { "2.0.9" }

repositories {
    mavenCentral()
}

subprojects {
    if (name != "aoc-commons") {
        apply(plugin = "com.github.johnrengelman.shadow")
        apply(plugin = "application")
    }

    repositories {
        mavenCentral()
        maven("https://gitlab.sbmf21.nl/api/v4/groups/5/-/packages/maven") { name = "sbmf" }
    }

    tasks {
        withType<JavaCompile> { targetCompatibility = "17" }
    }
}