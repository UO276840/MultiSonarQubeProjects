package App;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.net.URISyntaxException;

public class App {

	public static void main(String[] args) throws GitAPIException {
        // Replace with the local directory of your project
        File localPath = new File("C:\\Users\\Pedro\\git\\MultiSonarQubeProjects");
        
        // Initialize a new Git object with the local project directory
        Git git = Git.init().setDirectory(localPath).call();
        
        // Add all changes in the local project to the repository
        git.add().addFilepattern(".").call();
        
        // Commit the changes with a commit message
        git.commit().setMessage("Commit with GitHub API").call();
        
        // Replace with your GitHub repository URL
        String repoUrl = "https://github.com/UO276840/MultiSonarQubeProjects.git";
        
        // Replace with your GitHub credentials
        //String username = "your-username";
        //String password = "your-password";
        
        try {
			git.remoteAdd().setName("origin").setUri(new URIish(repoUrl)).call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Push the changes to the GitHub repository
        git.push();//.setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password)).call();
    }

}
