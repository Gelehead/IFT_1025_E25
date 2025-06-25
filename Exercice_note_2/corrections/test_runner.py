#!/usr/bin/env python3
import os
import subprocess
import sys
import time
import shutil
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

def create_or_replace_test_java(directory):
    """Create or replace Test.java with the test code"""
    test_content = """public class Test {
    // Tests Vecteurs
    public static boolean vec_rep() {
        double[] elements = {1, 2, 3, 4, 5};
        Vecteur v = new Vecteur(elements);

        return v.toString().equals("{1.0, 2.0, 3.0, 4.0, 5.0}");
    }

    public static boolean vec_dot() {
        double[] e1 = {1, 2};
        double[] e2 = {3, 4, 5};

        Vecteur v1 = new Vecteur(e1);
        Vecteur v2 = new Vecteur(e2);

        try {
            double result = v1.dotProduct(v2);
            return Double.isNaN(result);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean vec_set() {
        double[] e = {2, 4, 6, 8, 10};

        Vecteur v = new Vecteur(e);

        v.setElement(0, 7);

        return v.getElement(0) == 7;
    }

    public static boolean vec_get() {
        double[] e = {1, 3, 5, 7, 9};

        Vecteur v = new Vecteur(e);

        return v.getElement(2) == 5;
    }

    public static boolean vec_getelement_oob() {
        double[] e = {1, 2, 3};
        Vecteur v = new Vecteur(e);
        boolean failed = false;

        try {
            v.getElement(10); // Index hors limites
        } catch (ArrayIndexOutOfBoundsException e2) {
            failed = true;
        }

        return failed;
    }

    // Tests matrices
    public static boolean mat_dot_bad_dim() {
        Matrice A = new Matrice(2, 3);
        Matrice B = new Matrice(2, 2);

        return A.dotProduct(B) == null;
    }
    public static boolean mat_setget() {
        Matrice m = new Matrice(2, 2);
        m.setCell(0, 0, 1);
        m.setCell(0, 1, 2);
        m.setCell(1, 0, 3);
        m.setCell(1, 1, 4);

        return m.getCell(0, 0) == 1 &&
               m.getCell(0, 1) == 2 &&
               m.getCell(1, 0) == 3 &&
               m.getCell(1, 1) == 4;
    }

    // test additionner scalaire
    public static boolean mat_addscalaire() {
        Matrice m = new Matrice(2, 2);
        m.additionnerScalaire(5.0);

        for (int i = 0; i < m.getLignes(); i++) {
            for (int j = 0; j < m.getColonnes(); j++) {
                if (m.getCell(i, j) != 5.0) return false;
            }
        }
        return true;
    }

    // test multiplier scalaire
    public static boolean mat_multscalaire() {
        Matrice m = new Matrice(2, 2);
        m.setCell(0, 0, 1);
        m.setCell(0, 1, 2);
        m.setCell(1, 0, 3);
        m.setCell(1, 1, 4);

        m.multiplierScalaire(2.0);

        return m.getCell(0, 0) == 2 &&
               m.getCell(0, 1) == 4 &&
               m.getCell(1, 0) == 6 &&
               m.getCell(1, 1) == 8;
    }

    // test transposee
    public static boolean mat_transpose() {
        Matrice m = new Matrice(2, 3);
        m.setCell(0, 0, 1); m.setCell(0, 1, 2); m.setCell(0, 2, 3);
        m.setCell(1, 0, 4); m.setCell(1, 1, 5); m.setCell(1, 2, 6);

        Matrice t = m.transpose();

        return t != null &&
               t.getLignes() == 3 && t.getColonnes() == 2 &&
               t.getCell(0, 0) == 1 &&
               t.getCell(0, 1) == 4 &&
               t.getCell(1, 0) == 2 &&
               t.getCell(1, 1) == 5 &&
               t.getCell(2, 0) == 3 &&
               t.getCell(2, 1) == 6;
    }

    // test matrice identite
    public static boolean mat_identite() {
        Matrice m = Matrice.identite(3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if (m.getCell(i, j) != 1) return false;
                } else {
                    if (m.getCell(i, j) != 0) return false;
                }
            }
        }
        return true;
    }

    public static boolean mat_getcell_oob() {
        Matrice m = new Matrice(2, 2);
        boolean failed = false;

        try {
            m.getCell(10, 0); // Index hors limites
        } catch (ArrayIndexOutOfBoundsException e) {
            failed = true;
        }

        return failed;
    }

}"""
    
    test_file_path = os.path.join(directory, 'Test.java')
    try:
        with open(test_file_path, 'w', encoding='utf-8') as f:
            f.write(test_content)
        return True
    except Exception as e:
        print(f"Error writing Test.java to {directory}: {e}")
        return False

def compile_and_run_java(directory):
    """Compile and run the Java files in the given directory"""
    try:
        # Change to the directory containing the Java files
        original_dir = os.getcwd()
        os.chdir(directory)
        
        # Delete existing .class files
        class_files = [f for f in os.listdir('.') if f.endswith('.class')]
        for class_file in class_files:
            try:
                os.remove(class_file)
                print(f"Deleted existing class file: {class_file}")
            except Exception as e:
                print(f"Warning: Could not delete {class_file}: {e}")
        
        # Find all .java files in the current directory
        java_files = [f for f in os.listdir('.') if f.endswith('.java')]
        
        if not java_files:
            print(f"No Java files found in {directory}")
            return False, 0
        
        # Start timing
        start_time = time.time()
        
        # Compile all Java files
        compile_cmd = ['javac'] + java_files
        compile_result = subprocess.run(compile_cmd, capture_output=True, text=True)
        
        if compile_result.returncode != 0:
            print(f"Compilation failed: {compile_result.stderr}")
            return False, 0
        
        # Run the Main class
        run_result = subprocess.run(['java', 'Main'], capture_output=True, text=True)
        
        # End timing
        end_time = time.time()
        execution_time = end_time - start_time
        
        if run_result.returncode != 0:
            print(f"Runtime error: {run_result.stderr}")
            return False, 0
        
        output = run_result.stdout.strip()
        print(f"Output: {output}")
        print(f"Execution time: {execution_time:.3f}s")
        
        # Return the number of tests passed and execution time
        try:
            return int(output), execution_time
        except ValueError:
            # If output is not a number, still consider it successful but return the string
            return output, execution_time
        
    except Exception as e:
        print(f"Error running Java in {directory}: {e}")
        return False, 0
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
    
    # Keep track of successful and failed runs, and folders to delete
    successful_runs = []
    failed_runs = []
    folders_to_delete = set()  # Use set to avoid duplicates
    
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
            
            # Create or replace Test.java in the same directory
            if create_or_replace_test_java(directory):
                print("✓ Test.java created/replaced successfully")
            else:
                print("✗ Failed to create/replace Test.java")
                failed_runs.append(parent_folder)
                continue
            
            # Compile and run
            test_result, exec_time = compile_and_run_java(directory)
            if test_result is not False:
                print("✓ Compilation and execution successful")
                # Store the parent folder name, test result, and execution time for recap
                successful_runs.append((parent_folder, test_result, exec_time))
                
                # Mark the parent folder for deletion
                parent_folder_path = os.path.join(base_directory, parent_folder)
                folders_to_delete.add(parent_folder_path)
                
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
        
        # Sort by execution time (smallest to biggest)
        successful_runs.sort(key=lambda x: x[2])  # Sort by execution time (index 2)
        
        for folder_name, tests_passed, exec_time in successful_runs:
            print(f"{folder_name}: {tests_passed}/12 ({exec_time:.3f}s)")
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
    
    # Delete successful folders
    if folders_to_delete:
        print("\n" + "=" * 50)
        print("DELETING SUCCESSFUL FOLDERS:")
        print("=" * 50)
        
        deleted_count = 0
        for folder_path in folders_to_delete:
            folder_name = os.path.basename(folder_path)
            try:
                if os.path.exists(folder_path):
                    shutil.rmtree(folder_path)
                    print(f"✓ Deleted: {folder_name}")
                    deleted_count += 1
                else:
                    print(f"✗ Folder not found: {folder_name}")
            except Exception as e:
                print(f"✗ Failed to delete {folder_name}: {e}")
        
        print(f"\nDeleted {deleted_count} successful project folders.")

if __name__ == "__main__":
    main()