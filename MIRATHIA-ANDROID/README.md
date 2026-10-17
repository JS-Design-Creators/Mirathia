# MIRATHIA Living World Codex — Android

Native Android starter project for the MIRATHIA Living World Codex. The first milestone is an offline-capable Android shell with a Storage Access Framework folder picker and a starter data file. This is not yet a production-ready or tested APK.

## Build
Open this folder as a Gradle project in Android Studio, or run `gradle assembleDebug` with JDK 17 and Android SDK platform 35 installed.

## USB storage
Launch the app and tap **USB-Datenspeicher auswählen**. Android asks you to choose a folder. On a USB drive, select the intended MIRATHIA folder. The app creates `MIRATHIA_DATA` and only creates starter data when the target file does not already exist.

Android does not guarantee that an app opens automatically just because a USB drive is connected.

## Current limitations
- Starter biome view only; not the complete world database.
- Canon Guard rules and audit are not complete.
- Build and physical-device USB persistence tests must still be run.
- New content must remain DRAFT until an explicit canon approval process exists.

## Current implementation note (0.2.0)
The app creates `MIRATHIA_DATA/mirathia-codex.json` with the eight biome starter records when that file does not exist. New starter records are marked `DRAFT`. If the file already exists, the app does not overwrite it. Full loading/editing, character and artefact data, Canon Guard validation, a successful APK build, and physical-device USB tests are still pending.
