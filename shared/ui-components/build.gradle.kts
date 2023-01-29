import com.rax.buildsrc.applyCommonLibConfigurations
import com.rax.buildsrc.composeDependencies
import com.rax.buildsrc.utils.implementation

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}
android {
    buildFeatures.apply {
        compose = true
    }
}
applyCommonLibConfigurations(nameSpaceValue = "com.rax.shared.ui.components")

dependencies {
    composeDependencies()
    implementation(Android.materialDesign)
    implementation(Coil.coilCompose)
}