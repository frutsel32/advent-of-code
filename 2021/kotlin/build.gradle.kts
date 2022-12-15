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
    maven("https://gitlab.com/api/v4/projects/32373878/packages/maven") // sbmathf
}

dependencies {
    implementation(project(":commons"))
    implementation("nl.sbmf21:sbmathf:1.2.1")
    testImplementation(kotlin("test"))
}

tasks {
    withType<KotlinCompile> { kotlinOptions.jvmTarget = "17" }
    withType<Jar> { archiveBaseName.set("aoc2021") }
    withType<ShadowJar> {
        archiveClassifier.set("shaded")
        mergeServiceFiles()
    }
    jar { dependsOn(shadowJar) }
    test { useJUnitPlatform() }
}

application {
    mainClass.set("nl.sbmf21.aoc21.AocKt")
}
