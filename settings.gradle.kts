pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android Hub"
include(":app")
include(":core:ui")
include(":core:data")
include(":core:database")
include(":feature:hub")
include(":core:testing")
include(":test-app")
