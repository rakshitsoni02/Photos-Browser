import com.rax.buildsrc.applyCommonLibConfigurations
import com.rax.buildsrc.utils.implementation

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

applyCommonLibConfigurations(nameSpaceValue = "com.rax.test")

dependencies {
    implementation(project(":core"))
    implementation(Android.appcompat)
}