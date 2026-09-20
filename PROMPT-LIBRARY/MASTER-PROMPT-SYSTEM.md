# MIRATHIA — MASTER PROMPT SYSTEM

## 1. Global visual DNA

**Style:** CMSF — Cinematic Mythic Storybook Fantasy.

Core visual language:
- expressive, lightly stylized fantasy characters
- epic, highly detailed digital painting
- cinematic volumetric lighting
- fairytale atmosphere
- deep environmental perspective
- elegant magic effects
- luxurious fantasy-book illustration aesthetic

Technical target:
- 4K high quality
- 300 DPI
- primary scene format: landscape/panorama
- character plates and book pages: portrait where required

## 2. Prompt inheritance

Every production prompt inherits the following hierarchy:

```text
GLOBAL CMSF DNA
        ↓
MIRATHIA CANON LOCKS
        ↓
ENTITY MASTER DATA
        ↓
BOOK CONTEXT
        ↓
SCENE CONTEXT
        ↓
COMPOSITION / CAMERA
        ↓
LIGHT / MATERIAL / ATMOSPHERE
        ↓
NEGATIVE PROMPT
        ↓
OUTPUT SPECIFICATION
```

Lower layers may specialize higher layers but must not silently contradict them.

## 3. Five-book architecture

The same prompt can be reused across all five books when `book_scope: ALL-BOOKS`.

Book-specific prompts are stored separately:

- `BOOK-01` — Volume 1
- `BOOK-02` — Volume 2
- `BOOK-03` — Volume 3
- `BOOK-04` — Volume 4
- `BOOK-05` — Volume 5

A book-specific prompt may change scene context, composition, atmosphere or narrative moment, but not established character DNA, geography, artifact identity or other locked canon without a new Canon Lock.

## 4. Prompt classes

### Character
Identity, anatomy, expression, costume, materials, magic signature, pose, continuity.

### Weapon
Silhouette, construction, material, ornament, energy behavior, scale, wielder relationship.

### Urbestie
Species identity, body structure, elemental/environmental relationship, heraldic presence, scale and expression.

### Lichtwächter
Character DNA + regional identity + magic + ceremonial/guardian presentation.

### Artifact
Canonical artifact identity + material language + symbolic function + interaction with its biome.

### Biome
Landscape architecture, flora/fauna where canonized, atmospheric identity, regional palette and environmental storytelling.

### Fortress
Architecture DNA, defensive structure, regional gate identity, guardian statues, bridges, central geometry and lighting.

### Scene
Characters + location + action + emotional state + camera + environment + continuity.

## 5. Negative prompt layers

Negative prompts are modular:

`GLOBAL_NEGATIVE + DOMAIN_NEGATIVE + ENTITY_NEGATIVE + BOOK_NEGATIVE + SCENE_NEGATIVE`

This avoids repeating or accidentally deleting essential constraints.

## 6. Reference-image rule

When an approved image exists, the prompt must identify it through `image_refs` and state whether it is:

- identity reference
- costume reference
- weapon reference
- architecture reference
- composition reference
- lighting reference

Reference images are not automatically canon; their status comes from IMAGE-ARCHITECTURE.

## 7. Quality gate

Before a prompt becomes `APPROVED`, verify:

- Canon Locks respected
- entity name exact
- regional relationship correct
- visual identity consistent
- no invented lore
- negative prompt present
- book scope defined
- output specification defined
- reference images linked where available
