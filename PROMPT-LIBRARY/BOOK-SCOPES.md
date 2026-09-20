# MIRATHIA — FIVE-BOOK PROMPT SCOPES

The prompt library is designed from the beginning for a five-part book.

## BOOK-01
All prompts explicitly tagged `BOOK-01` belong to Volume 1 production. Global Canon DNA remains inherited.

## BOOK-02
Volume 2 prompt layer. Reuse approved entity prompts; create new scene prompts only where the book context changes.

## BOOK-03
Volume 3 prompt layer. Preserve established visual continuity and version changes explicitly.

## BOOK-04
Volume 4 prompt layer. Maintain character, artifact, biome and architecture continuity.

## BOOK-05
Volume 5 prompt layer. Final-volume production remains bound to the same Canon Master and visual identity system.

## Reusable prompt model

A reusable prompt should be callable by ID rather than copied manually:

```text
PROMPT-ID
  + ENTITY-ID
  + BOOK-ID
  + SCENE-ID
  + IMAGE REFERENCES
  + CANON LOCKS
```

This allows one character prompt to be reused across multiple chapters and books while only the scene/context layer changes.

## Example lifecycle

```text
MIR-CHAR-AURELIAN-001
        ↓
MIR-SCENE-AURELIAN-BOOK01-001
        ↓
MIR-SCENE-AURELIAN-BOOK03-014
        ↓
MIR-SCENE-AURELIAN-BOOK05-022
```

The character identity remains stable while scene prompts evolve.

## No silent mutation

A prompt copied into a book-specific folder must retain its source prompt ID. If it diverges materially, create a new version rather than overwriting the source.
