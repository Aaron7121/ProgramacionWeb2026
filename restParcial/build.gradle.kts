plugins {
    id("java")
    id("io.freefair.lombok") version "9.5.0"
    //id("application")
    id("com.gradleup.shadow") version "9.3.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val restEasyVersion = "7.0.2.Final"
val weldVersion = "6.0.4.Final"
val hibernateVersion = "7.4.1.Final"
val postgresqlVersion = "42.7.11"

dependencies {


    // -- REST
    // Resteasyclient para consumir de terceros
    implementation("org.jboss.resteasy:resteasy-client:${restEasyVersion}")

    implementation("org.jboss.resteasy:resteasy-core:${restEasyVersion}")
    //implementation("org.jboss.resteasy:resteasy-undertow:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-json-binding-provider:${restEasyVersion}")
    implementation("org.jboss.resteasy:resteasy-undertow-cdi:${restEasyVersion}")

    // -- CDI
    //implementation("org.jboss.weld:weld-core-impl:${weldVersion}")

    // -- Hibernate
    implementation("org.hibernate.orm:hibernate-core:${hibernateVersion}")

    implementation("org.postgresql:postgresql:${postgresqlVersion}")
    implementation("org.apache.deltaspike.modules:deltaspike-data-module-api:2.0.1")
    implementation("org.apache.deltaspike.modules:deltaspike-data-module-impl:2.0.1")




}

tasks.withType<JavaCompile> {
    options.release.set(21)
}

sourceSets {
    main {
        output.setResourcesDir(
            file("${buildDir}/classes/java/main")
        )
    }
}

tasks.test {
    useJUnitPlatform()

}

tasks.jar {
    manifest{
        attributes["Main-Class"] = "com.programacion.web.RestPostMain"
    }
}

tasks.shadowJar{
    mergeServiceFiles()
    manifest {
        attributes["Main-Class"] = "com.programacion.web.RestPostMain"
    }
}
