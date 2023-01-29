import com.rax.buildsrc.applyCommonLibConfigurations
import com.rax.buildsrc.presentationDependencies
import com.rax.buildsrc.testDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

applyCommonLibConfigurations(nameSpaceValue = "com.rax.photos.overview.presentation")
presentationDependencies()
testDependencies()

dependencies {
    implementation(project(":photos-overview:data"))
}
