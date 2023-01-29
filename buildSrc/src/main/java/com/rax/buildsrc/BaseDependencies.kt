package com.rax.buildsrc

import Android
import BaseDependencies
import Compose
import Hilt
import Retrofit
import RxJava
import Testing
import com.rax.buildsrc.utils.*
import org.gradle.api.artifacts.dsl.DependencyHandler


/**
 * Dependencies always required for Android modules
 */

fun DependencyHandler.commonPresentationDependencies() {
    implementation(Android.appcompat)
    implementation(Android.fragmentKtx)
    implementation(Android.coreKtx)
    implementation(Android.materialDesign)
    implementation(Android.activityCompose)
    implementation(Android.viewModelCompose)
    implementation(Android.accompanistSystemUI)
}

/**
 * Dependencies for RxJava
 */
fun DependencyHandler.rxJava() {
    implementation(RxJava.rxJava)
    implementation(RxJava.rxAndroid)
}

/**
 * Dependencies for project base
 */
fun DependencyHandler.baseDependencies() {
    implementation(BaseDependencies.kotlin)
}

/**
 * Dependency injection
 */
fun DependencyHandler.dependencyInjection() {
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.daggerCompiler)
    kapt(Hilt.hiltCompiler)
}

/**
 * Networking dependencies
 */
fun DependencyHandler.networkingDependencies() {
    implementation(Retrofit.retrofit)
    implementation(Retrofit.okhttpLogging)
    implementation(Retrofit.moshi)
    implementation(Retrofit.rxJavaAdapter)
    kapt(Retrofit.moshiCodeGen)
}

/**
 * Compose dependencies
 */
fun DependencyHandler.composeDependencies() {
    implementation(platform(Compose.composeBom))
    implementation(Compose.composeMaterial)
    implementation(Compose.composeAnimation)
    implementation(Compose.composeTooling)
    implementation(Compose.composeUi)
    implementation(Compose.composeToolingPreview)
    implementation(Compose.composeFoundation)
    implementation(Compose.composeRuntime)
    implementation(Compose.composeFonts)
}

/**
 * Generic instrumented test related dependencies
 */
fun DependencyHandler.genericTestDependencies() {
    testImplementation(Testing.mockk)
    testImplementation(Testing.jUnit)
    testImplementation(Testing.mockito)
    testImplementation(Testing.core)
}

/**
 * Generic instrumented test related dependencies
 */
fun DependencyHandler.genericAndroidTestDependencies() {
    androidTestImplementation(Testing.extJUnit)
    androidTestImplementation(Testing.espresso)
    androidTestImplementation(Hilt.hiltTesting)
    kaptAndroidTest(Hilt.daggerCompiler)
}
