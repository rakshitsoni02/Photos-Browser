import com.rax.buildsrc.applyCommonLibConfigurations
import com.rax.buildsrc.dataDependencies
import com.rax.buildsrc.testDependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

applyCommonLibConfigurations(nameSpaceValue = "com.rax.photos.overview.data")
dataDependencies()
testDependencies()

dependencies {
    api(project(":photos-overview:domain"))
}