import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * mybatis-plus 代码生成器
 * @autor kevin.dai
 * @Date 2018/1/5
 */
public class GeneratorCode {


    private  final  String dbUrl = "jdbc:mysql://localhost:3306/ams";

    private void generateByTables(String packageName,String... tableNames){
        AutoGenerator autoGenerator =  new AutoGenerator();
        GlobalConfig config = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //配置数据源
        dataSourceConfig.setDbType(DbType.MYSQL)
                        .setUrl(dbUrl)
                        .setUsername("root")
                        .setPassword("123456")
                        .setDriverName("com.mysql.jdbc.Driver");
        //配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                      .setEntityLombokModel(false)
                      .setDbColumnUnderline(true)
                      .setNaming(NamingStrategy.underline_to_camel)
                      .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组

        config.setActiveRecord(true)
              .setOutputDir(System.getProperty("user.dir")+"/ams/src/main/java/")
              .setAuthor("kevin.dai")
              .setEnableCache(false)
              .setBaseResultMap(true)
              .setBaseColumnList(true)
              .setFileOverride(true);

        autoGenerator.setGlobalConfig(config)
                     .setDataSource(dataSourceConfig)
                     .setStrategy(strategyConfig)
                     .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setMapper("dao")
                     );

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // 自定义 xxList.jsp 生成
//        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
//        focList.add(new FileOutConfig("/template/list.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return "D://my_" + tableInfo.getEntityName() + ".jsp";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        autoGenerator.setCfg(cfg);




        // 调整 xml 生成目录演示
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return System.getProperty("user.dir")+"/ams/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        autoGenerator.setCfg(cfg);



        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        autoGenerator.setTemplate(tc);


        autoGenerator.execute();





    }




    public static void main(String[] args) {
        String packageName = "com.peacebird.ams";
        GeneratorCode gc = new GeneratorCode();
        gc.generateByTables(packageName,"project");
    }
}
