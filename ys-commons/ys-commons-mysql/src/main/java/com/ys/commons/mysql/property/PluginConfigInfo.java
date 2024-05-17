package com.ys.commons.mysql.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * sql插件配置提示类
 */
@Data
@ConfigurationProperties(prefix = "yunshu.plugin")
public class PluginConfigInfo {
    private Sql sql;

    private Page page;

    @Data
    private static class Sql{
        private boolean enable;
    }

    @Data
    private static class Page{
        private boolean enable;
    }
}
