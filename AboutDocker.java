public class AboutDocker {
    /**
     * Simple Java program illustrating how to call Docker CLI from
     * Java and print some information.  It uses ProcessBuilder to
     * execute the command and capture its output.  You can extend it
     * further to parse JSON output from `docker inspect` etc.
     */
    public static void main(String[] args) {
        // Provide general information about Docker without executing it
        System.out.println("About Docker:");
        System.out.println("- Docker is a platform for developing, shipping, and running applications inside containers.");
        System.out.println("- Containers are lightweight, portable units that package code and dependencies together.");
        System.out.println("- Docker uses a layered filesystem and image concept; images are read-only templates for containers.");
        System.out.println("- The Docker Engine runs on the host and manages images, containers, networks, and storage.");
        System.out.println("- Developers typically write a Dockerfile to define an image and use `docker build`, `docker run`, etc.");
        System.out.println("- Docker simplifies deployment by ensuring applications run the same in different environments.");
        System.out.println("- Docker Compose allows defining and running multi-container applications using a single YAML configuration file.");
        System.out.println();
        System.out.println("This Java program merely prints general information about Docker and does not invoke the Docker CLI.");
    }

    /**
     * Executes the specified command and prints its output (stdout and stderr).
     */
    private static void runCommand(String[] command) {
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);
        try {
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("(exit code:" + exitCode + ")");
        } catch (Exception e) {
            System.err.println("Failed to run command: " + String.join(" ", command));
            e.printStackTrace();
        }
    }
}
