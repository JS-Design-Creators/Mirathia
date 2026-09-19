# MIRATHIA — DATA HUB

**Status:** INITIALIZED  
**Version:** 1.0  
**Date:** 2026-09-20  
**Repository:** `JS-Design-Creators/Mirathia`

## Purpose

This repository is the versioned technical/master layer for Mirathia. It receives harmonized, traceable project data from Notion, Airtable, Linear and the supplied source documents. It is not treated as a silent replacement for the source systems.

## Source hierarchy used for the initial build

1. **Current Notion master structures** — current worldbuilding organization, canon/production rules and fortress design DNA.
2. **Airtable MIRATHIA — MASTER-WELTSTRUKTUR** — structured entity data and status fields.
3. **Supplied YesWriter PDFs** — source material and production/database specifications.
4. **Linear** — synchronization, verification, cleanup and production governance.
5. **GitHub** — versioned harmonized master representation.

## Core systems

| System | Function |
|---|---|
| Notion | Canon, lore, production definitions and reference documentation |
| Airtable | Structured entity data and status fields |
| Linear | Tasks, conflicts, verification and synchronization governance |
| GitHub | Versioned master files and technical architecture |
| Novelist / YesWriter | Narrative production and manuscript data |

## Canon policy

- Missing information is recorded as **OPEN**.
- Contradictory information is recorded as **CONFLICT**.
- Production definitions are not silently promoted to historical lore.
- Older structures are retained as historical/source material and must not be silently merged into the current canon.
- No new lore is invented during harmonization.

## Current canonical backbone

- 8 Biomes: Mirathia + 7 outer biomes.
- 8 Biom-Artefacts.
- 9th Artefact: **Sphäre der Harmonie**, formed by the union of all 8 Biom-Artefacts.
- 8 Urbestien, one assigned to each biome.
- 8 Lichtwächter.
- 16-character structure in the current Notion master.
- 8 canonical fortress identities.
- CMSF — Cinematic Mythic Storybook Fantasy as the binding visual style for fortress production.

## Current Mirathia gate rule

At each of the seven outer gates of Mirathia, the **Urbestie of Mirathia, Aureon — Königslöwe**, stands together with the **regional Urbestie**. Both are represented as monumental petrified guardian figures. The pair is fixed to the corresponding gate and must not be replaced by generic lion/tiger statues.

## Repository structure

```text
Mirathia/
├── DATA-HUB/
├── CANON/
├── BIOMES/
├── URBESTIEN/
├── ARTEFACTS/
├── FORTRESSES/
├── CHARACTERS/
├── MAPS/
├── CHRONICLES/
├── PROMPTS/
├── DATABASE/
└── BOOK/
```

## Readiness gate

The manuscript is not considered officially ready for Chapter 1 until the project-defined overall writing readiness reaches at least **85%** and critical canon conflicts are resolved.
