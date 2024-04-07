# Демо проект по автоматизации мобильного приложения **Яндекс-Маркет**

![Яндекс-Маркет](.github/logo/logo.png)

## Настройка проекта

### Предварительная проверка

<details>
<summary>Перед началом работы проверьте следующие компоненты:</summary>

#### Проверка установленных компонентов

Откройте терминал (на macOS) или командную строку/PowerShell (на Windows) и выполните следующие команды:

```bash
java -version       # Проверка Java
node -v             # Проверка Node.js
npm -v              # Проверка NPM
appium -v           # Проверка Appium
echo $ANDROID_HOME  # Проверка пути Android SDK (macOS)
echo $JAVA_HOME     # Проверка пути Java JDK (macOS)
echo %ANDROID_HOME% # Проверка пути Android SDK (Windows)
echo %JAVA_HOME%    # Проверка пути Java JDK (Windows)
adb version         # Проверка Android Debug Bridge
```

#### Проверка переменных среды

##### Для macOS:

```bash
echo "JAVA_HOME: $JAVA_HOME"
echo "ANDROID_HOME: $ANDROID_HOME"
echo "Node.js version: $(node -v)"
echo "NPM version: $(npm -v)"
echo "Appium version: $(appium -v)"
adb version # Проверка версии Android Debug Bridge
```

##### Для Windows:

```cmd
echo "JAVA_HOME: %JAVA_HOME%"
echo "ANDROID_HOME: %ANDROID_HOME%"
node -v # Проверка версии Node.js
npm -v # Проверка версии NPM
appium -v # Проверка версии Appium
adb version # Проверка версии Android Debug Bridge
```

</details>

### Установка необходимого ПО и настройка путей

<details>
<summary>Если некоторые компоненты не установлены, следуйте этим инструкциям:</summary>

1. **Java Development Kit (JDK):** [Скачайте и установите JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. **Node.js и NPM:** [Скачайте и установите Node.js (включает NPM)](https://nodejs.org/en/)
3. **Android Studio:** [Скачайте и установите Android Studio](https://developer.android.com/studio)
4. **Appium:** В терминале выполните команду `npm install -g appium`

Настройте переменные среды по вышеуказанным инструкциям.

</details>
