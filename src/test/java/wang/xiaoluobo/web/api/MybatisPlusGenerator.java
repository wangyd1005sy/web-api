package wang.xiaoluobo.web.api;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Mybatis plus generator
 *
 * @see <a href="代码生成器配置">https://baomidou.com/pages/981406/</a >
 */
public class MybatisPlusGenerator {

    private static String jdbcUrl = "jdbc:mysql://localhost:3306/web-api?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai&allowMultiQueries=true&autoReconnect=true&autoReconnectForPools=true";
    private static String userName = "root";
    private static String password = "yXOswG1CEvmlKcSp";

    private static String author = "mybatis plus generator";
    private static String userDir = System.getProperty("user.dir");
    private static String parentPackage = "wang.xiaoluobo.web.api";

    private static String projectPath = userDir;
    private static String generatorJavaCodePath = projectPath + "/src/main/java";
    private static String generatorXMLMapperPath = projectPath + "/src/main/resources/mapper";
    private static List<String> tableList = new ArrayList<>();

    static {
//        tableList.add("t_province");
        tableList.add("t_system_user");
        tableList.add("t_system_resource");
        tableList.add("t_system_role");
        tableList.add("t_system_role_resource");
        tableList.add("t_system_user_role");
        tableList.add("t_system_user_data_role");
        tableList.add("t_system_data_type");
    }

    public static void main(String[] args) {
        if (tableList.size() == 0) {
            System.out.println("未添加需要映射的表名");
            return;
        }
        FastAutoGenerator.create(jdbcUrl, userName, password)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir()
                            .dateType(DateType.ONLY_DATE)
                            .outputDir(generatorJavaCodePath); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackage) // 设置父包名
                            .controller("controller")
                            .entity("model")
                            .mapper("mapper")
                            .service("service")
                            .serviceImpl("service.impl")
                            .moduleName("") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, generatorXMLMapperPath)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableList).addTablePrefix("t_") // 设置需要生成的表名
                            .entityBuilder()
                            .enableFileOverride()
                            .convertFileName(entityName -> entityName + "Entity")
                            .enableLombok();
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}