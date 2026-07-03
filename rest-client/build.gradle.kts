plugins {
    id("java")
    id("io.freefair.lombok") version "9.5.0"
}

group = "com.prograavanzada"
version = "1.0-SNAPSHOT"
val restEasyVersion = "7.0.2.Final"
val hibernateVersion = "7.4.1.Final"


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jboss.resteasy:resteasy-client:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-json-binding-provider:${restEasyVersion}")
}

tasks.test {
    useJUnitPlatform()
}

sourceSets {
    main {
        output.setResourcesDir(
            file("${buildDir}/classes/java/main")
        )
    }
}
tasks.withType<JavaCompile> {
    options.release.set(21)
}

