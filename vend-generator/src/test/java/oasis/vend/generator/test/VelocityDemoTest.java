package oasis.vend.generator.test;

import oasis.vend.generator.model.Generator;
import oasis.vend.generator.util.VelocityInitializer;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Locale;

public class VelocityDemoTest {
    public static void main(String[] args) throws IOException {

        //1. Detect OS
        String os = System.getProperty("os.name").toLowerCase();
        String filePath;

        //2. set the file path based on the OS
        if (os.contains("win")) {
            filePath = Paths.get("D:", "velocity", "index.html").toString();
        } else if (os.contains("mac")) {
            filePath = Paths.get(System.getProperty("user.home"), "code", "index.html").toString();
        } else {
            // Linux or other OS (fallback)
            filePath = Paths.get(System.getProperty("user.home"), "velocity", "index.html").toString();
        }

        // initialize the template
        VelocityInitializer.initVelocity();

        //2.prepare the data model
        VelocityContext velocityContext= new VelocityContext();
        velocityContext.put("message","Let's do demo!");

        //2.1 prepare the data model by inject model
        Generator gen = new Generator(1L,"code auto generation");
        velocityContext.put("generator",gen);

        //3.get the template
        Template template= Velocity.getTemplate("vm/index.html.vm","UTF-8");

        //4.render the template
        FileWriter fileWriter  = new FileWriter(filePath);// export to file
        template.merge(velocityContext,fileWriter);
        fileWriter.close();



    }
}
