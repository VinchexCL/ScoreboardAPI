# ScoreboardAPI

ScoreboardAPI es una API para manejar scoreboards en Minecraft 1.8.8. Esta API permite configurar y animar títulos y pies de página en las scoreboards, así como utilizar placeholders de PlaceholderAPI.

## Requisitos

- Minecraft 1.8.8
- Spigot/Bukkit
- PlaceholderAPI

## Instalación

1. Clona o descarga el repositorio de `ScoreboardAPI`.
2. Incluye la dependencia en tu archivo `pom.xml`.
   
```xml

<repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/VinchexCL/ScoreboardAPI</url>
</repository>

<dependency>
    <groupId>dev.vinchex</groupId>
    <artifactId>ScoreboardAPI</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

```
## Configuración

La configuración de la scoreboard se almacena en `scoreboard.yml` en el plugin principal. Aquí tienes un ejemplo de `scoreboard.yml`:

```yaml name=scoreboard.yml

# ~ Booleans

BARS-ENABLED: true
FOOTER-ENABLED: true

# ~ Main Settings

TITLE: "&7%flower% &3&lFrost &7%flower%"
BARS: "&7&m-----------------------"
FOOTER: "&7play.frostdevelopment.club"
TIME: "EST"

# ~ Title Animated Settings

TITLE-ANIMATED:
  ENABLED: true
  INTERVAL: 0.3
  TITLE:
    - "&f&lF&3&lrost"
    - "&b&lF&f&lr&3&lost"
    - "&b&lFr&f&lo&3&lst"
    - "&b&lFro&f&ls&3&lt"
    - "&b&lFros&f&lt&3&l"
    - "&b&lFrost&f&lt"
    - "&b&lFrost"

# ~ Footer Animated Settings

FOOTER-ANIMATED:
  ENABLED: true
  INTERVAL: 2.0
  FOOTER:
    - "&7play.frostdevelopment.club"

# ~ Lines

LINES:
  - "&b&lName:"
  - "&7%triangle-right% &f%name% &7(%player_ping%ms)"
  - ""
  - "&b&lRank:"
  - "&7%triangle-right% %phoenix_player_rank%"
  - ""
  - "&b&lConnected:"
  - "&7%triangle-right% &f%bungee_all%/1000"
  - "%custom-timer%"
  - "%queue%"

# ~ Queue Format

QUEUE:
  - ""
  - "&3&lQueue&f: %server%"
  - "&f#%position%/%inqueue%"

# ~ Custom Timer Format

CUSTOM-TIMER:
  - ""
  - "%timer-name% %timer-remaining%"
