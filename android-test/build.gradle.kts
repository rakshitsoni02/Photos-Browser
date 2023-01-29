import com.rax.buildsrc.applyCommonLibConfigurations
import com.rax.buildsrc.utils.implementation
import com.rax.buildsrc.utils.kapt

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

applyCommonLibConfigurations(nameSpaceValue = "com.rax.android.test")

dependencies {
    implementation(Testing.espresso)
    implementation(Hilt.hiltTesting)
}