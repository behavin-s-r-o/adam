# Project: [Název vašeho projektu]

## Kontext
Interní firemní systém / microservices backend. Tým 4 vývojářů + 2 virtuální AI členové (EVA, MAX).

## Tech Stack
- **Backend:** Java 21, Spring Boot 3.x, Gradle/Maven
- **Frontend:** React 18 / Angular 17, TypeScript
- **Databáze:** PostgreSQL (nebo vaše DB)
- **Testy:** JUnit 5, Mockito, Cypress
- **Cloud:** Google Cloud Platform (Cloud Run, Cloud Build)
- **Repository:** GitHub
- **Issue tracker:** Jira

## Architektura
- Mikroservisní architektura
- REST API (OpenAPI/Swagger dokumentace)
- Každý microservice má vlastní repozitář nebo modul
- Společné knihovny v /libs nebo jako Maven/Gradle dependency

## Kódovací standardy

### Java / Spring Boot
- Package struktura: `cz.firma.projekt.{modul}.{vrstva}`
- Vrstvy: controller → service → repository → entity
- Pojmenování: PascalCase pro třídy, camelCase pro metody a proměnné
- Každý REST endpoint má Swagger anotace (@Operation, @ApiResponse)
- Service vrstva VŽDY přes interface (např. UserService → UserServiceImpl)
- Dependency injection přes constructor (nikdy @Autowired na field)
- Exceptions: vlastní exception hierarchie dědící z RuntimeException
- DTOs pro API komunikaci, nikdy entity přímo v controlleru

### React / Angular / TypeScript
- Funkcionální komponenty s hooks (žádné class components)
- TypeScript strict mode — žádné `any`
- Pojmenování: PascalCase pro komponenty, camelCase pro funkce
- Sdílené typy v /types nebo /models adresáři
- API volání přes dedikovaný service layer (ne přímo v komponentách)

## Testovací pravidla
- **Minimální pokrytí:** 80% pro nový kód
- **JUnit 5:** Každý service a controller má svůj test
- **Mockito:** Pro mockování závislostí v unit testech
- **Cypress:** E2E testy pro kritické user flows
- **Naming:** `test_shouldReturnUser_whenUserExists()`
- **Arrange-Act-Assert** vzor v každém testu
- Testy se VŽDY píší PŘED nebo SPOLEČNĚ s implementací (TDD)

## Git Workflow
- Branch naming: `feature/JIRA-123-short-description`, `bugfix/JIRA-456-fix-name`
- Commit messages: `feat(JIRA-123): add user authentication endpoint`
- Conventional commits: feat, fix, refactor, test, docs, chore
- Vždy vytvářet PR — nikdy pushovat přímo do main/develop
- PR musí projít testy a mít alespoň 1 review

## Bezpečnost
- Žádné hardcoded credentials — vždy environment variables nebo Secret Manager
- OWASP Top 10 dodržovat
- Input validace na API vrstvě (@Valid, @NotNull, @Size)
- Autorizace přes Spring Security
- CORS konfigurace explicitně definovaná

## Deployment
- **Staging:** Cloud Run (auto-deploy z develop branche)
- **Produkce:** Cloud Run (manuální schválení deploymentu)
- Docker image: multi-stage build (builder + runtime)
- Health check endpoint: /actuator/health

## AI Agenti — Pravidla
- Vždy dodržuj výše uvedené standardy
- Před implementací VŽDY vytvoř nebo přečti specifikaci
- Nikdy neměň existující testy bez vysvětlení proč
- Při nejistotě SE ZEPTEJ — radši eskaluj než hádej
- Loguj rozhodnutí do .sdlc/knowledge/decisions.md

