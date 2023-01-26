package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class GitHubAPI {
	public static void update() {
		try {
		// Replace with the local directory of your project
        File localPath = new File("C:\\Users\\Pedro\\git\\MultiSonarQubeProjects");
        
        // Initialize a new Git object with the local project directory
        Git git = Git.init().setDirectory(localPath).call();
        
        // Add all changes in the local project to the repository
        git.add().addFilepattern(".").call();
        
        // Commit the changes with a commit message
        git.commit().setMessage("Analysing new projects").call();
        
        // Replace with your GitHub repository URL
        String repoUrl = "https://github.com/UO276840/MultiSonarQubeProjects.git";
        
		git.remoteAdd().setName("origin").setUri(new URIish(repoUrl)).call();

		//Reading the access token to have access to the Repository 
        String filePath = "password";
        String token = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        	token = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Push the changes to the GitHub repository
        CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(token, "");
        git.push().setCredentialsProvider(credentialsProvider).call();
		} catch (GitAPIException | URISyntaxException e) {
            e.printStackTrace();
        }
	}
}
