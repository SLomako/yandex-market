# Демо проект по автоматизации мобильного приложения [**Яндекс-Маркет**]

<p align="center">
<img title="Яндекс-Маркет" src=".github/logo/logo.png">
</p>

<h1>Настройка проекта</h1>

<h2>Предварительная проверка</h2>

<details>
<summary>Перед началом работы проверьте следующие компоненты:</summary>

<h3>Проверка установленных компонентов</h3>

<p>Откройте терминал (на macOS) или командную строку/PowerShell (на Windows) и выполните следующие команды:</p>

<pre><code>java -version       # Проверка Java
node -v             # Проверка Node.js
npm -v              # Проверка NPM
appium -v           # Проверка Appium
echo $ANDROID_HOME  # Проверка пути Android SDK (macOS)
echo $JAVA_HOME     # Проверка пути Java JDK (macOS)
echo %ANDROID_HOME% # Проверка пути Android SDK (Windows)
echo %JAVA_HOME%    # Проверка пути Java JDK (Windows)
adb version         # Проверка Android Debug Bridge
</code></pre>

<h3>Проверка переменных среды</h3>

<details>
<summary>Убедитесь, что переменные среды настроены правильно:</summary>

<p>Для macOS:</p>

<pre><code>echo $ANDROID_HOME
echo $PATH
echo $JAVA_HOME
</code></pre>

<p>Для Windows введите в командной строке:</p>

<pre><code>echo %ANDROID_HOME%
echo %PATH%
echo %JAVA_HOME%
</code></pre>
</details>

<h3>Установка необходимого ПО и настройка путей</h3>

<details>
<summary>Если некоторые компоненты не установлены, следуйте этим инструкциям:</summary>

<ol>
<li><strong>Java Development Kit (JDK):</strong>
<a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Скачайте и установите JDK</a></li>
<li><strong>Node.js и NPM:</strong>
<a href="https://nodejs.org/en/">Скачайте и установите Node.js (включает NPM)</a></li>
<li><strong>Android Studio:</strong>
<a href="https://developer.android.com/studio">Скачайте и установите Android Studio</a></li>
<li><strong>Appium:</strong>
<pre><code>npm install -g appium</code></pre></li>
<li>Настройте переменные среды по вышеуказанным инструкциям.</li>
</ol>
</details>
<summary>Настройка переменных среды после установки</summary>
<p>После установки всех компонентов, убедитесь, что переменные среды настроены правильно.</p>

<h4>Для macOS:</h4>
Добавьте следующие строки в ваш <code>.zshrc</code> или <code>.bash_profile</code>, а затем перезапустите терминал:
<pre><code>export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/emulator
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
export PATH=$PATH:$ANDROID_HOME/platform-tools
export JAVA_HOME=`/usr/libexec/java_home -v 17`</code></pre>

<h4>Для Windows:</h4>
Добавьте переменные среды через "Системные настройки" > "Переменные среды":
<pre><code>setx ANDROID_HOME "C:\Users\YOUR_USERNAME\AppData\Local\Android\Sdk"
setx PATH "%PATH%;%ANDROID_HOME%\emulator;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools"
setx JAVA_HOME "C:\Path\To\Your\JDK17"</code></pre>
</details>

<h2>Запуск проекта</h2>

<p>(Инструкции по запуску проекта будут добавлены позже)</p>