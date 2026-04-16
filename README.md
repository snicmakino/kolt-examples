# kolt-examples

Example projects for [kolt](https://github.com/snicmakino/kolt) — a lightweight Kotlin build tool.

Each subdirectory is a standalone kolt project. To try one:

```bash
cd hello-world
kolt build
kolt run
```

## Examples

| Directory | Description |
|---|---|
| [hello-world](hello-world/) | Minimal Hello World example |
| [native-serialization](native-serialization/) | `target = "native"` with `kotlinx.serialization` `@Serializable` round-trip |
| [http-client](http-client/) | OkHttp dependency with MockWebServer tests |

## Requirements

- [kolt](https://github.com/snicmakino/kolt) installed and on PATH
- JDK 17+
- kotlinc 2.1.0+
