package de.mirathia.codex

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.documentfile.provider.DocumentFile
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    private var status by mutableStateOf("Noch kein Datenspeicher ausgewählt.")
    private var storageFile: DocumentFile? = null

    private val biomeData = listOf(
        Triple("MIRATHIA", "Zentrum", "Schloss der Harmonie"),
        Triple("VESPERIA", "Norden", "Sternenschloss"),
        Triple("AETHYRSPITZ", "Nordwesten", "Eiskristallthron"),
        Triple("SYLVANDOR", "Nordosten", "Smaragdthron"),
        Triple("AQUARELIS", "Westen", "Perlenschloss"),
        Triple("LUNAFALL", "Osten", "Mondgarten-Festung"),
        Triple("GLIMMERFURT", "Südwesten", "Nebelburg"),
        Triple("PYRAKH", "Südosten", "Flammenfestung")
    )

    private val picker = registerForActivityResult(ActivityResultContracts.OpenDocumentTree()) { uri ->
        if (uri == null) {
            status = "Keine Auswahl vorgenommen."
            return@registerForActivityResult
        }
        try {
            contentResolver.takePersistableUriPermission(
                uri,
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            )
            val root = DocumentFile.fromTreeUri(this, uri)
            val dataDir = root?.findFile("MIRATHIA_DATA") ?: root?.createDirectory("MIRATHIA_DATA")
            if (dataDir == null) {
                status = "MIRATHIA_DATA konnte nicht angelegt werden. Bitte einen beschreibbaren Ordner wählen."
                return@registerForActivityResult
            }
            val existing = dataDir.findFile("mirathia-codex.json")
            if (existing != null) {
                storageFile = existing
                status = "Vorhandene Daten gefunden. Datei bleibt unverändert: mirathia-codex.json"
            } else {
                val file = dataDir.createFile("application/json", "mirathia-codex.json")
                if (file == null) {
                    status = "JSON-Datei konnte nicht angelegt werden."
                } else {
                    contentResolver.openOutputStream(file.uri, "wt")?.use { output ->
                        output.write(createStarterData().toByteArray(Charsets.UTF_8))
                    }
                    storageFile = file
                    status = "Starter-Datensatz angelegt: 8 Biome · Status DRAFT · mirathia-codex.json"
                }
            }
        } catch (e: Exception) {
            status = "Speicherzugriff fehlgeschlagen: ${e.localizedMessage ?: "unbekannter Fehler"}"
        }
    }

    private fun createStarterData(): String {
        val biomes = JSONArray()
        biomeData.forEachIndexed { index, biome ->
            biomes.put(JSONObject()
                .put("id", "BIOM-${(index + 1).toString().padStart(2, '0')}")
                .put("name", biome.first)
                .put("richtung", biome.second)
                .put("schloss", biome.third)
                .put("status", "DRAFT"))
        }
        return JSONObject()
            .put("schemaVersion", "1.0")
            .put("project", "MIRATHIA — Living World Codex")
            .put("canonStatus", "DRAFT")
            .put("biome", biomes)
            .toString(2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LazyColumn(
                    Modifier.fillMaxSize().padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    item { Text("🌌 MIRATHIA", style = MaterialTheme.typography.headlineLarge) }
                    item { Text("LIVING WORLD CODEX · Android 0.2.0", style = MaterialTheme.typography.titleMedium) }
                    item { Text("Eine Welt. Sichtbare Beziehungen. Kontrollierte Änderungen.") }
                    item { Button(onClick = { picker.launch(null) }) { Text("USB-Datenspeicher auswählen") } }
                    item { Text(status) }
                    item { HorizontalDivider() }
                    item { Text("Die acht Biome", style = MaterialTheme.typography.headlineSmall) }
                    biomeData.forEach { biome ->
                        item { Text("${biome.first} — ${biome.second} — ${biome.third}") }
                    }
                    item { HorizontalDivider() }
                    item { Text("Speicherformat: MIRATHIA_DATA/mirathia-codex.json") }
                    item { Text("Vorhandene JSON-Dateien werden nicht überschrieben. Neue Startdaten bleiben DRAFT.") }
                    item { Text("Canon Guard: Vollständige Beziehungs- und Kanonprüfungen sind noch nicht implementiert.") }
                    item { Text("Android garantiert keinen automatischen App-Start beim Einstecken eines USB-Sticks.") }
                }
            }
        }
    }
}
