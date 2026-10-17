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

class MainActivity : ComponentActivity() {
    private var status by mutableStateOf("Noch kein Datenspeicher ausgewählt.")
    private val picker = registerForActivityResult(ActivityResultContracts.OpenDocumentTree()) { uri ->
        if (uri != null) {
            contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            val root = DocumentFile.fromTreeUri(this, uri)
            val data = root?.findFile("MIRATHIA_DATA") ?: root?.createDirectory("MIRATHIA_DATA")
            if (data != null) status = "MIRATHIA_DATA ausgewählt. Bereit für den Datenspeicher."
            else status = "Ordner konnte nicht geöffnet werden."
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LazyColumn(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    item { Text("🌌 MIRATHIA", style = MaterialTheme.typography.headlineLarge) }
                    item { Text("LIVING WORLD CODEX · Android 0.1.0", style = MaterialTheme.typography.titleMedium) }
                    item { Text("Eine Welt. Sichtbare Beziehungen. Kontrollierte Änderungen.") }
                    item { Button(onClick = { picker.launch(null) }) { Text("USB-Datenspeicher auswählen") } }
                    item { Text(status) }
                    item { HorizontalDivider() }
                    item { Text("Die acht Biome", style = MaterialTheme.typography.headlineSmall) }
                    item { Text("MIRATHIA — Zentrum — Schloss der Harmonie") }
                    item { Text("VESPERIA — Norden — Sternenschloss") }
                    item { Text("AETHYRSPITZ — Nordwesten — Eiskristallthron") }
                    item { Text("SYLVANDOR — Nordosten — Smaragdthron") }
                    item { Text("AQUARELIS — Westen — Perlenschloss") }
                    item { Text("LUNAFALL — Osten — Mondgarten-Festung") }
                    item { Text("GLIMMERFURT — Südwesten — Nebelburg") }
                    item { Text("PYRAKH — Südosten — Flammenfestung") }
                    item { Text("Canon Guard: Die vollständigen Beziehungs- und Kanonprüfungen sind noch nicht implementiert. Neue Inhalte bleiben DRAFT.") }
                    item { Text("Android garantiert keinen automatischen App-Start beim Einstecken eines USB-Sticks.") }
                }
            }
        }
    }
}
