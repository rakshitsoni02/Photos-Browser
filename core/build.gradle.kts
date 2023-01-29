import com.rax.buildsrc.applyCommonLibConfigurations
import com.rax.buildsrc.dependencyInjection
import com.rax.buildsrc.networkingDependencies
import com.rax.buildsrc.rxJava
import com.rax.buildsrc.utils.implementation

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

applyCommonLibConfigurations(nameSpaceValue = "com.rax.core")

dependencies {
    implementation(Android.annotation)
    implementation(BaseDependencies.jodaTime)
    implementation(BaseDependencies.jodaTimeConvert)
    implementation(Timber.timber)
    rxJava()
    dependencyInjection()
    networkingDependencies()
}