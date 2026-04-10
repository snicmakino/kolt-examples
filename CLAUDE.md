# keel-examples

Example projects for [keel](https://github.com/snicmakino/keel).

## Structure

Each subdirectory is a standalone keel project with its own `keel.toml`.
Projects should be minimal — just enough to demonstrate a specific feature or pattern.

## Conventions

- Each example must have a `keel.toml` and at least one source file under `src/`
- Each example should build and run cleanly with `keel build && keel run` (or `keel test` for test-focused examples)
- Write all code, comments, and documentation in English
- Keep examples minimal — avoid unnecessary dependencies or complexity

## Adding a New Example

1. Create a new directory with a descriptive name (e.g., `serialization/`, `custom-repo/`)
2. Add `keel.toml` and source files
3. Update the table in `README.md`
