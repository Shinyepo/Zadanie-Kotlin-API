# Zadanie z REST API przy użyciu Kotlin'a

Program pobierający listę postów z serwisu https://jsonplaceholder.typicode.com i zapisujący każdy post w osobnym pliku.

Posty zapisywane są w folderze  `~/posts/` pod nazwą `<id_postu>.json`

## Stworzony przy użyciu:
- Kotlin
- Gradle
- Ktor Client
- Ktor Client Content Negotiation
- Ktor Serialization Kotlinx Json
- SLF4J + Logback

## Struktura projektu
- `src/main/kotlin`
  - `Main.kt` - Entry point
  - `services/PostService.kt` - Serwis odpowiedzialny za pobranie postów z API https://jsonplaceholder.typicode.com
  - `models/Post.kt` - Model danych zwrotnych z API
  - `utils/FileUtils.kt` - Funkcja pomocnicza zapisująca post do pliku
  - `network/HttpClientManager.kt` - Manager klienta HTTP
- `resources/logback.xml` - Plik konfiguracyjny Logów

## Wymagania
- JDK 21+
- Gradle 8.5+
