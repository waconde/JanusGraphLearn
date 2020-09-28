package site.waconde.janusGraphLearn;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
class JanusGraphLearnApplicationTests extends AbstractJUnit4SpringContextTests {

	@Test
	void contextLoads() {
		GraphTraversalSource g = (GraphTraversalSource)
				Objects.requireNonNull(applicationContext).getBean("janusGraphRemoteSource");
		GraphTraversal<Vertex, Object> values = g.V().values();
		Set<Object> objects = values.toSet();
		Object herculesAge = g.V().has("name", "hercules").values("age").next();
		System.out.println("Hercules is " + herculesAge + " years old.");
	}

}
