<h1 align="center">Демо проект по автоматизации мобильного приложения <strong>Яндекс-Маркет</strong></h1>

<p align="center">
  <img src=".github/logo/logo.png" alt="Яндекс-Маркет">
</p>

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
adb version         # Проверка Android Debug Bridge
echo $ANDROID_HOME  # Проверка пути Android SDK (macOS)
echo $JAVA_HOME     # Проверка пути Java JDK (macOS)
echo %ANDROID_HOME% # Проверка пути Android SDK (Windows)
echo %JAVA_HOME%    # Проверка пути Java JDK (Windows)
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

<ol>
    <li><strong>Скачайте проект из репозитория</strong> и откройте его в Android Studio или вашей IDE.</li>
    <li><strong>Запустите Appium Server</strong> открыв терминал и выполните команду:
        <pre><code>appium --base-path /wd/hub</code></pre>
    </li>
    <li><strong>Настройте параметры устройства</strong> в вашем тестовом коде или в файле конфигурации:</li>
</ol>

<p>Для запуска на эмуляторе, используйте параметры по умолчанию или настройте их в соответствии с конфигурацией вашего эмулятора. Для запуска на реальном устройстве, убедитесь, что вы указали правильные <code>deviceName</code> и <code>version</code> для вашего устройства.</p>

<ol start="4">
    <li><strong>Установите приложение на устройство</strong>. Если вы используете эмулятор, убедитесь, что он запущен. Если вы используете реальное устройство, подключите его к компьютеру через USB и включите режим разработчика и отладку по USB.</li>
<li><strong>Запустите тесты</strong>. Выполнить тесты через Gradle, используя команду:
<pre><code>./gradlew clean test</code></pre>
Убедитесь, что вы находитесь в корневой директории проекта перед запуском этой команды.</li></ol>

<p>В src/test/resources/configs/driver  укажите соответствующие настройки, как показано ниже:</p>

<pre><code>
# Для эмулятора
deviceName=Pixel_3a_API_34_extension_level_7_arm64-v8a
version=14.0

# Для реального устройства (замените на свои значения)
deviceName=samsung SM-A225F
version=11.0


</code></pre>

<p><strong>Важно:</strong> перед запуском тестов убедитесь, что Appium Server запущен, и все пути и параметры устройства настроены правильно.</p>