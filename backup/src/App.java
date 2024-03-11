
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        // запускаем метод резервного копирования текущей директории.
        myDirectoryBackup(new File("."));
    }

    /**
     * Метод создающий резервную копию каталога.
     * @param file - копируемый каталог.
     */
    static void myDirectoryBackup(File file) throws IOException {
        // путь корнвая дректория.
        Path rootpath = Paths.get("."); 
        // путь резервная копия.
        Path backupPath = Paths.get(".//backup"); 

        // создаем каталог (резервная копия) .
        // и запускаем метод копирования файлов/каталогов из текущей директории в резервную.
        copyDirectory(backupPath);
        copyDirecAndFile(file.listFiles(), rootpath, backupPath);
    }

    /**
     * Метод создающий копию каталогов/файлов из текущей директории в резервнцю.
     * @param files - массив копируемых каталогов/файлов.
     */
    static void copyDirecAndFile(File[] files, Path rootpath, Path backupPath) throws IOException {
        for (int i = 0; i < files.length; i++){
            // является ли фаил директорией.
            boolean isDirectory = files[i].isDirectory();
            // путь к резервным/скопированным файлам/папкам.
            Path backupNewPath = backupPath;
            // путь от крневой до копируемого файла/папки.
            Path relativizePath = rootpath.relativize(files[i].toPath()); 

            backupNewPath = Paths.get(String.format("%s//%s", backupPath.toString(), relativizePath.toString()));
            if (isDirectory) { copyDirectory(backupNewPath);}
            else { copyFile(relativizePath, backupNewPath);}
            // проверяем создались ли папки/файлы.
            if (Files.exists(backupNewPath)) { System.out.println(String.format("%s \"%s\" %s!", 
                ((isDirectory) ? "Директория" : "Файл"), backupNewPath.toString(),
                ((isDirectory) ? "создана" : "скопирован"))); }

            // не является каталогом резервного копирования
            boolean isNotBackupDirectory = !files[i].getName().equalsIgnoreCase(backupPath.getFileName().toString());
            // если директория имеет файлы запускаем еще один метод копирующий каталоги/файлы из следующей директории
            if (isDirectory && isNotBackupDirectory && files[i].listFiles().length > 0) { copyDirecAndFile(files[i].listFiles(), rootpath, backupPath);}
        }
    }

    /**
     * Метод создающий копию каталогов по указанному пути, в том случае если каталог еще не создан.
     * @param backupPath - путь резервной папки.
     */
    static void copyDirectory(Path backupPath) throws IOException {
        if (!Files.exists(backupPath)) { Files.createDirectory(backupPath);}
    }

    /**
     * Метод создающий копию файлов по указанному пути, если файл существует он заменяется.
     * @param relativizePath  - путь от крневой до копируемого файла.
     * @param backupPath - путь резервного файла.
     */
    static void copyFile(Path relativizePath, Path backupPath) throws IOException {
        Files.copy(relativizePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
    }
  
}
