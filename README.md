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
| [ktor-json](ktor-json/) | Ktor server with `ContentNegotiation` and `kotlinx.serialization` JSON |
| [ktor-test](ktor-test/) | Ktor `testApplication` with typed body parsing and multiple status-code scenarios |
| [ktor-websocket](ktor-websocket/) | Ktor WebSocket echo server tested via `testApplication` WS client |
| [ktor-cio](ktor-cio/) | Same JSON server as `ktor-json` but on the CIO engine instead of Netty |
| [ktor-native](ktor-native/) | Ktor CIO JSON server running on Kotlin/Native (`target = "linuxX64"`) |

## Requirements

- [kolt](https://github.com/snicmakino/kolt) installed and on PATH
- JDK 17+
- kotlinc 2.1.0+
