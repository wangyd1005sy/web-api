package wang.xiaoluobo.web.api;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
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
    //    private static String parentPackage = "wang.xiaoluobo.system.framework";
    private static String parentPackage = "wang.xiaoluobo.web.api";

    private static String projectPath = userDir;
    private static String generatorJavaCodePath = projectPath + "/src/main/java";
    private static String generatorXMLMapperPath = projectPath + "/src/main/resources/mapper";
    private static List<String> tableList = new ArrayList<>();

    static {
        tableList.add("t_test_data_config");

//        tableList.add("gen_table");
//        tableList.add("gen_table_column");
//        tableList.add("sys_config");
//        tableList.add("sys_dept");
//        tableList.add("sys_dict_data");
//        tableList.add("sys_dict_type");
//        tableList.add("sys_job");
//        tableList.add("sys_job_log");
//        tableList.add("sys_logininfor");
//        tableList.add("sys_menu");
//        tableList.add("sys_notice");
//        tableList.add("sys_oper_log");
//        tableList.add("sys_post");
//        tableList.add("sys_role");
//        tableList.add("sys_role_dept");
//        tableList.add("sys_role_menu");
//        tableList.add("sys_user");
//        tableList.add("sys_user_post");
//        tableList.add("sys_user_role");
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
                            .entity("domain")
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
                            .enableLombok()
                            .serviceBuilder().enableFileOverride()
                            .mapperBuilder().enableFileOverride();
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER);
                })
                .execute();
    }
}