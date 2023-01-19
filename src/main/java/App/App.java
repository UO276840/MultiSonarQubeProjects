package App;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.net.URISyntaxException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws GitAPIException {
        // Replace with the local directory of your project
        File localPath = new File("C:\\Users\\Pedro\\git\\MultiSonarQubeProjects");
        
        // Initialize a new Git object with the local project directory
        Git git = Git.init().setDirectory(localPath).call();
        
        // Add all changes in the local project to the repository
        git.add().addFilepattern(".").call();
        
        // Commit the changes with a commit message
        git.commit().setMessage("Commit with GitHub API 3").call();
        
        // Replace with your GitHub repository URL
        String repoUrl = "https://github.com/UO276840/MultiSonarQubeProjects.git";
        
        // Replace with your GitHub credentials
        //String username = "your-username";
        //String password = "your-password";
        
        try {
			git.remoteAdd().setName("origin").setUri(new URIish(repoUrl)).call();
			System.out.println("Hola");
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        String filePath = "password";
//        String token = null;
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//        	token = br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String token= "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";
        // Push the changes to the GitHub repository
       // git.push();//.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password)).call();
        git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider(token, "")).call();
    }

}
