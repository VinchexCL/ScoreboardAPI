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
# Supports 32 Chars & PlaceholderAPI

# ~ Booleans

BARS-ENABLED: true
FOOTER-ENABLED: true

# ~ Main Settings

TITLE: "&7%flower% &3&lOrbit &7%flower%"
BARS: "&7&m-----------------------"
FOOTER: "&7play.frostcraft.club"
TIME: "EST"

# ~ Title Animated Settings

TITLE-ANIMATED:
  ENABLED: true
  INTERVAL: 0.3
  TITLE:
    - "&f&lF&3&lrostCraft"
    - "&b&lF&f&lr&3&lostCraft"
    - "&b&lFr&f&lo&3&lstCraft"
    - "&b&lFro&f&ls&3&ltCraft"
    - "&b&lFros&f&lt&3&lCraft"
    - "&b&lFrost&f&lC&3&lraft"
    - "&b&lFrostC&f&lr&3&laft"
    - "&b&lFrostCr&f&la&3&lft"
    - "&b&lFrostCra&f&lf&3&lt"
    - "&b&lFrostCraf&f&lt"
    - "&b&lFrostCraft"
    - "&b&l"
    - "&7%flower% &b&lFrostCraft &f&lHub &7%flower%"
    - "&7%flower% &b&lFrostCraft &f&lHub &7%flower%"
    - "&7%flower% &b&lFrostCraft &f&lHub &7%flower%"
    - "&3&l"
    - "&7%flower% &b&lFrostCraft &f&lHub &7%flower%"
    - "&7%flower% &b&lFrostCraft &f&lHub &7%flower%"
    - "&7%flower% &b&lFrostCraft &f&lHub &7%flower%"
    - "&3&l"

# ~ Footer Animated Settings

FOOTER-ANIMATED:
  ENABLED: true
  INTERVAL: 1.5
  FOOTER:
    - "&7ts.frostcraft.club"
    - "&7play.frostcraft.club"
    - "&7discord.gg/Jd2wMvj2mp"
    - "&7frostcraft-store.tebex.io"

# ~ Lines

LINES:
  - "&b&lNombre:"
  - "&7%triangle-right% &f%name% &7(%player_ping%ms)"
  - ""
  - "&b&lRango:"
  - "&7%triangle-right% %phoenix_player_rank%"
  - ""
  - "&b&lMonedas:"
  - "&7%triangle-right% &f%pxcosmetics_player_coins%"
  - ""
  - "&b&lConectados:"
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
