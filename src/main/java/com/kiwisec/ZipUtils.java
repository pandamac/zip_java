package main.java.com.kiwisec;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lpcdm on 2017/9/14.
 */

public class ZipUtils {
    public static void deleteArchDir(String zipFilePath) throws Exception {
        String[] ArchList = {"lib/arm64-v8a/", "lib/x86_64/", "lib/mips64/", "lib/mips/"};
        ArrayList<String> removeList = new ArrayList<String>();
        ZipFile zipFile = new ZipFile(zipFilePath);
        zipFile.setFileNameCharset("UTF-8");
        List<FileHeader> list = zipFile.getFileHeaders();
        for (int i = 0; i < list.size(); i++) {
            String dname = list.get(i).getFileName();
            for (int j = 0; j < ArchList.length; j++) {
                String archName = ArchList[j];
                if (dname.length() > archName.length()) {
                    String subPath = dname.substring(0, archName.length());
                    if (subPath.equals(archName)) {
                        removeList.add(dname);
//                        System.out.println("dname ==> " + dname);
//                        System.out.println("subPath ==> " + subPath);
//                        System.out.println("archName ==> " + archName);
                    }
                }
            }
        }
        for (int i = 0; i < removeList.size(); i++) {
            String dname = removeList.get(i);
            System.out.println("dname ==> " + dname);
            zipFile.removeFile(dname);
        }
    }

    public static void deleteArchDir_e(String zipFilePath) throws Exception {
        String[] ArchList = {"lib/x86_64/", "lib/mips64/", "lib/mips/"};
        ArrayList<String> removeList = new ArrayList<String>();
        ZipFile zipFile = new ZipFile(zipFilePath);
        zipFile.setFileNameCharset("UTF-8");
        List<FileHeader> list = zipFile.getFileHeaders();
        for (int i = 0; i < list.size(); i++) {
            String dname = list.get(i).getFileName();
            for (int j = 0; j < ArchList.length; j++) {
                String archName = ArchList[j];
                if (dname.length() > archName.length()) {
                    String subPath = dname.substring(0, archName.length());
                    if (subPath.equals(archName)) {
                        removeList.add(dname);
//                        System.out.println("dname ==> " + dname);
//                        System.out.println("subPath ==> " + subPath);
//                        System.out.println("archName ==> " + archName);
                    }
                }
            }
        }
        for (int i = 0; i < removeList.size(); i++) {
            String dname = removeList.get(i);
            System.out.println("dname ==> " + dname);
            zipFile.removeFile(dname);
        }
    }

    public static void deleteFile(String zipFilePath, String file_operate) throws Exception {
        ZipFile zipFile = new ZipFile(zipFilePath);
        zipFile.setFileNameCharset("UTF-8");
        zipFile.removeFile(file_operate);
//        Path path = Paths.get(zipFilePath);
//        ZipFileManager zipFileManager = new ZipFileManager(path);
//        zipFileManager.removeFile(Paths.get(fileName));
//        Map<String, String> zip_properties = new HashMap<>();
//        zip_properties.put("create", "false");
//
//        System.out.println(System.getProperty("os.name"));
//        String urlHead = "jar:file:";
//        if (System.getProperty("os.name").contains("Windows") && zipFilePath.substring(1,2).equals(":")) {
//            urlHead = "jar:file:///";
//        }
//        URI zip_disk = URI.create(urlHead + zipFilePath);
//
//        try (FileSystem zipfs = FileSystems.newFileSystem(zip_disk, zip_properties)) {
//            Path pathInZipfile = zipfs.getPath(fileName);
//            Files.deleteIfExists(pathInZipfile);
//        }
    }

    //String zipFilePath, String pathName, String fileName
    public static void addFile(String zipFilePath, String in_zip_path, String file_operate) throws Exception {
        ZipFile zipFile = new ZipFile(zipFilePath);
        ArrayList filesToAdd = new ArrayList();
        File new_file = new File(file_operate);

//        String add_file_real_name =
//        Map<File, String> m_map = new HashMap<File,String>();
//        m_map.put(new_file,add_file_real_name);
//        filesToAdd.add(m_map);//by panda
        filesToAdd.add(new_file);

        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
//        System.out.println(pathName);
        if (in_zip_path != null || in_zip_path != "") {
//            parameters.setRootFolderInZip(in_zip_path);
            parameters.rootFolderInZip = in_zip_path;//by panda
        }
        zipFile.addFiles(filesToAdd, parameters);
        //zipFile.addFiles(filesToAdd, parameters);
//        Path path = Paths.get(zipFilePath);
//        ZipFileManager zipFileManager = new ZipFileManager(path);
//        zipFileManager.addFile(Paths.get(fileName));
//        Map<String, String> zip_properties = new HashMap<>();
//        zip_properties.put("create", "false");
//
//        System.out.println(System.getProperty("os.name"));
//        String urlHead = "jar:file:";
//        if (System.getProperty("os.name").contains("Windows") && zipFilePath.substring(1,2).equals(":")) {
//            urlHead = "jar:file:///";
//        }
//        URI zip_disk = URI.create(urlHead + zipFilePath);
//        Path src = Paths.get(fileName);
//
//        try (FileSystem zipfs = FileSystems.newFileSystem(zip_disk, zip_properties)) {
//            Path pathInZipfile = zipfs.getPath(path);
//            Files.move(src, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
//        }
    }


}
