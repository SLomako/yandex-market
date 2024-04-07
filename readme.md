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

</details>

<details>
<summary>Настройка переменных среды после установки</summary>

#### Для macOS:

Добавьте следующие строки в файл `.zshrc` (если используете zsh) или `.bash_profile` (если используете Bash), затем перезапустите терминал:

```bash
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH="$PATH:$ANDROID_HOME/emulator:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools"
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
```

Для применения изменений выполните в терминале:

```bash
source ~/.zshrc  # Для zsh
source ~/.bash_profile  # Для Bash
```

#### Для Windows:

Настройте переменные среды через системный интерфейс:

1. Откройте "Системные настройки" > "Дополнительные параметры системы" > "Переменные среды".
2. Создайте новую переменную среды `ANDROID_HOME` и установите её значение, например, `C:\Users\YOUR_USERNAME\AppData\Local\Android\Sdk`.
3. Добавьте пути к инструментам Android SDK в переменную среды `Path`.

Или временно установите переменные среды в командной строке (эти изменения будут действовать только в открытом окне командной строки):

```cmd
set ANDROID_HOME=C:\Users\YOUR_USERNAME\AppData\Local\Android\Sdk
set JAVA_HOME=C:\Path\To\Your\JDK17
set PATH=%PATH%;%ANDROID_HOME%\emulator;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools
```

Перезапустите командную строку или PowerShell, чтобы изменения вступили в силу.

</details>

## Запуск проекта

(Инструкции по запуску проекта будут добавлены позже)