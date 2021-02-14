import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    application
}

group = "me.kakap"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://www.dcm4che.org/maven2")
}

dependencies {
    val dcm4cheToolVersion = "5.23.0"
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation(kotlin("stdlib"))
    //PixelMed
    implementation(files("/src/libs/pixelmed.jar"))
    //DCM4CHE
    implementation("org.dcm4che:dcm4che-parent:5.23.0")
    implementation("org.dcm4che:dcm4che-core:5.23.0")
    implementation("org.dcm4che.tool:dcm4che-tool-pdf2dcm:${dcm4cheToolVersion}")
    implementation("org.dcm4che.tool:dcm4che-tool:${dcm4cheToolVersion}")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}