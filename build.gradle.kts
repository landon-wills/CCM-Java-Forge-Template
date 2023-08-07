plugins {
    id("java")
    id("dev.architectury.loom") version("0.12.0-SNAPSHOT")
    id("architectury-plugin") version("3.4-SNAPSHOT")
}

group = "org.example"
version = "1.0-SNAPSHOT"

architectury {
    platformSetupLoomIde()
    forge()
}

loom {
    silentMojangMappingsLicense()

    mixin {
        defaultRefmapName.set("mixins.${project.name}.refmap.json")
    }
}

repositories {
    mavenCentral()
    maven(url = "https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
    maven("https://maven.impactdev.net/repository/development/")
}

dependencies {
    minecraft("net.minecraft:minecraft:1.19.2")
    mappings(loom.officialMojangMappings())
    forge("net.minecraftforge:forge:1.19.2-43.2.0")

    modImplementation("dev.architectury", "architectury-forge", "6.5.69")
    modImplementation("com.cobblemon:forge:1.3.3+1.19.2-SNAPSHOT") {
        isTransitive = false
    }

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}