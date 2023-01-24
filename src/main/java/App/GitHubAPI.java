package App;

import java.io.File;
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
        git.commit().setMessage("Commit with GitHub API 5").call();
        
        // Replace with your GitHub repository URL
        String repoUrl = "https://github.com/UO276840/MultiSonarQubeProjects.git";
        
        // Replace with your GitHub credentials
        //String username = "your-username";
        //String password = "your-password";
        
		git.remoteAdd().setName("origin").setUri(new URIish(repoUrl)).call();
		System.out.println("Hola");
        String filePath = "password";
        String token = "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";
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//        	token = br.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // Push the changes to the GitHub repository
       // git.push();//.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password)).call();
        //git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider("UO276840", token)).call();
        CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider("${token}", "");
        git.push().setCredentialsProvider(credentialsProvider).call();
		} catch (GitAPIException | URISyntaxException e) {
            e.printStackTrace();
        }
	}
}
