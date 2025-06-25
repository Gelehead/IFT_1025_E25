@echo off
setlocal enabledelayedexpansion

:: Create the Main.java replacement file
> main_replacement.java (
    echo /*Auteur: ramzi Kouari
    echo  * Matricule: 20238839
    echo  * Date: 2025-01-06
    echo  * contient les fichiers des classes Matrice et Vecteur,leurs méthodes respectives et des test unitaires pour s'assurer de leurs bon fonctionnements
    echo */
    echo public class Main ^{
    echo     public static void main(String[] args) ^{
    echo         int passed_tests = 0;
    echo.
    echo         if ( Test.vec_dot() ) passed_tests++;
    echo         if ( Test.vec_get() ) passed_tests++;
    echo         if ( Test.vec_rep() ) passed_tests++;
    echo         if ( Test.vec_set() ) passed_tests++;
    echo         if ( Test.vec_getelement_oob() ) passed_tests++;
    echo.
    echo         if (Test.mat_dot_bad_dim()) passed_tests++;
    echo         if (Test.mat_setget()) passed_tests++;
    echo         if (Test.mat_addscalaire()) passed_tests++;
    echo         if (Test.mat_multscalaire()) passed_tests++;
    echo         if (Test.mat_transpose()) passed_tests++;
    echo         if (Test.mat_identite()) passed_tests++;
    echo         if (Test.mat_getcell_oob()) passed_tests++;
    echo.
    echo         System.out.println(passed_tests);
    echo     ^}
    echo ^}
)

:: Loop through folders
for /d %%F in (*) do (
    if /i not "%%F"=="__MACOSX" (
        echo === Processing %%F ===
        call :ProcessFolder "%%F"

        for /d %%S in ("%%F\*") do (
            if /i not "%%~nxS"=="__MACOSX" (
                echo === Processing subfolder %%S ===
                call :ProcessFolder "%%S"
            )
        )
    )
)

:: Clean up
del main_replacement.java
echo All done.
pause
exit /b

:ProcessFolder
set "target=%~1"
copy /Y main_replacement.java "%target%\Main.java" >nul

pushd "%target%"
javac *.java
if exist Main.class (
    echo Running in %target%:
    java Main
) else (
    echo Compilation failed in %target%
)
popd
exit /b
