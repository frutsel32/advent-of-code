import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    application
}

group = "nl.sbmf21"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://gitlab.com/api/v4/projects/22815243/packages/maven") // commons
    maven("https://gitlab.com/api/v4/projects/32373878/packages/maven") // sbmathf
}

dependencies {
    implementation("nl.sbmf21:adventofcode.common:6.0.0-SNAPSHOT")
    implementation("nl.sbmf21:sbmathf:1.2.0")
    testImplementation(kotlin("test"))
}

tasks {
    withType<KotlinCompile> { kotlinOptions.jvmTarget = "17" }
    withType<Jar> { archiveBaseName.set("aoc2020") }
    withType<ShadowJar> {
        archiveClassifier.set("shaded")
        mergeServiceFiles()
    }
    jar { dependsOn(shadowJar) }
    test { useJUnitPlatform() }
}

application {
    mainClass.set("nl.sbmf21.aoc20.AocKt")
}
