import java.lang.Module

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinx.kover)
    kotlin("kapt")
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.hilt)
}

val keystoreProperties = rootDir.loadGradleProperties("signing.properties")

android {
//    signingConfigs {
//        create(BuildType.RELEASE) {
//            // Remember to edit signing.properties to have the correct info for release build.
//            storeFile = file("../config/release.keystore")
//            storePassword = keystoreProperties.getProperty("KEYSTORE_PASSWORD") as String
//            keyPassword = keystoreProperties.getProperty("KEY_PASSWORD") as String
//            keyAlias = keystoreProperties.getProperty("KEY_ALIAS") as String
//        }
//
//        getByName(BuildType.DEBUG) {
//            storeFile = file("../config/debug.keystore")
//            storePassword = "oQ4mL1jY2uX7wD8q"
//            keyAlias = "debug-key-alias"
//            keyPassword = "oQ4mL1jY2uX7wD8q"
//        }
//    }

    buildFeatures {
        buildConfig = true
    }

    namespace = "com.deny.carousell"
    compileSdk = Versions.ANDROID_COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.deny.carousellsample"
        minSdk = Versions.ANDROID_MIN_SDK_VERSION
        targetSdk = Versions.ANDROID_TARGET_SDK_VERSION
        versionCode = Versions.ANDROID_VERSION_CODE
        versionName = Versions.ANDROID_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
//            signingConfig = signingConfigs[BuildType.RELEASE]
            buildConfigField("String", "BASE_API_URL", "\"https://storage.googleapis.com/carousell-interview-assets/android/\"")
        }

        getByName(BuildType.DEBUG) {
            // For quickly testing build with proguard, enable this
            isMinifyEnabled = false
//            signingConfig = signingConfigs[BuildType.DEBUG]
            buildConfigField("String", "BASE_API_URL", "\"https://storage.googleapis.com/carousell-interview-assets/android/\"")
        }
    }
//    flavorDimensions += Flavor.DIMENSION_VERSION
//    productFlavors {
//        create(Flavor.STAGING) {
//            applicationIdSuffix = ".staging"
//        }
//
//        create(Flavor.PRODUCTION) {}
//    }

    sourceSets["test"].resources {
        srcDir("src/test/resources")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_18.toString()
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER_VERSION
    }

    buildFeatures {
        compose = true
    }

    packagingOptions {
        jniLibs {
            // Resolve "libmockkjvmtiagent.so" https://github.com/mockk/mockk/issues/297#issuecomment-901924678
            useLegacyPackaging = true
        }
        resources.excludes.add("META-INF/*")
    }

    lint {
        checkDependencies = true
        xmlReport = true
        xmlOutput = file("build/reports/lint/lint-result.xml")
    }

    testOptions {
        unitTests {
            // Robolectric resource processing/loading https://github.com/robolectric/robolectric/pull/4736
            isIncludeAndroidResources = true
        }
        // Disable device's animation for instrument testing
        // animationsDisabled = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(Modules.DATA))
    implementation(project(Modules.DOMAIN))

    implementation(libs.androidx.core.ktx)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.material)
    implementation(libs.coil)

    implementation(libs.androidx.navigation.compose)
    implementation(libs.accompanist.systemuicontroller)

    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.timber)
    
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.android)

    debugImplementation(libs.library)
    releaseImplementation(libs.library.no.op)

    // Unit test
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.mockk)
    testImplementation(libs.junit)
    testImplementation(libs.turbine)

    // UI test with Robolectric
    testImplementation(platform(libs.androidx.compose.bom))
    testImplementation(libs.androidx.ui.test.junit4)
    testImplementation(libs.androidx.rules)
    testImplementation(libs.robolectric)

    // UI test
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.androidx.rules)
    androidTestImplementation(libs.mockk.android)

    /*testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)*/

}