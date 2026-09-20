# MIRATHIA — PROMPT LIBRARY

## Zweck
Zentrale, versionierte Bibliothek aller Erstellungs-Prompts für Mirathia. Die Bibliothek dient als Produktionssystem für das gesamte fünfteilige Buch und trennt wiederverwendbare Prompt-DNA von individuellen Aufträgen.

## Prinzip
Ein Prompt ist ein Produktionsdatensatz, kein loses Textfragment.

Jeder Prompt erhält eine eindeutige `prompt_id`, eine Version und definierte Einsatzbereiche. Ein Prompt darf für mehrere Bücher verwendet werden, solange die Canon- und Kontinuitätsregeln unverändert bleiben.

## Verzeichnisstruktur

```text
PROMPT-LIBRARY/
├── MASTER-PROMPT-SYSTEM.md
├── 00_CORE-DNA/
├── 01_CHARACTERS/
├── 02_WEAPONS/
├── 03_URBESTIEN/
├── 04_LIGHT-WATCHERS/
├── 05_ARTIFACTS/
├── 06_BIOMES/
├── 07_FORTRESSES/
├── 08_MAPS/
├── 09_SCENES/
├── 10_BOOK-01/
├── 11_BOOK-02/
├── 12_BOOK-03/
├── 13_BOOK-04/
├── 14_BOOK-05/
├── 15_NEGATIVE-PROMPTS/
└── 16_ARCHIVE/
```

## Prompt-Kategorien

### CORE-DNA
Globale Mirathia-Regeln: CMSF, Bildsprache, technische Zielwerte, Licht, Materialität, Komposition und Kontinuität.

### ENTITY PROMPTS
Individuelle Prompts für Charaktere, Waffen, Urbestien, Lichtwächter, Artefakte, Biome und Festungen.

### SCENE PROMPTS
Szenenbezogene Produktions-Prompts, die Canon-Daten über Referenz-IDs einbinden.

### BOOK PROMPTS
Buch-spezifische Prompts für Band 1–5. Diese dürfen die globale Canon-DNA nicht überschreiben.

### NEGATIVE PROMPTS
Zentrale Ausschlussregeln plus domänenspezifische Negative Prompts.

## Prompt-Datensatz

```yaml
prompt_id: MIR-PROMPT-XXXX
name: ""
version: "1.0"
status: DRAFT | APPROVED | ARCHIVED
entity_type: character | weapon | urbestie | light_watcher | artifact | biome | fortress | scene | book
entity_id: ""
book_scope: ALL-BOOKS | BOOK-01 | BOOK-02 | BOOK-03 | BOOK-04 | BOOK-05
source_refs: []
canon_locks: []
image_refs: []
positive_prompt: ""
negative_prompt: ""
composition: ""
lighting: ""
materials: ""
continuity_rules: []
output_spec: ""
notes: ""
```

## Produktionslogik

`Canon Master → Prompt Template → Entity Data → Book Context → Scene Context → Negative Prompt → Image Output → Review → Image Architecture`

## Wichtig
Prompts dürfen keine fehlenden Lore-Daten eigenmächtig ergänzen. Fehlt eine Information, bleibt sie als offene Variable markiert oder wird aus dem zugehörigen Canon-Datensatz referenziert.

## Versionierung
Eine Änderung an einer Canon-relevanten Promptkomponente erzeugt eine neue Prompt-Version. Die alte Fassung wandert nach `16_ARCHIVE/` und bleibt nachvollziehbar.
