@echo off
:: Path to 7z executable, update if necessary
set sevenzip="C:\Program Files\7-Zip\7z.exe"

:: Directory containing zip files (you can change this)
setlocal enabledelayedexpansion
set zipdir=%cd%

:: Loop through each zip file
for %%F in (*.zip) do (
    echo Processing %%F...
    :: Create a folder with the same name as the zip file (without extension)
    set foldername=%%~nF
    mkdir "!foldername!"
    
    :: Extract contents into the created folder
    %sevenzip% x "%%F" -o"!foldername!" -y

    echo Done extracting %%F
)

echo All files have been extracted.
pause
