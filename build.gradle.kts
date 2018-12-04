plugins {
    application
    java

    kotlin("jvm") version "1.3.10"

    id("com.github.ben-manes.versions") version "0.20.0"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
}

application {
    mainClassName = "com.bitquabit.kortune.Kortune"
}

repositories {
    jcenter()
}
