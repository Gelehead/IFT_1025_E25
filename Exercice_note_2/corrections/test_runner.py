#!/usr/bin/env python3
import os
import subprocess
import sys
from pathlib import Path

def find_main_java_files(directory):
    """Find all Main.java files in the directory and subdirectories, excluding __MACOSX folders"""
    main_java_files = []
    
    for root, dirs, files in os.walk(directory):
        # Skip __MACOSX folders
        if '__MACOSX' in root:
            continue
            
        # Remove __MACOSX from dirs to prevent os.walk from entering it
        dirs[:] = [d for d in dirs if d != '__MACOSX']
        
        for file in files:
            if file == 'Main.java':
                main_java_files.append(os.path.join(root, file))
    
    return main_java_files

def replace_main_java(file_path):
    """Replace the content of Main.java with the test code"""
    new_content = """public class Main {
    public static void main(String[] args) {
        // Tests publics
        int passed_tests = 0;
        
        // vecteurs
        if ( Test.vec_dot() ) {
            passed_tests += 1;
        }
        if ( Test.vec_get() ) {
            passed_tests += 1;
        }
        if ( Test.vec_rep() ) {
            passed_tests += 1;
        }
        if ( Test.vec_set() ) {
            passed_tests += 1;
        }
        if ( Test.vec_getelement_oob() ) {
            passed_tests += 1;
        }
        
        // Matrice
        if (Test.mat_dot_bad_dim()) {
            passed_tests += 1;
        }
        if (Test.mat_setget()) {
            passed_tests += 1;
        }
        if (Test.mat_addscalaire()) {
            passed_tests += 1;
        }
        if (Test.mat_multscalaire()) {
            passed_tests += 1;
        }
        if (Test.mat_transpose()) {
            passed_tests += 1;
        }
        if (Test.mat_identite()) {
            passed_tests += 1;
        }
        if (Test.mat_getcell_oob()) {
            passed_tests += 1;
        }
        
        System.out.println(passed_tests);
    }
}"""
    
    try:
        with open(file_path, 'w', encoding='utf-8') as f:
            f.write(new_content)
        return True
    except Exception as e:
        print(f"Error writing to {file_path}: {e}")
        return False

def compile_and_run_java(directory):
    """Compile and run the Java files in the given directory"""
    try:
        # Change to the directory containing the Java files
        original_dir = os.getcwd()
        os.chdir(directory)
        
        # Find all .java files in the current directory
        java_files = [f for f in os.listdir('.') if f.endswith('.java')]
        
        if not java_files:
            print(f"No Java files found in {directory}")
            return False
        
        # Compile all Java files
        compile_cmd = ['javac'] + java_files
        compile_result = subprocess.run(compile_cmd, capture_output=True, text=True)
        
        if compile_result.returncode != 0:
            print(f"Compilation failed: {compile_result.stderr}")
            return False
        
        # Run the Main class
        run_result = subprocess.run(['java', 'Main'], capture_output=True, text=True)
        
        if run_result.returncode != 0:
            print(f"Runtime error: {run_result.stderr}")
            return False
        
        output = run_result.stdout.strip()
        print(f"Output: {output}")
        
        # Return the number of tests passed (should be a number)
        try:
            return int(output)
        except ValueError:
            # If output is not a number, still consider it successful but return the string
            return output
        
    except Exception as e:
        print(f"Error running Java in {directory}: {e}")
        return False
    finally:
        os.chdir(original_dir)

def main():
    # Get the current directory or use command line argument
    if len(sys.argv) > 1:
        base_directory = sys.argv[1]
    else:
        base_directory = os.getcwd()
    
    if not os.path.exists(base_directory):
        print(f"Directory {base_directory} does not exist")
        return
    
    print(f"Processing directory: {base_directory}")
    print("-" * 50)
    
    # Find all Main.java files
    main_java_files = find_main_java_files(base_directory)
    
    if not main_java_files:
        print("No Main.java files found")
        return
    
    # Keep track of successful and failed runs
    successful_runs = []
    failed_runs = []
    
    # Process each Main.java file
    for main_java_path in main_java_files:
        directory = os.path.dirname(main_java_path)
        folder_name = os.path.basename(directory)
        
        # Get the parent folder name (first folder we pass through from base_directory)
        relative_path = os.path.relpath(directory, base_directory)
        parent_folder = relative_path.split(os.sep)[0]
        
        print(f"\nProcessing folder: {folder_name}")
        print(f"Path: {directory}")
        
        # Replace Main.java content
        if replace_main_java(main_java_path):
            print("✓ Main.java replaced successfully")
            
            # Compile and run
            test_result = compile_and_run_java(directory)
            if test_result is not False:
                print("✓ Compilation and execution successful")
                # Store the parent folder name and test result for recap
                successful_runs.append((parent_folder, test_result))
            else:
                print("✗ Compilation or execution failed")
                # Store the parent folder name for failed runs
                failed_runs.append(parent_folder)
        else:
            print("✗ Failed to replace Main.java")
            # Store the parent folder name for failed runs
            failed_runs.append(parent_folder)
        
        print("-" * 30)
    
    # Print recap of successful runs
    if successful_runs:
        print("\n" + "=" * 50)
        print("RECAP - SUCCESSFUL RUNS:")
        print("=" * 50)
        for folder_name, tests_passed in successful_runs:
            print(f"{folder_name}: {tests_passed}/12")
    else:
        print("\nNo folders ran successfully.")
    
    # Print recap of failed runs
    if failed_runs:
        print("\n" + "=" * 50)
        print("RECAP - FAILED RUNS:")
        print("=" * 50)
        # Remove duplicates while preserving order
        seen = set()
        unique_failed = []
        for folder in failed_runs:
            if folder not in seen:
                unique_failed.append(folder)
                seen.add(folder)
        
        for folder_name in unique_failed:
            print(f"{folder_name}: FAILED")
    else:
        print("\nAll folders ran successfully!")

if __name__ == "__main__":
    main()