plugins {
    application
    java

    kotlin("jvm") version "1.3.21"

    id("com.github.ben-manes.versions") version "0.21.0"
    id("com.github.johnrengelman.shadow") version "5.0.0"
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
