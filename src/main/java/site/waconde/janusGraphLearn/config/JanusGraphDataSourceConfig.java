package site.waconde.janusGraphLearn.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyGraph;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author side.wang
 * @description
 * @date 2020-09-27
 */
@Slf4j
@Configuration
public class JanusGraphDataSourceConfig {
    @Value("${janusGraph.remote.configFilePath:conf/remote-graph.properties}")
    private String remoteConfigFile;

    @Bean("janusGraphRemoteSource")
    public GraphTraversalSource configGraphTraversalSource() {
        GraphTraversalSource g = null;
        try {
            g = AnonymousTraversalSource.traversal().withRemote(remoteConfigFile);
        } catch (Exception e) {
            log.error("janusGraph 的配置出现问题，请检查：", e);
        }
        return g;
    }
}
