# native-serialization

A `target = "native"` kolt project that uses `kotlinx.serialization` with
the `@Serializable` compiler plugin, and round-trips a small data class
through JSON.

## Run

```bash
kolt build
kolt run
```

Expected output:

```
encoded: {"name":"world","count":3}
decoded: Greeting(name=world, count=3)
round-trip ok
```
