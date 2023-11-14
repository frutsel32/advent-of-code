import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
}

val annotationsVersion: String by rootProject.extra
val junitJupiterVersion: String by rootProject.extra

dependencies {
    implementation(project(":aoc-commons"))
    implementation("org.jetbrains:annotations:$annotationsVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks {
    withType<Jar> { archiveBaseName.set("aoc2015") }
    withType<ShadowJar> {
        archiveClassifier.set("shaded")
        mergeServiceFiles()
    }
    jar { dependsOn(shadowJar) }
    test { useJUnitPlatform() }
}

application {
    mainClass.set("nl.sbmf21.aoc15.Aoc")
}