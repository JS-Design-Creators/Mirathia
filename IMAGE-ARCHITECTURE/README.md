# MIRATHIA — IMAGE ARCHITECTURE

**System:** Mirathia Data Hub  
**Purpose:** Canonical management of all visual assets, references, production variants and archive material.

## Core rule
Every visual asset must be traceable to a canonical Mirathia entity. Images are evidence/references or production outputs; they do not silently redefine canon.

## Storage layers

### 01_CANON
Approved visual references that represent the current canonical appearance.

### 02_PRODUCTION
Working renders, prompt outputs, design studies, variants and iteration material.

### 03_ARCHIVE
Superseded visuals retained for provenance. Archived material must never be treated as current canon without an explicit Canon Lock.

## Entity domains

- `CHARACTERS/` — 16-character visual identities
- `WEAPONS/` — 80 weapon references
- `URBESTIEN/` — 8 Urbestien
- `LIGHT-WATCHERS/` — 8 Lichtwächter
- `ARTIFACTS/` — 8 Biom-Artefakte + Sphäre der Harmonie
- `BIOMES/` — Mirathia + 7 outer biomes
- `FORTRESSES/` — castle/fortress architecture and regional strongholds
- `MAPS/` — world, regional, city and route maps
- `SCENES/` — book-scene visual references
- `BOOKS/` — volume-specific art packages for the five-part book

## Image record standard
Each visual asset should be accompanied by a metadata record containing:

- `asset_id`
- `entity_id`
- `entity_type`
- `canon_status`
- `version`
- `source`
- `prompt_id`
- `book_scope`
- `scene_scope`
- `created_at`
- `approved_at`
- `notes`

## Canon status

`CANON` → approved current reference  
`PRODUCTION` → working material  
`VARIANT` → intentional alternative  
`ARCHIVE` → superseded historical material  
`PENDING` → awaiting review

## Five-book compatibility
Every production image may be assigned to one or more volumes:

- `BOOK-01`
- `BOOK-02`
- `BOOK-03`
- `BOOK-04`
- `BOOK-05`
- `ALL-BOOKS`

## Visual continuity rule
A later book may reuse an approved visual reference from an earlier book. A changed appearance requires an explicit version change and continuity note.
