import com.rax.buildsrc.applyCommonAppConfigurations
import com.rax.buildsrc.presentationDependencies

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

applyCommonAppConfigurations(nameSpaceValue = "com.rax")
presentationDependencies()

dependencies {
    implementation(project(":photos-overview:presentation"))
    implementation(Coil.coilCompose)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}