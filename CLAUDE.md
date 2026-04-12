# kolt-examples

Example projects for [kolt](https://github.com/snicmakino/kolt).

## Structure

Each subdirectory is a standalone kolt project with its own `kolt.toml`.
Projects should be minimal — just enough to demonstrate a specific feature or pattern.

## Conventions

- Each example must have a `kolt.toml` and at least one source file under `src/`
- Each example should build and run cleanly with `kolt build && kolt run` (or `kolt test` for test-focused examples)
- Write all code, comments, and documentation in English
- Keep examples minimal — avoid unnecessary dependencies or complexity

## Adding a New Example

1. Create a new directory with a descriptive name (e.g., `serialization/`, `custom-repo/`)
2. Add `kolt.toml` and source files
3. Update the table in `README.md`
