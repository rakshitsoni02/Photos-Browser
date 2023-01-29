import com.rax.buildsrc.applyCommonLibConfigurations
import com.rax.buildsrc.domainDependencies
import com.rax.buildsrc.testDependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

applyCommonLibConfigurations(nameSpaceValue = "com.rax.photos.overview.domain")
domainDependencies()
testDependencies()