plugins {
    id("java")
    id("io.freefair.lombok") version "9.5.0"
}

group = "com.programacion"
version = "unspecified"

repositories {
    mavenCentral()
}
val restEasyVersion = "7.0.2.Final"

dependencies {
    //--REST
    implementation("org.jboss.resteasy:resteasy-client:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-json-binding-provider:${restEasyVersion}")

}

tasks.test {
    useJUnitPlatform()
}