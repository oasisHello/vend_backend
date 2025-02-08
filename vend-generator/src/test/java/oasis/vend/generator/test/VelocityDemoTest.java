package oasis.vend.generator.test;

import oasis.vend.generator.util.VelocityInitializer;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.FileWriter;
import java.io.IOException;

public class VelocityDemoTest {
    public static void main(String[] args) throws IOException {
        // initialize the template
        VelocityInitializer.initVelocity();

        //2.prepare the data model
        VelocityContext velocityContext= new VelocityContext();
        velocityContext.put("message","demo!");

        //3.get the template
        Template template= Velocity.getTemplate("vm/index.html.vm","UTF-8");

        //4.render the template
        FileWriter fileWriter  = new FileWriter("D:\\velocity\\index.html");// export to file
        template.merge(velocityContext,fileWriter);
        fileWriter.close();



    }
}
