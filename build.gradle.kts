// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.google.dagger.hilt.android") version "2.44.2" apply false
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(BaseDependencies.gradle)
        classpath(BaseDependencies.kotlinGradle)
        classpath(BaseDependencies.detektPlugin)
    }
}

tasks.register<io.gitlab.arturbosch.detekt.Detekt>("detektAll") {
    description = "Runs Detekt on the whole project at once."
    parallel = true
    setSource(projectDir)
    include("**/*.kt", "**/*.kts")
    exclude("**/resources/**", "**/build/**")
    config.setFrom(project.file("detekt/config.yml"))
}