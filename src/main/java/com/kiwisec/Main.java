package main.java.com.kiwisec;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.io.File;

/**
 * Created by lpcdm on 2017/9/14.
 */

public class Main {
    public static void main(String[] args) {
        try {
            Options options = new Options();
            options.addOption("a", false, "add file job");
            options.addOption("d", false, "delete file job");

            options.addOption("f", true, "input apk path");
            options.addOption("n", true, "File path to operate");

            options.addOption("p", true, "in zip path");

            options.addOption("r", false, "remove all other arch");
            options.addOption("e", false, "remove all other arch");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            String apk_path = cmd.getOptionValue("f");
            String file_operate = cmd.getOptionValue("n");
            String in_zip_path = cmd.getOptionValue("p");

            if (cmd.hasOption("f"))
            {
                File testFile = new File(apk_path);
                if(!testFile.exists())
                {
                    HelpFormatter formatter = new HelpFormatter();
                    System.out.println("eg: need -f file exitst");
                    formatter.printHelp("java -jar zip.jar ",options);
                    return;
                }
            }
            if (cmd.hasOption("r") && cmd.hasOption("f")) {
                ZipUtils.deleteArchDir(apk_path);
                return;
            }
            if (cmd.hasOption("e") && cmd.hasOption("f")) {
                ZipUtils.deleteArchDir_e(apk_path);
                return;
            }

            if ( apk_path == null ) {
                HelpFormatter formatter = new HelpFormatter();
                System.out.println("eg: java -jar zip.jar -f xxx.apk -a -n xxx/xxx/xxx.db -p assets/xxx2.db");
                System.out.println("eg: java -jar zip.jar -f xxx.apk -a -n xxx/xxx/xxx.db ");
                System.out.println("eg: java -jar zip.jar -f xxx.apk -d -p assets/xxx2.db");
                formatter.printHelp("java -jar zip.jar ",options);
                return;
            }

            if (cmd.hasOption("d") && in_zip_path == null)
            {
                HelpFormatter formatter = new HelpFormatter();
                System.out.println("eg: java -jar zip.jar -f xxx.apk -d -p assets/xxx2.db");
                formatter.printHelp("java -jar zip.jar ",options);
                return;
            }

            if (cmd.hasOption("a") && file_operate == null) {//
                HelpFormatter formatter = new HelpFormatter();
                System.out.println("eg: java -jar zip.jar -f xxx.apk -a -n xxx/xxx/xxx.db -p assets/xxx2.db");
                System.out.println("eg: java -jar zip.jar -f xxx.apk -a -n xxx/xxx/xxx.db ");
                formatter.printHelp("java -jar zip.jar ",options);
                return;
            }
            if (cmd.hasOption("a")){
                File testFile = new File(file_operate);
                if(!testFile.exists())
                {
                    HelpFormatter formatter = new HelpFormatter();
                    System.out.println("eg: java -jar zip.jar -f xxx.apk -a -n xxx/xxx/xxx.db -p assets/xxx2.db");
                    System.out.println("eg: java -jar zip.jar -f xxx.apk -a -n xxx/xxx/xxx.db ");
                    formatter.printHelp("java -jar zip.jar ",options);
                    return;
                }
                else{
                    if ( in_zip_path == null || in_zip_path.equals("."))
                        in_zip_path = testFile.getName();
                }
            }

            System.out.println("apk_path            ==> " + apk_path);
            System.out.println("file_operate        ==> " + file_operate);
            System.out.println("in_zip_path         ==> " + in_zip_path);
            if (cmd.hasOption("d")) {
                System.out.println("delete file         ==> " + in_zip_path);
                ZipUtils.deleteFile(apk_path, in_zip_path);
            }
            if (cmd.hasOption("a")) {
            System.out.println("add file            ==> " + in_zip_path);
                ZipUtils.addFile(apk_path, in_zip_path, file_operate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
