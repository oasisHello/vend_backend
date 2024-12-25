package oasis.vend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class VendApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(VendApplication.class, args);
        System.out.println(
      		  "  ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  \r\n" 
			+ "❘ oooo                  oooo  oooo                                                oooo                                                           .                                                o8o            .o.   ❘\r\n"
      		+ "❘ `888                  `888  `888                                                `888                                                         .o8                                                ` '            888   ❘\r\n"
      		+ "❘  888 .oo.    .ooooo.   888   888   .ooooo.           oooo oooo    ooo  .ooooo.   888   .ooooo.   .ooooo.  ooo. .oo.  .oo.    .ooooo.       .o888oo  .ooooo.        .ooooo.   .oooo.    .oooo.o oooo   .oooo.o  888   ❘\r\n"
      		+ "❘  888P  Y88b d88' `88b  888   888  d88' `88b           `88. `88.  .8'  d88' `88b  888  d88' ` Y8 d88' `88b `888P Y88bP Y88b  d88' `88b        888   d88' `88b      d88' `88b `P  )88b  d88(  '8 `888  d88(  '8  Y8P   ❘\r\n"
      		+ "❘  888   888  888ooo888  888   888  888   888            `88..]88..8'   888ooo888  888  888       888   888  888   888   888  888ooo888        888   888   888      888   888  .oP 888   `Y88b.   888  `Y88b.    `8'   ❘\r\n"
      		+ "❘  888   888  888    .o  888   888  888   888 .o.         `888'`888'    888    .o  888  888   .o8 888   888  888   888   888  888    .o        888 . 888   888      888   888 d8(  888  o.  )88b  888  o.  )88b  .o.   ❘\r\n"
      		+ "❘ o888o o888o `Y8bod8P' o888o o888o `Y8bod8P' Y8P          `8'  `8'     `Y8bod8P' o888o `Y8bod8P' `Y8bod8P' o888o o888o o888o `Y8bod8P'          888 `Y8bod8P'      `Y8bod8P' `Y888oo8o 8oo888P' o888o 8oo888P'  Y8P   ❘\r\n"
            + "  ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  \r\n");                         
                                          
    }
}
