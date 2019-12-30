#!/usr/bin/env bash
./gradlew clean assembleDebug -Dorg.gradle.daemon=false -Dorg.gradle.debug=true

# -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005