package App;

import java.io.*;
import java.util.List;

public class FileCreator {
    public static void createFile(List<String> URLS) {
    	File file = new File("Jenkinsfile");
        try (FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);){

            bw.write("pipeline {\n" +
                    "    agent any\n" +
                    "    stages {\n");
            
            for (int i = 0; i < URLS.size(); i++) {
                bw.write("        stage('Clone Repository " + (i+1) + "') {\n" +
                        "            steps {\n" +
                        "                git url: '"+URLS.get(i)+"', branch: 'master'\n" +
                        "            }\n" +
                        "        }\n" +
                        "        stage('SonarQube Analysis " + (i+1) + "') {\n" +
                        "            steps {\n" +
                        "                withSonarQubeEnv('sonarserver') {\n" +
                        "                    bat 'mvn clean install sonar:sonar'\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }\n");
            }

            bw.write("    }\n" +
                    "}");
           // bw.close();
            System.out.println("File created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
