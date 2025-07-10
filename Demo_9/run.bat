@echo off

if "%1"=="" (
    echo use the runner as 
    echo run.bat [MVC1^|MVC2^|MVC3^|MVC4]
    exit /b 1
)

set SELECTED_FOLDER=%1

if not exist %SELECTED_FOLDER% (
    echo no such directory as %SELECTED_FOLDER%
    exit /b 1
)

if not exist %SELECTED_FOLDER%\out mkdir "%SELECTED_FOLDER%\out"

set JAVAFX_PATH=C:\javafx-sdk-24.0.1\lib

echo Compiling %SELECTED_FOLDER%

javac --module-path %JAVAFX_PATH% --add-modules javafx.controls,javafx.fxml -d "%SELECTED_FOLDER%\out2" "%SELECTED_FOLDER%\*.java"
java --module-path %JAVAFX_PATH% --add-modules javafx.controls,javafx.fxml -cp "%SELECTED_FOLDER%\out2" TryVueGUI
