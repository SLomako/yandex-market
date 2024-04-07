# Демо проект по автоматизации мобильного приложения [**Яндекс-Маркет**]

<p align="center">
<img title="Яндекс-Маркет" src=".github/logo/logo.png">
</p>

<h2>Настройка среды</h2>

<h3>Предварительная проверка</h3>
<details>
<summary>Кликните здесь, чтобы проверить установленные компоненты и настроенные пути</summary>

Откройте терминал (на macOS) или командную строку/PowerShell (на Windows) и выполните следующие команды:

<ul>
<li>Проверка версии Java:
<pre><code>java -version</code></pre>
</li>

<li>Проверка версии Node.js:
<pre><code>node -v</code></pre>
</li>

<li>Проверка версии NPM:
<pre><code>npm -v</code></pre>
</li>

<li>Проверка версии Appium:
<pre><code>appium -v</code></pre>
</li>

<li>Проверка путей для Android SDK (macOS):
<pre><code>echo $ANDROID_HOME</code></pre>
<pre><code>echo $PATH</code></pre>
</li>

<li>Проверка путей для Android SDK (Windows):
<pre><code>echo %ANDROID_HOME%</code></pre>
<pre><code>echo %PATH%</code></pre>
</li>

<li>Проверка доступности Android Debug Bridge (ADB):
<pre><code>adb version</code></pre>
</li>

<li>Проверка установленной JDK:
<pre><code>echo $JAVA_HOME</code></pre> (macOS)
<pre><code>echo %JAVA_HOME%</code></pre> (Windows)
</li>
</ul>

</details>

<h3>Установка необходимого программного обеспечения</h3>
<p>Если вышеупомянутые проверки не прошли успешно, установите необходимые компоненты, следуя ссылкам:</p>

<ol>
<li><strong>Java Development Kit (JDK):</strong>
<a href="https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html">Скачать и установить JDK 17 или выше</a>
</li>

<li><strong>Node.js и NPM:</strong>
<a href="https://nodejs.org/en/">Скачать и установить Node.js (включает NPM)</a>
</li>

<li><strong>Appium:</strong>
<pre><code>npm install -g appium</code></pre>
</li>

<li><strong>Android Studio:</strong>
<a href="https://developer.android.com/studio">Скачать и установить Android Studio (включает Android SDK и ADB)</a>
</li>
</ol>

<h3>Настройка переменных среды</h3>
<details>
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