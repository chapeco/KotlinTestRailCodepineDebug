import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object testRailClient {
    val group = "com.codepine.api"
    val name = "testrail-api-java-client"
    val version = "2.0.1"
}
object lightbendConfig {
    val group = "com.typesafe"
    val name = "config"
    val version = "1.3.4"
}

plugins {
    kotlin("jvm") version "1.3.41"
}

group = "chapeco"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    with(testRailClient) {
        implementation(group = group, name = name, version = version)
    }
    with(lightbendConfig) {
        implementation(group = group, name = name, version = version)
    }

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}